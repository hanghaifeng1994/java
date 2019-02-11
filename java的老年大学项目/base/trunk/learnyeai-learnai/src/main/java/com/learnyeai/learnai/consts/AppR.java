package com.learnyeai.learnai.consts;

public class AppR {

    // 应用编号 手机银行
    public static final String APP_TYPE = "001";


    /* *************** 交易日志要素 *************** */
    // 访问地址
    public static final String MDC_URL = "url";
    // 交易编号
    public static final String MDC_TRANS_CODE = "transCode";
    // 会话编号
    public static final String MDC_SESSION_ID = "sid";
    // 用户号|客户号
    public static final String MDC_USER_ID = "userId";
    // 登录名
    public static final String MDC_LOGIN_ID = "loginId";
    //客户端操作系统 I:IOS  A:ANDROID
    public static final String MDC_CLIENT_OS = "client_os";
    // 客户端设备标识
    public static final String MDC_CLIENT_NO = "client_no";
    // 客户端版本
    public static final String MDC_CLIENT_VER_NO = "client_version";
    // 客户端IP
    public static final String MDC_CLIENT_IP = "client_ip";

    public static final String RTN_SUCCESS = "1";
    public static final String RTN_TIME_OUT = "005";
    public static final String RTN_MSG = "message";
    public static final String RTN_CODE = "success";
    public static final String RTN_CAUSE = "cause";
    public static final String RTN_DATA = "data";
    public static final String RTN_LIST = "LIST";
    public static final String RTN_TOTAL = "totalCount";
    public static final String RTN_PAGE_NO = "pageNo";
    public static final String RTN_PAGE_SIZE = "pageSize";

    public static final String ACCT_NO = "ACCT_NO";
    public static final String ACCT_TYPE = "ACCT_TYPE";

    public static final String LIST = "LIST";
    public static final String _TRANS_CODE = "_transCode";
    public static final String TRANS_CODE = "transCode";

    //响应码
    public static final String RSP_CODE = "RSP_CODE";



    /* *************** 登陆状态(CUST_LOGIN_STATUS) *************** */
    //正常
    public static final String CLS_NORMAL = "0";
    //首次登陆
    public static final String CLS_FIRST_LOGIN = "1";
    //柜面重置
    public static final String CLS_COUNTER_RESET = "2";
    //设备未绑定
    public static final String CLS_DEVICE_NO_BINDING = "3";
    //柜面重置且设备未绑定
    public static final String CLS_RESET_NO_BINDING = "4";
    //卡号首次登陆

    public static final String NEXT_KEY = "NEXT_KEY";

    public static final String NEXT_KEY_DEFAULT = "1";

    public static final String PAGE_SIZE = "PAGE_SIZE";

    public static final String PAGE_SIZE_DEFAULT = "5";

    /* *************** 登录方式 *************** */
    public static final String IS_SUP_FINGER = "IS_SUP_FINGER";//是否支持指纹登录
    public static final String FINGER = "FINGER";//是否指纹登录
    public static final String LOGIN_BY_MOBILE = "M";//手机号
    public static final String LOGIN_BY_IDT = "I";//证件号
    public static final String LOGIN_BY_UID = "U";//用户号
    public static final String LOGIN_BY_FP = "F";//指纹
    
    public static final String CUST_STATUS_OK = "N";//客户正常状态
    public static final String LGN_ERR_NUM = "LGN_ERR_NUM";//登录密码输入错误次数
    public static final String LGN_ERR_LMT = "LGN_ERR_LMT";//密码输入错误次数上限
    public static final String PWD_PRE_FLAG = "PWD_PRE_FLAG";//密码初始状态
    public static final String CARD_LIST = "CARD_LIST";//卡列表

    /* *************** 登录响应状态码 *************** */
    public static final String LOGIN_RSP_ERROR_IMAGE_CODE = "01";//验证码输入错误
    public static final String LOGIN_RSP_UNFOUND_USER = "02";//未知用户
    public static final String LOGIN_RSP_FINGER_UNBIND = "03";//指纹登录，未绑定设备
    public static final String LOGIN_RSP_ERROR_PASSWORD = "04";//密码错误
    public static final String LOGIN_RSP_ERRPWD_LMT = "05";//密码输入错误此处超限
    public static final String LOGIN_RSP_FAIL_OTHER = "09";//未知异常导致的登录失败
    public static final String LOGIN_RSP_SUCCESS_NORMAL = "10";//正常登录成功
    public static final String LOGIN_RSP_SUCCESS_KICK = "11";//踢掉之前登录客户端后登录成功

    public static final boolean ENC_SM = false;	// 国密加密标识
    
    
    public static final String SSO_TYPE = "SSO_TYPE";	// 单点登录方式
    public static final String UDP = "UDP";	// UDP
    public static final String DB = "DB";	// DB
    public static final String CHECK_OUT = "CHECK_OUT";	// DB
    
    public static final String RTN_RE_LOGIN = "007";

    /* *************** 微信配置 *************** */
    public static final String WEIXIN_APPID = "weixin_appId";
    public static final String WEIXIN_APPSECRET = "weixin_appsecret";
    public static final String WEIXIN_OPENID = "weixin_openid";
    public static final String WEIXIN_TOKEN= "weixin_token";
    
}
