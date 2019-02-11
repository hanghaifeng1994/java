package com.drcl.traincore.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.ServletActionContext;
import org.springside.modules.utils.web.struts2.Struts2Utils;

import cn.common.lib.util.web.PropertyUtils;
import cn.common.lib.util.web.RequestUtils;
import cn.common.lib.vo.LabelValue;

import com.drcl.traincore.common.util.JsonUtil;
import com.drcl.traincore.contants.Constants;

/**
 * 
 * @author zzhe
 * 
 */
public class FileUploadUtil
{
    /**
     * 
     * 文件类型判断
     * 
     * @since 2010-12-24
     * @author zzhe
     * @author qingang param fileSize 文件大小 kb
     * @return String
     */
    public static String fileTypeValidate(String uploadFileName, File upload,
            List<String> fileTypes, int fileSize)
    {

        int fsize = getFileSize(upload);// 获取文件大小
        String ext = uploadFileName.substring(
                uploadFileName.lastIndexOf(".") + 1, uploadFileName.length());
        // 获取文件类型，即扩展名,通过String类的substring方法截取字符串，lastIndexOf获取某个字符串最后出现的索引。
        ext = ext.toLowerCase().trim();// 全部转换成小写。

        if (!fileTypes.contains(ext))
        {
            return "不支持该文件类型上传，该文件类型是：" + ext;
        }
        if (fsize > fileSize)
        {
            return "文件太大,上传失败";
        }
        return null;
    }

    /**
     * 
     * 获得文件大小
     * 
     * @since 2010-12-24
     * @author zzhe
     * @return int
     */
    private static int getFileSize(File upload)
    {
        FileInputStream fis = null;
        int size = 0;
        try
        {
            fis = new FileInputStream(upload);
            size = fis.available() / 1024;

        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        return size;
    }

    /**
     * 
     * 保存图片
     * 
     * @since 2010-12-23
     * @author zzHe
     * @param pic
     * @param picFileName
     * @return String
     */
    public static String savePicture(File pic, String picFileName,
            String localFilePath)
    {
        try
        {
            // 获得当前年月
            String date = DateFormatUtils.format(new Date(), "yyyyMM");

            // 　存储文件，获得存储后的文件名
            String fileName = cn.common.lib.util.file.FileUtils.saveFile(
                    localFilePath + "/" + date, pic, picFileName, "news");

            // 　重新设置文件名
            fileName = "/" + date + "/" + fileName;

            return fileName;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 
     * 读取excel数据
     * 
     * @since 2011-3-28
     * @author qingang
     * @param uploadFileName
     * @param keyList
     * @param upload
     * @return
     */
    public static List<Map<String, String>> getDataFromFile(
            String uploadFileName, List<String> keyList, File upload)
    {
        String filetype = uploadFileName.substring(
                uploadFileName.lastIndexOf(".") + 1).toLowerCase();

        if (filetype.equalsIgnoreCase("xlsx"))
        {
            return ExcelUtils.excel2List(keyList, upload, false);
        }
        if (filetype.equalsIgnoreCase("xls"))
        {
            return ExcelUtils.excel2List(keyList, upload, true);
        }
        return null;
    }

    /**
     * 
     * 删除文件
     * 
     * @since 2011-3-8
     * @author qingang
     * @param fileName
     * @return
     */
    public static boolean deleteFile(String fileName)
    {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile())
        {
            if (file.delete())
            {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            }
            else
            {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        }
        else
        {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 
     * 设置文件下载类型
     * 
     * @since 2011-5-6
     * @author fangyong
     * @param filename
     *            文件名
     * @param postfox
     *            文件类型
     * @return String[]
     */
    public static String[] getContentType(String filename, String postfox)
    {
        String[] downStrArray = new String[2];

        String contentType = "application/octet-stream";
        if (postfox.equalsIgnoreCase(".PDF"))// pdf
        {
            contentType = "application/pdf";
        }
        else
            if (postfox.equalsIgnoreCase(".ZIP"))// zip
            {
                contentType = "application/zip";
            }
            else
                if (postfox.equalsIgnoreCase(".RAR"))// rar
                {
                    contentType = "application/rar";
                }
                else
                    if (postfox.equalsIgnoreCase(".DOC")// word 2003
                            || postfox.equalsIgnoreCase(".DOCX"))
                    {
                        contentType = "application/msword";
                    }
                    else
                        if (postfox.equalsIgnoreCase(".XLS"))// excel 2003
                        {
                            contentType = "application/vnd.ms-excel";
                            if (filename.length() - 4 > 12)
                            {
                                filename = filename.substring(0, 12) + ".xls";
                            }
                            // file_name =
                            // article_id+".xls";//由于Excel文件名过长的话,无法打开,只能下载,所以覆盖掉原来的文件名
                        }
                        else
                            if (postfox.equalsIgnoreCase(".XLSX"))// excel 2007
                            {
                                contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                                if (filename.length() - 5 > 13)
                                {
                                    filename = filename.substring(0, 12)
                                            + ".xlsx";
                                }
                            }
                            else
                                if (postfox.equalsIgnoreCase(".PPT") // ppt
                                        || postfox.equalsIgnoreCase(".PPTX"))
                                {
                                    contentType = "/vnd.ms-powerpoint";
                                }
                                else
                                    if (postfox.equalsIgnoreCase(".JPG"))// jpg
                                    {
                                        contentType = "image/jpeg";
                                    }
                                    else
                                        if (postfox.equalsIgnoreCase(".BMP"))// bmp
                                        {
                                            contentType = "image/x-xbitmap";
                                        }
                                        else
                                            if (postfox
                                                    .equalsIgnoreCase(".GIF"))// gif
                                            {
                                                contentType = "image/gif";
                                            }
                                            else
                                                if (postfox
                                                        .equalsIgnoreCase(".TXT")) // txt
                                                {
                                                    contentType = "application/txt";
                                                }
        downStrArray[0] = contentType;
        downStrArray[1] = filename;

        return downStrArray;
    }
    
	public static void cutPic(String srcImageFile, String dirImageFile, int x, int y, int cutWidth, int cutHeight, int destWidth, int destHeight) throws Exception {
		Image img;
		ImageFilter cropFilter;
		// 读取源图像
		BufferedImage bi = ImageIO.read(new File(srcImageFile));
		int srcWidth = bi.getWidth(); // 源图宽度
		int srcHeight = bi.getHeight(); // 源图高度
		if (srcWidth >= cutWidth && srcHeight >= cutHeight) {
			Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
			// 改进的想法:是否可用多线程加快切割速度
			// 四个参数分别为图像起点坐标和宽高
			// 即: CropImageFilter(int x,int y,int width,int height)
			cropFilter = new CropImageFilter(x, y, cutWidth, cutHeight);
			img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
			BufferedImage tag = new BufferedImage(cutWidth, cutHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			if (destWidth > 0) {
				// Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				// img = img.getScaledInstance(destWidth, destHeight,
				// Image.SCALE_SMOOTH);
			}
			g.drawImage(img, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			// 输出为文件
			ImageIO.write(tag, "JPEG", new File(dirImageFile));
		}
	}
}
