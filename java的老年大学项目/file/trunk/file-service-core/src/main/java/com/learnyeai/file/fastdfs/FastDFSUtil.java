package com.learnyeai.file.fastdfs;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.*;

/**
 * Created by zpz on 2018/8/29.
 */
@Component
public class FastDFSUtil {
    private static Logger logger = LoggerFactory.getLogger(FastDFSUtil.class);
//    private static String classPath = FastDFSUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    private TrackerClient trackerClient = null;

    private TrackerServer trackerServer = null;

    private MyStorageClient storageClient = null;

    private StorageServer storageServer = null;
    @Autowired
    private FastDfsProperties fastDfsProperties;

    private FileServerClient fileServerClient;

    private static FastDFSUtil instance = null;

    public FastDFSUtil(){
    }
    private FileServerClient getFileServerClient(){
        if(null == fileServerClient){
            fileServerClient = FeignUtils.buildCleign("http://FILE-SERVICE/", FileServerClient.class);
        }
        return fileServerClient;
    }
    // 必须初始化才能使用
    @PostConstruct
    private void init() {
        instance = this;
        try {
            // 判断是否是文件服务器
            Map<String, String> map = null;
            if(fastDfsProperties.getMainServer() == 1) { // 主服务
                map = fastDfsProperties.getProperties();
            }else if(fastDfsProperties.getMainServer() == 2) {// 从服务
                new GetSettingThread().start();
                new GetSettingThread(false).start();
                return;
            }else {
                return;
            }
            Properties pp = new Properties();
            pp.putAll(map);
            ClientGlobal.initByProperties(pp);
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient = new MyStorageClient(trackerServer, null);

        } catch (Exception e) {
//            throw new RuntimeException("init exception",e);
            e.printStackTrace();
        }
    }
    public static String getFileUrl(String fileId){
        if(instance.fastDfsProperties.getFileDownloadUrl() == null)
            return fileId;
        return instance.fastDfsProperties.getFileDownloadUrl() + "/" + fileId;
    }

    public static String getFileTemDir(){
        return instance.fastDfsProperties.getFileTemDir();
    }

    private static MyStorageClient getStorageClient() {
//        trackerClient = new TrackerClient();
//        trackerServer = trackerClient.getConnection();
////        storageServer = trackerClient.getStoreStorage(trackerServer);
//        storageClient = new StorageClient(trackerServer, storageServer);
        if(instance.fastDfsProperties.getMainServer() == 0){
            throw new FastUploadException("未启用文件服务");
        }

        MyStorageClient storageClient = new MyStorageClient(instance.trackerServer, null);
        return storageClient;
    }

    public static String upload(MultipartFile multipartFile, Map<String, String> prop) throws IOException {
        if(null == multipartFile){
            throw new FastUploadException("参数为空");
        }
        //1、取文件的扩展名
        String originalFilename = multipartFile.getOriginalFilename();
        String extName = getFileExt(originalFilename);
        NameValuePair[] metaDataArr = null;
        if(null != prop) {
            List<NameValuePair> metaDataList = new ArrayList<>();
            prop.forEach((k,v)->{
                if(k == null || null == v || k.length() == 0 || v.length() == 0)
                    return;
                NameValuePair o = new NameValuePair(k, v);
                metaDataList.add(o);
            });
            metaDataArr = metaDataList.toArray(new NameValuePair[metaDataList.size()]);
        }
        logger.info("开始上传文件{}", originalFilename);
        String fileId = null;
        try {
            fileId = getStorageClient().upload_file_stream(multipartFile.getInputStream(), metaDataArr, multipartFile.getSize(), extName);
        } catch (MyException e) {
            throw new RuntimeException("上传文件失败", e);
        }

        logger.info("上传文件成功 {}，文件id {}", originalFilename,fileId);
        return fileId;

    }

    /**
     * 上传输入流到指定的组，主要是想存放大文件
     * @param in
     * @param size
     * @param prop
     * @param extName
     * @return
     * @throws IOException
     */
    public static String upload(InputStream in,long size, Map<String, String> prop, String extName) throws IOException {
        return upload2Group(in,size, null,prop, extName);
    }
    public static String upload2Group(InputStream in,long size, String group, Map<String, String> prop, String extName) throws IOException {
        if(null == in || size <=0){
            throw new FastUploadException("参数为空");
        }
        NameValuePair[] metaDataArr = null;
        if(null != prop) {
            List<NameValuePair> metaDataList = new ArrayList<>();
            prop.forEach((k,v)->{
                if(k == null || null == v || k.length() == 0 || v.length() == 0)
                    return;
                NameValuePair o = new NameValuePair(k, v);
                metaDataList.add(o);
            });
            metaDataArr = metaDataList.toArray(new NameValuePair[metaDataList.size()]);
        }
        String ss = JsonMapper.getInstance().toJson(prop);
        logger.info("开始上传文件流{}", ss);
        String fileId = null;
        try {
            fileId = getStorageClient().upload_file_stream(in,group, metaDataArr, size, extName);
        } catch (MyException e) {
            throw new RuntimeException("上传文件失败", e);
        }
        logger.info("上传文件成功 {}，文件id {}", ss,fileId);
        return fileId;
    }

