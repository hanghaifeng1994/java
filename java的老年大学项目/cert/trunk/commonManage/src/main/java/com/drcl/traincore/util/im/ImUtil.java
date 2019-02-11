package com.drcl.traincore.util.im;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.struts2.json.JSONUtil;

import cn.common.lib.util.web.PropertyUtils;

import com.drcl.traincore.common.util.JsonUtil;
import com.drcl.traincore.util.im.vo.AddMemberBodyVO;
import com.drcl.traincore.util.im.vo.CreateGroupRequestBodyVO;
import com.drcl.traincore.util.im.vo.RegRequestBodyVO;
import com.drcl.traincore.util.im.vo.RegRequestVO;
import com.drcl.traincore.util.im.vo.RequestHeadVO;
import com.drcl.traincore.util.im.vo.ResponseVO;

public class ImUtil {
	public static String hostUrl = PropertyUtils.getPropertyWithConfigName(
			"im.properties", "im.host.url", "");
	private static String open = PropertyUtils.getPropertyWithConfigName(
			"im.properties", "im.open", "false");

	private static String userregurl = PropertyUtils.getPropertyWithConfigName(
			"im.properties", "userreg.url", "");
	private static String createimgroupurl = PropertyUtils.getPropertyWithConfigName(
			"im.properties", "createimgroup.url", "");
	private static String joinusertogroupurl = PropertyUtils.getPropertyWithConfigName(
			"im.properties", "joinusertogroup.url", "");
	
	/**
	 * 同步用户的im服务系统
	 * 
	 * @param userId
	 * @param nick
	 * @param avater 相对地址
	 * @param password
	 * @return
	 */
	public static boolean synUserToIM(long userId, String nick, String avater,
			String password,String sex) {
		if ("false".equals(open))
			return false;
		if(password==null)
			password = "111111";
		HttpClient client = HttpClients.createDefault();
		RegRequestVO regRequestVO = new RegRequestVO();
		
		HttpPost post = new HttpPost(userregurl);
		RequestHeadVO requestHeadVO = new RequestHeadVO("2612390040", "2612390040");
		RegRequestBodyVO regRequestBodyVO = new RegRequestBodyVO(String.valueOf(userId), password, avater, nick, "1");
		regRequestVO.setPayload(regRequestBodyVO);
		regRequestVO.setHeader(requestHeadVO);
		String jsonBody="";
		try{
			jsonBody = JSONUtil.serialize(regRequestVO);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		StringEntity entity;
		try {
			entity = new StringEntity(jsonBody, HTTP.UTF_8); 
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");// 设置为 json数据
			post.setEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpResponse response = null;
		try {
			System.out.println("im userregurl is "+userregurl);
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpEntity resEntity = response.getEntity();
		String res = "";
		try {
			res = EntityUtils.toString(resEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(res);
		if(res.contains("\"success\":\"1\""))
			return true;
		else
			return false;
	}

	/**
	 * 在im服务系统里面创建项目，学习圈，班级对应的群组
	 * 
	 * @param aboutObjectId
	 *            要唯一 学习圈加circle前缀 班级加clazz前缀 培训项目加program前缀比如：clazz_12121
	 * @param name
	 *            群组名称
	 * @param imgname 群图片
	 * 
	 * @param createrId 创建者用户id
	 * 
	 * @return im group id in 环信
	 */
	public static String createGroupInIM(String aboutObjectId, String name,String imgname,Long createrId) {
		if ("false".equals(open))
			return "";
		HttpClient client = HttpClients.createDefault();
		RegRequestVO regRequestVO = new RegRequestVO();

		HttpPost post = new HttpPost(createimgroupurl);
		RequestHeadVO requestHeadVO = new RequestHeadVO("2612390040", "2612390040");
		CreateGroupRequestBodyVO regRequestBodyVO = new CreateGroupRequestBodyVO(name, imgname, name, aboutObjectId, String.valueOf(createrId));
		regRequestVO.setPayload(regRequestBodyVO);
		regRequestVO.setHeader(requestHeadVO);
		String jsonBody="";
		try{
			jsonBody = JSONUtil.serialize(regRequestVO);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		StringEntity entity;
		try {
			entity = new StringEntity(jsonBody, HTTP.UTF_8);  
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");// 设置为 json数据
			post.setEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpEntity resEntity = response.getEntity();
		String res = "";
		try {
			res = EntityUtils.toString(resEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(res);
		if(res.contains("\"success\":\"1\"")){
			ResponseVO rvo;
			try {
				rvo = (ResponseVO)JsonUtil.jsonToObject(res, ResponseVO.class);
				for(String k : rvo.getData().keySet()){
					return rvo.getData().get(k);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}else
			return "";
	}

	/**
	 * 添加用户到群组
	 * 
	 * @param userId
	 * @param groupId
	 *            im服务系统返回的组id
	 * @return
	 */
	public static boolean addGroupMember(String userId, String groupId, String name) {
		if ("false".equals(open))
			return false;
		HttpClient client = HttpClients.createDefault();
		RegRequestVO regRequestVO = new RegRequestVO();

		HttpPost post = new HttpPost(joinusertogroupurl);
		RequestHeadVO requestHeadVO = new RequestHeadVO("4982757722", "4982757722");
		AddMemberBodyVO regRequestBodyVO = new AddMemberBodyVO(userId, groupId,  name);
		regRequestVO.setPayload(regRequestBodyVO);
		regRequestVO.setHeader(requestHeadVO);
		String jsonBody="";
		try{
			jsonBody = JSONUtil.serialize(regRequestVO);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		StringEntity entity;
		try {
			entity = new StringEntity(jsonBody, HTTP.UTF_8); 
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");// 设置为 json数据
			post.setEntity(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpEntity resEntity = response.getEntity();
		String res = "";
		try {
			res = EntityUtils.toString(resEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(res);
		if(res.contains("\"success\":\"1\"")){
			return true;
		}
		return true;
	}
	
	public static void main(String[] args){
		String r = "http://dfkdhttp://dfd";
		if(r.lastIndexOf("http")>1){
			String vr = r;
			vr = vr.substring(vr.lastIndexOf("http"));
			System.out.println(vr);
			//vo.setResourceUrl(vr);
		}
		//ImUtil.synUserToIM(11, "", "", "", "");
		String gid = ImUtil.createGroupInIM("clazz_12121212", "高薪5班", "", 12127L);
		//ImUtil.addGroupMember("121217", "265791775333941672", "xiaosan");
	}
}
