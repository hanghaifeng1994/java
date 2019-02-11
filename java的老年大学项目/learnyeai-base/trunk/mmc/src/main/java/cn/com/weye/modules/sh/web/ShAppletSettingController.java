package cn.com.weye.modules.sh.web;

import cn.com.weye.cons.WeyeCons;
import cn.com.weye.core.consts.ICons;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.service.mybatis.MybatisBaseService;

import cn.com.weye.ares.web.MybatisBaseController;
import cn.com.weye.modules.sh.entity.ShAppletSetting;
import cn.com.weye.modules.sh.entity.ShAppletSettingExt;
import cn.com.weye.modules.sh.service.ShAppletSettingService;
import cn.com.weye.modules.sh.vo.ShMerchantSchemeVo;
import cn.com.weye.tools.common.StringUtils;
import com.thinkgem.jeesite.common.config.Global;
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
@RequestMapping("${adminPath}" + ShAppletSettingController.BASE_URL)
public class ShAppletSettingController extends MybatisBaseController<ShAppletSetting>{

    public static final String BASE_URL = "/sh/ShAppletSetting/";
    private static final String BASE_PATH = "modules/sh/ShAppletSetting";

    @Resource
    private ShAppletSettingService shAppletSettingService;

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
        return "sh:ShAppletSetting";
    }

    @Override
    protected MybatisBaseService<ShAppletSetting> getService() {
        return shAppletSettingService;
    }

    /**
     * 管理商户方案小程序
     * @param entity
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("manageForm")
    public String manageForm(ShAppletSetting entity, HttpServletRequest request, Model model){
        ShAppletSetting applet = new ShAppletSetting();
        applet.setMchtSchmId(entity.getMchtSchmId());
        List<ShAppletSetting> list = shAppletSettingService.queryList(applet);
        model.addAttribute("appletList", list);
        model.addAttribute("entry", entity);
        return getBasePath() + "ManageForm";
    }
    @RequestMapping("saveApplets")
    public String saveApplets(ShMerchantSchemeVo mchtSchmVo, HttpServletRequest request, Model model){
        List<ShAppletSetting> dataList = null;
        if(null != mchtSchmVo) {
            dataList = mchtSchmVo.getAppletSettings();
        }else {
            dataList = new ArrayList<ShAppletSetting>();
        }
        String mchtId = request.getParameter("mchtId");
        String mchtSchmId = request.getParameter("mchtSchmId");
        for (ShAppletSetting it : dataList){
            it.setMchtId(mchtId);
            it.setMchtSchmId(mchtSchmId);
        }
        shAppletSettingService.saveList(dataList, mchtSchmId);
        return "redirect:" + Global.getAdminPath() + "/sh/ShMerchantScheme/?mchtId="+mchtId;
    }

    /**
     * 商户小程序代码管理
     * @param entity
     * apltId 小程序id
     * apltVerId 小程序版本id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("codeManage")
    public String codeManage(ShAppletSetting entity, HttpServletRequest request, HttpServletResponse response, Model model){

        Page<Map> page = shAppletSettingService.queryCodePage(entity, new Page<Map>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "CodeManage";
    }
    @RequestMapping("codeUpdateStatus")
    public String codeUpdateStatus(String apltSetId, String apltVerId, int upType, HttpServletRequest request, RedirectAttributes redirectAttributes){
        checkPermission("edit");

        String redirect = "redirect:" + Global.getAdminPath() + getBaseUrl() + "codeManage?repage;";
        ShAppletSetting shAppletSetting = shAppletSettingService.queryById(apltSetId);
        if(null == shAppletSetting){
            addMessage(redirectAttributes, "商户小程序不存在");
            return redirect;
        }

        if(StringUtils.isBlank(shAppletSetting.getAppCodeUploadStatus())){
            addMessage(redirectAttributes, "商户小程序没有新版本");
            return redirect;
        }
        // 如果已经上传过代码，不要再上传了
        if(upType == 1 && !WeyeCons.SH_APPLET_SETTING_CODE_UPLOAD.WSS.getVal().equals(shAppletSetting.getAppCodeUploadStatus())){
            addMessage(redirectAttributes, "代码已经提交上传");
            return redirect;
        }else if(upType == 2 && !WeyeCons.SH_APPLET_SETTING_CODE_AUDIT.WTJ.getVal().equals(shAppletSetting.getAppAuditStatus())){
            addMessage(redirectAttributes, "代码已经提交审核了");
            return redirect;
        }else if(upType == 3 && !WeyeCons.SH_APPLET_SETTING_CODE_PUB.WTJ.getVal().equals(shAppletSetting.getAppPubStatus())){
            addMessage(redirectAttributes, "代码已经提交发布了");
            return redirect;
        }
        ICons type = null;
        if(upType == 1)
            type = WeyeCons.SH_APPLET_SETTING_CODE_UPLOAD.SSZ;
        else if (upType == 2)
            type = WeyeCons.SH_APPLET_SETTING_CODE_AUDIT.TJZ;
        else if(upType == 3)
            type = WeyeCons.SH_APPLET_SETTING_CODE_PUB.TJZ;

        if(null == type){
            addMessage(redirectAttributes, "类型错误");
            return redirect;
        }
        shAppletSettingService.opApletCode(apltSetId,apltVerId, type);

        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));

        return redirect;
    }
    /**
     * 商户方案小程序配置列表
     */
    @RequestMapping("configSmallOrdList")
    public String configSmallOrdList(ShAppletSetting entity, HttpServletRequest request, HttpServletResponse response, Model model){
       Page<ShAppletSettingExt> page= shAppletSettingService.queryExtPage(entity,new Page<ShAppletSettingExt>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
       return  getBasePath()+"List";
    }
    @Override
    public String save(ShAppletSetting entity, HttpServletRequest request, RedirectAttributes redirectAttributes){
        String redirect = "redirect:" + Global.getAdminPath() + getBaseUrl() + "configSmallOrdList";
        super.save(entity,request,redirectAttributes);
        addMessage(redirectAttributes, MSG_SUCC_FINISH);
        redirectAttributes.addAllAttributes(getFixParams(request));
        return redirect;
    }

}
