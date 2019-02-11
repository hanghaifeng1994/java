/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.19 : Database - trainmanage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`trainmanage` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `trainmanage`;

/*Table structure for table `clz_category` */

DROP TABLE IF EXISTS `clz_category`;

CREATE TABLE `clz_category` (
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `CAT_NAME` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CAT_LEVEL` int(4) DEFAULT NULL,
  `PARENT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARENT_IDS` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `DEL_FLAG` char(1) COLLATE utf8_unicode_ci DEFAULT '0',
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MCHT_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MCHT_SCHM_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `clz_site_category_rel` */

DROP TABLE IF EXISTS `clz_site_category_rel`;

CREATE TABLE `clz_site_category_rel` (
  `SITE_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `CAT_ID` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `SHOW_STATUS` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CAT_CRT_SITE_ID` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SITE_ID`,`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
