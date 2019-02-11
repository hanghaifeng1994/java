package cn.com.weyeyun.rabbitmq.consumer.demo.service;

import cn.com.weyeyun.rabbitmq.bean.RabbitMetaMessage;
import cn.com.weyeyun.rabbitmq.consumer.demo.model.RabMsgTable;
import cn.com.weyeyun.rabbitmq.consumer.demo.model.RabMsgTempTable;
import cn.com.weyeyun.rabbitmq.consumer.demo.mapper.RabMsgTempTableMapper;
import cn.com.weyeyun.servicebase.support.BaseMapper;
import cn.com.weyeyun.servicebase.support.BaseService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author yl
 */
@Service
public class RabMsgTempTableWyService extends BaseService<RabMsgTempTable> {

    @Resource
    private RabMsgTempTableMapper rabMsgTempTableMapper;
    @Resource
    private RabMsgTableWyService rabMsgTableWyService;


    @Override
    public BaseMapper<RabMsgTempTable> getMapper() {
        return rabMsgTempTableMapper;
    }
    @Override
    protected boolean isLogicDelete(){
        return false;
    }
    @Autowired
    @Qualifier(value = "redisTemplateMq")
    private RedisTemplate<String, Object> redisTemplate;

    private CountDownLatch endCount;
    @Transactional
    public void saveMessage(Set<String> serverkeys){
        ArrayList<Object> listKey = new ArrayList();
        //先删除临时表中所有数据
        try{
        int deleteNum= rabMsgTempTableMapper.delete(new RabMsgTempTable());
//        共删除临时表中、
        logger.info("共删除临时表中"+deleteNum+"条数据并且开始向数据库中插入消息数据");
        for (Iterator<String> it = serverkeys.iterator(); it.hasNext(); ) {
            String redisKey = it.next();
            Set<Object> keys = redisTemplate.opsForHash().keys(redisKey);
            endCount = new CountDownLatch(keys.size());
            try {
                for (Iterator<Object> itkey = keys.iterator(); itkey.hasNext(); ) {
                Object key =  itkey.next();
                if (listKey.size() <= 30)
                    continue;
                    listKey.add(key);
                    List<Object> listMsg = redisTemplate.opsForHash().multiGet(redisKey, listKey);
                    listKey.clear();
                    //保存操作
                    saveDataToTemp(  listMsg,redisKey);
            }
            // 处理最后记录
                for (Iterator<Object> itkey = keys.iterator(); itkey.hasNext(); ) {
                    listKey.add(itkey.next());
//                 Object o=   redisTemplate.opsForHash().get(redisKey,itkey.next());
//                    logger.info(o.toString());
                }
                List<Object> listMsg = redisTemplate.opsForHash().multiGet(redisKey,listKey);
                //保存到临时表中
                saveDataToTemp(  listMsg,redisKey);
            }catch (Exception e){
                for (int i=0; i< listKey.size(); i++){
                    endCount.countDown();
                }
                listKey.clear();
                logger.error("获取缓存数据失败", e);
            }
        }
        //先将表中的数据全部删除
        rabMsgTableWyService.delete(new RabMsgTable());
        //取出临时表中所有数据并且将所有数据插入到主表中
        int num= rabMsgTempTableMapper.insertToRabMsg();
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    //将数据保存到临时表中
    public void saveDataToTemp(List<Object> list,String redisKey){
        RabMsgTempTable ra=new RabMsgTempTable();
        for(Object o:list){
            RabbitMetaMessage msg=(RabbitMetaMessage) o;
            ra= parseToRab(msg,ra,redisKey);
            rabMsgTempTableMapper.insertSelective(ra);
        }
    }

    //将消息转为临时表数据
    public RabMsgTempTable parseToRab(RabbitMetaMessage msg, RabMsgTempTable ra, String redisKey){
        String payload= JSON.toJSONString(msg.getPayload());
        String dealResult=JSON.toJSONString(msg.getDealResult());
        ra.setPayload(payload);
        ra.setDealResult(dealResult);
        ra.setMsgId(msg.getMsgId());
        ra.setServerName(redisKey);
        ra.setExchange(msg.getExchange());
        ra.setRoutingKey(msg.getRoutingKey());
        ra.setMsgStatus(msg.getMsgStatus());
        ra.setFailTimes(msg.getFailTimes());
        ra.setReturnDate(msg.getReturnDate());
        ra.setDealDate(msg.getDealDate());
        ra.setCreateDate(msg.getCreateDate());
        ra.setLastSendDate(msg.getLastSendDate());
        ra.setLastDealMsgDate(msg.getLastDealMsgDate());
        return  ra;
    }
}
