package com.learnyeai.base.action.login;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.api.vo.ShMerchantSchemeVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.model.ShMerchant;
import com.learnyeai.base.model.ShMerchantScheme;
import com.learnyeai.base.service.ShMerchantSchemeWyService;
import com.learnyeai.base.service.ShMerchantWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.consts.ConsTools;
import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.tools.common.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 检查商户版本、商户状态
 * 输入：MCHT_SCHM_ID、商户方案id、CUST_TYPE
 * Created by zpz on 2017/11/18.
 */
@Service
public class Weye_CheckMerchantOp implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(Weye_CheckMerchantOp.class);

    @Autowired
    private ShMerchantWyService merchantService;
    @Autowired
    private ShMerchantSchemeWyService merchantSchemeService;

    @Override
    public int execute(IBusinessContext ctx) {//查询用户信息
        // 如果用户是系统用户，不用检查
        String custType = ctx.getParam(CustInfoVo.CF.custType);
        if(ConsTools.getCons(BaseCons.CUST_INFO_TYPE.class, custType) == BaseCons.CUST_INFO_TYPE.SYS){
            return NEXT;
        }

        if(CtxCommonUtils.getClientOs() != ConfigEnum.CLIENT_OS.WA){
            return NEXT;
        }

        String mchtSchmId = MapUtil.singleNodeValue(ctx.getParamMap(), ShMerchantSchemeVo.CF.mchtSchmId);
        ShMerchantScheme merchantScheme = merchantSchemeService.queryById(mchtSchmId);
        if(null == merchantScheme){
            throw new BusinessException("merchant_scheme_not_exist", "商户方案不存在");
        }
        ShMerchant merchant = merchantService.queryById(merchantScheme.getMchtId());
        String status = merchant.getMchtStatus();
        if(merchant == null || !ConfigEnum.ENABLE.equals(status)){
            logger.error("商户不存在");
            throw new BusinessException("merchant_not_exist", "商户不存在");
        }
        String ss = merchantScheme.getMchtSchmStatus();

        if(ConfigEnum.DISABLE.equals(ss)){
            throw new BusinessException("merchant_scheme_disable", "商户方案已禁用");
        }

        return NEXT;
    }
}
