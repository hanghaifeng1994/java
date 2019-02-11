/**
 * Created by zpz on 2018/6/23.
 */
package com.learnyeai.quartz;
/*
创建job方式
    1 继承job 或 QuartzJobBean
        public class HelloJob implements BaseJob {
    2 spring.xml中配置DetailQuartzJobBean，或new

jobdetail生成方式
    JobDetail jobDetail = JobBuilder
				.newJob(getClass(jobClassName).getClass())
				.withIdentity(jobClassName, jobGroupName)
				.build();

trigger两种方式
	CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
		 SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(1)
				.withRepeatCount(3)
				.repeatForever();
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
 */
/*
spring 配置
<bean id="testJobDetail" class="org.springframework.scheduling.quartz.JobDetailFactoryBean">
        <!-- durability 表示任务完成之后是否依然保留到数据库，默认false -->
        <property name="durability" value="true" />
        <property name="requestsRecovery" value="true" />
        <property name="jobClass">
            <value>
                com.learnyeai.quartz.DetailQuartzJobBean
            </value>
        </property>
        <property name="jobDataAsMap">
            <map>
                <entry key="targetObject" value="testScheduleTask" />
                <entry key="targetMethod" value="sayHello" />
                <!-- 是否允许任务并发执行。当值为false时，表示必须等到前一个线程处理完毕后才再启一个新的线程 -->
                <!--
                可以在job类上注解实现，并发，jobdata持久化
                @PersistJobDataAfterExecution
                @DisallowConcurrentExecution
                -->
                <entry key="concurrent" value="false" />
            </map>
        </property>
    </bean>

    <bean id="testJobTrigger"
          class="org.springframework.scheduling.quartz.CronTriggerFactoryBean">
        <property name="jobDetail">
            <ref bean="testJobDetail" />
        </property>
        <property name="cronExpression">
            <value>0/10 * * * * ?</value><!--每10秒钟执行一次 -->
        </property>
    </bean>
 */


/*
在class根目录中添加 quartz.properties

# 固定前缀org.quartz
# 主要分为scheduler、threadPool、jobStore、plugin等部分


#==============================================================
#Configure Main Scheduler Properties
#==============================================================
# 假如你用到了集群特性，你就必须为集群中的每一个实例使用相同的名称，以使它们成为“逻辑上” 是同一个 Scheduler
org.quartz.scheduler.instanceName = zzzQuartzScheduler
org.quartz.scheduler.instanceId = AUTO


org.quartz.scheduler.rmi.export = false
org.quartz.scheduler.rmi.proxy = false
org.quartz.scheduler.wrapJobExecutionInUserTransaction = false

#==============================================================
#Configure JobStore
#==============================================================
org.quartz.jobStore.isClustered = true
org.quartz.jobStore.misfireThreshold = 5000
#org.quartz.jobStore.clusterCheckinInterval =20000
# 默认存储在内存中
#org.quartz.jobStore.class = org.quartz.simpl.RAMJobStore
#持久化
org.quartz.jobStore.class = org.quartz.impl.jdbcjobstore.JobStoreTX

org.quartz.jobStore.tablePrefix = QRTZ_

org.quartz.jobStore.dataSource = qzDS

#==============================================================
#Configure DataSource
#==============================================================
org.quartz.dataSource.qzDS.driver = com.mysql.jdbc.Driver

org.quartz.dataSource.qzDS.URL = jdbc:mysql://localhost:3306/quartz-test?useUnicode=true&characterEncoding=UTF-8

org.quartz.dataSource.qzDS.user = root

org.quartz.dataSource.qzDS.password =

org.quartz.dataSource.qzDS.maxConnections = 10

#==============================================================
#Configure ThreadPool
#==============================================================
# 实例化ThreadPool时，使用的线程类为SimpleThreadPool
org.quartz.threadPool.class = org.quartz.simpl.SimpleThreadPool
# threadCount和threadPriority将以setter的形式注入ThreadPool实例
# 并发个数
org.quartz.threadPool.threadCount = 5
# 优先级
org.quartz.threadPool.threadPriority = 5
org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread = true

 */