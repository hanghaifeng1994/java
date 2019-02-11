package cn.com.weye.modules.cfg.web;

import cn.com.weye.modules.cfg.entity.CfgModule;
import cn.com.weye.modules.cfg.service.CfgModuleService;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgModuleVersion;
import cn.com.weye.modules.cfg.service.CfgModuleVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgModuleVersionController.BASE_URL)
public class CfgModuleVersionController extends MybatisBaseController<CfgModuleVersion>{

    public static final String BASE_URL = "/cfg/CfgModuleVersion/";
    private static final String BASE_PATH = "modules/cfg/CfgModuleVersion";

    @Resource
    private CfgModuleVersionService cfgModuleVersionService;
    @Autowired
    private CfgModuleService cfgModuleService;

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
        return "cfg:CfgModuleVersion";
    }

    @Override
    protected MybatisBaseService<CfgModuleVersion> getService() {
        return cfgModuleVersionService;
    }

    @Override
    public String list(CfgModuleVersion entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        // 查询所有模块
        List<CfgModule> list = cfgModuleService.queryList(new CfgModule());
        model.addAttribute("mdlList", list);
        return super.list(entity, request, response, model);
    }

    @Override
    public String form(CfgModuleVersion entity, HttpServletRequest request, Model model) {
        // 查询所有模块
        List<CfgModule> list = cfgModuleService.queryList(new CfgModule());
        model.addAttribute("mdlList", list);
        return super.form(entity, request, model);
    }

    /**
     * 模块版本只会添加
     * @param entity
     * @param request
     * @param redirectAttributes
     * @return
     */
    @Override
    public String save(CfgModuleVersion entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        checkPermission("edit");

        if(entity.getMdlVerId() != null)
            throw new RuntimeException();

        cfgModuleVersionService.addVersion(entity);

        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));
        return repageListPath;
    }
}
