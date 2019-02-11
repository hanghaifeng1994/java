package com.learnyeai.lifelongedu.gateway.client;

import com.learnyeai.lifelongedu.gateway.util.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 小程序
 *
 * @author zhangpz
 */
@FeignClient(name = "${AUTH-SERVICE}")
public interface AuthLoginClient {
    // 登录
    @RequestMapping(value = "/auth-service/loginNoPass/{account}")
    BaseResponse loginNoPass(@PathVariable(value = "account") String account);

//    @RequestMapping(value = "/**/*.do")
//    BaseResponse check(@RequestParam(value = "account") String account);
}
