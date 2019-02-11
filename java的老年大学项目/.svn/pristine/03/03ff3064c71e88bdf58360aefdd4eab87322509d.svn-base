package com.learnyeai.servicebase.report;

import com.learnyeai.file.fastdfs.FastDFSUtil;
import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zpz on 2018/5/15.
 */
public class ReportItemVal_ResourceParser implements IReportItemValParser {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String parse(Object val, MBTransItem item) {
        logger.debug("资源串{}", val);
        if(null == val)
            return "";
        String ss = val.toString();
        if(ss.length() == 0)
            return "";
        String imgs[] = val.toString().split(",");
        // 获取文件绝对路径，拼接到文件名中
        StringBuffer sb = new StringBuffer();
        for(String img : imgs) {
            if(logger.isDebugEnabled())
            {
                logger.debug("原图片串{}", img);
            }
            if(img == null || img.length() == 0) // 为空，
                continue;

            String url = null;
            if(img.indexOf("http") == 0)
                url = img;
            else
                url = FastDFSUtil.getFileUrl(img);

            if(url == null)
                url = img;
            if(logger.isDebugEnabled())
            {
                logger.debug("图片url{}", url);
            }
            // 获取路径
            sb.append(url).append(",");
        }
        if(imgs.length > 0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
