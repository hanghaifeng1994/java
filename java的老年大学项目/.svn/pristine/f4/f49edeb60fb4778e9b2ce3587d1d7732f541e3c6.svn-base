/**
 * Copyright ©2015 上海屹通. All rights reserved.
 *  
 * @Title: NetResponse4Soap.java
 * @Prject: mbank
 * @Description: TODO
 * @Package: cn.com.zhisou.ares.net.netMsg.soap
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:50:01
 * @version: V1.0
 */
package com.learnyeai.learnai.net.netMsg.soap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.net.netConf.MBTransConfBean;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.learnai.error.AresCoreException;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.error.OtherRuntimeException;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.tools.common.XmlUtil;

/**
 * @ClassName: NetResponse4Soap
 * @Description: TODO
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:50:01
 */
@Component
public class NetResponse4Soap implements IResponseParser{
	/**
	 * @FieldName: logger
	 * @FieldType: Logger
	 * @Description: 日志
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/*
	 * 
	 * (non Javadoc)
	 * @Title: parserResponseData
	 * @Description: TODO 解析响应报文
	 * @param ctx
	 * @param confParser
	 * @param transCode
	 * @return
	 * @see cn.com.zhisou.ares.base.IResponseParser#parserResponseData(cn.com.zhisou.ares.base.IBusinessContext, cn.com.zhisou.ares.base.INetConfParser, java.lang.String)
	 */
	@Override
	public boolean parserResponseData(IBusinessContext ctx,INetConfParser confParser, String transCode) {
		MBTransConfBean conf = confParser.findTransConfById(transCode,NetConst.SOAP_XML_PATH);
		if (conf == null) {
			logger.debug("net.config_not_definied {}", transCode);
			throw new AresCoreException("net.config_not_definied", transCode);
		}
		String rsp = ctx.getResponseEntry();
		// 解析交易体
		Element root = null;
		boolean ok = false;
		try {
			rsp = rsp.replaceAll("(soap:)|(ns2:)", "");
			Document doc = XmlUtil.readText(rsp);
			root = doc.getRootElement();
			String xpath = String.format("Body/%sResponse/uxunmsg",conf.getName());
			logger.info("---root--{}", xpath);
			root = (Element) root.selectSingleNode(xpath);
			root.element("msghead");
			ok = (root != null);
		} catch (Exception e) {
			logger.error("net.response_parse_error", e);
		}
		if (!ok) {
			throw new AresRuntimeException("net.response_parse_error");
		}

		Element body = parseHeader(root, transCode, ctx);

		Map map = new HashMap();
		// 取定义
		List<MBTransItem> items = conf.getRcv();
		parseXml(body, items, map);
		ctx.getParamMap().clear();
		ctx.getParamMap().putAll(map);
		return true;
	}

	/**
	 * 
	 * @Title: parseHeader
	 * @Description: TODO 解析响应头
	 * @param root
	 * @param transCode
	 * @param ctx
	 * @return
	 */
	private Element parseHeader(Element root, String transCode,IBusinessContext ctx) {
		// TODO 需要适配
		Element head = root.element("msghead");
		Element body = root.element("msgrsp");
		String rtnCode = body.elementText("retcode");
		String rtnMsg = body.elementText("retshow");
		if (NetConst.SUCCESS.equals(rtnCode)) {
			return body;
		}
		logger.warn("ebnak error {}", rtnCode);
		throw new OtherRuntimeException(rtnCode, rtnMsg);
	}

	/**
	 * 
	 * @Title: parseXml
	 * @Description: TODO  深度解析XML
	 * @param parent
	 * @param items
	 * @param outMap
	 */
	private void parseXml(Element parent, List<MBTransItem> items, Map outMap) {
		// TODO 需要适配 
		// 遍历定义
		for (MBTransItem item : items) {
			// 取定义
			List<MBTransItem> children = item.getChildren();
			// 1、普通字段-定义
			if (children == null || children.isEmpty()) {
				parseItem(parent, item, outMap);
				continue;// 中断
			}
			// 2、实体-定义
			if (NetConst.FILED_TYPE_M.equals(item.getType())) {
				Map entry = new HashMap();
				Element itemElem = parent.element(item.getXmlPath());
				parseXml(itemElem, children, entry);
				outMap.put(item.getName(), entry);
				continue;
			}
			// 3、列表-定义
			// 列表字段-取出数据
			List<Element> rows = parent.elements(item.getXmlPath());
			if (rows == null || rows.isEmpty()) {
				logger.debug("list is empty:{}", item);
				continue;
			}
			// 设置输出值
			List outDatas = new ArrayList();
			// 遍历值
			for (Element row : rows) {
				Map outData = new HashMap();
				// 遍历定义
				for (MBTransItem child : children) {
					// 判断字段类型
					if (!NetConst.FILED_TYPE_E.equals(child.getType())) {
						// 普通字段
						parseItem(row, child, outData);
						continue;// 中断
					}
					// 列表字段
					// 取定义
					List<MBTransItem> sonChildren = child.getChildren();
					// 深度解析
					parseXml(row, sonChildren, outData);
				}
				outDatas.add(outData);
			}
			outMap.put(item.getName(), outDatas);
		}
	}

	/**
	 * 
	 * @Title: parseItem
	 * @Description: TODO 提取子节点字段
	 * @param parent
	 * @param item
	 * @param outMap
	 */
	private void parseItem(Element parent, MBTransItem item, Map outMap) {
		// 取定义
		List<MBTransItem> children = item.getChildren();
		// 1、普通字段-定义
		if (children == null || children.isEmpty()) {
			try{
				outMap.put(item.getName(), parent.elementText(item.getXmlPath()));
			}catch(Exception e){
				logger.error("response_parse_error ,{}",e.toString());
			}
			return;
		}
		// 2、实体-定义
		if (NetConst.FILED_TYPE_M.equals(item.getType())) {
			Map entry = new HashMap();
			Element itemElem = parent.element(item.getXmlPath());
			parseXml(itemElem, children, entry);
			outMap.put(item.getName(), entry);
			return;
		}
		// 3、列表-定义
		// 列表字段-取出数据
		List<Element> rows = parent.elements(item.getXmlPath());
		if (rows == null || rows.isEmpty()) {
			logger.debug("list is empty:{}", item);
		}// 设置输出值
		List outDatas = new ArrayList();
		// 遍历值
		for (Element row : rows) {
			Map outData = new HashMap();
			// 遍历定义
			for (MBTransItem child : children) {
				parseItem(row, item, outData);
			}
			outDatas.add(outData);
		}
		outMap.put(item.getName(), outDatas);
	}

}
