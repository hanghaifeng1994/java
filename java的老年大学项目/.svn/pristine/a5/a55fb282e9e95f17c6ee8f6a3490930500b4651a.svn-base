package com.learnyeai.auth.action;

import com.learnyeai.auth.domain.BaseResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zpz on 2018/8/2.
 */
@RestController
public class CheckPermissionsAction {

//    @Autowired
//    private CacheManager cacheManager;

    /**
     * 检查所有接口权限
     * @return
     */
    @RequestMapping(value = "/**/*.do")
    public BaseResponse check(String account){
        /*String host = request.getRemoteHost();
        String jwt = request.getParameter(ShiroProperties.PARAM_JWT);
        if(null != jwt){
            try {
                JwtToken token = new JwtToken(host, jwt);
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
            }catch (Exception e){
                return BaseResponse.fail(REST_CODE_AUTH_UNAUTHORIZED, e.getMessage());
            }
        }*/

        Subject sub = SecurityUtils.getSubject();
        Session sess = sub.getSession();
        if(sub.getPrincipal().equals(account)) {
            return BaseResponse.ok()
                    .add("startTime", sess.getStartTimestamp())
                    .add("timeout", sess.getTimeout());
        }else {
            return BaseResponse.fail("用户信息不一致 :" + sub.getPrincipal() + "_" + account);
        }
    }

    // 检查是否拥有权限
    @RequestMapping(value = "/perm/hasPermission.do")
    public BaseResponse hasPermission(String perm){
        Subject sub = SecurityUtils.getSubject();
        boolean b = sub.isPermitted(perm);
        BaseResponse rst = BaseResponse.build().message(b ? "拥有权限" : "错误！没有权限");
        rst.put("success", b? 1 : false);
        return rst;
    }


    // 检查是否拥有权限
    @RequestMapping("/perm/permissions.do")
    public BaseResponse hasPermissions(@RequestBody String[] perms){
        Subject sub = SecurityUtils.getSubject();
        boolean[] b = sub.isPermitted(perms);
        BaseResponse rst = BaseResponse.build();
        rst.put("success",1);
        return rst.add("perms", b);
    }
}
