package com.learnyeai.orderform.payconfig.wx;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.learnyeai.orderform.util.PropertyUtils;

public class WxGzhConfig {
	public static String DEFUALT = "defualt";
	// 初始化
	public static String TOKENURL = "https://api.weixin.qq.com/cgi-bin/token";// 获取access_token对应的url
	public static String GRANT_TYPE = "client_credential";// 常量固定值
	public static String EXPIRE_ERRCODE = "42001";// access_token失效后请求返回的errcode
	public static String FAIL_ERRCODE = "40001";// 重复获取导致上一次获取的access_token失效,返回错误码
	public static String GATEURL = "https://api.weixin.qq.com/pay/genprepay?access_token=";// 获取预支付id的接口url
	public static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";// 统一下单
	public static String ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	public static String ACCESS_TOKEN = "access_token";// access_token常量值
	public static String ERRORCODE = "errcode";// 用来判断access_token是否失效的值
	public static String SIGN_METHOD = "sha1";// 签名算法常量值
	// package常量值
	public static String packageValue = "bank_type=WX&body=%B2%E2%CA%D4&fee_type=1&input_charset=GBK&notify_url=http%3A%2F%2F127.0.0.1%3A8180%2Ftenpay_api_b2c%2FpayNotifyUrl.jsp&out_trade_no=2051571832&partner=1900000109&sign=10DA99BCB3F63EF23E4981B331B0A3EF&spbill_create_ip=127.0.0.1&time_expire=20131222091010&total_fee=1";
	public static String traceid = "testtraceid001";// 测试用户id

	public static Map<String, WxGzhConfig> map = new HashMap<String, WxGzhConfig>();

	public static WxGzhConfig getInstance(String endSuffix) {
		if (StringUtils.isBlank(endSuffix)) {
			endSuffix = WxGzhConfig.DEFUALT;
		}
		WxGzhConfig config = map.get(endSuffix);
		if (config == null) {
			String wxconffile = "pay/wx/gzh/wx_pay";
			config = new WxGzhConfig();
			if (!WxGzhConfig.DEFUALT.equals(endSuffix)) {
				wxconffile += "_" + endSuffix;
			}
			wxconffile += ".properties";
			String appId = PropertyUtils.getPropertyWithConfigName(wxconffile, "APP_ID");
			String appSecret = PropertyUtils.getPropertyWithConfigName(wxconffile, "APP_SECRET");
			String partner = PropertyUtils.getPropertyWithConfigName(wxconffile, "PARTNER");
			String partnerKey = PropertyUtils.getPropertyWithConfigName(wxconffile, "PARTNER_KEY");
			String domain = PropertyUtils.getPropertyWithConfigName(wxconffile, "DOMAIN");
			config.setAppId(appId);
			config.setAppSecret(appSecret);
			config.setPartner(partner);
			config.setPartnerKey(partnerKey);
			config.setDomain(domain);
			map.put(endSuffix, config);
		}
		return config;
	}

	private String appId;// 微信开发平台应用id 72cf74560dfd5917d2e72d3d0e884de2
	private String appSecret;// 应用对应的凭证 app有用
	private String partner;// 财付通商户号
	private String partnerKey;// 商户号对应的密钥
	private String domain;// 签名算法常量值

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPartnerKey() {
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
