package com.learnyeai.learnai.support;

import com.learnyeai.learnai.net.INetConfParser;
import com.learnyeai.learnai.net.IResponseParser;
import com.learnyeai.learnai.net.IRequstBuilder;

import java.util.Map;

/**
 * 数据总线接口，采用JSON-MAP为数据结构，<br>
 * 共两个数据区：基础数据区（可以在请求中直接赋值），会话数据区（只能在代码中赋值）
 * 
 * @author yaoym
 * 
 */
public interface IBusinessContext extends com.learnyeai.core.IBusinessContext {

    //    请求报文头
    public Map getReqHead();

    public void setReqHead(Map reqHead);

    // ---------设置报文解析相关
    public void setReport(IRequstBuilder requstBuilder, IResponseParser parser, INetConfParser confParser);
    IRequstBuilder getRequstBuilder();
    IResponseParser getResponseParser();
    INetConfParser getNetConfParser();

    IBusinessContext copy();
}
