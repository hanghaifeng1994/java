package com.drcl.traincore.vo;

import com.drcl.traincore.user.dto.UserDTO;
/**
 * 辅导老师选择状态vo
 * @author zhaowei
 *
 */
public class TutorCheckVO {

	private UserDTO userDTO;//辅导老师用户
	private boolean checked;//是否被选择过了

	public TutorCheckVO()
	{
	}
	
	public TutorCheckVO(UserDTO userDTO ,boolean isChecked)
	{
		this.userDTO=userDTO;
		this.checked=isChecked;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
