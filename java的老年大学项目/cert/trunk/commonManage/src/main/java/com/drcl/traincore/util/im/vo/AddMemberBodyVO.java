package com.drcl.traincore.util.im.vo;
/**
 * im接口添加成员baody
 * @author ycguo
 *
 */
public class AddMemberBodyVO {
	private String USER_ID;//用户id
	private String GP_ID;//群组im id
	private String GM_CARD;//群昵称

	public AddMemberBodyVO(String USER_ID, String GP_ID, String GM_CARD){
		this.USER_ID = USER_ID;
		this.GP_ID = GP_ID;
		this.GM_CARD = GM_CARD;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}

	public String getGP_ID() {
		return GP_ID;
	}

	public void setGP_ID(String gPID) {
		GP_ID = gPID;
	}

	public String getGM_CARD() {
		return GM_CARD;
	}

	public void setGM_CARD(String gMCARD) {
		GM_CARD = gMCARD;
	}
	
}
