package com.learnyeai.tools.http;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zpz on 2017/3/8.
 */
public class HttpClient {
    private static final int TIMEOUT_IN_MILLIONS = 5000;

    private String url;
    private Map<String, String> reqHeads = new HashMap<String, String>();

    public HttpClient(){}
    public HttpClient(String url){
        this.url = url;
    }
    public HttpClient(String url, Map<String, String> heads){
        this.url = url;
        this.reqHeads.putAll(heads);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getReqHeads() {
        return reqHeads;
    }

    public void setReqHeads(Map<String, String> reqHeads) {
        this.reqHeads.clear();
        this.reqHeads.putAll(reqHeads);
    }
    public void addHead(String key, String val){
        this.reqHeads.put(key, val);
    }

    public interface CallBack
    {
        void onRequestComplete(String result);
    }


    /**
     * 异步的Get请求
     *
     * @param callBack
     */
    public void doGetAsyn(final CallBack callBack)
    {
        new Thread()
        {
            public void run()
            {
                try
                {
                    String result = doGet();
                    if (callBack != null)
                    {
                        callBack.onRequestComplete(result);
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }

            };
        }.start();
    }

    /**
     * 异步的Post请求
     * @param params
     * @param callBack
     * @throws Exception
     */
    public void doPostAsyn(final String params,
                                  final CallBack callBack) throws Exception
    {
        new Thread()
        {
            public void run()
            {
                try
                {
                    String result = doPost(params);
                    if (callBack != null)
                    {
                        callBack.onRequestComplete(result);
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }

            };
        }.start();

    }

    /**
     * Get请求，获得返回数据
     *
     * @return
     * @throws Exception
     */
    public String doGet()
    {
        URL ur = null;
        HttpURLConnection conn = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try
        {
            ur = new URL(url);
            conn = (HttpURLConnection) ur.openConnection();
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            if(null != reqHeads){
                for(Iterator<Map.Entry<String, String>> it=reqHeads.entrySet().iterator(); it.hasNext();){
                    Map.Entry<String, String> o = it.next();
                    conn.setRequestProperty(o.getKey(),o.getValue());

                }
            }
            if (conn.getResponseCode() == 200)
            {
                is = conn.getInputStream();
                baos = new ByteArrayOutputStream();
                int len = -1;
                byte[] buf = new byte[128];

                while ((len = is.read(buf)) != -1)
                {
                    baos.write(buf, 0, len);
                }
                baos.flush();
                return baos.toString();
            } else
            {
                throw new RuntimeException(" responseCode is not 200 ... ");
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (is != null)
                    is.close();
            } catch (IOException e)
            {
            }
            try
            {
                if (baos != null)
                    baos.close();
            } catch (IOException e)
            {
            }
            conn.disconnect();
        }

        return null ;

    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     * @throws Exception
     */
    public String doPost(String param)
    {
//        PrintWriter out = null;
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl
                    .openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            if(null != reqHeads){
                for(Iterator<Map.Entry<String, String>> it=reqHeads.entrySet().iterator(); it.hasNext();){
                    Map.Entry<String, String> o = it.next();
                    conn.setRequestProperty(o.getKey(),o.getValue());

                }
            }

            conn.setUseCaches(false);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(TIMEOUT_IN_MILLIONS);
            conn.setConnectTimeout(TIMEOUT_IN_MILLIONS);

            if (param != null && !param.trim().equals(""))
            {
                /*out = conn.getOutputStream();
                out.write(param.getBytes("utf-8"));*/
                out = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
                out.write(param);
                // flush输出流的缓冲
                out.flush();
            }
//            byte[] bytes = FileUtil.readFileBinary(conn.getInputStream());
//            result = new String(bytes, "utf-8");
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
