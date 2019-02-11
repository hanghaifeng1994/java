package com.learnyeai.learnai.net;

import com.learnyeai.learnai.net.netConf.MBTransItem;

/**
 * 对报文项的值解析
 * Created by zpz on 2017/2/15.
 */
public interface IReportItemValParser {
    String parse(Object val, MBTransItem item);
}
