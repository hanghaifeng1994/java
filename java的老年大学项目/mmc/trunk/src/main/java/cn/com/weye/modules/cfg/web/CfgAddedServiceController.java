package cn.com.weye.modules.cfg.web;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgAddedService;
import cn.com.weye.modules.cfg.service.CfgAddedServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author yl
 */
@Controller
@RequestMapping("${adminPath}" + CfgAddedServiceController.BASE_URL)
public class CfgAddedServiceController extends MybatisBaseController<CfgAddedService>{

    public static final String BASE_URL = "/cfg/CfgAddedService/";
    private static final String BASE_PATH = "modules/cfg/CfgAddedService";

    @Resource
    private CfgAddedServiceService cfgAddedServiceService;

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
        return "cfg:CfgAddedService";
    }

    @Override
    protected MybatisBaseService<CfgAddedService> getService() {
        return cfgAddedServiceService;
    }
    @Override
    public String list(CfgAddedService entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");
        Page<CfgAddedService> page = cfgAddedServiceService.queryExtPage(entity, new Page<CfgAddedService>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }
}
