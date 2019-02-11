package cn.com.weye.modules.sh.entity;

import cn.com.weye.core.utils.ConfigUtils;
import cn.com.weye.core.persistence.BBaseEntity;

/**
 * 订单增值服务关联表
 *
 * @author yl
 */
public class ShOrderAddserviceRel extends BBaseEntity {

    /**
     * 增值服务id
     */
    private String asId;
    /**
     * 订单id
     */
    private String ordId;
    /**
     * 价格
     */
    private Long asPrice;

    public String getAsId() {
        return asId;
    }

    public void setAsId(String asId) {
        this.asId = asId;
    }
    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }
    public Long getAsPrice() {
        return asPrice;
    }

    public void setAsPrice(Long asPrice) {
        this.asPrice = asPrice;
    }

    public static class TF {

        public static String TABLE_NAME = "SH_ORDER_ADDSERVICE_REL";   // 表名

        public static String TABLE_SCHEMA = ConfigUtils.getValue("schema.interPlat");   // 库名

        public static String asId = "AS_ID";  // 增值服务id
        public static String ordId = "ORD_ID";  // 订单id
        public static String asPrice = "AS_PRICE";  // 价格

    }
}
