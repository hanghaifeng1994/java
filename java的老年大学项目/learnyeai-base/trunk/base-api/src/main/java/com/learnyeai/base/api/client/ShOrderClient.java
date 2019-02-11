package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.ShOrderVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 商户订单
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/ShOrder")
public interface ShOrderClient extends BaseFeignClient<ShOrderVo> {
}
