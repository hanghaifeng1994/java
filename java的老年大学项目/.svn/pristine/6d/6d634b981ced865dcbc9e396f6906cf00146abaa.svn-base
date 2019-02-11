package com.learnyeai.core.flow;

import java.util.HashMap;
import java.util.Map;

import com.learnyeai.core.IBusinessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 流程服务节点
 * 
 * @author yaoym
 * 
 */
public class AresServiceStep extends AresFlowData {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public int run(IBusinessContext ctx) {
		if (aresService == null)
			return IAresSerivce.EXIT;
		logger.debug("step {}", index);
		// 执行简单的赋值及转译
		evalPrevDatas(ctx);
		// 执行服务
		int indexKey = aresService.execute(ctx);
		// 设置默认的跳转：EXIT
		if (indexKey <= IAresSerivce.EXIT) {
			return IAresSerivce.EXIT;
		}
		Integer nextStep = mapping.get(indexKey);
		return nextStep == null ? (index + 1) : nextStep;
	}

	/**
	 * 分支与流程节点的映射
	 */
	private Map<Integer, Integer> mapping = new HashMap();
	private IAresSerivce aresService;
	private int index;

	public IAresSerivce getAresService() {
		return aresService;
	}

	public void setAresService(IAresSerivce aresService) {
		this.aresService = aresService;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Map<Integer, Integer> getMapping() {
		return mapping;
	}

	public void setMapping(Map<Integer, Integer> mapping) {
		this.mapping = mapping;
	}

}