package com.learnyeai.base.web.common;

import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.stereotype.Component;

/**
 * 用户注册
 * Created by xielina on 2017/2/6 0006.
 */
@Component
public class RegisterUpdateController implements IController {

//    @Autowired
//    @Qualifier("registerFlow")
    private IAresFlowDispatch flow;

    @Override
    public Object execute(IBusinessContext ctx) {
        ctx.setParam("CUST_NAME","张三");
        flow.execute(ctx);
        // 限制输出
        return ctx.getParamMap();
    }
}
