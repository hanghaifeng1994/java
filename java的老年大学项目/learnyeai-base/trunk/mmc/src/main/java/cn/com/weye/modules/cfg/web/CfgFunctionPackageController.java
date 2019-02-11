package cn.com.weye.modules.cfg.web;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.modules.cfg.entity.CfgModule;
import cn.com.weye.modules.cfg.service.CfgModuleService;
import cn.com.weye.cons.PtCons;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgFunction;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackage;
import cn.com.weye.modules.cfg.entity.CfgFunctionPackageExt;
import cn.com.weye.modules.cfg.service.CfgFunctionPackageService;
import cn.com.weye.modules.cfg.service.CfgFunctionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgFunctionPackageController.BASE_URL)
public class CfgFunctionPackageController extends MybatisBaseController<CfgFunctionPackage>{

    public static final String BASE_URL = "/cfg/CfgFunctionPackage/";
    private static final String BASE_PATH = "modules/cfg/CfgFunctionPackage";

    @Resource
    private CfgFunctionPackageService cfgFunctionPackageService;
    @Autowired
    private CfgModuleService cfgModuleService;
    @Autowired
    private CfgFunctionService cfgFunctionService;

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
        return "cfg:CfgFunctionPackage";
    }

    @Override
    protected MybatisBaseService<CfgFunctionPackage> getService() {
        return cfgFunctionPackageService;
    }

    @Override
    public String form(CfgFunctionPackage entity, HttpServletRequest request, Model model) {
        // 查询模块所有功能
//        CfgFunction funcPp = new CfgFunction();
//        cfgFunctionService.queryList()
        // 查询选中的功能


        // 查询模块列表
        List<CfgModule> mdlList = cfgModuleService.queryList(new CfgModule());
        model.addAttribute("mdlList", mdlList);
        return super.form(entity, request, model);
    }

    @Override
    public String save(CfgFunctionPackage entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if(entity.getPkgId() == null) {
            entity.setPkgStatus(WeyeCons.CFG_FUNCTION_PACKAGE_STATUS.UNPUB.getVal());
        }
        return super.save(entity, request, redirectAttributes);
    }

    @Override
    public String list(CfgFunctionPackage entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");
        // 查询模块列表
        List<CfgModule> mdlList = cfgModuleService.queryList(new CfgModule());
        model.addAttribute("mdlList", mdlList);
        Page<CfgFunctionPackageExt> page = cfgFunctionPackageService.queryExtPage(entity, new Page<CfgFunctionPackageExt>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }

    /**
     * 选择功能页面
     * @param entity
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("selFuncForm")
    public String selFuncForm(CfgFunctionPackage entity, HttpServletRequest request, Model model) {
        CfgFunctionPackage entry = cfgFunctionPackageService.queryById(entity.getPkgId());
        CfgModule mdl = cfgModuleService.queryById(entry.getMdlId());
        model.addAttribute("mdl", mdl);
        model.addAttribute("entry", entry);

        // 查询模块功能
        CfgFunction funcPP = new CfgFunction();
        funcPP.setMdlId(entry.getMdlId());
        List<CfgFunction> funcList = cfgFunctionService.queryList(funcPP);
        model.addAttribute("funcList", funcList);

        // 查询功能包选择的功能
        List<CfgFunction> selFuncList = cfgFunctionService.queryPkgFunctionList(entry.getPkgId());
        StringBuffer sb = new StringBuffer();
        for (CfgFunction func : selFuncList){
            sb.append(func.getFuncId()).append(",");
        }
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);

        model.addAttribute("funcIds", sb.toString());
        return getBasePath() + "Func";
    }

    @RequestMapping("selFunc")
    public String selFunc(String pkgId, String funcIds, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        CfgFunctionPackage entry = cfgFunctionPackageService.queryById(pkgId);
        String[] idArr = StringUtils.split(funcIds, ",");
        List<String> idList = new ArrayList<String>();
        // 去掉根节点
        for(int i=idArr.length-1; i>=0; i--){
            if(!"1".equals(idArr[i])){
                idList.add(idArr[i]);
            }
        }
        cfgFunctionPackageService.savePkgFunc(pkgId, idList);
        redirectAttributes.addAllAttributes(getFixParams(request));
        return repageListPath;
    }
    @RequestMapping("pub")
    public String pub(String id, String status, HttpServletRequest request, RedirectAttributes redirectAttributes){
        cfgFunctionPackageService.updateStatus(id, status);
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "1".equals(status)?"发布成功" : "成功取消发布");
        return repageListPath;
    }
}
