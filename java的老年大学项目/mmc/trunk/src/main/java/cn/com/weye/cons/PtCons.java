package cn.com.weye.cons;


import cn.com.weye.core.consts.ConsTools;
import cn.com.weye.core.consts.ICons;

/**
 * Created by zpz on 2016/5/8.
 */
public class PtCons {
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

    /**
     * 用户认证状态
     */
    public enum CUST_AUDIT_STATUS implements ICons {
        WRZ("0","未认证"),//未认证
        SHZ("1","审核中"),//审核中
        RZCG("2","认证成功"),//认证成功
        RZSB("3","认证失败"),//认证失败
        ;
        private String val;
        private String label;
        private CUST_AUDIT_STATUS(String val,String label){
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
     * 用户状态
     */
    public enum USER_STATUS implements ICons {//N: 正常 D: 普通冻结 C: 注销 E:人工冻结
        N("1","正常"),
        D("2","普通冻结"),
        C("3","注销"),
        E("0","人工冻结")
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
    /**
     * 消息读取状态
     */
    public enum MSG_READ_FLAG implements ICons{
        WD("0","未读"),
        YD("1","已读")
        ;
        private String val;
        private String label;
        private MSG_READ_FLAG(String val,String label){
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
     * 认证审核状态
     */
    public  enum AUDIT_STATUS implements ICons {
        wsh("0","未审核"),
        cg("1","成功"),
        sb("2","失败"),
        ;
        private String val;
        private String label;

        private AUDIT_STATUS(String val,String label){
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

    public enum PM_PUSH_TYPE implements ICons {
        GR("1","个人"),
        ZT("2","主题"),
        QB("3","全部"),
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

    public enum PM_TYPE implements ICons {
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
    public  enum schm_edt_pay_type implements ICons{
        YF("1","月付"),
        NF("2","年付"),
        ;
        private String val;
        private String label;
        private schm_edt_pay_type(String val,String label){
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
    public enum ord_pay_status implements  ICons{
//        0未付费、1已付费、欠费
        WFF("0","未付费"),
        YFF("1","已付费"),
        QF("2","欠费"),
        ;
        private String val;
        private String label;
        private ord_pay_status(String val,String label){
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
//    0正常1作废2系统作废
    public enum ord_status implements  ICons{
        ZC("0","正常"),
        ZF("1","作废"),
        XTZF("2","系统作废"),
        ;
        private String val;
        private String label;
        private ord_status(String val,String label){
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
    public enum ord_type implements  ICons{
        GM("1","购买"),
        ZF("2","升级"),
        ;
        private String val;
        private String label;
        private ord_type(String val,String label){
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
    public enum ord_pay_type implements  ICons{
        XS("1","线上"),
        XX("2","线下"),
        ;
        private String val;
        private String label;
        private ord_pay_type(String val,String label){
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
    public enum MCHT_UPGRADE_STATUS implements  ICons{
        XS("0","不升级"),
        XX("1","免费升级"),
        ;
        private String val;
        private String label;
        private MCHT_UPGRADE_STATUS(String val,String label){
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
