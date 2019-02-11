package com.drcl.traincore.dto;

import java.io.Serializable;

public class ShopUserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String shopuser_id;

	private String name;

	private String role;

	private String brand_id;

	private int status;

	private String mobile;

	private String tenant_id;

	private String store_id;

	public String getRoleStr() {
		if (this.role == null)
			return "其他";
		if (this.role.equals("dy"))
			return "店员";
		if (this.role.equals("dg"))
			return "导购";
		if (this.role.equals("mananger"))
			return "管理员";
		return "其他";
	}

	public String getStatusStr() {
		if (this.status == 1)
			return "正常";
		return "禁用";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getShopuser_id() {
		return shopuser_id;
	}

	public void setShopuser_id(String shopuser_id) {
		this.shopuser_id = shopuser_id;
	}

}