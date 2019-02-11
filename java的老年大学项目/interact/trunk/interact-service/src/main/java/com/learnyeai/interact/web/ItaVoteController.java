package com.learnyeai.interact.web;

import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.interact.model.ItaVote;
import com.learnyeai.interact.service.ItaVoteWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yl
 */
@Component
public class ItaVoteController extends BaseController<ItaVote> {
    public static final String BASE_URL = "/ItaVote/";

    @Autowired
    private ItaVoteWyService itaVoteWyService;
    @Autowired
    private ItaInteractionTimesWyService itaInteractionTimesWyService;
    @Autowired
    CurrentUserInfoIml currentUserInfoIml;
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;
    @Value("${spring.application.name}")
    private String aplicationName;
    @Value("${schema.interPlat}")
    private String interPlat;
    @Value("${vote_key}")
    private String voteKey;

    @Override
    protected WeyeBaseService<ItaVote> getService() {
        return itaVoteWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        ItaVote iv=itaVoteWyService.convert2Bean(ctx.getParamMap());
        ItaInteractionTimes it=new ItaInteractionTimes();
        it.setObjId(iv.getObjId());
        it.setType(iv.getType());
        if("save".equals(method)){
            return  itaVoteWyService.saveData(iv);
        }
        if("queryListById".equals(method)){
           return  itaVoteWyService.queryListByObjId(iv);
        }
        return super.execute(ctx);
    }
}
