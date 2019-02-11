package cn.com.weye.modules.cfg.web;

import cn.com.weye.cons.PtCons;
import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.consts.ConsTools;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.cfg.entity.CfgAppletVersion;
import cn.com.weye.modules.cfg.entity.CfgSchemeEdition;
import cn.com.weye.modules.cfg.entity.CfgSchemeEditionUpdateInfo;
import cn.com.weye.modules.cfg.service.CfgAppletVersionService;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionService;
import cn.com.weye.modules.cfg.service.CfgSchemeEditionUpdateInfoService;
import cn.com.weye.modules.cfg.vo.CfgSchemeEditionUpdateInfoVo;
import cn.com.weye.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("${adminPath}" + CfgSchemeEditionUpdateInfoController.BASE_URL)
public class CfgSchemeEditionUpdateInfoController extends MybatisBaseController<CfgSchemeEditionUpdateInfo>{

    public static final String BASE_URL = "/cfg/CfgSchemeEditionUpdateInfo/";
    private static final String BASE_PATH = "modules/cfg/CfgSchemeEditionUpdateInfo";

    Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CfgSchemeEditionUpdateInfoService cfgSchemeEditionUpdateInfoService;

    @Resource
    private CfgSchemeEditionService cfgSchemeEditionService;

    @Resource
    private CfgAppletVersionService cfgAppletVersionService;

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
        return "cfg:CfgSchemeEditionUpdateInfo";
    }

    @Override
    protected MybatisBaseService<CfgSchemeEditionUpdateInfo> getService() {
        return cfgSchemeEditionUpdateInfoService;
    }

    /**
     * 添加版本历史、小程序版本的升级信息时，全部添加，只有自定义添加时才会选择方案版本
     * @param entity
     * @param request
     * @param model
     * @return
     */
    @Override
    public String form(CfgSchemeEditionUpdateInfo entity, HttpServletRequest request, Model model) {
        // 如果id不是空认为错误
        if(StringUtils.isNotBlank(entity.getEdtUpId())){
            logger.error("升级信息不能修改");
            return null;
        }
        // 判断类型是小程序、还是版本、自定义
        // 如果不是自定义，还需要查询版本信息
        WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE type = ConsTools.getCons(WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.class, entity.getEdtUpType());
        if(null == type)
            type = WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.ZDY;

        // 获取版本列表，供选择
        List<CfgSchemeEdition> edtList = null;
        if(type == WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.BB){
            // 查询版本
            if(StringUtils.isBlank(entity.getSchmEdtId())){
                logger.error("根据版本历史添加升级信息时，版本id不能为空");
                return null;
            }
            CfgSchemeEdition edt = cfgSchemeEditionService.queryById(entity.getSchmEdtId());
            edtList = new ArrayList<CfgSchemeEdition>();
            edtList.add(edt);
        }else if(type == WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.XCY){
            // 根据小程序版本id，找到小程序版本对应的版本列表
            CfgAppletVersion apltVer = cfgAppletVersionService.queryById(entity.getEdtUpObjId());
            edtList = cfgSchemeEditionService.queryApletEditionList(apltVer.getApltId());
        }else {
            CfgSchemeEdition ppEdtion = new CfgSchemeEdition();
            ppEdtion.setSchmEnableStatus(PtCons.ENABLE_DISABLE.E.getVal());
            edtList = cfgSchemeEditionService.queryList(ppEdtion);
        }
        model.addAttribute("edtList", edtList);
        return super.form(entity, request, model);
    }

    @Override
    public String save(CfgSchemeEditionUpdateInfo entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        return super.save(entity, request, redirectAttributes);
    }

    /**
     *
     * @param entity
     * @param request
     * edtUpType 升级类型
     * edtUpObjId 方案版本、小程序版本的id
     * edtUpVerName 版本升级名称
     * edtUpVerDate 版本升级日期
     * edtUpContent 版本升级内容
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(CfgSchemeEditionUpdateInfo entity, HttpServletRequest request){
        List<CfgSchemeEdition> edtList = null;
        WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE type = ConsTools.getCons(WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.class, entity.getEdtUpType());
        if(type == WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.BB){
            // 查询版本
            if(StringUtils.isBlank(entity.getSchmEdtId())){
                logger.error("方案版本id不能为空");
                return "{\"success\":false}";
            }
            CfgSchemeEdition edt = cfgSchemeEditionService.queryById(entity.getSchmEdtId());
            edtList = new ArrayList<CfgSchemeEdition>();
            edtList.add(edt);
        }else if(type == WeyeCons.CFG_SCHEME_EDITION_UPDATE_INFO_TYPE.XCY){
            // 根据小程序版本id，找到小程序版本对应的版本列表
            CfgAppletVersion apltVer = cfgAppletVersionService.queryById(entity.getEdtUpObjId());
            edtList = cfgSchemeEditionService.queryApletEditionList(apltVer.getApltId());
        }else {
            CfgSchemeEdition edt = cfgSchemeEditionService.queryById(entity.getSchmEdtId());
            edtList = new ArrayList<CfgSchemeEdition>();
            edtList.add(edt);
        }
        for(CfgSchemeEdition it : edtList){
            entity.setEdtUpId(null);
            entity.setSchmEdtId(it.getSchmEdtId());
            long code = it.getSchmEdtCode() == null? 1l : it.getSchmEdtCode();
            entity.setSchmEdtCode(++code);

            cfgSchemeEditionUpdateInfoService.add(entity, type);
        }

        return "{\"success\":true}";
    }

    @Override
    public String list(CfgSchemeEditionUpdateInfo entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");

        Page<CfgSchemeEditionUpdateInfoVo> page = cfgSchemeEditionUpdateInfoService.queryExtPage(entity, new Page<CfgSchemeEditionUpdateInfoVo>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }

    @RequestMapping("view")
    public String view(CfgSchemeEditionUpdateInfo entity, HttpServletRequest request, Model model) {
        // 如果id不是空认为错误
        if(StringUtils.isBlank(entity.getEdtUpId())){
            logger.error("升级信息id不能为空");
            return null;
        }
        super.form(entity, request, model);
        CfgSchemeEditionUpdateInfo entry = (CfgSchemeEditionUpdateInfo)model.asMap().get("entry");
        CfgSchemeEdition edtion = cfgSchemeEditionService.queryById(entry.getSchmEdtId());
        model.addAttribute("edtion", edtion);
        return getBasePath() + "View";
    }
}
