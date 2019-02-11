package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 客户
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/CustInfo")
public interface CustInfoClient extends BaseFeignClient<CustInfoVo> {

    @RequestMapping(value = {"/queryByLoginName"}
            ,method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    CustInfoVo queryByLoginName(Map<String, Object> params);
}
