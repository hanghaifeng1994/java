package com.drcl.traincore.web.manage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.common.lib.springside.web.CrudActionSupport;

import com.drcl.traincore.vo.SellerShoreVO;
import com.drcl.traincore.vo.SellerUserVO;
import com.google.common.collect.Lists;

/**
 * 
 * 后台action基类
 * 
 * @author shibing
 * @version 1.0
 * @since 2011-11-10
 * @author hbqian checked by hbqian at 2050812 整理代码
 */
public abstract class BaseCrudAction<T> extends CrudActionSupport<T> {
	private static final long serialVersionUID = 1L;

	protected String id;// ID
	public String idsArray;
	public List<String> idsArrayStr;
	protected List<String> ids = Lists.newArrayList();

	private SellerUserVO curUser = null;
	private List<SellerShoreVO> stores;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public List<String> getIdsArrayStr() {
		return idsArrayStr;
	}

	public void setIdsArrayStr(List<String> idsArrayStr) {
		this.idsArrayStr = idsArrayStr;
	}

	public String getIdsArray() {
		return idsArray;
	}

	public void clean() {
		this.idsArray = null;
		this.idsArrayStr = null;
	}

	public String getTenantId() {
		return null;
	}
	
	public void setIdsArray(String idsArray) {
		if (StringUtils.isBlank(idsArray))
			return;
		this.idsArray = idsArray;
		List<String> tempids = new ArrayList<String>();
		String[] ids = idsArray.split(",");
		for (String id : ids) {
			tempids.add(id);
		}
		setIdsArrayStr(tempids);
	}

	public HttpSession getSession() {
		return Struts2Utils.getSession();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 取得当前用户区域管理员所在区id
	 * 
	 * @return
	 */
	public String getCantonID() {
		// UserDTO userDTO = getNowUser();
		// return userDTO.getTenantId();
		return "1";
	}

	public SellerUserVO getCurUser() {
		return null;
	}

	/**
	 * 取得域名获取所在租户id
	 * 
	 * @return
	 */
	public String getCurTenantID() {
		return getCurUser().getTenantId();
	}

}