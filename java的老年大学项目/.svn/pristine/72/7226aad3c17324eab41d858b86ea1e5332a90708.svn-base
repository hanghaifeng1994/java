package com.learnyeai.resource.service;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.learnyeai.rabbitmq.util.WeyeRabbitException;

@Component
public class QuartzLearnResourceService {
	@Resource
	private StdCustLearnRecordWyService stdCustLearnRecordWyService;

	@Scheduled(cron = "0 0/1 * * * ?")
	public void timerToNow() {
		try {
			stdCustLearnRecordWyService.synRedisToDb();
		} catch (WeyeRabbitException e) {
			e.printStackTrace();
		}
	}
}
