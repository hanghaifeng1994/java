package com.learnyeai.schoolclass.service;

import com.github.pagehelper.PageHelper;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.mapper.ClzCategoryClzzRellMapper;
import com.learnyeai.schoolclass.model.ClzCategory;
import com.learnyeai.schoolclass.mapper.ClzCategoryMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.schoolclass.model.ClzCategoryClzzRell;
import com.learnyeai.schoolclass.model.ClzClazz;
import com.learnyeai.schoolclass.model.ClzSiteCategoryRel;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author twang
 */
@Service
public class ClzCategoryWyService extends WeyeBaseService<ClzCategory> {

    @Resource
    private ClzCategoryMapper clzCategoryMapper;
    @Resource
    private ClzCategoryClzzRellMapper clzCategoryClzzRellMapper;
    @Resource
    private ClzCategoryClzzRellWyService clzCategoryClzzRellWyService;
    @Resource
    private  ClzSiteCategoryRelWyService clzSiteCategoryRelWyService;

    @Override
    public BaseMapper<ClzCategory> getMapper() {
        return clzCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend<ClzCategory> genSqlExample(ClzCategory t, Map params) {
        Weekend<ClzCategory> weekend = super.genSqlExample(t, params);
        WeekendCriteria<ClzCategory, Object> c = weekend.createCriteriaAddOn();
        String catIds= MapUtil.singleNodeText(params,"catIds");
        String siteIds= MapUtil.singleNodeText(params,"siteIds");
        if(StringUtils.isNotBlank(catIds)){
            String[] catIdArr=catIds.split(",");
            c.andIn(ClzCategory::getCatId,Arrays.asList(catIdArr));
        }
        if(StringUtils.isNotBlank(siteIds)){
            String[] siteIdArr=siteIds.split(",");
            c.andIn(ClzCategory::getSiteId,Arrays.asList(siteIdArr));
        }
        if(StringUtils.isNotBlank(t.getCatCerted())){
            c.andEqualTo(ClzCategory::getCatCerted,t.getCatCerted());
        }
        if(StringUtils.isNotBlank(t.getParentId())){
            c.andEqualTo(ClzCategory::getParentId,t.getParentId());
        }
        weekend.and(c);
        return weekend;
    }

    /**
     * 保存
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> saveData(IBusinessContext ctx){
        ClzCategory cc= super.convert2Bean(ctx.getParamMap());
        String siteId=cc.getSiteId();
        String parent=cc.getParentId();
        boolean flag=true;
        if(StringUtils.isBlank(cc.getCatId())){
            if(StringUtils.isNotBlank(parent)){
                ClzCategory cate=super.queryById(parent);
                if(cate !=null){
                    String  parentIds=cate.getParentIds()+parent+",";
                    cc.setParentIds(parentIds);
                }
                //改变父id状态1为存在子数据
                cate.setChildData("1");
                super.save(cate);
            }else{
                cc.setParentId("0");
                cc.setParentIds("0,");
            }
        }else{
            flag=false;
        }

        super.save(cc);
        //向站点分类关联表中插入数据
        if(flag){
            List<PtsetSiteVo> list= SiteUtils.getPubSites(siteId);
            ClzSiteCategoryRel rel=new ClzSiteCategoryRel();
            for(PtsetSiteVo pt:list){
                rel.setCatId(cc.getCatId());
                rel.setCatCrtSiteId(siteId);
                rel.setSiteId(pt.getSiteId());
                rel.setShowStatus("1");
                clzSiteCategoryRelWyService.save(rel);
            }
        }
        return MapUtil.newMap("id",cc.getCatId());
    }

    /**
     * 删除分类
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> deleteData(IBusinessContext ctx){
        ClzCategory cc=super.convert2Bean(ctx.getParamMap());
       String[] ids=(MapUtil.singleNodeText(ctx.getParamMap(),"catIds")).split(",");
        ClzCategoryClzzRell rell=new ClzCategoryClzzRell();
        int num=0;
        for(String id:ids){
            ClzCategory cate= super.queryById(id);
            //先判断该栏目下面是否有班级
            rell.setCatId(id);
            List<ClzCategoryClzzRell> list=clzCategoryClzzRellWyService.queryList(rell,new HashMap());
            if(list.size()>0){
                return MapUtil.newMap("msg","该栏目下存在班级不能删除");
            }
            String parentId=cate.getParentId();
            if(parentId !="0"){
                ClzCategory nca=  new ClzCategory();
                nca.setParentId(parentId);
                List<ClzCategory> cats=super.queryList(nca,new HashMap());
                if(cats.size()==1){
                    ClzCategory category= new ClzCategory();
                    category.setCatId((cats.get(0).getParentId()));
                    category.setChildData("0");
                    super.save(category);
                }
            }
            String siteId= cate.getSiteId();
            num+=super.deleteById(id);
            clzCategoryClzzRellMapper.deleteByCatId(id);
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 可用分类
     * @param ctx
     * @return
     */
    public List<ClzCategory>  queryPageUse(IBusinessContext ctx){
        ClzCategory cc=super.convert2Bean(ctx.getParamMap());
        if (cc != null) {
            cc.initPage();
            PageHelper.startPage(cc.getPage(), cc.getRows());
        }
        Weekend w=super.genSqlExample(cc,ctx.getParamMap());
        WeekendCriteria<ClzCategory,Object> c=w.weekendCriteria();
       String  query=" EXISTS (SELECT 1 FROM clz_site_category_rel r WHERE r.`CAT_ID`= clz_category.`CAT_ID` ";
       String siteIds=MapUtil.singleNodeText(ctx.getParamMap(),"siteIds");
       if(StringUtils.isNotBlank(siteIds)){
           String[] siteIdArr=siteIds.split(",");
           c.andIn(ClzCategory::getSiteId,Arrays.asList(siteIdArr));
       }
       if(StringUtils.isNotBlank(cc.getCatCerted())){
           c.andEqualTo(ClzCategory::getCatCerted,cc.getCatCerted());
       }
       String catIds=MapUtil.singleNodeText(ctx.getParamMap(),"catIds");
       if(StringUtils.isNotBlank(catIds)){
           String[] catIdArr=catIds.split(",");
           int length=catIdArr.length;
           query+=" and r.cat_id in (";
           for(int i=0;i<length;i++){
               if(i==length-1){
                   query+="'"+catIdArr[i]+"'";
               }else{
                   query+="'"+catIdArr[i]+"',";
               }
           }
           query+=")";
       }
       query+=")";
       c.andCondition(query);
       w.and(c);
        return    clzCategoryMapper.selectByExample(w);
    }
    public static void  main(String[] args){
        Optional<String> stringOptional = Optional.of("zhangsan");
        System.out.println(stringOptional.map(e -> e.toUpperCase()).orElse("失败"));
        stringOptional.map(e  ->e.equals("w")).orElse(false);

    }
}
