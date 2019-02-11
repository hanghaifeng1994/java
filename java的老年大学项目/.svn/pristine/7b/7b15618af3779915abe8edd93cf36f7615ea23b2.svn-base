package com.learnyeai.learnai.net.netConf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.learnyeai.learnai.net.INetConfCaches;

/**
 * 交易处理类的读取类
 * 
 * @author yym
 * 
 */
@Component
public class EBankConfCaches implements INetConfCaches {
	private Map<String, MBTransConfBean> ebankConfList = new HashMap();

	public EBankConfCaches() {
	}

	
	public synchronized void addTransConf(String transCode,
			MBTransConfBean trans) {
		ebankConfList.put(transCode, trans);
	}

	
	public MBTransConfBean getTransConfById(String transCode) {
		return ebankConfList.get(transCode);
	}

	
	public boolean hasTransConfById(String transCode) {
		return ebankConfList.containsKey(transCode);
	}
}