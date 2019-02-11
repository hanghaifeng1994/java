package com.learnyeai.learnai.utils.smg.util;

import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;


/**
 * 短信接口业务逻辑类
 * @author Administrator
 *
 */
@Component
public class SmsService{
	private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

	private static boolean debug = false;//debug模式下不发送短信
	

    /**
     * 获取验证码
     *
     * @param mobile 用户手机号码
     * @return 验证码
     */
    /*public String getSmscode(String mobile){
        String code = String.valueOf(random.nextInt(8999) + 1000);
        SmscodeVO smscode = new SmscodeVO();
        smscode.setCode(code);
        smscode.setDatetime(System.currentTimeMillis());
        cacheManager.put(CacheKeyUtil.buildSmscodeCacheKey(mobile), smscode);
        return code;
    }*/
    
    /**
     * 
     * @param mobile
     * @param code
     * @throws
     * @throws UnsupportedEncodingException
     * @throws MalformedURLException
     */
	public static void sendSmscode(String mobile, String code) throws UnsupportedEncodingException, MalformedURLException {
        if (debug) {
            logger.debug("sms.debug=true 模式下不发送短信");
            return;
        }
        //String message = getTemplate().format(new Object[]{code});
        logger.debug("发送短信：\n{}\n至 {}", code, mobile);
        //System.out.println(url + "?mobile=" + mobile + "&tpl_id="+tpl_id+"&tpl_value="+URLEncoder.encode("#code#="+code,"utf-8")+"&key="+key);
        //String send_content = URLEncoder.encode(message.replaceAll("<br/>", " "), "GBK");//发送内容
        URL connection = new URL(MsgConstants.MSG_URL + "?mobile=" + mobile + "&tpl_id="+MsgConstants.MSG_TPL_ID+"&tpl_value="+URLEncoder.encode("#code#="+code,"utf-8")+"&key="+MsgConstants.SMG_KEY);
        BufferedReader in = null;
        HttpURLConnection con = null;
        try {
            logger.debug("调用发短信接口： {}", connection);
            con = (HttpURLConnection) connection.openConnection();
            con.connect();
            boolean isError = con.getResponseCode() >= 400;
            InputStream is = isError ? con.getErrorStream() : con.getInputStream();
            String response = StreamUtils.copyToString(is, Charset.forName("utf-8"));

            logger.debug("发送短信接口返回：\n{}", response);
            Map object = JsonMapper.jsonToMap(response.toString());
            int error_code = (Integer) object.get("error_code");
            if (error_code != 0) {
                throw new RuntimeException("短信验证码发送失败：" + response);
            }
        } catch (IOException ex) {
            throw new RuntimeException("发送短信时出现网络错误", ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
                if (con != null) {
                    con.disconnect();
                }
            }
        }
    }


    /**
     *
     * @param mobile
     * @param code
     * @throws
     * @throws UnsupportedEncodingException
     * @throws MalformedURLException
     */
    public static void sendSmscode(String mobile,String tplId, String tplValue) throws UnsupportedEncodingException, MalformedURLException {
        if (debug) {
            logger.debug("sms.debug=true 模式下不发送短信");
            return;
        }
        //String message = getTemplate().format(new Object[]{code});
        logger.debug("发送短信：\n{}\n至 {}", tplValue, mobile);
        //System.out.println(url + "?mobile=" + mobile + "&tpl_id="+tpl_id+"&tpl_value="+URLEncoder.encode("#code#="+code,"utf-8")+"&key="+key);
        //String send_content = URLEncoder.encode(message.replaceAll("<br/>", " "), "GBK");//发送内容
        URL connection = new URL(MsgConstants.MSG_URL + "?mobile=" + mobile + "&tpl_id="+tplId+"&tpl_value="+URLEncoder.encode(tplValue,"utf-8")+"&key="+MsgConstants.SMG_KEY);
        BufferedReader in = null;
        HttpURLConnection con = null;
        try {
            logger.debug("调用发短信接口： {}", connection);
            con = (HttpURLConnection) connection.openConnection();
            con.connect();
            boolean isError = con.getResponseCode() >= 400;
            InputStream is = isError ? con.getErrorStream() : con.getInputStream();
            String response = StreamUtils.copyToString(is, Charset.forName("utf-8"));

//            StreamUtils.copyToString(is, new Charset("utf-8"));
            logger.debug("发送短信接口返回：\n{}", response);
            Map object = JsonMapper.jsonToMap(response.toString());
            int error_code = (Integer) object.get("error_code");
            if (error_code != 0) {
                throw new RuntimeException("短信验证码发送失败：" + response);
            }
        } catch (IOException ex) {
            throw new RuntimeException("发送短信时出现网络错误", ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    throw new IllegalStateException(ex);
                }
                if (con != null) {
                    con.disconnect();
                }
            }
        }
    }

}
