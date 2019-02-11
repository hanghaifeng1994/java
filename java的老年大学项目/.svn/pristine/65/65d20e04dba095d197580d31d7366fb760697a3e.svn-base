package cn.com.weye.ares.web;

import cn.com.weye.core.exception.CannotDeleteException;
import cn.com.weye.core.persistence.BBaseEntity;
import cn.com.weye.core.persistence.Page;
import cn.com.weye.core.persistence.mybatis.DBQuery;
import cn.com.weye.core.persistence.mybatis.impl.CriteriaQuery;
import cn.com.weye.core.service.mybatis.MybatisBaseService;
import cn.com.weye.core.utils.ParamCover;
import cn.com.weye.core.utils.WebUtils;
import cn.com.weye.core.vo.DeleteCheckVo;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于Mybatis进行增删改查的基础Controller
 * @author lc3
 */
public abstract class MybatisBaseController<E extends BBaseEntity> extends BaseController {

    public final static String MSG_FAILURE = "操作失败，请稍后重试！";
    public final static String MSG_SUCC_FINISH = "操作成功！";
    protected final String repageListPath = "redirect:" + Global.getAdminPath() + getBaseUrl() + "list?repage";
    protected final String defaultErrorPage = "error/500";
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected final String[] dateFieldNames = getDateFiledNames();

    protected abstract String getBaseUrl();
    protected abstract String getBasePath();
    protected abstract MybatisBaseService<E> getService();
    protected String getBasePermission() {
        return null;
    }

    /**
     * 获取请求参数
     * @param entity 实体
     * @param request request
     * @param model model
     * @return 请求参数
     */
    protected Map<String, Object> getRequestParams(boolean isForm, E entity, HttpServletRequest request, Model model) {
        return converDataType(WebUtils.getParametersStartingWith(request, null));
    }

    /**
     * 获取请求参数
     * @param isForm 是否为表单
     * @param entity 实体
     * @param request request
     * @param model model
     * @param isForm 是否是新增修改表单
     * @return
     */
    protected void updateRequestParams(boolean isForm, E entity, HttpServletRequest request, Model model) {
    }

    /**
     * 根据id查询实体，子类可以覆盖 // 张配忠创建 20151112
     * @param id
     * @return
     */
    protected E queryById(Object id){
        return getService().queryById(id);
    }

    /**
     * 转换数据类型
     * @param params 参数
     * @return 转换参数
     */
    protected Map<String, Object> converDataType(Map<String, Object> params) {
        if(null == params || null == dateFieldNames) {
            return params;
        }
        for (String fieldName : dateFieldNames) {
            final Object o = params.get(fieldName);
            if(o instanceof Date) {
                continue;
            }
            params.put(fieldName, DateUtils.parseDate(o));
        }
        return params;
    }

    /**
     * 得到日期类型字段
     * @return
     */
    protected String[] getDateFiledNames() {
        return null;
    }

    /**
     * 检查权限
     * @param subPerm
     */
    protected void checkPermission(String subPerm) {
        if(null == getBasePermission()) {
            return;
        }
        SecurityUtils.getSubject().checkPermission(getBasePermission() + (null != subPerm ? ":" + subPerm : ""));
    }

    /**
     * 通用从参数中得到主键方法
     * @param req Request
     * @return id
     */
    protected String getId(HttpServletRequest req) {
        String id = req.getParameter(getService().getIdKey());
        if(!StringUtils.hasText(id)) {
            id = req.getParameter("id");
        }
        return id;
    }

    @RequestMapping(value = {"list", ""})
    public String list(E entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        checkPermission("view");
        Page<E> page = getService().queryPage(entity, new Page<E>(request, response));
        model.addAttribute("page", page);
        model.addAttribute("entry", entity);
        return getBasePath() + "List";
    }

    @RequestMapping("form")
    public String form(E entity, HttpServletRequest request, Model model) {
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
        E entry = null;
        if(null != id && !id.isEmpty()) {
//            entry = getService().queryById(id);
            entry = queryById(id); // 给子类自定义机会， 张配忠修改 20151112
        }
        if(null == entry) {
            entry = entity;
        }
        model.addAttribute("entry", entry);
        return getBasePath() + "Form";
    }

    @RequestMapping("save")
    public String save(E entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
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
        return repageListPath;
    }

    @RequestMapping("delete")
    public String delete(E entity, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        checkPermission("edit");

        redirectAttributes.addAllAttributes(getFixParams(request));

        String id = getId(request);
        try {

            getService().deleteById(id);
            addMessage(redirectAttributes, MSG_SUCC_FINISH);
            return repageListPath;

            /*if(-1 < getService().relationDelete(id)) {
                addMessage(redirectAttributes, MSG_SUCC_FINISH);
                return repageListPath;
            }*/
        } catch (CannotDeleteException e) {
            List<String> msgList = e.getRelaMsgList();
            addMessage(redirectAttributes, "不能直接删除，原因为：<br/>" +
                    StringUtils.collectionToDelimitedString(msgList, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;"));
            return repageListPath;
        }

    }

    /**
     * 级联删除检查
     * @param req HttpServletRequest
     * @return
     */
    @RequestMapping("checkRelation")
    @ResponseBody
    public DeleteCheckVo checkRelation(HttpServletRequest req) {
        return getService().checkRelation(getId(req));
    }

    /**
     * 得到错误页面
     * @return
     */
    protected String getErrorPage() {
        return defaultErrorPage;
    }

    @ExceptionHandler
    public String exceptionHandler(Throwable e, HttpServletRequest request) {
    	if(e instanceof ShiroException) {
             throw (ShiroException) e;
        }
        logger.error("操作异常", e);
        final String msg = "操作异常，请联系管理员。";
        RequestContextUtils.getOutputFlashMap(request).put("message", msg);
        request.setAttribute("message", msg);
        return getErrorPage();
    }

    protected Map getFixParams(HttpServletRequest request){
        if(request.getAttribute("paramCover") == null)
            return new HashMap();
        ParamCover paramCover = (ParamCover)request.getAttribute("paramCover");
        return paramCover.defixParam(request);
    }
}
