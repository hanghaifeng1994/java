package com.learnyeai.learnai.support;

import com.learnyeai.core.utils.SpringContextUtils;
import com.learnyeai.learnai.consts.SessR;
import com.learnyeai.learnai.context.ThreadContextUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zpz on 2016/4/28.
 */
public class CurrentUserHelp{
    private static CurrentUserInfoDao currentUserInfoDao;
    private static CurrentUserInfoDao getCurrentUserInfoDao(){
        if(null == currentUserInfoDao) {
            currentUserInfoDao = SpringContextUtils.getBean(CurrentUserInfoDao.class);
        }
        return currentUserInfoDao;
    }
    public static String getId() {
        return getCurrentUserInfoDao().getId();
    }

    public static String getLoginName() {
        return getCurrentUserInfoDao().getLoginName();
    }

    public static String getPhone() {
        return getCurrentUserInfoDao().getPhone();
    }

    public static String getCustName() {
        return getCurrentUserInfoDao().getCustName();
    }

    public static String getCustType() {
        return getCurrentUserInfoDao().getCustType();
    }

    public static String getSex() {
        return getCurrentUserInfoDao().getSex();
    }

    public static Map getUserInfo() {
        return getCurrentUserInfoDao().getUserInfo();
    }
}
