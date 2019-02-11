package com.learnyeai.audit.service;

import com.learnyeai.audit.mapper.AdtReportUpMapper;
import com.learnyeai.audit.model.AdtReportUp;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.context.ThreadContextUtil;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class AdtReportUpWyService extends WeyeBaseService<AdtReportUp> {

    @Resource
    private AdtReportUpMapper adtReportUpMapper;

    @Autowired
    RabbitSender rabbitSender;
    @Autowired
    private CurrentUserInfoIml currentUserInfoIml;

    @Override
    public BaseMapper<AdtReportUp> getMapper() {
        return adtReportUpMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(AdtReportUp t, Map params) {
        Weekend w=super.genSqlExample(t,params);
        WeekendCriteria<AdtReportUp,Object> c=w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getPtId())){
            c.andEqualTo(AdtReportUp::getPtId,t.getPtId());
        }
        if(StringUtils.isNotBlank(t.getReportSiteId())){
            c.andEqualTo(AdtReportUp::getReportSiteId,t.getReportSiteId());
        }
        w.and(c);
        w.setOrderByClause("AUDIT_DATE desc");
        return w;
    }
  /*  public void audit(AdtReportUp adtReportUp) throws WeyeRabbitException {
        String userName=currentUserInfoIml.getLoginName();
        String userId=currentUserInfoIml.getId();
        adtReportUp.setAuditDate(new Date());
        adtReportUp.setAuditUserId(userId);
        adtReportUp.setAuditUserName(userName);
        super.save(adtReportUp);
        NewsUpAuditMq na=new NewsUpAuditMq();
        na.setObjId(adtReportUp.getObjId());
        na.setAuditStatus(adtReportUp.getAuditStatus());
        na.setReportSiteId(adtReportUp.getReportSiteId());
        //更新后发送消息
//        RabbitMetaMessage ra= NewsUpAuditMessageVo.parseMsg(na);
        rabbitSender.send(ra);
    }*/
}
