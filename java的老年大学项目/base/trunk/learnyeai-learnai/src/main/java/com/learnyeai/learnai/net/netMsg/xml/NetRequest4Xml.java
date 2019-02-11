package com.learnyeai.learnai.net.netMsg.xml;

import java.security.Key;
import java.util.List;
import java.util.Map;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.net.netConf.MBTransConfBean;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.learnai.error.AresCoreException;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.learnai.net.netConf.NetConst;
import com.learnyeai.learnai.support.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.learnyeai.tools.common.AmountUtils;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;
import com.learnyeai.tools.security.encrypt.AESCoder;
import com.learnyeai.tools.security.encrypt.Converts;

/**
 * 生成请求报文
 * 
 * @author LQ
 * 
 */
@Component
public class NetRequest4Xml implements IRequstBuilder {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private final String XML_ENCODE = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
	private final String TRANS_SEQ = "H_TRANS_SEQ";
	private final String TRANS_CODE = "H_TRANS_CODE";
	private final String CHANN_ID = "H_CHANN_ID";
	private final String CIFN = "H_CIFN_NO";
	private final String SHOW_REQ = "H_SHOW_REQ";

	@Override
	public boolean buildSendMessage(IBusinessContext ctx,
									INetConfParser confParser, String transCode) {
		MBTransConfBean conf = confParser.findTransConfById(transCode, NetConst.HTTP_XML_PATH);
		if (conf == null) {
			logger.warn("config_not_definied: {}", transCode);
			throw new AresCoreException("net.config_not_definied", transCode);
		}
		ctx.setParam(NetConst.TRAN_URL, conf.getName());
		StringBuffer bf = new StringBuffer(1024);
		bf.append(XML_ENCODE).append("<trans>");
        // 消息头
		buildMsgHead(ctx, conf, transCode, bf);
        // 消息体：
		buildMsgBody(ctx, conf, transCode, bf);
		bf.append("</trans>");
		ctx.setRequestEntry(bf.toString());
		return true;
	}

	private void buildMsgHead(IBusinessContext ctx, MBTransConfBean conf,
			String transCode, StringBuffer bf) {
		bf.append("<head>");
        // 手工填写
        buildElement(bf, TRANS_SEQ, "");// 前端流水号
        buildElement(bf, TRANS_CODE, conf.getName());// 交易名称
        buildElement(bf, CHANN_ID, "01");// 渠道代号
		String cifnNo = ctx.getSessionObject(SessR.CIFN);
        buildElement(bf, CIFN, cifnNo == null ? "" : cifnNo);// 核心客户号
        buildElement(bf, SHOW_REQ, "");// 响应报文是否包含请求报文
		bf.append("</head>");
	}

    /**
     * 生成报文主体
     * 
     * @param ctx
     * @param conf
     * @param transCode
     * @return
     */
	private void buildMsgBody(IBusinessContext ctx, MBTransConfBean conf,
			String transCode, StringBuffer bf) {
		bf.append("<data>");
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
		bf.append("</data>");
	}

    /**
     * 生成字段内容
     * 
     * @param param
     * @param item
     * @param bfOut
     */
	private void buildItem(Map param, MBTransItem item, StringBuffer bfOut) {
        String name = item.getName();
        // 字段转换，如果设置了targetName则上送targetName对应的字段，否则送name字段
        String targetName = item.getTargetName();
        
		String value = MapUtil.getMapValue(param, name, item.getDefaultValue());
		if (StringUtils.isEmpty(value)) {
			if (item.isRequred()) {
                logger.warn("common.parameter_empty {}", item.getDesc());
                throw new AresRuntimeException("common.parameter_empty", item.getDesc());
			}
		}
		// 金额统一处理 元转分
		if(NetConst.FILED_TYPE_M.equals(item.getType())){
			value = AmountUtils.changeY2F(value);
		}
		
		// 交易密码统一调用加密机进行加密
		String type = item.getType();
		if(NetConst.FILED_TYPE_TPWD.equals(type)){
			/*// 是否使用国密加密方式开关
            if(AppR.ENC_SM){
            	// 如果银行用了加密机，并且加密机的算法已与客户端协商一致，则不需要进行解密，可以直接返回密文
            	try {
	            	SM2Ecrypt sm2 = SM2Ecrypt.getIntance();
	            	byte[] rst = sm2.decode(value);
	            	value = new String(rst);
            	} catch (Exception e) {
    				throw new AresRuntimeException("common.tran_pwd_decrypt_error");
    			}
            }else*/{
    			// 对交易密码密文进行解密，AES
    			try {
    				String randomKey = ConfigUtils.getValue("TRAN_KEY");
    				Key k = AESCoder.toKey(randomKey.getBytes());
    				byte[] decryptData = AESCoder.decrypt(Converts.strToBase64(value), k);
    			    value = new String(decryptData);
    			} catch (Exception e) {
    				throw new AresRuntimeException("common.tran_pwd_decrypt_error");
    			}
    			
    			// 获取加密因子 卡号
    			String AcctNo = param.get("AcctNo")+"";
    			if(StringUtils.isEmpty(AcctNo)){
    				AcctNo = param.get("CARD_NO")+"";
    			}
    			if(StringUtils.isEmpty(AcctNo)){
    				throw new AresRuntimeException("common.encry_need_cardno");
    			}
    			
    			// 调用加密机进行加密
    			try{
    			//	value = DecryEncry.getInstance().EncryPassword(value, AcctNo);
    			}catch(Exception e){
    				throw new AresRuntimeException("common.encry_fail");
    			}
            }
		}
				
		buildElement(bfOut, targetName, value);
	}

	private void buildElement(StringBuffer bf, String name, String value) {
		bf.append("<").append(name).append(">");
		bf.append(null==value?"":value);
		bf.append("</").append(name).append(">");
	}

}
