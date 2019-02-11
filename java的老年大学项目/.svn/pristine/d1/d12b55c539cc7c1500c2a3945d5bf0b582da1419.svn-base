package cn.com.weye.modules.cfg.web;

import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgApplet;
import cn.com.weye.modules.cfg.entity.CfgScheme;
import cn.com.weye.modules.cfg.service.CfgAppletService;
import cn.com.weye.modules.cfg.service.CfgSchemeService;
import cn.com.weye.modules.cfg.vo.CfgAppletVo;
import cn.com.weye.modules.cfg.vo.CfgSchemeEditionUpdateInfoVo;
import cn.com.weye.tools.common.MapUtil;
import cn.com.weye.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("${adminPath}" + CfgAppletController.BASE_URL)
public class CfgAppletController extends MybatisBaseController<CfgApplet>{

    public static final String BASE_URL = "/cfg/CfgApplet/";
    private static final String BASE_PATH = "modules/cfg/CfgApplet";

    @Resource
    private CfgAppletService cfgAppletService;
    @Autowired
    private CfgSchemeService schemeService;

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
        return "cfg:CfgApplet";
    }

    @Override
    protected MybatisBaseService<CfgApplet> getService() {
        return cfgAppletService;
    }


    @Override
    public String save(CfgApplet entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if(StringUtils.isBlank(entity.getApltId())){
            entity.setApltVerCode(1l);
        }

        return super.save(entity, request, redirectAttributes);
    }

    @Override
    public String list(CfgApplet entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");

        Page<CfgAppletVo> page = cfgAppletService.queryExtPage(entity, new Page<CfgAppletVo>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }

    @ResponseBody
    @RequestMapping("getListJson")
    public List getListJson(@RequestParam(required = false) String schmId, @RequestParam(required = false) String schmEdtId){
        List<CfgApplet> schmApltlist = null;
        List<CfgApplet> schmEdtApltlist = null;

        if(StringUtils.isNotBlank(schmId)){
            CfgApplet pp = new CfgApplet();
            pp.setSchmId(schmId);
            schmApltlist = cfgAppletService.queryList(pp);
        }
        if(StringUtils.isNotBlank(schmEdtId)){
            schmEdtApltlist = cfgAppletService.queryListBySchmEdtId(schmEdtId);
        }

        List rstList = new ArrayList();
        // 获取方案小程序，如果版本id不为空，标识是否是版本小程序
        if(null != schmApltlist){
            for(CfgApplet it : schmApltlist){
                Map o = MapUtil.newMap(
                        CfgApplet.TF.apltId, it.getApltId(),
                        CfgApplet.TF.apltName, it.getApltName(),
                        CfgApplet.TF.schmId, it.getSchmId()
                );
                if(schmEdtApltlist != null){
                    for (CfgApplet a : schmEdtApltlist){
                        if(a.getApltId().equals(it.getApltId())){
                            o.put("sel", "1");
                            break;
                        }
                    }
                }
                rstList.add(o);
            }
        }
        else if(null != schmEdtApltlist){
            for(CfgApplet it : schmEdtApltlist){
                Map o = MapUtil.newMap(
                        CfgApplet.TF.apltId, it.getApltId(),
                        CfgApplet.TF.apltName, it.getApltName(),
                        CfgApplet.TF.schmId, it.getSchmId()
                );
                rstList.add(o);
            }
        }

        return rstList;
    }
}
