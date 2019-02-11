/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.19 : Database - activity
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`activity` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `activity`;

/*Table structure for table `act_activity` */

DROP TABLE IF EXISTS `act_activity`;

CREATE TABLE `act_activity` (
  `ACT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `ACT_TITLE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动标题',
  `ACT_INFO` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简介',
  `ACT_CONTENT` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动内容',
  `ACT_PHOTO` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '封面',
  `ACT_AREA_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动区域id',
  `ACT_TYPE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动类型1宣传活动、2评比类活动',
  `ACT_START_DATE` datetime DEFAULT NULL COMMENT '活动开始时间',
  `ACT_END_DATE` datetime DEFAULT NULL COMMENT '活动结束时间',
  `ACT_TUTOR_USER_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '指导老师id',
  `ACT_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核',
  `ACT_PUB_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布状态',
  `ACT_AUDIT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核id',
  `ACT_SIGNUP_NUM` int(9) DEFAULT NULL COMMENT '报名人数',
  `ACT_IMGS` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动图片',
  `CREATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标记',
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '站点',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`ACT_ID`),
  KEY `IDX_ACT_ACTIVITY_UPDATE` (`UPDATE_DATE`),
  KEY `IDX_ACT_ACTIVITY_STARTDATE` (`ACT_START_DATE`),
  KEY `IDX_ACT_ACTIVITY_ENDDATE` (`ACT_END_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动';

/*Data for the table `act_activity` */

/*Table structure for table `act_activity_memer` */

DROP TABLE IF EXISTS `act_activity_memer`;

CREATE TABLE `act_activity_memer` (
  `ACT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动id',
  `JOINUP_USER_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户id',
  `JOINUP_DATE` datetime DEFAULT NULL COMMENT '参加时间',
  PRIMARY KEY (`ACT_ID`,`JOINUP_USER_ID`),
  KEY `IDX_ACT_ACTIVITY_MEMER_USER` (`JOINUP_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动参与人员';

/*Data for the table `act_activity_memer` */

/*Table structure for table `act_activity_works` */

DROP TABLE IF EXISTS `act_activity_works`;

CREATE TABLE `act_activity_works` (
  `WKS_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `ACT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动id',
  `WKS_CODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '作品编号',
  `WKS_PHOTO` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '封面',
  `WKS_TYPE` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '视频、图片',
  `WKS_FILE_IDS` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件ids',
  `WKS_FILE_NAMES` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件名称',
  `WKS_USER_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上传人id',
  `WKS_USER_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上传人名称',
  `WKS_UPLOAD_DATE` datetime DEFAULT NULL COMMENT '上传时间',
  `WKS_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0未提交、1已审核中、2审核通过、3审核失败',
  `WKS_AUDIT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核id',
  `WKS_VOTE_NUM` int(4) DEFAULT NULL COMMENT '投票数',
  `WKS_AVG_SCORE` int(3) DEFAULT NULL COMMENT '平均分',
  `UPDATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标记',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`WKS_ID`),
  KEY `IDX_ACT_ACTIVITY_WORKS_ACT` (`ACT_ID`),
  KEY `IDX_ACT_ACTIVITY_WORKS_CODE` (`WKS_CODE`),
  KEY `IDX_ACT_ACTIVITY_WORKS_USER` (`WKS_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动作品';

/*Data for the table `act_activity_works` */

/*Table structure for table `act_category` */

DROP TABLE IF EXISTS `act_category`;

CREATE TABLE `act_category` (
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '分类id',
  `CAT_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `CAT_LEVEL` int(4) DEFAULT NULL COMMENT '级别',
  `PARENT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父id',
  `PARENT_IDS` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父ids',
  `CREATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标记',
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '站点',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`CAT_ID`),
  KEY `IDX_ACT_CATEGORY_PARENT` (`PARENT_ID`),
  KEY `IDX_ACT_CATEGORY_PARENTS` (`PARENT_IDS`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动分类';

/*Data for the table `act_category` */

/*Table structure for table `act_category_activity` */

DROP TABLE IF EXISTS `act_category_activity`;

CREATE TABLE `act_category_activity` (
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动分类id',
  `ACT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动id',
  PRIMARY KEY (`CAT_ID`,`ACT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动分类-活动关联表';

/*Data for the table `act_category_activity` */

/*Table structure for table `act_marking` */

DROP TABLE IF EXISTS `act_marking`;

CREATE TABLE `act_marking` (
  `MK_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ID',
  `WKS_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '作品id',
  `MK_SCORE` int(3) DEFAULT NULL COMMENT '打分',
  `MK_USER_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '打分人id',
  `MK_USER_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '打分人名称',
  `MK_DATE` datetime DEFAULT NULL COMMENT '打分时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`MK_ID`),
  KEY `IDX_ACT_MARKING_WKS` (`WKS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='打分';

/*Data for the table `act_marking` */

/*Table structure for table `act_results` */

DROP TABLE IF EXISTS `act_results`;

CREATE TABLE `act_results` (
  `RST_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `ACT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动id',
  `RST_TITLE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `RST_CONTENT` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '内容',
  `RST_PHOTO` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '封面',
  `RST_FILE_IDS` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件ids',
  `RST_FILE_NAMES` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件名称',
  `RST_USER_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提交人id',
  `RST_USER_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提交人名称',
  `RST_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0未提交、1审核中、2审核通过、3审核不通过',
  `RST_AUDIT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标记',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`RST_ID`),
  KEY `IDX_ACT_RESULTS_ACT` (`ACT_ID`),
  KEY `IDX_ACT_RESULTS_USER` (`RST_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='活动成果';

/*Data for the table `act_results` */

/*Table structure for table `act_site_activity_rel` */

DROP TABLE IF EXISTS `act_site_activity_rel`;

CREATE TABLE `act_site_activity_rel` (
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '站点id',
  `ACT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动id',
  `ACT_AS_NAME` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动别名',
  `ACT_MANAGE_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '管理状态',
  `ACT_PUB_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布状态',
  `ACT_CRT_SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建站点id',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`SITE_ID`,`ACT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='站点-活动';

/*Data for the table `act_site_activity_rel` */

/*Table structure for table `act_site_category_rel` */

DROP TABLE IF EXISTS `act_site_category_rel`;

CREATE TABLE `act_site_category_rel` (
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '站点id',
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动分类id',
  `SHOW_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '显示状态',
  PRIMARY KEY (`SITE_ID`,`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='站点-活动分类';

/*Data for the table `act_site_category_rel` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
