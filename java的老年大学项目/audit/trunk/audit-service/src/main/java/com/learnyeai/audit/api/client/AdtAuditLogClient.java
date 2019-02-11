package com.learnyeai.audit.api.client;

import com.learnyeai.audit.api.vo.AdtAuditLogVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 审核日志
 *
 * @author yl
 */
@FeignClient(name = "COMMON-AUDIT-SERVICE", path="/commonaudit/AdtAuditLog")
public interface AdtAuditLogClient extends BaseFeignClient<AdtAuditLogVo> {
    @RequestMapping(
            value = {"/queryPageByIds"},
            method = {RequestMethod.POST},
            consumes = {"application/x-www-form-urlencoded"}
    )
   String queryPageByIds(Map<String, Object> var1);
}
