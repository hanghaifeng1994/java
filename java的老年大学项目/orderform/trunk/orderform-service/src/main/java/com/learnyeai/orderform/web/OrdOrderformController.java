package com.learnyeai.orderform.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.jfinal.kit.StrKit;
import com.learnyeai.learnai.context.CtxHeadUtil;
import com.learnyeai.learnai.support.BaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.orderform.model.OrdOrderform;
import com.learnyeai.orderform.service.OrdOrderformWyService;
import com.learnyeai.orderform.util.IpUtil;
import com.learnyeai.orderform.util.OrderformUtil;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + OrdOrderformController.BASE_URL)
public class OrdOrderformController extends BaseController<OrdOrderform> {
	public static final String BASE_URL = "/OrdOrderform/";

	@Autowired
	private OrdOrderformWyService ordOrderformWyService;

	@Override
	protected BaseService<OrdOrderform> getService() {
		return ordOrderformWyService;
	}

	@Override
	public Object execute(IBusinessContext ctx) {
		String method = CtxHeadUtil.getControllerMethod();
		OrdOrderform cc = ordOrderformWyService.convert2Bean(ctx.getParamMap());
		cc.setSiteIds(OrderformUtil.convertSiteIds((String) ctx.getParamMap().get("sites")));
		if ("queryManagePage".equals(method)) {
			return rtnPageList4Report(ordOrderformWyService.queryManagePage(cc));
		}
		if ("queryById".equals(method)) {
			return ordOrderformWyService.queryOrderformDetail(cc.getOrderId());
		}
		if ("queryWxpayqrcode".equals(method)) {
			String ip = IpUtil.getIpAddr(ctx.getRequest());
			if (StringUtils.isBlank(ip) || ip.contains(":")) {
				ip = "127.0.0.1";
			}
			return ordOrderformWyService.queryWxpayqrcode(cc.getOrderId(), ip);
		}
		if ("queryWxOrder".equals(method)) {
			try {
				return ordOrderformWyService.queryWxOrder(cc.getOrderId());
			} catch (WeyeRabbitException e) {
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("status", "1");
				xml.put("msg", "系统异常,订单未支付.");
				return xml;
			}
		}

		if ("queryAipayCode".equals(method)) {
			return ordOrderformWyService.queryAlipayqrcode(cc.getOrderId());
		}

		if ("queryAliOrder".equals(method)) {
			try {
				return ordOrderformWyService.queryAliOrder(cc.getOrderId());
			} catch (WeyeRabbitException e) {
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("status", "1");
				xml.put("msg", "订单未支付.");
				return xml;
			} catch (AlipayApiException e) {
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("status", "1");
				xml.put("msg", "系统异常,订单未支付.");
				return xml;
			}
		}

		if ("queryOrderStatus".equals(method)) {
			try {
				return ordOrderformWyService.queryOrderStatus(cc.getOrderId());
			} catch (WeyeRabbitException e) {
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("status", "1");
				xml.put("msg", "订单未支付.");
				return xml;
			} catch (AlipayApiException e) {
				Map<String, String> xml = new HashMap<String, String>();
				xml.put("status", "1");
				xml.put("msg", "系统异常,订单未支付.");
				return xml;
			}
		}
		return super.execute(ctx);
	}
}
