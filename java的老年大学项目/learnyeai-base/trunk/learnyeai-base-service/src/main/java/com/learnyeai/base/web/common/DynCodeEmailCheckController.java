package com.learnyeai.base.web.common;

import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 邮箱验证码校验
 * Created by XieLina on 2016/5/17 0017.
 */
@Component
public class DynCodeEmailCheckController implements IController {
    @Autowired
    private IAresSerivce emailDynCodeCheckOp;

    @SuppressWarnings("unchecked")
    @RequestMapping("/common/dynCodeCheck.do")
    @ResponseBody
    @Override
    public Object execute(IBusinessContext ctx) {
        emailDynCodeCheckOp.execute(ctx);
        // 限制输出
        return ctx.getParamMap();
    }
}
