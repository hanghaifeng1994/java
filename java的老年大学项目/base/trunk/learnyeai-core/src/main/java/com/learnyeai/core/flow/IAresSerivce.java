package com.learnyeai.core.flow;

import com.learnyeai.core.IBusinessContext;

/**
 * 可编排原子服务
 * 
 * @author yaoym
 * 
 */
public interface IAresSerivce {
	public static int NEXT = 1;
	public static int EXIT = 0;

	public int execute(IBusinessContext ctx);
}
