package com.learnyeai.core;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by zpz on 2018/4/19.
 */
public interface IBusinessContext {
    /**
     * 初始化基础参数
     *
     * @param request
     * @param locale
     */
    public void init(HttpServletRequest request, String locale);

    /**
     * 获取Map容器的客户端请求参数集
     *
     * @return
     */
    public Map getParamMap();

    /**
     * 获取请求的参数
     *
     * @param xpath
     * @return
     */
    public String getParam(String xpath);

    /**
     * 获取请求的参数，参数为空时，使用缺省值
     *
     * @param xpath
     * @param defval
     * @return
     */
    public String getParam(String xpath, String defval);

    /**
     * 设置请求参数
     *
     * @param name
     * @param text
     * @return
     */
    public boolean setParam(String name, String text);

    /**
     * 获取请求的参数对象数组
     *
     * @param xpath
     * @return
     */
    public List getParamDatas(String xpath);

    /**
     * 获取会话对象
     *
     * @param name
     * @return
     */
    public <T> T getSessionObject(String name);

    /**
     * 保存会话对象
     *
     * @param name
     * @param obj
     */
    public void saveSessionObject(String name, Object obj);

    /**
     * 消除会活属性
     *
     * @param name
     */
    public void removeSession(String name);


    /**
     * 设置临时响应信息
     *
     * @param responseEntry
     */
    public void setResponseEntry(Object responseEntry);

    /**
     * 获取临时响应信息
     *
     * @return
     */
    public <T> T getResponseEntry();

    /**
     * 设置临时请求信息
     *
     * @param requestEntry
     */
    public void setRequestEntry(Object requestEntry);

    /**
     * 获取临时请求信息
     *
     * @return
     */
    public <T> T getRequestEntry();

    /**
     * 地区归属
     *
     * @return
     */
    public Locale getLocale();

    public void setLocale(String local);

    public void setLocale(Locale local);

    /**
     * 获取交易流水号
     *
     * @return
     */
    public <T> T getMainSeqNo();

    /**
     * 设置交易流水号
     *
     * @return
     */
    public void setMainSeqNo(String serialNo);

    /**
     * 获取临时交易号
     *
     * @return
     */
    public String getTransCode();

    /**
     * 设置临时交易号
     *
     * @return
     */
    public void setTransCode(String tranCode);


    public HttpServletRequest getRequest();



    IBusinessContext copy(BusinessContext o);
}

