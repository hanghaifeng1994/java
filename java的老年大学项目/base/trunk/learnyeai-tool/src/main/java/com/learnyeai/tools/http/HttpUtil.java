package com.learnyeai.tools.http;

/**
 * Created by zpz on 2017/3/24.
 */
public class HttpUtil {
    public static void doGetAsyn(final String urlStr, final HttpClient.CallBack callBack)
    {
        new HttpClient(urlStr).doGetAsyn(callBack);
    }
    public static void doPostAsyn(final String urlStr, final String params,
                                  final HttpClient.CallBack callBack) throws Exception
    {
        new HttpClient(urlStr).doPostAsyn(params, callBack);
    }

    public static String doGet(String urlStr)
    {
        return new HttpClient(urlStr).doGet();
    }

    public static String doPost(String url, String param)
    {
        return new HttpClient(url).doPost(param);
    }
}
