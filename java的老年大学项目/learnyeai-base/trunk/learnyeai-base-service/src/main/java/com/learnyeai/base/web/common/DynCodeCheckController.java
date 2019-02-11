package com.learnyeai.base.web.common;

import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.IController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Component
public class DynCodeCheckController implements IController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private IAresSerivce dynCodeCheckOp;

    @SuppressWarnings("unchecked")
	@RequestMapping("/common/dynCodeCheck.do")
    @ResponseBody
    public Map<String,Object> execute(IBusinessContext ctx) {
        dynCodeCheckOp.execute(ctx);

        // 限制输出
        return ctx.getParamMap();
    }
}
