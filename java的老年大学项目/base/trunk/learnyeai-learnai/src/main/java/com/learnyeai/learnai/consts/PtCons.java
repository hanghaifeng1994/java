package com.learnyeai.learnai.consts;

import com.learnyeai.core.consts.ICons;

/**
 * Created by zpz on 2017/2/13.
 */
public class PtCons {

    /**
     * 分页
     */
    public enum MYPAGE implements ICons {
        pageNo("1","默认页码"),//页码
        pageSize("10","默认页长"),//页长
        ;
        private String val;
        private String label;
        private MYPAGE(String val,String label){
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
     * 是否删除
     */
    public enum DEL_FLAG implements ICons {
        NO("0","未删除"),
        YES("1","已删除"),
        ;
        private String val;
        private String label;
        private DEL_FLAG(String val,String label){
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
     * 是、否
     */
    public enum YES_NO implements ICons {
        NO("0","否"),
        YES("1","是"),
        ;
        private String val;
        private String label;
        private YES_NO(String val,String label){
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
    // 生效、失效
    public enum EFF_FAL implements ICons {
        EFF("0","失效"),
        FAL("1","生效"),
        ;
        private String val;
        private String label;
        private EFF_FAL(String val,String label){
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
    // 启用、禁用
    public enum ENABLE_DISABLE implements ICons {
        D("0","禁用"),
        E("1","启用"),
        ;
        private String val;
        private String label;
        private ENABLE_DISABLE(String val,String label){
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
    public enum USER_STATUS implements  ICons {
        N("N","正常"),
        D("D","普通冻结"),
        C("C","注销"),
        E("E","人工冻结")
        ;
        private String val;
        private String label;
        private USER_STATUS(String val,String label){
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
     * 消息推送状态
     */
    public enum PM_STATUS implements ICons{
        WTS("0","未推送"),
        CG("1","成功"),
        SB("2","失败")
        ;
        private String val;
        private String label;
        private PM_STATUS(String val,String label){
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
    public enum PM_TYPE  implements  ICons {
        SS("1","实时推送"),
        DS("2","定时推送"),
        ;
        private String val;
        private String label;
        private PM_TYPE(String val,String label){
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
    public enum PM_PUSH_TYPE implements  ICons {
        GR("1","个人"),
        ZT("2","主题"),
        QB("3","全部 "),
        ;
        private String val;
        private String label;
        private PM_PUSH_TYPE(String val,String label){
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

}
