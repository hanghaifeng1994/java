//-------------------------------------------------------------------------
// Copyright (c) 2000-2010 Digital. All Rights Reserved.
//
// This software is the confidential and proprietary information of
// Digital
//
// Original author: qingang
//
//-------------------------------------------------------------------------
// LOOSOFT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
// THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
// TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UFINITY SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
// MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
//
// THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
// CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
// PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
// NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
// SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
// SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
// PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES"). UFINITY
// SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
// HIGH RISK ACTIVITIES.
//-------------------------------------------------------------------------
package com.drcl.traincore.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.common.lib.util.file.FileUtils;
import cn.common.lib.util.web.PropertyUtils;
import cn.common.lib.util.web.RequestUtils;
import cn.common.lib.vo.LabelValue;

import com.drcl.traincore.contants.Constants;
import com.drcl.traincore.common.util.FileUploadUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 操作图片或附件上传的Action
 * 
 * @author fangyong
 * @version 1.0
 * @since 2011-3-28
 */
@ParentPackage("json-default")
@Namespace("/")
@Results( {
        @Result(name = "success", type = "json", params = { "contentType",
                "text/html" }),
        @Result(name = "error", type = "json", params = { "contentType",
                "text/html" }) })
public class UploadAction extends ActionSupport
{

    /**
     * serialVersionUID long
     */
    private static final long   serialVersionUID   = 1L;

    private File                picfile;

    private String              picfileFileName;

    private String              delAttchFileName;                  // 删除附件时的名字

    private String              fileFileContentType;

    private String              message            = null;

    private String              avatarname;                        // 上传成功之后的文件名

    private int                 width;

    private int                 height;

    private static final String FAILDELETE_MESSAGE = "对不起，文件删除失败.";

    // 上传培训项目LOGO图片
    public String uploadItemLogo() throws Exception
    {
        // 验证附件的格式和大小
        message = FileUploadUtils.fileTypeValidate(picfileFileName, picfile,
                Constants.ITEMIMAGETYPES, Constants.ITEMLOGO_MAXSIZE);

        if (message == null)
        {
            // 获得当前年月
            String date = DateFormatUtils.format(new Date(), "yyyyMM");

            // 设置文件路径，优先存储在本地，如本地存储失败，则存储至服务器路径上
            String localFilePath = PropertyUtils.getProperty("traincore.uploadpath",
                    RequestUtils.getRealPath(ServletActionContext
                            .getServletContext(), "/"))
                    + Constants.PICTUREPATH
                    + Constants.ITEMLOGOPATH
                    + File.separator + date;

            try
            {
                // 　存储文件，获得存储后的文件名
                avatarname = FileUtils.saveFile(localFilePath, picfile,
                        picfileFileName, "pic");
                avatarname = "/" + date + "/" + avatarname;// 附件后加上日期方便保存到数据库中
            }
            catch (Exception e)
            {
                e.printStackTrace();
                message = "对不起,图片上传失败了!";
            }
        }
        return SUCCESS;
    }

    // 上传培训项目BANNER图片
    public String uploadItemBanner() throws Exception
    {
        // 验证附件的格式和大小
        message = FileUploadUtils.fileTypeValidate(picfileFileName, picfile,
                Constants.ITEMIMAGETYPES, Constants.ITEMLOGO_MAXSIZE);

        if (message == null)
        {
            // 获得当前年月
            String date = DateFormatUtils.format(new Date(), "yyyyMM");

            // 设置文件路径，优先存储在本地，如本地存储失败，则存储至服务器路径上
            String localFilePath = PropertyUtils.getProperty("traincore.uploadpath",
                    RequestUtils.getRealPath(ServletActionContext
                            .getServletContext(), "/"))
                    + Constants.PICTUREPATH
                    + Constants.ITEMBANNER
                    + File.separator + date;

            try
            {
                // 　存储文件，获得存储后的文件名
                avatarname = FileUtils.saveFile(localFilePath, picfile,
                        picfileFileName, "pic");
                avatarname = "/" + date + "/" + avatarname;// 附件后加上日期方便保存到数据库中
            }
            catch (Exception e)
            {
                e.printStackTrace();
                message = "对不起,图片上传失败了!";
            }
        }
        return SUCCESS;
    }

    // 删除培训项目LOGO图片
    public String deleteItemLogo()
    {
        try
        {

            String filePath = PropertyUtils.getProperty("traincore.uploadpath",
                    RequestUtils.getRealPath(ServletActionContext
                            .getServletContext(), "/"))
                    + Constants.PICTUREPATH
                    + Constants.ITEMLOGOPATH
                    + this.delAttchFileName;// 取得附件前半部分名称

            // 判断附件是否已存在,如存在则删除
            if (!FileUploadUtils.deleteFile(filePath))
            {
                Struts2Utils.renderJson(new LabelValue(FAILDELETE_MESSAGE, ""));
            }
        }
        catch (Exception e)
        {
            Struts2Utils.renderJson(new LabelValue(FAILDELETE_MESSAGE, ""));
        }
        return null;
    }

