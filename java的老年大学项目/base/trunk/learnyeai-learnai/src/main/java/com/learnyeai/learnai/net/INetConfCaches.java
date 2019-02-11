package com.learnyeai.learnai.net;

import com.learnyeai.learnai.net.netConf.MBTransConfBean;

/**
 * 报文定义缓存
 * 
 * @author yaoym
 * 
 */
public interface INetConfCaches {

	public abstract void addTransConf(String transCode, MBTransConfBean trans);

	public abstract MBTransConfBean getTransConfById(String transCode);

	public abstract boolean hasTransConfById(String transCode);

}