package com.learnyeai.tools.http;

import com.learnyeai.tools.common.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by zpz on 2017/9/11.
 */
public class HttpFileUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpFileUtils.class);

    /**
     * 保存上传的文件到本地
     * @param request
     * @param fileNameType 保存文件名称类型，1 时间+随机数，2 根据老文件名生成
     * @return
     */
    public static List<FileBean> saveRequestFile(HttpServletRequest request, String dir, int fileNameType){
        try{
            if(!ServletFileUpload.isMultipartContent(request))
                throw new HttpUtilException("没有要保存的文件");
            //判断文件夹是否存在，如果不存放，新建
            if(!FileUtil.createDirectory(dir))
                throw new HttpUtilException("文件保存失败，请检查");
            List<FileBean> list = null;
            if(request instanceof DefaultMultipartHttpServletRequest)
                list = saveMultipartRequest((DefaultMultipartHttpServletRequest)request, dir, fileNameType);
            else
                list = saveServletRequestFile(request, dir, fileNameType);
            return list;
        }catch (HttpUtilException e) {
            throw e;
        }catch (Exception e){
            throw new HttpUtilException("上传文件失败", e);
        }
    }
    private static List<FileBean> saveMultipartRequest(DefaultMultipartHttpServletRequest request, String dir, int fileNameType) throws Exception{
        List<FileBean> list = new ArrayList();
        MultiValueMap<String, MultipartFile> fileMap = request.getMultiFileMap();
        if(fileMap.size() == 0)
            return list;

        for(Iterator<String> it=fileMap.keySet().iterator(); it.hasNext();){
            String name = it.next();
            List<MultipartFile> ll = fileMap.get(name);
            for(MultipartFile file : ll){
                list.add(saveInputStream2File(file.getInputStream(),dir, file.getOriginalFilename(), fileNameType));
            }
        }

        return list;
    }
    /**
     * 保存上传的文件到本地
     * @param request
     * @return
     */
    private static List<FileBean> saveServletRequestFile(HttpServletRequest request, String dir, int fileNameType){
        try{
            //获得磁盘文件条目工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
            //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
            /**
             * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，
             * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
             * 然后再将其真正写到 对应目录的硬盘上
             */

            factory.setRepository(new File(dir));
            //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024*1024) ;

            //高水平的API文件上传处理
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileBean> fileBeanList = new ArrayList<FileBean>();
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item:list){
                //非普通文件信息
                if(item.isFormField()){
                    continue;
                }
                fileBeanList.add(saveInputStream2File(item.getInputStream(), dir, item.getName(), fileNameType));
            }
            return fileBeanList;
        }catch (HttpUtilException e) {
            throw e;
        }catch (Exception e){
            throw new HttpUtilException("上传文件失败", e);
        }
    }

    /**
     * 保存文件流到文件
     * @param in
     * @param dir 保存目录
     * @param oldFileName 老文件名
     * @return
     */
    private static FileBean saveInputStream2File(InputStream in, String dir, String oldFileName, int fileNameType) throws Exception{
        String filename = null;
        if(2 == fileNameType)
            filename = FileUtil.genFileNameFromOld(dir, oldFileName);
        else
            filename = FileUtil.genDateFileName(dir, oldFileName);
        String suffixes = FileUtil.getFileSuffix(oldFileName);

        //真正写到磁盘上
        File file = new File(dir,filename);
        OutputStream out = new FileOutputStream(file);

        int length = 0;
        byte[] buf = new byte[1024];

        while ((length=in.read(buf))!=-1){
            //在bug数组中取出数据写到（输出流）磁盘上
            out.write(buf,0,length);
        }

        in.close();
        out.close();


        FileBean fileBean = new FileBean();
        fileBean.setFileId(filename);
        fileBean.setFileName(oldFileName);
        fileBean.setSuffix(suffixes);
        fileBean.setSize(file.length());
        fileBean.setFilePath(file.getPath());
        System.out.println("上传文件：" + oldFileName +"，文件大小："+fileBean.getSize());
        return fileBean;
    }

    /**
     * 多文件上传
     * @param actionUrl 上传的路径
     * @param params 参数
     * @param uploadFilePaths 文件路径数组
     * @return
     */
    public static String uploadFile(String actionUrl, Map<String, String> params, String... uploadFilePaths){
        Map<String, String> name2Path = new HashMap<String, String>();
        for(String filePath : uploadFilePaths){
            File file = new File(filePath);
            if(file.exists() && file.isFile()){
                name2Path.put(file.getName(), filePath);
            }
        }
        if(name2Path.size() == 0)
            throw new HttpUtilException("没有要上传的文件");
        return uploadFile(actionUrl, params, name2Path);
    }
    /**
     * 多文件上传的方法
     *
     * @param actionUrl：上传的路径
     * @param params
     * @param uploadFileName2Path：需要上传的文件名、路径
     * @return
     */
    @SuppressWarnings("finally")
    public static String uploadFile(String actionUrl, Map<String, String> params, Map<String, String> uploadFileName2Path){
        try{
            HttpPost post = new HttpPost(actionUrl);

            if(null != params && params.size() > 0) {
                for (Iterator<Map.Entry<String, String>> it = params.entrySet().iterator(); it.hasNext(); ) {
                    Map.Entry<String, String> o = it.next();
                    post.addTextParameter(o.getKey(), o.getValue());
                }
            }
            if(null != uploadFileName2Path && uploadFileName2Path.size() > 0) {
                for (Iterator<String>  it=uploadFileName2Path.keySet().iterator(); it.hasNext();) {
                    String fileName = it.next();
                    String filePath = uploadFileName2Path.get(fileName);
                    File file = new File(filePath);
                    post.addFileParameter(fileName, file);
                }
            }
            return new String(post.send(), "utf-8").trim();
        }catch (Exception e){
            throw new HttpUtilException(e);
        }
    }
    /**
     *
     * @param urlPath
     *            下载路径
     * @param downloadDir
     *            下载存放目录
     * @return 返回下载文件
     */
    /*public static File downloadFile(String urlPath, String downloadDir, String fileName) {
        File file = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设定请求的方法，默认是GET
//            httpURLConnection.setRequestMethod("POST");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();

            // 文件大小
            int fileLength = httpURLConnection.getContentLength();

            // 文件名
            String fileFullName = null;
            if(null == fileName || fileName.length() == 0){
                String headerFile = httpURLConnection.getHeaderField("content-disposition");
                int idx = -1;
                if(headerFile != null && headerFile.length() > 0){
                    idx = headerFile.indexOf("=");
                    if(idx > 0){
                        fileFullName = headerFile.substring(idx + "=".length());
                    }
                }
                if(null == fileFullName){
                    String filePathUrl = httpURLConnection.getURL().getFile();
                    if(filePathUrl.indexOf("?") < 0 && filePathUrl.indexOf(".") > 0){
                        fileFullName = filePathUrl.substring(filePathUrl.lastIndexOf("/") + 1);
                    }
                }
                if(null == fileFullName) {
                    fileFullName = FileUtil.genDateFileName(downloadDir, null);
                }else {
                    fileFullName = FileUtil.genFileNameFromOld(downloadDir,fileFullName);
                }
            }

            System.out.println("file length---->" + fileLength);

            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());

            String path = downloadDir + File.separatorChar + fileFullName;
            file = new File(path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(file);
            int size = 0;
            int len = 0;
            byte[] buf = new byte[1024];
            while ((size = bin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
                // 打印下载百分比
                // System.out.println("下载了-------> " + len * 100 / fileLength +
                // "%\n");
            }
            bin.close();
            out.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return file;
        }
    }*/

    public static File downloadFile(String urlPath, String downloadDir, String fileName) {
        return downloadFile(urlPath, downloadDir,fileName, null);
    }
    public static File downloadFile(String urlPath, String downloadDir, String fileName, Map<String, String> reqHeads) {
        StreamFileBean fileBean = downloadFile(urlPath, reqHeads);

        File file = null;
        try {
            // 文件名
            String fileFullName = null;
            if(null == fileName || fileName.length() == 0){
                fileFullName = fileBean.getFileName();
                if(null == fileFullName) {
                    fileFullName = FileUtil.genDateFileName(downloadDir, null);
                }else {
                    fileFullName = FileUtil.genFileNameFromOld(downloadDir,fileFullName);
                }
            }

            String path = downloadDir + File.separatorChar + fileFullName;
            file = new File(path);
            FileUtil.writeFileStream(file, fileBean.getInputStream());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            return file;
        }
    }

    /**
     * 下载文件
     * @param urlPath
     *            下载路径
     * @return 返回文件流、文件名
     */
    public static StreamFileBean downloadFile(String urlPath, Map<String, String> reqHeads) {
        StreamFileBean fileBean = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设定请求的方法，默认是GET
//            httpURLConnection.setRequestMethod("POST");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");

            if (null != reqHeads) {
                for (Iterator<Map.Entry<String, String>> it = reqHeads.entrySet().iterator(); it.hasNext();) {
                    Map.Entry<String, String> o = it.next();
                    httpURLConnection.setRequestProperty(o.getKey(), o.getValue());

                }
            }
            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();

            // 文件名
            String fileName = null;
            String contentDisp = null;
            Map<String, List<String>> rspHeads = httpURLConnection.getHeaderFields();
            for (Iterator<String> it=rspHeads.keySet().iterator(); it.hasNext();){
                String key = it.next();
                if(null == key)
                    continue;
                if("content-disposition".equals(key.toLowerCase())){
                    if(rspHeads.get(key).size() == 0)
                        continue;
                    contentDisp = rspHeads.get(key).get(0);
                }

            }

            if(contentDisp != null && contentDisp.length() > 0){
                int idx = contentDisp.indexOf("=");
                if(idx > 0){
                    fileName = contentDisp.substring(idx + "=".length());
                }
            }
            if(null == fileName){
                String filePathUrl = httpURLConnection.getURL().getFile();
                if(filePathUrl.indexOf("?") > 0)
                    filePathUrl = filePathUrl.substring(0, filePathUrl.indexOf("?"));
                if(filePathUrl.indexOf(".") > 0){
                    String suffix = filePathUrl.substring(filePathUrl.indexOf(".")+1);
                    if(suffix.indexOf("do") > -1 || suffix.indexOf("action") > -1 || suffix.indexOf("exe") > -1)
                        ;
                    else
                        fileName = filePathUrl.substring(filePathUrl.lastIndexOf("/") + 1);
                    // 计算后缀名
                    // xxxxxxxxxxxxxxxx
                }
            }
            fileBean = new StreamFileBean();
            fileBean.setFileName(fileName);
            fileBean.setInputStream(httpURLConnection.getInputStream());
            return fileBean;

        } catch (IOException e) {
            if(fileBean != null && fileBean.getInputStream()!= null)
                try {
                    fileBean.getInputStream().close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            // TODO Auto-generated catch block
            throw new HttpUtilException(e);
        }
    }


    public static void main(String[] args) {

        // 上传文件测试
//        String str = uploadFile("http://192.168.1.166:10010/resources/fileupload","H:/zhisou/71物流/doc/需求/天天有货论坛截图/QQ图片20170309110909.jpg" );
//        System.out.println(str);
        // 下载文件测试
        downloadFile("http://ewei-web-saas.ewei.com/05dffe3f6d7dfe50508bcb14a736f05f?sign=c4edaa8f88b6e665f69620c75f023dfd&t=59bb827f", "d:/", "");

    }
}

