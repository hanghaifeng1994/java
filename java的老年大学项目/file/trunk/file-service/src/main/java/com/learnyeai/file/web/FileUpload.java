package com.learnyeai.file.web;

import com.learnyeai.file.bean.UploadFileBean;
import com.learnyeai.file.fastdfs.FastDFSUtil;
import com.learnyeai.file.fastdfs.FastDfsProperties;
import com.learnyeai.file.utils.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zpz on 2018/8/30.
 */
@Component
public class FileUpload {
    private DiskFileItemFactory fileItemFactory = null;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private FastDfsProperties fastDfsProperties;

    private Map<String, ServletFileUpload> sizeFileLoad = new HashMap<>();

    private ServletFileUpload getFileUpload(long maxSize){
        String ss = String.valueOf(maxSize);
        if(sizeFileLoad.containsKey(ss)){
            return sizeFileLoad.get(ss);
        }

        ServletFileUpload actualFileUpload = new ServletFileUpload(getDiskFileItemFactory());// this.newFileUpload(this.getFileItemFactory());
//        actualFileUpload.setSizeMax(maxSize);
        actualFileUpload.setFileSizeMax(maxSize);
        actualFileUpload.setHeaderEncoding("utf-8");
        sizeFileLoad.put(ss, actualFileUpload);
        return actualFileUpload;
    }
    private DiskFileItemFactory getDiskFileItemFactory(){
        if(null == fileItemFactory)
        {
            //获得磁盘文件条目工厂
            fileItemFactory = new DiskFileItemFactory();
            //如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
            //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
            /**
             * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，
             * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
             * 然后再将其真正写到 对应目录的硬盘上
             */

            fileItemFactory.setRepository(new File(FastDFSUtil.getFileTemDir()));
            //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            fileItemFactory.setSizeThreshold(200*1024*1024) ;
        }
        return fileItemFactory;
    }
    /**
     * 上传文件统一处理
     * @param request
     * @param fileType，不为空检查文件类型
     * @param maxSize，大于0，检查文件大小
     * @return
     */
    public Map upload2Fds(HttpServletRequest request, String fileType, int maxSize){
        try{
            UploadFileBean upFile = servletUpload(request, fileType, maxSize);

            fileType = upFile.getFileType();
            String fileName = upFile.getFileName();
            String fileExt = upFile.getFileExt();
            long fileSize = upFile.getFileSize();
            FileItem fileItem = upFile.getFileItem();

            // 上传文件
            Map<String, String> prop = new HashMap<>();
            prop.put("fileName", fileName);
            prop.put("fileSize",String.valueOf(fileSize));
            prop.put("createtime",String.valueOf(Calendar.getInstance().getTimeInMillis()));

            //3、执行上传处理
            String fileId = FastDFSUtil.upload(fileItem.getInputStream(), fileSize, prop, fileExt);

            String fileUrl = fastDfsProperties.getFileDownloadUrl() + "/" + fileId;
            return BaseResponse.ok()
                    .add("fileId", fileId)
                    .add("fileName", fileName)
                    .add("fileType", fileType)
                    .add("fileExt", fileExt)
                    .add("fileSize", FileHelp.calculateFileSize(fileSize))
                    .add("fileUrl", fileUrl)
                    ;
        }catch (BusinessException e){
            e.printStackTrace();
            return BaseResponse.fail(e.getMessage());
        }catch (Exception e1){
            e1.printStackTrace();
            logger.error("上传失败",e1);
            return BaseResponse.fail("上传文件失败");
        }

    }





    /**
     * 获取处理状态
     * @param length
     * @param maxSize
     * @return 是否继续解析 是否太超限 实际max
     */
    private int[] getUploadState(int length, int maxSize){
        int[] ret = {1,0,Math.max(maxSize, length)+10};

        int dd = length - maxSize;
        if(dd <= 0){
            return ret;
        }


        ret[1] = 1;
        int m10 = 10 * 1024*1024;
        // 如果最大值在10M以内
        if(maxSize < m10 && dd < m10){
            return ret;
        }

        // 10m -
        if(maxSize >= m10){
            if(dd < 2 * m10)
                return ret;
        }

        ret[0] = 0;

        return ret;
    }
    public UploadFileBean servletUpload(HttpServletRequest request, String fileType, int maxSize)
        throws Exception{
        String dir = FastDFSUtil.getFileTemDir();

        try{
            if(!ServletFileUpload.isMultipartContent(request))
                throw new BusinessException("没有要保存的文件");

            //判断文件夹是否存在，如果不存放，新建
            if(!FileUtils.createDirectory(dir))
                throw new BusinessException("文件保存失败，请检查");

            maxSize = maxSize == 0? request.getContentLength() : maxSize;
            // 处理状态：是否继续解析 是否太超限 实际max
            int[] aa = getUploadState(request.getContentLength(), maxSize);
            boolean isParse = aa[0] == 1;
            if(!isParse){ // 不解析了
                throw new BusinessException("文件太大");
            }

            ServletFileUpload upload = getFileUpload(aa[2]);

            //只能上传一个文件
            logger.debug("开始上传文件");
            List<FileItem> list = upload.parseRequest(request);

            FileItem fileItem = null;
            for(FileItem item:list){
                logger.debug("成功上传文件{}", item.getName());
                //非普通文件信息
                if(!item.isFormField()){
                    if(null != fileItem)
                        throw new BusinessException("只能上传一个文件");
                    fileItem = item;
                }
            }

            if(fileItem == null){
                throw new BusinessException("请选择文件");
            }

            //后缀
            String fileName = fileItem.getName();
            //索引到最后一个点
            int pointStart = fileName.lastIndexOf(".");
            String suffixes = "";
            if(pointStart > 0)
                suffixes = fileName.substring(pointStart+1);

            // 检查文件类型
            fileType = check(suffixes, fileType);

            if(maxSize > 0 && fileItem.getSize() > maxSize){
                throw new BusinessException("您选择的文件大小超过" + FileHelp.calculateFileSize(maxSize) +
                        "限制，无法上传！");
            }
            UploadFileBean upFile = new UploadFileBean();
            upFile.setFileItem(fileItem);
            upFile.setFileName(fileName);
            upFile.setFileSize(fileItem.getSize());
            upFile.setFileExt(suffixes);
            upFile.setFileType(fileType);
            return upFile;
        }catch (Exception e){
            throw e;
        }
    }
    private String  check(String ext, String fileType){
        String ss = FileHelp.getFileType(ext);
        if(null == fileType || fileType.length() == 0){
            return ss;
        }
        if(null == ss || !ss.equals(fileType)) {
            String[] arr = FileHelp.getFileSuffixByType(fileType);
            throw new BusinessException("非常抱歉，目前上传附件格式类型只允许为：" + StringUtils.join(arr, ",") +
                    "，你选择的文件不符合要求，无法上传！");
        }
        return ss;
    }
}
