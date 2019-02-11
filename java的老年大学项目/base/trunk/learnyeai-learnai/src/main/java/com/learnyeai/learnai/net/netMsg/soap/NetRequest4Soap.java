/**
 * Copyright ©2015 上海屹通. All rights reserved.
 *  
 * @Title: NetRequest4Soap.java
 * @Prject: mbank
 * @Description: TODO
 * @Package: cn.com.zhisou.ares.net.netMsg.soap
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:49:31
 * @version: V1.0
 */
package com.learnyeai.learnai.net.netMsg.soap;

import java.util.List;
import java.util.Map;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.net.netConf.MBTransConfBean;
import com.learnyeai.learnai.error.AresCoreException;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.learnai.support.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;

/**
 * @ClassName: NetRequest4Soap
 * @Description: TODO
 * @author: 李朋飞（lpf@yitong.com.cn）
 * @date: 2015年8月27日 上午8:49:31
 */
@Component
public class NetRequest4Soap implements IRequstBuilder {
	/**
	 * @FieldName: logger
	 * @FieldType: Logger
	 * @Description: 日志
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * @FieldName: XML_ENCODE
	 * @FieldType: String
	 * @Description:soap报文
	 */
	private final String XML_ENCODE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.net.ares.yitong.com.cn/\">";
	/*
	 * 
	 * (non Javadoc)
	 * @Title: buildSendMessage
	 * @Description: TODO 生成请求报文
	 * @param ctx
	 * @param confParser
	 * @param transCode
	 * @return
	 * @see cn.com.zhisou.ares.base.IRequstBuilder#buildSendMessage(cn.com.zhisou.ares.base.IBusinessContext, cn.com.zhisou.ares.base.INetConfParser, java.lang.String)
	 */
	@Override
	public boolean buildSendMessage(IBusinessContext ctx, INetConfParser confParser, String transCode) {
		MBTransConfBean conf = confParser.findTransConfById(transCode, NetConst.SOAP_XML_PATH);
		if (conf == null) {
			logger.warn("config_not_definied: {}", transCode);
			throw new AresCoreException("net.config_not_definied", transCode);
		}
		ctx.setParam(NetConst.TRAN_URL, conf.getName());
		StringBuilder bf = new StringBuilder(1024);
		bf.append(XML_ENCODE).append("<soapenv:Header/><soapenv:Body>");
		bf.append("<web:").append(conf.getName()).append(">");
		// 消息头
		buildMsgHead(ctx, conf, transCode, bf);
		// 消息体：
		buildMsgBody(ctx, conf, transCode, bf);
		bf.append("</web:").append(conf.getName()).append(">");
		bf.append("</soapenv:Body></soapenv:Envelope>");
		ctx.setRequestEntry(bf.toString());
		return true;
	}
	/**
	 * @Title: buildMsgHead
	 * @Description: TODO 构建消息头
	 * @param ctx
	 * @param conf
	 * @param transCode
	 * @param bf
	 */
	private void buildMsgHead(IBusinessContext ctx, MBTransConfBean conf,String transCode, StringBuilder bf) {
		bf.append("<msghead>");
		// 手工填写
		buildElement(bf, NetConst.CHANN_ID, "01");//渠道标识
		buildElement(bf, NetConst.TRANS_CODE, "Q001");//交易代码
		buildElement(bf, NetConst.CUST_ID, "2100689");//客户ID
		buildElement(bf, NetConst.TRAN_DATE, "20150826");//交易日期
		bf.append("</msghead>");
	}
	/**
	 * @Title: buildMsgBody
	 * @Description: TODO 生成报文主体
	 * @param ctx
	 * @param conf
	 * @param transCode
	 * @param bf
	 */
	private void buildMsgBody(IBusinessContext ctx, MBTransConfBean conf,String transCode, StringBuilder bf) {
		bf.append("<msgreq>");
		List<MBTransItem> items = conf.getSed();
		for (MBTransItem item : items) {
			if (!NetConst.FILED_TYPE_E.equals(item.getType())) {
				// 普通字段
				buildItem(ctx.getParamMap(), item, bf);
				continue;// 中断
			}
			// 取列表值
			List<Map> datas = ctx.getParamDatas(item.getName());
			if (null == datas)
				continue;
			List<MBTransItem> children = item.getChildren();
			bf.append("<").append(item.getName()).append(">");
			// 遍历值
			for (Map data : datas) {
				bf.append("<map>");
				// 遍历定义
				for (MBTransItem child : children) {
					buildItem(data, item, bf);
				}
				bf.append("</map>");
			}
			bf.append("</").append(item.getName()).append(">");
		}
		bf.append("</msgreq>");
	}
	/**
	 * @Title: buildItem
	 * @Description: TODO 生成报文字段
	 * @param param
	 * @param item
	 * @param bfOut
	 */
	private void buildItem(Map param, MBTransItem item, StringBuilder bfOut) {
		String name = item.getName();
		String value = MapUtil.getMapValue(param, name, item.getDefaultValue());
		if (StringUtils.isEmpty(value)) {
			if (item.isRequred()) {
				logger.warn("common.parameter_empty {}", item.getDesc());
				throw new AresRuntimeException("common.parameter_empty",
						item.getDesc());
			}
		}
		buildElement(bfOut, name, value);
	}
	private void buildElement(StringBuilder bf, String name, String value) {
		bf.append("<").append(name).append(">");
		bf.append(value);
		bf.append("</").append(name).append(">");
	}

}
