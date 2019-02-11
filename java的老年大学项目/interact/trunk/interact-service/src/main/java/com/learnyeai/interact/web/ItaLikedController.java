package com.learnyeai.interact.web;

import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.interact.model.ItaLiked;
import com.learnyeai.interact.service.ItaLikedWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author yl
 */
@Component
public class ItaLikedController extends BaseController<ItaLiked> {
    public static final String BASE_URL = "/ItaLiked/";
    @Autowired
    private ItaLikedWyService itaLikedWyService;

    @Autowired
    private CurrentUserInfoIml currentUserInfoIml;
    @Override
    protected WeyeBaseService<ItaLiked> getService() {
        return itaLikedWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("isItaLike".equals(method)){
           return itaLikedWyService.isItaLike(ctx);
        }
        if("insert".equals(method)){
            return  itaLikedWyService.saveCach(ctx);
        }
        return super.execute(ctx);
    }
}
