package cn.com.weye.modules.cfg.vo;

import cn.com.weye.modules.cfg.entity.CfgAppletVersion;

/**
 * Created by zpz on 2018/3/6.
 */
public class CfgAppletVersionVo extends CfgAppletVersion {

    /**
     * 行业方案名称
     */
    private String schmName;

    public String getSchmName() {
        return schmName;
    }

    public void setSchmName(String schmName) {
        this.schmName = schmName;
    }
}
