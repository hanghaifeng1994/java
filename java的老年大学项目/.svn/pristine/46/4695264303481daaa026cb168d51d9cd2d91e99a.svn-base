package com.learnyeai.orderform.model;

import com.learnyeai.learnai.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 订单明细
 *
 * @author twang
 */
public class OrdOrderformDetail extends BaseEntity {

    /**
    * 订单明细id
    */
    @Id
    @Column(name = "ORD_DETAIL_ID")
    private String ordDetailId;

    /**
     * 订单id
     */
    @Column(name = "ORDER_ID")
    private String orderId;
    /**
     * 项目ID
     */
    @Column(name = "ITEM_ID")
    private String itemId;
    /**
     * 项目类型(1:课程;2:商品)
     */
    @Column(name = "ITEM_TYPE")
    private Integer itemType;
    /**
     * 项目名称
     */
    @Column(name = "ITEMNAME")
    private String itemname;
    /**
     * 项目数量
     */
    @Column(name = "ITEMNUM")
    private Integer itemnum;
    /**
     * 项目单价
     */
    @Column(name = "PRICE")
    private BigDecimal price;
    /**
     * 项目总价
     */
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    /**
     * 折扣
     */
    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    public String getOrdDetailId() {
        return ordDetailId;
    }

    public void setOrdDetailId(String ordDetailId) {
        this.ordDetailId = ordDetailId;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }
    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public static class TF {

        public static String TABLE_NAME = "ORD_ORDERFORM_DETAIL";   // 表名

        //public static String TABLE_SCHEMA = ConfigUtils.getValue("");   // 库名

        public static String ordDetailId = "ORD_DETAIL_ID";  // 订单明细id
        public static String orderId = "ORDER_ID";  // 订单id
        public static String itemId = "ITEM_ID";  // 项目ID
        public static String itemType = "ITEM_TYPE";  // 项目类型(1:课程;2:商品)
        public static String itemname = "ITEMNAME";  // 项目名称
        public static String itemnum = "ITEMNUM";  // 项目数量
        public static String price = "PRICE";  // 项目单价
        public static String totalPrice = "TOTAL_PRICE";  // 项目总价
        public static String discount = "DISCOUNT";  // 折扣

    }
}
