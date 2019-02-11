package com.learnyeai.learnai.engine;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 处理普通的请求，只会把参数放到ctx中
 * 做简单的请求转发
 * Created by zpz on 2018/03/09.
 */
public class OtherChannelEngine extends AbstractChannelEngine {

    private Logger logger = LoggerFactory.getLogger(getClass());


    private void init(HttpServletRequest request, IBusinessContext ctx) {
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()){
            Object o = names.nextElement();
            ctx.getParamMap().put(o, request.getParameter(o.toString()));
        }

    }

    /**
     * 渠道处理
     * @param request
     * @param ctx
     * @return
     */
    public String execute(HttpServletRequest request, IBusinessContext ctx ){
        try{
            init(request, ctx);
            String rst = super.execute(request, ctx);

            return rst;
        }catch (Exception e){
            logger.error("error", e);
            e.printStackTrace();
        }
        return "请求失败";

    }

    @Override
    protected Object doAction(IBusinessContext ctx, IController action) {
        Object data = action.execute(ctx);

        return data;
    }
}
