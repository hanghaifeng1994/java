package com.learnyeai.orderform.payconfig.wx;

import com.learnyeai.orderform.payconfig.wx.WxPayApiConfig.PayModel;

/**
 * @Email javen205@126.com
 * @author Javen 2017年5月22日
 */
public class WxPayApiConfigKit {
	// 公众号支付配置，根据平台及命名规则自动获取配置 add len
	public static WxPayApiConfig getWxGzhPayConfig(String accountSuffix) {
		// 公众号商户相关资料
		WxGzhConfig gzh = WxGzhConfig.getInstance(accountSuffix);
		String appid = gzh.getAppId(); // 公账号id
		String mch_id = gzh.getPartner();// 商户号id
		String partnerKey = gzh.getPartnerKey();// 商户号秘钥
		String notify_url = gzh.getDomain();// 支付回调地址
		WxPayApiConfig apiConfig = WxPayApiConfig.New().setAppId(appid).setMchId(mch_id).setPaternerKey(partnerKey)
				.setPayModel(PayModel.BUSINESSMODEL).setNotifyUrl(notify_url);
		return apiConfig;

	}
}
