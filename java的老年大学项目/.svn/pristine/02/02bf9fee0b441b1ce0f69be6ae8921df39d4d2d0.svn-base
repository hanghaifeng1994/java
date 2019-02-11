package com.learnyeai.schoolclass.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.schoolclass.model.ClzSiteCategoryRel;
import com.learnyeai.schoolclass.mapper.ClzSiteCategoryRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author twang
 */
@Service
public class ClzSiteCategoryRelWyService extends WeyeBaseService<ClzSiteCategoryRel> {

    @Resource
    private ClzSiteCategoryRelMapper clzSiteCategoryRelMapper;

    @Override
    public BaseMapper<ClzSiteCategoryRel> getMapper() {
        return clzSiteCategoryRelMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }

    /**
     * 批量显示隐藏 0隐藏 1 显示
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> saveData(IBusinessContext ctx){
        ClzSiteCategoryRel rel=   super.convert2Bean(ctx.getParamMap());
        String[] ids=(rel.getId()).split(",");
        int num=0;
        for (String id:ids){
            rel.setId(id);
            num+= super.save(rel);
        }
        return MapUtil.newMap("num",num);
    }
}
