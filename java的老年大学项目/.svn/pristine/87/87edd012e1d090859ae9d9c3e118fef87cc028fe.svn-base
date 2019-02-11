package com.learnyeai.learnai.engine;

import com.learnyeai.learnai.codec.MessageCodecFactory;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.session.util.SessionManagerUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.tools.common.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zpz on 2016/4/11.
 * 渠道处理器
 * 解密加密、报文处理
 */
public abstract class AbstractChannelEngine {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected MessageCodecFactory codecFactory;

    private String coderKey;

    /**
     * 获取action
     * @param transCode
     * @return
     */
    private IController getAction(String transCode){
        // 获取aciotn执行，为transcode倒数第二个../controller/method，
        // 为了迅速找到bean，如果只有两个
        String methods = null;
        IController action = null;
        {
            String arr[] = transCode.split("/");
            int len = arr.length;
            String act = null;
            for(int i=len-1; i>-1 && i>=len-2; i--){
                try{
                    act = arr[i];
                    action = SpringContextUtils.getBean(act + "Controller", IController.class);
                }catch (Exception e){}
                if(action!=null) {
                    break;
                }
            }
            methods = arr[len-1];
            if(methods.equals(act))
                methods = null;
        }

        // 设置方法参数
        CtxHeadUtil.setControllerMethod(methods);
        return action;
    }

    /**
     * 渠道处理，子类可能需要覆盖此方案：解密-初始化数据-》加密
     * 此方法不做加解密操作，由子类完成
     * @param request
     * @param ctx
     * @return
     */
    public String execute(HttpServletRequest request, IBusinessContext ctx ){
        String transCode = ctx.getTransCode();

        IController action = getAction(transCode);
        Object data = doAction(ctx, action);

        if(data == null)
            return "";
        else if(data instanceof String){
            return (String)data;
        }

        //  提交session
        Session sess = ThreadContextUtil.getSession(false);
        if(sess != null && !sess.isExpire()) {
            SessionManagerUtils.getDefaultManager().submit(sess);
        }

        return JsonMapper.getInstance().toJson(data);
    }

    protected abstract Object doAction(IBusinessContext ctx, IController action);

    private final String SERCICE_ERROR = "inte.service_not_found_or_error";

    private boolean allowJSONP = false;

    public boolean isAllowJSONP() {
        return allowJSONP;
    }

    public void setAllowJSONP(boolean allowJSONP) {
        this.allowJSONP = allowJSONP;
    }

    public String getCoderKey() {
        return coderKey;
    }

    public void setCoderKey(String coderKey) {
        this.coderKey = coderKey;
    }
}
