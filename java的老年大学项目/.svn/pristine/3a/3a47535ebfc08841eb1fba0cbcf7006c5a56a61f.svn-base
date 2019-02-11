package com.learnyeai.learnai.net.netMsg.iso8583;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.net.netConf.MBTransConfBean;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.learnai.error.AresCoreException;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.AmountUtils;
import com.learnyeai.tools.common.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NetResponse8583 implements IResponseParser {

	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	public boolean parserResponseData(IBusinessContext ctx,
									  INetConfParser confParser, String transCode) {
		MBTransConfBean conf = confParser.findTransConfById(transCode, NetConst.SOCKET_XML_PATH);
		if (conf == null) {
			logger.debug("net.config_not_definied {}", transCode);
			throw new AresCoreException("net.config_not_definied", transCode);
		}
		byte[] rsp = ctx.getResponseEntry();
		
		if(rsp==null||rsp.length==0){
			logger.debug("net.response_is_empty {}", transCode);
			throw new AresCoreException("net.response_is_empty", transCode);
		}
		Map out = new HashMap();
		// 解析报文头(TPDU)：
		byte[] head = new byte[10];
		System.arraycopy(rsp,0,head,0,head.length);
		parseHeader(head,ctx,out);

		// 解析报文体
		byte[] packet = new byte[rsp.length-head.length];
		System.arraycopy(rsp, head.length, packet, 0, packet.length);
		parsePacket(packet,ctx,conf,out);
		ctx.getParamMap().clear();
		ctx.getParamMap().putAll(out);
		return true;
	}

    /**
     * 解析响应头
     * 
     * @param head
     * @param ctx
	 * @param map
     */
	private void parseHeader(byte[] head, IBusinessContext ctx,Map map) {
		//1、通过报文头获得交易结果信息：状态、交易结果等

		//2、如果交易结果异常，应抛出异常
	}

    /**
     * 解析报文体
     *
	 * @param packet
	 * @param ctx
	 * @param conf
	 * @param outMap
     */
    private void parsePacket(byte[] packet,IBusinessContext ctx,MBTransConfBean conf,Map outMap) {

		Iso8583Util iso8583Util = new Iso8583Util();
		//解析报文数据
		Map map = iso8583Util.analyze8583(packet);

		List<MBTransItem> items = conf.getRcv();
		// 遍历定义
		for (MBTransItem item : items) {
			if (!NetConst.FILED_TYPE_E.equals(item.getType())) {
				// 字段转换，如果设置了targetName则上送targetName对应的字段，否则送name字段
				String value = map.get(item.getTargetName()).toString();

				// 金额统一处理 分转元
				if(NetConst.FILED_TYPE_M.equals(item.getType())){
					value = AmountUtils.changeF2Y(value);
				}
				outMap.put(item.getName(), value);
				// 解析mapKey 数据字典
				parseItemMapKey(item, outMap, value);
			}
		}
	}


	// 解析数据字典
	private void parseItemMapKey(MBTransItem item, Map outMap, String key) {
		if (StringUtils.isEmpty(key)) {
			return ;
		}
		String type = item.getDictType();
		if (StringUtils.isEmpty(type)) {
			return ;
		}
//		outMap.put(item.getDictKeyName(), label);
	}
}
