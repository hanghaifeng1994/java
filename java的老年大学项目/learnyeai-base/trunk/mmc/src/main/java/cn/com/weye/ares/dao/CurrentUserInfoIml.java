package cn.com.weye.ares.dao;

import cn.com.weye.core.dao.CurrentUserInfoDao;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;

/**
 * Created by zpz on 2017/12/1.
 */
@Service
public class CurrentUserInfoIml implements CurrentUserInfoDao {
    @Override
    public String getId() {
        return UserUtils.getUser().getId();
    }

    @Override
    public String getLoginName() {
        return UserUtils.getUser().getLoginName();
    }

    @Override
    public String getPhone() {
        return UserUtils.getUser().getPhone();
    }

    @Override
    public String getCustName() {
        return UserUtils.getUser().getName();
    }

    @Override
    public String getCustType() {
        return UserUtils.getUser().getUserType();
    }

    @Override
    public String getSex() {
        return null;
    }
}
