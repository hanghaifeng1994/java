package com.drcl.traincore.util.alipay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import cn.common.lib.util.web.PropertyUtils;

import com.drcl.traincore.contants.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayUtil {

	private static Logger logger = LoggerFactory.getLogger(PayUtil.class);
	
	 /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";


    // 商户PID			
	public static String PARTNER = "2088421985328130";
	// 商户收款账号
	public static String SELLER = "158681110@qq.com";
	// 商户私钥，pkcs8格式
	public static String RSA_PRIVATE ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOZZTHWS9gsHmew3Dc9HHdmcZ9ex0+uaAcvtNv6WE49AczaJOS+y8tXd2XUyMqinUcsbehGmDm8s5wCZVYr1SDnzo2kFa4DrAEbn8LfjN7ZvOWY+ZrZzf9QvsnjvyPJn34XpcCNXPkdrk5Ax6ArlfQFMoaolOAVUC2kki/z7QA6dAgMBAAECgYBrmEKSmLa8qCxJnd2heEKFJv2KTtICNsmoC4GooUk5nI00aByCH0A2jY3JpEztYlpeWNNH8xzC6WJtcTH32mKFbEBmx7++85U2Rksj0UC475jmdjCqxbGKVfCmJrCJUZ73vwwdfBQ5v4vgmfUqr+csNdO0MyyGSRP5Rv+i/HSQAQJBAPsQsGar1RzOvDnRSa8QUkGQY3JK3ocAvVDVgCECVYhjrRKxWgdAg26xDEpujuZAZPUq+Pyy+8Bl98tKdLdIp50CQQDq4F5vZP8amBY1SUKMBmPxCCDPdg11gkRVsHs9CoSi72iYF8Lr9WvHlXn8xJwZ2SBuWESnIBqOcUXnjHIexdMBAkBQtovPZhyMN1ZBzCvBESEwnMervbAOfMlgDFM1yXdP8qN4Z/XGcRIP6vFFmIduNHOAcgE71BqlPuLLwzMEnWHtAkEA2hUYOhApudSrEjECpCcu1tc4N8kiOBCLSJED7Kp+excWI9o0N4j52SgWSzd2xZ1QOoSkwhTR856DTLqgH6iJAQJAGTVxx1RVPE4ZbmYtUhNb+N/KZ4E/IHJkelctfxPq0bRbrR0xGbPjiauhuJL2mHmuAVvtdTQz4lsym6hdKk/DfQ==";
	// 支付宝公钥
	public static String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	
	private static final int SDK_PAY_FLAG = 1;

	private static final int SDK_CHECK_FLAG = 2;
	
	static{
		String pt = null;
		try{
			pt = Configuration.getPlatform();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		logger.debug("app alipay param");
		String aliconffile = "pay/ali/app/ali_pay_"+pt+".properties";
		PARTNER = PropertyUtils.getPropertyWithConfigName(aliconffile,"partner.pid");
		SELLER = PropertyUtils.getPropertyWithConfigName(aliconffile,"seller");
//		app_id = PropertyUtils.getPropertyWithConfigName(aliconffile,"app_id");
		RSA_PRIVATE = PropertyUtils.getPropertyWithConfigName(aliconffile,"merchant_private_key");
		RSA_PUBLIC = PropertyUtils.getPropertyWithConfigName(aliconffile,"alipay_public_key");
		logger.debug(aliconffile);
		logger.debug(PARTNER);
		logger.debug(SELLER);
		logger.debug(RSA_PRIVATE);
		logger.debug(RSA_PUBLIC);
		/*notify_url = PropertyUtils.getPropertyWithConfigName(aliconffile,"notify_url");
		return_url = PropertyUtils.getPropertyWithConfigName(aliconffile,"return_url");
		sign_type = PropertyUtils.getPropertyWithConfigName(aliconffile,"sign_type");
		charset = PropertyUtils.getPropertyWithConfigName(aliconffile,"charset");
		sign_type = PropertyUtils.getPropertyWithConfigName(aliconffile,"sign_type");
		gatewayUrl = PropertyUtils.getPropertyWithConfigName(aliconffile,"gatewayUrl");
		log_path = PropertyUtils.getPropertyWithConfigName(aliconffile,"log_path");*/
	}

	/**
	 * create the order info. 创建订单信息
	 * 
	 */
	public  static String getOrderInfo(String subject, String body, String price, String orderNo, String webhost) {

		// 签约合作者身份ID
		String orderInfo = "partner=" + "\"" + PARTNER + "\"";

		// 签约卖家支付宝账号
		orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

		// 商户网站唯一订单号
		orderInfo += "&out_trade_no=" + "\"" + orderNo + "\"";

		// 商品名称
		orderInfo += "&subject=" + "\"" + subject + "\"";

		// 商品详情
		orderInfo += "&body=" + "\"" + body + "\"";

		// 商品金额
		orderInfo += "&total_fee=" + "\"" + price + "\"";

		// 服务器异步通知页面路径
		orderInfo += "&notify_url=" + "\"" + webhost+"/app/api/" + Configuration.getPlatform() +
				"/paySuccessAliCallback.excsec"//"http://notify.msp.hk/notify.htm"
				+ "\"";

		// 服务接口名称， 固定值
		orderInfo += "&service=\"mobile.securitypay.pay\"";

		// 支付类型， 固定值
		orderInfo += "&payment_type=\"1\"";

		// 参数编码， 固定值
		orderInfo += "&_input_charset=\"utf-8\"";

		// 设置未付款交易的超时时间
		// 默认30分钟，一旦超时，该笔交易就会自动被关闭。
		// 取值范围：1m～15d。
		// m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
		// 该参数数值不接受小数点，如1.5h，可转换为90m。
		orderInfo += "&it_b_pay=\"30m\"";

		// extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
		// orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

		// 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
		orderInfo += "&return_url=\"m.alipay.com\"";

		// 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
		// orderInfo += "&paymethod=\"expressGateway\"";

		return orderInfo;
	}

	/**
	 * sign the order info. 对订单信息进行签名
	 * 
	 * @param content
	 *            待签名订单信息
	 */
	public static String sign(String content) {
		return SignUtils.sign(content, RSA_PRIVATE);
	}

	/**
	 * get the sign type we use. 获取签名方式
	 * 
	 */
	public static String getSignType() {
		return "sign_type=\"RSA\"";
	}
	/**
    * 获取远程服务器ATN结果
    * @param urlvalue 指定URL路径地址
    * @return 服务器ATN结果
    * 验证结果集：
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
    * true 返回正确信息
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
    /**
     * 获取远程服务器ATN结果,验证返回URL
     * @param notify_id 通知校验ID
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
     private static String verifyResponse(String notify_id) {
         //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

         String partner = PARTNER;
         String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

         return checkUrl(veryfy_url);
     }
    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = true;//getRSASignVerify(params, sign);

        //写日志记录（若要调试，请取消下面两行注释）
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
	public static void main(String args[]){
		RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJrWv82fXoVYvVlVrgGHNsdkrS7W+K6TWBJh87dG4mmHTDPtEAIPQ6Kj3FjCR/SdH506MBBPE3CiqnspEvbSYKqP9qHj3+DoxS4cXI1M+fYDgYEgCyM8BXfHKIYNHU5ArqKLFhsQx336v6euzV+Id4DiK5IRlNeuQejbRcZAXITjAgMBAAECgYA3y6rSLduhsZiJ2JYbdt4GfADsIAr83ZufBC0Onjx4SojrLUHXfCijMuj0Ew5a10PNJGqtddFLhVJpjyOGTckHHdHnXHV/3Rw4csQVG4WG+urOUugdrGHcL3MCWw8MaeLR3ar6ZkKL9bm1qaCyj+QNvjV3GgUYOXuJQoVxdmEGAQJBAMvwDDYh2RkOLMjPsE8yEPAtLMfLuSrojCy0m69ZplHxFT+HFJ0tE4Jsl9ukAwdkrbaB4yc+UX2Smx6jkKVckEUCQQDCXfFydZJc8Fqo69LvneUSGJC6LCfv0TT0elAyj+OsUhBpbMUM9XLhBZVWvCJlE+QksLyfc8++sVrwgbuMOvcHAkAtVFrygU2HEy6DKB7RS5iWOgRVGIQ89FmL6k0cibm9Ru/pIfZEBWvrtoV+jZMaxpcSFQbPhzuHxNlz0vlouA1dAkEApe2lDd2pEYZvHv4TmVPmFsi55PWFMooa9wrkJAYKizWTpSyiHCn95HPrxZvekQOmJFxs6oLnuxeVVvSps1EzSQJBAJa+EaiWaqapcL5NUSG6DI2KtBKuJyyZG1dNjyAMHrL5LaGNH9KI49t5UzP1Jp7hV7VMKJxLZVwCN6VsE0RZJac=";
		String ss = sign("a=123");
		ss = ss;
		// UBDoUeel1mTudEioDVN5Ly5hLsOlr1XxHL1+YPY0WqZk3Q/dBoTz/RDiG2EQL0895kGOk5bSODgiErbHGPEzr7EjelP6AT5bnWiVh/o2FBpG6ErcKeGG0A++I+BjYG7/6h4gWQyK9ptUBYNI7c76pLUzDp5zHo+3zSnpUN4meCs=
	}
}
