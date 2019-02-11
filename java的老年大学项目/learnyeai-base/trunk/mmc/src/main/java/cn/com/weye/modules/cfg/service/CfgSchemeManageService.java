package cn.com.weye.modules.cfg.service;

import cn.com.weye.modules.cfg.entity.CfgScheme;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.vo.CfgSchemeEditionVo;
import cn.com.weye.modules.cfg.vo.CfgSchemeVo;
import cn.com.weye.tools.common.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpz on 2017/12/4.
 */
@Service
public class CfgSchemeManageService {
    @Autowired
    private CfgSchemeService schemeService;
    @Autowired
    private CfgSchemeEditionService schemeEditionService;

    /**
     * 查询所有方案
     * @return
     */
    public List<CfgSchemeVo> queryAllScheme(){
        List<CfgScheme> schemes = schemeService.queryList(new CfgScheme());
        List<CfgSchemeEdition> schemeEditions = schemeEditionService.queryList(new CfgSchemeEdition());
        List<CfgSchemeVo> rstList = new ArrayList<CfgSchemeVo>();
        for (CfgScheme scheme : schemes){
            CfgSchemeVo schemeVo = new CfgSchemeVo();
            BeanHelper.copy(scheme, schemeVo);
            for (CfgSchemeEdition schemeEdition : schemeEditions){
                if(!scheme.getSchmId().equals(schemeEdition.getSchmId()))
                    continue;
                CfgSchemeEditionVo schemeEditionVo = new CfgSchemeEditionVo();
                BeanHelper.copy(schemeEdition, schemeEditionVo);
                schemeVo.getSchemeEditionVos().add(schemeEditionVo);
            }

            rstList.add(schemeVo);
        }
        return rstList;
    }
}
