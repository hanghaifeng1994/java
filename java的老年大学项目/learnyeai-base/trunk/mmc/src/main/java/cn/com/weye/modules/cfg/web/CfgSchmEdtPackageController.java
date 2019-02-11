package cn.com.weye.modules.cfg.web;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionHis;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackage;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionHisService;
import cn.com.weye.modules.cfg.service.CfgSchmEdtPackageService;
import cn.com.weye.tools.common.StringUtils;
import com.thinkgem.jeesite.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgSchmEdtPackageController.BASE_URL)
public class CfgSchmEdtPackageController extends MybatisBaseController<CfgSchmEdtPackage>{

    public static final String BASE_URL = "/cfg/CfgSchmEdtPackage/";
    private static final String BASE_PATH = "modules/cfg/CfgSchmEdtPackage";

    @Resource
    private CfgSchmEdtPackageService cfgSchmEdtPackageService;
    @Autowired
    private CfgSchemeEditionHisService cfgSchemeEditionHisService;

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
        return "cfg:CfgSchmEdtPackage";
    }

    @Override
    protected MybatisBaseService<CfgSchmEdtPackage> getService() {
        return cfgSchmEdtPackageService;
    }

    @Override
    public String delete(CfgSchmEdtPackage entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        super.delete(entity, request, redirectAttributes);
        return "redirect:" + Global.getAdminPath() + "/cfg/CfgSchemeEdition/assignPkgFrom";
    }

    @Override
    public String save(CfgSchmEdtPackage entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
//        如果没有id，认为出错
        if(entity.getEdtPkgId() == null){
            addMessage(redirectAttributes,"修改版本功能包失败");
            return "redirect:" + Global.getAdminPath() + "/cfg/CfgSchemeEdition/assignPkgFrom";
        }

        checkPermission("edit");
        CfgSchmEdtPackage o = cfgSchmEdtPackageService.queryById(entity.getEdtPkgId());
        entity.setSchmEdtId(o.getSchmEdtId());

        cfgSchmEdtPackageService.savePkg_upEditStatus(entity,
                WeyeCons.CFG_SCHM_EDT_PACKAGE_STATUS.ENABLE.getVal().equals(o.getEdtPkgStatus()));
        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));

        return "redirect:" + Global.getAdminPath() + "/cfg/CfgSchemeEdition/assignPkgFrom";
    }

    @Override
    public String form(CfgSchmEdtPackage entity, HttpServletRequest request, Model model) {
        /*int edtHisCount = 0;
        String pkgId = getId(request);
        // 查看是方案版本是否发布过
        if(StringUtils.isNotBlank(pkgId)){
            CfgSchmEdtPackage pkg = cfgSchmEdtPackageService.queryById(pkgId);
            CfgSchemeEditionHis his = new CfgSchemeEditionHis();
            his.setSchmEdtId(pkg.getSchmEdtId());
            edtHisCount = cfgSchemeEditionHisService.getCount(his);
        }
        model.addAttribute("edtHisCount", edtHisCount);*/
        return super.form(entity, request, model);
    }
    @RequestMapping("enable")
    public String enable(String edtPkgId, HttpServletRequest request, RedirectAttributes redirectAttributes){

        cfgSchmEdtPackageService.updateStatus(edtPkgId, WeyeCons.CFG_SCHM_EDT_PACKAGE_STATUS.ENABLE.getVal());
        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));

        return "redirect:" + Global.getAdminPath() + "/cfg/CfgSchemeEdition/assignPkgFrom";
    }
}
