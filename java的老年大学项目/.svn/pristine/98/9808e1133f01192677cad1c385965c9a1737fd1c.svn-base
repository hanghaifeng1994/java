package com.learnyeai.audit.api.client;

import com.learnyeai.audit.api.vo.AdtReportUpVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 上报审核
 *
 * @author yl
 */
@FeignClient(name = "COMMON-AUDIT-SERVICE", path="/commonaudit/AdtReportUp")
public interface AdtReportUpClient extends BaseFeignClient<AdtReportUpVo> {
    @RequestMapping(
            value = {"/audit"},
            method = {RequestMethod.POST},
            consumes = {"application/x-www-form-urlencoded"}
    )
    String audit(Map<String, Object> params);
}
