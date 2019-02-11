/**
 * 
 */
package com.learnyeai.core.flow;

import com.learnyeai.core.IBusinessContext;

/**
 * @ClassName: IFlowService
 * @Description: 执行flow
 * @author: mingyi.li（mylee0523@gmail.com）
 * @date: 2015年4月2日 下午9:37:28
 */
public interface IFlowService {
    
    public int executeFlow(IBusinessContext ctx, IAresSerivce flow);

}
