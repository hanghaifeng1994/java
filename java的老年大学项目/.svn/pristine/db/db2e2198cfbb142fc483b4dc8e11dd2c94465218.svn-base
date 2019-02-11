package com.learnyeai.base.action.login;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.UrDeviceWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.core.utils.CtxCommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户设备信息保存
 * 输入：CUST_ID
 *  UUID
 *  CLIENT_OS
 * Created by zpz on 2017/3/15.
 */
@Component
public class LoginDeviceSaveOp implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UrDeviceWyService deviceService;

    @Override
    public int execute(IBusinessContext ctx) {
        logger.debug("--run---");

        String custId = ctx.getParam(CustInfoVo.CF.custId);
        String uuid = CtxCommonUtils.getUUID(ctx.getParamMap());

        //判断是客户端登陆还是网页登陆
        ConfigEnum.CLIENT_OS clientOs = CtxCommonUtils.getClientOs();
        if(clientOs == ConfigEnum.CLIENT_OS.O)
            return NEXT;

        deviceService.loginInit(custId, uuid, clientOs.name(), ctx);

        return NEXT;
    }
}
