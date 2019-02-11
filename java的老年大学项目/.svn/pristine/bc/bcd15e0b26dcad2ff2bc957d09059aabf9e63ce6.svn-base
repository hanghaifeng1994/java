package com.learnyeai.base.web.login;

import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by zpz on 2018/8/23.
 */
@Component
public class UserRegistController implements IController {

    @Autowired
    @Qualifier(value = "registerFlow")
    private IAresFlowDispatch flow;

    @Override
    public Object execute(IBusinessContext iBusinessContext) {
        flow.execute(iBusinessContext);
        return null;
    }
}
