package com.learnyeai.lifelongedu.gateway.web;

import com.learnyeai.core.cache.RedisUtil;
import com.learnyeai.core.cache.RedisUtilFactory;
import com.learnyeai.lifelongedu.gateway.client.AuthLoginClient;
import com.learnyeai.lifelongedu.gateway.util.*;
import com.learnyeai.lifelongedu.gateway.vo.TokenCheckVo;
import com.learnyeai.tools.common.JsonMapper;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by zpz on 2018/8/15.
 */
@RestController
public class TokenAction {
    @Autowired
    private LearnAiGateWayProperties gateWayProperties = new LearnAiGateWayProperties();
    private RedisUtil redisUtil = null;//RedisUtilFactory.getUtil(GateWayUtils.CACHENAME_TOKEN);

    @Autowired
    private AuthLoginClient authLoginClient;
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 换取toekn
     * @param token
     * @param account
     * @return
     */
    @RequestMapping("/refreshToken")
    public BaseResponse refreshToken(String token, String account){
        if(null == token || token.length() == 0){
            return BaseResponse.fail("参数不能为空");
        }

        if(null == redisUtil){
            redisUtil = RedisUtilFactory.getUtil(GateWayUtils.CACHENAME_TOKEN);
        }

        // 缓存中不存在
        TokenCheckVo vo = redisUtil.get(token);
        if(null == vo){
            return BaseResponse.fail("参数无效");
        }

        // 查看是否过期
        if(vo.getAuthVisitTime() != null){
            if(vo.getAuthVisitTime().getTime() + gateWayProperties.getTimeOut()
                    < Calendar.getInstance().getTimeInMillis()){
                redisUtil.remove(token);
                return BaseResponse.fail("参数无效");
            }
        }

        // 缓存中的用户信息存在，校验用户一致性
        if(StringUtils.isNotBlank(vo.getAccount()) && !vo.getAccount().equals(account)){
            return BaseResponse.fail("参数无效");
        }

        vo.setAccount(account);
        // 生成新的token
        long period = gateWayProperties.getPeriod();
        String jwt = genJwt(account);

        // 如果访问时间为空登录
        if(!login(vo)){
            return BaseResponse.fail("换取token失败");
        }

        // 保存到缓存中
        redisUtil.set(jwt, vo, gateWayProperties.getTimeOut());
        redisUtil.remove(token);

        return BaseResponse.ok("换取token成功")
                .add("token", jwt)
                .add("expiretime", Calendar.getInstance().getTimeInMillis() + period)
                ;
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
}
