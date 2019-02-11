package com.learnyeai.activity.service;

import com.learnyeai.activity.model.ActActivityWorks;
import com.learnyeai.activity.mapper.ActActivityWorksMapper;
import com.learnyeai.common.support.WeyeBaseService;
import com.learnyeai.learnai.support.BaseMapper;
import com.learnyeai.learnai.support.IBusinessContext;
import com.learnyeai.learnai.support.iml.CurrentUserInfoIml;
import com.learnyeai.mq.AuditlogMq;
import com.learnyeai.mq.ParseRabbitMsg;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import com.learnyeai.rabbitmq.util.WeyeRabbitException;
import com.learnyeai.tools.common.BeanMapUtils;
import com.learnyeai.tools.common.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.learnyeai.tools.common.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;
import com.learnyeai.activity.mapper.ActMarkingMapper;

import javax.annotation.Resource;


import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author yl
 */
@Service
public class ActActivityWorksWyService extends WeyeBaseService<ActActivityWorks> {

    @Resource
    private ActActivityWorksMapper actActivityWorksMapper;
    @Autowired
    private RabbitSender rabbitSender;
    @Resource
    private  CurrentUserInfoIml currentUserInfoIml;
    @Override
    public BaseMapper<ActActivityWorks> getMapper() {
        return actActivityWorksMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return true;
    }
    @Resource
    private ActMarkingMapper actMarkingMapper;


@Override
protected Weekend genSqlExample(ActActivityWorks a,Map params){
    Weekend<ActActivityWorks> weekend = super.genSqlExample(a,params);
    WeekendCriteria<ActActivityWorks,Object> c = weekend.weekendCriteria();
    if(StringUtils.isNotBlank(a.getWksStatus())){
        c.andEqualTo(ActActivityWorks::getWksStatus,a.getWksStatus());
    }

    if(StringUtils.isNotBlank(a.getActId())){
        c.andEqualTo(ActActivityWorks::getActId,a.getActId());
    }
    if(StringUtils.isNotBlank(a.getWksId())){
        c.andEqualTo(ActActivityWorks::getWksId,a.getWksId());
    }
    if(StringUtils.isNotBlank(a.getWksUserId())){
        c.andEqualTo(ActActivityWorks::getWksUserId,a.getWksUserId());
    }
    weekend.and(c);
    return weekend;
}


    @Transactional
    public Map<String,Object> deleteall(ActActivityWorks wks){
        String[] wksIds = (wks.getWksId()).split(",");
        int num = 0;
        for (String id:wksIds){
            num += super.deleteById(id);
        }
        logger.info("批量删除了"+num+"条数据");
        return MapUtil.newMap("num",num);
    }

    @Transactional
    public Map<String,Object> saveData(ActActivityWorks wks){
        Map<String,Object> map = new HashMap<>();
        String userId=currentUserInfoIml.getId();
        wks.setWksUserId(userId);
        String userName=currentUserInfoIml.getLoginName();
        wks.setWksUserName(userName);
        wks.setWksUploadDate(new Date());
        if(StringUtils.isNotBlank(wks.getWksId())){
            ActActivityWorks works = super.queryById(wks.getWksId());
            String status = works.getWksStatus();
            if("1".equals(status)||"2".equals(status)){
                map.put("status",1);
                return map;
            }
        }else{
            wks.setWksStatus("0");
        }
        //查询最大的code
        String  code=actActivityWorksMapper.getMaxCode(wks);
        if("".equals(code)){
            code="000";
        }
        code= increatCode(code);
        wks.setWksCode(code);
        super.save(wks);
        map.put("status",0);
        map.put("id",wks.getWksId());
        return map;
    }


    @Transactional
    public Map<String,Object> sumbitAudit(ActActivityWorks wks){
        String[] wksIds = (wks.getWksId()).split(",");
        ActActivityWorks actActivityWorks = new ActActivityWorks();
        String userId = currentUserInfoIml.getId();
        String userName = currentUserInfoIml.getLoginName();
        int num = 0;
        for (String wksId:wksIds){
            actActivityWorks.setWksUserId(userId);
            actActivityWorks.setWksUserName(userName);
            actActivityWorks.setWksId(wksId);
            actActivityWorks.setWksStatus(wks.getWksStatus());
            num += super.save(actActivityWorks);
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 活动作品审核
     * @param ctx
     * @return
     */
    @Transactional
    public Map<String,Object> audit(IBusinessContext ctx) throws WeyeRabbitException {
        ActActivityWorks wks=new ActActivityWorks();
        AuditlogMq auditlogMq= toParseAuditLog(ctx);
        String[] wksIds=(auditlogMq.getObjId()).split(",");
        int num =0;
        wks.setWksStatus(auditlogMq.getStatus());
        for(String wksId:wksIds){
            wks.setWksId(wksId);
            //活动表中保存
            num+=  super.save(wks);
            auditlogMq.setObjId(wksId);
            RabbitMetaMessage msg=ParseRabbitMsg.toParseRabbitMetaMessage(auditlogMq);
            rabbitSender.send(msg);
        }
        return MapUtil.newMap("num",num);
    }

    /**
     * 将入参转为审核日志对象
     */
    public AuditlogMq toParseAuditLog(IBusinessContext ctx){
        try {
            AuditlogMq a= (AuditlogMq)BeanMapUtils.convertMap(AuditlogMq.class, ctx.getParamMap());
            return a;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public String increatCode(String code){
       Integer n = Integer.parseInt(code);
        n++;
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumIntegerDigits(3);
        numberFormat.setGroupingUsed(false);
            String s = numberFormat.format(n);
            return s;
    }

}
