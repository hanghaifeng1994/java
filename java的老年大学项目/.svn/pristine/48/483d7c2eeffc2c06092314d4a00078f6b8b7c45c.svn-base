package cn.com.weye.web;

import cn.com.weye.modules.attach.entity.Attachment;
import cn.com.weye.modules.attach.service.AttachmentService;
import cn.com.zhisou.resource.ResUploadFileServlet;
import cn.com.zhisou.resource.ResourceGlobal;
import cn.com.zhisou.resource.entity.ResourceFileBean;
import cn.com.zhisou.resource.exception.ResourceException;
import cn.com.zhisou.resource.utils.HttpFileUtils;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2016/6/29.
 */
public class ResourceUpload extends ResUploadFileServlet {

    @Override
    protected String up2ResourceServer(ResourceFileBean fileBean, HttpServletRequest request) throws Exception {
        String url = ResourceGlobal.getServerUploadUrl() + "?token=123&userid=123";
        String rstJson = HttpFileUtils.uploadFile(url, (Map)null, new String[]{fileBean.getFilePath()});
        JSONObject rstO = JSONObject.parseObject(rstJson);
        if("0".equals(rstO.getString("status"))) {
            return rstO.getString("filename");
        } else {
            throw new ResourceException(rstO.getString("msg"));
        }
    }

    @Override
    protected void upSucess(ResourceFileBean fileBean, HttpServletRequest req,HttpServletResponse response) {
        Map result = new HashMap();
        try{
            String suffixes = fileBean.getSuffix();

            String filename = fileBean.getFileId();
            result.put("code", 0);
            result.put("value", filename);
            result.put("size", fileBean.getSize());
            result.put("fileName", fileBean.getFileName());



            // 保存到数据库
            AttachmentService attachmentService = SpringContextHolder.getBean("attachmentService");
            Attachment o = new Attachment();
            o.setId(fileBean.getFileId());
            o.setAtName(fileBean.getFileName());
            o.setAtSuffix(fileBean.getSuffix());
            o.setCreateDate(Calendar.getInstance().getTime());
            o.setCreateBy(UserUtils.getUser());

            o.setIsNewRecord(true);

            // 如果是图片，不要保存到数据库中，除非强制保存
            String toDb = req.getParameter("toDb");
            toDb = toDb == null?"0" : "1";

            if(".jpg".equals(suffixes) || ".png".equals(suffixes) || ".img".equals(suffixes) || ".bmp".equals(suffixes) || ".jpeg".equals(suffixes)) {

                if(toDb.equals("1")){
                    attachmentService.save(o);
                }
            }else
                attachmentService.save(o);
        }catch (Exception e){
            result.put("code", -1);
        }

        try {
            response.getOutputStream().write(JsonMapper.toJsonString(result).getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void upFailure(String msg, HttpServletResponse response) {
        try {
            response.setContentType("text/json; charset=UTF-8");
            String resultJson = "{ \"status\": \"-1\" ,\"msg\": \"" + msg + "\"}";
            response.getOutputStream().write(msg.getBytes("UTF-8"));
        }catch (Exception e){

        }
    }
}
