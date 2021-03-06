package com.learnyeai.base.utils;

/**
 * Created by zpz on 2016/4/20.
 */
public class BaseReportErrorKey {

    public static final String RTN_RE_LOGIN = "007"; // "该用户已在其它设备上登录"

    //  密码错误超过{0}次，无法登录
    public static String login_IncorrectUserOrPwd_Over_LMT="login.IncorrectUserOrPwd.Over_LMT";
    //原始密码错误
    public static String login_pwd_wong ="login.pwd.wong";
    //修改密码和新密码不能相同
    public static String login_pwd_same = "login.pwd.same";
    //  密码错误，您还有{0}次机会
    public static String login_IncorrectUserOrPwd="login.IncorrectUserOrPwd";
    //  密码错误次数超过{0}次，手机银行将被冻结，请到柜面重置手机银行登录密码
    public static String login_IncorrectPwdUpLimit="login.IncorrectPwdUpLimit";
    //  输入的密码需要长度为{0}~{1}位的数字和字母
    public static String login_inputPassWd_formatError="login.inputPassWd.formatError";
    //  用户不存在
    public static String login_UserNotFound="login.UserNotFound";
    // 用户未通过审核
    public static String cust_not_audit_sucess="cust_not_audit_sucess";
    //  客户已被冻结
    public static String login_UserFrozon="login.UserFrozon";
    public static String login_UserDisable="login.UserDisable";
    // 用户已被注销
    public static String login_UseCancel="login.UseCancel";
    //用户已存在
    public static String login_UserExist="login.UserExist";
    // 请登录
    public static String login_user_no_login="login_user_no_login";




}
