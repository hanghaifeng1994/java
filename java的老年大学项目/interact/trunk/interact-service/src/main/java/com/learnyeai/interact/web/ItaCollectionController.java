package com.learnyeai.interact.web;

import com.learnyeai.interact.model.ItaInteractionTimes;
import com.learnyeai.interact.service.ItaInteractionTimesWyService;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.common.support.WeyeBaseService;

import com.learnyeai.interact.model.ItaCollection;
import com.learnyeai.interact.service.ItaCollectionWyService;
import com.learnyeai.learnai.support.IBusinessContext;
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
import java.util.Map;

/**
 *
 * @author yl
 */
@Component
public class ItaCollectionController extends BaseController<ItaCollection> {
    public static final String BASE_URL = "/ItaCollection/";

    @Autowired
    private ItaCollectionWyService itaCollectionWyService;
    @Autowired
    private ItaInteractionTimesWyService itaInteractionTimesWyService;

    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${spring.application.name}")
    private String aplicationName;

    @Value("${schema.interPlat}")
    private String interPlat;

    @Value("${collect_key}")
    private String collectKey;

    @Override
    protected WeyeBaseService<ItaCollection> getService() {
        return itaCollectionWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        ItaCollection ic=itaCollectionWyService.convert2Bean(ctx.getParamMap());
        if("queryPage".equals(method)){
            return itaCollectionWyService.listPage(ctx);
        }
       if("insert".equals(method)){
           ic.setCltStatus("1");
           return  itaCollectionWyService.saveCach( ic);
       }
       //取消收藏
       if("delete".equals(method)){
           ic.setCltStatus("2");
            itaCollectionWyService.saveCach( ic);
           return null;
       }
        return super.execute(ctx);
    }
}
