/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.19 : Database - study_group
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`study_group` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `study_group`;

/*Table structure for table `sgp_category` */

DROP TABLE IF EXISTS `sgp_category`;

CREATE TABLE `sgp_category` (
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `CAT_NAME` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名',
  `CREATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标记',
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '站点',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学习小组分类分类';

/*Table structure for table `sgp_category_group_rel` */

DROP TABLE IF EXISTS `sgp_category_group_rel`;

CREATE TABLE `sgp_category_group_rel` (
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '分类id',
  `SGP_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '小组id',
  PRIMARY KEY (`CAT_ID`,`SGP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学习小组分类-小组关联表';

/*Table structure for table `sgp_member` */

DROP TABLE IF EXISTS `sgp_member`;

CREATE TABLE `sgp_member` (
  `SGP_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '小组id',
  `CUST_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '客户id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`SGP_ID`,`CUST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='小组成员';

/*Table structure for table `sgp_site_category` */

DROP TABLE IF EXISTS `sgp_site_category`;

CREATE TABLE `sgp_site_category` (
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '站点id',
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '学习小组分类id',
  `SHOW_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '显示状态',
  `CAT_CRT_SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建站点',
  PRIMARY KEY (`SITE_ID`,`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='站点-学习小组';

/*Table structure for table `sgp_site_studygroup_rel` */

DROP TABLE IF EXISTS `sgp_site_studygroup_rel`;

CREATE TABLE `sgp_site_studygroup_rel` (
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '站点id',
  `SGP_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '学习小组id',
  `MANAGE_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '管理状态',
  `PUB_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布状态',
  `PUB_DATE` datetime DEFAULT NULL COMMENT '发布时间',
  `CRT_SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建站点',
  PRIMARY KEY (`SITE_ID`,`SGP_ID`),
  KEY `IDX_SGP_SITE_STUDYGROUP_SITE` (`CRT_SITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='站点-学习小组关联表';

/*Table structure for table `sgp_study_group` */

DROP TABLE IF EXISTS `sgp_study_group`;

CREATE TABLE `sgp_study_group` (
  `SGP_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `SGP_NAME` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '小组名称',
  `SGP_INFO` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简介',
  `SGP_CONTENT` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '小组介绍',
  `SGP_PHOTO` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '封面',
  `SGP_QQ` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'qq群',
  `SGP_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '0提交、1审核中、2审核通过、3审核失败',
  `AUDIT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审核id',
  `SGP_USER_NUM` int(9) DEFAULT NULL COMMENT '加入人数',
  `CREATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标记',
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '站点',
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`SGP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='学习小组';

/*Table structure for table `sgp_study_group_experience` */

DROP TABLE IF EXISTS `sgp_study_group_experience`;

CREATE TABLE `sgp_study_group_experience` (
  `SGP_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '小组id',
  `EPC_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '经验id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`SGP_ID`,`EPC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='小组经验';

/*Table structure for table `sgp_study_group_talent` */

DROP TABLE IF EXISTS `sgp_study_group_talent`;

CREATE TABLE `sgp_study_group_talent` (
  `SGP_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '小组id',
  `TLT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT '才艺id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`SGP_ID`,`TLT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='小组才艺';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
