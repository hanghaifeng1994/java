package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.CfgSchemeEditionVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 方案版本
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/CfgSchemeEdition")
public interface CfgSchemeEditionClient extends BaseFeignClient<CfgSchemeEditionVo> {
}
