package com.learnyeai.learnai.net.netMsg.filter;

import com.learnyeai.learnai.net.IReportValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.tools.common.MapUtil;

import java.util.Map;

/**
 * 检查报文参数，错误抛异常
 * Created by zpz on 2018/5/2.
 */
public class RequestValParser implements IReportValParser {
    @Override
    public String parseVal(MBTransItem item, Map entrys) {

        Object val = MapUtil.singleNodeValue(entrys, item.getXmlPath());
        if(null == val)
            return null;

        return val.toString();
    }
}
