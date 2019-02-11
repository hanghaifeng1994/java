package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

/**
 * 利率查询
 * Created by xln on 2015/8/27.
 */
@Service
public class RateGetOp implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int execute(IBusinessContext context) {
        com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
        //存贷款类型
        String prodClas = ctx.getParam("PROD_CLAS");
        //业务类型代码
        String prodTypeCode = ctx.getParam("PROD_TYPE_CODE");
        //业务代码
        String prodCode = ctx.getParam("PROD_CODE");
        //币种
        String ccyCode = ctx.getParam("CCY_CODE");

        DecimalFormat dcmFmt = new DecimalFormat("0.0000%");

        List<Map<String,String>> list =new ArrayList<Map<String, String>>();

        Map map10101 = new HashMap();
        map10101.put("PROD_CLAS","1");
        map10101.put("PROD_TYPE_CODE","101");
        map10101.put("PROD_CODE","10101");
        map10101.put("CCY_CODE",ccyCode);
        map10101.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10101.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10102 = new HashMap();
        map10102.put("PROD_CLAS","1");
        map10102.put("PROD_TYPE_CODE","101");
        map10102.put("PROD_CODE","10102");
        map10102.put("CCY_CODE",ccyCode);
        map10102.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10102.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10103 = new HashMap();
        map10103.put("PROD_CLAS","1");
        map10103.put("PROD_TYPE_CODE","101");
        map10103.put("PROD_CODE","10103");
        map10103.put("CCY_CODE",ccyCode);
        map10103.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10103.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10201 = new HashMap();
        map10201.put("PROD_CLAS","1");
        map10201.put("PROD_TYPE_CODE","102");
        map10201.put("PROD_CODE","10201");
        map10201.put("CCY_CODE",ccyCode);
        map10201.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10201.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10202 = new HashMap();
        map10202.put("PROD_CLAS","1");
        map10202.put("PROD_TYPE_CODE","102");
        map10202.put("PROD_CODE","10202");
        map10202.put("CCY_CODE",ccyCode);
        map10202.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10202.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10203 = new HashMap();
        map10203.put("PROD_CLAS","1");
        map10203.put("PROD_TYPE_CODE","102");
        map10203.put("PROD_CODE","10203");
        map10203.put("CCY_CODE",ccyCode);
        map10203.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10203.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10204 = new HashMap();
        map10204.put("PROD_CLAS","1");
        map10204.put("PROD_TYPE_CODE","102");
        map10204.put("PROD_CODE","10204");
        map10204.put("CCY_CODE",ccyCode);
        map10204.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10204.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10205 = new HashMap();
        map10205.put("PROD_CLAS","1");
        map10205.put("PROD_TYPE_CODE","102");
        map10205.put("PROD_CODE","10205");
        map10205.put("CCY_CODE",ccyCode);
        map10205.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10205.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10206 = new HashMap();
        map10206.put("PROD_CLAS","1");
        map10206.put("PROD_TYPE_CODE","102");
        map10206.put("PROD_CODE","10206");
        map10206.put("CCY_CODE",ccyCode);
        map10206.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10206.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10301 = new HashMap();
        map10301.put("PROD_CLAS","1");
        map10301.put("PROD_TYPE_CODE","103");
        map10301.put("PROD_CODE","10301");
        map10301.put("CCY_CODE",ccyCode);
        map10301.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10301.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10302 = new HashMap();
        map10302.put("PROD_CLAS","1");
        map10302.put("PROD_TYPE_CODE","103");
        map10302.put("PROD_CODE","10302");
        map10302.put("CCY_CODE",ccyCode);
        map10302.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10302.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map10401 = new HashMap();
        map10401.put("PROD_CLAS","1");
        map10401.put("PROD_TYPE_CODE","104");
        map10401.put("PROD_CODE","10401");
        map10401.put("CCY_CODE",ccyCode);
        map10401.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map10401.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        Map map20101 = new HashMap();
        map20101.put("PROD_CLAS","2");
        map20101.put("PROD_TYPE_CODE","201");
        map20101.put("PROD_CODE","20101");
        map20101.put("CCY_CODE",ccyCode);
        map20101.put("PROD_RATE", dcmFmt.format(Math.random()/10));
        map20101.put("PROD_DATE", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

        list.add(map10101);
        list.add(map10102);
        list.add(map10103);
        list.add(map10201);
        list.add(map10202);
        list.add(map10203);
        list.add(map10204);
        list.add(map10205);
        list.add(map10206);
        list.add(map10301);
        list.add(map10302);
        list.add(map10401);
        list.add(map20101);

        List<Map<String,String>> resultList = new ArrayList<Map<String, String>>();

        boolean fit = true;
        for(Map<String,String> map:list){
            if(!StringUtils.isEmpty(prodClas)&&!prodClas.equals(map.get("PROD_CLAS"))){
                fit=false;
            }
            if(!StringUtils.isEmpty(prodTypeCode)&&!prodTypeCode.equals(map.get("PROD_TYPE_CODE"))){
                fit=false;
            }
            if(!StringUtils.isEmpty(prodCode)&&!prodCode.equals(map.get("PROD_CODE"))){
                fit=false;
            }
            if(fit){
                resultList.add(map);
            }
            fit = true;
        }

        ctx.getParamMap().put("LIST", resultList);

        return NEXT;
    }
}
