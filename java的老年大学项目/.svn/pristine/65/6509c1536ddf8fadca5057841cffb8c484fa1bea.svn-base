package com.learnyeai.base.action.cust;

import com.learnyeai.base.api.util.BaseCons;
import com.learnyeai.base.model.CustInfo;
import com.learnyeai.base.service.CustInfoWyService;
import com.learnyeai.base.utils.DtHelps;
import com.learnyeai.core.IBusinessContext;
import com.learnyeai.core.flow.IAresSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册用户添加
 * Created by zpz on 2018/8/23.
 */
@Service
public class UserAddOp implements IAresSerivce {
    @Autowired
    private CustInfoWyService custInfoWyService;
    @Override
    public int execute(IBusinessContext ctx) {
        CustInfo t = custInfoWyService.convert2Bean(ctx.getParamMap());
        t.setCustId(null);
        // 添加客户类型
        t.setCustType(BaseCons.CUST_INFO_TYPE.KH.getVal());
        t.setUserStatus(BaseCons.CUST_INFO_STATUS.N.getVal());
        // 加密
        String pass = t.getPassword();
        if(null != pass){
            pass = DtHelps.entryptPassword(pass);
        }
        t.setPassword(pass);

        // 用户名为空时，默认为登录名
        if(t.getCustName() == null){
            t.setCustName(t.getLoginName());
        }

        custInfoWyService.save(t);
        return NEXT;
    }
}
