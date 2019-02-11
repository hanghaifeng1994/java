package com.learnyeai.common.utils;

import com.learnyeai.core.consts.ICons;

/**
 * Created by zpz on 2018/5/8.
 */
public class WeyeCons {
    public static final String COL_NAME_MCHT_ID = "MCHT_ID";    // 商户id
    public static final String COL_NAME_MCHT_SCHM_ID = "MCHT_SCHM_ID";  // 商户方案id
    public static final String COL_NAME_SITE_ID = "SITE_ID";    // 站点id

    // 实例是bean时，字段名称
    public static final String BEAN_NAME_MCHT_ID = "mchtId";    // 商户id
    public static final String BEAN_NAME_MCHT_SCHM_ID = "mchtSchmId";  // 商户方案id
    public static final String BEAN_NAME_SITE_ID = "siteId";    // 站点id

    /**
     * 登录类型
     */
    /*public enum LOGIN_TYPE implements ICons {
        STAFF("1", "员工"), CUST("2"," 客户"), STAFF_MNG("3", "员工后管")
        ;

        LOGIN_TYPE(String val, String label) {
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
    }*/
}
