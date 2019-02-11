package com.learnyeai.base.web.login;

import com.learnyeai.core.utils.CtxCommonUtils;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.session.Session;
import com.learnyeai.learnai.support.CurrentUserInfoDao;
import com.learnyeai.learnai.support.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zpz on 2017/11/23.
 */
@Service
public class UuidLoginController implements IController {
    @Autowired
    private CurrentUserInfoDao currentUserInfoDao;
    @Override
    public Object execute(IBusinessContext ctx) {
        Session session = ThreadContextUtil.getSession(false);
        ctx.setParam(CtxCommonUtils.SESSION_TOKEN,ThreadContextUtil.getToken() );
        Map userInfo = currentUserInfoDao.getUserInfo();
        Map pp = ctx.getParamMap();
        pp.putAll(userInfo);
        return pp;
    }
}