    // 删除培训项目BANNER图片
    public String deleteItemBanner()
    {
        try
        {

            String filePath = PropertyUtils.getProperty("traincore.uploadpath",
                    RequestUtils.getRealPath(ServletActionContext
                            .getServletContext(), "/"))
                    + Constants.PICTUREPATH
                    + Constants.ITEMBANNER
                    + this.delAttchFileName;// 取得附件前半部分名称

            // 判断附件是否已存在,如存在则删除
            if (!FileUploadUtils.deleteFile(filePath))
            {
                Struts2Utils.renderJson(new LabelValue(FAILDELETE_MESSAGE, ""));
            }
        }
        
        catch (Exception e)
        {
            Struts2Utils.renderJson(new LabelValue(FAILDELETE_MESSAGE, ""));
        }
        return null;
    }

    // 上传用户图片
    public String uploadUserImage() throws Exception
    {
        // 验证附件的格式和大小
        message = FileUploadUtils.fileTypeValidate(picfileFileName, picfile,
                Constants.ITEMIMAGETYPES, Constants.ITEMLOGO_MAXSIZE*10);

        if (message == null)
        {
            // 判断照片的像素,读取源图像
            BufferedImage bi = ImageIO.read(picfile);
            width = bi.getWidth(); // 源图宽度
            height = bi.getHeight(); // 源图高度

            // 获得当前年月
            String date = DateFormatUtils.format(new Date(), "yyyyMM");
            String day = DateFormatUtils.format(new Date(), "yyyyMMdd");

            // 设置文件路径，优先存储在本地，如本地存储失败，则存储至服务器路径上
            String localFilePath = PropertyUtils.getProperty("traincore.uploadpath",
                    RequestUtils.getRealPath(ServletActionContext
                            .getServletContext(), "/"))+ Constants.AVATARPATH
                    + File.separator + date + File.separator + day;;

            try
            {
                // 　存储文件，获得存储后的文件名
                avatarname = FileUtils.saveFile(localFilePath, picfile,
                        picfileFileName, "pic");
                avatarname = Constants.AVATARPATH + "/" + date + "/" + day + "/" + avatarname;// 附件后加上日期方便保存到数据库中
            }
            catch (Exception e)
            {
                e.printStackTrace();
                message = "对不起,图片上传失败了!";
            }
        }
        return SUCCESS;
    }
    
    // 上传课程图片
    public String uploadCourseImage() throws Exception
    {
        // 验证附件的格式和大小
        message = FileUploadUtils.fileTypeValidate(picfileFileName, picfile,
                Constants.ITEMIMAGETYPES, Constants.ITEMLOGO_MAXSIZE*10);

        if (message == null)
        {
            // 判断照片的像素,读取源图像
            BufferedImage bi = ImageIO.read(picfile);
            width = bi.getWidth(); // 源图宽度
            height = bi.getHeight(); // 源图高度

            // 获得当前年月
            String date = DateFormatUtils.format(new Date(), "yyyyMM");

            // 设置文件路径，优先存储在本地，如本地存储失败，则存储至服务器路径上
            String localFilePath = PropertyUtils.getProperty("traincore.uploadpath",
                    RequestUtils.getRealPath(ServletActionContext
                            .getServletContext(), "/"))+ Constants.COURSE
                    + File.separator + date;

            try
            {
                // 　存储文件，获得存储后的文件名
                avatarname = FileUtils.saveFile(localFilePath, picfile,
                        picfileFileName, "pic");
                avatarname = Constants.COURSE + "/" + date + "/" + avatarname;// 附件后加上日期方便保存到数据库中
            }
            catch (Exception e)
            {
                e.printStackTrace();
                message = "对不起,图片上传失败了!";
            }
        }
        return SUCCESS;
    }

    // 上传证书模板图片
    public String uploadCertTemImage() throws Exception
    {
        // 验证附件的格式和大小
        //message = FileUploadUtils
          //      .fileTypeValidate(picfileFileName, picfile,
            //            Constants.CERTTEMIMAGEFILETYPES,
              //          Constants.CERTTEMPLATE_MAXSIZE);

        if (message == null)
        {
            String date = DateFormatUtils.format(new Date(), "yyyyMM");
            String realPath = RequestUtils.getRealPath(ServletActionContext
                    .getServletContext(), "/");

            // 设置文件路径，优先存储在本地，如本地存储失败，则存储至服务器路径上
            String localFilePath = PropertyUtils.getProperty("traincore.uploadpath",
                    realPath)
                    + Constants.CERTPATH + File.separator + date;

            try
            { // 　存储文件，获得存储后的文件名
                avatarname = FileUtils.saveFile(localFilePath, picfile,
                        picfileFileName, Constants.CERTTEMPLATE_PREFIX);
                avatarname = File.separator + date + File.separator
                        + avatarname;// 附件后加上日期方便保存到数据库中
            }
            catch (Exception e)
            {
                e.printStackTrace();
                message = "对不起,图片上传失败了!";
            }
        }

        return SUCCESS;
    }

    public void setAvatarname(String avatarname)
    {
        this.avatarname = avatarname;
    }

    public String getAvatarname()
    {
        return avatarname;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public File getPicfile()
    {
        return picfile;
    }

    public void setPicfile(File picfile)
    {
        this.picfile = picfile;
    }

    public String getPicfileFileName()
    {
        return picfileFileName;
    }

    public void setPicfileFileName(String picfileFileName)
    {
        this.picfileFileName = picfileFileName;
    }

    public String getFileFileContentType()
    {
        return fileFileContentType;
    }

    public void setFileFileContentType(String fileFileContentType)
    {
        this.fileFileContentType = fileFileContentType;
    }

    public void setDelAttchFileName(String delAttchFileName)
    {
        this.delAttchFileName = delAttchFileName;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

}
