package com.learnyeai.base.api.client;

import com.learnyeai.base.api.vo.CustRoleVo;
import com.learnyeai.core.support.BaseFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 角色-暂不用
 *
 * @author zhangpz
 */
@FeignClient(name = "${BASE-SERVICE-NAME}", path="${BASE-SERVICE-CONTEXT-PATH}/CustRole")
public interface CustRoleClient extends BaseFeignClient<CustRoleVo> {
}
