package com.learnyeai.trainmanage.service;


import com.learnyeai.base.api.bean.BaseInfoDao;
import com.learnyeai.base.api.util.SiteUtils;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.trainmanage.model.ClzCategory;
import com.learnyeai.trainmanage.mapper.ClzCategoryMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.trainmanage.model.ClzSiteCategoryRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import com.learnyeai.trainmanage.mapper.ClzSiteCategoryRelMapper;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
 */
@Service
public class ClzCategoryWyService extends WeyeBaseService<ClzCategory> {
    @Autowired
    private BaseInfoDao baseInfoDao;

    @Resource
    private ClzCategoryMapper clzCategoryMapper;

    @Override
    public BaseMapper<ClzCategory> getMapper() {
        return clzCategoryMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }

    @Resource
    private ClzSiteCategoryRelMapper clzSiteCategoryRelMapper;

    @Override
    protected Weekend<ClzCategory> genSqlExample(ClzCategory cc,Map params){
        Weekend w=super.genSqlExample(cc,params);
        WeekendCriteria<ClzCategory,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(cc.getCatId())){
            c.andEqualTo(ClzCategory::getCatId,cc.getCatId());
        }
        if(StringUtils.isNotBlank(cc.getSiteId())){
            c.andEqualTo(ClzCategory::getSiteId,cc.getSiteId());
        }
        w.and(c);
        return w;
    }


    @Transactional
    public Map<String,Object> saveDate(IBusinessContext ctx){
        ClzCategory ccg = super.convert2Bean(ctx.getParamMap());
        boolean flag = true;
        if(StringUtils.isNotBlank(ccg.getCatId())){
            flag = false;
        }

        super.save(ccg);

        if(flag){
            String siteId =ccg.getSiteId();
            List<PtsetSiteVo> list = SiteUtils.getPubSites(siteId);
            ClzSiteCategoryRel cscr = new ClzSiteCategoryRel();

            cscr.setCatId(ccg.getCatId());
            cscr.setCatCrtSiteId(ccg.getSiteId());
            cscr.setShowStatus("1");
            for(PtsetSiteVo pt:list){
                cscr.setSiteId(pt.getSiteId());
                clzSiteCategoryRelMapper.insertSelective(cscr);
            }

        }

        return null;

    }



    @Transactional
    public Map<String,Object> delBatch(IBusinessContext ctx){
        ClzCategory ccg = super.convert2Bean(ctx.getParamMap());
        String[] ids = (ccg.getCatId()).split(",");
        int num = 0;
        for(String id:ids){
            ClzSiteCategoryRel cscr = new ClzSiteCategoryRel();
            cscr.setCatId(id);
            cscr.setSiteId(ccg.getSiteId());
            num += super.deleteById(id);
            clzSiteCategoryRelMapper.delete(cscr);
        }
        return MapUtil.newMap("num",num);
    }





}
