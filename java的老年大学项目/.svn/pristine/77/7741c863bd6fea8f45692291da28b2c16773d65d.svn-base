/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : resource

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2018-08-04 18:41:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `res_category`
-- ----------------------------
DROP TABLE IF EXISTS `res_category`;
CREATE TABLE `res_category` (
  `CAT_ID` varchar(64) NOT NULL COMMENT 'id',
  `CAT_NAME` varchar(30) DEFAULT NULL COMMENT '分类名称',
  `CAT_SORT` int(5) NOT NULL DEFAULT '0' COMMENT '排序',
  `CAT_LEVEL` int(5) NOT NULL DEFAULT '1' COMMENT '级别',
  `PARENT_ID` varchar(64) DEFAULT NULL COMMENT '父id',
  `PARENT_IDS` varchar(640) DEFAULT NULL COMMENT '所有父ids',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `DEL_FLAG` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标记',
  `SITE_ID` varchar(64) DEFAULT NULL COMMENT '站点id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`CAT_ID`),
  KEY `IDX_RES_CATEGORY_PARENT` (`PARENT_ID`),
  KEY `IDX_RES_CATEGORY_PARENTS` (`PARENT_IDS`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源分类';

-- ----------------------------
-- Records of res_category
-- ----------------------------
INSERT INTO `res_category` VALUES ('991c3ee79b47446d90d934eacc4fbbaa', '001', '1', '1', null, '', 'abcd', '2018-08-04 11:49:25', '1', '2018-08-03 16:23:39', '', '1', '2', '2');
INSERT INTO `res_category` VALUES ('c63e7cb56c81402f9560c7bfe1d67b32', '002', '2', '2', '991c3ee79b47446d90d934eacc4fbbaa', '991c3ee79b47446d90d934eacc4fbbaa,', 'abcd', '2018-08-04 11:49:23', '1', '2018-08-03 16:23:39', '', '1', '2', '2');
INSERT INTO `res_category` VALUES ('e8441b15ac3d46338bf7dd25b5d04c3e', '009', '2', '1', null, '', '1234', '2018-08-03 17:37:13', '1', '2018-08-03 17:37:13', '', '1', '2', '2');
INSERT INTO `res_category` VALUES ('eecfc7ac777d4a49a229777c4227af16', '003', '2', '3', 'c63e7cb56c81402f9560c7bfe1d67b32', '991c3ee79b47446d90d934eacc4fbbaa,c63e7cb56c81402f9560c7bfe1d67b32,', 'abcd', '2018-08-03 16:07:27', '1', '2018-08-03 16:07:27', '', '1', '2', '2');

-- ----------------------------
-- Table structure for `res_category_resource_rel`
-- ----------------------------
DROP TABLE IF EXISTS `res_category_resource_rel`;
CREATE TABLE `res_category_resource_rel` (
  `ID` varchar(64) NOT NULL COMMENT 'id',
  `CAT_ID` varchar(64) NOT NULL COMMENT '分类id',
  `RES_ID` varchar(64) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UN_CAT_RES_INDEX` (`CAT_ID`,`RES_ID`),
  KEY `NOR_R_C_R_R_RES_ID` (`RES_ID`) USING BTREE,
  KEY `NOR_R_C_R_R_CAT_ID` (`CAT_ID`),
  CONSTRAINT `res_category_resource_rel_ibfk_1` FOREIGN KEY (`RES_ID`) REFERENCES `res_resource` (`RES_ID`),
  CONSTRAINT `res_category_resource_rel_ibfk_2` FOREIGN KEY (`CAT_ID`) REFERENCES `res_category` (`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源分类关联表';

-- ----------------------------
-- Records of res_category_resource_rel
-- ----------------------------
INSERT INTO `res_category_resource_rel` VALUES ('2cb8bec3f6aa4a828a21cc6f62df048c', 'e8441b15ac3d46338bf7dd25b5d04c3e', '37520c2078ec4a1c8a0778ca22bc8e17');
INSERT INTO `res_category_resource_rel` VALUES ('240fe567f99f4af4bb692c4426294166', 'e8441b15ac3d46338bf7dd25b5d04c3e', '5680dd74a4284b248d6033c58fe7ca4d');
INSERT INTO `res_category_resource_rel` VALUES ('527f3b83a1f2417e8c60ddc8d173eed4', 'e8441b15ac3d46338bf7dd25b5d04c3e', 'aed6bab75e484b22acec52ace4590edc');
INSERT INTO `res_category_resource_rel` VALUES ('d9ff05fa78a14999bfe30b8ec07acf10', 'e8441b15ac3d46338bf7dd25b5d04c3e', 'c57ffa25d0cd482184810b0b277abf04');
INSERT INTO `res_category_resource_rel` VALUES ('29868dd4ffb7442586633aa49c802b24', 'e8441b15ac3d46338bf7dd25b5d04c3e', 'ed4fe9c8891e41f487c3c89f1ab54d9b');

-- ----------------------------
-- Table structure for `res_file`
-- ----------------------------
DROP TABLE IF EXISTS `res_file`;
CREATE TABLE `res_file` (
  `RES_FIEL_ID` varchar(64) NOT NULL COMMENT 'id',
  `FILE_NAME` varchar(128) DEFAULT NULL COMMENT '文件名',
  `RES_ID` varchar(64) DEFAULT NULL COMMENT '资源id',
  `FILE_ID` varchar(30) DEFAULT NULL COMMENT '文件id',
  `FILE_TYPE` varchar(10) DEFAULT NULL COMMENT '文件类型',
  `FILE_FORMAT` varchar(10) DEFAULT NULL COMMENT '文件格式',
  `FILE_SIZE` double(9,0) DEFAULT NULL COMMENT '大小',
  `FILE_SUFFIX` varchar(10) DEFAULT NULL COMMENT '后缀',
  `FILE_TIME_LEN` int(9) DEFAULT NULL COMMENT '时长',
  `DOWNLOAD_NUM` int(9) NOT NULL DEFAULT '0' COMMENT '下载次数',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `DEL_FLAG` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标记',
  `SITE_ID` varchar(64) DEFAULT NULL COMMENT '站点',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`RES_FIEL_ID`),
  KEY `IDX_RES_FILE_RES` (`RES_ID`),
  CONSTRAINT `FK_R_F_RES_ID` FOREIGN KEY (`RES_ID`) REFERENCES `res_resource` (`RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源文件';

-- ----------------------------
-- Records of res_file
-- ----------------------------
INSERT INTO `res_file` VALUES ('75a458a640bf471d8cfde39b199ef728', '视频001', 'ed4fe9c8891e41f487c3c89f1ab54d9b', '111', 'mp4', null, '12', 'mp4', '6000', '0', null, '2018-08-04 14:16:12', '', '1', '2', '2');

-- ----------------------------
-- Table structure for `res_ptrescs_resource_rel`
-- ----------------------------
DROP TABLE IF EXISTS `res_ptrescs_resource_rel`;
CREATE TABLE `res_ptrescs_resource_rel` (
  `ID` varchar(64) NOT NULL COMMENT 'id',
  `PTRES_CS_ID` varchar(64) DEFAULT NULL COMMENT '平台资源大类id',
  `RES_ID` varchar(64) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源-平台资源大类';

-- ----------------------------
-- Records of res_ptrescs_resource_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `res_resource`
-- ----------------------------
DROP TABLE IF EXISTS `res_resource`;
CREATE TABLE `res_resource` (
  `RES_ID` varchar(64) NOT NULL COMMENT 'id',
  `RES_NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `RES_LABEL` varchar(64) DEFAULT NULL COMMENT '标签',
  `RES_INFO` varchar(800) DEFAULT NULL COMMENT '简介',
  `RES_PHOTO` varchar(50) DEFAULT NULL COMMENT '封面',
  `RES_IMGS` varchar(500) DEFAULT NULL COMMENT '配图',
  `RES_AUTHOR` varchar(20) DEFAULT NULL COMMENT '作者',
  `RES_POINTS` double(6,2) DEFAULT NULL COMMENT '资源积分',
  `FILE_TYPE` varchar(64) DEFAULT NULL COMMENT '文件类型',
  `FILE_FORMAT` varchar(10) DEFAULT NULL COMMENT '文件格式',
  `FILE_SIZE` double(6,2) DEFAULT NULL COMMENT '大小',
  `FILE_TIME_LEN` int(9) DEFAULT NULL COMMENT '时长',
  `RES_STATUS` int(2) NOT NULL DEFAULT '0' COMMENT '状态：0未提交、1审核中、2审核通过、3审核失败、4不需要审核',
  `RES_PUB_STATUS` bit(1) NOT NULL DEFAULT b'0' COMMENT '发布状态',
  `RES_PUB_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `RES_AUDIT_ID` varchar(64) DEFAULT NULL COMMENT '审核id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `DEL_FLAG` bit(1) NOT NULL COMMENT '删除标记',
  `SITE_ID` varchar(64) DEFAULT NULL COMMENT '站点',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of res_resource
-- ----------------------------
INSERT INTO `res_resource` VALUES ('37520c2078ec4a1c8a0778ca22bc8e17', '资源004', null, null, null, null, '11', null, null, null, null, '1001', '0', '', '2018-08-04 18:09:24', null, null, '2018-08-04 11:48:55', '1', '2018-08-04 11:48:55', '', '1', '2', '2');
INSERT INTO `res_resource` VALUES ('5680dd74a4284b248d6033c58fe7ca4d', '资源003', null, null, null, null, '21', null, null, null, null, '1001', '0', '', '2018-08-04 18:09:24', null, null, '2018-08-04 11:48:53', '1', '2018-08-04 14:51:20', '', '1', '2', '2');
INSERT INTO `res_resource` VALUES ('aed6bab75e484b22acec52ace4590edc', '资源002', null, null, null, null, '31', null, null, null, null, '1001', '0', '', '2018-08-04 18:09:25', null, null, '2018-08-04 11:48:49', '1', '2018-08-04 11:48:49', '', '1', '2', '2');
INSERT INTO `res_resource` VALUES ('c57ffa25d0cd482184810b0b277abf04', '资源005', '资源005', '资源005资源005资源005', null, null, '41', null, null, null, null, '1001', '0', '', '2018-08-04 18:09:25', null, null, '2018-08-04 11:50:19', '1', '2018-08-04 14:51:42', '', '1', '2', '2');
INSERT INTO `res_resource` VALUES ('ed4fe9c8891e41f487c3c89f1ab54d9b', '资源001', null, null, null, null, '51', null, null, null, null, '1001', '0', '', '2018-08-04 18:09:27', null, null, '2018-08-04 11:48:28', '1', '2018-08-04 11:51:12', '', '1', '2', '2');

-- ----------------------------
-- Table structure for `res_site_category_rel`
-- ----------------------------
DROP TABLE IF EXISTS `res_site_category_rel`;
CREATE TABLE `res_site_category_rel` (
  `ID` varchar(64) NOT NULL COMMENT 'id',
  `SITE_ID` varchar(64) NOT NULL COMMENT '站点id',
  `CAT_CRT_SITE_ID` varchar(64) NOT NULL COMMENT '创建站点',
  `CAT_ID` varchar(64) NOT NULL COMMENT '资源分类id',
  `SHOW_STATUS` bit(1) NOT NULL DEFAULT b'0' COMMENT '显示状态',
  `CAT_SORT` int(5) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UN_R_S_C_R_SITE_CAT_ID` (`SITE_ID`,`CAT_ID`),
  KEY `NO_R_S_C_R_SITE_ID` (`SITE_ID`),
  KEY `FK_R_S_C_R_CAT_ID` (`CAT_ID`),
  CONSTRAINT `FK_R_S_C_R_CAT_ID` FOREIGN KEY (`CAT_ID`) REFERENCES `res_category` (`CAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点-资源分类';

-- ----------------------------
-- Records of res_site_category_rel
-- ----------------------------
INSERT INTO `res_site_category_rel` VALUES ('47fdb59310194ad9ab9078d806157fa9', '1', '1', 'e8441b15ac3d46338bf7dd25b5d04c3e', '', '1');
INSERT INTO `res_site_category_rel` VALUES ('5dc1b69a8e2a4761b53dee105ab70f54', '1', '1', '991c3ee79b47446d90d934eacc4fbbaa', '', '2');
INSERT INTO `res_site_category_rel` VALUES ('f20752a813274a428a58e187df468cef', '1', '1', 'eecfc7ac777d4a49a229777c4227af16', '', '3');
INSERT INTO `res_site_category_rel` VALUES ('f401cb9faf3a4ff3a40b0640c1859d43', '1', '1', 'c63e7cb56c81402f9560c7bfe1d67b32', '', '4');

-- ----------------------------
-- Table structure for `res_site_resource_rel`
-- ----------------------------
DROP TABLE IF EXISTS `res_site_resource_rel`;
CREATE TABLE `res_site_resource_rel` (
  `ID` varchar(64) NOT NULL COMMENT 'id',
  `SITE_ID` varchar(64) NOT NULL COMMENT '站点',
  `RES_ID` varchar(64) NOT NULL COMMENT '资源id',
  `RES_AS_NAME` varchar(200) DEFAULT NULL COMMENT '别名',
  `RES_MANAGE_STATUS` bit(1) NOT NULL DEFAULT b'0' COMMENT '管理状态',
  `RES_PUB_STATUS` bit(1) NOT NULL DEFAULT b'0' COMMENT '发布状态',
  `RES_CRT_SITE_ID` varchar(64) DEFAULT NULL COMMENT '创建站点',
  `RES_PUB_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UN_R_S_R_R_SITE_RES_ID` (`SITE_ID`,`RES_ID`),
  KEY `FK_R_S_R_R_RES_ID` (`RES_ID`),
  KEY `NO_R_S_R_R_SITE_ID` (`SITE_ID`),
  CONSTRAINT `FK_R_S_R_R_RES_ID` FOREIGN KEY (`RES_ID`) REFERENCES `res_resource` (`RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点资源关联表';

-- ----------------------------
-- Records of res_site_resource_rel
-- ----------------------------
INSERT INTO `res_site_resource_rel` VALUES ('163cea30662d4970bc205c7267efbf98', '1', 'ed4fe9c8891e41f487c3c89f1ab54d9b', '资源001', '', '', '1', null);
INSERT INTO `res_site_resource_rel` VALUES ('1711cde264104494972da1ef1b345df1', '1', 'aed6bab75e484b22acec52ace4590edc', '资源002', '', '', '1', null);
INSERT INTO `res_site_resource_rel` VALUES ('6e7113da9eb4430b90a024b6cbb27de9', '1', '37520c2078ec4a1c8a0778ca22bc8e17', '资源004', '', '', '2', '2018-08-04 15:37:29');
INSERT INTO `res_site_resource_rel` VALUES ('f1ce95d87ddd485eb7b54c530f732d5b', '1', '5680dd74a4284b248d6033c58fe7ca4d', '资源003', '', '', '2', '2018-08-04 15:32:17');
INSERT INTO `res_site_resource_rel` VALUES ('fdd9c94487604cb58b64065e48875317', '1', 'c57ffa25d0cd482184810b0b277abf04', '资源005', '', '', '2', '2018-08-04 15:32:17');

-- ----------------------------
-- Table structure for `res_user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `res_user_resource`;
CREATE TABLE `res_user_resource` (
  `ID` varchar(64) NOT NULL COMMENT 'id',
  `USER_ID` varchar(64) NOT NULL COMMENT '用户id',
  `RES_ID` varchar(64) NOT NULL COMMENT '资源id',
  `LAST_PAGE` varchar(10) DEFAULT NULL COMMENT '最后学习时间点，秒',
  `STUDY_TIME` int(11) NOT NULL DEFAULT '0',
  `APP_STUDY_TIME` int(11) NOT NULL DEFAULT '0',
  `PROCESS_PERCENT` double(5,2) DEFAULT '0.00' COMMENT '进度百分比*100',
  `STUDY_NO` int(11) NOT NULL DEFAULT '0',
  `START_LEARNING_DATE` timestamp NULL DEFAULT NULL,
  `END_LEARNING_DATE` timestamp NULL DEFAULT NULL,
  `CREATE_DATE` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `UN_R_U_R_USER_RES_ID` (`USER_ID`,`RES_ID`),
  KEY `RES_ID_Normal` (`RES_ID`) USING BTREE,
  CONSTRAINT `FK_R_U_R_RES_ID` FOREIGN KEY (`RES_ID`) REFERENCES `res_resource` (`RES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res_user_resource
-- ----------------------------
INSERT INTO `res_user_resource` VALUES ('fa48c92e1fb14af5a11ca258429ba46c', '1', '37520c2078ec4a1c8a0778ca22bc8e17', '100', '480', '240', '47.95', '0', '2018-08-04 17:56:12', '2018-08-04 18:09:51', '2018-08-04 17:54:59');

-- ----------------------------
-- Table structure for `res_user_resource_record`
-- ----------------------------
DROP TABLE IF EXISTS `res_user_resource_record`;
CREATE TABLE `res_user_resource_record` (
  `ID` varchar(64) NOT NULL,
  `USER_RESOURCE_ID` varchar(64) DEFAULT NULL,
  `STUDY_TIME` int(11) NOT NULL DEFAULT '0',
  `APP_STUDY_TIME` int(11) NOT NULL DEFAULT '0',
  `STUDY_DAY` varchar(10) DEFAULT NULL,
  `HOUR` int(2) DEFAULT NULL,
  `START_LEARNING_DATE` timestamp NULL DEFAULT NULL,
  `END_LEARNING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_RESOURCE_ID` (`USER_RESOURCE_ID`),
  CONSTRAINT `res_user_resource_record_ibfk_1` FOREIGN KEY (`USER_RESOURCE_ID`) REFERENCES `res_user_resource` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res_user_resource_record
-- ----------------------------
INSERT INTO `res_user_resource_record` VALUES ('e926547aba52454fbc9c41fe503919c2', 'fa48c92e1fb14af5a11ca258429ba46c', '480', '300', '20180804', '18', '2018-08-04 18:03:00', '2018-08-04 18:09:51');
