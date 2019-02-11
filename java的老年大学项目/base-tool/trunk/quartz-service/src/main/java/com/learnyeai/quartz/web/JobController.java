package com.learnyeai.quartz.web;

import java.util.HashMap;
import java.util.Map;

import com.learnyeai.learnai.support.IBusinessContext;
//import com.learnyeai.servicebase.support.ApiBaseController;
//import com.learnyeai.servicebase.support.IController;
import com.learnyeai.learnai.support.IController;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnyeai.quartz.model.JobAndTrigger;
import com.learnyeai.quartz.job.BaseJob;
import com.learnyeai.quartz.service.IJobAndTriggerService;
import com.github.pagehelper.PageInfo;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;


@RestController
@RequestMapping(value="/job")
public class JobController implements IController
{
/*	@Override
	public String getBaseUrl() {
		return "/job";
	}*/

	@Autowired
	private IJobAndTriggerService iJobAndTriggerService;
	
	//加入Qulifier注解，通过名称注入bean
	@Autowired
	private Scheduler scheduler;
	
	private static Logger log = LoggerFactory.getLogger(JobController.class);  
	

	@PostMapping(value="/addjob")
	public String addjob(@RequestParam(value="jobClassName")String jobClassName,
			@RequestParam(value="jobGroupName")String jobGroupName, 
			@RequestParam(value="cronExpression")String cronExpression) throws Exception
	{			
		addJob(jobClassName, jobGroupName, cronExpression);
		return "1";
	}
	
	public void addJob(String jobClassName, String jobGroupName, String cronExpression)throws Exception{
        
        // 启动调度器  
//		scheduler.start();
		
		//构建job信息
		JobDetail jobDetail = JobBuilder
				.newJob(getClass(jobClassName).getClass())
				.withIdentity(jobClassName, jobGroupName)
				.build();
		//表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
		/* SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(1)
				.withRepeatCount(3)
				.repeatForever();*/
		//按新的cronExpression表达式构建一个新的trigger
		CronTrigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(jobClassName, jobGroupName)
				.withSchedule(scheduleBuilder)

				.build();
        
        try {
        	scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
        	e.printStackTrace();
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
	}


	@PostMapping(value="/pausejob")
	public String pausejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception
	{			
		jobPause(jobClassName, jobGroupName);
		return "1";
	}
	
	public void jobPause(String jobClassName, String jobGroupName) throws Exception
	{	
		scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
	}
	

	@PostMapping(value="/resumejob")
	public String resumejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception
	{			
		jobresume(jobClassName, jobGroupName);
		return "1";
	}
	
	public void jobresume(String jobClassName, String jobGroupName) throws Exception
	{
		scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
	}
	
	
	@PostMapping(value="/reschedulejob")
	public String rescheduleJob(@RequestParam(value="jobClassName")String jobClassName,
			@RequestParam(value="jobGroupName")String jobGroupName,
			@RequestParam(value="cronExpression")String cronExpression) throws Exception
	{			
		jobreschedule(jobClassName, jobGroupName, cronExpression);
		return "1";
	}
	
	public void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception
	{				
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		} catch (SchedulerException e) {
			System.out.println("更新定时任务失败"+e);
			throw new Exception("更新定时任务失败");
		}
	}
	
	
	@PostMapping(value="/deletejob")
	public String deletejob(@RequestParam(value="jobClassName")String jobClassName, @RequestParam(value="jobGroupName")String jobGroupName) throws Exception
	{			
		jobdelete(jobClassName, jobGroupName);
		return "1";
	}
	
	public void jobdelete(String jobClassName, String jobGroupName) throws Exception
	{		
		scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
		scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));				
	}
	
	
	@GetMapping(value="/queryjob")
	public Map<String, Object> queryjob(@RequestParam(value="pageNum")Integer pageNum, @RequestParam(value="pageSize")Integer pageSize) 
	{			
		PageInfo<JobAndTrigger> jobAndTrigger = iJobAndTriggerService.getJobAndTriggerDetails(pageNum, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("JobAndTrigger", jobAndTrigger);
		map.put("number", jobAndTrigger.getTotal());
		return map;
	}
	
	public static BaseJob getClass(String classname) throws Exception 
	{
		Class<?> class1 = Class.forName(classname);
		return (BaseJob)class1.newInstance();
	}


	@Override
	public Object execute(IBusinessContext ctx) {
		return null;
	}
}
