package com.learnyeai.schoolclass.web;

import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.schoolclass.model.ClzCategory;
import com.learnyeai.schoolclass.model.ClzCategoryClzzRell;
import com.learnyeai.schoolclass.model.ClzClazz;
import com.learnyeai.schoolclass.service.ClzCategoryClzzRellWyService;
import com.learnyeai.schoolclass.service.ClzCategoryWyService;
import com.learnyeai.schoolclass.service.ClzClazzWyService;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + ClzClazzController.BASE_URL)
public class ClzClazzController extends BaseController<ClzClazz> {
    public static final String BASE_URL = "/ClzClazz/";

    @Autowired
    private ClzClazzWyService clzClazzWyService;
    @Autowired
    private ClzCategoryWyService clzCategoryWyService;
    @Autowired
    private ClzCategoryClzzRellWyService clzCategoryClzzRellWyService;

    @Override
    protected BaseService<ClzClazz> getService() {
        return clzClazzWyService;
    }
    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("save".equals(method)){
           return clzClazzWyService.saveData(ctx);
        }
        if("publish".equals(method)){
            return clzClazzWyService.publish(ctx);
        }
        if("delete".equals(method)){
            return clzClazzWyService.deleteBatch(ctx);
        }
        if("queryById".equals(method)){
            String id=MapUtil.singleNodeText(ctx.getParamMap(),"czId");
            ClzClazz cc= clzClazzWyService.queryById(id);
            ClzCategoryClzzRell rell=new ClzCategoryClzzRell();
            rell.setCzId(id);
            List<ClzCategoryClzzRell> rels=clzCategoryClzzRellWyService.queryList(rell,ctx.getParamMap());
           int i=1;
           String catId="";
           String catName="";
            for(ClzCategoryClzzRell r:rels){
                ClzCategory c=new ClzCategory();
                c.setCatId(r.getCatId());
                ClzCategory cate = clzCategoryWyService.queryById(r.getCatId());
                if(cate!=null){
                    if(i==rels.size()){
                        catName+= cate.getCatName();
                        catId+= cate.getCatId();
                    }else{
                        catName+= cate.getCatName()+",";
                        catId+= cate.getCatId()+",";
                    }
                }
                i++;
            }
            cc.setCatId(catId);
            cc.setCatName(catName);
            return cc;
        }
        if("queryPageManger".equals(method)){
            List<ClzClazz> list= clzClazzWyService.queryPageManger(ctx);
            MyPage page=new MyPage(list);
            return super.rtnPageList4Report(page);
        }
        if("queryPageUse".equals(method)){
            List<ClzClazz> list=clzClazzWyService.queryPageUse(ctx);
            MyPage page=new MyPage(list);
            return super.rtnPageList4Report(page);
        }
        if("sendLowerPage".equals(method)){
            MyPage page= clzClazzWyService.sendLowerPage(ctx);
            return super.rtnPageList4Report(page);
        }
        if("recommend".equals(method)){
            return clzClazzWyService.recommend(ctx);
        }
        return super.execute(ctx);
    }
}
