package cn.com.weye.modules.sh.web;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgAddedService;
import cn.com.weye.modules.sh.entity.ShMerchant;
import cn.com.weye.modules.sh.service.ShMerchantService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  商户管理
 * @author yl
 */
@Controller
@RequestMapping("${adminPath}" + ShMerchantController.BASE_URL)
public class ShMerchantController extends MybatisBaseController<ShMerchant>{

    public static final String BASE_URL = "/sh/ShMerchant/";
    private static final String BASE_PATH = "modules/sh/ShMerchant";

    @Resource
    private ShMerchantService shMerchantService;

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
        return "sh:ShMerchant";
    }

    @Override
    protected MybatisBaseService<ShMerchant> getService() {
        return shMerchantService;
    }

    @Override
    public String list(ShMerchant entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");
        Page<ShMerchant> page = shMerchantService.queryExtPage(entity, new Page<ShMerchant>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }

    @RequestMapping("startOrForbiddenUse")
    public String startOrForbiddenUse(ShMerchant entity, HttpServletRequest request, RedirectAttributes redirectAttributes){
        logger.info("商户禁用数据开始");
        try{
            shMerchantService.startOrForbiddenUse(entity);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("系统异常！！");
        }
        String mchtId=entity.getMchtId();
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes,  "1".equals(entity.getMchtStatus())?"禁用成功" : "启用成功");
        return repageListPath;
    }

    @RequestMapping("toManager")
    public  String toManager(ShMerchant entity, HttpServletRequest request, Model model){
        model.addAttribute("entry", entity);
        return getBasePath() + "ToManager";
    }
    @RequestMapping("myShMerchant")
    public String myShMerchant(ShMerchant entity, HttpServletRequest request, HttpServletResponse response, Model model){
        String userId= UserUtils.getUser().getId();
        entity.setClientManagerId(userId);
        Page<ShMerchant> page = shMerchantService.queryExtPage(entity, new Page<ShMerchant>(request, response));
        model.addAttribute("isManager","yes");
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }
}
