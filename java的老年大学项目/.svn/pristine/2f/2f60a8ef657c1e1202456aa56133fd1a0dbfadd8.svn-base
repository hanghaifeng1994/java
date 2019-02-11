package com.learnyeai.learnai.net.netMsg.filter;

import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.IReportValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zpz on 2017/2/15.
 */
public class ResponseValParser implements IReportValParser{
    private Logger logger = LoggerFactory.getLogger(getClass());

    private SimpleDateFormat defDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int defDolt = 0;
    public static Map<String, SimpleDateFormat> dateFormatMap = new HashMap();

    // item 类型，解析器
    private Map<String, IReportItemValParser> itemParses = new HashMap();

    public ResponseValParser(Map<String, IReportItemValParser> parses){
        if(null != parses && parses.size() > 0) {
            this.itemParses.putAll(parses);
        }
        // 添加默认解析器
        if(!itemParses.containsKey(NetConst.FILED_TYPE_F)){
            this.itemParses.put(NetConst.FILED_TYPE_F, new ReportItemVal_DoubleParser());
        }
        if(!itemParses.containsKey(NetConst.FILED_TYPE_D)){
            this.itemParses.put(NetConst.FILED_TYPE_D, new ReportItemVal_DateParser());
        }
        if(!itemParses.containsKey(NetConst.FILED_TYPE_CONS)){
            this.itemParses.put(NetConst.FILED_TYPE_CONS, new ReportItemVal_ConsParser());
        }

        dateFormatMap.put("yyyy-MM-dd HH:mm:ss", defDateFormat);
    }
    public void addItemValParse(String type, IReportItemValParser parse){
        itemParses.put(type, parse);
    }

    public String parseVal(MBTransItem item, Map entrys) {
        Object val = MapUtil.singleNodeValue(entrys, item.getXmlPath());
        if(null == val || (val instanceof String && val.toString().length() == 0))
            val = item.getDefaultValue();

        // 值类型，0普通、dict本地字典、cons常量、res资源
        String itemType = item.getType();

        IReportItemValParser parse = null;
        if(itemParses.containsKey(itemType)){
            parse = itemParses.get(itemType);
        }else{
            parse = getValParse(val, item);
        }

        String text = null;
        if(parse != null){
            text = parse.parse(val, item);
        }else {
            if(null != val){
                text = val.toString();
            }
        }

        if (item.isRequred()) {
            if (StringUtils.isEmpty(text)) {
                logger.debug("item can't be empty:\n{}", item);
            }
        }
        if(null == text){
            text = "";
        }

        return text;
    }

    // 根据值找解析器
    private IReportItemValParser getValParse(Object val, MBTransItem item){
        if(item.getDolt() != null && item.getDolt() >= 0) {
            return itemParses.get(NetConst.FILED_TYPE_F);
        }
        if(null == val || val instanceof String) {
            return null;
        }else if(val instanceof java.util.Date
                || "oracle.sql.TIMESTAMP".equals(val.getClass().getName())){
            return itemParses.get(NetConst.FILED_TYPE_D);
        }else if(val instanceof Float || val instanceof Double || val instanceof BigDecimal){
            return itemParses.get(NetConst.FILED_TYPE_F);
        }
        return null;
    }
}
