package cn.com.weye.modules.cfg.web;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionHis;
import cn.com.weye.modules.cfg.entity.CfgSchmEdtPackageHis;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionHisService;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionService;
import cn.com.weye.modules.cfg.service.CfgSchmEdtPackageHisService;
import com.thinkgem.jeesite.common.config.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgSchemeEditionHisController.BASE_URL)
public class CfgSchemeEditionHisController extends MybatisBaseController<CfgSchemeEditionHis>{

    public static final String BASE_URL = "/cfg/CfgSchemeEditionHis/";
    private static final String BASE_PATH = "modules/cfg/CfgSchemeEditionHis";

    @Resource
    private CfgSchemeEditionHisService cfgSchemeEditionHisService;

    @Resource
    private CfgSchemeEditionService cfgSchemeEditionService;
    @Autowired
    private CfgSchmEdtPackageHisService cfgSchmEdtPackageHisService;

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
        return "cfg:CfgSchemeEditionHis";
    }

    @Override
    protected MybatisBaseService<CfgSchemeEditionHis> getService() {
        return cfgSchemeEditionHisService;
    }

    /**
     * 只会增加，不会修改
     * @param entity
     * @param request
     * @param redirectAttributes
     * @return
     */
    @Override
    public String save(CfgSchemeEditionHis entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        checkPermission("edit");
        if(null != entity.getSchmEdtHisId()){
            return null;
        }
        cfgSchemeEditionHisService.addHis(entity);
        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));
        return "redirect:" + Global.getAdminPath() + "/cfg/CfgSchemeEdition/";
    }

    @Override
    public String form(CfgSchemeEditionHis entity, HttpServletRequest request, Model model) {
//        查询方案版本，取修改状态，如果有功能包修改
        CfgSchemeEdition edition = cfgSchemeEditionService.queryById(entity.getSchmEdtId());

        model.addAttribute("edition", edition);
        return super.form(entity, request, model);
    }
    @RequestMapping("view")
    public String view(CfgSchemeEditionHis entity, HttpServletRequest request, Model model) {
        String id = getId(request);

        CfgSchemeEditionHis entry = queryById(id);
        // 查询历史功能包
        CfgSchmEdtPackageHis pp = new CfgSchmEdtPackageHis();
        pp.setSchmEdtHisId(entity.getSchmEdtHisId());
        List<CfgSchmEdtPackageHis> pkList = cfgSchmEdtPackageHisService.queryList(pp);
        model.addAttribute("pkList", pkList);
        model.addAllAttributes(getFixParams(request));
        model.addAttribute("entry", entry);
        return getBasePath() + "View";
    }
}
