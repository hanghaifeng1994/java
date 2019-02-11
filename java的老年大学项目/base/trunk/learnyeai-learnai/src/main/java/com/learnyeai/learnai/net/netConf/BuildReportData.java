package com.learnyeai.learnai.net.netConf;

import com.learnyeai.learnai.net.IReportValParser;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.netMsg.filter.ResponseValParser;
import com.learnyeai.tools.common.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建报文
 * Created by zpz on 2017/3/27.
 */
public class BuildReportData {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private IReportValParser reportValParser;
    private boolean check;
    public BuildReportData(){
        check = false;
        reportValParser = new ResponseValParser(null);
    }
    public BuildReportData(boolean check){
        this.check = check;

        reportValParser = new ResponseValParser(null);
    }

    public BuildReportData(boolean check, IReportValParser responseValParser){
        this.check = check;
        this.reportValParser = responseValParser;
    }

    private boolean parseItem(MBTransItem item, Map rst, Map outMap){
        logger.debug("item:{}", item);

        String type = item.getType();

        if (NetConst.FILED_TYPE_E.equals(type)) {
            parserListData(item, rst, outMap);
        }else if(NetConst.FILED_TYPE_OE.equals(type)){
            parserObject(item, rst, outMap);
        } else {
            // 普通内容
            parseCommonItem(item, rst,outMap);
        }
        logger.debug("item:{} 结束", item.getName());
        return true;
    }

    public boolean buildData(String transCode, List<MBTransItem> items, Map inputMap, Map outMap){

        if(items == null)
            throw new AresRuntimeException(ReportErrorKey.common_request_reprot_field_null);

        logger.debug("报文{}，开始解析", transCode);
        for (MBTransItem item : items) {
            parseItem(item, inputMap, outMap);
        }
        logger.debug("报文{}，解析完成", transCode);
        return true;
    }

    private boolean parserListData(MBTransItem item, Map rst, Map outMap) {
        // 列表内容
        List<Map> entrys = MapUtil.selectNodes(rst,
                item.getXmlPath());

        if (entrys == null || entrys.isEmpty()) {
            logger.debug("list content is empty ");

            if(check && item.isRequred()) {
                logger.error("字段“{}”必填", item.getName());
                throw new AresRuntimeException(ReportErrorKey.common_request_reprot_field_null, item.getDesc());
            }

            // 添加空列表
            outMap.put(item.getName(), new ArrayList());

        } else {
            logger.debug("{}, list size: {}", item.getName(), entrys.size());
            List<MBTransItem> children = item.getChildren();
            // 设置输出值
            List outDatas = new ArrayList();
            // 遍历值
            for (Map row : entrys) {
                Map outData = new HashMap();
                // 遍历定义
                for (MBTransItem child : children) {
                    parseItem(child, row, outData);
                }
                outDatas.add(outData);
            }
            outMap.put(item.getName(), outDatas);
        }
        return true;
    }

    private boolean parserObject(MBTransItem item, Map rst, Map outMap) {
        Map entry = MapUtil.singleNode(rst,item.getXmlPath());

        if (entry == null || entry.isEmpty()) {
            logger.debug("object {} content is empty ", item.getName());

            if(check && item.isRequred()) {
                logger.error("字段“{}”必填", item.getName());
                throw new AresRuntimeException(ReportErrorKey.common_request_reprot_field_null, item.getDesc());
            }
            outMap.put(item.getName(), new HashMap());
            return true;
        }

        List<MBTransItem> children = item.getChildren();
        // 设置输出值
        Map outDatas = new HashMap();
        // 遍历定义
        for (MBTransItem child : children) {
            parseItem(child,entry, outDatas);
        }
        outMap.put(item.getName(), outDatas);

        return true;
    }
    private void parseCommonItem(MBTransItem item, Map entrys, Map outMap) {
        String text = null;
        if(null == reportValParser){
            text = MapUtil.singleNodeText(entrys, item.getXmlPath());
        }else{
            text = reportValParser.parseVal(item, entrys);
        }

        if(text == null || text.length() == 0) {
            if(check && item.isRequred()) {
                logger.error("字段“{}”必填", item.getName());
                throw new AresRuntimeException(ReportErrorKey.common_request_reprot_field_null, item.getDesc());
            }
            text = item.getDefaultValue();
        }

        outMap.put(item.getName(), text);
    }
}
