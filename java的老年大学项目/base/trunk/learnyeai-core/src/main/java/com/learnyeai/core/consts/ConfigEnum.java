package com.learnyeai.core.consts;

import java.nio.charset.Charset;

/**
 * 类配置信息
 * @author lc3@yitong.com.cn
 */
public class ConfigEnum {
    // ios、android、微信小程序、浏览器
    public enum CLIENT_OS{I,A,WA,O}

    public static final String SYS_DEFAULT_SPLIT_STR = ";"; // 系统默认分隔符
    public static final char SYS_DEFAULT_VAR_SIGN = '$';    // 变量开始标志

    public static final Charset DEFAULT_CONFIG_FILE_ENCODING = Charset.forName("UTF-8");    // 默认的配置文件编码

    public static final String DICT_SYS_PARAMS = "SYS_PARAM";	// 系统配置数据字典项

    // 数据表字段VVVVVVVVVVVVVVV
    public static final String FILED_NAME_CREATE_DATE = "CREATE_DATE";   // 创建时间字段名称
    public static final String FILED_NAME_CREATE_BY = "CREATE_BY";   // 创建人字段名称
    public static final String FILED_NAME_UPDATE_DATE = "UPDATE_DATE";   // 更新时间字段名称
    public static final String FILED_NAME_UPDATE_BY = "UPDATE_BY";   // 更新人字段名称
    public static final String FIELD_DEL_FLAG = "DEL_FLAG";

    // 实例是bean时，字段名称
    public static final String BEAN_FILED_NAME_CREATE_DATE = "createDate";   // 创建时间字段名称
    public static final String BEAN_FILED_NAME_CREATE_BY = "createBy";   // 创建人字段名称
    public static final String BEAN_FILED_NAME_UPDATE_DATE = "updateDate";   // 更新时间字段名称
    public static final String BEAN_FILED_NAME_UPDATE_BY = "updateBy";   // 更新人字段名称
    public static final String BEAN_FIELD_DEL_FLAG = "delFlag";
    // 数据表字段^^^^^^^^^^^^^^^^


    // 删除标记（0：正常；1：删除；2：审核；）
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";


    // 显示/隐藏
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    // 是/否
    public static final String YES = "1";
    public static final String NO = "0";

    // 启用/禁用
    public static final String ENABLE = "1";
    public static final String DISABLE = "0";

    // 生效/失效
    public static final String EFF = "1";
    public static final String FAL = "0";

    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";
}
