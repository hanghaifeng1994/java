package com.learnyeai.learnai.net.netConf;

public class NetConst {
	public static final String SUCCESS = "0000";
	public static String TRAN_URL = "_TRAN_URL";
	public static String UTF_8 = "UTF-8";
	public static String HTTP_XML_PATH = "http/";
	public static String SOCKET_XML_PATH = "socket/";
	public static String WEB_XML_PATH = "";	// 此目录下的xml用于对返回前端数据进行过滤
	public static String SOAP_XML_PATH = "soap/";

	// 报文类型
//	public static final String FILED_TYPE_C = "C"; // 字符
	public static final String FILED_TYPE_N = "N"; // 整数
	public static final String FILED_TYPE_F = "F"; // 小数
	public static final String FILED_TYPE_M = "M"; // 金额
	public static final String FILED_TYPE_D = "D"; // 日期
	public static final String FILED_TYPE_B = "B"; // 加密密文
	public static final String FILED_TYPE_TPWD = "T"; // 交易密码
	public static final String FILED_TYPE_LPWD = "L"; // 登录密码
	public static final String FILED_TYPE_E = "E"; // 列表
	public static final String FILED_TYPE_OE = "OE"; // 对象
	public static final String FILED_TYPE_DICT = "dict"; // 字典
	public static final String FILED_TYPE_CONS = "cons"; // 常量
	public static final String FILED_TYPE_RES = "res"; // 资源


	public static final String TYPE_MAP = "map";
	public static final String TYPE_LIST = "list";

	public static final String XT_ITEM = "field";
	public static final String XT_LIST = "field-list";

	public static final String AT_NAME = "name";
//	public static final String AT_TARGET_NAME = "targetName";
	public static final String AT_HEADER = "header";
	public static final String AT_DESC = "desc";
	public static final String AT_TYPE = "type";
	public static final String AT_LEN = "length";
	public static final String AT_REQUIRED = "required";
	public static final String AT_DEFVAL = "default";
	public static final String AT_XPATH = "xpath";
	public static final String AT_PLUS = "plugin";
	public static final String AT_SIZE_FIELD = "sizeField";
	public static final String AT_COMMENT = "comment";
//	public static final String AT_VAL_TYPE = "valType";
	public static final String AT_DOLT = "dolt"; // 小数点保留位数
	public static final String AT_DATE_FORMAT = "dateFormat";
	public static final String AT_DICT_TYPE = "dictType";

	public enum XT_TYPE{snd, snd_head, rcv}
	public static final String XT_SEND = "snd";
	public static final String XT_SEND_HEAD= "snd_head";
	public static final String XT_RCV = "rcv";

	public static final String EMPTY = "";

	// --------------------报文定义扩展属性-------------
	public static final String PP_CREATE_BY = "createBy"; // 判断只有自己才能修改

	// 报文相关字段
	public static final String CHANN_ID = "CHANN_ID"; // 渠道标识
	public static final String TRANS_CODE = "TRANS_CODE";
	public static final String CUST_ID = "CUST_ID";
	public static final String BUSI_ID = "BUSI_ID";
	public static final String TRAN_SEQ = "TRAN_SEQ";
	public static final String TRAN_DATE = "TRAN_DATE";
	public static final String TRAN_TIME = "TRAN_TIME";
	public static final String LAGG = "LAGG";
	public static final String RSP_CODE = "RSP_CODE";
	public static final String RSP_MSG = "RSP_MSG";
	
    // 分页
	public static final String FILE_NAME = "fileName";// 定义文件中的增加文件头 
	public static final String FILE_ROWS = "fileRows";// 定义文件中的增加文件头 
	public static final String NEXT_KEY = "NEXT_KEY";// 下一页
	public static final String PAGE_SIZE = "PAGE_SIZE";// 每页数目
	
	public static final String NEXT_KEY_DEFAULT = "1";
	public static final String PAGE_SIZE_DEFAULT = "5";
}