package com.learnyeai.learnai.net.netMsg.common;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.consts.AppR;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.tools.common.JsonMapper;
import com.learnyeai.tools.common.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 通用渠道请求响应
 * Created by zpz on 2017/9/6.
 */
@Component
public class NetResponse4Common implements IResponseParser {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean parserResponseData(IBusinessContext busiContext, INetConfParser confParser, String transCode) {
        String rst = busiContext.getResponseEntry();
        try{
            Map<Object, Object> rstMap = JsonMapper.jsonToMap(rst);
            /*
{
 "data":
  {
  "MON_ERR_GRADE":""
  },
 "message":"交易成功",
 "success":"1"
 }
             */
            if(!rstMap.containsKey(AppR.RTN_CODE)){
                return false;
            }
            String rtCode = MapUtil.getMapValue(rstMap,AppR.RTN_CODE, "0");
            if(!"1".equals(rtCode)) {
                logger.error(MapUtil.getMapValue(rstMap, AppR.RTN_MSG, "" ).toString());
                return false;
            }
            busiContext.getParamMap().clear();
            if(rstMap.containsKey(AppR.RTN_DATA)){
                Object data = rstMap.get(AppR.RTN_DATA);
                if(data instanceof List){
                    busiContext.getParamMap().put(AppR.RTN_LIST, data);
                }else if(data instanceof Map){
                    busiContext.getParamMap().putAll((Map)data);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
