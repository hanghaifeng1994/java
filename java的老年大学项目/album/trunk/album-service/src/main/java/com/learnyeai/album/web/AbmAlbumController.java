package com.learnyeai.album.web;

import com.learnyeai.album.model.AbmCategory;
import com.learnyeai.album.model.AbmCategoryPhotoRel;
import com.learnyeai.album.model.AbmPhoto;
import com.learnyeai.album.service.AbmCategoryPhotoRelWyService;
import com.learnyeai.album.service.AbmCategoryWyService;
import com.learnyeai.album.service.AbmPhotoWyService;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;

import com.learnyeai.album.model.AbmAlbum;
import com.learnyeai.album.service.AbmAlbumWyService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author yl
 */
@Component
public class AbmAlbumController extends BaseController<AbmAlbum> {

    @Autowired
    private AbmAlbumWyService abmAlbumWyService;
    @Autowired
    private AbmPhotoWyService abmPhotoWyService;
    @Autowired
    private AbmCategoryPhotoRelWyService abmCategoryPhotoRelWyService;
    @Autowired
    private AbmCategoryWyService abmCategoryWyService;

    @Override
    protected BaseService<AbmAlbum> getService() {
        return abmAlbumWyService;
    }

    @Override
    public Object execute(IBusinessContext ctx) {
        String method = CtxHeadUtil.getControllerMethod();
        if("sendLowerPage".equals(method)){
            return abmAlbumWyService.sendLowerPage(ctx);
        }
        if("queryPage".equals(method)){
            return abmAlbumWyService.queryPageExt(ctx);
        }
        if("queryPageUse".equals(method)){
            return abmAlbumWyService.queryPageUse(ctx);
        }
        if("save".equals(method)){
            return abmAlbumWyService.saveData(ctx);
        }
        if("delete".equals(method)){
            return abmAlbumWyService.delBatch(ctx);
        }
        if("queryById".equals(method)){
            return abmAlbumWyService.queryByIdMsg(ctx);
        }
        if("sumbitAudit".equals(method)){
            return  abmAlbumWyService.sumbitAudit(ctx);
        }
        if("audit".equals(method)){
            try {
                return abmAlbumWyService.audit(ctx);
            } catch (WeyeRabbitException e) {
                e.printStackTrace();
            }
        }
        if("myQueryPage".equals(method)){
          return   abmAlbumWyService.myQueryPage(ctx);
        }
        if("recommend".equals(method)){
            return abmAlbumWyService.recommend(ctx);
        }
        if("queryByIds".equals(method)){
         List<AbmAlbum> list=   super.queryByIds(ctx);
            AbmPhoto ap=new AbmPhoto();
         for (AbmAlbum a:list){
             ap.setAbmId(a.getAbmId());
             List<AbmPhoto> list2=  abmPhotoWyService.queryList(ap,ctx.getParamMap());
             AbmCategoryPhotoRel rel=new AbmCategoryPhotoRel();
             String abmId=a.getAbmId();
             rel.setAbmId(abmId);
             //通过abmId查询出所有的分类id
             List<AbmCategoryPhotoRel> photoRels=  abmCategoryPhotoRelWyService.queryList(rel,ctx.getParamMap());
             int i=1;
             String catName="";
             String catId="";
             for(AbmCategoryPhotoRel prel:photoRels){
                 //通过分类id查询分类名称
                 AbmCategory cate=  abmCategoryWyService.queryById(prel.getAbmId());
                 if(cate!=null){
                     if(i==photoRels.size()){
                         catName+=cate.getCatName();
                         catId+=cate.getCatId();
                     }else{
                         catId+=cate.getCatId()+",";
                     }
                 }

             }
             a.setCatId(catId);
             a.setCatName(catName);
             a.setPhotoList(list2);
         }
         return  list;
        }
        return super.execute(ctx);
    }
}
