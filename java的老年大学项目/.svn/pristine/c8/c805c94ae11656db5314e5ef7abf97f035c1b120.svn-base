package com.drcl.traincore.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.drcl.traincore.user.adapter.CantonLocalAdapter;
import com.drcl.traincore.user.adapter.UserLocalAdapter;
import com.drcl.traincore.user.dto.CantonDTO;
import com.drcl.traincore.user.dto.UserDTO;
import com.google.common.collect.Lists;

/**
 * 用户工具
 * 
 * @author zhaowei
 * 
 */
public class UserUtils
{

    public static final int CITY   = 1;

    public static final int AREA   = 2;

    public static final int STREET = 3;

    public static final int NOTALL = 0;


    /**
     * 取得当前登录完整用户对象
     * 
     * @return
     */
    public static UserDTO getCurUser()
    {
        String username = SpringSecurityUtils.getCurrentUserName();
        if("anonymousUser".equals(username))return null;
        
        UserDTO user = null;
		try {
			user = UserLocalAdapter.getUserByUsername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return user;
    }

    /**
     * 根据用户名取得用户
     * 
     * @author fangyong
     * @param username
     *            用户名
     * @return
     */
    public static UserDTO getUserByUsername(String username)
    {
        if (StringUtils.isNotBlank(username))
        {
            UserDTO user = null;
    		try {
    			user = UserLocalAdapter.getUserByUsername(username);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return user;
        }
        return null;
    }
    /**
     * 根据用户id取得用户
     * @param userId
     * @return
     */
    public static UserDTO getUser(Long userId)
    {
        UserDTO user = null;
		try {
			user = UserLocalAdapter.getUser(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
    
    /**
     * 是否实名制 --身份证号，姓名，手机号，城市，地区，街道
     * @param user
     * @return
     */
    public static boolean isRealName(UserDTO user){
    	if(user==null)return false;
    	//if(StringUtils.isNotBlank(user.getName())&&StringUtils.isNotBlank(user.getIdcard())&&StringUtils.isNotBlank(user.getMobilephone())&&StringUtils.isNotBlank(user.getCity())&&StringUtils.isNotBlank(user.getArea())&&StringUtils.isNotBlank(user.getStreet()))
    	if(StringUtils.isNotBlank(user.getName())&&StringUtils.isNotBlank(user.getIdcard())&&StringUtils.isNotBlank(user.getMobilephone())&&StringUtils.isNotBlank(user.getCity())&&StringUtils.isNotBlank(user.getArea())&&StringUtils.isNotBlank(user.getStreet()))
    		return true;
    	return false;
    }
    
    public static boolean isRealName(Long userId){
    	UserDTO user = getUser(userId);
    	return isRealName(user);
    }
    
    public static List<CantonDTO>  getAllContonList(){
    	List<CantonDTO> cityList = CantonLocalAdapter.findCity();
    	List<CantonDTO> ctList = Lists.newArrayList();
    	List<CantonDTO> ct = null;
    	for (CantonDTO ctDto : cityList) {
    		ct = CantonLocalAdapter.findByParentid(ctDto.getId());
    		ctList.addAll(ct);
    	}
    	return ctList;
    }
}
