package com.learnyeai.learnai.net.netMsg.filter;

import com.learnyeai.core.consts.ConsTools;
import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zpz on 2018/5/15.
 */
public class ReportItemVal_ConsParser implements IReportItemValParser {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String parse(Object val, MBTransItem item) {
        if(null == val)
            return null;
        String dictType = item.getDictType();
        if(StringUtils.isBlank(dictType))
            return val.toString();

        return ConsTools.getLabelByValue(dictType, val.toString(), null);
    }
}
