package com.drcl.traincore.vo;

import java.io.Serializable;

import com.drcl.traincore.user.dto.TenantDTO;

public class TenantOrderVO implements Comparable<TenantOrderVO>,Serializable{

	private TenantDTO tenantDTO;
	
	private long order;

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public TenantDTO getTenantDTO() {
		return tenantDTO;
	}

	public void setTenantDTO(TenantDTO tenantDTO) {
		this.tenantDTO = tenantDTO;
	}

	@Override
	public int compareTo(TenantOrderVO o) {
		return (int)o.getOrder()-(int)this.order;
	}
	
	
}
