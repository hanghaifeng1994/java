package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.model.ClzClazzNews;
import com.learnyeai.schoolclass.service.ClzClazzNewsWyService;
import com.learnyeai.tools.common.MapUtil;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 *
 * @author twang
 */
@Component
public class ClzClazzNewsController extends BaseController<ClzClazzNews> {

    @Autowired
    private ClzClazzNewsWyService clzClazzNewsWyService;

    @Override
    protected BaseService<ClzClazzNews> getService() {
        return clzClazzNewsWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String transCode = ctx.getTransCode();
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
            ClzClazzNews news=  clzClazzNewsWyService.convert2Bean(ctx.getParamMap());
            news.setCreateDate(new Date());
            clzClazzNewsWyService.saveData(news);
            return null;
        }
        if("queryPage".equals(method)){
          MyPage page=    clzClazzNewsWyService.queryPage(null,ctx.getParamMap());
          rtnPageList4Report(page);
          List<ClzClazzNews> list=page.getList();
          String ids="";
          for (ClzClazzNews l:list){
              ids+=l.getArticleId()+",";
          }
            return MapUtil.newMap("articleIds",ids);
        }
        return super.execute(ctx);
    }
}
