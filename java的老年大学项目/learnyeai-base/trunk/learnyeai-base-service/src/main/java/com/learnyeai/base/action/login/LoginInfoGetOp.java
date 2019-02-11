package com.learnyeai.base.action.login;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.model.CustLgnInfo;
import com.learnyeai.base.service.CustLgnInfoWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.tools.common.DateHelper;
import com.learnyeai.tools.common.F5ipUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 获取登录信息
 * 输入：CUST_ID
 *  CLIENT_OS
 * 输出：loginInfoKey（登录信息）
 * Created by zpz on 2017/3/15.
 */
@Component
public class LoginInfoGetOp implements IAresSerivce {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private CustLgnInfoWyService lgnInfoService;

    private static String loginInfoKey = "__loginInfo";

    public static CustLgnInfo getLoginInfo(IBusinessContext ctx){
        Object o = ctx.getParamMap().get(loginInfoKey);
        return null == o ? null : (CustLgnInfo)o;
    }

    @Override
    public int execute(IBusinessContext ctx) {
        logger.debug("--run---");

        //根据用户ID获取最后一次登录信息
        String custId = ctx.getParam(CustInfoVo.CF.custId);

        CustLgnInfo loginMap = this.lgnInfoService.queryByUserId(custId);

        //登录信息
        String lgnIp = F5ipUtil.getIpAddr(ctx.getRequest());
        String todayStr = DateFormatUtils.format(new Date(),
                "yyyy-MM-dd HH:mm:ss");

        if(loginMap!=null) {
//            loginMap.putAll(ctx.getParamMap());
            loginMap.setFirstLgnFlag("N");
        }else {
            loginMap = new CustLgnInfo();
            //首次登录标记：Y:首次登录 N：非首次登录
            loginMap.setFirstLgnFlag("Y");
            //首次登录时间
            loginMap.setFirstLgnDate(todayStr);
            loginMap.setUserId(custId);
        }

        loginMap.setLgnDate(DateHelper.getDate());
        loginMap.setLgnTime(DateHelper.getTime());
        loginMap.setLgnIp(lgnIp);
        loginMap.setLgnDatetime(new Date());

        ConfigEnum.CLIENT_OS clientOs = CtxCommonUtils.getClientOs();
        if(clientOs == ConfigEnum.CLIENT_OS.O){
            loginMap.setLgnType(BaseCons.LGN_TYPE.WY.getVal());
        }else{
            loginMap.setLgnType(BaseCons.LGN_TYPE.APP.getVal());
        }

        ctx.getParamMap().put(loginInfoKey, loginMap);

        return NEXT;
    }
}
