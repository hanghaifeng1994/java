package com.learnyeai.tools.common;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zpz on 2016/2/26.
 */
public class WeixinUtils {
    private static Logger log = LoggerFactory.getLogger(WeixinUtils.class);
    public static class OAuthInfo{
        private String accessToken;
        private int expiresIn;
        private String refreshToken;
        private String openId;
        private String scope;

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }
    }
    /**
     * 与微信交互，get请求
     **/
    public static String getWeiXin(String urlNameString){
        String result = "";
        BufferedReader in = null;
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
            throw new RuntimeException("发送GET请求出现异常！");
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    /*public static String postWeiXin(String urlParams,String content)throws WeixinException{

        DataOutputStream out = null;
        InputStream is = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                    new java.security.SecureRandom());

            URL console = new URL(urlParams);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();
            out = new DataOutputStream(conn.getOutputStream());
            out.write(content.getBytes("utf-8"));
            // 刷新、关闭
            out.flush();
//	        out.close();
            is = conn.getInputStream();
            if (is != null) {
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
//	            is.close();
                return new String(outStream.toByteArray(),"utf-8");
            }
//			return "{\"result\":\"error\",\"message\":\"更新微信菜单错误\"}";
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new WeixinException("post请求失败");
        }
        finally{
            if(null != out)
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if(null != is)
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }*/
    public static OAuthInfo getOAuthOpenId(String appid, String secret, String code ) {
        OAuthInfo oAuthInfo = null;
        String o_auth_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code;";
        String requestUrl = o_auth_openid_url.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);

        JSONObject jsonObject = JSONObject.parseObject(getWeiXin(requestUrl));

        //oAuthInfo是作者自己把那几个属性参数写在一个类里面了。
        // 如果请求成功
        if (null != jsonObject) {
            try {
                oAuthInfo = new OAuthInfo();
                oAuthInfo.setAccessToken(jsonObject.getString("access_token"));
                oAuthInfo.setExpiresIn(jsonObject.getInteger("expires_in"));
                oAuthInfo.setRefreshToken(jsonObject.getString("refresh_token"));
                oAuthInfo.setOpenId(jsonObject.getString("openid"));
                oAuthInfo.setScope(jsonObject.getString("scope"));
            } catch (JSONException e) {
                oAuthInfo = null;
                // 获取token失败
                log.error("网页授权获取openId失败 errcode:{} errmsg:{}", jsonObject
                        .getInteger("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return oAuthInfo;
    }
}

/*
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //参数
        String code = request.getParameter("code");


        if(null != code && !"".equals(code)){
            log.info("==============[OAuthServlet]获取网页授权code不为空，code="+code);
            //根据code换取openId
            OAuthInfo oa = WeixinUtil.getOAuthOpenId(Constants.appId,Constants.appSecret,code);
            UserInfo info = WeixinUtil.getUserInfo(oa.getAccessToken(), oa.getOpenId());
            if(!"".equals(oa) && null != oa){
                request.setAttribute("openid", oa.getOpenId());
                request.setAttribute("nickname", info.getNickname());
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            }else{
                log.info("==============[OAuthServlet]获取网页授权openId失败！");
            }
        }else{
            log.info("==============[OAuthServlet]获取网页授权code失败！");
        }
    }*/
