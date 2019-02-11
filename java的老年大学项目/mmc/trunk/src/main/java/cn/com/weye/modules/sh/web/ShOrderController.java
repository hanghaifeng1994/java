package cn.com.weye.modules.sh.web;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgAddedService;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackageExt;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionExt;
import cn.com.weye.modules.cfg.service.CfgAddedServiceService;
import cn.com.weye.modules.cfg.service.CfgFunctionPackageService;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionService;
import cn.com.weye.modules.sh.entity.ShActivity;
import cn.com.weye.modules.sh.entity.ShOrder;
import cn.com.weye.modules.sh.entity.ShOrderExt;
import cn.com.weye.modules.sh.service.ShActivityService;
import cn.com.weye.modules.sh.service.ShOrderPackageService;
import cn.com.weye.modules.sh.service.ShOrderService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
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
 * @author yl
 */
@Controller
@RequestMapping("${adminPath}" + ShOrderController.BASE_URL)
public class ShOrderController extends MybatisBaseController<ShOrder>{

    public static final String BASE_URL = "/sh/ShOrder/";
    private static final String BASE_PATH = "modules/sh/ShOrder";

    @Resource
    private ShOrderService shOrderService;

    @Autowired
    private CfgSchemeEditionService cfgSchemeEditionService;
    @Autowired
    private ShActivityService shActivityService;
    @Autowired
    private CfgAddedServiceService cfgAddedServiceService;
    @Autowired
    private CfgFunctionPackageService functionPackageService;
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
        return "sh:ShOrder";
    }

    @Override
    protected MybatisBaseService<ShOrder> getService() {
        return shOrderService;
    }

    @Override
    public String list(ShOrder entity , HttpServletRequest request, HttpServletResponse response, Model model){
        checkPermission("view");
        Page<ShOrderExt> page=shOrderService.queryCriteriaExt(entity,new Page<ShOrderExt>(request,response));
        //查询出订单所包含所有的方案版本
        List<CfgSchemeEditionExt> list=cfgSchemeEditionService.queryAllSchemeByCriteriaExt();
        model.addAttribute("list",list);
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }

    /**
     * 跳转作废页面
     * @param entity
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("toInvalid")
    public String toInvalid(ShOrder entity,HttpServletRequest request,Model model){
        super.form(entity,request,model);
        return getBasePath()+"Invalid";
    }
    @RequestMapping("invalid")
    public String invalid(ShOrder entity, HttpServletRequest request, Model model, RedirectAttributes rectAttributes){
        String userName= UserUtils.getUser().getName();
        entity.setOrdCancelUsername(userName);
        entity.setOrdStatus("1");
        super.save(entity,request,rectAttributes);
        return getBasePath()+"List";
    }
    @Override
    public String form(ShOrder entity,HttpServletRequest request,Model model){
        super.form(entity,request,model);
        //通过订单id查询增值包
     List<CfgFunctionPackageExt> shOrderPackages=  functionPackageService.getPkQueryByOrdId(entity.getOrdId());
        // 通过订单id查询增值服务
        List<CfgAddedService> addedServies=cfgAddedServiceService.queryByOrdId(entity.getOrdId());
        //通过活动id查询活动
        ShActivity ac= shActivityService.queryById(entity.getActId());
        model.addAttribute("spList",shOrderPackages);
        model.addAttribute("asList",addedServies);
        model.addAttribute("ac",ac);
        return getBasePath()+"Form";
    }
    @RequestMapping("myShOrder")
    public String myShOrder(ShOrder entity , HttpServletRequest request, HttpServletResponse response, Model model){
       String userId=UserUtils.getUser().getId();
       entity.setClientManagerId(userId);
        Page<ShOrderExt> page=shOrderService.queryCriteriaExt(entity,new Page<ShOrderExt>(request,response));
        //查询出订单所包含所有的方案版本
        List<CfgSchemeEditionExt> list=cfgSchemeEditionService.queryAllSchemeByCriteriaExt();
        model.addAttribute("isManager","yes");
        model.addAttribute("list",list);
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }
}
