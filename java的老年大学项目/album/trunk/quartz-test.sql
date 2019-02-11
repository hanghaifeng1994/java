/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.19 : Database - quartz-test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quartz-test` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `quartz-test`;

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `CALENDAR_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_cron_triggers` */

insert  into `qrtz_cron_triggers`(`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`CRON_EXPRESSION`,`TIME_ZONE_ID`) values ('AUDIT-SERVICE','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('COMMON-AUDIT-SERVICE','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('COMMON-NEWS-SERVICE','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('HOMEWORK-SERVICE','testJobTrigger','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('INTERACT-SERVICE','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('INTERACT-SERVICE','testJobTrigger','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('LEARNBEHAVIOR-SERVICE','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('NEWS-SERVICE','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('QUARTZ-SERVICE','testJobTrigger','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RABBIT-VIEW','saveMsgQueTrigger','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RABBIT-VIEW','testJobTrigger','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RABBIT-VIEW','testJobTrigger2','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('rabbitmq-consumer-demo','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('rabbitmq-product-demo','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('WEYE_RABBITMQ_VIEW','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('WEYE_RABBITMQ_VIEW','saveMsgQueTrigger','jobDetail','0/10 * * * * ?','Asia/Shanghai'),('WEYE_RABBITMQ_VIEW','saveMsgQueTrigger','jobDetail2','0/10 * * * * ?','Asia/Shanghai'),('WEYE_RABBITMQ_VIEW','saveMsgQueTrigger','view','0/10 * * * * ?','Asia/Shanghai'),('weye-rabbitmq-consumer-demo','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('weye-rabbitmq-consumer-demo','saveMsgQueTrigger','jobDetail','0/10 * * * * ?','Asia/Shanghai'),('weye-rabbitmq-consumer-demo','saveMsgQueTrigger','view','0/10 * * * * ?','Asia/Shanghai'),('weye-rabbitmq-product-demo','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('weye-rabbitmq-review','MqResultDealJob2Trigger','mq2','0/10 * * * * ?','Asia/Shanghai'),('weye-rabbitmq-review','MqResultDealJobTrigger','mq','0 1/10 * * * ?','Asia/Shanghai'),('weye-rabbitmq-review','MqResultDealJobTrigger1','mq1','0/10 * * * * ?','Asia/Shanghai'),('weye-rabbitmq-review','saveMsgQueTrigger','jobDetail','0/10 * * * * ?','Asia/Shanghai');

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `ENTRY_ID` varchar(95) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `INSTANCE_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_NAME` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JOB_GROUP` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_fired_triggers` */

insert  into `qrtz_fired_triggers`(`SCHED_NAME`,`ENTRY_ID`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`INSTANCE_NAME`,`FIRED_TIME`,`SCHED_TIME`,`PRIORITY`,`STATE`,`JOB_NAME`,`JOB_GROUP`,`IS_NONCONCURRENT`,`REQUESTS_RECOVERY`) values ('COMMON-AUDIT-SERVICE','PC-20180620SIRG15317326609421531732660643','recover_PC-20180620SIRG1531730455478_1531732675206','RECOVERING_JOBS','PC-20180620SIRG1531732660942',1531732675579,1531731660000,5,'EXECUTING','MqResultDealJob','mq','0','1'),('COMMON-AUDIT-SERVICE','PC-20180620SIRG15317326609421531732660644','recover_PC-20180620SIRG1531730455478_1531732675207','RECOVERING_JOBS','PC-20180620SIRG1531732660942',1531732675746,1531732260000,5,'EXECUTING','MqResultDealJob','mq','0','1'),('COMMON-AUDIT-SERVICE','PC-20180620SIRG15317326609421531732660645','MqResultDealJobTrigger','mq','PC-20180620SIRG1531732660942',1531732968292,1531732967985,5,'EXECUTING','MqResultDealJob','mq','0','1'),('COMMON-AUDIT-SERVICE','PC-20180620SIRG15317326609421531732660646','MqResultDealJobTrigger','mq','PC-20180620SIRG1531732660942',1531733460005,1531733460000,5,'EXECUTING','MqResultDealJob','mq','0','1'),('COMMON-AUDIT-SERVICE','PC-20180620SIRG15317326609421531732660647','MqResultDealJobTrigger','mq','PC-20180620SIRG1531732660942',1531734060006,1531734060000,5,'EXECUTING','MqResultDealJob','mq','0','1'),('INTERACT-SERVICE','PC-20180620SIRG15331025645821533102564928','testJobTrigger','DEFAULT','PC-20180620SIRG1533102564582',1533107330057,1533107340000,0,'ACQUIRED',NULL,NULL,'0','0'),('QUARTZ-SERVICE','PC-20180620SIRG15323949909781532394993506','testJobTrigger','DEFAULT','PC-20180620SIRG1532394990978',1532428360119,1532428370000,0,'ACQUIRED',NULL,NULL,'0','0'),('RABBIT-VIEW','PC-20180620SIRG15305119099271530511909394','testJobTrigger','DEFAULT','PC-20180620SIRG1530511909927',1530513158779,1530511940000,0,'EXECUTING','testJobDetail','DEFAULT','0','1'),('WEYE_RABBITMQ_VIEW','PC-20180620SIRG15306000489071530599759796','saveMsgQueTrigger','view','PC-20180620SIRG1530600048907',1530600120358,1530600130000,5,'ACQUIRED',NULL,NULL,'0','0'),('weye-rabbitmq-consumer-demo','PC-20180620SIRG15311844964661531184496615','saveMsgQueTrigger','view','PC-20180620SIRG1531184496466',1531186240430,1531186250000,5,'ACQUIRED',NULL,NULL,'0','0'),('weye-rabbitmq-review','PC-20180620SIRG15305178011451530517800989','MqResultDealJob2Trigger','mq2','PC-20180620SIRG1530517801145',1530517987809,1530517830000,5,'EXECUTING','MqResultDealJob2','mq2','0','1');

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `IS_DURABLE` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_job_details` */

insert  into `qrtz_job_details`(`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`,`DESCRIPTION`,`JOB_CLASS_NAME`,`IS_DURABLE`,`IS_NONCONCURRENT`,`IS_UPDATE_DATA`,`REQUESTS_RECOVERY`,`JOB_DATA`) values ('AUDIT-SERVICE','MqResultDealJob','mq',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('COMMON-AUDIT-SERVICE','MqResultDealJob','mq',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('COMMON-NEWS-SERVICE','MqResultDealJob','mq',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('HOMEWORK-SERVICE','testJobDetail','DEFAULT',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0testScheduleTaskt\0targetMethodt\0sayHellot\0\nconcurrentt\0falsex\0'),('INTERACT-SERVICE','MqResultDealJob','mq',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('INTERACT-SERVICE','testJobDetail','DEFAULT',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0collectInteractInfoTaskt\0targetMethodt\0saveInteractDatat\0\nconcurrentt\0falsex\0'),('LEARNBEHAVIOR-SERVICE','MqResultDealJob','mq',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('NEWS-SERVICE','MqResultDealJob','mq',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('QUARTZ-SERVICE','testJobDetail','DEFAULT',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0testScheduleTaskt\0targetMethodt\0sayHellot\0\nconcurrentt\0falsex\0'),('RABBIT-VIEW','saveMsgQueJob','DEFAULT',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentt\0falsex\0'),('RABBIT-VIEW','testJobDetail','DEFAULT',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0testScheduleTaskt\0targetMethodt\0sayHellot\0\nconcurrentt\0falsex\0'),('RABBIT-VIEW','testJobDetail2','DEFAULT',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0testScheduleTask2t\0targetMethodt\0sayHellot\0\nconcurrentt\0falsex\0'),('rabbitmq-consumer-demo','MqResultDealJob','mq',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('rabbitmq-product-demo','MqResultDealJob','mq',NULL,'com.learnyeai.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('WEYE_RABBITMQ_VIEW','jobDetail','jobDataAsMap',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('WEYE_RABBITMQ_VIEW','jobDetail2','jobDataAsMap2',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('WEYE_RABBITMQ_VIEW','MqResultDealJob','mq',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('WEYE_RABBITMQ_VIEW','view','jobDataAsMap',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-consumer-demo','jobDetail','jobDataAsMap',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-consumer-demo','MqResultDealJob','mq',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-consumer-demo','view','jobDataAsMap',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-product-demo','MqResultDealJob','mq',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-review','jobDetail','jobDataAsMap',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0saveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-review','MqResultDealJob','mq',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0mqResultTaskt\0targetMethodt\0reDoAllt\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-review','MqResultDealJob1','mq1',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0SaveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0'),('weye-rabbitmq-review','MqResultDealJob2','mq2',NULL,'cn.com.weyeyun.quartz.DetailQuartzJobBean','1','0','0','1','¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0targetObjectt\0SaveMsgQueTaskt\0targetMethodt\0\nsaveMsgQuet\0\nconcurrentsr\0java.lang.BooleanÕ rÄ’ú˙Ó\0Z\0valuexp\0x\0');

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `LOCK_NAME` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_locks` */

insert  into `qrtz_locks`(`SCHED_NAME`,`LOCK_NAME`) values ('AUDIT-SERVICE','STATE_ACCESS'),('AUDIT-SERVICE','TRIGGER_ACCESS'),('COMMON-AUDIT-SERVICE','STATE_ACCESS'),('COMMON-AUDIT-SERVICE','TRIGGER_ACCESS'),('COMMON-NEWS-SERVICE','STATE_ACCESS'),('COMMON-NEWS-SERVICE','TRIGGER_ACCESS'),('HOMEWORK-SERVICE','TRIGGER_ACCESS'),('INTERACT-SERVICE','STATE_ACCESS'),('INTERACT-SERVICE','TRIGGER_ACCESS'),('LEARNBEHAVIOR-SERVICE','STATE_ACCESS'),('LEARNBEHAVIOR-SERVICE','TRIGGER_ACCESS'),('NEWS-SERVICE','STATE_ACCESS'),('NEWS-SERVICE','TRIGGER_ACCESS'),('QUARTZ-SERVICE','STATE_ACCESS'),('QUARTZ-SERVICE','TRIGGER_ACCESS'),('RABBIT-VIEW','STATE_ACCESS'),('RABBIT-VIEW','TRIGGER_ACCESS'),('rabbitmq-consumer-demo','STATE_ACCESS'),('rabbitmq-consumer-demo','TRIGGER_ACCESS'),('rabbitmq-product-demo','STATE_ACCESS'),('rabbitmq-product-demo','TRIGGER_ACCESS'),('WEYE_RABBITMQ_VIEW','STATE_ACCESS'),('WEYE_RABBITMQ_VIEW','TRIGGER_ACCESS'),('weye-rabbitmq-consumer-demo','STATE_ACCESS'),('weye-rabbitmq-consumer-demo','TRIGGER_ACCESS'),('weye-rabbitmq-product-demo','STATE_ACCESS'),('weye-rabbitmq-product-demo','TRIGGER_ACCESS'),('weye-rabbitmq-review','STATE_ACCESS'),('weye-rabbitmq-review','TRIGGER_ACCESS');

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `INSTANCE_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_scheduler_state` */

insert  into `qrtz_scheduler_state`(`SCHED_NAME`,`INSTANCE_NAME`,`LAST_CHECKIN_TIME`,`CHECKIN_INTERVAL`) values ('AUDIT-SERVICE','PC-20180620SIRG1532748601942',1532773991472,7500),('COMMON-AUDIT-SERVICE','PC-20180620SIRG1531732660942',1531737088619,7500),('COMMON-NEWS-SERVICE','PC-20180620SIRG1531725392440',1531726481717,7500),('INTERACT-SERVICE','PC-20180620SIRG1533102564582',1533107333460,7500),('LEARNBEHAVIOR-SERVICE','PC-20180620SIRG1532071414340',1532072813668,7500),('NEWS-SERVICE','PC-20180620SIRG1532918641752',1532946694519,7500),('QUARTZ-SERVICE','PC-20180620SIRG1532394990978',1532428362103,7500),('RABBIT-VIEW','PC-20180620SIRG1530511909927',1530513158742,7500),('rabbitmq-consumer-demo','PC-20180620SIRG1532141620248',1532145823951,7500),('rabbitmq-product-demo','PC-20180620SIRG1532141302399',1532145792153,7500),('WEYE_RABBITMQ_VIEW','PC-20180620SIRG1530600048907',1530600125752,7500),('weye-rabbitmq-consumer-demo','PC-20180620SIRG1531184496466',1531186235023,7500),('weye-rabbitmq-product-demo','PC-20180620SIRG1530780861714',1530784883071,7500),('weye-rabbitmq-review','PC-20180620SIRG1530517801145',1530517987718,7500);

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_simple_triggers` */

insert  into `qrtz_simple_triggers`(`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`REPEAT_COUNT`,`REPEAT_INTERVAL`,`TIMES_TRIGGERED`) values ('COMMON-AUDIT-SERVICE','recover_PC-20180620SIRG1531730455478_1531732675206','RECOVERING_JOBS',0,0,1),('COMMON-AUDIT-SERVICE','recover_PC-20180620SIRG1531730455478_1531732675207','RECOVERING_JOBS',0,0,1);

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `STR_PROP_1` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STR_PROP_2` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STR_PROP_3` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_NAME` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `JOB_GROUP` varchar(190) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(190) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `qrtz_triggers` */

insert  into `qrtz_triggers`(`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`JOB_NAME`,`JOB_GROUP`,`DESCRIPTION`,`NEXT_FIRE_TIME`,`PREV_FIRE_TIME`,`PRIORITY`,`TRIGGER_STATE`,`TRIGGER_TYPE`,`START_TIME`,`END_TIME`,`CALENDAR_NAME`,`MISFIRE_INSTR`,`JOB_DATA`) values ('AUDIT-SERVICE','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1532774460000,1532773860000,5,'WAITING','CRON',1531966620000,0,NULL,0,''),('COMMON-AUDIT-SERVICE','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1531737088202,1531734060000,5,'WAITING','CRON',1531387197000,0,NULL,0,''),('COMMON-AUDIT-SERVICE','recover_PC-20180620SIRG1531730455478_1531732675206','RECOVERING_JOBS','MqResultDealJob','mq',NULL,-1,1531731660000,5,'COMPLETE','SIMPLE',1531731660000,0,NULL,-1,'¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0?QRTZ_FAILED_JOB_ORIG_TRIGGER_FIRETIME_IN_MILLISECONDS_AS_STRINGt\0\r1531731660015t\0!QRTZ_FAILED_JOB_ORIG_TRIGGER_NAMEt\0MqResultDealJobTriggert\0IQRTZ_FAILED_JOB_ORIG_TRIGGER_SCHEDULED_FIRETIME_IN_MILLISECONDS_AS_STRINGt\0\r1531731660000t\0\"QRTZ_FAILED_JOB_ORIG_TRIGGER_GROUPt\0mqx\0'),('COMMON-AUDIT-SERVICE','recover_PC-20180620SIRG1531730455478_1531732675207','RECOVERING_JOBS','MqResultDealJob','mq',NULL,-1,1531732260000,5,'COMPLETE','SIMPLE',1531732260000,0,NULL,-1,'¨Ì\0sr\0org.quartz.JobDataMapü∞ÉËø©∞À\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMapÇË√˚≈](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMapÊ.≠(v\nŒ\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap⁄¡√`—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0?QRTZ_FAILED_JOB_ORIG_TRIGGER_FIRETIME_IN_MILLISECONDS_AS_STRINGt\0\r1531732260007t\0!QRTZ_FAILED_JOB_ORIG_TRIGGER_NAMEt\0MqResultDealJobTriggert\0IQRTZ_FAILED_JOB_ORIG_TRIGGER_SCHEDULED_FIRETIME_IN_MILLISECONDS_AS_STRINGt\0\r1531732260000t\0\"QRTZ_FAILED_JOB_ORIG_TRIGGER_GROUPt\0mqx\0'),('COMMON-NEWS-SERVICE','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1531726860000,1531726260000,5,'WAITING','CRON',1531387077000,0,NULL,0,''),('HOMEWORK-SERVICE','testJobTrigger','DEFAULT','testJobDetail','DEFAULT',NULL,1532324640000,-1,0,'WAITING','CRON',1532324635000,0,NULL,0,''),('INTERACT-SERVICE','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1533107460000,1533106860000,5,'WAITING','CRON',1532053891000,0,NULL,0,''),('INTERACT-SERVICE','testJobTrigger','DEFAULT','testJobDetail','DEFAULT',NULL,1533107340000,1533107330000,0,'ACQUIRED','CRON',1533102564000,0,NULL,0,''),('LEARNBEHAVIOR-SERVICE','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1532073060000,1532072460000,5,'WAITING','CRON',1532070422000,0,NULL,0,''),('NEWS-SERVICE','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1532947260000,1532946660000,5,'WAITING','CRON',1531987145000,0,NULL,0,''),('QUARTZ-SERVICE','testJobTrigger','DEFAULT','testJobDetail','DEFAULT',NULL,1532428370000,1532428360000,0,'ACQUIRED','CRON',1532394990000,0,NULL,0,''),('RABBIT-VIEW','saveMsgQueTrigger','DEFAULT','saveMsgQueJob','DEFAULT',NULL,1530513158848,1530511921039,0,'WAITING','CRON',1530511909000,0,NULL,0,''),('RABBIT-VIEW','testJobTrigger','DEFAULT','testJobDetail','DEFAULT',NULL,1530513158851,1530511940000,0,'WAITING','CRON',1530255012000,0,NULL,0,''),('RABBIT-VIEW','testJobTrigger2','DEFAULT','testJobDetail2','DEFAULT',NULL,1530513158834,1530511921010,0,'WAITING','CRON',1530253019000,0,NULL,0,''),('rabbitmq-consumer-demo','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1532146260000,1532145660000,5,'WAITING','CRON',1532136718000,0,NULL,0,''),('rabbitmq-product-demo','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1532146260000,1532145660000,5,'WAITING','CRON',1532140998000,0,NULL,0,''),('WEYE_RABBITMQ_VIEW','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1530600660000,1530600060000,5,'WAITING','CRON',1530596828000,0,NULL,0,''),('WEYE_RABBITMQ_VIEW','saveMsgQueTrigger','jobDetail','jobDetail','jobDataAsMap',NULL,1530600130000,1530600120000,5,'WAITING','CRON',1530596827000,0,NULL,0,''),('WEYE_RABBITMQ_VIEW','saveMsgQueTrigger','jobDetail2','jobDetail2','jobDataAsMap2',NULL,1530600130000,1530600120000,5,'WAITING','CRON',1530598720000,0,NULL,0,''),('WEYE_RABBITMQ_VIEW','saveMsgQueTrigger','view','view','jobDataAsMap',NULL,1530600130000,1530600120000,5,'ACQUIRED','CRON',1530600049000,0,NULL,0,''),('weye-rabbitmq-consumer-demo','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1531186260000,1531185660000,5,'WAITING','CRON',1530155677000,0,NULL,0,''),('weye-rabbitmq-consumer-demo','saveMsgQueTrigger','jobDetail','jobDetail','jobDataAsMap',NULL,1531186250000,1531186240000,5,'WAITING','CRON',1530518605000,0,NULL,0,''),('weye-rabbitmq-consumer-demo','saveMsgQueTrigger','view','view','jobDataAsMap',NULL,1531186250000,1531186240000,5,'ACQUIRED','CRON',1530601052000,0,NULL,0,''),('weye-rabbitmq-product-demo','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1530785460000,1530784860000,5,'WAITING','CRON',1530155417000,0,NULL,0,''),('weye-rabbitmq-review','MqResultDealJob2Trigger','mq2','MqResultDealJob2','mq2',NULL,1530517840000,1530517830000,5,'WAITING','CRON',1530516404000,0,NULL,0,''),('weye-rabbitmq-review','MqResultDealJobTrigger','mq','MqResultDealJob','mq',NULL,1530517987784,1530517405665,5,'WAITING','CRON',1530514999000,0,NULL,0,''),('weye-rabbitmq-review','MqResultDealJobTrigger1','mq1','MqResultDealJob1','mq1',NULL,1530517987737,1530517826188,5,'WAITING','CRON',1530516046000,0,NULL,0,''),('weye-rabbitmq-review','saveMsgQueTrigger','jobDetail','jobDetail','jobDataAsMap',NULL,1530517987772,1530517830000,5,'WAITING','CRON',1530516681000,0,NULL,0,'');

/*Table structure for table `rab_msg_table` */

DROP TABLE IF EXISTS `rab_msg_table`;

CREATE TABLE `rab_msg_table` (
  `MSG_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Ê∂àÊÅØid',
  `SERVER_NAME` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Ê∂àÊÅØÊúçÂä°ÁöÑÂêçÁß∞',
  `EXCHANGE` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROUTING_KEY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PAYLOAD` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '‰º†ÈÄíÁöÑÊ∂àÊÅØÂÜÖÂÆπ',
  `MSG_STATUS` int(1) DEFAULT NULL COMMENT 'Áîü‰∫ßËÄÖÊ∂àÊÅØÁä∂ÊÄÅÔºå0Êú™Á°ÆËÆ§„ÄÅ1Â∑≤Á°ÆËÆ§„ÄÅ2ÂõûË∞ÉÂ§ÑÁêÜÂ§±Ë¥•',
  `FAIL_TIMES` int(1) DEFAULT NULL COMMENT 'ÂÆöÊó∂Âô®Âæ™ÁéØÂ§ÑÁêÜË∂ÖÊó∂Êï∞ÊçÆÊó∂ÔºåÂ§±Ë¥•Ê¨°Êï∞+1ÔºåreturnTimes=0ÔºåÂÜçÈáçÊñ∞ÂèëÈÄÅÊï∞ÊçÆ',
  `RETURN_DATE` datetime DEFAULT NULL COMMENT 'Êåâ‰∏ÄÂÆöÊó∂Èó¥ËßÑÂæãÔºåÂÜçÊ¨°ÂèëÈÄÅÔºåÂ§ÑÁêÜÁä∂ÊÄÅÔºöÊ≠ª‰ø°ËøòÊòØÊú™ÂèëÈÄÅÈÉΩÊõ¥Êñ∞',
  `DEAL_RESULT` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DEAL_DATE` datetime DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `LAST_SEND_DATE` datetime DEFAULT NULL,
  `LAST_DEAL_Msg_DATE` datetime DEFAULT NULL COMMENT '‰∏äÊ¨°Ê∂àÊÅØÂèëÈÄÅÊó∂Èó¥',
  `DEAL_STATUS` int(11) DEFAULT NULL COMMENT 'Ê∂àË¥πËÄÖÂ§ÑÁêÜÔºö0Êú™Â§ÑÁêÜ„ÄÅ1ÊàêÂäü„ÄÅ2Â§±Ë¥•„ÄÅ3Ê≠ª‰ø°ÈòüÂàóÔºåÂ¶ÇÊûúÊòØÊ≠ª‰ø°ÂÆöÊó∂ÂèëÈÄÅ',
  PRIMARY KEY (`MSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rab_msg_table` */

insert  into `rab_msg_table`(`MSG_ID`,`SERVER_NAME`,`EXCHANGE`,`ROUTING_KEY`,`PAYLOAD`,`MSG_STATUS`,`FAIL_TIMES`,`RETURN_DATE`,`DEAL_RESULT`,`DEAL_DATE`,`CREATE_DATE`,`LAST_SEND_DATE`,`LAST_DEAL_Msg_DATE`,`DEAL_STATUS`) values ('c0a9a441-cb1e-452d-ba3a-cd2dd470b214','weye-rabbitmq-product-demo::MQ_product','demo.exchange','demo.key','\"{\\\"cacheKey\\\":\\\"weye-rabbitmq-product-demo::MQ_product\\\"}\"',1,7,NULL,'null',NULL,'2018-07-05 16:54:47','2018-07-05 16:54:47','2018-07-05 18:01:01',0);

/*Table structure for table `rab_msg_temp_table` */

DROP TABLE IF EXISTS `rab_msg_temp_table`;

CREATE TABLE `rab_msg_temp_table` (
  `MSG_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'Ê∂àÊÅØid',
  `SERVER_NAME` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Ê∂àÊÅØÊúçÂä°ÁöÑÂêçÁß∞',
  `EXCHANGE` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROUTING_KEY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PAYLOAD` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '‰º†ÈÄíÁöÑÊ∂àÊÅØÂÜÖÂÆπ',
  `MSG_STATUS` int(1) DEFAULT NULL COMMENT 'Áîü‰∫ßËÄÖÊ∂àÊÅØÁä∂ÊÄÅÔºå0Êú™Á°ÆËÆ§„ÄÅ1Â∑≤Á°ÆËÆ§„ÄÅ2ÂõûË∞ÉÂ§ÑÁêÜÂ§±Ë¥•',
  `FAIL_TIMES` int(1) DEFAULT NULL COMMENT 'ÂÆöÊó∂Âô®Âæ™ÁéØÂ§ÑÁêÜË∂ÖÊó∂Êï∞ÊçÆÊó∂ÔºåÂ§±Ë¥•Ê¨°Êï∞+1ÔºåreturnTimes=0ÔºåÂÜçÈáçÊñ∞ÂèëÈÄÅÊï∞ÊçÆ',
  `RETURN_DATE` datetime DEFAULT NULL COMMENT 'Êåâ‰∏ÄÂÆöÊó∂Èó¥ËßÑÂæãÔºåÂÜçÊ¨°ÂèëÈÄÅÔºåÂ§ÑÁêÜÁä∂ÊÄÅÔºöÊ≠ª‰ø°ËøòÊòØÊú™ÂèëÈÄÅÈÉΩÊõ¥Êñ∞',
  `DEAL_RESULT` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DEAL_DATE` datetime DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `LAST_SEND_DATE` datetime DEFAULT NULL,
  `LAST_DEAL_Msg_DATE` datetime DEFAULT NULL COMMENT '‰∏äÊ¨°Ê∂àÊÅØÂèëÈÄÅÊó∂Èó¥',
  `DEAL_STATUS` int(11) DEFAULT NULL COMMENT ' Ê∂àË¥πËÄÖÂ§ÑÁêÜÔºö0Êú™Â§ÑÁêÜ„ÄÅ1ÊàêÂäü„ÄÅ2Â§±Ë¥•„ÄÅ3Ê≠ª‰ø°ÈòüÂàóÔºåÂ¶ÇÊûúÊòØÊ≠ª‰ø°ÂÆöÊó∂ÂèëÈÄÅ',
  PRIMARY KEY (`MSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rab_msg_temp_table` */

insert  into `rab_msg_temp_table`(`MSG_ID`,`SERVER_NAME`,`EXCHANGE`,`ROUTING_KEY`,`PAYLOAD`,`MSG_STATUS`,`FAIL_TIMES`,`RETURN_DATE`,`DEAL_RESULT`,`DEAL_DATE`,`CREATE_DATE`,`LAST_SEND_DATE`,`LAST_DEAL_Msg_DATE`,`DEAL_STATUS`) values ('c0a9a441-cb1e-452d-ba3a-cd2dd470b214','weye-rabbitmq-product-demo::MQ_product','demo.exchange','demo.key','\"{\\\"cacheKey\\\":\\\"weye-rabbitmq-product-demo::MQ_product\\\"}\"',1,7,NULL,'null',NULL,'2018-07-05 16:54:47','2018-07-05 16:54:47','2018-07-05 18:01:01',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
