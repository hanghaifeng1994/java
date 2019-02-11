package com.learnyeai.album.service;

import com.learnyeai.album.mapper.AbmSiteCategoryRelMapper;
import com.learnyeai.album.model.AbmCategory;
import com.learnyeai.album.mapper.AbmCategoryMapper;
import com.learnyeai.album.model.AbmSiteCategoryRel;
import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.CurrentBaseInfoUtil;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AbmCategoryWyService extends WeyeBaseService<AbmCategory> {

    @Resource
    private AbmCategoryMapper abmCategoryMapper;
    @Resource
    private AbmSiteCategoryRelWyService abmSiteCategoryRelWyService;
    @Resource
    private AbmSiteCategoryRelMapper abmSiteCategoryRelMapper;
    @Autowired
    private BaseInfoDao baseInfoDao;

    @Override
    public BaseMapper<AbmCategory> getMapper() {
        return abmCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Override
    protected Weekend<AbmCategory> genSqlExample(AbmCategory t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<AbmCategory,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getSiteId())){
            String[] arr=(t.getSiteId()).split(",");
            c.andIn(AbmCategory::getSiteId, Arrays.asList(arr));
        }
        w.and(c);
        w.setOrderByClause("CREATE_DATE desc");
        return w;
    }


    /**
     * @param ctx
     * @return status：0正常 1分类下面有关联数据不能修改
     */
    @Transactional
    public Map<String,Object> saveData(IBusinessContext ctx){
        AbmCategory a=super.convert2Bean(ctx.getParamMap());
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isNotBlank(a.getCatId())){
            AbmSiteCategoryRel r=new  AbmSiteCategoryRel();
            r.setCatId(a.getCatId());
            List<AbmSiteCategoryRel> l= abmSiteCategoryRelWyService.queryList(r,new HashMap());
            if(l.size()>0){
                map.put("status","1");
                return map;
            }
        }
        super.save(a);
        a=super.queryById(a.getCatId());
        //查询该站点下所包含的子站点
       List<PtsetSiteVo> sites= SiteUtils.getPubSites(a.getSiteId());
        AbmSiteCategoryRel s=new AbmSiteCategoryRel();
        s.setCatCrtSiteId(a.getSiteId());
        s.setCatId(a.getCatId());
        s.setShowStatus("1");
        for (PtsetSiteVo pt:sites){
           s.setSiteId(pt.getSiteId());
            abmSiteCategoryRelMapper.insertSelective(s);
       }
       map.put("status",0);
        return map;
    }

    /**
     * 批量删除
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> delBatch(IBusinessContext ctx){
        AbmCategory a= super.convert2Bean(ctx.getParamMap());
        String[] ids=(a.getCatId()).split(",");
        int num=0;
        for (String id:ids){
            //先删除分类表中数据再删除关联表中数据
         num+=super.deleteById(id);
            //删除关联表数据
            abmSiteCategoryRelMapper.deleteByCatIds(id);
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 通过站点id查询出站点所包含的子站点
     */
    public List<PtsetSiteVo> GetPriSite(String siteId){
        List<PtsetSiteVo> list=new ArrayList<>();
        PtsetSiteVo vo= baseInfoDao.querySite(siteId);
        if("1".equals(vo.getSiteType())){
//            baseInfoDao.querySitesByPt(siteId);
            //查询平台id
            String ptId=vo.getPtId();
            list=  baseInfoDao.querySitesByPt(ptId);
        }else{
            list.add(vo);
        }
        return list;
    }

}
