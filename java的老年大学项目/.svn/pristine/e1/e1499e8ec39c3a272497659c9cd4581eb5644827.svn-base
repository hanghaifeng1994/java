package com.learnyeai.learnai.net.netMsg.filter;


import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IReportValParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.learnai.net.netConf.BuildReportData;
import com.learnyeai.learnai.net.netConf.MBTransConfBean;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.learnai.support.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求生成器
 * 
 * @author yaoym
 * 
 */
@Component
public class RequestBuilder4Web implements IRequstBuilder {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private IReportValParser requestValParser;
	private IReportValParser getRequestValParser(){
		if(null == requestValParser) {
			requestValParser = SpringContextUtils.getBean("requestValParser");
		}
		if(null == requestValParser) {
			requestValParser = new RequestValParser();
		}
		return requestValParser;
	}


	@Override
	public boolean buildSendMessage(IBusinessContext busiContext,
									INetConfParser confParser, String transCode) {
		if (logger.isDebugEnabled()) {
			logger.debug("buildSendMessage ......start........" + transCode);
		}
		// 动态报文体
		MBTransConfBean conf = confParser.findTransConfById(transCode, NetConst.WEB_XML_PATH);
		if (conf != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("loaded transconf successfully!" + transCode);
			}
		} else {
			logger.error("loaded transconf failed!" + transCode);
			throw new AresRuntimeException(ReportErrorKey.net_config_not_definied, transCode);
		}
		Map out = new HashMap();
		boolean b = buildDocument(busiContext, conf, transCode, out);
		if(b) {
			busiContext.setRequestEntry(out);
			busiContext.getParamMap().clear();
			busiContext.getParamMap().putAll(out);
		}
		return b;
	}

	/**
	 * 创建请求消息体
	 * @param ctx
	 * @param conf
	 * @param transCode
	 * @param out
     * @return
     */
	private boolean buildDocument(IBusinessContext ctx, MBTransConfBean conf,
			String transCode, Map out) {
		if (logger.isDebugEnabled()) {
			logger.debug("buildDocument ......start........" + transCode);
		}
		try {
			List<MBTransItem> sed = conf.getSed();
			// 报文头
			buildHeadContent(out, ctx, transCode);
			// 报文体
			buildBodyContent(ctx.getParamMap(),out, sed, ctx, transCode);
			return true;
		} catch (Exception e) {
			logger.error(transCode + " build the xml head error!", e);
			if(e instanceof AresRuntimeException)
				throw e;
			else
				throw new AresRuntimeException(ReportErrorKey.net_request_build_error, transCode);
		}
	}

	/**
	 * 报文头
	 * 
	 * @param rst
	 * @param ctx
	 * @param transCode
	 * @return
	 */
	private boolean buildHeadContent(Map rst, IBusinessContext ctx,
			String transCode) {

		// 检查报文头

		return true;
	}

	/**
	 * 组装报文
	 */
	private void buildBodyContent(Map rst, Map out, List<MBTransItem> sed,
			IBusinessContext ctx, String transCode) {
		if (logger.isDebugEnabled()) {
			logger.debug("buildBodyContent ......start....." + transCode);
		}
		if (null == sed) {
			if (logger.isDebugEnabled()) {
				logger.debug("交易自定义发送内容为空!");
			}
			throw new RuntimeException();
		}
		BuildReportData buildReportData = new BuildReportData(true, getRequestValParser());
		buildReportData.buildData(transCode, sed, rst, out);
	}

}
