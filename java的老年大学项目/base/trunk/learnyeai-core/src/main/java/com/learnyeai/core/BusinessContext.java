package com.learnyeai.core;

import com.learnyeai.tools.common.MapUtil;
import com.learnyeai.tools.common.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 统一资源上下文 ，业务总线 reqeust|session|application data selectNode
 * 数据总线接口，采用JSON-MAP为数据结构，<br>
 * 共两个数据区：基础数据区，会话数据区
 * 
 * @author yaoym
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class BusinessContext implements IBusinessContext {
    protected HttpServletRequest request;
    protected Locale Locale;
    // 临时交互数据
    protected Map paraMap;
    // 临时请求内容
    protected Object requestEntry;
    // 临时响应内容
    protected Object responseEntry;
    // 交易流水号
    protected String mainSeqNo;
    // 交易号
    protected String transCode;


    public static final List EMPTY_LIST = new ArrayList();


    public BusinessContext() {
        this.init(null, null);
    }
    public BusinessContext(Map params) {
        this.init(null, null);
        this.paraMap.putAll(params);
    }

    public BusinessContext(HttpServletRequest request, String locale) {
        this.init(request, locale);
    }

    public void init(HttpServletRequest request, String locale) {
        locale = StringUtils.isEmpty(locale) ? "zh_CN" : locale;
        this.Locale = new Locale(locale);
        this.request = request;

        this.paraMap = new HashMap();
    }

    public Map getParamMap() {
        return this.paraMap;
    }

    public String getParam(String xpath) {
        String val = MapUtil.singleNodeValue(paraMap, xpath);
        return  val == null? "" : val;
    }

    public String getParam(String xpath, String defval) {
        String value = getParam(xpath);
        return StringUtils.isEmpty(value) ? defval : value;
    }

    public boolean setParam(String name, String text) {
        this.paraMap.put(name, text);
        return true;
    }

    public List getParamDatas(String xpath) {
        return MapUtil.getMapValue(this.paraMap, xpath, EMPTY_LIST);
    }


    public <T> T getResponseEntry() {
        return (T) this.responseEntry;
    }

    public void setRequestEntry(Object requestEntry) {
        this.requestEntry = requestEntry;
    }

    public <T> T getRequestEntry() {
        return (T) this.requestEntry;
    }

    public void setResponseEntry(Object responseEntry) {
        this.responseEntry = responseEntry;
    }

    public Locale getLocale() {
        return this.Locale;
    }

    public void setLocale(String local) {
        this.Locale = new Locale(local);
    }

    public void setLocale(Locale local) {
        this.Locale = local;
    }


    public String getMainSeqNo() {
        return mainSeqNo;
    }

    public void setMainSeqNo(String mainSeqNo) {
        this.mainSeqNo = mainSeqNo;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public HttpServletRequest getRequest() {
		return request;
	}


    @Override
    public IBusinessContext copy(BusinessContext target) {
        target.request = this.request;
        target.paraMap.putAll(this.paraMap);
        target.mainSeqNo = this.mainSeqNo;
        target.transCode = this.transCode;

        return target;
    }
}
