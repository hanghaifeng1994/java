package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.persistence.BBaseEntity;
import cn.com.weye.core.utils.ConfigUtils;

import java.util.Date;

/**
 * 功能包
 *
 * @author zpzxskxsk@126.com
 */
public class CfgFunctionPackageExt extends CfgFunctionPackage {
    private String mdlName;

    public String getMdlName() {
        return mdlName;
    }

    public void setMdlName(String mdlName) {
        this.mdlName = mdlName;
    }
}
