package com.learnyeai.file.web;

import com.learnyeai.file.bean.UploadFileBean;
import com.learnyeai.file.fastdfs.FastDFSUtil;
import com.learnyeai.file.fastdfs.FastDfsProperties;
import com.learnyeai.file.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传
 * Created by zpz on 2018/8/29.
 */
@RestController
public class FileUploadController {
    @Autowired
    private FileUpload fileUpload;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @RequestMapping(value = "/upload/custfile.do")
    public Map upload(HttpServletRequest request){
        String ssfileType = request.getHeader("fileType");
        String ssSize = request.getHeader("maxSize");
        if(ssfileType == null || ssfileType.length() == 0 || null == ssSize || ssSize.length() == 0){
            return BaseResponse.fail("上传文件错误，请联系管理员");
        }

        int size = 0;
        try{
            size = Integer.valueOf(ssSize) * 1024 * 1024;
        }catch (Exception e){
            return BaseResponse.fail("上传文件错误，请联系管理员");
        }
        // 最大限制500M
        if(size > 500*1024*1024){
            return BaseResponse.fail("文件太大");
        }
        return fileUpload.upload2Fds(request,ssfileType, size);
    }

    // 小文件上传，文件类型不限，文件大小10M
    @RequestMapping(value = "/upload/file")
    public Map uploadMinFile(HttpServletRequest request){
        String ssfileType = request.getHeader("fileType");
        return fileUpload.upload2Fds(request,ssfileType, 10*1024*1024);
    }
    @RequestMapping(value = "/upload/pic")
    public Map uploadPic(HttpServletRequest request/*, CommonsMultipartFile uploadFile*/) {
        return fileUpload.upload2Fds(request, "image", 10 * 1024 * 1024);
    }
    // 删除文件
    @RequestMapping(value = "/deleteFile.do")
    public Map delete(String fileId){
        try {
            FastDFSUtil.delete(fileId);
            return BaseResponse.ok("删除文件成功");
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail("删除文件失败").add("cause", e.getMessage());
        }
    }
    // 获取文件信息
    @RequestMapping(value = "/getFileInfo")
    public Map getFileInfo(String fileId){
        try {
            Map<String, String> pp = FastDFSUtil.getFileMataData(fileId);
            String fileName = pp.get("fileName");
            String size = pp.get("fileSize");
            String date = pp.get("createtime");

            String suffix = FileUtils.getFileSuffix(fileName);
            String fileType = FileHelp.getFileType(suffix);
            BaseResponse rst = BaseResponse.ok("获取文件信息成功");
            rst.add("fileId",fileId)
                    .add("fileName", fileName)
                    .add("fileSize", size)
                    .add("createTime", date)
                    .add("fileType", fileType)
                    .add("fileExt", suffix);
            return rst;
        } catch (IOException e) {
            e.printStackTrace();
            return BaseResponse.fail("获取文件信息失败");
        }
    }

    // 上传视频
    @RequestMapping("/upload/uploadVido.do")
    public Map uploadVido(HttpServletRequest request){

        String ssSize = request.getHeader("maxSize");
        if(null == ssSize || ssSize.length() == 0){
            return BaseResponse.fail("上传文件错误，请联系管理员");
        }

        int size = 0;
        try{
            size = Integer.valueOf(ssSize) * 1024 * 1024;
        }catch (Exception e){
            return BaseResponse.fail("上传文件错误，请联系管理员");
        }
        // 最大限制500M
        if(size > 500*1024*1024){
            return BaseResponse.fail("文件太大");
        }

        File file = null;
        FileInputStream fi = null;
        try {
            UploadFileBean upFile = fileUpload.servletUpload(request, "video", size);
            String tempFilePath = FastDFSUtil.getFileTemDir() + "/" + genFileName(upFile.getFileExt());
            file = new File(tempFilePath);
            FileUtils.copyInputStreamToFile(upFile.getFileItem().getInputStream(),file);

            // 计算时长
            String len = FfmpegUtil.readtime(tempFilePath);

            String fileType = upFile.getFileType();
            String fileName = upFile.getFileName();
            String fileExt = upFile.getFileExt();
            long fileSize = upFile.getFileSize();
            fi = new FileInputStream(file);

            Map<String, String> prop = new HashMap<>();
            prop.put("fileName", fileName);
            prop.put("fileSize",String.valueOf(fileSize));
            prop.put("createtime",String.valueOf(Calendar.getInstance().getTimeInMillis()));
            prop.put("timeLength", len);

            String fileId = FastDFSUtil.upload(fi, fileSize, prop, fileExt);


            return BaseResponse.ok()
                    .add("fileId", fileId)
                    .add("fileName", fileName)
                    .add("timeLength", len)
                    .add("fileType", fileType)
                    .add("fileExt", fileExt)
                    .add("fileSize", FileHelp.calculateFileSize(fileSize));
        }catch (BusinessException be){
            return BaseResponse.fail(be.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail("上传文件失败");
        }finally {
            if(null != fi){
                try {
                    fi.close();
                } catch (IOException e) {
                }
            }
            if(null != file && file.exists())
                file.delete();
        }

    }

    private String genFileName(String fileExt){
        Date curDate = Calendar.getInstance().getTime();
        Double dd = (Math.random() * 1000);
        String ss = dateFormat.format(curDate) + dd.intValue();
        return fileExt == null? ss : ss + "." + fileExt;
    }
}
