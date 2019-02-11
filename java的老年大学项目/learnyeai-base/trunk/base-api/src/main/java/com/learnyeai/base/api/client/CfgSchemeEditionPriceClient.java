package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.CfgSchemeEditionPriceVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 方案版本价格
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/CfgSchemeEditionPrice")
public interface CfgSchemeEditionPriceClient extends BaseFeignClient<CfgSchemeEditionPriceVo> {
}
