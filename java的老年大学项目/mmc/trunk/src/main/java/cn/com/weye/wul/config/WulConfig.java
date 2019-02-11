package cn.com.weye.wul.config;

import cn.com.weye.core.utils.ConfigUtils;

/**
 * Created by zpz on 2016/9/25.
 */
public class WulConfig {

    public static String getDeanLoginName(){
        return ConfigUtils.getValue("YUAN_ZHANG_LOGIN_NAME");
    }

}
