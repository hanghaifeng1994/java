package com.learnyeai.learnai.utils.smg;

/**
 * 即时通信工厂类
 * Created by sunlei on 2016/6/17 0017.
 */
public class SmsFactory {
    public static SmsFactory getFactory(){return new SmsFactory();}
    /**
     * 实例化即时通信接口
     * @return
     */

    public ISmsService getImp(){return new SmsSerivceImp();}
}
