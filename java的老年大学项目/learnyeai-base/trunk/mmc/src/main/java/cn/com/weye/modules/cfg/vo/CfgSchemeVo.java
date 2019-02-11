package cn.com.weye.modules.cfg.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpz on 2017/12/4.
 */
public class CfgSchemeVo {

    /**
     * 行业方案id
     */
    private String schmId;
    /**
     * 行业方案名称
     */
    private String schmName;
    /**
     * 方案描述
     */
    private String schmDesc;
    /**
     * 行业
     */
    private String schmIndustry;
    /**
     * 核心模块id
     */
    private String schmMdlId;
    /**
     * 核心模块名称
     */
    private String schmMdlName;

    private List<CfgSchemeEditionVo> schemeEditionVos = new ArrayList<CfgSchemeEditionVo>();

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

    public String getSchmDesc() {
        return schmDesc;
    }

    public void setSchmDesc(String schmDesc) {
        this.schmDesc = schmDesc;
    }

    public String getSchmIndustry() {
        return schmIndustry;
    }

    public void setSchmIndustry(String schmIndustry) {
        this.schmIndustry = schmIndustry;
    }

    public String getSchmMdlId() {
        return schmMdlId;
    }

    public void setSchmMdlId(String schmMdlId) {
        this.schmMdlId = schmMdlId;
    }

    public String getSchmMdlName() {
        return schmMdlName;
    }

    public void setSchmMdlName(String schmMdlName) {
        this.schmMdlName = schmMdlName;
    }

    public List<CfgSchemeEditionVo> getSchemeEditionVos() {
        return schemeEditionVos;
    }

    public void setSchemeEditionVos(List<CfgSchemeEditionVo> schemeEditionVos) {
        this.schemeEditionVos = schemeEditionVos;
    }
}
