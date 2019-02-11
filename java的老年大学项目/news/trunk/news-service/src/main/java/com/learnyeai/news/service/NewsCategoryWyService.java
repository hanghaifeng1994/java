package com.learnyeai.news.service;

import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.core.support.ThreadContext;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.news.mapper.NewsSiteCategoryRelMapper;
import com.learnyeai.news.model.NewsCategory;
import com.learnyeai.news.mapper.NewsCategoryMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.news.model.NewsCategoryArticleRel;
import com.learnyeai.news.model.NewsSiteCategoryRel;
import com.learnyeai.news.util.NewsUtil;
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
 * @author yl
 */
@Service
public class NewsCategoryWyService extends WeyeBaseService<NewsCategory> {

    @Resource
    private NewsCategoryMapper newsCategoryMapper;
    @Resource
    private NewsCategoryArticleRelWyService newsCategoryArticleRelWyService;
    @Resource
    private NewsSiteCategoryRelMapper newsSiteCategoryRelMapper;
    @Resource
    private CurrentUserInfoIml currentUserInfoIml;
    @Resource
    private NewsSiteCategoryRelWyService newsSiteCategoryRelWyService;
    @Override
    public BaseMapper<NewsCategory> getMapper() {
        return newsCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Override
    protected Weekend genSqlExample(NewsCategory t, Map params) {
       Weekend<NewsCategory> w=super.genSqlExample(t,params);
       WeekendCriteria<NewsCategory,Object> c=w.weekendCriteria();
       if(StringUtils.isNotBlank(t.getSiteId())){
           String[] siteId=(t.getSiteId()).split(",");
           List<String> siteIdArr=Arrays.asList(siteId);
           c.andIn(NewsCategory::getSiteId,siteIdArr);
       }
       if(StringUtils.isNotBlank(t.getParentId())){
           c.andEqualTo(NewsCategory::getParentId,t.getParentId());
       }else{
           c.andEqualTo(NewsCategory::getParentId,"0");
       }
       if(StringUtils.isNotBlank(t.getCatId())){
           c.andEqualTo(NewsCategory::getCatId,t.getCatId());
       }
       w.and(c);
       w.setOrderByClause("cat_sort asc");
       return w;
    }

    /**
     * 栏目删除
     * @param nc
     * @return status =0 时删除成功 status =1时栏目下面有咨讯不能删除
     */
    public Map<String,Object> deleteCat(NewsCategory nc){
       Map<String,Object> result=new HashMap();
         String userId=currentUserInfoIml.getId();
        NewsCategoryArticleRel ncar=new NewsCategoryArticleRel();
        ncar.setCatId(nc.getCatId());
        List<NewsCategoryArticleRel> list= newsCategoryArticleRelWyService.queryList(ncar,new HashMap());
        //栏目下面有咨讯不能删除
        if(list.size()>0){
            result.put("status","1");
        }else{
            String[] catIds=(nc.getCatId()).split(",");
            int num=0;
            for(String catId:catIds){
              NewsCategory newsCategory=  super.queryById(catId);
                String siteId= newsCategory.getSiteId();
                super.deleteById(catId);
                newsSiteCategoryRelWyService.deleteByIdAndsiteId(siteId,catId);
                num++;
            }
            result.put("status","0");
            result.put("num",num);
        }
        return result;
    }

    /**
     * status0操作成功 1 栏目下面有咨讯不能修改 2系统异常
     * @param nc
     * @return
     */
    @Transactional
    public Map<String,Object> saveData(NewsCategory nc){
        try{
            Map<String ,Object> map=new HashMap();
            String parentId=nc.getParentId();
            NewsCategory cate=super.queryById(nc.getParentId());
            //新建最上级目录时没有parentIds 默认为0；
            String parentIds;
            if (cate!=null){
                parentIds=cate.getParentIds()+parentId+",";
            }else{
                parentIds="0,";
            }
            nc.setParentIds(parentIds);
            nc.setParentId("0");
            //判断栏目下是否有新闻，有新闻不能更新
            if(StringUtils.isNotBlank(nc.getCatId())){
                NewsCategoryArticleRel ncar=new NewsCategoryArticleRel();
                ncar.setCatId(nc.getCatId());
                List<NewsCategoryArticleRel> list= newsCategoryArticleRelWyService.queryList(ncar,new HashMap());
                if(list.size()>0){
                    //栏目下面有关联数据不能删除 状态为1
                    map.put("status",1);
                    return map;
                }
            }
            String siteId=nc.getSiteId();
            //获取该站点的所有站点信息
            NewsUtil newsUtil=new NewsUtil();
            List<PtsetSiteVo> pts= newsUtil.GetPriSite(siteId);
            NewsSiteCategoryRel nscr=new NewsSiteCategoryRel();
            nscr.setShowStatus("1");
            //新增到栏目表
            super.save(nc);
            nscr.setCatId(nc.getCatId());
            nscr.setCatSort(nc.getCatSort());
            nscr.setCatCrtSite(nc.getSiteId());
            for(PtsetSiteVo pt:pts){
                String sid=pt.getSiteId();
                nscr.setSiteId(sid);
                newsSiteCategoryRelMapper.insertSelective(nscr);
            }
            //操作成功
            map.put("status",0);
            return map;
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            return MapUtil.newMap("status",2);
        }
    }

    /**
     * 查询展示显示的栏目
     * @param nc
     * @return
     */
    public List<NewsCategory> queryShowPage(NewsCategory nc){
        NewsSiteCategoryRel nscr=new NewsSiteCategoryRel();
        nscr.setSiteId(nc.getSiteId());
        MyPage<NewsSiteCategoryRel> page=newsSiteCategoryRelWyService.queryPage(nscr,new HashMap());
        //先查询所有状态为1的列表
        List<NewsCategory> list=  new ArrayList<>();
        List<NewsSiteCategoryRel> relList=page.getList();
        for (NewsSiteCategoryRel ns:relList) {
            NewsCategory cate=super.queryById(ns.getCatId());
            list.add(cate);
        }
        rtnPageList4Report(page);
        return list;
    }



    public static List rtnPageList4Report(MyPage page) {
        if (page.getTotal() > -1L) {
            ThreadContext.put("totalCount", page.getTotal());
        }

        return page.getList();
    }
}
