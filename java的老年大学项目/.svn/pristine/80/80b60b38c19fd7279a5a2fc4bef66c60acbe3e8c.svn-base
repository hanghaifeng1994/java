package com.learnyeai.base.action.cust;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.utils.BaseReportErrorKey;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.error.AresRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zpz on 2018/8/23.
 */
@Service
public class UserLoginNameCheckOp implements IAresSerivce{
    @Autowired
    private CustInfoWyService custInfoWyService;

    @Override
    public int execute(IBusinessContext ctx) {
        String loginName = ctx.getParam(CustInfoVo.CF.loginName);
        // 商户必须存在
        CustInfo userInfo = custInfoWyService.queryByLoginName(loginName, WeyeThreadContextUtils.getMerchantId(), null);
        if(null != userInfo){
            throw new AresRuntimeException(BaseReportErrorKey.login_UserExist);
        }
        return NEXT;
    }
}
