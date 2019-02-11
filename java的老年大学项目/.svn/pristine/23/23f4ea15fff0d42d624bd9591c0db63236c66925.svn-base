package com.learnyeai.file.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 图片上传
 * Created by zpz on 2018/8/29.
 */
//@RestController
public class PicUploadController {
    @Autowired
    private FileUpload fileUpload;
    private List<String> imgExtList = Arrays.asList("gif","jpg","jpeg","png","bmp");

//    @RequestMapping(value = "/kindedt/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
//    @RequestMapping(value = "/upload/pic")
    public Map upload(HttpServletRequest request/*, CommonsMultipartFile uploadFile*/){
        return fileUpload.upload2Fds(request,"image", 10*1024*1024);
        /*if(!ServletFileUpload.isMultipartContent(request)){
            return BaseResponse.fail("请选择文件");
        }
        if(!(request instanceof StandardMultipartHttpServletRequest)){
            return BaseResponse.fail("内错");
        }

        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest)request;
        if(req.getFileMap().size() <= 0){
            return BaseResponse.fail("请选择文件");
        }
        MultipartFile imgFile = req.getFileMap().values().iterator().next();
//        ServletFileUpload.
        try {
            //1、取文件的扩展名
            String originalFilename = imgFile.getOriginalFilename();
            String extName = null;
            if(originalFilename.lastIndexOf(".") > -1) {
                extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            }

            // 检查文件大小、类型
            check(imgFile, extName);

            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", originalFilename);
            metaList[1] = new NameValuePair("fileSize",String.valueOf(imgFile.getSize()));
            metaList[2] = new NameValuePair("createtime",String.valueOf(Calendar.getInstance().getTimeInMillis()));

            //3、执行上传处理
            String fileId = FastDFSUtil.upload(imgFile, metaList);
            return BaseResponse.ok()
                    .add("fileId", fileId)
                    .add("fileName", originalFilename)
                    .add("fileType", FileHelp.getFileType(extName))
                    .add("fileExt", extName)
                    .add("fileSize", FileHelp.calculateFileSize(imgFile.getSize()));

        } catch (Exception e) {
            return BaseResponse.fail(e.getMessage());
        }*/
    }
    private void check(MultipartFile uploadFile, String ext){
        // 最大文件大小
        long maxSize = 10*1024*1024;

        if (!imgExtList.contains(ext)) {
            throw new RuntimeException("非常抱歉，目前上传附件格式类型只允许为：<br/>gif,jpg,jpeg,png,bmp，你选择的文件【" + uploadFile.getOriginalFilename() + "】不符合要求，无法上传！");
        }

        if (uploadFile.getSize() > maxSize) {
            throw new RuntimeException("您选择的文件【" + uploadFile.getOriginalFilename()+ "】大小超过10M限制，无法上传！");
        }

    }
}
