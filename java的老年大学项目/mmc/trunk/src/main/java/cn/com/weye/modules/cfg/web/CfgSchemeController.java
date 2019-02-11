package cn.com.weye.modules.cfg.web;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.core.utils.ConfigEnum;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgModule;
import cn.com.weye.modules.cfg.entity.CfgScheme;
import cn.com.weye.modules.cfg.service.CfgModuleService;
import cn.com.weye.modules.cfg.service.CfgSchemeService;
import cn.com.weye.tools.common.MapUtil;
import com.thinkgem.jeesite.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgSchemeController.BASE_URL)
public class CfgSchemeController extends MybatisBaseController<CfgScheme>{

    public static final String BASE_URL = "/cfg/CfgScheme/";
    private static final String BASE_PATH = "modules/cfg/CfgScheme";

    @Resource
    private CfgSchemeService cfgSchemeService;

    @Autowired
    private CfgModuleService moduleService;

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
        return "cfg:CfgScheme";
    }

    @Override
    protected MybatisBaseService<CfgScheme> getService() {
        return cfgSchemeService;
    }

    @Override
    public String save(CfgScheme entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        entity.setSchmStatus(WeyeCons.CFG_SCHEME_STATUS.UNPUB.getVal());
        return super.save(entity, request, redirectAttributes);
    }

    /**
     * 进入分配模块页面
     * @param
     * @return
     */
    @RequestMapping("assignMdlForm")
    public String assignMdlForm(Model model, HttpServletRequest request){
        checkPermission("edit");
        CfgScheme entry = cfgSchemeService.queryById(getId(request));
        model.addAttribute("entry", entry);

        List<Map> mdlList = moduleService.queryBySchmId(entry.getSchmId());
        // 查找模块列表
        model.addAttribute("mdlList", mdlList);
        return getBasePath() + "MdlAssign";
    }

    /**
     * 选择图片
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("selectMdl")
    public String selectMdl(Model model, HttpServletRequest request){

        String schmId = getId(request);
        List<CfgModule> selList = moduleService.queryUnSelMdlBySchmId(schmId);

        // 查找模块列表
        model.addAttribute("selList", selList);
        return getBasePath() + "MdlSel";
    }

    /**
     * 分配模块
     * @param request
     * @param redirectAttributes
     * @return
     */
//    @RequestMapping("assignMdl") // 暂不用
    public String assignMdl(HttpServletRequest request, RedirectAttributes redirectAttributes){
        checkPermission("edit");
        String id = getId(request);
        Map<String, Object> pp = WebUtils.getParametersStartingWith(request, null);
        String ids = MapUtil.getMapValue(pp, "idsArr", "");

        List idList = new ArrayList();
        if(ids != null && ids.length() > 0){
            String[] idArr = ids.split(",");
            idList = Arrays.asList(idArr);
        }
        cfgSchemeService.updateSchmMdl(id, idList);

        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "已成功配置模块");

        return "redirect:" + "assignMdlForm?id=" + id;
    }
    @RequestMapping("addMdl")
    public String addMdl(HttpServletRequest request, RedirectAttributes redirectAttributes){
        checkPermission("edit");
        String id = getId(request);
        Map<String, Object> pp = WebUtils.getParametersStartingWith(request, null);
        String ids = MapUtil.getMapValue(pp, "idsArr", "");

        List idList = new ArrayList();
        if(ids != null && ids.length() > 0){
            String[] idArr = ids.split(",");
            idList = Arrays.asList(idArr);
        }
        cfgSchemeService.addSchmMdl(id, idList);

        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "成功添加模块");

        return "redirect:" + "assignMdlForm?id=" + id;
    }

    @RequestMapping("updateMdlSort")
    public String updateMdlSort(String schmId, String[] mdlIds, Integer[] sorts, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        cfgSchemeService.updateSchemeMdlSorts(schmId,mdlIds, sorts);

        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "保存功能排序成功!");
        return "redirect:" + Global.getAdminPath() + getBaseUrl() + "assignMdlForm";
    }

    /**
     * 删除模块
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("delMdl")
    public String delMdl( String schmId, String mdlId, HttpServletRequest request, RedirectAttributes redirectAttributes){

        redirectAttributes.addAllAttributes(getFixParams(request));
        try{
            cfgSchemeService.delSchemeMdl(schmId, mdlId);
        }catch (Exception e){
            addMessage(redirectAttributes, "删除方案模块失败，方案模块已被使用!");
            return "redirect:" + Global.getAdminPath() + getBaseUrl() + "assignMdlForm";
        }

        addMessage(redirectAttributes, "删除方案模块成功!");
        return "redirect:" + Global.getAdminPath() + getBaseUrl() + "assignMdlForm";
    }
    @RequestMapping("enable")
    public String enable(CfgScheme scheme, HttpServletRequest request, RedirectAttributes redirectAttributes){
        cfgSchemeService.updateStatus(scheme.getSchmId(), scheme.getSchmStatus());
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "1".equals(scheme.getSchmStatus())?"发布成功" : "成功取消发布");
        return repageListPath;
    }

    // 查询所有行业方案列表
    @ResponseBody
    @RequestMapping("getListJson")
    public List getSchmeListJson(){
        List<CfgScheme> schemeList = cfgSchemeService.queryList(new CfgScheme());
        List rstList = new ArrayList();
        for(CfgScheme it : schemeList){
            Map o = MapUtil.newMap(
                    CfgScheme.TF.schmId, it.getSchmId(),
                    CfgScheme.TF.schmName, it.getSchmName(),
                    CfgScheme.TF.schmIndustry, it.getSchmIndustry()
            );
            rstList.add(o);
        }


        return rstList;
    }


}
