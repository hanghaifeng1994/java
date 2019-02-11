package com.learnyeai.rabbitmq.util;
/**
 * <p><b>Description:</b> 常量类 <p>
 * <b>Company:</b>
 */
public class MQConstants {

	// ------------------发送重试--------------------
	// ##发送重试等待策略 exponentialWait 指数倍增长
	/**发送端重新发送重试乘数(ms)*/
	public static final int MUTIPLIER_TIME = 500;
	/** 发送端重新发送，最大重试时时间（s）*/
	public static final int MAX_RETRY_TIME = 10;
	public static final int MAX_RETRY_COUNT = 7; // 尝试次数，尝试最多次数后，不再尝试
	public static final int MAX_RETURN_COUNT = 10;

	// 发送时间超过时间限制不发送
	public static final int MAX_OVERRUN_HOUR = 24;


	// 消费者队列
	public static String CONSUMER_FINISH_QUEUE_KEY = "finish_queue";

	/** 消费端最大重试次数 */
	public static final int MAX_CONSUMER_COUNT = 5; 
	/** 递增时的基本常量 */
	public static final int BASE_NUM = 2;
	/** 空的字符串 */
	public static final String BLANK_STR = "";
	
	

}
