package com.learnyeai.base.action.beans;

import com.learnyeai.base.action.login.LoginCons;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.tools.common.BeanMapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建登录会话;
 * 输入：客户id、租户编码
 * @author yaoym
 *
 */
@Service
public class CustSessionCreate {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private CustInfoWyService userService;
//	@Resource
//	private UrSettingService urSettingService;

	/*@Value("${RESOURCE_APP}")
	private String resourceRootPath;*/

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(IBusinessContext ctx) {
		Session session = ThreadContextUtil.getSessionRequired();

		session.setAttribute(SessR.CLIENT_OS, ctx.getParam(SessR.CLIENT_OS)); // 操作系统
		session.setAttribute(SessR.CLIENT_TYPE, ctx.getParam(SessR.CLIENT_TYPE)); // 客户端类型
		session.setAttribute(SessR.CLIENT_INFO, ctx.getParam(SessR.CLIENT_INFO)); // 客户端详情

		CustInfo custInfo = (CustInfo)ctx.getParamMap().get(LoginCons.CUST_INFO_KEY);

		/*WeyeCons.LOGIN_TYPE lgnType = ConsTools.getCons(WeyeCons.LOGIN_TYPE.class, custInfo.getCustType());
		if(CtxCommonUtils.getClientOs() == ConfigEnum.CLIENT_OS.O && lgnType == WeyeCons.LOGIN_TYPE.STAFF){
			lgnType = WeyeCons.LOGIN_TYPE.STAFF_MNG;
		}
		ctx.saveSessionObject(WeyeSessUtils.LOGIN_TYPE, lgnType);*/

		Map custMap = new HashMap();
		try {
			custMap = BeanMapUtils.convertBean(custInfo);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
//		ctx.getParamMap().clear();
		ctx.getParamMap().putAll(custMap);
		//用户设置
		/*Map urSettingMap = urSettingService.queryById(ctx);
		if(urSettingMap!=null){
			ctx.getParamMap().putAll(urSettingMap);
		}*/

		//用户扩展信息
		/*Map userExt = custExtService.queryById(ctx);
		if(userExt!=null){
			ctx.getParamMap().putAll(userExt);
		}*/


		if(custInfo!=null){
			// 设置登录成功标识
			session.setAttribute(SessR.LOGIN_FLAG, SessR.TRUE);
			// 创建用户会话
			String userId = custInfo.getCustId();
			session.setUserId(userId);

			// currentUser所需基本信息
			session.setAttribute(SessR.MOBILE_NO, custInfo.getPhone()); // 手机号
			session.setAttribute(SessR.CUST_LGN,custInfo.getLoginName());//登录名
			session.setAttribute(SessR.CUST_NAME,custInfo.getShortName());//用户名
			session.setAttribute(SessR.CUST_TYPE,custInfo.getCustType());//用户类型
			session.setAttribute(SessR.CUST_SEX, custInfo.getSex());

			/*session.setAttribute(SessR.Y_LINE,ctx.getParam(CustLgnInfo.TF.yLine));//经度
			session.setAttribute(SessR.X_LINE,ctx.getParam(CustLgnInfo.TF.xLine));//纬度*/
			session.setAttribute(SessR.USER_INFO,custMap);

			/*if(urSettingMap!=null){
				session.setAttribute("UR_SETTING",urSettingMap);
			}*/
		}
	}
}
