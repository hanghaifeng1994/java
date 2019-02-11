package cn.com.weye.modules.cfg.web;

import cn.com.weye.cons.PtCons;
import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.exception.CannotDeleteException;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.core.utils.ConfigEnum;
import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.*;
import cn.com.weye.modules.cfg.service.*;
import cn.com.weye.tools.common.MapUtil;
import cn.com.weye.tools.common.StringUtils;
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
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgSchemeEditionController.BASE_URL)
public class CfgSchemeEditionController extends MybatisBaseController<CfgSchemeEdition>{

    public static final String BASE_URL = "/cfg/CfgSchemeEdition/";
    private static final String BASE_PATH = "modules/cfg/CfgSchemeEdition";

    @Resource
    private CfgSchemeEditionService cfgSchemeEditionService;
    @Autowired
    private CfgSchemeService schemeService;
    @Autowired
    private CfgAppletService cfgAppletService;

    @Resource
    private CfgSchmEdtPackageService cfgSchmEdtPackageService;

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
        return "cfg:CfgSchemeEdition";
    }

    @Override
    protected MybatisBaseService<CfgSchemeEdition> getService() {
        return cfgSchemeEditionService;
    }

    @Override
    public String save(CfgSchemeEdition entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if(StringUtils.isBlank(entity.getSchmEdtId())) {
            entity.setSchmEdtGrade(0l);
            entity.setSchmEnableStatus(ConfigEnum.DISABLE);
            entity.setSchmEdtStatus(WeyeCons.CFG_SCHEME_STATUS.UNPUB.getVal());
            entity.setSchmEdtModStatus(WeyeCons.CFG_SCHEME_EDITION_MOD_STATUS.INFO_PKG.getVal());
        }else {
            // 到这里，认为信息已经改了
            CfgSchemeEdition schm = cfgSchemeEditionService.queryById(entity.getSchmEdtId());
            String ss = schm.getSchmEdtModStatus();
            String editStatus = WeyeCons.CFG_SCHEME_EDITION_MOD_STATUS.INFO.getVal();
            if(StringUtils.isNumber(ss)){
                int dd = Integer.parseInt(ss);
                dd = dd | 1;
                editStatus = String.valueOf(dd);
            }
            entity.setSchmEdtModStatus(editStatus);

        }
        super.save(entity, request, redirectAttributes);
        return repageListPath;
    }

    @Override
    public String form(CfgSchemeEdition entity, HttpServletRequest request, Model model) {

        super.form(entity, request, model);
        // 方案列表
        List<CfgScheme> schemeList = schemeService.queryList(new CfgScheme());
        model.addAttribute("schemeList", schemeList);
        return getBasePath() + "Form";
    }

    @Override
    public String list(CfgSchemeEdition entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        // 方案列表
        List<CfgScheme> schemeList = schemeService.queryList(new CfgScheme());
        model.addAttribute("schemeList", schemeList);
        return super.list(entity, request, response, model);
    }

    @Override
    public String delete(CfgSchemeEdition entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        super.delete(entity, request, redirectAttributes);
        return repageListPath;
    }

    @RequestMapping("pub")
    public String pub(String id, String status, HttpServletRequest request, RedirectAttributes redirectAttributes){
        cfgSchemeEditionService.updateStatus(id, status);
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "1".equals(status)?"发布成功" : "成功取消发布");
        return repageListPath;
    }

    @RequestMapping("enable")
    public String enable(String id, String status, HttpServletRequest request, RedirectAttributes redirectAttributes){
        cfgSchemeEditionService.updateEnableStatus(id, status);
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes,  "1".equals(status)?"发布成功" : "成功取消发布");
        return repageListPath;
    }

    /**
     * 进入功能包设置页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("assignPkgFrom")
    public String assignPkgFrom(Model model, HttpServletRequest request){
        CfgSchemeEdition entry = cfgSchemeEditionService.queryById(getId(request));
        model.addAttribute("entry", entry);

        CfgScheme schm = schemeService.queryById(entry.getSchmId());
        model.addAttribute("schm", schm);

        List<CfgSchmEdtPackageExt> pkgList = cfgSchmEdtPackageService.querySchmEditFuncPkg(entry.getSchmEdtId());
        model.addAttribute("pkgList", pkgList);
        return getBasePath() + "FuncPkgAssign";
    }
    @RequestMapping("assignPkg")
    public String assignPkg(HttpServletRequest request, RedirectAttributes redirectAttributes){
        checkPermission("edit");
        String editId = getId(request);
        Map<String, Object> pp = WebUtils.getParametersStartingWith(request, null);
        String ssPkgIds = MapUtil.getMapValue(pp, "pkgIds", "");
        String ssMdlIds = MapUtil.getMapValue(pp, "mdlIds", "");

        List<CfgSchmEdtPackage> pkgList = new ArrayList();
        if(ssPkgIds != null && ssPkgIds.length() > 0){
            String[] pkgIds = ssPkgIds.split(",");
            String[] mdlIds = ssMdlIds.split(",");
            if(pkgIds.length == mdlIds.length){
                for (int i=0; i<pkgIds.length; i++){
                    CfgSchmEdtPackage pkg = new CfgSchmEdtPackage();
                    pkg.setPkgId(pkgIds[i]);
                    pkg.setSchmEdtId(editId);
                    pkg.setMdlId(mdlIds[i]);
                    pkg.setEdtPkgType(WeyeCons.CFG_SCHM_EDT_PACKAGE_TYPE.JC.getVal());
                    pkg.setEdtPkgStatus(WeyeCons.CFG_SCHM_EDT_PACKAGE_STATUS.DISABLE.getVal());

                    pkgList.add(pkg);
                }
            }
        }
        cfgSchemeEditionService.addPkg(editId, pkgList);

        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "成功添加功能包");
        return "redirect:" + "assignPkgFrom?id=" + editId;
    }
    @RequestMapping("selectPkg")
    public String selectPkg(Model model, HttpServletRequest request){
        CfgSchemeEdition entry = cfgSchemeEditionService.queryById(getId(request));
        // 查询方案的对应模块所有功能包
        List<CfgSchmEdtPackageExt> pkgList = cfgSchmEdtPackageService.querySchmEdtUnSelPkg(entry.getSchmId(), entry.getSchmEdtId());
        List<Map> list = new ArrayList<Map>();
        Map<String,String> mdlId2Name = new HashMap();
        for (CfgSchmEdtPackageExt pkg : pkgList){
            mdlId2Name.put(pkg.getMdlId(), pkg.getMdlName());

            Map it = new HashMap();
            it.put("pkgId", pkg.getPkgId());
            it.put("pkgName", pkg.getPkgName());
            it.put("pId", pkg.getMdlId());
            list.add(it);
        }

        // 模块添加进去
        for (Map.Entry<String,String> o : mdlId2Name.entrySet()){

            Map it = new HashMap();
            it.put("pkgId", o.getKey());
            it.put("pkgName", o.getValue());
            it.put("pId", "0");
            list.add(it);
        }

        model.addAttribute("list", list);
        return getBasePath() + "FuncPkgSel";
    }

    @RequestMapping("delPkg")
    public String delPkg(String editPkgId, HttpServletRequest request, RedirectAttributes redirectAttributes){
        try {
            cfgSchmEdtPackageService.deleteById(editPkgId);
        } catch (CannotDeleteException e) {
            e.printStackTrace();
        }
        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes, "成功删除功能包");
        return "redirect:" + "assignPkgFrom";
    }


    /*@RequestMapping("pubForm")
    public String pubForm(String id, HttpServletRequest request, Model model){
        CfgSchemeEdition schm = cfgSchemeEditionService.queryById(id);
        CfgSchemeEditionHis his = new CfgSchemeEditionHis();
        his.setSchmEdtName(schm.getSchmEdtName());
        his.setSchmEdtId(schm.getSchmEdtId());
        model.addAttribute("editHis", his);

        model.addAllAttributes(getFixParams(request));
        return BASE_PATH + "PubForm";
    }
    @RequestMapping("pub")
    public String pub(HttpServletRequest request,  RedirectAttributes redirectAttributes){

        redirectAttributes.addAllAttributes(getFixParams(request));
        addMessage(redirectAttributes,  "发布成功");
        return repageListPath;
    }*/

    @ResponseBody
    @RequestMapping("getListJson")
    public List getListJson(@RequestParam(required = false) String schmId){
        CfgSchemeEdition pp = new CfgSchemeEdition();
        pp.setSchmId(schmId);
        pp.setSchmEnableStatus(PtCons.ENABLE_DISABLE.E.getVal());
        List<CfgSchemeEdition> list = cfgSchemeEditionService.queryList(pp);
        List rstList = new ArrayList();
        for(CfgSchemeEdition it : list){
            Map o = MapUtil.newMap(
                    CfgSchemeEdition.TF.schmEdtId, it.getSchmEdtId(),
                    CfgSchemeEdition.TF.schmEdtName, it.getSchmEdtName(),
                    CfgSchemeEdition.TF.schmId, it.getSchmId()
            );
            rstList.add(o);
        }


        return rstList;
    }

    @RequestMapping("selApletForm")
    public String selApletForm(CfgSchemeEdition entity, Model model, HttpServletRequest request){

        CfgSchemeEdition entry = cfgSchemeEditionService.queryById(entity.getSchmEdtId());
        model.addAttribute("entry", entry);
        return getBasePath() + "ApletForm";
    }
    @RequestMapping("selAplet")
    public String selAplet(String schmEdtId, String apltIds[], HttpServletRequest request, RedirectAttributes redirectAttributes){
        if(null == apltIds)
            apltIds = (String[]) request.getParameterMap().get("apltIds");
        cfgSchemeEditionService.addApltList(schmEdtId, apltIds);
        redirectAttributes.addAllAttributes(getFixParams(request));
        return repageListPath;
    }


}
