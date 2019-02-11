package com.learnyeai.core.flow;

import java.util.HashMap;
import java.util.Map;

import com.learnyeai.core.IBusinessContext;

public class AresFlowData {

	/**
	 * 简单的赋值及转译代码
	 */
	private Map<String, String> datas = new HashMap();

	/**
	 * 执行简单的赋值及转译
	 * 
	 * @param ctx
	 */
	public void evalPrevDatas(IBusinessContext ctx) {
		if (null == datas)
			return;
		for (String key : datas.keySet()) {
			String value = datas.get(key);
			if (!value.contains("@")) {
				// 常量设置
				ctx.setParam(key, value);
			} else if (value.startsWith("@param:")) {
				String name = value.substring("@param:".length());
				value = ctx.getParam(name);
				ctx.setParam(key, value);
			} else if (value.startsWith("@sess:")) {
				String name = value.substring("@sess:".length());
				value = ctx.getSessionObject(name);
				ctx.setParam(key, value);
			}
		}
	}

	public Map getDatas() {
		return datas;
	}

	public void setDatas(Map datas) {
		this.datas = datas;
	}

}
