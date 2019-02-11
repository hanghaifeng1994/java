package com.learnyeai.provider.demo;

import com.learnyeai.rabbitmq.bean.MqVo;
import com.learnyeai.rabbitmq.bean.RabbitMetaMessage;
import com.learnyeai.rabbitmq.consumer.demo.mq.DemoConstans;
import com.learnyeai.rabbitmq.consumer.demo.mq.DemoMq;
import com.learnyeai.rabbitmq.sender.RabbitSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageProviderController {
 
  /** test if can get value from config center **/
//  @Value("${spring.rabbitmq.host}")
//  private String rabbitmqAddress;
  
  @Autowired
  RabbitSender rabbitSender;
  
//  @Autowired
//  private RabbitSender rabbitSender;
  
  Logger logger = LoggerFactory.getLogger(getClass());
  
  
  /*@GetMapping("testconfig")
  public String testconfig() throws Exception {
	  return rabbitmqAddress;
  }*/
  
  @GetMapping("testmq")
  @Transactional
  public String testMessage() throws Exception {
      /** 生成一个发送对象 */
		RabbitMetaMessage rabbitMetaMessage = new RabbitMetaMessage();
		/**设置交换机 */
		rabbitMetaMessage.setExchange(DemoConstans.DEMO_EXCHANGE);
		/**指定routing key */
		rabbitMetaMessage.setRoutingKey(DemoConstans.DEMO_KEY);
		/** 设置需要传递的消息体,可以是任意对象 */
        MqVo vo = new DemoMq();
      rabbitMetaMessage.setPayload(vo);
		/** 发送消息 */
		rabbitSender.send(rabbitMetaMessage);
		return "sucess";
  }
  
}
