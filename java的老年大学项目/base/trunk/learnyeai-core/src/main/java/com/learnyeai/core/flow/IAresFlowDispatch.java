package com.learnyeai.core.flow;

import java.util.List;
import java.util.Map;

public interface IAresFlowDispatch extends IAresSerivce {

	/**
	 * 流转节点
	 * 
	 * @return
	 */
	public abstract List<AresServiceStep> getSteps();

	/**
	 * 设置流程节点
	 * 
	 * @param steps
	 */
	public abstract void setSteps(List<AresServiceStep> steps);

	/**
	 * 设置流程预置代码
	 * 
	 * @param defData
	 */
	public abstract void setDatas(Map defData);

}