package com.learnyeai.common.engine;

import com.learnyeai.learnai.support.IBusinessContext;

/**
 * Created by zpz on 2018/8/4.
 */
public interface ILearnAiThreadStart {
    void initUserSession(IBusinessContext ctx);
    void initThreadContex(IBusinessContext ctx);
}
