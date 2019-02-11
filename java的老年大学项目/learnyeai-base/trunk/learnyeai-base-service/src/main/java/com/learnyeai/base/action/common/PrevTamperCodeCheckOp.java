package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.config.ConfigUtils;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.error.AresRuntimeException;
import com.learnyeai.tools.security.BASE64Custom;
import com.learnyeai.tools.security.encrypt.AESCoder;
import com.learnyeai.tools.security.encrypt.MD5Encrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Map;

/**
 * 检查客户端是否被篡改
 * Created by xln on 2015/8/23.
 */
@Component
public class PrevTamperCodeCheckOp implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    // 客户版本信息
    final String MOBILE_CLIENT_TAG_PNC = ConfigUtils.getValue("MOBILE_CLIENT_TAG_PNC");

    @Override
	public int execute(IBusinessContext context) {
		com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
        if(ctx.getSessionObject("confusedCode")==null){
            logger.warn("防篡改随机码过期，请重新获取！");
            throw new AresRuntimeException("common.dyn_code_timeout");
        }

        Map map = (Map) ctx.getSessionObject("confusedCode");

        boolean isTrue = false;
        
        String clientOS = ctx.getParam(SessR.CLIENT_OS,"A");	// I: ios A:android
    	String appVer = ctx.getParam("APP_VER","1.0.0");
        // 客户签名信息
        String MOBILE_CLIENT_SIGNDATE = ConfigUtils.getValue(clientOS+"_"+appVer+"_SIGNDATE");
        
        for (int i = 1; i <= map.size(); i++) {
            String signInfo = ctx.getParam("SIGN_INFO" + i); // 客户端签名信息
            String serverCode = (String) map.get("confusedCode" + i);
            String rndCode = ctx.getParam("RND_CODE" + i);
            if("I".equals(clientOS)){
            	if (this.prevTamperCheck4ios(serverCode,
                        signInfo, rndCode,MOBILE_CLIENT_SIGNDATE)) {
            		return  NEXT;
                }
            }else{
            	if (this.prevTamperCheck4android(serverCode,
                        signInfo, rndCode,MOBILE_CLIENT_SIGNDATE)) {
            		return  NEXT;
                }
            }
        }
        if(!isTrue) {
            logger.warn("客户版本校验异常出错");
            throw new AresRuntimeException("common.check_confused_error");
        }
        return  NEXT;
    }

    /**
     * 检查android客户端是否被篡改
     *
     * @param serverCode
     * @param signInfo
     * @param rndCode
     * @return
     */
    public boolean prevTamperCheck4android(String serverCode, String signInfo,
            String rndCode,String MOBILE_CLIENT_SIGNDATE) {
	   try {
	       // 将客户端传过来的16位随机数作为key
	       Key key = AESCoder.toKey(rndCode.getBytes());
	       // 将客户端的加密数据进行AES解密
	       byte[] decryptData = AESCoder.decrypt(
	               BASE64Custom.decode(signInfo), key);
	       // 从session中获得之前生成的服务端随机数
	       // 取前16位有效数据
	       if (null != decryptData && decryptData.length >= 16) {
	           byte[] trueData = new byte[16];
	           for (int i = 0; i < 16; i++) {
	               trueData[i] = decryptData[i];
	           }
	           String custRemark = MD5Encrypt.byteArr2HexStr(trueData);
	           // signDate 为客户端提供的签名文件信息
	           String oriData = MOBILE_CLIENT_SIGNDATE + MOBILE_CLIENT_TAG_PNC
	                   + serverCode;
	           String md5Str = MD5Encrypt.MD5(oriData);
	           if (custRemark.equalsIgnoreCase(md5Str)) {
	               return true;
	           }
	       }
	
	   } catch (Exception e) {
	       logger.warn("客户版本校验异常出错");
	       throw new AresRuntimeException("common.check_confused_error");
	   }
	   return false;
	}
	
	/**
	* 检查ios客户端是否被篡改
	*
	* @param serverCode
	* @param signInfo
	* @param rndCode
	* @return
	*/
	public boolean prevTamperCheck4ios(String serverCode, String signInfo,
	            String rndCode,String MOBILE_CLIENT_SIGNDATE) {
	   try {
	       // 将客户端传过来的16位随机数作为key
	       Key key = AESCoder.toKey(rndCode.getBytes());
	       // 将客户端的加密数据进行AES解密
	       byte[] decryptData = AESCoder.decrypt(
	               BASE64Custom.decode(signInfo), key);
	       // 从session中获得之前生成的服务端随机数
	       String custRemark = new String(decryptData, "UTF-8");
	       // signDate 为客户端提供的签名文件信息
	       String oriData = MOBILE_CLIENT_SIGNDATE + MOBILE_CLIENT_TAG_PNC
	               + serverCode;
	       String md5Str = MD5Encrypt.MD5(oriData);
	       if (custRemark.equalsIgnoreCase(md5Str)) {
	           return true;
	       }
	
	   } catch (Exception e) {
	       logger.warn("客户版本校验异常出错");
	       throw new AresRuntimeException("common.check_confused_error");
	   }
	   return false;
	}
}
