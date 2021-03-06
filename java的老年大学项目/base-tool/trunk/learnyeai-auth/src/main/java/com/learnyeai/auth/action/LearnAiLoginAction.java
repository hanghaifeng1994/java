package com.learnyeai.auth.action;

import com.learnyeai.auth.domain.BaseResponse;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jsets.shiro.util.CryptoUtil;
import org.jsets.shiro.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zpz on 2018/8/14.
 */
@RestController
public class LearnAiLoginAction {

    /*@Value("${jwt.period}")
    private long period;
    private final String guestAcout = "guest_guest";*/

    /**
     * 免密码登录，登录后，拿到sessionid，请求需要鉴权登录，url拼上参数JSESSIONID=
     * @return
     */
    @RequestMapping(value = "/loginNoPass/{account}")
    public BaseResponse login(@PathVariable String account){
        /*if(null == account){
            account = guestAcout;
        }*/

        UsernamePasswordToken token = new UsernamePasswordToken(account, "111");

        Subject sub = SecurityUtils.getSubject();
        sub.login(token);
        Session sess = sub.getSession();
        return BaseResponse.ok()
                .add("account", account)
                .add("sessionId", sess.getId())
                .add("timeout", sess.getTimeout());
    }

    /**
     * 重新加载角色权限
     * @return
     */
    @RequestMapping(value = "/reloadShiro")
    public BaseResponse reloadShiroPermissions(){
        ShiroUtils.reloadFilterRules();
        return BaseResponse.ok();
    }

    /**
     * 生成token
     * @return
     */
    /*public String genJwt(String account) {
        String jwt =  CryptoUtil.issueJwt(ShiroUtils.getShiroProperties().getJwtSecretKey()
                ,account
                ,account
                ,period
                ,null//CommonUtil.join(userRoles)
                ,null//CommonUtil.join(perms)
                , SignatureAlgorithm.HS512);
        return jwt;
    }*/

    /**
     * 换取token
     *
     */
    /*@RequestMapping("/token/refreshJwtToken")
    public BaseResponse refreshJwtToken(String account, HttpServletResponse response){
        long currentTimeMillis = System.currentTimeMillis();

        String jwt =  genJwt(account);

        return BaseResponse.ok().add("jwt", jwt)
                .add("expiretime", currentTimeMillis + period)
                .message("令牌生成成功");
    }*/
}
