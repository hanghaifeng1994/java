package com.drcl.traincore.util.im.vo;
/**
 * im接口请求头
 * @author ycguo
 *
 */
public class RegRequestBodyVO {
	private String USER_ID;//token
	private String USER_PWD;//设备号
	private String USER_PIC;//用户头像
	private String USER_SHORTNAME;//用户昵称
	private String USER_SEX;//性别 1:男 0：女

	public RegRequestBodyVO(String USER_ID, String USER_PWD, String USER_PIC,String USER_SHORTNAME, String USER_SEX){
		this.USER_ID = USER_ID;
		this.USER_PWD = USER_PWD;
		this.USER_PIC = USER_PIC;
		this.USER_SHORTNAME =USER_SHORTNAME;
		this.USER_SEX = USER_SEX;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}

	public String getUSER_PWD() {
		return USER_PWD;
	}

	public void setUSER_PWD(String uSERPWD) {
		USER_PWD = uSERPWD;
	}

	public String getUSER_PIC() {
		return USER_PIC;
	}

	public void setUSER_PIC(String uSERPIC) {
		USER_PIC = uSERPIC;
	}

	public String getUSER_SHORTNAME() {
		return USER_SHORTNAME;
	}

	public void setUSER_SHORTNAME(String uSERSHORTNAME) {
		USER_SHORTNAME = uSERSHORTNAME;
	}

	public String getUSER_SEX() {
		return USER_SEX;
	}

	public void setUSER_SEX(String uSERSEX) {
		USER_SEX = uSERSEX;
	}
	
}
