package com.learnyeai.servicebase.report;

import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zpz on 2018/5/15.
 */
public class ReportItemVal_DictParser implements IReportItemValParser {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String parse(Object val, MBTransItem item) {
        String dictType = item.getDictType();
        if(StringUtils.isBlank(dictType))
            return val.toString();
        return null;//SysDictUtils.getDictLabel(val.toString(),dictType, null);
    }
}
