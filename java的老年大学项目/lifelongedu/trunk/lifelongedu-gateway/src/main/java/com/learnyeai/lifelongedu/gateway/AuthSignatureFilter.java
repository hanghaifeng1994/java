package com.learnyeai.lifelongedu.gateway;

import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.lifelongedu.gateway.client.AuthLoginClient;
import com.learnyeai.lifelongedu.gateway.util.*;
import com.learnyeai.lifelongedu.gateway.vo.TokenCheckVo;
import com.learnyeai.tools.common.DateHelper;
import com.learnyeai.tools.common.JsonMapper;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by zpz on 2018/8/14.
 */
@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered {
    @Autowired
    private LearnAiGateWayProperties gateWayProperties = new LearnAiGateWayProperties();
    @Autowired
    private AuthLoginClient authLoginClient;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${AUTH-SERVICE}")
    private String authService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedisUtil redisUtil = null;//RedisUtilFactory.getUtil(GateWayUtils.CACHENAME_TOKEN);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain gatewayFilterChain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String path = request.getURI().getPath();
        // 不是接口，直接跳过
        if(!path.endsWith(".do")){
            return gatewayFilterChain.filter(exchange);
        }

        if(path.indexOf("/test/") > -1){
            return gatewayFilterChain.filter(exchange);
        }

        String headAuthKey = "authToken";

        if(null == redisUtil){
            redisUtil = RedisUtilFactory.getUtil(GateWayUtils.CACHENAME_TOKEN);
        }

        // 匿名登录，不做token校验
        if(path.endsWith("/base/login/anonLogin.do")){ // 匿名登录，添加token
            String ss = genJwt(null);
            // 添加token 到head中
            response.getHeaders().add(headAuthKey, ss);
            TokenCheckVo vo = new TokenCheckVo();
            vo.setCreateTime(Calendar.getInstance().getTime());
            redisUtil.set(ss, vo, gateWayProperties.getTimeOut());
            return gatewayFilterChain.filter(exchange);
        }

        // 登录后，需要调用刷新token接口换取token
        boolean isLoginUrl = false;
        if(path.indexOf("/base/login/") > -1 && gateWayProperties.getLoginurls()!= null){
            isLoginUrl = gateWayProperties.getLoginurls().stream().anyMatch(p->{
                if(path.endsWith(p))
                    return true;
                return false;
            });
        }

        // 其它都做token校验

        // 获取token、缓存中的数据
        StatelessLogined logined = null;
        TokenCheckVo checkVo = null;
        String token = request.getHeaders().getFirst(headAuthKey);
        if(token != null) {
            request = request.mutate().headers((httpHeaders) -> {
                httpHeaders.remove(headAuthKey);
            }).build();
            exchange = exchange.mutate().request(request).build();
        }

        try {
            if(token == null && gateWayProperties.isDebugAbled()){
                token = request.getQueryParams().getFirst(headAuthKey);
            }
            if (token == null || token.isEmpty()) {
                throw new RuntimeException("不存在token");
            }

            logined = CryptoUtil.parseJwt(token, gateWayProperties.getJwtSecretKey());

            // 缓存中做校验
            if(!isLoginUrl) { // 不是登录url才做校验
                checkVo = redisUtil.get(token);
                if (null == checkVo) {// 缓存中不存在
                    throw new RuntimeException("缓存中不存在token");
                }

                // token、缓存中的用户信息是否一致
                if (StringUtils.isNotBlank(logined.getAppId())
                        || StringUtils.isNotBlank(checkVo.getAccount())
                        ) {
                    String ss = logined.getAppId() == null ? "" : logined.getAppId();
                    if (!ss.equals(checkVo.getAccount())) {
                        throw new RuntimeException("token、缓存中的用户信息不一致");
                    }
                }

                // 查看是否过期
                if(checkVo.getAuthVisitTime() != null){
                    if(checkVo.getAuthVisitTime().getTime() + gateWayProperties.getTimeOut()
                            < Calendar.getInstance().getTimeInMillis()){
                        redisUtil.remove(token);
                        throw new RuntimeException("登录超时");
                    }
                }
            }
        }catch (Exception e){
//            Publisher<? extends DataBuffer> data = new Pu;
//            response.writeWith(data);
            logger.error(e.getMessage());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // 登录
        if(isLoginUrl){
            return gatewayFilterChain.filter(exchange);
        }

        String account = null;
        if(checkVo != null)
            account =checkVo.getAccount();

        // 报文头添加用户信息
        if(null != account) {
            request = request.mutate().header("__account_id", account).build();
            exchange = exchange.mutate().request(request).build();
        }
        // common，
        if(path.indexOf("/common/") > -1) {
            if(account == null) { // 没有用户信息，不要调用auth服务
                return gatewayFilterChain.filter(exchange);
            }else if(checkVo.getAuthVisitTime() == null){
                return gatewayFilterChain.filter(exchange);
            }else { // 有用户信息，不要频繁调用校验服务
                if(DateHelper.getDateMargin(checkVo.getAuthVisitTime().getTime(), Calendar.getInstance().getTimeInMillis(), Calendar.MINUTE) < 2){

                }else {
                    return gatewayFilterChain.filter(exchange);
                }
            }
        }

        // 非common请求，帐号必须存在
        try{
            if(null == account){
                throw new RuntimeException("没有登录");
            }
            // 调用auth服务
            if(auth(path, checkVo, token)){
                return gatewayFilterChain.filter(exchange);
            }

        }catch (Exception e){
            logger.error("{} 鉴权失败 {}", account, e.getMessage());
        }

        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    // 鉴权，重新登录后，再校验
    private boolean auth(String path, TokenCheckVo checkVo, String token){
        int checkStatus = 3;
        if(checkVo.getAuthVisitTime() != null) {
            checkStatus = check(path, checkVo, token);
        }
        // 需要登录auth
        if(checkStatus == 3 && gateWayProperties.isDebugAbled()){
            if(login(checkVo)){ // 如果成功，再check一次
                checkStatus = check(path, checkVo, token);
            }else {
            }
        }
        if(checkStatus == 1){
            return true;
        }

        return false;
    }

    /**
     * 检查权限，
     * 返回值：
     *  1成功
     *  2鉴权失败
     *  3网络问题
     * @param path
     * @return
     */
    private int check(String path, TokenCheckVo checkVo, String token){
        String account = checkVo.getAccount();
        try {
            BaseResponse rst = restTemplate.getForObject("http://" + authService
                            + "/auth-service" + path + "?JSESSIONID=" + checkVo.getSessionId()
                            + "&account=" + account
                    , BaseResponse.class);
            if(logger.isDebugEnabled()) {
                logger.debug("auth服务检查权限信息 {}", JsonMapper.toJsonString(rst));
            }
            int status = 2;
            if(rst.get("code").equals("1")){
                logger.info("{} auth服务检查权限成功，{}", account, rst.attributes().get("sessionId"));
                status = 1;
            }else {
                logger.warn("{} auth服务检查权限失败 {}", account, rst.getMessage());
                status = 2;
            }
            checkVo.setAuthVisitTime(Calendar.getInstance().getTime());
            redisUtil.set(token, checkVo, gateWayProperties.getTimeOut());
            return status;
        }catch (Exception e){
            logger.error("{} auth服务检查权限失败 {}", account, e.getMessage());
            return 3;
        }
    }
    // 登录
    private boolean login(TokenCheckVo checkVo){
        String account = checkVo.getAccount();
        BaseResponse rst = null;
        try{
            rst = authLoginClient.loginNoPass(account);
            if(logger.isDebugEnabled()) {
                logger.debug("auth服务登录信息 {}", JsonMapper.toJsonString(rst));
            }
            if(rst.get("code").equals("1")){
                Map pp = rst.attributes();
                String sessionId = pp.get("sessionId").toString();
                logger.info("{} auth服务登录成功，{}", account, rst.attributes().get("sessionId"));
                checkVo.setAuthVisitTime(Calendar.getInstance().getTime());
                checkVo.setSessionId(sessionId);
                return true;
            }

            logger.warn("{} auth服务登录失败 {}", account, rst.getMessage());
            return false;
        }catch (Exception e){
            logger.error("{} auth服务登录失败 {}", account, e.getMessage());
            return false;
        }

    }

    @Override
    public int getOrder() {
        return -200;
    }

    /**
     * 生成token
     * @return
     */
    private String genJwt(String account) {
        long period = gateWayProperties.getPeriod();
        String jwt =  CryptoUtil.issueJwt(gateWayProperties.getJwtSecretKey()
                ,account
                ,account
                ,period
                ,null//CommonUtil.join(userRoles)
                ,null//CommonUtil.join(perms)
                , SignatureAlgorithm.HS512);
        return jwt;
    }
}
