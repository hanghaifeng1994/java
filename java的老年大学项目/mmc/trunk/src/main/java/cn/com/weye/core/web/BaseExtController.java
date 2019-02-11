package cn.com.weye.core.web;

import com.thinkgem.jeesite.common.web.BaseController;
import org.apache.shiro.SecurityUtils;

/**
 * Created by zpz on 2016/9/14.
 */
public abstract class BaseExtController extends BaseController{
    protected String getBasePermission() {
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
}
