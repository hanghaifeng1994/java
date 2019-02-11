package com.learnyeai.learnai.net.netMsg.filter;

import com.learnyeai.learnai.net.IReportItemValParser;
import com.learnyeai.learnai.net.netConf.MBTransItem;
import com.learnyeai.tools.common.TypeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Created by zpz on 2018/5/15.
 */
public class ReportItemVal_DoubleParser implements IReportItemValParser {
    private int defDolt = 1;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String parse(Object val, MBTransItem item) {

        Integer dot = item.getDolt();
        if(dot == null){
            dot = defDolt;
        }
        BigDecimal decimal = new BigDecimal("0");
        if(val == null) {
//            return percent("0", isPercent);
        }if(val instanceof Integer){
            Integer dd = (Integer)val;
            decimal = new BigDecimal(dd);
        }else if(val instanceof Byte) {
            Integer dd = ((Byte)val).intValue();
            decimal = new BigDecimal(dd);
        }else if(val instanceof Float){
            decimal = new BigDecimal((Float)val * 1.0);
        }else if(val instanceof Double){
            decimal = new BigDecimal((Double) val);
        }else if(val instanceof String){
            try{
                if(TypeHelper.isNumber(val))
                    decimal = new BigDecimal(val.toString());
            }catch (Exception e){
                logger.error("数字格式有误", e);
            }
        }else if(val instanceof BigDecimal) {
            decimal = (BigDecimal)val;
        }

        String ssPercent = item.getProperty("isPercent");
        boolean isPercent = false;
        if(null != ssPercent && ssPercent.equals("true")) {
            isPercent = true;
        }

        if(isPercent){
            decimal = decimal.multiply(new BigDecimal(100));
        }

        String text = null;
        decimal = decimal.setScale(dot,BigDecimal.ROUND_HALF_UP);
        /*if(dot == 0){
            text = String.valueOf(decimal.intValue());
        }else {
            text = decimal.setScale(dot,BigDecimal.ROUND_HALF_UP).toString();
        }*/
        text = decimal.toString();

        return percent(text, isPercent);
    }
    private String percent(String text, boolean isPercent){

        if(isPercent){
            return text = text + "%";
        }
        return text;
    }

    public int getDefDolt() {
        return defDolt;
    }

    public void setDefDolt(int defDolt) {
        this.defDolt = defDolt;
    }
}
