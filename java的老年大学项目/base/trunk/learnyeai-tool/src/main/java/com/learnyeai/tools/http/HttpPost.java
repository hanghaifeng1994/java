package com.learnyeai.tools.http;

import com.learnyeai.tools.common.StreamUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 模拟表单提交
 * Created by zpz on 2017/9/11.
 */
public class HttpPost {
    private URL url;
    private HttpURLConnection conn;
    private final String boundary = "--------httppost*********";
    private final String end = "\r\n";
    private final String twoHyphens = "--";

    private Map<String, String> textParams = new HashMap<String, String>();
    private Map<String, File> fileparams = new HashMap<String, File>();
    private DataOutputStream ds;

    private int connTime = 15000; //连接超时为10秒
    private int readTime = 50000;

    public HttpPost(String url) throws Exception {
        this.url = new URL(url);
    }

    public void setConnTime(int connTime) {
        this.connTime = connTime;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    //重新设置要请求的服务器地址，即上传文件的地址。
    public void setUrl(String url) throws Exception {
        this.url = new URL(url);
    }
    //增加一个普通字符串数据到form表单数据中
    public void addTextParameter(String name, String value) {
        textParams.put(name, value);
    }
    //增加一个文件到form表单数据中
    public void addFileParameter(String name, File value) {
        fileparams.put(name, value);
    }
    // 清空所有已添加的form表单数据
    public void clearAllParameters() {
        textParams.clear();
        fileparams.clear();
    }
    // 发送数据到服务器，返回一个字节包含服务器的返回结果的数组
    public byte[] send() throws Exception {
        initConnection();
        try {
            conn.connect();
        } catch (SocketTimeoutException e) {
            // something
            throw new RuntimeException();
        }
        ds = new DataOutputStream(conn.getOutputStream());
        ByteArrayOutputStream out = null;
        InputStream in = null;
        try{
            writeStringParams();
            writeFileParams();
            paramsEnd();
            if (conn.getResponseCode() >= 300) {
                throw new Exception(
                        "HTTP Request is not success, Response code is " + conn.getResponseCode());
            }
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                in = conn.getInputStream();
                out = new ByteArrayOutputStream();
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
                return out.toByteArray();
            }
        }catch (Exception e){
            throw e;
        }finally {
            if(null != ds)
                try{
                    ds.close();
                }catch (Exception e){}
            if(null != out)
                try{
                    out.close();
                }catch (Exception e){}
            if(null != in)
                try{
                    in.close();
                }catch (Exception e){}
            conn.disconnect();
        }

        return new byte[0];
    }
    //文件上传的connection的一些必须设置
    private void initConnection() throws Exception {
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 9090));
//        conn = (HttpURLConnection) this.url.openConnection(proxy);
        conn = (HttpURLConnection) this.url.openConnection();
        conn.setDoInput(true);// 允许写
        conn.setDoOutput(true);// 允许读
        conn.setUseCaches(false);// 不使用缓存
        conn.setConnectTimeout(connTime); //连接超时为10秒
        conn.setReadTimeout(readTime);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Connection", "Keep-Alive");// 设置连接参数
//        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
        // 设置字符编码
        conn.setRequestProperty("Charset", "UTF-8");

        conn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + boundary);

        /*if(fileparams.size() > 0)
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);
        else
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");*/

    }
    //普通字符串数据
    private void writeStringParams() throws Exception {
        Set<String> keySet = textParams.keySet();
        StringBuilder sb = new StringBuilder();
        for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
            String name = it.next();
            String value = textParams.get(name);
            sb.append(twoHyphens + boundary + end);
            sb.append("Content-Disposition: form-data; name=\"" + name
                    + "\"" + end);
            sb.append(end);
            sb.append(encode(value) + end);

            /*ds.writeBytes(twoHyphens + boundary + end);
            ds.writeBytes("Content-Disposition: form-data; name=\"" + name
                    + "\"" + end);
            ds.writeBytes(end);
            ds.writeBytes(encode(value) + end);*/
        }
        if(keySet.size() > 0)
            ds.write(sb.toString().getBytes("utf-8"));
    }
    //文件数据
    private void writeFileParams() throws Exception {
        Set<String> keySet = fileparams.keySet();
        StringBuilder sb = new StringBuilder();
        for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
            String name = it.next();
            File value = fileparams.get(name);
            ds.writeBytes(twoHyphens + boundary + end);
            ds.writeBytes("Content-Disposition: form-data; name=\"" + name
                    + "\"; filename=\"" + URLEncoder.encode(value.getName(),"UTF-8") + "\"" + end);
            ds.writeBytes("Content-Type: " + getContentType(value) + end);
            ds.writeBytes(end);
            ds.write(getBytes(value));
            ds.writeBytes(end);
        }
    }
    //获取文件的上传类型，图片格式为image/png,image/jpg等。非图片为application/octet-stream
    private String getContentType(File f) throws Exception {

//      return "application/octet-stream";  // 此行不再细分是否为图片，全部作为application/octet-stream 类型
        ImageInputStream imagein = ImageIO.createImageInputStream(f);
        if (imagein == null) {
            return "application/octet-stream";
        }
        Iterator<ImageReader> it = ImageIO.getImageReaders(imagein);
        if (!it.hasNext()) {
            imagein.close();
            return "application/octet-stream";
        }
        imagein.close();
        return "image/" + it.next().getFormatName().toLowerCase();//将FormatName返回的值转换成小写，默认为大写

    }
    //把文件转换成字节数组
    private byte[] getBytes(File f) throws Exception {
        return StreamUtils.copyToByteArray(new FileInputStream(f));
        /*FileInputStream in = new FileInputStream(f);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while ((n = in.read(b)) != -1) {
            out.write(b, 0, n);
        }
        in.close();
        return out.toByteArray();*/
    }
    //添加结尾数据
    private void paramsEnd() throws Exception {
        ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
        ds.writeBytes(end);// \r\n
    }
    // 对包含中文的字符串进行转码，此为UTF-8。服务器那边要进行一次解码
    private String encode(String value) throws Exception{
        return value;
//        return URLEncoder.encode(value, "UTF-8");
    }
    public static void main(String[] args) throws Exception {
//        HttpPost u = new HttpPost("http://192.168.1.166:10010/resources/fileupload");
        HttpPost u = new HttpPost("http://192.168.1.54:8080/resources/fileupload?token=123&userid=123");
        u.addFileParameter("aa", new File("H:/zhisou/71物流/doc/需求/天天有货论坛截图/QQ图片20170309110909.jpg"));
        u.addTextParameter("token", "123");
        u.addTextParameter("userid", "123");
        byte[] b = u.send();
        String result = new String(b);
        System.out.println(result);

    }
}

