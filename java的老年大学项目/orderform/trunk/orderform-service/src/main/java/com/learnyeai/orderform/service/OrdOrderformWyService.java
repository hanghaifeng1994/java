package com.learnyeai.orderform.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.MyPage;
import com.learnyeai.mq.OrderformMq;
import com.learnyeai.orderform.mapper.OrdOrderformMapper;
import com.learnyeai.orderform.model.OrdOrderform;
import com.learnyeai.orderform.model.OrdOrderformDetail;
import com.learnyeai.orderform.payconfig.ali.NewAlipayConfig;
import com.learnyeai.orderform.payconfig.wx.PaymentKit;
import com.learnyeai.orderform.payconfig.wx.WxPayApi;
import com.learnyeai.orderform.payconfig.wx.WxPayApi.TradeType;
import com.learnyeai.orderform.payconfig.wx.WxPayApiConfig;
import com.learnyeai.orderform.payconfig.wx.WxPayApiConfigKit;
import com.learnyeai.orderform.util.OrderformUtil;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;

import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 *
 * @author twang
 */
@Service
public class OrdOrderformWyService extends WeyeBaseService<OrdOrderform> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrdOrderformMapper ordOrderformMapper;

	@Autowired
	private OrdOrderformDetailWyService ordOrderformDetailWyService;

	@Autowired
	private RabbitSender rabbitSender;
	
	@Value("${orderform.expire.time}")
	private int orderformExpireTime;

	@Override
	public BaseMapper<OrdOrderform> getMapper() {
		return ordOrderformMapper;
	}

	@Override
	protected boolean isLogicDelete() {
		return false;
	}

	public MyPage<OrdOrderform> queryManagePage(OrdOrderform orderform) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sorts", "createDate=0");
		return super.queryPage(orderform, params);
	}

	public OrdOrderform queryByOrderNo(String orderNo) {
		OrdOrderform orderform = new OrdOrderform();
		orderform.setSn(orderNo);
		return super.queryOne(orderform);
	}

	/**
	 * 报名班级时生成的个人订单 每次新建一个，已存在订单的返回订单号
	 * 
	 * @return
	 */
	@Transactional
	public Map<String, Object> savePersonSignupOrderform(String jsonData) {
		OrdOrderform orderform = JSONObject.parseObject(jsonData).toJavaObject(OrdOrderform.class);
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(orderform.getUserId()) || StringUtils.isBlank(orderform.getCzId())
				|| StringUtils.isBlank(orderform.getBatchId())) {
			map.put("status", -1);
			map.put("msg", "创建订单失败,用户id或订单id不存在!");
			return map;
		}
		OrdOrderform param = new OrdOrderform();
		param.setUserId(orderform.getUserId());
		param.setStatus(1);
		OrdOrderform object = super.queryOne(param);
		if (object != null) {
			map.put("status", 1);
			map.put("msg", "创建订单失败,已存在待付订单!");
			map.put("orderNo", object.getSn());
			map.put("orderId", object.getOrderId());
			return map;
		}
		List<OrdOrderformDetail> details = orderform.getDetails();
		orderform.setType(1);
		orderform.setOrderType(2);
		orderform.setStatus(1);
		orderform.setPayType(1);
		orderform.setQueryNum(0);
		orderform.setFqStatus("0");
		orderform.setUpopSuccess("0");
		orderform.setSn(genSn());
		orderform.setUpopSn(orderform.getSn());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, orderformExpireTime);
		orderform.setEndTime(cal.getTime());
		super.save(orderform);
		for (OrdOrderformDetail detail : details) {
			detail.setOrderId(orderform.getOrderId());
			ordOrderformDetailWyService.save(detail);
		}
		map.put("status", 0);
		map.put("orderNo", orderform.getSn());
		map.put("orderId", orderform.getOrderId());
		map.put("msg", "创建订单成功.");
		return map;
	}

	public OrdOrderform queryOrderformDetail(String orderId) {
		OrdOrderform orderform = super.queryById(orderId);
		OrdOrderformDetail detail = new OrdOrderformDetail();
		detail.setOrderId(orderId);
		List<OrdOrderformDetail> details = ordOrderformDetailWyService.queryList(detail, null);
		orderform.setDetails(details);
		return orderform;

	}

	private synchronized String genSn() {
		return "test" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss" + new Random().nextInt(1000000));
	}

	/**
	 * 微信支付入口
	 */
	public Map<String, String> queryWxpayqrcode(String orderId, String ip) {
		Map<String, String> xml = new HashMap<String, String>();
		OrdOrderform orderform = super.queryById(orderId);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "2");
			xml.put("msg", "订单已完成.");
			return xml;
		}
		String finalmoney = String.format("%.2f", orderform.getRealPrice());
		finalmoney = finalmoney.replace(".", "");
		int total_fee = Integer.parseInt(finalmoney);
		Map<String, String> params = WxPayApiConfigKit.getWxGzhPayConfig("test").setAttach("订单缴费确认").setBody("订单缴费确认")
				.setSpbillCreateIp(ip).setTotalFee(String.valueOf(total_fee)).setTradeType(TradeType.NATIVE)
				.setOutTradeNo(orderform.getSn()).build();
		String xmlResult = WxPayApi.pushOrder(params);
		Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
		String return_code = result.get("return_code");
		String return_msg = result.get("return_msg");
		if (!PaymentKit.codeIsOK(return_code)) {
			logger.debug(return_msg);
			xml.put("msg", return_msg);
			xml.put("status", "1");
			return xml;
		}
		String result_code = result.get("result_code");
		if (!PaymentKit.codeIsOK(result_code)) {
			logger.debug(return_msg);
			xml.put("msg", return_msg);
			xml.put("status", "1");
			return xml;
		}

		// 更新订单支付方式
		orderform.setUpopTime(new Date());
		orderform.setPayPath(OrdOrderform.PAY_QD_WX);
		super.updateBySelect(orderform);

		// 生成预付订单success
		String qrCodeUrl = result.get("code_url");
		xml.put("qrCode", qrCodeUrl);
		xml.put("orderNo", orderform.getSn());
		xml.put("status", "0");
		xml.put("msg", "生成二维码成功.");
		return xml;
	}

	/**
	 * 查询wx订单是否已支付成功
	 * 
	 * @param orderId
	 * @return
	 * @throws WeyeRabbitException
	 */
	public Map<String, String> queryWxOrder(String orderId) throws WeyeRabbitException {
		Map<String, String> xml = new HashMap<String, String>();
		OrdOrderform orderform = super.queryById(orderId);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "0");
			xml.put("msg", "订单已完成.");
			return xml;
		}
		WxPayApiConfig wxPayApiConfig = WxPayApiConfigKit.getWxGzhPayConfig("test");
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", wxPayApiConfig.getAppId());
		params.put("mch_id", wxPayApiConfig.getMchId());
		params.put("out_trade_no", orderform.getSn());
		params.put("nonce_str", String.valueOf(System.currentTimeMillis()));
		params.put("sign_type", "MD5");
		params.put("sign", PaymentKit.createSign(params, wxPayApiConfig.getPaternerKey()));
		String result = WxPayApi.orderQuery(params);
		params = PaymentKit.xmlToMap(result);
		// 已支付
		if (params.containsKey("trade_state") && params.get("trade_state").equalsIgnoreCase("SUCCESS")) {
			orderform.setPayType(OrdOrderform.PAYTYPE_ONLINE);
			orderform.setPaySource(OrdOrderform.PAYSOURCE_ONLINE);
			orderform.setPayPath(OrdOrderform.PAY_QD_WX);
			orderform.setFactPayAppType(OrdOrderform.PAY_APPTYPE_WEB);
			orderform.setUpopSuccess("1");
			orderform.setUpopTime(new Date());
			orderform.setPayDate(new Date());
			orderform.setStatus(OrdOrderform.STATUS_SUCCESSED);
			super.updateBySelect(orderform);
			logger.info("微信支付成功,发送消息到教务------------");
			sendOrderfromMq(orderform);

			xml.put("orderNo", orderform.getSn());
			xml.put("status", "0");
			xml.put("msg", "订单已完成.");
			return xml;
		} else {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "1");
			xml.put("msg", "订单未支付.");
			return xml;
		}
	}

	/**
	 * 微信后台支付回调
	 * 
	 * @throws WeyeRabbitException
	 */
	public boolean saveOrderformCallbackWx(String xmlMsg) throws WeyeRabbitException {
		// 支付结果通用通知文档:
		// https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
		logger.debug("支付通知={}", xmlMsg);
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		String total_fee = params.get("total_fee");
		String result_code = params.get("result_code");
		String out_trade_no = params.get("out_trade_no");
		OrdOrderform orderform = this.queryByOrderNo(out_trade_no);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			return true;
		}
		if (PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxGzhPayConfig("test").getPaternerKey())) {
			if (("SUCCESS").equals(result_code)) {
				// 更新订单信息
				if (orderform.getStatus() != OrdOrderform.STATUS_SUCCESSED) {
					String finalmoney = String.format("%.2f", orderform.getRealPrice());
					finalmoney = finalmoney.replace(".", "");
					// 加上判断金额是否相等
					if (total_fee.equals(String.valueOf(Integer.parseInt(finalmoney)))) {
						orderform.setPaySource(OrdOrderform.PAYSOURCE_ONLINE);
						orderform.setPayPath(OrdOrderform.PAY_QD_WX);
						orderform.setPayType(OrdOrderform.PAYTYPE_ONLINE);
						orderform.setUpopSuccess("1");
						orderform.setStatus(OrdOrderform.STATUS_SUCCESSED);
						orderform.setUpopTime(new Date());
						orderform.setPayDate(new Date());
						orderform.setFactPayAppType(OrdOrderform.PAY_APPTYPE_WEB);
						super.updateBySelect(orderform);

						logger.debug("微信支付回调成功,发送消息到教务------------");
						sendOrderfromMq(orderform);
					}
				} else {
					logger.debug("已经是支付成功状态=");
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 支付宝支付入口
	 */
	public Map<String, String> queryAlipayqrcode(String orderId) {
		Map<String, String> xml = new HashMap<String, String>();
		OrdOrderform orderform = super.queryById(orderId);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "2");
			xml.put("msg", "订单已完成.");
			return xml;
		}
		NewAlipayConfig config = NewAlipayConfig.getInstance("test");
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(config.getGatewayUrl(), config.getAppId(),
				config.getMerchantPrivateKey(), "json", config.getCharset(), config.getAlipayPublicKey(),
				config.getSignType());
		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(config.getReturnUrl());
		alipayRequest.setNotifyUrl(config.getNotifyUrl());
		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(orderform.getSn());
		// 付款金额，必填
		String total_amount = new String(String.valueOf(orderform.getRealPrice()));
		// 订单名称，必填
		String subject = new String(orderform.getName());
		// 商品描述，可空
		String body = new String(orderform.getName());
		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		// 修改表单标签
		result = result.replace("document.forms[0].submit();", "").replace("style=\"display:none\"", "class=\"aliok\"");
		StringBuilder sb = new StringBuilder(result);
		sb.insert(6, " target=\"_blank\" ");

		// 更新订单支付方式
		orderform.setUpopTime(new Date());
		orderform.setPayPath(OrdOrderform.PAY_QD_ALI);
		super.updateBySelect(orderform);

		xml.put("qrCode", sb.toString());
		xml.put("orderNo", orderform.getSn());
		xml.put("status", "0");
		xml.put("msg", "返加支付地址成功.");
		return xml;
	}

	/**
	 * 查询支付宝订单是否已支付成功
	 * 
	 * @param orderId
	 * @return
	 * @throws WeyeRabbitException
	 * @throws AlipayApiException
	 */
	public Map<String, String> queryAliOrder(String orderId) throws WeyeRabbitException, AlipayApiException {
		Map<String, String> xml = new HashMap<String, String>();
		OrdOrderform orderform = super.queryById(orderId);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "0");
			xml.put("msg", "订单已完成.");
			return xml;
		}
		NewAlipayConfig config = NewAlipayConfig.getInstance("test");
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(config.getGatewayUrl(), config.getAppId(),
				config.getMerchantPrivateKey(), "json", config.getCharset(), config.getAlipayPublicKey(),
				config.getSignType());
		// 设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		// 商户订单号，商户网站订单系统中唯一订单号
		String out_trade_no = new String(orderform.getSn());
		// 支付宝交易号
		String trade_no = new String("");
		// 请二选一设置
		alipayRequest
				.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\"}");
		String result = "";
		String trade_status = "";
		double total_amount;
		// 请求
		result = alipayClient.execute(alipayRequest).getBody();
		// 输出
		JSONObject jsonObject = JSONObject.parseObject(result);
		JSONObject jsonObject2 = jsonObject.getJSONObject("alipay_trade_query_response");
		trade_status = jsonObject2.getString("trade_status");
		double realprice = orderform.getRealPrice().doubleValue();
		if (StringUtils.isNotBlank(trade_status) && trade_status.equals("TRADE_SUCCESS")) {
			// 判断支付金额
			total_amount = jsonObject2.getDouble("total_amount");
			if (total_amount == realprice) {
				orderform.setPaySource(OrdOrderform.PAYSOURCE_ONLINE);
				orderform.setPayPath(OrdOrderform.PAY_QD_ALI);
				orderform.setPayType(OrdOrderform.PAYTYPE_ONLINE);
				orderform.setFactPayAppType(OrdOrderform.PAY_APPTYPE_WEB);
				orderform.setUpopSuccess("1");
				orderform.setUpopTime(new Date());
				orderform.setPayDate(new Date());
				orderform.setStatus(OrdOrderform.STATUS_SUCCESSED);
				super.updateBySelect(orderform);
				logger.info("支付宝支付成功,发送消息到教务------------");
				sendOrderfromMq(orderform);

				xml.put("orderNo", orderform.getSn());
				xml.put("status", "0");
				xml.put("msg", "订单已完成.");
				return xml;
			} else {
				logger.info("支付宝支付成功,金额验证失败,orderNo={}|total_amount={}|realprice={}", orderform.getSn(), total_amount,
						realprice);
				xml.put("orderNo", orderform.getSn());
				xml.put("status", "1");
				xml.put("msg", "订单已支付，但金额不对!");
				return xml;
			}
		} else {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "1");
			xml.put("msg", "订单未支付.");
			return xml;
		}
	}

	public boolean saveOrderformCallbackAli(Map<String, String[]> requestParams, String out_trade_no, String trade_no,
			String trade_status) throws WeyeRabbitException {
		OrdOrderform orderform = this.queryByOrderNo(out_trade_no);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			return true;
		}
		Map<String, String> params = new HashMap<String, String>();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		boolean signVerified = false;
		try {
			NewAlipayConfig config = NewAlipayConfig.getInstance("test");
			// 调用SDK验证签名
			signVerified = AlipaySignature.rsaCheckV1(params, config.getAlipayPublicKey(), config.getCharset(),
					config.getSignType());
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if (signVerified) {// 验证成功
			if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
				orderform.setPaySource(OrdOrderform.PAYSOURCE_ONLINE);
				orderform.setPayPath(OrdOrderform.PAY_QD_ALI);
				orderform.setPayType(OrdOrderform.PAYTYPE_ONLINE);
				orderform.setFactPayAppType(OrdOrderform.PAY_APPTYPE_WEB);
				orderform.setUpopSuccess("1");
				orderform.setUpopTime(new Date());
				orderform.setPayDate(new Date());
				orderform.setStatus(OrdOrderform.STATUS_SUCCESSED);
				super.updateBySelect(orderform);
				logger.info("支付宝支付回调成功,发送消息到教务------------");
				sendOrderfromMq(orderform);
				return true;
			}
		} else {// 验证失败
			return false;
		}
		return false;
	}

	/**
	 * 发消息到教务，生成正式用户班级和课程
	 * 
	 * @param orderform
	 * @return
	 * @throws WeyeRabbitException
	 */
	private boolean sendOrderfromMq(OrdOrderform orderform) throws WeyeRabbitException {
		OrderformMq mq = new OrderformMq(orderform.getUserId(), orderform.getOrderId(), orderform.getSn(),
				orderform.getCzId(), orderform.getBatchId());
		RabbitMetaMessage msg = OrderformUtil.toParseRabbitMetaMessage(mq);
		rabbitSender.send(msg);
		return true;
	}

	public Map<String, String> queryOrderStatus(String orderId) throws WeyeRabbitException, AlipayApiException {
		Map<String, String> xml = new HashMap<String, String>();
		OrdOrderform orderform = super.queryById(orderId);
		if (orderform.getStatus() == OrdOrderform.STATUS_SUCCESSED) {
			xml.put("orderNo", orderform.getSn());
			xml.put("status", "0");
			xml.put("msg", "订单已完成.");
			return xml;
		}
		if (OrdOrderform.PAY_QD_WX.equals(orderform.getPayPath())) {
			return queryWxOrder(orderId);
		} else if (OrdOrderform.PAY_QD_ALI.equals(orderform.getPayPath())) {
			return queryAliOrder(orderId);
		}
		xml.put("orderNo", orderform.getSn());
		xml.put("status", "1");
		xml.put("msg", "订单未支付.");
		return xml;
	}

	@Override
	protected Weekend<OrdOrderform> genSqlExample(OrdOrderform t, Map params) {
		Weekend<OrdOrderform> w = super.genSqlExample(t, params);
		WeekendCriteria<OrdOrderform, Object> c = w.weekendCriteria();
		if (StringUtils.isNotBlank(t.getSn())) {
			c.andLike(OrdOrderform::getSn, "%" + t.getSn().trim() + "%");
		}
		if (StringUtils.isNotBlank(t.getName())) {
			c.andLike(OrdOrderform::getName, "%" + t.getName().trim() + "%");
		}
		if (StringUtils.isNotBlank(t.getUserName())) {
			c.andLike(OrdOrderform::getUserName, "%" + t.getUserName().trim() + "%");
		}
		if (StringUtils.isNotBlank(t.getIdcard())) {
			c.andLike(OrdOrderform::getIdcard, "%" + t.getIdcard().trim() + "%");
		}
		if (StringUtils.isNotBlank(t.getBatchId())) {
			c.andEqualTo(OrdOrderform::getBatchId, t.getBatchId());
		}
		if (StringUtils.isNotBlank(t.getUserId())) {
			c.andEqualTo(OrdOrderform::getUserId, t.getUserId());
		}
		if (t.getStatus() != null) {
			c.andEqualTo(OrdOrderform::getStatus, t.getStatus());
		}
		if (t.getType() != null) {
			c.andEqualTo(OrdOrderform::getType, t.getType());
		}
		if (t.getOrderType() != null) {
			c.andEqualTo(OrdOrderform::getOrderType, t.getOrderType());
		}
		if (t.getPayType() != null) {
			c.andEqualTo(OrdOrderform::getPayType, t.getPayType());
		}
		w.and(c);
		return w;
	}
}
