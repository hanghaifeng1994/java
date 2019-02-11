package com.drcl.traincore.dto;

import java.io.Serializable;

public class BrandDTO implements Serializable{
	private static final long serialVersionUID = -169182043848442539L;

	private String brandId = null;

	private String name; // 品牌名称

	private String storeId;

	private String tenantId;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
}
