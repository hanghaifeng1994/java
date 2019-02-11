package com.learnyeai.learnai.net;

import com.learnyeai.learnai.net.netConf.MBTransItem;

import java.util.Map;

/**
 * 解析报文数据，对值处理
 * Created by zpz on 2017/2/15.
 */
public interface IReportValParser {
    public String parseVal(MBTransItem item, Map entrys);

}
