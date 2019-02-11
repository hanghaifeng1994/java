package cn.com.weye.modules.cfg.web;

import cn.com.weye.core.exception.CannotDeleteException;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionPrice;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionPriceService;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *  版本jiage
 * @author yl.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgSchemeEditionPriceController.BASE_URL)
public class CfgSchemeEditionPriceController extends MybatisBaseController<CfgSchemeEditionPrice>{

    public static final String BASE_URL = "/cfg/CfgSchemeEditionPrice/";
    private static final String BASE_PATH = "modules/cfg/CfgSchemeEditionPrice";

    @Resource
    private CfgSchemeEditionPriceService cfgSchemeEditionPriceService;

    @Resource
    CfgSchemeEditionService cfgSchemeEditionService;

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
        return "cfg:CfgSchemeEditionPrice";
    }

    @Override
    protected MybatisBaseService<CfgSchemeEditionPrice> getService() {
        return cfgSchemeEditionPriceService;
    }

    @RequestMapping("priceManger")
    public String priceManger(Model model, HttpServletRequest request){
        String schmEdtId=request.getParameter("schmEdtId");
        List<CfgSchemeEditionPrice> priList = cfgSchemeEditionPriceService.queryPriceListById(schmEdtId);
        //查询是否存在启用状态的数据
        Integer count=cfgSchemeEditionPriceService.getIsUsing(schmEdtId);
        model.addAttribute("priList", priList);
        model.addAttribute("count",count);
        request.setAttribute("schmEdtId",schmEdtId);
        return getBasePath()+"List";
    }

    @Override
    public String save(CfgSchemeEditionPrice entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        checkPermission("edit");
        try {
            getRequestParams(true, entity, request, redirectAttributes);
        } catch (Exception e) {
            logger.error("获取表单数据异常", e);
            addMessage(redirectAttributes, MSG_FAILURE);
            return form(entity, request, redirectAttributes);
        }
        getService().save(entity);
        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));
        String schmEdtId=entity.getSchmEdtId();
        request.setAttribute("schmEdtId",schmEdtId);
        return "redirect:" + "priceManger?schmEdtId=" + schmEdtId;
    }

    @Override
    public String form(CfgSchemeEditionPrice entity, HttpServletRequest request, Model model) {
        checkPermission("view");
        if(model instanceof RedirectAttributes) {
            return getBasePath() + "Form";
        }
        try {
            getRequestParams(true, entity, request, model);
        } catch (Exception e) {
            logger.error("获取表单数据异常", e);
            addMessage(model, MSG_FAILURE);
            return getBasePath() + "List";
        }
        String id = getId(request);
        CfgSchemeEditionPrice entry = null;
        if(null != id && !id.isEmpty()) {
//            entry = getService().queryById(id);
            entry = queryById(id); // 给子类自定义机会， 张配忠修改 20151112
        }
        if(null == entry) {
            entry = entity;
        }
        String schmEdtId=request.getParameter("schmEdtId");
        model.addAttribute("schmEdtId",schmEdtId);
        model.addAttribute("entry", entry);
        return getBasePath() + "Form";
    }
    @Override
    public String delete(CfgSchemeEditionPrice entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        checkPermission("edit");
        redirectAttributes.addAllAttributes(getFixParams(request));
        String id = getId(request);
        try {
            getService().deleteById(id);
            addMessage(redirectAttributes, MSG_SUCC_FINISH);
            String schmEdtId=request.getParameter("schmEdtId");
            return  "redirect:" + "priceManger?schmEdtId=" + schmEdtId;
        } catch (CannotDeleteException e) {
            List<String> msgList = e.getRelaMsgList();
            addMessage(redirectAttributes, "不能直接删除，原因为：<br/>" + StringUtils.collectionToDelimitedString(msgList, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;"));
            return repageListPath;
        }
    }
    @RequestMapping("startOrForbiddenUse")
    public String startOrForbiddenUse(CfgSchemeEditionPrice entity, HttpServletRequest request){
        logger.info("版本价格禁用或启用开始");
        //查询该方案版本下是否有方案价格已经被启用
        try{
            Map<String,Object> map=cfgSchemeEditionPriceService.startOrForbiddenUse(entity);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("禁用或启用失败");
        }
        String schmEdtId=entity.getSchmEdtId();
        return "redirect:" + "priceManger?schmEdtId=" + schmEdtId;
    }

}
