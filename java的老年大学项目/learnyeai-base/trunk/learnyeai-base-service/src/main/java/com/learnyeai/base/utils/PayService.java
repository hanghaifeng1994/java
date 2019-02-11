package com.learnyeai.base.utils;

/**
 *
 * @author lpt
 */
/*
@Service
public class PayService {
    private static final Logger logger = LoggerFactory.getLogger(PayService.class);
    private static boolean debug = true;//debug模式下不发起支付




    */
/**
     * 微信支付发起
     *
     * @param res
     * @return
     *//*

    public Map wxPay(Map res) {
        //商户相关资料
        String appid = ConstantUtil.APP_ID;
        //String appsecret = ConstantUtil.APP_SECRET;
        String mch_id = ConstantUtil.PARTNER;
        //String partnerkey = ConstantUtil.PARTNER_KEY;
        String nonce_str = WXUtil.getNonceStr();
        String body = (String) res.get("body");
        //商户订单号
        String out_trade_no = (String) res.get("out_trade_no");//订单号
        String finalmoney = String.format("%.2f", res.get("totalFee"));
        finalmoney = finalmoney.replace(".", "");
        int total_fee = Integer.parseInt(finalmoney);
        String notify_url = "";//todo 微信支付回调地址不可带参数
        System.out.println(notify_url);
        String trade_type = "APP";
        String timestamp = WXUtil.getTimeStamp();
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("appid", appid);
        parameters.put("mch_id", mch_id);
        parameters.put("nonce_str", nonce_str);
        parameters.put("body", body);
        parameters.put("out_trade_no", out_trade_no);

        parameters.put("total_fee", total_fee + "");
        parameters.put("spbill_create_ip", "123.21.21.21");//用户ip地址
        parameters.put("notify_url", notify_url);
        //parameters.put("timestamp", timestamp);

        parameters.put("trade_type", trade_type);
        String sign = WXUtil.createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        String requestXML = WXUtil.getRequestXml(parameters);
        System.out.println(requestXML);
        String result = WXUtil.httpsRequest(ConstantUtil.UNIFIED_ORDER_URL, "POST", requestXML);
        System.out.println(result);
        Map<String, String> map = null;
        try {
            map = WXUtil.doXMLParse(result);//解析微信返回的信息，以Map形式存储
            WXPayParam param = new WXPayParam();
            param.setPackageValue("Sign=WXPay");
            param.setAppid(appid);
            param.setNoncestr(nonce_str);
            param.setPartnerid(mch_id);
            param.setPrepayid(map.get("prepay_id"));
            param.setTimestamp(timestamp);

            //输出参数列表
            parameters = new TreeMap<String, String>();
            parameters.put("appid", appid);
            parameters.put("noncestr", nonce_str);
            parameters.put("package", "Sign=WXPay");
            parameters.put("partnerid", mch_id);
            parameters.put("prepayid", map.get("prepay_id"));
            parameters.put("timestamp", timestamp);
            //生成签名
            sign = WXUtil.createSign("UTF-8", parameters);
            param.setSign(sign);
            if ((map.get("return_code")).equals("FAIL")) {
                param.setCode("return_code_FAIL");//
                param.setMsg(map.get("return_msg"));
                res.put("unifiedOrder", param);
                return res;
            }
            if ((map.get("result_code")).equals("FAIL")) {
                param.setCode("result_code_FAIL");//
                param.setMsg(map.get("err_code") + "--" + map.get("err_code_des"));
                res.put("unifiedOrder", param);
                return res;
            }
            param.setCode("success");
            res.put("unifiedOrder", param);
            return res;
        } catch (JDOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
    */
/**
     * 支付宝支付发起
     *
     * @param res body  totalFee  out_trade_no
     * @return
     *//*

    public Map aliPay(Map res) {
        String subject = (String) res.get("body");//商品名称
        String body = (String) res.get("body");//商品描述
        String price = (String) res.get("totalFee");//订单金额
        String orderNo = (String) res.get("out_trade_no");//订单号
        String notifyUrl = "";//回调地址
        String orderInfo = PayUtil.getOrderInfo(subject, body, price, orderNo, notifyUrl);
        // 对订单做RSA 签名
        String sign = PayUtil.sign(orderInfo);
        try {
            // 仅需对sign 做URL编码
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        // 完整的符合支付宝参数规范的订单信息
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&"
                + "sign_type=\"RSA\"";
        res.put("payInfo", payInfo);
        return res;
    }

}
*/
