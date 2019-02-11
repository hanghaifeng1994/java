package com.learnyeai.base.api.service;

import com.learnyeai.base.api.client.PtsetSiteClient;
import com.learnyeai.base.api.vo.PtsetSiteVo;
import com.learnyeai.core.support.BaseFeignClient;
import com.learnyeai.learnai.support.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangpz
 */
@Service
public class PtsetSiteApiService extends BaseClientService<PtsetSiteVo> {
    @Autowired
    private PtsetSiteClient ptsetSiteClient;

    @Override
    public BaseFeignClient<PtsetSiteVo> getFeignClient() {
        return ptsetSiteClient;
    }

    @Override
    public Object getId(Map params) {
        String idKey = "siteId";
        if(params.containsKey(idKey)){
        return params.get(idKey);
        }
        return null;
    }
    List<PtsetSiteVo> queryByPt(String ptId){
        return ptsetSiteClient.queryByPt(ptId);
    }

}
