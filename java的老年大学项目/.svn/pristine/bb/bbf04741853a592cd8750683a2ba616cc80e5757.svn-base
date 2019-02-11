package com.learnyeai.file.web;

import com.learnyeai.file.bean.UploadFileBean;
import com.learnyeai.file.fastdfs.FastDfsProperties;
import com.learnyeai.file.utils.BusinessException;
import com.learnyeai.file.fastdfs.FastDFSUtil;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * kindeditor编辑使用的图片上传
 * Created by zpz on 2018/8/29.
 */
@RestController
public class KindEditorUploadController {

    @Autowired
    private FileUpload fileUpload;
    @Autowired
    private FastDfsProperties fastDfsProperties;

    private List<String> imgExtList = Arrays.asList("gif","jpg","jpeg","png","bmp");

//    @RequestMapping(value = "/kindedt/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @RequestMapping(value = "/kindedt/upload")
    public Map upload(HttpServletRequest request){
        try {
            UploadFileBean upFile = fileUpload.servletUpload(request, "image", 10 * 1024 * 1024);

            String fileType = upFile.getFileType();
            String fileName = upFile.getFileName();
            String fileExt = upFile.getFileExt();
            long fileSize = upFile.getFileSize();
            FileItem fileItem = upFile.getFileItem();

            //2、创建一个FastDFS的客户端
            Map<String, String> prop = new HashMap<>();
            prop.put("fileName", fileName);

            //3、执行上传处理
            String path = FastDFSUtil.upload(fileItem.getInputStream(), fileSize, prop, fileExt);

            //4、拼接返回的url和ip地址，拼装成完整的url
            String url = fastDfsProperties.getFileDownloadUrl() + "/" + path;
            //5、返回map
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            return result;
        } catch (BusinessException e) {
            e.printStackTrace();
            //5、返回map
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", e.getMessage());
            return result;
        }catch (Exception e1){
            e1.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("cause", e1.getMessage());
            result.put("message", "上传文件失败");
            return result;
        }
    }
    private void check(MultipartFile uploadFile, String ext){
        // 定义允许上传的文件扩展名
        /*HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");*/
//        List<String> extList = Arrays.asList("gif","jpg","jpeg","png","bmp");
        // 最大文件大小
        long maxSize = 10*1024*1024;

        if (!imgExtList.contains(ext)) {
//            throw new RuntimeException("<font size='3'>非常抱歉，目前上传附件格式类型只允许为：<br/>gif,jpg,jpeg,png,bmp，你选择的文件【" + uploadFile.getOriginalFilename() + "】不符合要求，无法上传！</font>");
            throw new RuntimeException("非常抱歉，目前上传附件格式类型只允许为：<br/>gif,jpg,jpeg,png,bmp，你选择的文件【" + uploadFile.getOriginalFilename() + "】不符合要求，无法上传！");
        }

        if (uploadFile.getSize() > maxSize) {
//            throw new RuntimeException("<font size='3'>您选择的文件【" + uploadFile.getOriginalFilename()+ "】大小超过" + maxSize + "限制，无法上传！</font>");
            throw new RuntimeException("您选择的文件【" + uploadFile.getOriginalFilename()+ "】大小超过10M限制，无法上传！");
        }

    }

    private Map<String, Object> getError(String message) {
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("error", 1);
        msg.put("message", message);
        return msg;
    }
}
