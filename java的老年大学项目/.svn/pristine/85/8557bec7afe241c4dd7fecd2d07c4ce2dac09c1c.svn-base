package cn.com.weye.modules.cfg.web;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgApplet;
import cn.com.weye.modules.cfg.entity.CfgAppletVersion;
import cn.com.weye.modules.cfg.service.CfgAppletService;
import cn.com.weye.modules.cfg.service.CfgAppletVersionService;
import cn.com.weye.modules.cfg.vo.CfgAppletVersionVo;
import cn.com.weye.tools.common.JsonMapper;
import cn.com.weye.tools.common.MapUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zpzxskxsk@126.com
 */
@Controller
@RequestMapping("${adminPath}" + CfgAppletVersionController.BASE_URL)
public class CfgAppletVersionController extends MybatisBaseController<CfgAppletVersion>{

    public static final String BASE_URL = "/cfg/CfgAppletVersion/";
    private static final String BASE_PATH = "modules/cfg/CfgAppletVersion";

    @Resource
    private CfgAppletVersionService cfgAppletVersionService;
    @Resource
    private CfgAppletService cfgAppletService;

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
        return "cfg:CfgAppletVersion";
    }

    @Override
    protected MybatisBaseService<CfgAppletVersion> getService() {
        return cfgAppletVersionService;
    }

    @Override
    public String form(CfgAppletVersion entity, HttpServletRequest request, Model model) {
        // 小程序列表
        List<CfgApplet> apletList = cfgAppletService.queryList(null);
        {
            List<Map> ll = new ArrayList<Map>();
            for (CfgApplet a : apletList){
                ll.add(MapUtil.newMap(
                        CfgApplet.TF.apltId, a.getApltId(),
                        CfgApplet.TF.apltName, a.getApltName(),
                        CfgApplet.TF.schmId, a.getSchmId()
                ));
            }
            model.addAttribute("apletList", JsonMapper.getInstance().toJson(ll));
        }
        return super.form(entity, request, model);
    }

    @Override
    public String save(CfgAppletVersion entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        checkPermission("edit");

        // 查询小程序
        CfgApplet aplet = cfgAppletService.queryById(entity.getApltId());
        long code = aplet.getApltVerCode()== null? 1l : aplet.getApltVerCode();
        entity.setApltVerCode(++code);
        entity.setApltName(aplet.getApltName());
        entity.setApltAppId(aplet.getApltAppId());
        entity.setApltAppSecret(aplet.getApltAppSecret());
        entity.setApltVerStatus("0");
        entity.setApltVerAuditNum(0l);
        entity.setApltVerPubNum(0l);
        entity.setApltVerUploadNum(0l);

        cfgAppletVersionService.add(entity);
        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));
        return repageListPath;
    }

    @Override
    public String list(CfgAppletVersion entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");

        Page<CfgAppletVersionVo> page = cfgAppletVersionService.queryExtPage(entity, new Page<CfgAppletVersionVo>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }
}
