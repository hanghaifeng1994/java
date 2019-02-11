package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.ShMerchantSchemePackageVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 商户方案功能包
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/ShMerchantSchemePackage")
public interface ShMerchantSchemePackageClient extends BaseFeignClient<ShMerchantSchemePackageVo> {
}
