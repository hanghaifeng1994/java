package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.ShAppletSettingVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 小程序配置
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/ShAppletSetting")
public interface ShAppletSettingClient extends BaseFeignClient<ShAppletSettingVo> {
}
