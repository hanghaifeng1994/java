package com.learnyeai.base.action.beans;

import com.learnyeai.core.flow.IAresFlowDispatch;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.web.IloginSessionCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by zpz on 2017/11/18.
 */
@Service
public class LoginSessionCreate implements IloginSessionCreate {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("appStartCheckFlow")
    private IAresFlowDispatch appStartCheckFlow;

    @Override
    public void execute(IBusinessContext ctx) {

        appStartCheckFlow.execute(ctx);
    }
}
