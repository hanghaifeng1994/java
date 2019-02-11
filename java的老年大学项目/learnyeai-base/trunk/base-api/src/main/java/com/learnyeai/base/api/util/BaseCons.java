package com.learnyeai.base.api.util;

import com.learnyeai.core.consts.ICons;

/**
 * Created by zpz on 2018/4/10.
 */
public class BaseCons {
    // 缓存名称
    public static final String CACHE_CUST_INFO = "custInfo"; // 客户
    public static final String CACHE_SCACHE= "CfgScheme";  // 方案
    public static final String CACHE_SCHEMEEDITION = "CfgcfgSchemeEdition";  // 方案版本
    public static final String CACHE_MERCHANTSCHEME = "ShMerchantScheme";  // 商户方案
    public static final String CACHE_MERCHANT = "ShMerchant";  // 商户
    public static final String CACHE_PLATFORM = "PtsetPlatform";  // 平台
    public static final String CACHE_SITE = "PtsetSite";  // 站点
    public static final String CACHE_PT_SITES = "PtSites";  // 平台站点列表


    public enum CUST_INFO_TYPE implements ICons {
        YG("1","员工"),
        KH("2","客户"),
        SYS("3", "系统用户"),
        ;
        private String val;
        private String label;
        private CUST_INFO_TYPE(String val,String label){
            this.val = val;
            this.label= label;
        }
        public String getVal() {
            return val;
        }

        public String getLabel() {
            return label;
        }
    }

    public enum CUST_INFO_STATUS implements  ICons {
        N("N","正常"),
        D("D","普通冻结"),
        C("C","注销"),
        E("E","人工冻结")
        ;
        private String val;
        private String label;
        private CUST_INFO_STATUS(String val,String label){
            this.val = val;
            this.label= label;
        }
        public String getVal() {
            return val;
        }
        public String getLabel() {
            return label;
        }
    }
    public enum CUST_INFO_ADMIN_TYPE implements ICons {
        NO("0","不是管理员"),
        SH_ADMIN("1","商户管理员"),
        ;
        private String val;
        private String label;
        private CUST_INFO_ADMIN_TYPE(String val,String label){
            this.val = val;
            this.label= label;
        }
        public String getVal() {
            return val;
        }

        public String getLabel() {
            return label;
        }
    }

    public enum LGN_TYPE implements ICons {
        APP("1","APP"),
        WY("2","网页"),
        ;
        private String val;
        private String label;
        private LGN_TYPE(String val,String label){
            this.val = val;
            this.label= label;
        }

        public String getVal() {
            return val;
        }

        public String getLabel() {
            return label;
        }
    }

    /**
     * 方案功能包状态
     */
    public enum SCHM_PKG_TYPE implements ICons {
        JS("1", "基础包"),ZZ("2", "增值包")
        ;

        private SCHM_PKG_TYPE(String val, String label) {
            this.val = val;
            this.label = label;
        }

        private String val;
        private String label;
        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getVal() {
            return val;
        }
    }
    public enum PTSET_SITE_TYPE implements ICons {
        MS("1", "主站"),SS("2", "子站")
        ;

        private PTSET_SITE_TYPE(String val, String label) {
            this.val = val;
            this.label = label;
        }

        private String val;
        private String label;
        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getVal() {
            return val;
        }
    }

}
