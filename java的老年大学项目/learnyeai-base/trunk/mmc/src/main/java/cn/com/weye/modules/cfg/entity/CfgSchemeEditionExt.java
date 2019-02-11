package cn.com.weye.modules.cfg.entity;

import cn.com.weye.core.persistence.BBaseEntity;
import cn.com.weye.core.utils.ConfigUtils;

import java.util.Date;

/**
 * 方案版本
 *
 * @author zpzxskxsk@126.com
 */
public class CfgSchemeEditionExt extends CfgSchemeEdition {
    private String  schmId;

    private String  schmName;

    public String getSchmId() {
        return schmId;
    }

    public void setSchmId(String schmId) {
        this.schmId = schmId;
    }

    public String getSchmName() {
        return schmName;
    }

    public void setSchmName(String schmName) {
        this.schmName = schmName;
    }
}
