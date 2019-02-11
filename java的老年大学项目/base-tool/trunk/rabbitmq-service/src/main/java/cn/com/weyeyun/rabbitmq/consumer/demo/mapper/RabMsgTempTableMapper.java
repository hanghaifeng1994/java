package cn.com.weyeyun.rabbitmq.consumer.demo.mapper;

import cn.com.weyeyun.rabbitmq.consumer.demo.model.RabMsgTempTable;
import cn.com.weyeyun.servicebase.support.BaseMapper;
import cn.com.weyeyun.servicebase.support.MyBatisDao;
/**
 * @Description: 
 * @author yl
 */
@MyBatisDao
public interface RabMsgTempTableMapper extends BaseMapper<RabMsgTempTable> {
    int deleteAll();

    int insertToRabMsg();
}
