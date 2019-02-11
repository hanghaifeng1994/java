package com.learnyeai.base.action.login;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.api.vo.CustInfoVo;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.utils.applet.EmojiFilter;
import com.learnyeai.base.utils.applet.Pkcs7Encoder;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.exception.BusinessException;
import com.learnyeai.core.flow.IAresSerivce;
import com.learnyeai.learnai.consts.ReportErrorKey;
import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.security.BASE64Custom;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 小程序用户添加，如果不存在添加
 *  输入：
 *      OPEN_ID
 *      PHOTO
 *      MCHT_ID
 *      MCHT_SCHM_ID
 *  输出
 * Created by zpz on 2018/5/14.
 */
@Service
public class ApltUserAddOp implements IAresSerivce {
    @Autowired
    private CustInfoWyService custInfoWyService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int execute(IBusinessContext ctx) {
        String openId = ctx.getParam(CustInfoVo.CF.openId);
        String photo = ctx.getParam(CustInfoVo.CF.photo);
        String mchtId = ctx.getParam(CustInfoVo.CF.mchtId);
        String mcht_schm_id = ctx.getParam(CustInfoVo.CF.mchtSchmId);
        // 检查参数
        if(StringUtils.isBlank(openId)){
            throw new BusinessException(ReportErrorKey.common_parameter_empty,"参数为空");
        }

        CustInfo pp = new CustInfo();
        CustInfo ret = pp;
        // 查询是否是同一商户
        CustInfo custInfo = custInfoWyService.queryByOpenId(openId);

        if(custInfo != null){
            pp.setCustId(custInfo.getCustId());
            custInfo.setPhoto(photo);
            ret = custInfo;
        }else {
            pp.setOpenId(openId);
            pp.setMchtId(mchtId);
            pp.setMchtSchmId(mcht_schm_id);
            pp.setCustType(BaseCons.CUST_INFO_TYPE.KH.getVal());
        }
        pp.setPhoto(photo);
        custInfoWyService.save(pp);

        String unionid = custInfo.getUnionid();
        if(com.learnyeai.tools.common.StringUtils.isNotBlank(unionid))
            return NEXT;

        try{
            CustInfo userNew = getuuid(ctx);
            userNew.setCustId(custInfo.getCustId());
            custInfoWyService.save(userNew);

            custInfo.setSex(userNew.getSex());
            custInfo.setPhoto(userNew.getPhoto());
            custInfo.setUnionid(userNew.getUnionid());
            custInfo.setShortName(userNew.getShortName());
            custInfo.setCustName(userNew.getCustName());
        }catch (Exception e){
            logger.error("获取uuid失败",e);
        }
        return NEXT;
    }

    /**
     * 获取unionid，个人帐号也获取不到这个值
     * @param ctx
     * @return
     */
    private CustInfo getuuid(IBusinessContext ctx){
        final String encryptedDataKey = "encryptedData";
        final String ivKey = "IV";
        String session_key = ctx.getParam("session_key");
        if(!ctx.getParamMap().containsKey(encryptedDataKey))
            return null;
/*userInfo
nickName	String	用户昵称
avatarUrl	String	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
gender	String	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
city	String	用户所在城市
province	String	用户所在省份
country	String	用户所在国家
language	String	用户的语言，简体中文为zh_CN

encryptedData
 "openId": "OPENID",
    "nickName": "NICKNAME",
    "gender": GENDER,
    "city": "CITY",
    "province": "PROVINCE",
    "country": "COUNTRY",
    "avatarUrl": "AVATARURL",
    "unionId": "UNIONID",
    "watermark":
    {
        "appid":"APPID",
    "timestamp":TIMESTAMP
    }*/



        logger.debug("unionid <<<<<<<");
        try{
            // 这种方法获取不到unionid，可能未绑定公众号，这是公众号的接口
            //{"errcode":40001,"errmsg":"invalid credential, access_token is invalid or not latest hint: [lIz5Ca0983vr57!]"}
            /*String openid1 = rstMap.get("openid").toString();
            String sessk = rstMap.get("session_key").toString();
            String ss = HttpUtil.doGet("https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN&access_token=" +
                    sessk +
                    "&openid=" + openid1);
            logger.debug(ss);*/


            //--------------------------
/*userInfo	OBJECT	用户信息对象，不包含 openid 等敏感信息
rawData	String	不包括敏感信息的原始数据字符串，用于计算签名。
signature	String	使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息，参考文档 signature。
encryptedData	String	包括敏感数据在内的完整用户信息的加密数据，详细见加密数据解密算法
iv	String	加密算法的初始向量*/


            String encryptedData = ctx.getParam("encryptedData");
            String iv = ctx.getParam("IV");
            logger.debug(encryptedData);
            logger.debug(iv);

            byte dataByte[] = BASE64Custom.decode(encryptedData);
            byte keyByte[] = BASE64Custom.decode(session_key);
            byte ivByte[] = BASE64Custom.decode(iv);
            byte[] decData = Pkcs7Encoder.decryptOfDiyIV(dataByte, keyByte, ivByte);
            String desSS = new String(decData, "utf-8");
            logger.debug(desSS);
            Map<Object, Object> desMap = JsonMapper.getInstance().jsonToMap(desSS);
            Map userMap = new HashMap();
            String nickName = MapUtil.getMapValue(desMap, "nickName","");
//            logger.debug(nickName);
            String replaceReg = "#(\\\\\\ud[0-9a-f]{3})#ie)";
//            nickName = nickName.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
            nickName = EmojiFilter.filterEmoji(nickName);
//            logger.debug(nickName);
            /*userMap.put(CustInfoVo.CF.shortName, nickName);
            userMap.put(CustInfoVo.CF.custName, nickName);
            userMap.put(CustInfoVo.CF.sex, MapUtil.getMapValue(desMap, "gender",""));
            userMap.put(CustInfoVo.CF.unionid, desMap.get("unionId"));
            CustUser.setPhoto(userMap, desMap.get("avatarUrl"));*/
            CustInfo custInfoVo = new CustInfo();
            custInfoVo.setShortName(nickName);
            custInfoVo.setCustName(nickName);
            String sex = MapUtil.getMapValue(desMap, "gender","GENDER");
            custInfoVo.setSex("GENDER".equals(sex) ? "1" : "2");
            custInfoVo.setUnionid(MapUtil.singleNodeText(desMap, "unionId"));
            custInfoVo.setPhoto(MapUtil.singleNodeText(desMap, "avatarUrl"));

            logger.debug("unionid <<<<<<<");
            return custInfoVo;

        }catch (Exception e){
            logger.debug("unionid 失败");
            e.printStackTrace();
            return null;
        }
    }
}
