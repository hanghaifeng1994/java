package com.learnyeai.core.flow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learnyeai.core.IBusinessContext;

/**
 * 服务编排组件
 * 
 * @author yaoym
 * 
 */
public class AresFlowDispatch extends AresFlowData implements IAresFlowDispatch {

	private List<AresServiceStep> steps = new ArrayList();// 流程节点
	private Map<Integer, AresServiceStep> mapping;// 节点序列
	private String defineName;
	private IAresFlowDefine flowDefine;

	public AresFlowDispatch() {
	}

	/**
	 * 初始化定义
	 */
	public void init() {
		// 加载定义
		flowDefine.parserDefine(defineName, this);
		this.mapping = new HashMap();
		int stepIndex = 1;
		for (AresServiceStep step : steps) {
			mapping.put(stepIndex++, step);
		}
	}

	public int execute(IBusinessContext ctx) {
		// 执行预定义代码
		evalPrevDatas(ctx);
		// 执行服务
		auto(ctx, 1, mapping);
		return NEXT;
	}

	/**
	 * 内部流转
	 * 
	 * @param ctx
	 * @param stepIndex
	 * @param mapping
	 * @return
	 */
	private int auto(IBusinessContext ctx, int stepIndex,
                     Map<Integer, AresServiceStep> mapping) {
		if (stepIndex <= EXIT)
			return EXIT;
		AresServiceStep step = mapping.get(stepIndex);
		if (step == null)
			return EXIT;
		stepIndex = step.run(ctx);
		return auto(ctx, stepIndex, mapping);
	}

	public List<AresServiceStep> getSteps() {
		return steps;
	}

	public void setSteps(List<AresServiceStep> steps) {
		this.steps = steps;
	}

	public String getDefineName() {
		return defineName;
	}

	public void setDefineName(String defineName) {
		this.defineName = defineName;
	}

	public IAresFlowDefine getFlowDefine() {
		return flowDefine;
	}

	public void setFlowDefine(IAresFlowDefine flowDefine) {
		this.flowDefine = flowDefine;
	}

}