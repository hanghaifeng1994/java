package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.CfgSchemeVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 行业方案
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/CfgScheme")
public interface CfgSchemeClient extends BaseFeignClient<CfgSchemeVo> {
}
