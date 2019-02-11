package cn.com.weye.modules.sh.web;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.*;
import cn.com.weye.modules.cfg.service.*;
import cn.com.weye.modules.sh.entity.*;
import cn.com.weye.modules.sh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 *商户方案
 * @author yl
 */

@Controller
@RequestMapping("${adminPath}" + ShMerchantSchemeController.BASE_URL)
public class ShMerchantSchemeController extends MybatisBaseController<ShMerchantScheme> {

    public static final String BASE_URL = "/sh/ShMerchantScheme/";
    private static final String BASE_PATH = "modules/sh/ShMerchantScheme";
    @Resource
    private ShAppletSettingService shAppletSettingService;
    @Resource
    private ShMerchantSchemeService shMerchantSchemeService;
    @Autowired
    private CfgSchemeEditionService schemeEditionService;
    @Autowired
    private CfgSchemeService schemeService;
    @Autowired
    private ShMerchantService shMerchantService;
    @Autowired
    private CfgSchmEdtPackageService cfgSchmEdtPackageService;
    @Autowired
    private CfgAddedServiceService cfgAddedServiceService;
    @Autowired
    private ShOrderService shOrderService;
    @Autowired
    private CfgFunctionPackageService functionPackageService;
    @Autowired
    private ShActivityService shActivityService;
    @Override
    protected String getBaseUrl() {
        return BASE_URL;
    }

    @Override
    protected String getBasePath() {
        return BASE_PATH;
    }

    @Override
    protected MybatisBaseService<ShMerchantScheme> getService() {
        return shMerchantSchemeService;
    }

    @Override
    public String list(ShMerchantScheme entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");
//        Page<Map> page = shMerchantSchemeService.queryCodePage(entity, new Page<Map>(request, response));
        Page<ShMerchantSchemeExt> page = shMerchantSchemeService.queryExtPage(entity, new Page<ShMerchantSchemeExt>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }
    @Override
    public String save(ShMerchantScheme entity, HttpServletRequest request, RedirectAttributes redirectAttributes){
        super.save(entity,request,redirectAttributes);
        entity.setMchtSchmStatus("0");
        //向商户小程序配置表中插入数据
        shAppletSettingService.insertIntoShAppSet(entity);
        return repageListPath;
    }
    /**
     * 商户方案的禁用及启用
     *
     * @param entity
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("startOrForbiddenUse")
    public String startOrForbiddenUse(ShMerchantScheme entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        logger.info("商户方案禁用或启用数据开始");
        try {
            shMerchantSchemeService.startOrForbiddenUse(entity);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("商户方案禁用或启用异常！");
        }
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "1".equals(entity.getMchtSchmStatus()) ? "禁用成功" : "启用成功");
        return repageListPath;
    }


    @Override
    public String form(ShMerchantScheme entity, HttpServletRequest request, Model model) {
        super.form(entity, request, model);
        // 方案列表
        CfgScheme cf =new CfgScheme();
        cf.setSchmStatus("1");
        List<CfgScheme> schemeList = schemeService.queryByCriteria(cf);
        //查询所有已发布商户列表
        ShMerchant sh= new ShMerchant();
        sh.setMchtStatus("1");
        List<ShMerchant> shMerchantList = shMerchantService.queryByCriteria(sh);
        // 获取方案版本id
        String schmEdtId = entity.getSchmEdtId();
        if(entity.getMchtSchmId()!=null){
            model.addAttribute("schmId",request.getParameter("schmId"));
            model.addAttribute("schmEdtName",request.getParameter("schmEdtName"));
            model.addAttribute("mchtName",request.getParameter("mchtName"));
        }
        //方案版本列表
        List<Map<String, Object>> mapList = shMerchantSchemeService.getEditionList(schmEdtId);
        //获取增值服务列表
        List<CfgAddedService> serviceList=cfgAddedServiceService.queryList(new CfgAddedService());
        model.addAttribute("schemeList", schemeList);
        model.addAttribute("mapList", mapList);
        model.addAttribute("shMerchantList", shMerchantList);
        model.addAttribute("serciceList",serviceList);
        model.addAttribute("entry",entity);
        return getBasePath() + "Form";
    }

    /**
     * 根据方案id 查询方案版本
     *
     * @param c
     * @return
     */
    @ResponseBody
    @RequestMapping("getSchmId")
    public List<CfgSchemeEdition> getSchmId(CfgSchemeEdition c) {
        c.setSchmEdtStatus("1");
        List<CfgSchemeEdition> list=schemeEditionService.queryByCriteria(c);
        return list;
    }

    /**
     * 创建订单
     * @param entity
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("createOreder")
    public String createOrder(ShMerchantSchemeExt entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        boolean flag=shMerchantSchemeService.toGenerateOrder(entity,request,redirectAttributes);
        redirectAttributes.addAllAttributes(getFixParams(request));
        String message;
        if(flag){
            message="缴费成功且成功生成新订单";
        }else{
            message="缴费异常，请联系管理员！";
        }
        addMessage(redirectAttributes, message);
        return repageListPath;
    }

    /**
     * 跳转到缴费页面
     * @param entity
     * @param model
     * @param request
     * @param redirectAttributes
     * @return
     */
   @RequestMapping("toPayment")
    public String  toPayment(ShMerchantSchemeExt entity,Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
       checkPermission("view");
       logger.info("------------开始查询缴费所需的参数-----------");
       entity=shMerchantSchemeService.querySchemeByMchtSchmId(entity);
       //根据方案版本id查询出所有增值包
       List<CfgSchmEdtPackageExt> increasePaklist= cfgSchmEdtPackageService.queryPkNameByCriteriaExt(entity.getSchmEdtId());
       //查询出所有增值服务
       List<CfgAddedService> serviceList=cfgAddedServiceService.queryList(new CfgAddedService());
       //查询所有活动
        List<ShActivity> acList=shActivityService.queryByCriteria(new ShActivity());
       model.addAttribute("entry", entity);
       model.addAttribute("serviceList",serviceList);
       model.addAttribute("increasePaklist",increasePaklist);
       model.addAttribute("acList",acList);
       return getBasePath()+"Payment";
   }

    /**
     * 查看商户方案详情
     * @param entity
     * @param model
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("view")
    public String view(ShMerchantSchemeExt entity,Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
        logger.info("------------查看商户方案详情-----------");
        ShMerchantSchemeExt a=shMerchantSchemeService.querySchemeByMchtSchmId(entity);
        model.addAttribute("entry",a);
        return getBasePath()+"View";
    }

}

