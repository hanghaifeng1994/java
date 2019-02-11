package com.learnyeai.orderform.web.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.learnai.support.ApiBaseController;
import com.learnyeai.learnai.support.BaseService;
import com.learnyeai.orderform.model.OrdOrderform;
import com.learnyeai.orderform.service.OrdOrderformWyService;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;

/**
 *
 * @author twang
 */
@RestController
@RequestMapping("${adminPath}" + OrdOrderformAction.BASE_URL)
public class OrdOrderformAction extends ApiBaseController<OrdOrderform> {
	public static final String BASE_URL = "/OrdOrderform/";
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrdOrderformWyService ordOrderformWyService;

	@Override
	protected BaseService<OrdOrderform> getBaseService() {
		return ordOrderformWyService;
	}

	@Override
	public String getBaseUrl() {
		return BASE_URL;
	}

	@RequestMapping(value = "/savePersonSignupOrderform", method = RequestMethod.GET)
	public Map<String, Object> savePersonSignupOrderform(@RequestBody String jsonData) {
		return ordOrderformWyService.savePersonSignupOrderform(jsonData);
	}

	@RequestMapping(value = "/saveOrderformCallbackWx")
	public String saveOrderformCallbackWx(String xmlMsg) {
		logger.debug("微信发起回调开始 msg={}",xmlMsg);
		String msg = "FAILL";
		boolean success = false;
		try {
			success = ordOrderformWyService.saveOrderformCallbackWx(xmlMsg);
			logger.debug("微信发起回调结束{}",success);
		} catch (WeyeRabbitException e) {
			e.printStackTrace();
			logger.debug("微信发起回调异常结束{}",e.getMessage());
		}
		if (success)
			msg = "SUCCESS";
		return msg;
	}

	@RequestMapping(value = "/saveOrderformCallbackAli", method = RequestMethod.GET)
	public String saveOrderformCallbackAli(HttpServletRequest request) {
		logger.debug("支付宝发起回调开始---------------------");
		Map<String, String[]> requestParams = request.getParameterMap();
		String out_trade_no = request.getParameter("out_trade_no");
		String trade_no = request.getParameter("trade_no");
		String trade_status = request.getParameter("trade_status");
		logger.debug("支付宝发起回调out_trade_no={}|out_trade_no={]|trade_status={}",out_trade_no,trade_no,trade_status);
		String msg = "FAILL";
		boolean success = false;
		try {
			success = ordOrderformWyService.saveOrderformCallbackAli(requestParams, out_trade_no, trade_no,
					trade_status);
			logger.debug("支付宝发起回调结束{}",success);
		} catch (WeyeRabbitException e) {
			e.printStackTrace();
			logger.debug("支付宝发起回调异常结束{}",e.getMessage());
		}
		if (success)
			msg = "SUCCESS";
		return msg;
	}
}
