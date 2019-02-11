package com.drcl.traincore.dto;

import java.io.Serializable;

public class OrderformDetailDTO implements Serializable {
	private static final long serialVersionUID = 2088045048806605410L;
	private String orderformProductId;// 订单明细id
	private String productId;// 商品id
	private String categoryId;// 分类id
	private String categoryName;// 分类名称
	private String brandId;
	private String brandName; // 品牌名称
	private String name;// 商品名称
	private String pic;// 商品图片
	private int productNum;// 数量
	private Double price; // 价格
	private Double actPrice;// 核销后价格

	public String getOrderformProductId() {
		return orderformProductId;
	}

	public void setOrderformProductId(String orderformProductId) {
		this.orderformProductId = orderformProductId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getActPrice() {
		return actPrice;
	}

	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}

}
