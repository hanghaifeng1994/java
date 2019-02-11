package com.learnyeai.interact.service;

import com.learnyeai.interact.model.ItaCustExt;
import com.learnyeai.interact.mapper.ItaCustExtMapper;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class ItaCustExtWyService extends WeyeBaseService<ItaCustExt> {

    @Resource
    private ItaCustExtMapper itaCustExtMapper;

    @Override
    public BaseMapper<ItaCustExt> getMapper() {
        return itaCustExtMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(ItaCustExt t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<ItaCustExt,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getCustId())){
            String[] arr=(t.getCustId()).split(",");
            c.andIn(ItaCustExt::getCustId,Arrays.asList(arr));
        }
        w.and(c);
        return w;
    }
}
