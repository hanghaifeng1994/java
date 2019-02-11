package cn.com.weye.modules.cfg.web;

import cn.com.weye.modules.cfg.service.CfgSchemeService;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.core.utils.ConfigEnum;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgModule;
import cn.com.weye.modules.cfg.service.CfgModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgModuleController.BASE_URL)
public class CfgModuleController extends MybatisBaseController<CfgModule>{

    public static final String BASE_URL = "/cfg/CfgModule/";
    private static final String BASE_PATH = "modules/cfg/CfgModule";

    @Resource
    private CfgModuleService cfgModuleService;
    @Autowired
    private CfgSchemeService cfgSchemeService;

    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected String getBasePath() {
        return BASE_PATH;
    }

    @Override
    protected String getBasePermission() {
        return "cfg:CfgModule";
    }

    @Override
    protected MybatisBaseService<CfgModule> getService() {
        return cfgModuleService;
    }


    @Override
    public String save(CfgModule entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        // 添加默认为，没有启用
        if(entity.getMdlId() == null){
            entity.setMdlStatus(ConfigEnum.DISABLE);
        }
        return super.save(entity, request, redirectAttributes);
    }

}
