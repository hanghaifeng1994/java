package com.learnyeai.trainmanage.service;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.trainmanage.model.ClzSiteCategoryRel;
import com.learnyeai.trainmanage.mapper.ClzSiteCategoryRelMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author yl
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

    public Map<String,Object> showAndHideBatch(IBusinessContext ctx){
        ClzSiteCategoryRel cscr = super.convert2Bean(ctx.getParamMap());
        List<ClzSiteCategoryRel> list = cscr.getList();
        int num = 0;
        if(list !=null && list.size()>0){
            for (ClzSiteCategoryRel cscrl:list){
                num += clzSiteCategoryRelMapper.updateByPrimaryKeySelective(cscr);
            }
        }
        return MapUtil.newMap("num",num);
    }

}
