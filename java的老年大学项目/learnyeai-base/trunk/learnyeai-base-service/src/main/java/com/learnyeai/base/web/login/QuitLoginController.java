package com.learnyeai.base.web.login;

import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.service.UrDeviceWyService;
import com.learnyeai.common.utils.WeyeThreadContextUtils;
import com.learnyeai.core.consts.ConfigEnum;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.CurrentUserHelp;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 退出登录
 * Created by xielina on 2017/2/10 0010.
 */
@Component
public class QuitLoginController implements IController {


    @Resource
    private UrDeviceWyService deviceService;

    @Override
    public Object execute(IBusinessContext ctx) {
        Object uuid = ctx.getReqHead().get("UUID");
        //当前登陆用户id
        String userId = ThreadContextUtil.getSessionRequired().getUserId();
        // 没有登录，不用处理
        if(StringUtils.isBlank(userId)){
            return null;
        }

        Map userMap = CurrentUserHelp.getUserInfo();
        String mchtId = MapUtil.singleNodeText(userMap, CustInfoVo.CF.mchtId);
        // 设置当前商户
        ThreadContext.put(WeyeThreadContextUtils.CTX_CUR_MERCHANT, mchtId);

        //修改用户登录表中的是否登录字段（退出登录） // 监听器中已经处理 // 张配忠 20170315
        /*Map params = new HashMap();
        params.put(CustLgnInfo.TF.userId,userId);
        params.put(CustLgnInfo.TF.isOnline, "0");
        custLgnInfoService.updateLngStatus(params);*/
        ConfigEnum.CLIENT_OS client = CtxCommonUtils.getClientOs();
        if(client != ConfigEnum.CLIENT_OS.O){
            deviceService.updateDeviceStatus(userId, uuid.toString(), "2");
        }

        ThreadContextUtil.resetSession();
        return ctx.getParamMap();
    }
}
