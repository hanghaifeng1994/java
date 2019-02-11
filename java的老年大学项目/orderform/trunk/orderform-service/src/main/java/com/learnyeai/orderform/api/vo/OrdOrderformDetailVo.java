package com.learnyeai.orderform.api.vo;

import com.learnyeai.core.support.BaseVo;
import java.math.BigDecimal;

/**
 * 订单明细
 *
 * @author twang
 */
public class OrdOrderformDetailVo extends BaseVo {

    /**
    * 订单明细id
    */
    private String ordDetailId;

    /**
     * 订单id
     */
    private String orderId;
    /**
     * 项目ID
     */
    private String itemId;
    /**
     * 项目类型(1:课程;2:商品)
     */
    private Integer itemType;
    /**
     * 项目名称
     */
    private String itemname;
    /**
     * 项目数量
     */
    private Integer itemnum;
    /**
     * 项目单价
     */
    private BigDecimal price;
    /**
     * 项目总价
     */
    private BigDecimal totalPrice;
    /**
     * 折扣
     */
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
        public static String ordDetailId = "ordDetailId";  // 订单明细id
        public static String orderId = "orderId";  // 订单id
        public static String itemId = "itemId";  // 项目ID
        public static String itemType = "itemType";  // 项目类型(1:课程;2:商品)
        public static String itemname = "itemname";  // 项目名称
        public static String itemnum = "itemnum";  // 项目数量
        public static String price = "price";  // 项目单价
        public static String totalPrice = "totalPrice";  // 项目总价
        public static String discount = "discount";  // 折扣

    }

}
