package com.learnyeai.base.action.beans;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.model.UrDevice;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.service.UrDeviceWyService;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.web.IuuidLoginCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * uuid登录检查
 * 输入：报文头：appid、uuid、appType
 * 输出：设备信息、custId、userId
 * Created by zpz on 2017/2/13.
 */
@Service
public class UUIDLoginCheck implements IuuidLoginCheck {
    @Autowired
    private UrDeviceWyService deviceService;
    @Autowired
    CustInfoWyService custInfoExtService;
    private Logger logger = LoggerFactory.getLogger(UUIDLoginCheck.class);

    /**
     * 参数中要有UUID
     * @param ctx
     *  输出 custId
     *
     * @return 1登录、2未登录、3在其它设备登录 4新设备上登录
     */
    public String checkLogin(IBusinessContext ctx){
        // 根据设备id查询用户设备信息
//        Map deviceMap = deviceService.queryById(ctx);
        ctx.getParamMap().putAll(ctx.getReqHead());
        String uuid = CtxCommonUtils.getUUID(ctx.getParamMap());

        // 客户类型：1员工、2客户
        /*if(CtxCommonUtils.getClientOs() == ConfigEnum.CLIENT_OS.WA){
            logger.debug("客户程序uuid检查{}", uuid);
            return "1";
        }*/

        UrDevice deviceMap = deviceService.queryCurByUuid(uuid);

        if(null == deviceMap){ // 新设备上登录
            return "4";
        }
        // 1登录、2未登录、3在其它设备登录 4新设备上登录
        if(!"1".equals(deviceMap.getDevStatus()) ){
            return deviceMap.getDevStatus();
        }

        /*// 查询用户信息是否存在
        CustInfoVo custMap = custInfoExtService.queryById(deviceMap.getCustId());
        if(null == custMap){
            return "2";
        }

        // 用户检查
        // 根据用户id查询用户信息，N: 正常  D: 普通冻结  C: 注销  E:人工冻结
        String custStatus = custMap.getUserStatus();
        if(!custStatus.equals("N"))
            return  "2";*/

        ctx.getParamMap().put(CustInfoVo.CF.custId,deviceMap.getCustId());
        return "1";
    }

}
