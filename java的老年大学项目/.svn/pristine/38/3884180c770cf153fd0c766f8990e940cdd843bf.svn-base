package com.thinkgem.jeesite.modules.sys.utils;

import cn.com.weye.core.consts.ICons;
import cn.com.weye.core.consts.ConsTools;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.Dict;

import java.util.*;

/**
 * Created by Administrator on 2017/2/8 0008.
 */
public class ConsUtils {
    /**
     * 根据枚举类型和枚举值获取值的中文说明
     * @param type
     * @param value
     * @param defaultValue
     * @return
     */
    public static String getConsLabel(String type, String value, String defaultValue){
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
            Map<String, ICons> map = ConsTools.getConsMap().get(type);
            for(Iterator<Map.Entry<String, ICons>> it = map.entrySet().iterator(); it.hasNext();){
                Map.Entry<String, ICons> o = it.next();
                if (value.equals(o.getKey())){
                    return o.getValue().getLabel();
                }
            }
        }
        return defaultValue;
    }

    /**
     * 根据枚举类型，将常量值和说明转换成List集合
     * @param type
     * @return
     */
    public static List<Dict> getConsList(String type){
        Map<String, ICons> map = ConsTools.getConsMap().get(type);
        List<Dict> consList = new ArrayList<Dict>();
        for(Iterator<Map.Entry<String, ICons>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, ICons> o = it.next();
            consList.add(new Dict(o.getValue().getVal(),o.getValue().getLabel()));
        }
        return consList;
    }

    /**
     * 返回字典列表（JSON）
     * @param type
     * @return
     */
    public static String getConsListJson(String type){
        return JsonMapper.toJsonString(getConsList(type));
    }
}
