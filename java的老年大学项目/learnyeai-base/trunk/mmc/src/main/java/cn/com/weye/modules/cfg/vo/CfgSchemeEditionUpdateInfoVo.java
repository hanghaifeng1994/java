package cn.com.weye.modules.cfg.vo;

import cn.com.weye.modules.cfg.entity.CfgSchemeEditionUpdateInfo;

/**
 * Created by zpz on 2018/3/5.
 */
public class CfgSchemeEditionUpdateInfoVo extends CfgSchemeEditionUpdateInfo {

    /**
     * 方案版本名称
     */
    private String schmEdtName;

    public String getSchmEdtName() {
        return schmEdtName;
    }

    public void setSchmEdtName(String schmEdtName) {
        this.schmEdtName = schmEdtName;
    }
}
