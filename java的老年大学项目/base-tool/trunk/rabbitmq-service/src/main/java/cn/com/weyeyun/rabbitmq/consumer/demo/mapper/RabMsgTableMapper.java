package cn.com.weyeyun.rabbitmq.consumer.demo.mapper;

import cn.com.weyeyun.rabbitmq.consumer.demo.model.RabMsgTable;
import cn.com.weyeyun.servicebase.support.BaseMapper;
import cn.com.weyeyun.servicebase.support.MyBatisDao;
/**
 * @Description: 
 * @author yl
 */
@MyBatisDao
public interface RabMsgTableMapper extends BaseMapper<RabMsgTable> {
}
