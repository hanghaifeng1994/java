package cn.com.weyeyun.rabbitmq.service;

import cn.com.weyeyun.rabbitmq.bean.RabbitMetaMessage;
import cn.com.weyeyun.rabbitmq.model.RabMsgTable;
import cn.com.weyeyun.rabbitmq.mapper.RabMsgTableMapper;
import cn.com.weyeyun.rabbitmq.sender.RabbitSender;
import cn.com.weyeyun.servicebase.support.BaseMapper;
import cn.com.weyeyun.servicebase.support.BaseService;
import cn.com.weyeyun.tools.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import javax.annotation.Resource;
import java.util.Map;

/**
 *
 * @author yl
 */
@Service
public class RabMsgTableWyService extends BaseService<RabMsgTable> {

    @Resource
    private RabMsgTableMapper rabMsgTableMapper;

    @Resource
    private RabMsgTempTableWyService rabMsgTempTableWyService;
    @Autowired
    RabbitSender rabbitSender;

    @Override
    public BaseMapper<RabMsgTable> getMapper() {
        return rabMsgTableMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Override
    protected Weekend genSqlExample(RabMsgTable t, Map params) {
        Weekend w=super.genSqlExample(t);
        WeekendCriteria<RabMsgTable,Object> c= w.weekendCriteria();
        if(StringUtils.isNotBlank(t.getServerName())){
            c.andEqualTo(RabMsgTable::getServerName,t.getServerName());
        }
        if(t.getFailTimes()!=null){
            c.andEqualTo(RabMsgTable::getFailTimes,t.getFailTimes());
        }
        if(t.getMsgStatus()!=null){
            c.andEqualTo(RabMsgTable::getMsgStatus,t.getMsgStatus());
        }
        w.and(c);
        return  w;
    }

    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 重新发送
     * @param rabMsgTable
     * @return
     */
    public void reSend(RabMsgTable rabMsgTable){
        RabMsgTable msg= super.queryById(rabMsgTable.getMsgId());
        Object o =redisTemplate.opsForHash().get(msg.getServerName(),msg.getMsgId());
        RabbitMetaMessage sendMsg=(RabbitMetaMessage) o;
        sendMsg.setMsgStatus(3);
        redisTemplate.opsForHash().put(msg.getServerName(),msg.getMsgId(),sendMsg);
    }
    @Transactional
    public int deleteData(String id){
        RabMsgTable rabMsgTable=super.queryById(id);
        try {
            rabMsgTempTableWyService.deleteById(id);
            redisTemplate.opsForHash().delete(rabMsgTable.getServerName(), rabMsgTable.getMsgId());
            return   super.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }

        return 0;
    }
}
