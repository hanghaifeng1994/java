package com.learnyeai.orderform.payconfig.ali;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.learnyeai.orderform.util.PropertyUtils;

/* *
 *类名：AlipayConfig
 *功能：基础配置类a
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class NewAlipayConfig {

	public static String DEFUALT = "defualt";
	public static Map<String, NewAlipayConfig> map = new HashMap<String, NewAlipayConfig>();

	public static NewAlipayConfig getInstance(String endSuffix) {
		if (StringUtils.isBlank(endSuffix)) {
			endSuffix = NewAlipayConfig.DEFUALT;
		}
		NewAlipayConfig config = map.get(endSuffix);
		if (config == null) {
			config = new NewAlipayConfig();
			String aliconffile = "pay/ali/ali_pay";
			if (!NewAlipayConfig.DEFUALT.equals(endSuffix)) {
				aliconffile += "_" + endSuffix;
			}
			aliconffile += ".properties";
			String appId = PropertyUtils.getPropertyWithConfigName(aliconffile, "app_id");
			String merchantPrivateKey = PropertyUtils.getPropertyWithConfigName(aliconffile, "merchant_private_key");
			String alipayPublicKey = PropertyUtils.getPropertyWithConfigName(aliconffile, "alipay_public_key");
			String notifyUrl = PropertyUtils.getPropertyWithConfigName(aliconffile, "notify_url");
			String returnUrl = PropertyUtils.getPropertyWithConfigName(aliconffile, "return_url");
			String gatewayUrl = PropertyUtils.getPropertyWithConfigName(aliconffile, "gatewayUrl");
			String logPath = PropertyUtils.getPropertyWithConfigName(aliconffile, "log_path");
			String signType = PropertyUtils.getPropertyWithConfigName(aliconffile, "sign_type");
			String charset = PropertyUtils.getPropertyWithConfigName(aliconffile, "charset");
			config.setAppId(appId);
			config.setMerchantPrivateKey(merchantPrivateKey);
			config.setAlipayPublicKey(alipayPublicKey);
			config.setNotifyUrl(notifyUrl);
			config.setReturnUrl(returnUrl);
			config.setGatewayUrl(gatewayUrl);
			config.setLogPath(logPath);
			config.setSignType(signType);
			config.setCharset(charset);
			map.put(endSuffix, config);
		}
		return config;
	}

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	private String appId;
	// 商户私钥，您的PKCS8格式RSA2私钥
	private String merchantPrivateKey;
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	private String alipayPublicKey;
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	private String notifyUrl;
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	private String returnUrl;
	private String logPath;
	// 签名方式
	private String signType;
	// 字符编码格式
	private String charset;
	// 支付宝网关
	private String gatewayUrl;

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMerchantPrivateKey() {
		return merchantPrivateKey;
	}

	public void setMerchantPrivateKey(String merchantPrivateKey) {
		this.merchantPrivateKey = merchantPrivateKey;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getGatewayUrl() {
		return gatewayUrl;
	}

	public void setGatewayUrl(String gatewayUrl) {
		this.gatewayUrl = gatewayUrl;
	}

}
