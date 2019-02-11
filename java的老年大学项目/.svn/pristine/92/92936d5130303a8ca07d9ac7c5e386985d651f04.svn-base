package com.learnyeai.base.action.common;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 防篡改随机码获取
 * Created by xln on 2015/8/23.
 */
@Service
public class PrevTamperCodeGetOp implements IAresSerivce {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public int execute(IBusinessContext context) {
        com.learnyeai.learnai.support.IBusinessContext ctx = (com.learnyeai.learnai.support.IBusinessContext) context;
        String str="abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        StringBuffer sb3=new StringBuffer();
        StringBuffer sb4=new StringBuffer();
        //取8次
        for(int i=0;i<8;i++){
            int  number=random.nextInt(62);//取整数0-61
            sb1.append(str.charAt(number));//取第(number-1)个字符
        }
        for(int i=0;i<8;i++){
            int  number=random.nextInt(62);
            sb2.append(str.charAt(number));
        }
        for(int i=0;i<8;i++){
            int  number=random.nextInt(62);
            sb3.append(str.charAt(number));
        }
        for(int i=0;i<8;i++){
            int  number=random.nextInt(62);
            sb4.append(str.charAt(number));
        }
        ArrayList list =new ArrayList();
        list.add(sb1.toString());
        list.add(sb2.toString());
        list.add(sb3.toString());
        list.add(sb4.toString());
        ctx.getParamMap().put("signCode", list);

        //保存进session
        Map map2 =new HashMap();
        map2.put("confusedCode1", sb1.toString());
        map2.put("confusedCode2", sb2.toString());
        map2.put("confusedCode3", sb3.toString());
        map2.put("confusedCode4", sb4.toString());
        ctx.saveSessionObject("confusedCode", map2);;

        return NEXT;
    }
}
