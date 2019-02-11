package com.learnyeai.learnai.support;

import java.util.Map;

/**
 * 当前操作用户信息访问接口，MybatisBaseService会自动调用此接口获取当前操作人，从而自动记录当前更新人和创建人
 * @author lc3@yitong.com.cn
 */
public interface CurrentUserInfoDao {

    /**
     * 获得当前用户ID
     * @return 当前用户标识
     */
    String getId();

    /**
     * 获得当前用户登录名称
     * @return 当前用户名称
     */
    String getLoginName();

    /**
     * 获取当前登录用户手机号
     */
    String getPhone();

    /**
     *获取用户姓名
     */
    String getCustName();

    /**
     * 获取用户类型
     * @return
     */
    String getCustType();

    /**
     * 用户性别
     * @return
     */
    String getSex();

    Map getUserInfo();
}
