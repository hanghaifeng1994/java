package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.CfgAppletVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 小程序
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/CfgApplet")
public interface CfgAppletClient extends BaseFeignClient<CfgAppletVo> {
}
