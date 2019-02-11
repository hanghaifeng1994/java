package com.learnyeai.tools.observe;

import java.util.Observer;

/**
 * 可中断的观察者，如果此观察者抛出异常，则剩下的观察者们将不被通知
 * @see GenericObservable 需要配合一起使用才有效果
 * @author lc3@yitong.com.cn
 */
public interface InterruptObserver extends Observer {
}
