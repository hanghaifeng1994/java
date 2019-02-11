package com.learnyeai.learnai.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.learnyeai.core.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IRequstBuilder;
import com.learnyeai.learnai.net.IResponseParser;

/**
 * 统一资源上下文 ，业务总线 reqeust|session|application data selectNode
 * 数据总线接口，采用JSON-MAP为数据结构，<br>
 * 共两个数据区：基础数据区，会话数据区
 * 
 * @author yaoym
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BusinessContext extends com.learnyeai.core.BusinessContext implements com.learnyeai.learnai.support.IBusinessContext {
    private Map reqHead;

    private IRequstBuilder requstBuilder;
    private IResponseParser responseParser;
    private INetConfParser confParser;

    public BusinessContext() {
        init(null,null);
    }

    public BusinessContext(Map params) {
        super(params);
    }

    public BusinessContext(HttpServletRequest request, String locale) {
        super(request, locale);
    }

    @Override
    public void init(HttpServletRequest request, String locale) {
        super.init(request, locale);
        reqHead = new HashMap();
    }

    @Override
    public IBusinessContext copy(com.learnyeai.core.BusinessContext target) {
        if(null == target)
            target = new BusinessContext();
        BusinessContext o = (BusinessContext) target;
        o.reqHead.putAll(this.reqHead);

        o.requstBuilder = this.requstBuilder;
        o.responseParser = this.responseParser;
        o.confParser = this.confParser;

        return super.copy(o);
    }


    public <T> T getSessionObject(String name) {
//        return (T) session.getAttribute(name);
        return (T) ThreadContextUtil.getSession(true).getAttribute(name);
    }

    public void saveSessionObject(String name, Object obj) {
//        session.setAttribute(name, obj);
        ThreadContextUtil.getSession(true).setAttribute(name,obj);
    }

    public void removeSession(String name) {
//        session.removeAttribute(name);
        ThreadContextUtil.getSession(true).removeAttribute(name);
    }

    @Override
    public Map getReqHead() {
        return this.reqHead;
    }

    @Override
    public void setReqHead(Map reqHead) {
        this.reqHead = reqHead;
    }

    @Override
    public IRequstBuilder getRequstBuilder() {
        return this.requstBuilder;
    }

    @Override
    public IResponseParser getResponseParser() {
        return this.responseParser;
    }

    @Override
    public INetConfParser getNetConfParser() {
        return this.confParser;
    }
    @Override
    public void setReport(IRequstBuilder requstBuilder, IResponseParser parser, INetConfParser confParser){
        this.requstBuilder = requstBuilder;
        this.responseParser = parser;
        this.confParser = confParser;
    }

    @Override
    public com.learnyeai.learnai.support.IBusinessContext copy() {
        BusinessContext o = new BusinessContext();
        copy(o);
        return o;
    }
}
