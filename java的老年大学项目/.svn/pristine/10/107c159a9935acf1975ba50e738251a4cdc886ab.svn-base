package com.learnyeai.base.web.common;

import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.stereotype.Component;

/**
 * 忘记密码
 * Created by xielina on 2017/2/7 0007.
 */
@Component
public class ForgetPasswordController implements IController {

//    @Autowired
//    @Qualifier("findPwdByMobile")
    private IAresFlowDispatch flow;

    @Override
    public Object execute(IBusinessContext ctx) {
        flow.execute(ctx);
        // 限制输出
        return ctx.getParamMap();
    }
}