    public static String upload(String filePath, Map<String, String> prop) throws IOException{
        return upload2Group(filePath,null, prop);
    }
    public static String upload2Group(String filePath, String group, Map<String, String> prop) throws IOException {
        if(filePath == null || filePath.length() == 0){
            throw new FastUploadException("参数为空");
        }
//        String fileExtName = getFileExt(filePath);
        NameValuePair[] metaDataArr = null;
        if(null != prop) {
            List<NameValuePair> metaDataList = new ArrayList<>();
            prop.forEach((k,v)->{
                if(k == null || null == v || k.length() == 0 || v.length() == 0)
                    return;
                NameValuePair o = new NameValuePair(k, v);
                metaDataList.add(o);
            });
            metaDataArr = metaDataList.toArray(new NameValuePair[metaDataList.size()]);
        }

        logger.info("开始上传文件{}", filePath);
        String fileId = null;
        try {
            fileId = getStorageClient().upload_file_group(group,filePath, metaDataArr);
        } catch (MyException e) {
            throw new RuntimeException("上传文件失败", e);
        }

        logger.info("上传文件成功 {}，文件id {}", filePath,fileId);

        return fileId;
    }

    public static String upload(byte[] file_buff, String fileExtName, Map<String, String> prop) throws IOException {
        if(file_buff == null){
            throw new FastUploadException("参数为空");
        }
        NameValuePair[] metaDataArr = null;
        if(null != prop) {
            List<NameValuePair> metaDataList = new ArrayList<>();
            prop.forEach((k,v)->{
                if(k == null || null == v || k.length() == 0 || v.length() == 0)
                    return;
                NameValuePair o = new NameValuePair(k, v);
                metaDataList.add(o);
            });
            metaDataArr = metaDataList.toArray(new NameValuePair[metaDataList.size()]);
        }
        String fileId = null;
        try {
            fileId = getStorageClient().upload_file1(file_buff, fileExtName, metaDataArr);
        } catch (MyException e) {
            throw new RuntimeException("上传文件失败", e);
        }

        System.out.println("fileid:" + fileId);

        return fileId;
    }

    public static String download2Dir(String fileId, String dir) throws IOException {
        String path = dir + "/" + fileId.substring(fileId.lastIndexOf("/") + 1);
        download2Path(fileId, path);
        return path;
    }

    public static void download2Path(String fileId, String filePath) throws IOException {
        logger.info("开始下载文件 {}", fileId);
        try {
            getStorageClient().download_file1(fileId, filePath);
        } catch (MyException e) {
            throw new RuntimeException("下载文件失败", e);
        }
        logger.info("download success {}", filePath);
    }

    public static FileInfo getFileInfo(String fileId) throws IOException {
        try {
            FileInfo fileInfo = getStorageClient().get_file_info1(fileId);
            System.out.println("source ip=" + fileInfo.getSourceIpAddr());
            System.out.println("file sizes=" + fileInfo.getFileSize());
            System.out.println("timestamp=" + fileInfo.getCreateTimestamp());
            System.out.println("crc32=" + fileInfo.getCrc32());

            return fileInfo;
        } catch (MyException e) {
            throw new RuntimeException("gets file info exception", e);
        }
    }

    public static Map<String,String> getFileMataData(String fileId) throws IOException {
        try {
            NameValuePair[] metas = getStorageClient().get_metadata1(fileId);
            Map<String,String> prop = new HashMap<>();
            for(NameValuePair it : metas){
                prop.put(it.getName(), it.getValue());
            }
            return prop;
        } catch (MyException e) {
            throw new RuntimeException("gets file metadata exception", e);
        }
    }

    public static void delete(String fileId) throws IOException {
        try {
            getStorageClient().delete_file1(fileId);
            System.out.println("detele file success");
        } catch (MyException e) {
            e.printStackTrace();
            throw new RuntimeException("deletes file exception", e);
        }
    }
    private static String getFileExt(String fileName){
        String extName = null;
        if(fileName.lastIndexOf(".") > -1) {
            extName = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return extName;
    }

    class GetSettingThread extends Thread{
        private boolean onece = true;
        public GetSettingThread(){}
        public GetSettingThread(boolean onece) {
            this.onece = onece;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    if(onece){
                        sleep(20000);
                    }else {
                        sleep(fastDfsProperties.getRefreshSetting()); // 1小时刷新一次配置
                    }
                    logger.debug("刷新文件配置");
                    String ss = getFileServerClient().getSetting();
                    if(logger.isDebugEnabled()){
                        logger.debug(ss);
                    }
                    Map setting =JsonMapper.getInstance().readValue(ss, Map.class);
                    Map data = (Map)setting.get("data");
                    fastDfsProperties.setFileDownloadUrl(data.get("fileDownloadUrl").toString());
                    fastDfsProperties.getProperties().putAll((Map)data.get("properties"));
                    Properties pp = new Properties();
                    pp.putAll(fastDfsProperties.getProperties());
                    ClientGlobal.initByProperties(pp);

                    trackerClient = new TrackerClient();
                    trackerServer = trackerClient.getConnection();
                    storageServer = trackerClient.getStoreStorage(trackerServer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(onece && null != storageClient)
                    break;
            }
        }
    }
}
