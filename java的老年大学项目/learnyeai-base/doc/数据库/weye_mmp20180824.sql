/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : weye_mmp2

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2018-08-24 09:16:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aa`
-- ----------------------------
DROP TABLE IF EXISTS `aa`;
CREATE TABLE `aa` (
  `ID` varchar(64) NOT NULL COMMENT 'ID',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(500) DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  `PROC_INS_ID` varchar(64) DEFAULT NULL COMMENT '流程id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='AA';

-- ----------------------------
-- Records of aa
-- ----------------------------

-- ----------------------------
-- Table structure for `cfg_added_service`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_added_service`;
CREATE TABLE `cfg_added_service` (
  `AS_ID` varchar(64) NOT NULL COMMENT 'id',
  `AS_NAME` varchar(200) DEFAULT NULL COMMENT '增值服务名称',
  `AS_PRICE` decimal(9,0) DEFAULT NULL COMMENT '服务价格',
  `AS_CODE` varchar(64) DEFAULT NULL COMMENT '编码',
  `AS_STATUS` char(1) DEFAULT NULL COMMENT '状态：0未启用、1启用、2作废',
  `AS_DESC` varchar(500) DEFAULT NULL COMMENT '描述',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`AS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='增值服务';

-- ----------------------------
-- Records of cfg_added_service
-- ----------------------------
INSERT INTO `cfg_added_service` VALUES ('8c3a0af6c2b345baa2cf0617c81070c9', '2', '1', '1', '0', '222', '1', '2018-03-25 19:46:00', '1', '2018-04-08 11:36:44');
INSERT INTO `cfg_added_service` VALUES ('986b487268f7460aa614977916f9c614', '111w', '11', '去', '0', '', '1', '2018-03-25 19:38:43', '1', '2018-03-25 19:38:43');
INSERT INTO `cfg_added_service` VALUES ('a79a0a0815924847bc34c604110431f8', '123', '13', '13', '0', '', '1', '2018-03-25 20:08:53', '1', '2018-03-25 20:08:53');
INSERT INTO `cfg_added_service` VALUES ('ac117168a52b43f6af53923aeeb03b1c', '增值服务', '18', 'HF007', '0', '增值服务', '1', '2018-03-26 09:12:35', '1', '2018-03-26 09:12:35');
INSERT INTO `cfg_added_service` VALUES ('ba112859333e4c4da4b6f875462d5670', '增值', '12', 'HF12345', '0', '', '1', '2018-03-26 09:15:48', '1', '2018-03-26 09:15:48');
INSERT INTO `cfg_added_service` VALUES ('cb1812d90bd9485b89b574e3580a0fb8', '半价优惠', '12', 'HF002', '0', '价格半价', '1', '2018-03-25 19:35:07', '1', '2018-03-25 19:35:07');
INSERT INTO `cfg_added_service` VALUES ('d5d2053e364140419c05e58d61b5174e', '切切', '12', '231', '2', '1231', '1', '2018-03-25 19:57:51', '1', '2018-03-25 19:57:51');
INSERT INTO `cfg_added_service` VALUES ('d7ec9df6e1294cb39765c8ded7e3c576', '国庆大酬宾', '10', 'NCODE', '1', '122', '1', '2018-03-24 18:03:36', '1', '2018-03-24 18:03:36');
INSERT INTO `cfg_added_service` VALUES ('e03470e8c7574daea9a723b6ae0ecb28', '和谐', '12', 'HF002', '0', '', '1', '2018-03-25 19:56:01', '1', '2018-03-25 19:56:01');
INSERT INTO `cfg_added_service` VALUES ('e2d664b8e25e463a9482539fa2053a48', '五一黄金周', '150', 'HF0001', '0', '', '1', '2018-03-25 19:25:18', '1', '2018-03-25 19:26:48');

-- ----------------------------
-- Table structure for `cfg_applet`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_applet`;
CREATE TABLE `cfg_applet` (
  `APLT_ID` varchar(64) NOT NULL COMMENT 'id',
  `APLT_APP_ID` varchar(64) DEFAULT NULL COMMENT '小程序appid',
  `APLT_APP_SECRET` varchar(64) DEFAULT NULL COMMENT '小程序secret',
  `APLT_NAME` varchar(128) DEFAULT NULL COMMENT '小程序名称',
  `APLT_DESC` varchar(500) DEFAULT NULL COMMENT '小程序描述',
  `APLT_MDL_CODE` varchar(64) DEFAULT NULL COMMENT '模块编码',
  `APLT_VER_CODE` decimal(9,0) DEFAULT NULL COMMENT '版本编码',
  `APLT_VER_ID` varchar(64) DEFAULT NULL COMMENT '当前版本id',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '行业方案id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`APLT_ID`),
  KEY `IDX_CFG_APPLET` (`SCHM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序';

-- ----------------------------
-- Records of cfg_applet
-- ----------------------------
INSERT INTO `cfg_applet` VALUES ('395a4d8878e44267937ef562a3b45fba', '11', '111', '代言人', '11', '', '1', null, '21b7d32b42514d1da6518483504588b8', '1', '2018-03-07 15:25:13', '1', '2018-03-07 15:25:13', '0');
INSERT INTO `cfg_applet` VALUES ('d123efcd17ff4f0a88ca872addac3319', '11', '11', '111', '2', '23', '1', null, '25da08296ecf40e0a1a9f9ee108ece8e', '1', '2018-03-30 09:41:58', '1', '2018-03-30 09:41:58', '0');
INSERT INTO `cfg_applet` VALUES ('e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '', 'sell', '12', 'a2a57e22b7b04c9785e73dd4fbe26312', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-05 17:05:26', '1', '2018-03-05 17:05:26', '0');
INSERT INTO `cfg_applet` VALUES ('f1e6a41039504c77a3de7a9c0b6c5484', '', '', '企业通用的小程序', '', 'aa', '1', null, '10fe31b74bbb4e0b95f57adcf2995c99', '1', '2018-03-05 17:06:37', '1', '2018-03-05 17:06:37', '1');

-- ----------------------------
-- Table structure for `cfg_applet_version`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_applet_version`;
CREATE TABLE `cfg_applet_version` (
  `APLT_VER_ID` varchar(64) NOT NULL COMMENT 'id',
  `APLT_ID` varchar(64) DEFAULT NULL COMMENT '小程序id',
  `APLT_APP_ID` varchar(64) DEFAULT NULL COMMENT '小程序appid',
  `APLT_APP_SECRET` varchar(64) DEFAULT NULL COMMENT '小程序appsecret',
  `APLT_NAME` varchar(128) DEFAULT NULL COMMENT '小程序名称',
  `APLT_VER_CODE` decimal(9,0) DEFAULT NULL COMMENT '版本编码',
  `APLT_VER_NAME` varchar(20) DEFAULT NULL COMMENT '版本名称',
  `APLT_VER_DESC` varchar(500) DEFAULT NULL COMMENT '版本描述',
  `APLT_VER_STATUS` char(1) DEFAULT NULL COMMENT '商户升级信息添加状态：0未添加升级信息、1添加升级信息，所有关联此小程序方案版本都添加升级信息',
  `APLT_VER_ZIP_PATH` varchar(30) DEFAULT NULL COMMENT '用来备份代码',
  `APLT_VER_AUTO_ONLINE` char(1) DEFAULT NULL COMMENT '自动上线：0未开启、1开启，商户小程序是否自动上线',
  `APLT_VER_TEMPLATE_ID` varchar(64) DEFAULT NULL COMMENT '小程序代码模版ID',
  `APLT_VER_UPLOAD_NUM` decimal(5,0) DEFAULT NULL COMMENT '商户小程序上传代码数量',
  `APLT_VER_AUDIT_NUM` decimal(5,0) DEFAULT NULL COMMENT '商户小程序审核数量',
  `APLT_VER_PUB_NUM` decimal(5,0) DEFAULT NULL COMMENT '商户小程序发布数量',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '行业方案id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`APLT_VER_ID`),
  KEY `IDX_CFG_APPLET_VERSION_APLT` (`APLT_ID`),
  KEY `IDX_CFG_APPLET_VERSION_SCHMID` (`SCHM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序版本';

-- ----------------------------
-- Records of cfg_applet_version
-- ----------------------------
INSERT INTO `cfg_applet_version` VALUES ('85e77194e36a4406aaae09e55e4f9d14', 'e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '4', '1.01', 'aa', '0', '', '0', 'aa', '0', '0', '0', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-07 10:34:05');
INSERT INTO `cfg_applet_version` VALUES ('a2a57e22b7b04c9785e73dd4fbe26312', 'e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '12', '1.0.4', 'ttt', '0', null, '0', '3', '0', '0', '0', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-21 18:17:34');
INSERT INTO `cfg_applet_version` VALUES ('a9e5d2b725bf4bc7af26734655ca7ded', 'e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '3', '1.0', 'oooo', '1', '无', '1', '11', '0', '0', '0', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-06 16:01:06');
INSERT INTO `cfg_applet_version` VALUES ('c048227c5e864fbcb2e07f9b0238df7a', 'e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '9', '1.0.2', 'ttt', '0', null, '0', '2', '0', '0', '0', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-21 09:25:14');
INSERT INTO `cfg_applet_version` VALUES ('dee4c68deddc47f19df45b67dd1b3dd2', 'e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '10', '1.0.3', 'tt', '0', null, '0', '2', '0', '0', '0', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-21 10:53:11');
INSERT INTO `cfg_applet_version` VALUES ('e1dfbd9767fe44d79a52e93ffad045ae', 'e0a1d2c14608401f9b96d8a80e17d393', 'aapi', 'aa', '核销小程序', '11', '1.0.3', 'ttt', '0', null, '1', '2', '0', '0', '0', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-21 17:39:01');

-- ----------------------------
-- Table structure for `cfg_cust_table_manage`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_cust_table_manage`;
CREATE TABLE `cfg_cust_table_manage` (
  `COL_ID` varchar(64) NOT NULL COMMENT 'id',
  `COL_NAME` varchar(64) DEFAULT NULL COMMENT '字段名',
  `COL_DESC` varchar(64) DEFAULT NULL COMMENT '字段描述',
  `COL_SHOW` char(1) DEFAULT NULL COMMENT '0隐藏、1显示',
  `TABLE_TYPE` char(10) DEFAULT NULL COMMENT '1客户、2类型',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '方案id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`COL_ID`),
  KEY `IDX_CFG_CUST_TABLE_MANAGE_SCHM` (`SCHM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已有用户表字段管理，默认是显示';

-- ----------------------------
-- Records of cfg_cust_table_manage
-- ----------------------------

-- ----------------------------
-- Table structure for `cfg_funcpkg_func_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_funcpkg_func_rel`;
CREATE TABLE `cfg_funcpkg_func_rel` (
  `PKG_ID` varchar(64) NOT NULL COMMENT '功能包id',
  `FUNC_ID` varchar(64) NOT NULL COMMENT '功能id',
  PRIMARY KEY (`PKG_ID`,`FUNC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能包_功能关联表';

-- ----------------------------
-- Records of cfg_funcpkg_func_rel
-- ----------------------------
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('17e91a9f521249f28efba289f37c374d', '40acbce6a0134a24a8b20e95e80e04ad');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('17e91a9f521249f28efba289f37c374d', '9769da687c6847b2b3005c7145c795d6');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('17e91a9f521249f28efba289f37c374d', 'eac2c0ed8f2a43e7bef4d8b1755f5a5a');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('17e91a9f521249f28efba289f37c374d', 'ec70b603ed864e6cbef57756766d0662');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('1c80747af4134b58bce7c5cac9db6730', '4fe3b799b4eb48cd910df313c56557a3');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('1c80747af4134b58bce7c5cac9db6730', '54df2b703da149599adeff57680b254e');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '195eb52e6f224631b46f5c5bb3282d7b');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '87adefadf4da4daaa97bff7eb7148a4d');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('932943748ba44cd3803f6f97ae1611d5', '958cb21c0af04b339bcf6ed3ac1df1c1');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('932943748ba44cd3803f6f97ae1611d5', 'd2b77fb5cc8b45999819848aa4c5df52');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('ac1e4fd45eb942e5bcf2536e87affe36', '40acbce6a0134a24a8b20e95e80e04ad');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('ac1e4fd45eb942e5bcf2536e87affe36', 'eac2c0ed8f2a43e7bef4d8b1755f5a5a');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('ac1e4fd45eb942e5bcf2536e87affe36', 'ec70b603ed864e6cbef57756766d0662');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('d277afe8b37f484cbd1603de227584fa', '21bbd414324e41069ff8699fe7703036');
INSERT INTO `cfg_funcpkg_func_rel` VALUES ('d277afe8b37f484cbd1603de227584fa', 'ed0d4639457044a993ba6c5c7ad8bf97');

-- ----------------------------
-- Table structure for `cfg_function`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_function`;
CREATE TABLE `cfg_function` (
  `FUNC_ID` varchar(64) NOT NULL COMMENT '功能id',
  `FUNC_NAME` varchar(64) DEFAULT NULL COMMENT '功能名称',
  `FUNC_TYPE` char(1) DEFAULT NULL COMMENT '1后管、2前端',
  `FUNC_MNG_TYPE` char(1) DEFAULT '' COMMENT '1接口、2html',
  `FUNC_URL` varchar(256) DEFAULT NULL COMMENT 'url',
  `FUNC_PERMISSION` varchar(64) DEFAULT NULL COMMENT '权限标识',
  `FUNC_STATUS` char(1) DEFAULT NULL COMMENT '0禁用、1启用',
  `FUNC_SHOW_STATUS` char(1) DEFAULT NULL COMMENT '0隐藏、1显示',
  `PARENT_ID` varchar(64) DEFAULT NULL COMMENT '父节点',
  `PARENT_IDS` varchar(400) DEFAULT NULL COMMENT '所有父节点',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `SORT` decimal(4,0) DEFAULT NULL COMMENT '排序',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`FUNC_ID`),
  KEY `IDX_CFG_FUNCTION_FUNC_NAME` (`FUNC_NAME`),
  KEY `IDX_CFG_FUNC_FUNC_PERMISSION` (`FUNC_PERMISSION`),
  KEY `IDX_CFG_FUNCTION_PARENT_ID` (`PARENT_ID`),
  KEY `IDX_CFG_FUNCTION_PARENT_IDS` (`PARENT_IDS`(255)),
  KEY `IDX_CFG_FUNCTION_MDL_ID` (`MDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能';

-- ----------------------------
-- Records of cfg_function
-- ----------------------------
INSERT INTO `cfg_function` VALUES ('1', '功能菜单', '0', '1', null, null, null, null, '0', null, null, '1', null, null, null, null, '0');
INSERT INTO `cfg_function` VALUES ('195eb52e6f224631b46f5c5bb3282d7b', 'app-f2', '2', '1', '', '', null, null, '1', null, '59fd33c54da84426898be1ea44494853', '60', '1', '2018-01-30 17:26:25', '1', '2018-01-30 17:26:25', '0');
INSERT INTO `cfg_function` VALUES ('1b2b54c19ffc4a2d961d7f79d63ec879', 'f15', '1', '1', '11122', '11122-1', null, null, 'eac2c0ed8f2a43e7bef4d8b1755f5a5a', '1,eac2c0ed8f2a43e7bef4d8b1755f5a5a,', '59fd33c54da84426898be1ea44494853', '120', '1', '2018-08-18 15:46:01', '1', '2018-08-18 15:46:20', '0');
INSERT INTO `cfg_function` VALUES ('1f772fd2a9964bc0b7a5a245ab7303fb', '功能tt', '1', '1', '', '', null, null, '1', '1,', '59fd33c54da84426898be1ea44494853', '90', '1', '2018-01-30 16:40:39', '1', '2018-02-01 18:34:23', '1');
INSERT INTO `cfg_function` VALUES ('21bbd414324e41069ff8699fe7703036', 'f2', '1', '1', '', '', null, null, '1', '1,', '46b5060b90db40d28b78cca000f7d6cc', '60', '1', '2018-02-27 11:37:34', '1', '2018-02-27 11:37:34', '0');
INSERT INTO `cfg_function` VALUES ('40acbce6a0134a24a8b20e95e80e04ad', 'f12', '1', '1', '', '', null, null, 'eac2c0ed8f2a43e7bef4d8b1755f5a5a', '1,eac2c0ed8f2a43e7bef4d8b1755f5a5a,', '59fd33c54da84426898be1ea44494853', '30', '1', '2018-01-30 17:04:33', '1', '2018-02-27 10:44:38', '0');
INSERT INTO `cfg_function` VALUES ('4fe3b799b4eb48cd910df313c56557a3', 'f11', '1', '1', '', '', null, null, '54df2b703da149599adeff57680b254e', '1,54df2b703da149599adeff57680b254e,', '46b5060b90db40d28b78cca000f7d6cc', '30', '1', '2018-02-27 11:37:42', '1', '2018-02-27 11:37:42', '0');
INSERT INTO `cfg_function` VALUES ('54df2b703da149599adeff57680b254e', 'f1', '1', '1', '', '', null, null, '1', '1,', '46b5060b90db40d28b78cca000f7d6cc', '30', '1', '2018-02-27 11:37:29', '1', '2018-02-27 11:37:29', '0');
INSERT INTO `cfg_function` VALUES ('66fe887997b548159c151fbb71cbc3c4', 'app-f13', '2', '1', '', '', null, null, '87adefadf4da4daaa97bff7eb7148a4d', null, '59fd33c54da84426898be1ea44494853', '60', '1', '2018-01-30 17:26:56', '1', '2018-01-30 17:26:56', '1');
INSERT INTO `cfg_function` VALUES ('72c235cf05604757ad6b191ab5eb8f52', '添加角色', '1', '1', '/custRole/add.do', 'cfg:CustRole:add', '1', '0', 'f51107a11a2341458d4b249607382a05', '1,f51107a11a2341458d4b249607382a05,', '5ee65780503d4554b5562d44087a21c0', '30', '1', '2018-08-20 16:40:27', '1', '2018-08-20 16:42:08', '0');
INSERT INTO `cfg_function` VALUES ('73f7df58a68d42789f14c12cfc605341', 'f22', '1', '1', '', '', null, null, 'cb6521b878b1422a9d8fcc4554b2cdc7', '1,eac2c0ed8f2a43e7bef4d8b1755f5a5a,', '59fd33c54da84426898be1ea44494853', '60', '1', '2018-02-24 11:31:49', '1', '2018-02-24 11:31:49', '0');
INSERT INTO `cfg_function` VALUES ('746cdb761f3045249523b4ad90bb6a64', 'f21', '1', '1', '', '', null, null, 'cb6521b878b1422a9d8fcc4554b2cdc7', '1,eac2c0ed8f2a43e7bef4d8b1755f5a5a,', '59fd33c54da84426898be1ea44494853', '30', '1', '2018-02-24 11:31:42', '1', '2018-02-24 11:31:42', '0');
INSERT INTO `cfg_function` VALUES ('87adefadf4da4daaa97bff7eb7148a4d', 'app-f1', '2', '1', '', '', null, null, '1', null, '59fd33c54da84426898be1ea44494853', '30', '1', '2018-01-30 17:26:16', '1', '2018-01-30 17:26:16', '0');
INSERT INTO `cfg_function` VALUES ('8ad7a118b0d24c4b85703b2cabb4d0d3', 'f14', '1', '2', 'ccc', '', null, null, 'eac2c0ed8f2a43e7bef4d8b1755f5a5a', '1,eac2c0ed8f2a43e7bef4d8b1755f5a5a,', '59fd33c54da84426898be1ea44494853', '90', '1', '2018-03-19 16:02:34', '1', '2018-03-19 16:02:34', '0');
INSERT INTO `cfg_function` VALUES ('958cb21c0af04b339bcf6ed3ac1df1c1', '1', '1', '2', 'aaa', '', null, null, 'd2b77fb5cc8b45999819848aa4c5df52', '1,54df2b703da149599adeff57680b254e,4fe3b799b4eb48cd910df313c56557a3,d2b77fb5cc8b45999819848aa4c5df52,', 'c8ed8566c34644448ebe0e8df5aff802', '30', '1', '2018-03-19 16:00:26', '1', '2018-03-19 16:00:26', '0');
INSERT INTO `cfg_function` VALUES ('9769da687c6847b2b3005c7145c795d6', '测试功能', '1', '2', '', '', null, null, '1', '1,', '59fd33c54da84426898be1ea44494853', '60', '1', '2018-01-30 16:08:52', '1', '2018-02-01 18:34:42', '1');
INSERT INTO `cfg_function` VALUES ('cb6521b878b1422a9d8fcc4554b2cdc7', 'f2', '1', '1', '', '', null, null, '1', '1,', '59fd33c54da84426898be1ea44494853', '60', '1', '2018-02-24 11:30:51', '1', '2018-02-24 11:30:51', '0');
INSERT INTO `cfg_function` VALUES ('d2b77fb5cc8b45999819848aa4c5df52', '测试模块1', '1', '2', '', '', null, null, '4fe3b799b4eb48cd910df313c56557a3', '1,54df2b703da149599adeff57680b254e,4fe3b799b4eb48cd910df313c56557a3,', 'c8ed8566c34644448ebe0e8df5aff802', '30', '1', '2018-03-19 15:45:09', '1', '2018-03-19 15:45:09', '0');
INSERT INTO `cfg_function` VALUES ('e4ef65510a48442ab929c3d02967fd17', 'aff-f12', '2', '1', '', '', null, null, '87adefadf4da4daaa97bff7eb7148a4d', null, '59fd33c54da84426898be1ea44494853', '30', '1', '2018-01-30 17:26:40', '1', '2018-01-30 17:26:40', '1');
INSERT INTO `cfg_function` VALUES ('eac2c0ed8f2a43e7bef4d8b1755f5a5a', 'f1', '1', '2', '11122', '11122', null, null, '1', '1,', '59fd33c54da84426898be1ea44494853', '30', '1', '2018-01-30 14:12:24', '1', '2018-02-01 18:34:13', '0');
INSERT INTO `cfg_function` VALUES ('ec70b603ed864e6cbef57756766d0662', 'f13', '1', '2', '', '', null, null, 'eac2c0ed8f2a43e7bef4d8b1755f5a5a', '1,eac2c0ed8f2a43e7bef4d8b1755f5a5a,', '59fd33c54da84426898be1ea44494853', '60', '1', '2018-01-30 17:04:48', '1', '2018-02-01 18:34:32', '0');
INSERT INTO `cfg_function` VALUES ('ed0d4639457044a993ba6c5c7ad8bf97', 'f21', '1', '1', '', '', null, null, '21bbd414324e41069ff8699fe7703036', '1,21bbd414324e41069ff8699fe7703036,', '46b5060b90db40d28b78cca000f7d6cc', '30', '1', '2018-02-27 11:37:52', '1', '2018-02-27 11:37:52', '0');
INSERT INTO `cfg_function` VALUES ('f51107a11a2341458d4b249607382a05', '角色管理', '1', '2', '/roleList.html', 'cfg:CustRole:list', null, '1', '1', '1,', '5ee65780503d4554b5562d44087a21c0', '30', '1', '2018-08-20 16:39:00', '1', '2018-08-20 16:39:00', '0');
INSERT INTO `cfg_function` VALUES ('f8e0df5e2c8343dc859273c96c3983d9', '删除角色', '1', '1', '/custRole/delete.do', 'cfg:CustRole:del', null, '0', 'f51107a11a2341458d4b249607382a05', '1,f51107a11a2341458d4b249607382a05,', '5ee65780503d4554b5562d44087a21c0', '60', '1', '2018-08-20 16:41:52', '1', '2018-08-20 16:41:52', '0');

-- ----------------------------
-- Table structure for `cfg_function_package`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_function_package`;
CREATE TABLE `cfg_function_package` (
  `PKG_ID` varchar(64) NOT NULL COMMENT '功能包id',
  `PKG_NAME` varchar(64) DEFAULT NULL COMMENT '功能包名称',
  `PKG_DESC` varchar(500) DEFAULT NULL COMMENT '功能包描述',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `PKG_STATUS` char(1) DEFAULT NULL COMMENT '0禁用、1启用',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`PKG_ID`),
  KEY `IDX_CFG_FUNC_PACKAGE_MDL_ID` (`MDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能包';

-- ----------------------------
-- Records of cfg_function_package
-- ----------------------------
INSERT INTO `cfg_function_package` VALUES ('0ebdb9465ce24fbe937a6d99187d6210', 'dyr包1', '', 'aa8fa7d8f95842008b037463955957d7', '0', '1', '2018-02-01 16:34:02', '1', '2018-02-01 16:34:02', '1');
INSERT INTO `cfg_function_package` VALUES ('17e91a9f521249f28efba289f37c374d', '核销包1', 'ttt', '59fd33c54da84426898be1ea44494853', '1', '1', '2018-02-01 12:03:40', '1', '2018-02-01 12:04:29', '0');
INSERT INTO `cfg_function_package` VALUES ('1c80747af4134b58bce7c5cac9db6730', '企业通用1', '', '46b5060b90db40d28b78cca000f7d6cc', '1', '1', '2018-02-27 11:38:23', '1', '2018-02-27 11:40:48', '0');
INSERT INTO `cfg_function_package` VALUES ('36d92639dd5b42909681a1d08f6e7cf7', 'dyr包2', '', 'aa8fa7d8f95842008b037463955957d7', '1', '1', '2018-02-01 16:34:11', '1', '2018-02-01 16:34:53', '0');
INSERT INTO `cfg_function_package` VALUES ('55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '核销包2', '', '59fd33c54da84426898be1ea44494853', '1', '1', '2018-02-01 13:12:24', '1', '2018-02-01 13:12:24', '0');
INSERT INTO `cfg_function_package` VALUES ('932943748ba44cd3803f6f97ae1611d5', 'c1', '', 'c8ed8566c34644448ebe0e8df5aff802', null, '1', '2018-03-19 16:51:22', '1', '2018-03-19 16:51:43', '0');
INSERT INTO `cfg_function_package` VALUES ('9af101af096343d4bcc2256c9c2c7c29', '测试1', '测试1111', '1cfed0fcc3e84bdda475401cdb205223', '0', '1', '2018-03-19 15:32:43', '1', '2018-03-19 15:32:43', '0');
INSERT INTO `cfg_function_package` VALUES ('a704603969aa43ccb41abdd98096b21d', 'test1', '', '1cfed0fcc3e84bdda475401cdb205223', null, '1', '2018-02-27 10:56:53', '1', '2018-02-27 10:56:53', '0');
INSERT INTO `cfg_function_package` VALUES ('ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', '3333444', '59fd33c54da84426898be1ea44494853', '1', '1', '2018-02-02 13:43:12', '1', '2018-02-02 13:48:18', '0');
INSERT INTO `cfg_function_package` VALUES ('d277afe8b37f484cbd1603de227584fa', '企业通用2', '', '46b5060b90db40d28b78cca000f7d6cc', '1', '1', '2018-02-27 11:38:59', '1', '2018-02-27 11:40:59', '0');

-- ----------------------------
-- Table structure for `cfg_module`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_module`;
CREATE TABLE `cfg_module` (
  `MDL_ID` varchar(64) NOT NULL COMMENT '模块id',
  `MDL_CODE` varchar(64) DEFAULT NULL COMMENT '模块编码',
  `MDL_NAME` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `MDL_STATUS` char(1) DEFAULT NULL COMMENT '0禁用、1启用',
  `MDL_STAFF_TABLE_NAME` varchar(64) DEFAULT NULL COMMENT '员工扩展表名',
  `MDL_USER_TABLE_NAME` varchar(64) DEFAULT NULL COMMENT '用户表扩展名',
  `MDL_SERVER_CONTEXT` varchar(64) DEFAULT NULL COMMENT '模块上下文',
  `MDL_VER_NAME` varchar(20) DEFAULT NULL COMMENT '版本号',
  `MDL_VER_CODE` decimal(9,0) DEFAULT NULL COMMENT '版本编码',
  `MDL_VER_ID` varchar(64) DEFAULT NULL COMMENT '版本id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`MDL_ID`),
  KEY `IDX_CFG_MODULE_MDL_CODE` (`MDL_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块';

-- ----------------------------
-- Records of cfg_module
-- ----------------------------
INSERT INTO `cfg_module` VALUES ('1cfed0fcc3e84bdda475401cdb205223', 'test', '测试模块', null, '', '', '', null, null, null, '1', '2018-02-05 16:02:57', '1', '2018-02-05 16:02:57', '0');
INSERT INTO `cfg_module` VALUES ('46b5060b90db40d28b78cca000f7d6cc', 'qyty', '企业通用', null, '', '', 'qyty', null, null, null, '1', '2018-02-27 11:36:51', '1', '2018-02-27 11:36:51', '0');
INSERT INTO `cfg_module` VALUES ('59fd33c54da84426898be1ea44494853', 'sell', '核销', '0', 'CUST_INFO_SELL', 'CUST_USER_SELL', 'SellApiWeb', '测试模块', '3', '0d4ad9753e4d4c249584f934b0d06f9b', '1', '2018-01-25 14:21:43', '1', '2018-01-25 17:15:06', '0');
INSERT INTO `cfg_module` VALUES ('5ee65780503d4554b5562d44087a21c0', 'base', '基础服务', null, '', '', '', '1', '1', '41af2df904e0477d847b2bdab8d0fef9', '1', '2018-08-20 16:18:54', '1', '2018-08-20 16:18:54', '0');
INSERT INTO `cfg_module` VALUES ('aa8fa7d8f95842008b037463955957d7', 'dyr', 'dyr', '0', '', '', '', 'v1.0.0', '1', '3b86a0580d214acd88ba82d602006d20', '1', '2018-01-25 16:29:38', '1', '2018-01-25 17:15:15', '0');
INSERT INTO `cfg_module` VALUES ('c8ed8566c34644448ebe0e8df5aff802', 'yl', '测试模块1', null, '', '', '', null, null, null, '1', '2018-03-19 15:34:32', '1', '2018-03-19 15:34:32', '0');

-- ----------------------------
-- Table structure for `cfg_module_version`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_module_version`;
CREATE TABLE `cfg_module_version` (
  `MDL_VER_ID` varchar(64) NOT NULL COMMENT 'id',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `MDL_NAME` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `MDL_VER_NAME` varchar(20) DEFAULT NULL COMMENT '版本号',
  `MDL_VER_CODE` decimal(9,0) DEFAULT NULL COMMENT '版本编码',
  `MDL_VER_DESC` varchar(1000) DEFAULT NULL COMMENT '版本内容',
  `MDL_VER_DATE` datetime DEFAULT NULL COMMENT '版本日期',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`MDL_VER_ID`),
  KEY `IDX_CFG_MODULE_VERSION_MDLID` (`MDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块版本';

-- ----------------------------
-- Records of cfg_module_version
-- ----------------------------
INSERT INTO `cfg_module_version` VALUES ('0d4ad9753e4d4c249584f934b0d06f9b', '59fd33c54da84426898be1ea44494853', '核销', '测试模块', '3', '', '2018-02-05 00:00:00', '1', '2018-02-05 16:02:34');
INSERT INTO `cfg_module_version` VALUES ('2289f330b0884f51899f999b557834f2', '59fd33c54da84426898be1ea44494853', null, 'v1.0.0', '1', '初始版本', '2018-01-29 00:00:00', '1', '2018-01-29 10:12:42');
INSERT INTO `cfg_module_version` VALUES ('3b86a0580d214acd88ba82d602006d20', 'aa8fa7d8f95842008b037463955957d7', 'dyr', 'v1.0.0', '1', 'tt', '2018-01-29 00:00:00', '1', '2018-01-29 10:16:09');
INSERT INTO `cfg_module_version` VALUES ('41af2df904e0477d847b2bdab8d0fef9', '5ee65780503d4554b5562d44087a21c0', '基础服务', '1', '1', '111', '2018-08-20 00:00:00', '1', '2018-08-20 17:25:30');
INSERT INTO `cfg_module_version` VALUES ('a94e3b059b17457192a9054587ae37e6', '59fd33c54da84426898be1ea44494853', '核销', 'v1.0.1', '2', '测试', '2018-01-29 00:00:00', '1', '2018-01-29 10:14:53');

-- ----------------------------
-- Table structure for `cfg_scheme`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_scheme`;
CREATE TABLE `cfg_scheme` (
  `SCHM_ID` varchar(64) NOT NULL COMMENT '行业方案id',
  `SCHM_NAME` varchar(128) DEFAULT NULL COMMENT '行业方案名称',
  `SCHM_PHOTO` varchar(30) DEFAULT NULL COMMENT '图片',
  `SCHM_BRIEF` varchar(500) DEFAULT NULL COMMENT '方案概要',
  `SCHM_DESC` varchar(3000) DEFAULT NULL COMMENT '方案描述',
  `SCHM_INDUSTRY` varchar(64) DEFAULT NULL COMMENT '行业',
  `SCHM_IMGS` varchar(300) DEFAULT NULL COMMENT '图片集',
  `SCHM_STATUS` char(1) DEFAULT NULL COMMENT '0未发布、1已发布',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`SCHM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业方案';

-- ----------------------------
-- Records of cfg_scheme
-- ----------------------------
INSERT INTO `cfg_scheme` VALUES ('10fe31b74bbb4e0b95f57adcf2995c99', '企业通用', null, 'aab', 'bb', '1', null, '1', '1', '2018-02-27 11:39:42', '1', '2018-03-19 16:12:12', '0');
INSERT INTO `cfg_scheme` VALUES ('21b7d32b42514d1da6518483504588b8', '核销', null, null, '', '1', null, '1', '1', '2018-02-05 11:37:40', '1', '2018-02-05 11:37:40', '0');
INSERT INTO `cfg_scheme` VALUES ('25da08296ecf40e0a1a9f9ee108ece8e', 'yl测试', null, '教培', '', '2', null, '1', '1', '2018-03-29 17:55:48', '1', '2018-03-29 17:55:48', '0');
INSERT INTO `cfg_scheme` VALUES ('93c64bb38dde41f4840dd524e872a54a', '老年大学', null, '', '', '2', null, '1', '1', '2018-08-20 16:51:39', '1', '2018-08-20 16:51:39', '0');
INSERT INTO `cfg_scheme` VALUES ('e70d53d91b334bffa55a1ae5951d714c', 'yl计算', null, '', '', '1', null, '1', '1', '2018-04-08 11:25:37', '1', '2018-04-08 11:25:37', '0');

-- ----------------------------
-- Table structure for `cfg_scheme_edition`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_scheme_edition`;
CREATE TABLE `cfg_scheme_edition` (
  `SCHM_EDT_ID` varchar(64) NOT NULL COMMENT '方案版本id',
  `SCHM_EDT_NAME` varchar(256) DEFAULT NULL COMMENT '方案版本名称',
  `SCHM_EDT_DESC` varchar(2000) DEFAULT NULL COMMENT '版本描述',
  `SCHM_EDT_PHOTO` varchar(30) DEFAULT NULL COMMENT '图片',
  `SCHM_EDT_STATUS` char(1) DEFAULT NULL COMMENT '状态0未发布、1发布，发布后用户可以看见',
  `SCHM_ENABLE_STATUS` char(1) DEFAULT NULL COMMENT '启用状态 0未启用、1启用，版本是否可用',
  `SCHM_EDT_MOD_STATUS` char(1) DEFAULT NULL COMMENT '编辑状态0未编辑、1修改版本信息、2修改功能包、3版本信息功能包都修改了',
  `SCHM_EDT_GRADE` decimal(9,0) DEFAULT NULL COMMENT '版本级别，版本历史级别',
  `SCHM_EDT_CODE` decimal(9,0) DEFAULT NULL COMMENT '商户升级信息编码',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '方案id',
  `SCHM_EDT_HIS_ID` varchar(64) DEFAULT NULL COMMENT '方案版本历史的id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`SCHM_EDT_ID`),
  KEY `IDX_CFG_SCHEME_EDITION_SCHM_ID` (`SCHM_ID`),
  KEY `IDX_CFG_SCHEME_EDITION__NAME` (`SCHM_EDT_NAME`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本';

-- ----------------------------
-- Records of cfg_scheme_edition
-- ----------------------------
INSERT INTO `cfg_scheme_edition` VALUES ('08c0a69a74254da4a317f0eee6a58164', 'yl方案版本', '测试价格', null, '1', '1', '0', '1', '8', 'e70d53d91b334bffa55a1ae5951d714c', '8f47591a92514aac80d0754772bb62b0', '1', '2018-04-08 11:26:41', '1', '2018-04-08 11:26:41', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('1', '核销系统-基础版', '112233', null, '1', '1', '2', '12', '5', '21b7d32b42514d1da6518483504588b8', 'cf9ab6961c1948b49b7a37404d6008c9', null, null, '1', '2018-02-24 12:02:22', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('30a2cd33344c45bbb8b894e6153d67cc', '33', '', null, '1', null, null, '0', null, '21b7d32b42514d1da6518483504588b8', null, '1', '2018-02-06 17:08:41', '1', '2018-02-06 17:08:41', '1');
INSERT INTO `cfg_scheme_edition` VALUES ('3498943c97f047a9bcec79a4759238a9', 'yl方案版本测试', '方案版本测试', null, '0', '1', '0', '1', null, '25da08296ecf40e0a1a9f9ee108ece8e', '54f18aacf43a46cbaef6dc15a2dfa94b', '1', '2018-03-29 17:56:41', '1', '2018-03-29 17:56:41', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('3a5ec231d7494d52aad3d9989fba4711', '版本1', '', null, '0', '1', '3', '0', null, '25da08296ecf40e0a1a9f9ee108ece8e', null, '1', '2018-03-30 09:42:15', '1', '2018-03-30 09:42:15', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('534b28cbd1c8453792315966670b4e0c', '企业通用-基础', '111', null, '0', '0', '1', '1', '3', '10fe31b74bbb4e0b95f57adcf2995c99', 'e926fc6096ca49e1bfa6f19248d53dd9', '1', '2018-02-27 11:40:33', '1', '2018-03-19 15:01:47', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('63c038db251c469d9686b6823f6f38f7', '44', '222', null, '1', null, null, null, null, '21b7d32b42514d1da6518483504588b8', null, '1', '2018-02-06 17:10:31', '1', '2018-02-06 17:11:58', '1');
INSERT INTO `cfg_scheme_edition` VALUES ('8bc9c1e84e2d4cd880510b13c321a93f', '核销test', '11', null, '0', '1', '1', '1', '2', '21b7d32b42514d1da6518483504588b8', '701f1278f5f546e9bdc3b5f703bd11e4', '1', '2018-02-24 17:48:33', '1', '2018-02-26 16:06:31', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('96a639f2acaa420088a9f831d4fb7fb1', '老年大学-通用版', '', null, '1', '1', '0', '1', '2', '93c64bb38dde41f4840dd524e872a54a', '968c983ff8b246b48528cb9cf5931bd8', '1', '2018-08-20 16:54:39', '1', '2018-08-20 16:54:39', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('982c5410003c4ee0bdce19356caf0b00', '测试版本1', 'aaab', null, '1', '1', '0', '2', '2', '10fe31b74bbb4e0b95f57adcf2995c99', 'b21bd15dd36f4690af80179f3cf02f3d', '1', '2018-03-19 15:57:37', '1', '2018-03-19 16:45:15', '0');
INSERT INTO `cfg_scheme_edition` VALUES ('c7454d379ac7460dae27c5d48ef410f1', '22', '11122', null, '0', '1', '0', '5', '2', '21b7d32b42514d1da6518483504588b8', '2cb2fc66195945208ebd300ddaa056d8', '1', '2018-02-06 17:08:13', '1', '2018-02-12 17:47:43', '0');

-- ----------------------------
-- Table structure for `cfg_scheme_edition_aplt_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_scheme_edition_aplt_rel`;
CREATE TABLE `cfg_scheme_edition_aplt_rel` (
  `SCHM_EDT_ID` varchar(64) NOT NULL COMMENT '方案版本id',
  `APLT_ID` varchar(64) NOT NULL COMMENT '小程序id',
  PRIMARY KEY (`SCHM_EDT_ID`,`APLT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本小程序关联表';

-- ----------------------------
-- Records of cfg_scheme_edition_aplt_rel
-- ----------------------------
INSERT INTO `cfg_scheme_edition_aplt_rel` VALUES ('1', 'e0a1d2c14608401f9b96d8a80e17d393');
INSERT INTO `cfg_scheme_edition_aplt_rel` VALUES ('8bc9c1e84e2d4cd880510b13c321a93f', 'e0a1d2c14608401f9b96d8a80e17d393');
INSERT INTO `cfg_scheme_edition_aplt_rel` VALUES ('c7454d379ac7460dae27c5d48ef410f1', '395a4d8878e44267937ef562a3b45fba');

-- ----------------------------
-- Table structure for `cfg_scheme_edition_his`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_scheme_edition_his`;
CREATE TABLE `cfg_scheme_edition_his` (
  `SCHM_EDT_HIS_ID` varchar(64) NOT NULL COMMENT '方案版本历史id',
  `SCHM_EDT_HIS_STATUS` char(1) DEFAULT NULL COMMENT '版本状态：0未添加升级信息 1已添加升级信息',
  `SCHM_EDT_HIS_REMARK` varchar(1000) DEFAULT NULL COMMENT '版本升级备注',
  `SCHM_EDT_MOD_STATUS` char(1) DEFAULT NULL COMMENT '编辑状态0未编辑、1修改版本信息、2修改功能包、3版本信息功能包都修改了',
  `SCHM_EDT_ID` varchar(64) NOT NULL COMMENT '方案版本id',
  `SCHM_EDT_NAME` varchar(256) DEFAULT NULL COMMENT '方案版本名称',
  `SCHM_EDT_DESC` varchar(2000) DEFAULT NULL COMMENT '版本描述',
  `SCHM_EDT_PHOTO` varchar(30) DEFAULT NULL COMMENT '图片',
  `SCHM_EDT_GRADE` decimal(9,0) DEFAULT NULL COMMENT '版本级别',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '方案id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`SCHM_EDT_HIS_ID`),
  KEY `IDX_CFG_SCHEME_EDITIONHIS_SCHM_ID` (`SCHM_ID`),
  KEY `IDX_CFG_SCHEME_EDITIONHIS_EDTID` (`SCHM_EDT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本历史';

-- ----------------------------
-- Records of cfg_scheme_edition_his
-- ----------------------------
INSERT INTO `cfg_scheme_edition_his` VALUES ('08e90fa0140247daaf2e2fe52fcf110a', '0', '777', '1', '1', '核销系统-基础版', '112233', null, '8', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:01');
INSERT INTO `cfg_scheme_edition_his` VALUES ('14421edb06db4c0a8b8b543a17bce5b6', '0', '111111111111', '0', 'c7454d379ac7460dae27c5d48ef410f1', '22', '11122', null, '4', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-12 17:47:49');
INSERT INTO `cfg_scheme_edition_his` VALUES ('2cb2fc66195945208ebd300ddaa056d8', '0', '2222222222222', '1', 'c7454d379ac7460dae27c5d48ef410f1', '22', '11122', null, '5', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:03');
INSERT INTO `cfg_scheme_edition_his` VALUES ('54f18aacf43a46cbaef6dc15a2dfa94b', '0', '', '3', '3498943c97f047a9bcec79a4759238a9', 'yl方案版本测试', '方案版本测试', null, '1', '25da08296ecf40e0a1a9f9ee108ece8e', '1', '2018-04-12 17:32:34');
INSERT INTO `cfg_scheme_edition_his` VALUES ('701f1278f5f546e9bdc3b5f703bd11e4', '0', 'iiii', '1', '8bc9c1e84e2d4cd880510b13c321a93f', '核销test', '', null, '1', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:03');
INSERT INTO `cfg_scheme_edition_his` VALUES ('75b07ee661894f5a8a5a6ebfbc88ad04', '0', 'ooo', '1', '1', '核销系统-基础版', '112233', null, '5', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:04');
INSERT INTO `cfg_scheme_edition_his` VALUES ('82a8122f8bc040ce94cc9437a82c7223', '0', 'pp', '1', '1', '核销系统-基础版', '112233', null, '11', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:05');
INSERT INTO `cfg_scheme_edition_his` VALUES ('8759601d28a540519e60ce2e412819f5', '0', '222', '1', 'c7454d379ac7460dae27c5d48ef410f1', '22', '11122', null, '3', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:05');
INSERT INTO `cfg_scheme_edition_his` VALUES ('8f47591a92514aac80d0754772bb62b0', '0', '1', '3', '08c0a69a74254da4a317f0eee6a58164', 'yl方案版本', '测试价格', null, '1', 'e70d53d91b334bffa55a1ae5951d714c', '1', '2018-04-08 11:35:46');
INSERT INTO `cfg_scheme_edition_his` VALUES ('90318710e4fd4af7a69709dc8f0b40c7', '0', '111', '1', 'c7454d379ac7460dae27c5d48ef410f1', '22', '111', null, '2', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:06');
INSERT INTO `cfg_scheme_edition_his` VALUES ('94bb445611ff4111bea2eea36929f5b1', '0', 'ppp', '1', '1', '核销系统-基础版', '112233', null, '6', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:06');
INSERT INTO `cfg_scheme_edition_his` VALUES ('968c983ff8b246b48528cb9cf5931bd8', '1', '测试', '3', '96a639f2acaa420088a9f831d4fb7fb1', '老年大学-通用版', '', null, '1', '93c64bb38dde41f4840dd524e872a54a', '1', '2018-08-20 16:57:44');
INSERT INTO `cfg_scheme_edition_his` VALUES ('9cc58c63cd2c4d869992172eacd59102', '0', 'pp', '1', '1', '核销系统-基础版', '112233', null, '9', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:07');
INSERT INTO `cfg_scheme_edition_his` VALUES ('b21bd15dd36f4690af80179f3cf02f3d', '0', '', '1', '982c5410003c4ee0bdce19356caf0b00', '测试版本1', 'aaab', null, '2', '10fe31b74bbb4e0b95f57adcf2995c99', '1', '2018-03-19 16:46:34');
INSERT INTO `cfg_scheme_edition_his` VALUES ('c14b40b443b841a78970cab05c9ef3fa', '0', '11', '1', '1', '核销系统-基础版', '112233', null, '10', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-27 17:53:07');
INSERT INTO `cfg_scheme_edition_his` VALUES ('cf7f23e445ef4d7c82310daa4b571832', '1', '111', '3', '982c5410003c4ee0bdce19356caf0b00', '测试版本1', 'aaa', null, '1', '10fe31b74bbb4e0b95f57adcf2995c99', '1', '2018-03-19 16:46:25');
INSERT INTO `cfg_scheme_edition_his` VALUES ('cf9ab6961c1948b49b7a37404d6008c9', '1', '11', '1', '1', '核销系统-基础版', '112233', null, '12', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-03 18:13:29');
INSERT INTO `cfg_scheme_edition_his` VALUES ('e926fc6096ca49e1bfa6f19248d53dd9', '1', 'ttt', '1', '534b28cbd1c8453792315966670b4e0c', '企业通用-基础', '', null, '1', '10fe31b74bbb4e0b95f57adcf2995c99', '1', '2018-03-03 18:07:21');
INSERT INTO `cfg_scheme_edition_his` VALUES ('fa2621e9d45648c681b5ac4652d0bfa3', '0', '11111', '0', '1', '核销系统-基础版', '112233', null, '4', '21b7d32b42514d1da6518483504588b8', '1', '2018-02-24 17:15:03');
INSERT INTO `cfg_scheme_edition_his` VALUES ('ff3b33a32b174dd4bff7d63192f836c9', '1', 'ooo', '1', '1', '核销系统-基础版', '112233', null, '7', '21b7d32b42514d1da6518483504588b8', '1', '2018-03-03 18:07:01');

-- ----------------------------
-- Table structure for `cfg_scheme_edition_price`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_scheme_edition_price`;
CREATE TABLE `cfg_scheme_edition_price` (
  `EDT_PRC_ID` varchar(64) NOT NULL COMMENT 'id',
  `SCHM_EDT_ID` varchar(64) DEFAULT NULL COMMENT '方案版本id',
  `EDT_PRC_NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `EDT_PRC_YEAR_PRICE` decimal(9,0) DEFAULT NULL COMMENT '年价格',
  `EDT_PRC_MONTH_PRICE` decimal(9,0) DEFAULT NULL COMMENT '月价格',
  `EDT_PRC_STORE_NUM` decimal(5,0) DEFAULT NULL COMMENT '门店数',
  `EDT_PRC_STATUS` char(1) DEFAULT NULL COMMENT '状态：0禁用、1启用、作废',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记 0正常 1 删除',
  PRIMARY KEY (`EDT_PRC_ID`),
  KEY `IDX_SCHEME_EDT_PRC_SCHM_EDT` (`SCHM_EDT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本价格';

-- ----------------------------
-- Records of cfg_scheme_edition_price
-- ----------------------------
INSERT INTO `cfg_scheme_edition_price` VALUES ('a8227709bbd04f819928354af90fb4dc', '1', '核销价格', '110', '10', '1', '1', '1', '2018-04-12 18:06:20', '1', '2018-04-12 18:06:20', '0');

-- ----------------------------
-- Table structure for `cfg_scheme_edition_update_info`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_scheme_edition_update_info`;
CREATE TABLE `cfg_scheme_edition_update_info` (
  `EDT_UP_ID` varchar(64) NOT NULL COMMENT 'id',
  `SCHM_EDT_ID` varchar(64) NOT NULL COMMENT '方案版本id',
  `SCHM_EDT_CODE` decimal(9,0) DEFAULT NULL COMMENT '版本编码',
  `EDT_UP_VER_NAME` varchar(256) DEFAULT NULL COMMENT '版本名称',
  `EDT_UP_VER_DATE` datetime DEFAULT NULL COMMENT '版本时间',
  `EDT_UP_CONTENT` varchar(3000) DEFAULT NULL COMMENT '升级内容',
  `EDT_UP_TYPE` char(1) DEFAULT '' COMMENT '1版本升级、2小程序升级、3自定义升级',
  `EDT_UP_OBJ_ID` varchar(64) DEFAULT NULL COMMENT '对象id，类型是版本时是方案版本历史id小程序时是小程序版本id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`EDT_UP_ID`),
  KEY `IDX_CFG_SCHEME_EDITIONHIS_EDTID` (`SCHM_EDT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本升级信息';

-- ----------------------------
-- Records of cfg_scheme_edition_update_info
-- ----------------------------
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('0373b9fc30204c9089715279a568d88f', '534b28cbd1c8453792315966670b4e0c', '2', '1.2', '2018-03-03 00:00:00', 'tt', '1', 'e926fc6096ca49e1bfa6f19248d53dd9', '1', '2018-03-03 18:07:21');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('19f1db6913d6486197f4d5d8a77d89f9', '534b28cbd1c8453792315966670b4e0c', '3', '1.3.03', '2018-03-07 00:00:00', 'tt', '3', '', '1', '2018-03-07 09:50:00');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('3bd6492db2224adf9654855a44ca1750', '08c0a69a74254da4a317f0eee6a58164', '2', '11', '2018-04-26 00:00:00', '111', '3', '', '1', '2018-04-26 09:57:45');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('4f6f6dec1def472787a2da40c0ebbaf6', '08c0a69a74254da4a317f0eee6a58164', '3', '112', '2018-04-26 00:00:00', '222', '3', '', '1', '2018-04-26 09:59:12');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('5016194c01c544cd9afb70f0c2d702ca', '08c0a69a74254da4a317f0eee6a58164', '7', '222', '2018-04-26 00:00:00', '222', '3', '', '1', '2018-04-26 11:24:50');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('5d0fcc6a714940a99a3bf3dad09a11a0', '982c5410003c4ee0bdce19356caf0b00', '2', '1.0', '2018-03-07 00:00:00', '第一次', '1', 'cf7f23e445ef4d7c82310daa4b571832', '1', '2018-03-19 16:46:25');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('7b36e0334c2045728c9c2a2b06e33fbd', '96a639f2acaa420088a9f831d4fb7fb1', '2', '1', '2018-08-20 00:00:00', '111', '1', '968c983ff8b246b48528cb9cf5931bd8', '1', '2018-08-20 17:23:35');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('8de0a46de192451bba6cead77f36c6d1', '1', '3', '1.3', '2018-03-03 00:00:00', 'uuu', '1', 'cf9ab6961c1948b49b7a37404d6008c9', '1', '2018-03-03 18:13:29');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('979ead8c60974b199370d21bf0d83bb7', '1', '2', '1.1', '2018-03-02 00:00:00', 'ttt', '1', 'ff3b33a32b174dd4bff7d63192f836c9', '1', '2018-03-03 18:07:04');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('a82fbf2274c04f5cb6bc3c35df783fa8', '08c0a69a74254da4a317f0eee6a58164', '6', '888', '2018-04-26 00:00:00', '888', '3', '', '1', '2018-04-26 11:10:15');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('abc3ad935d2f434b99797d7d512a6d7d', '1', '5', '1.3.02', '2018-03-07 00:00:00', 'tt', '3', '', '1', '2018-03-07 08:40:16');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('ba7f60c1621e461990ffc4d281f6c05f', '08c0a69a74254da4a317f0eee6a58164', '5', '66', '2018-04-26 00:00:00', '66', '3', '', '1', '2018-04-26 10:12:41');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('c31094570e8c4d9d94413dd78e77165a', '8bc9c1e84e2d4cd880510b13c321a93f', '2', '1.1', '2018-03-06 00:00:00', '11', '2', 'a9e5d2b725bf4bc7af26734655ca7ded', '1', '2018-03-06 18:03:08');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('c53988e41fca4af09a0ac879734d9c93', '1', '2', '1.0', '2018-03-01 00:00:00', '111', '1', 'ff3b33a32b174dd4bff7d63192f836c9', '1', '2018-03-03 17:58:28');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('e1837f89e5434234b1522a9737eb8713', '1', '4', '1.1', '2018-03-06 00:00:00', '11', '2', 'a9e5d2b725bf4bc7af26734655ca7ded', '1', '2018-03-06 18:03:08');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('f85090857ee848e5ab51a492b3aef051', '08c0a69a74254da4a317f0eee6a58164', '4', '33', '2018-04-26 00:00:00', '333', '3', '', '1', '2018-04-26 10:11:06');
INSERT INTO `cfg_scheme_edition_update_info` VALUES ('ff2259167ee0494ca270bd94f3a6edff', '08c0a69a74254da4a317f0eee6a58164', '8', '77', '2018-04-26 00:00:00', '777', '3', '', '1', '2018-04-26 11:25:12');

-- ----------------------------
-- Table structure for `cfg_schm_edt_package`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_schm_edt_package`;
CREATE TABLE `cfg_schm_edt_package` (
  `EDT_PKG_ID` varchar(64) NOT NULL COMMENT '方案版本功能包id',
  `PKG_ID` varchar(64) DEFAULT NULL COMMENT '功能包id',
  `SCHM_EDT_ID` varchar(64) DEFAULT NULL COMMENT '方案版本id',
  `EDT_PKG_STATUS` char(1) DEFAULT NULL COMMENT '0禁用、1启用',
  `EDT_PKG_TYPE` char(1) DEFAULT NULL COMMENT '1基础、2增值',
  `EDT_PKG_YEAR_PRICE` decimal(9,0) DEFAULT NULL COMMENT '年价格',
  `EDT_PKG_MONTH_PRICE` decimal(9,0) DEFAULT NULL COMMENT '月价格',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`EDT_PKG_ID`),
  KEY `IDX_CFG_SCHM_EDT_PKG_SCHM` (`SCHM_EDT_ID`),
  KEY `CFG_SCHM_EDT_PACKAGE_PKG_ID` (`PKG_ID`),
  KEY `CFG_SCHM_EDT_PACKAGE_MDLID` (`MDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本功能包';

-- ----------------------------
-- Records of cfg_schm_edt_package
-- ----------------------------
INSERT INTO `cfg_schm_edt_package` VALUES ('01e8d57ca03e47afa881f3e215161f68', '1c80747af4134b58bce7c5cac9db6730', '3498943c97f047a9bcec79a4759238a9', '1', '1', '15', '2', '46b5060b90db40d28b78cca000f7d6cc', '1', '2018-03-29 17:57:27', '1', '2018-03-29 17:57:27');
INSERT INTO `cfg_schm_edt_package` VALUES ('2d79363b486b490d818431bb7d30a3a0', '55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '1', '1', '1', null, null, '59fd33c54da84426898be1ea44494853', '1', '2018-02-26 15:58:07', '1', '2018-02-26 15:58:07');
INSERT INTO `cfg_schm_edt_package` VALUES ('4e38514060a743a6bb2f2cef3f24fe08', '17e91a9f521249f28efba289f37c374d', 'c7454d379ac7460dae27c5d48ef410f1', '0', '1', null, null, '59fd33c54da84426898be1ea44494853', '1', '2018-02-11 16:35:45', '1', '2018-02-11 16:35:45');
INSERT INTO `cfg_schm_edt_package` VALUES ('820a6216435047bdb4962bebc3515696', '36d92639dd5b42909681a1d08f6e7cf7', '982c5410003c4ee0bdce19356caf0b00', '0', '1', null, null, 'aa8fa7d8f95842008b037463955957d7', '1', '2018-03-19 16:15:14', '1', '2018-03-19 16:15:14');
INSERT INTO `cfg_schm_edt_package` VALUES ('99aebfe19a5d40f880608bb926e04514', '17e91a9f521249f28efba289f37c374d', '08c0a69a74254da4a317f0eee6a58164', '1', '1', null, null, '59fd33c54da84426898be1ea44494853', '1', '2018-04-08 11:29:54', '1', '2018-04-08 11:29:54');
INSERT INTO `cfg_schm_edt_package` VALUES ('a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '1', '1', '2', '5000', '500', '59fd33c54da84426898be1ea44494853', '1', '2018-02-11 14:35:01', '1', '2018-02-26 16:05:59');
INSERT INTO `cfg_schm_edt_package` VALUES ('a939630ead3944bcb265eb06763ea07c', '1c80747af4134b58bce7c5cac9db6730', '534b28cbd1c8453792315966670b4e0c', '1', '1', '15', '2', '46b5060b90db40d28b78cca000f7d6cc', '1', '2018-02-27 11:41:39', '1', '2018-02-27 11:41:39');
INSERT INTO `cfg_schm_edt_package` VALUES ('b6187187bbeb4d67b8a08eef28502c22', '55ac95e8cdd24a0bb46c2d0eb4d7a6ff', 'c7454d379ac7460dae27c5d48ef410f1', '0', '1', null, null, '59fd33c54da84426898be1ea44494853', '1', '2018-02-12 17:48:22', '1', '2018-02-12 17:48:22');
INSERT INTO `cfg_schm_edt_package` VALUES ('da726f1d342c4d069985860ca752604a', 'd277afe8b37f484cbd1603de227584fa', '982c5410003c4ee0bdce19356caf0b00', '0', '1', null, null, '46b5060b90db40d28b78cca000f7d6cc', '1', '2018-03-26 16:54:40', '1', '2018-03-26 16:54:40');
INSERT INTO `cfg_schm_edt_package` VALUES ('f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '1', '1', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '1', '2018-02-26 15:15:33', '1', '2018-02-26 15:15:55');
INSERT INTO `cfg_schm_edt_package` VALUES ('ff538c00fe7741f4b90ba8bf3aca32ae', 'd277afe8b37f484cbd1603de227584fa', '534b28cbd1c8453792315966670b4e0c', '1', '2', '5000', '500', '46b5060b90db40d28b78cca000f7d6cc', '1', '2018-02-27 11:41:39', '1', '2018-02-27 11:41:55');

-- ----------------------------
-- Table structure for `cfg_schm_edt_package_his`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_schm_edt_package_his`;
CREATE TABLE `cfg_schm_edt_package_his` (
  `EDT_PKG_HIS_ID` varchar(64) NOT NULL COMMENT '方案版本功能包历史id',
  `EDT_PKG_ID` varchar(64) DEFAULT NULL COMMENT '方案版本功能包id',
  `PKG_ID` varchar(64) DEFAULT NULL COMMENT '功能包id',
  `PKG_NAME` varchar(64) DEFAULT NULL COMMENT '功能包名称',
  `SCHM_EDT_HIS_ID` varchar(64) DEFAULT NULL COMMENT '方案版本历史id',
  `EDT_PKG_TYPE` char(1) DEFAULT NULL COMMENT '1基础、2增值',
  `EDT_PKG_YEAR_PRICE` decimal(9,0) DEFAULT NULL COMMENT '年价格',
  `EDT_PKG_MONTH_PRICE` decimal(9,0) DEFAULT NULL COMMENT '月价格',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `MDL_NAME` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`EDT_PKG_HIS_ID`),
  KEY `IDX_CFG_SCHM_EDT_PKG_SCHM2` (`SCHM_EDT_HIS_ID`),
  KEY `CFG_SCHM_EDT_PACKAGE_PKG_ID2` (`PKG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案版本功能包历史';

-- ----------------------------
-- Records of cfg_schm_edt_package_his
-- ----------------------------
INSERT INTO `cfg_schm_edt_package_his` VALUES ('0f91f9988e99493ba784ad3e752ddb55', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', 'cf9ab6961c1948b49b7a37404d6008c9', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 16:05:08');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('2033f7270add45d4b09dce4a041111e4', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', '08e90fa0140247daaf2e2fe52fcf110a', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:18:29');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('23447bdf82d14571bc8797d72ea99bb4', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', '82a8122f8bc040ce94cc9437a82c7223', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:57:56');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('2c987055f6954df28701a8ee8a1f86a5', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', 'cf9ab6961c1948b49b7a37404d6008c9', '2', '5000', '501', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 16:05:08');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('2d62fc937c914536a09328cff9d546f9', '01e8d57ca03e47afa881f3e215161f68', '1c80747af4134b58bce7c5cac9db6730', '企业通用1', '54f18aacf43a46cbaef6dc15a2dfa94b', '1', '15', '2', '46b5060b90db40d28b78cca000f7d6cc', '企业通用', '1', '2018-04-12 17:32:34');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('491e16862fa046619e33145994a836e0', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', '9cc58c63cd2c4d869992172eacd59102', '2', '5000', '501', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:26:12');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('4afd991aa4584173a521e63908fec037', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', '82a8122f8bc040ce94cc9437a82c7223', '2', '5000', '501', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:57:56');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('4dc68f4b5f7f480db7eae74dbd4c0dde', 'a939630ead3944bcb265eb06763ea07c', '1c80747af4134b58bce7c5cac9db6730', '企业通用1', 'e926fc6096ca49e1bfa6f19248d53dd9', '1', null, null, '46b5060b90db40d28b78cca000f7d6cc', '企业通用', '1', '2018-02-27 11:42:31');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('665ff42e139c4fbe8ed9a37f8fb91b22', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', '08e90fa0140247daaf2e2fe52fcf110a', '2', '5000', '501', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:18:29');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('6e54bb3cf7c844a7882ada4f7e0dc4a3', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', 'c14b40b443b841a78970cab05c9ef3fa', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:53:27');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('8adb27ad94d347b0a57e13534d6ab51b', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', '75b07ee661894f5a8a5a6ebfbc88ad04', '2', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:04:54');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('a95d83de98814e0e8e655bc1c2af18ef', '99aebfe19a5d40f880608bb926e04514', '17e91a9f521249f28efba289f37c374d', '核销包1', '8f47591a92514aac80d0754772bb62b0', '1', null, null, '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-04-08 11:35:47');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('ab9b3d3edb5b48ecb8c83c51898dcc12', 'ff538c00fe7741f4b90ba8bf3aca32ae', 'd277afe8b37f484cbd1603de227584fa', '企业通用2', 'e926fc6096ca49e1bfa6f19248d53dd9', '2', '5000', '500', '46b5060b90db40d28b78cca000f7d6cc', '企业通用', '1', '2018-02-27 11:42:31');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('ae769b7c7b8e4b808d9185e730d5540d', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', 'ff3b33a32b174dd4bff7d63192f836c9', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:18:12');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('af9cc29e9d254b2ea71657b5355a711e', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', 'ff3b33a32b174dd4bff7d63192f836c9', '2', '5000', '501', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:18:12');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('b58d84dc11eb4fe68cbeb74766d64c10', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', '94bb445611ff4111bea2eea36929f5b1', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:16:23');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('c532de86e02749ecac3fc28b1a8cab40', '2d79363b486b490d818431bb7d30a3a0', '55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '核销包2', 'cf9ab6961c1948b49b7a37404d6008c9', '1', null, null, '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 16:05:08');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('c649447738744dd1b503311c0dac9897', 'f61809ef945d48f9b3d5b2e46d39e2ea', '17e91a9f521249f28efba289f37c374d', '核销包1', '9cc58c63cd2c4d869992172eacd59102', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:26:12');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('d50fd43a4cd54a7eaa6ed4a92854c052', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', '94bb445611ff4111bea2eea36929f5b1', '2', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:16:23');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('ded516b19b2744bfa987b6743d83c504', 'a17f74619a18483ba6de42cf2389f3ff', 'ac1e4fd45eb942e5bcf2536e87affe36', '核销包3', 'c14b40b443b841a78970cab05c9ef3fa', '2', '5000', '501', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:53:27');
INSERT INTO `cfg_schm_edt_package_his` VALUES ('e5815d2695f34c63bb6cb4a4af68cfbd', '3a98297c6f15429d802683052225f486', '17e91a9f521249f28efba289f37c374d', '核销包1', '75b07ee661894f5a8a5a6ebfbc88ad04', '1', '5000', '500', '59fd33c54da84426898be1ea44494853', '核销', '1', '2018-02-26 15:04:54');

-- ----------------------------
-- Table structure for `cfg_schm_mdl_rel`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_schm_mdl_rel`;
CREATE TABLE `cfg_schm_mdl_rel` (
  `SCHM_ID` varchar(64) NOT NULL COMMENT '行业方案id',
  `MDL_ID` varchar(64) NOT NULL COMMENT '模块id',
  `SORT` decimal(9,0) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`SCHM_ID`,`MDL_ID`),
  KEY `IDX_CFG_SCHM_MDL_REL_SCHM_ID` (`SCHM_ID`),
  KEY `IDX_CFG_SCHM_MDL_REL_MDL_ID` (`MDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业方案模块';

-- ----------------------------
-- Records of cfg_schm_mdl_rel
-- ----------------------------
INSERT INTO `cfg_schm_mdl_rel` VALUES ('10fe31b74bbb4e0b95f57adcf2995c99', '1cfed0fcc3e84bdda475401cdb205223', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('10fe31b74bbb4e0b95f57adcf2995c99', '46b5060b90db40d28b78cca000f7d6cc', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('10fe31b74bbb4e0b95f57adcf2995c99', 'aa8fa7d8f95842008b037463955957d7', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('21b7d32b42514d1da6518483504588b8', '1cfed0fcc3e84bdda475401cdb205223', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('21b7d32b42514d1da6518483504588b8', '59fd33c54da84426898be1ea44494853', '1');
INSERT INTO `cfg_schm_mdl_rel` VALUES ('21b7d32b42514d1da6518483504588b8', 'aa8fa7d8f95842008b037463955957d7', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('25da08296ecf40e0a1a9f9ee108ece8e', '1cfed0fcc3e84bdda475401cdb205223', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('25da08296ecf40e0a1a9f9ee108ece8e', '46b5060b90db40d28b78cca000f7d6cc', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('25da08296ecf40e0a1a9f9ee108ece8e', 'c8ed8566c34644448ebe0e8df5aff802', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('93c64bb38dde41f4840dd524e872a54a', '5ee65780503d4554b5562d44087a21c0', null);
INSERT INTO `cfg_schm_mdl_rel` VALUES ('e70d53d91b334bffa55a1ae5951d714c', '59fd33c54da84426898be1ea44494853', null);

-- ----------------------------
-- Table structure for `cfg_user_column_ext`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_user_column_ext`;
CREATE TABLE `cfg_user_column_ext` (
  `COL_ID` varchar(64) NOT NULL COMMENT '模块扩展字段id',
  `COL_NAME` varchar(64) DEFAULT NULL COMMENT '字段名称',
  `COL_DESC` varchar(64) DEFAULT NULL COMMENT '字段描述',
  `TABLE_TYPE` char(1) DEFAULT NULL COMMENT '1客户、2员工',
  `COL_DATA_TYPE` varchar(20) DEFAULT NULL COMMENT 'N_8:number八个、V3_5:varchar(3)五个、V20_5、V64_5、V256_3、V500_2',
  `COL_TYPE` char(1) DEFAULT NULL COMMENT '0无、1数据库、2常量',
  `CONST_TYPE` varchar(64) DEFAULT NULL COMMENT '常量类型',
  `FILTER` char(1) DEFAULT NULL COMMENT '0否、1是',
  `FILTER_TYPE` char(1) DEFAULT NULL COMMENT '1相等（=）、2字符串匹配(like)、3时间（xx_start xx_end）',
  `LIST_SHOW` char(1) DEFAULT NULL COMMENT '0否、1是',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `SORT` decimal(3,0) DEFAULT NULL COMMENT '排序',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`COL_ID`),
  KEY `IDX_CFG_USER_COLUMN_EXT_` (`MDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展字段';

-- ----------------------------
-- Records of cfg_user_column_ext
-- ----------------------------

-- ----------------------------
-- Table structure for `cfg_user_column_ext_ins`
-- ----------------------------
DROP TABLE IF EXISTS `cfg_user_column_ext_ins`;
CREATE TABLE `cfg_user_column_ext_ins` (
  `COL_INS_ID` varchar(64) NOT NULL COMMENT '扩展字段实例id',
  `COL_ID` varchar(64) DEFAULT NULL COMMENT '模块扩展字段id',
  `COL_NAME` varchar(64) DEFAULT NULL COMMENT '字段名称',
  `COL_DESC` varchar(64) DEFAULT NULL COMMENT '字段描述',
  `REAL_COL_NAME` varchar(64) DEFAULT NULL COMMENT '实际字段',
  `MDL_ID` varchar(64) DEFAULT NULL COMMENT '模块id',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '方案id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`COL_INS_ID`),
  KEY `IDX_CFG_USER_COL_EXT_MDL_ID` (`MDL_ID`),
  KEY `IDX_CFG_USER_COL_EXT_SCHM_ID` (`SCHM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展字段实例';

-- ----------------------------
-- Records of cfg_user_column_ext_ins
-- ----------------------------

-- ----------------------------
-- Table structure for `cust_info`
-- ----------------------------
DROP TABLE IF EXISTS `cust_info`;
CREATE TABLE `cust_info` (
  `CUST_ID` varchar(64) NOT NULL COMMENT '用户id',
  `CUST_NAME` varchar(20) NOT NULL COMMENT '姓名',
  `SHORT_NAME` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `LOGIN_NAME` varchar(50) NOT NULL COMMENT '登录名',
  `PASSWORD` varchar(64) DEFAULT NULL COMMENT '密码',
  `CUST_TYPE` char(1) DEFAULT NULL COMMENT '人员类型 1员工、2用户、3系统人员',
  `USER_STATUS` char(1) NOT NULL COMMENT 'N: 正常 D: 普通冻结 C: 注销 E:人工冻结',
  `FREEZE_DATE` datetime DEFAULT NULL COMMENT '冻结时间',
  `SEX` char(1) DEFAULT NULL COMMENT '性别',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '用户生日',
  `PHOTO` varchar(200) DEFAULT NULL COMMENT '头像',
  `SIGN` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `EMAIL` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `QQ` varchar(64) DEFAULT NULL COMMENT 'qq',
  `WEIXIN` varchar(64) DEFAULT NULL COMMENT '微信',
  `OFFICE` varchar(128) DEFAULT NULL COMMENT '所属单位',
  `IDCAR_NO` varchar(64) DEFAULT NULL COMMENT '身份证号码',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `OPEN_ID` varchar(64) DEFAULT NULL COMMENT 'OPEN_ID',
  `UNIONID` varchar(64) DEFAULT NULL COMMENT 'UNIONID',
  `STAFF_TYPE` char(1) DEFAULT NULL COMMENT '员工类型由各方案定义',
  `CUST_IS_ADMIN` char(1) DEFAULT NULL COMMENT '员工用户时，管理员标识：0否、1是',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  `SITE_ID` varchar(64) DEFAULT NULL COMMENT '站点id',
  PRIMARY KEY (`CUST_ID`),
  UNIQUE KEY `U_CUST_INFO_LOGINNAME` (`LOGIN_NAME`,`MCHT_ID`),
  UNIQUE KEY `U_CUST_INFO_OPEN_ID` (`OPEN_ID`),
  KEY `IDX_CUST_INFO_CUST_NAME` (`CUST_NAME`),
  KEY `IDX_CUST_INFO_MCHT_ID` (`MCHT_ID`),
  KEY `IDX_CUST_INFO_CREATE_DATE` (`CREATE_DATE`),
  KEY `IDX_CUST_INFO_MCHT_SCHM_ID` (`MCHT_SCHM_ID`),
  KEY `IDX_CUST_INFO_UNIONID` (`UNIONID`),
  KEY `IDX_CUST_INFO_SITE` (`SITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户';

-- ----------------------------
-- Records of cust_info
-- ----------------------------
INSERT INTO `cust_info` VALUES ('111', 't-admin', 't-admin', '111', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '1', 'N', null, null, null, null, null, null, null, null, null, null, null, null, '111', null, null, '1', '0e94f62519b84d138566d05510db5f4a', '1', '0', '1');
INSERT INTO `cust_info` VALUES ('222', '安徽电大管理员', 'ahdiand', '222', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '1', 'N', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '192e78f06ff94bdf98986d06172d3193', '233b1e33148444a49af58f52146c17c4', '0', '1');
INSERT INTO `cust_info` VALUES ('82f66b6689fc4a2bacbc3294e06b40c2', 'testcust', 'testcust', 'testcust', 'a6ec083870c72a5b88c5dd87968aa38bb9cb16db03b19b70c2eab950', '2', 'N', '2018-08-22 17:31:17', null, null, null, null, null, null, null, null, null, null, '2018-08-22 17:28:29', null, null, null, null, '192e78f06ff94bdf98986d06172d3193', '233b1e33148444a49af58f52146c17c4', '0', null);
INSERT INTO `cust_info` VALUES ('8d9d7fda1b1342ccb5ae40324f7975d4', 'teststaff', 'teststaff', 'teststaff', '25c33bbecf26931013e60809e6879ca4263d2a04cf65f5b26ab76ef6', '1', 'N', '2018-08-23 09:22:34', null, null, null, null, null, null, null, null, null, null, '2018-08-22 17:28:07', null, null, null, null, '192e78f06ff94bdf98986d06172d3193', '233b1e33148444a49af58f52146c17c4', '0', null);
INSERT INTO `cust_info` VALUES ('b1da0b66fe114fa2b32a546b25edb845', 'test-reg', null, 'test-reg', '5c5a8f74b26a8b16a1eab3184eb7880f65fc4fa5f87053be84c4c3e5', '2', 'N', null, null, null, null, null, null, null, null, null, null, null, '2018-08-23 15:01:58', null, null, null, null, '192e78f06ff94bdf98986d06172d3193', '233b1e33148444a49af58f52146c17c4', '0', null);

-- ----------------------------
-- Table structure for `cust_info_ext`
-- ----------------------------
DROP TABLE IF EXISTS `cust_info_ext`;
CREATE TABLE `cust_info_ext` (
  `CUST_ID` varchar(64) NOT NULL COMMENT '用户id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `N_1` decimal(9,0) DEFAULT NULL COMMENT 'N_1',
  `N_2` decimal(9,0) DEFAULT NULL COMMENT 'N_2',
  `N_3` decimal(9,0) DEFAULT NULL COMMENT 'N_3',
  `N_4` decimal(9,0) DEFAULT NULL COMMENT 'N_4',
  `N_5` decimal(9,0) DEFAULT NULL COMMENT 'N_5',
  `N_6` decimal(9,0) DEFAULT NULL COMMENT 'N_6',
  `N_7` decimal(9,0) DEFAULT NULL COMMENT 'N_7',
  `N_8` decimal(9,0) DEFAULT NULL COMMENT 'N_8',
  `V3_1` varchar(3) DEFAULT NULL COMMENT 'V3_1',
  `V3_2` varchar(3) DEFAULT NULL COMMENT 'V3_2',
  `V3_3` varchar(3) DEFAULT NULL COMMENT 'V3_3',
  `V3_4` varchar(3) DEFAULT NULL COMMENT 'V3_4',
  `V3_5` varchar(3) DEFAULT NULL COMMENT 'V3_5',
  `V20_1` varchar(20) DEFAULT NULL COMMENT 'V20_1',
  `V20_2` varchar(20) DEFAULT NULL COMMENT 'V20_2',
  `V20_3` varchar(20) DEFAULT NULL COMMENT 'V20_3',
  `V20_4` varchar(20) DEFAULT NULL COMMENT 'V20_4',
  `V20_5` varchar(20) DEFAULT NULL COMMENT 'V20_5',
  `V64_1` varchar(64) DEFAULT NULL COMMENT 'V64_1',
  `V64_2` varchar(64) DEFAULT NULL COMMENT 'V64_2',
  `V64_3` varchar(64) DEFAULT NULL COMMENT 'V64_3',
  `V64_4` varchar(64) DEFAULT NULL COMMENT 'V64_4',
  `V64_5` varchar(64) DEFAULT NULL COMMENT 'V64_5',
  `V256_1` varchar(256) DEFAULT NULL COMMENT 'V256_1',
  `V256_2` varchar(256) DEFAULT NULL COMMENT 'V256_2',
  `V256_3` varchar(256) DEFAULT NULL COMMENT 'V256_3',
  `V500_1` varchar(500) DEFAULT NULL COMMENT 'V500_1',
  `V500_2` varchar(500) DEFAULT NULL COMMENT 'V500_2',
  PRIMARY KEY (`CUST_ID`),
  KEY `IDX_CUST_INFO_STAFF_MCHT_ID` (`MCHT_ID`),
  KEY `IDX_CUST_INFO_STAFF_CRT_DATE` (`CREATE_DATE`),
  KEY `IDX_CUST_INFO_STAFF_V20_1` (`V20_1`),
  KEY `IDX_CUST_INFO_STAFF_V20_2` (`V20_2`),
  KEY `IDX_CUST_INFO_STAFF_V64_1` (`V64_1`),
  KEY `IDX_CUST_INFO_STAFF_V64_2` (`V64_2`),
  KEY `IDX_CUST_INFO_STAFF_V64_3` (`V64_3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工扩展-暂不用';

-- ----------------------------
-- Records of cust_info_ext
-- ----------------------------

-- ----------------------------
-- Table structure for `cust_lgn_info`
-- ----------------------------
DROP TABLE IF EXISTS `cust_lgn_info`;
CREATE TABLE `cust_lgn_info` (
  `LGN_ID` varchar(64) NOT NULL COMMENT 'ID',
  `USER_ID` varchar(64) DEFAULT NULL COMMENT '客户ID',
  `FIRST_LGN_FLAG` char(1) DEFAULT NULL COMMENT 'Y：首次登陆 N：非首次登陆',
  `FIRST_LGN_DATE` varchar(20) DEFAULT NULL COMMENT '第一次登录时间',
  `LGN_ERR_NUM` decimal(3,0) DEFAULT NULL COMMENT '错误登录次数',
  `LGN_DATE` varchar(10) DEFAULT NULL COMMENT '登录日期',
  `LGN_TIME` varchar(10) DEFAULT NULL COMMENT '登录时间',
  `LGN_DATETIME` datetime DEFAULT NULL COMMENT '登录日期时间',
  `LGN_TYPE` char(1) DEFAULT NULL COMMENT '1APP、2网页',
  `LGN_IP` varchar(20) DEFAULT NULL COMMENT '登录IP',
  `Y_LINE` varchar(10) DEFAULT NULL COMMENT '经度',
  `X_LINE` varchar(10) DEFAULT NULL COMMENT '纬度',
  `CUR_ADRESS` varchar(200) DEFAULT NULL COMMENT '当前地址',
  `AREA_NAME` varchar(100) DEFAULT NULL COMMENT '区县名称',
  `AREA_ID` varchar(64) DEFAULT NULL COMMENT '区县id',
  `LAST_LGN_CITY_ID` varchar(64) DEFAULT NULL COMMENT '登录城市id',
  `LAST_LGN_CITY_NAME` varchar(200) DEFAULT NULL COMMENT '登录城市名称',
  `IS_ONLINE` char(1) DEFAULT NULL COMMENT '是否在线',
  PRIMARY KEY (`LGN_ID`),
  KEY `IDX_CUST_LGN_INFO_CUST_ID` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录信息';

-- ----------------------------
-- Records of cust_lgn_info
-- ----------------------------
INSERT INTO `cust_lgn_info` VALUES ('4b566ddca3204f7ab86119d7b37786bc', 'b1da0b66fe114fa2b32a546b25edb845', 'N', '2018-08-23 15:34:05', '0', '2018-08-23', '15:35:07', '2018-08-23 15:35:07', '2', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, '1');
INSERT INTO `cust_lgn_info` VALUES ('538f91b0d327489f8ff5f942543a0c04', '82f66b6689fc4a2bacbc3294e06b40c2', 'Y', '2018-08-23 10:04:56', '0', '2018-08-23', '10:04:56', '2018-08-23 10:04:56', '2', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, '1');
INSERT INTO `cust_lgn_info` VALUES ('71cebca426c8450fac529a9062690fc3', '8d9d7fda1b1342ccb5ae40324f7975d4', 'Y', '2018-08-23 10:05:14', '0', '2018-08-23', '10:05:14', '2018-08-23 10:05:14', '2', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, '1');
INSERT INTO `cust_lgn_info` VALUES ('ab59dfef8d3048b8af409ae24a25435e', '111', 'N', '2018-05-07 13:37:38', '0', '2018-08-22', '17:21:27', '2018-08-22 17:21:27', '2', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, '1');
INSERT INTO `cust_lgn_info` VALUES ('fd3ebc0010914577a19db3e963f5c465', '222', 'Y', '2018-08-22 17:27:17', '0', '2018-08-22', '17:27:17', '2018-08-22 17:27:17', '2', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for `cust_mng_site`
-- ----------------------------
DROP TABLE IF EXISTS `cust_mng_site`;
CREATE TABLE `cust_mng_site` (
  `CUST_ID` varchar(64) NOT NULL COMMENT '用户id',
  `SITE_ID` varchar(64) NOT NULL COMMENT '站点id',
  PRIMARY KEY (`CUST_ID`,`SITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户管理站点';

-- ----------------------------
-- Records of cust_mng_site
-- ----------------------------
INSERT INTO `cust_mng_site` VALUES ('8d9d7fda1b1342ccb5ae40324f7975d4', '11');
INSERT INTO `cust_mng_site` VALUES ('8d9d7fda1b1342ccb5ae40324f7975d4', '22');

-- ----------------------------
-- Table structure for `cust_role`
-- ----------------------------
DROP TABLE IF EXISTS `cust_role`;
CREATE TABLE `cust_role` (
  `ROLE_ID` varchar(64) NOT NULL COMMENT 'ID',
  `ROLE_NAME` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `ROLE_ENAME` varchar(64) DEFAULT NULL COMMENT '英文名称',
  `ROLE_TYPE` varchar(64) DEFAULT NULL COMMENT '角色类型',
  `USERABLE` char(1) DEFAULT NULL COMMENT '0否、1是',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(500) DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-暂不用';

-- ----------------------------
-- Records of cust_role
-- ----------------------------

-- ----------------------------
-- Table structure for `cust_role_func`
-- ----------------------------
DROP TABLE IF EXISTS `cust_role_func`;
CREATE TABLE `cust_role_func` (
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色id',
  `FUNC_ID` varchar(64) NOT NULL COMMENT '功能id',
  PRIMARY KEY (`ROLE_ID`,`FUNC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单';

-- ----------------------------
-- Records of cust_role_func
-- ----------------------------

-- ----------------------------
-- Table structure for `cust_user_ext`
-- ----------------------------
DROP TABLE IF EXISTS `cust_user_ext`;
CREATE TABLE `cust_user_ext` (
  `USER_ID` varchar(64) NOT NULL COMMENT '用户id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `N_1` decimal(9,0) DEFAULT NULL COMMENT 'N_1',
  `N_2` decimal(9,0) DEFAULT NULL COMMENT 'N_2',
  `N_3` decimal(9,0) DEFAULT NULL COMMENT 'N_3',
  `N_4` decimal(9,0) DEFAULT NULL COMMENT 'N_4',
  `N_5` decimal(9,0) DEFAULT NULL COMMENT 'N_5',
  `N_6` decimal(9,0) DEFAULT NULL COMMENT 'N_6',
  `N_7` decimal(9,0) DEFAULT NULL COMMENT 'N_7',
  `N_8` decimal(9,0) DEFAULT NULL COMMENT 'N_8',
  `V3_1` varchar(3) DEFAULT NULL COMMENT 'V3_1',
  `V3_2` varchar(3) DEFAULT NULL COMMENT 'V3_2',
  `V3_3` varchar(3) DEFAULT NULL COMMENT 'V3_3',
  `V3_4` varchar(3) DEFAULT NULL COMMENT 'V3_4',
  `V3_5` varchar(3) DEFAULT NULL COMMENT 'V3_5',
  `V20_1` varchar(20) DEFAULT NULL COMMENT 'V20_1',
  `V20_2` varchar(20) DEFAULT NULL COMMENT 'V20_2',
  `V20_3` varchar(20) DEFAULT NULL COMMENT 'V20_3',
  `V20_4` varchar(20) DEFAULT NULL COMMENT 'V20_4',
  `V20_5` varchar(20) DEFAULT NULL COMMENT 'V20_5',
  `V64_1` varchar(64) DEFAULT NULL COMMENT 'V64_1',
  `V64_2` varchar(64) DEFAULT NULL COMMENT 'V64_2',
  `V64_3` varchar(64) DEFAULT NULL COMMENT 'V64_3',
  `V64_4` varchar(64) DEFAULT NULL COMMENT 'V64_4',
  `V64_5` varchar(64) DEFAULT NULL COMMENT 'V64_5',
  `V256_1` varchar(256) DEFAULT NULL COMMENT 'V256_1',
  `V256_2` varchar(256) DEFAULT NULL COMMENT 'V256_2',
  `V256_3` varchar(256) DEFAULT NULL COMMENT 'V256_3',
  `V500_1` varchar(500) DEFAULT NULL COMMENT 'V500_1',
  `V500_2` varchar(500) DEFAULT NULL COMMENT 'V500_2',
  PRIMARY KEY (`USER_ID`),
  KEY `IDX_CUST_INFO_EXT_MCHT_ID` (`MCHT_ID`),
  KEY `IDX_CUST_INFO_EXT_CRT_DATE` (`CREATE_DATE`),
  KEY `IDX_CUST_INFO_EXT_V20_1` (`V20_1`),
  KEY `IDX_CUST_INFO_EXT_V20_2` (`V20_2`),
  KEY `IDX_CUST_INFO_EXT_V64_1` (`V64_1`),
  KEY `IDX_CUST_INFO_EXT_V64_2` (`V64_2`),
  KEY `IDX_CUST_INFO_EXT_V64_3` (`V64_3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户扩展1';

-- ----------------------------
-- Records of cust_user_ext
-- ----------------------------

-- ----------------------------
-- Table structure for `cust_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `cust_user_role`;
CREATE TABLE `cust_user_role` (
  `CUST_ID` varchar(64) NOT NULL COMMENT '用户id',
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`CUST_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of cust_user_role
-- ----------------------------
INSERT INTO `cust_user_role` VALUES ('8d9d7fda1b1342ccb5ae40324f7975d4', '33');
INSERT INTO `cust_user_role` VALUES ('8d9d7fda1b1342ccb5ae40324f7975d4', '44');

-- ----------------------------
-- Table structure for `net_code_dict`
-- ----------------------------
DROP TABLE IF EXISTS `net_code_dict`;
CREATE TABLE `net_code_dict` (
  `ID` varchar(20) NOT NULL,
  `CODE_TYPE` varchar(20) DEFAULT NULL COMMENT '类型',
  `CODE_TYPE_NAME` varchar(20) DEFAULT NULL COMMENT '类型名称',
  `CODE_NO` varchar(20) DEFAULT NULL COMMENT '编码',
  `CODE_NO_NAME` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_SORT` int(11) DEFAULT NULL COMMENT '排序',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of net_code_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `prompt_msg_translate`
-- ----------------------------
DROP TABLE IF EXISTS `prompt_msg_translate`;
CREATE TABLE `prompt_msg_translate` (
  `TRANS_CODE` varchar(20) NOT NULL COMMENT '转换编码',
  `TRANS_NAME` varchar(100) DEFAULT NULL COMMENT '转换名称',
  `OTH_TRANS_CODE` varchar(20) NOT NULL COMMENT '转换后消息编码',
  `MSG_CODE` varchar(20) NOT NULL COMMENT '消息编码',
  `PRE_VALUE` varchar(150) DEFAULT NULL,
  `SUF_VALUE` varchar(150) DEFAULT NULL,
  `EXTRA_1` varchar(100) DEFAULT NULL,
  `EXTRA_2` varchar(100) DEFAULT NULL,
  `EXTRA_3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TRANS_CODE`,`OTH_TRANS_CODE`,`MSG_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prompt_msg_translate
-- ----------------------------

-- ----------------------------
-- Table structure for `ptset_cust_site`
-- ----------------------------
DROP TABLE IF EXISTS `ptset_cust_site`;
CREATE TABLE `ptset_cust_site` (
  `CUST_ID` varchar(64) NOT NULL COMMENT '学员',
  `SITE_ID` varchar(64) NOT NULL COMMENT '站点',
  `PT_ID` varchar(64) DEFAULT NULL COMMENT '平台id',
  `JOIN_DATE` datetime DEFAULT NULL COMMENT '时间',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`CUST_ID`,`SITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员参与站点';

-- ----------------------------
-- Records of ptset_cust_site
-- ----------------------------
INSERT INTO `ptset_cust_site` VALUES ('111', '1', '1', null, '1', '0e94f62519b84d138566d05510db5f4a');

-- ----------------------------
-- Table structure for `ptset_platform`
-- ----------------------------
DROP TABLE IF EXISTS `ptset_platform`;
CREATE TABLE `ptset_platform` (
  `PT_ID` varchar(64) NOT NULL COMMENT 'id',
  `PT_NAME` varchar(128) DEFAULT NULL COMMENT '平台名称',
  `PT_CODE` varchar(64) DEFAULT NULL COMMENT '平台编码',
  `SITE_ID` varchar(64) DEFAULT NULL COMMENT '主站点id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  PRIMARY KEY (`PT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台';

-- ----------------------------
-- Records of ptset_platform
-- ----------------------------
INSERT INTO `ptset_platform` VALUES ('1', 'test', 'test', '8888f37ff54a4178af97cd113560171b', '233b1e33148444a49af58f52146c17c4', '192e78f06ff94bdf98986d06172d3193');

-- ----------------------------
-- Table structure for `ptset_site`
-- ----------------------------
DROP TABLE IF EXISTS `ptset_site`;
CREATE TABLE `ptset_site` (
  `SITE_ID` varchar(64) NOT NULL COMMENT 'id',
  `SITE_NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `SITE_CODE` varchar(64) DEFAULT NULL COMMENT '编码',
  `SITE_LOGO` varchar(64) DEFAULT NULL COMMENT 'logo',
  `PAGE_HEAD_IMG` varchar(64) DEFAULT NULL COMMENT '头部图片',
  `PAGE_SITE_COPYRIGHT` varchar(2000) DEFAULT NULL COMMENT '站点版权',
  `SITE_DOMAIN` varchar(128) DEFAULT NULL COMMENT '域名',
  `AREA_ID` varchar(64) DEFAULT NULL COMMENT '区域',
  `SORT` decimal(9,0) DEFAULT NULL COMMENT '排序',
  `PT_ID` varchar(64) DEFAULT NULL COMMENT '平台ID',
  `SITE_TYPE` char(1) DEFAULT NULL COMMENT '1主站、2子站',
  `STATUS` char(1) DEFAULT NULL COMMENT '0未启用、1启用',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  `EXT_COL1` varchar(64) DEFAULT NULL COMMENT '扩展字段1',
  `EXT_COL2` varchar(64) DEFAULT NULL COMMENT '扩展字段2',
  `EXT_COL3` varchar(64) DEFAULT NULL COMMENT '扩展字段3',
  `EXT_COL4` varchar(64) DEFAULT NULL COMMENT '扩展字段4',
  `EXT_COL5` varchar(64) DEFAULT NULL COMMENT '扩展字段5',
  PRIMARY KEY (`SITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点';

-- ----------------------------
-- Records of ptset_site
-- ----------------------------
INSERT INTO `ptset_site` VALUES ('1', 'testsite', 'testsite', null, null, null, null, null, null, '1', '2', '1', null, null, null, null, '0', '233b1e33148444a49af58f52146c17c4', '192e78f06ff94bdf98986d06172d3193', null, null, null, null, null);
INSERT INTO `ptset_site` VALUES ('8888f37ff54a4178af97cd113560171b', 'site2', 'site2', null, null, null, null, null, null, '1', '1', '0', '222', '2018-08-23 17:37:40', '222', '2018-08-23 17:37:40', '0', '233b1e33148444a49af58f52146c17c4', '192e78f06ff94bdf98986d06172d3193', null, null, null, null, null);

-- ----------------------------
-- Table structure for `sh_activity`
-- ----------------------------
DROP TABLE IF EXISTS `sh_activity`;
CREATE TABLE `sh_activity` (
  `ACT_ID` varchar(64) NOT NULL COMMENT '活动id',
  `ACT_NAME` varchar(256) DEFAULT NULL COMMENT '活动名称',
  `ACT_DESC` varchar(2000) DEFAULT NULL COMMENT '活动描述',
  `ACT_DISCOUNT_AMOUNT` decimal(9,0) DEFAULT NULL COMMENT '优惠金额',
  `ACT_START_DATE` datetime DEFAULT NULL COMMENT '开始时间',
  `ACT_END_DATE` datetime DEFAULT NULL COMMENT '结束时间',
  `ACT_STATUS` char(1) DEFAULT NULL COMMENT '0未发布，1发布',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ACT_ID`),
  KEY `IDX_SH_ACTIVITY_CREATE_DATE` (`CREATE_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动';

-- ----------------------------
-- Records of sh_activity
-- ----------------------------
INSERT INTO `sh_activity` VALUES ('04fb2d61deb849efa421949524cb228d', '周年店庆', '11', '2', '2018-04-03 09:49:50', '2018-04-21 00:00:00', '0', '1', '2018-04-03 09:33:38', '1', '2018-04-08 11:40:29');

-- ----------------------------
-- Table structure for `sh_applet_setting`
-- ----------------------------
DROP TABLE IF EXISTS `sh_applet_setting`;
CREATE TABLE `sh_applet_setting` (
  `APLT_SET_ID` varchar(64) NOT NULL COMMENT '小程序配置id',
  `APP_ID` varchar(64) DEFAULT NULL COMMENT 'AppId',
  `APP_SECRET` varchar(64) DEFAULT NULL COMMENT 'AppSecret',
  `APP_NAME` varchar(128) DEFAULT NULL COMMENT '小程序名称',
  `APP_SIGNS` varchar(64) DEFAULT NULL COMMENT '小程序标志，是核销的客户小程序，还是核销导购小程序',
  `APP_AUTH_REFRESH_TOKEN` varchar(64) DEFAULT NULL COMMENT '接口调用凭据刷新令牌',
  `APP_AUTH_INFO` varchar(1000) DEFAULT NULL COMMENT '授权信息',
  `WECHAT_MERCHANT_NAME` varchar(128) DEFAULT NULL COMMENT '商户名称',
  `WECHAT_MERCHANT_NUM` varchar(64) DEFAULT NULL COMMENT '商户号',
  `WECHAT__MERCHANT_PASSWOD` varchar(64) DEFAULT NULL COMMENT '商户密钥',
  `PUBLIC_NUM_NAME` varchar(64) DEFAULT NULL COMMENT '公众号名称',
  `PUBLIC_NUM_APPID` varchar(64) DEFAULT NULL COMMENT '公众号appid',
  `PUBLIC_NUM_APPSECRETE` varchar(64) DEFAULT NULL COMMENT '公众号appsecrete',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `APLT_ID` varchar(64) DEFAULT NULL COMMENT '小程序ID',
  `APLT_VER_ID` varchar(64) DEFAULT NULL COMMENT '小程序版本id',
  `APP_EXT_JSON` varchar(1000) DEFAULT NULL COMMENT '模板小程序扩展信息，不包含APPID，使用时再做拼json串',
  `APP_CODE_UPLOAD_STATUS` char(1) DEFAULT NULL COMMENT '上传代码状态：0未上传、1上传中、2成功、3失败',
  `APP_AUDIT_ID` varchar(64) DEFAULT NULL COMMENT '审核id',
  `APP_AUDIT_STATUS` char(1) DEFAULT NULL COMMENT '审核状态：0未提交、1提交中、2审核中、3成功、4失败',
  `APP_PUB_STATUS` char(1) DEFAULT NULL COMMENT '发布状态：0未发布、1发布中、2发布成功、2发布失败',
  `APP_REVERT_STATUS` char(1) DEFAULT NULL COMMENT '版本回退状态：0未回退、1回退成功、2回退失败',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`APLT_SET_ID`),
  KEY `IDX_SH_APPLET_SET_MCHT_SCHM_ID` (`MCHT_SCHM_ID`),
  KEY `IDX_SH_APPLET_SETTING_MCHT_ID` (`MCHT_ID`),
  KEY `IDX_SH_APPLET_SETTING_APPID` (`APP_ID`),
  KEY `IDX_SH_APPLET_SETTING_APLT_ID` (`APLT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小程序配置';

-- ----------------------------
-- Records of sh_applet_setting
-- ----------------------------
INSERT INTO `sh_applet_setting` VALUES ('26ab7359e338465da28d1d35295832b3', null, null, null, null, null, null, null, null, null, null, null, null, '6b2ac652d878468c926e5ef6bbf2656d', '1', 'e0a1d2c14608401f9b96d8a80e17d393', 'a2a57e22b7b04c9785e73dd4fbe26312', null, null, null, null, null, null, '1', '2018-04-13 09:11:37', '1', '2018-04-13 09:11:37', '0');
INSERT INTO `sh_applet_setting` VALUES ('8f3d7b19c0dc43479f5af955579c0dcf', 'wxd520508a5dbbb797', null, null, null, null, null, null, null, null, null, null, null, '0e94f62519b84d138566d05510db5f4a', '1', 'e0a1d2c14608401f9b96d8a80e17d393', 'a2a57e22b7b04c9785e73dd4fbe26312', null, '2', null, '1', '2', '1', '1', '2018-04-04 16:25:57', '1', '2018-04-04 16:25:57', '0');
INSERT INTO `sh_applet_setting` VALUES ('9b48eb90518a47f6a127a22d901e95c5', '1', null, null, null, null, null, null, null, null, null, null, null, '35eb97c61e4a451b8db3692103b2b2b8', '1', 'e0a1d2c14608401f9b96d8a80e17d393', 'a2a57e22b7b04c9785e73dd4fbe26312', null, null, null, null, null, null, '1', '2018-04-08 13:24:18', '1', '2018-04-08 13:24:18', '0');
INSERT INTO `sh_applet_setting` VALUES ('b661765170a04928a27dc319910d4a15', '3', null, null, null, null, null, null, null, null, null, null, null, '3997388e1c494046947d96a24f76c0cc', '1', 'e0a1d2c14608401f9b96d8a80e17d393', 'a2a57e22b7b04c9785e73dd4fbe26312', null, null, null, null, null, null, '1', '2018-04-04 14:28:21', '1', '2018-04-04 14:28:21', '0');

-- ----------------------------
-- Table structure for `sh_applet_version_his`
-- ----------------------------
DROP TABLE IF EXISTS `sh_applet_version_his`;
CREATE TABLE `sh_applet_version_his` (
  `APP_ID` varchar(64) NOT NULL COMMENT '商户小程序配置id',
  `APLT_VER_ID` varchar(64) NOT NULL COMMENT '小程序版本id',
  PRIMARY KEY (`APP_ID`,`APLT_VER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户小程序版本历史';

-- ----------------------------
-- Records of sh_applet_version_his
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `sh_merchant`;
CREATE TABLE `sh_merchant` (
  `MCHT_ID` varchar(64) NOT NULL COMMENT '商户id',
  `MCHT_NAME` varchar(128) DEFAULT NULL COMMENT '商户名称',
  `MCHT_SHORTNAME` varchar(64) DEFAULT NULL COMMENT '商户shortname',
  `MCHT_CODE` varchar(64) DEFAULT NULL COMMENT '商户编码',
  `MCHT_LINKMAN` varchar(64) DEFAULT NULL COMMENT '联系人',
  `MCHT_PHONE` varchar(64) DEFAULT NULL COMMENT '手机号',
  `MCHT_TELEPHONE` varchar(64) DEFAULT NULL COMMENT '座机',
  `MCHT_STATUS` char(1) DEFAULT NULL COMMENT '0禁用、1启用',
  `MCHT_ADRESS` varchar(256) DEFAULT NULL COMMENT '地址',
  `MCHT_INDUSTRY` varchar(20) DEFAULT NULL COMMENT '行业',
  `CLIENT_MANAGER_ID` varchar(64) DEFAULT NULL COMMENT '客户经理id',
  `CLIENT_MANAGER_NAME` varchar(20) DEFAULT NULL COMMENT '客户经理名称',
  `MCHT_ADD_TYPE` char(1) DEFAULT NULL COMMENT '1线上、2线下',
  `MCHT_LOGO` varchar(30) DEFAULT NULL COMMENT 'logo',
  `CREATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(500) DEFAULT NULL COMMENT '备注',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`MCHT_ID`),
  UNIQUE KEY `U_SH_MERCHANT_CODE` (`MCHT_CODE`),
  KEY `IDX_SH_MERCHANT_CLIENT_MNG_ID` (`CLIENT_MANAGER_ID`),
  KEY `IDX_SH_MERCHANT_MCHT_NAME` (`MCHT_NAME`),
  KEY `IDX_SH_MERCHANT_CREATE_DATE` (`CREATE_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户';

-- ----------------------------
-- Records of sh_merchant
-- ----------------------------
INSERT INTO `sh_merchant` VALUES ('1', 'test', 'test', 'test', 'test', null, null, '1', null, '1', '1', '系统管理员', null, null, null, null, null, null, '1', '2018-04-04 17:47:42', null, '0');
INSERT INTO `sh_merchant` VALUES ('233b1e33148444a49af58f52146c17c4', '安徽电大', '', null, '电大人员', '135515663220', '', '1', '', '2', null, null, null, null, null, null, '1', '2018-08-20 17:01:45', '1', '2018-08-20 17:01:45', '', '0');

-- ----------------------------
-- Table structure for `sh_merchant_scheme`
-- ----------------------------
DROP TABLE IF EXISTS `sh_merchant_scheme`;
CREATE TABLE `sh_merchant_scheme` (
  `MCHT_SCHM_ID` varchar(64) NOT NULL COMMENT '商家方案id',
  `MCHT_SCHM_EXPIRE_DATE` datetime DEFAULT NULL COMMENT '到期时间',
  `ORD_ID` varchar(64) DEFAULT NULL COMMENT '当前订单id',
  `MCHT_SCHM_STATUS` char(1) DEFAULT NULL COMMENT '0禁用、1启用',
  `MCHT_SCHM_PAY_STATUS` char(1) DEFAULT NULL COMMENT '0未付费、1已付费、2欠费',
  `MCHT_UPGRADE_STATUS` char(1) DEFAULT NULL COMMENT '0不升级、1免费升级',
  `SCHM_EDT_ID` varchar(64) DEFAULT NULL COMMENT '方案版本id',
  `SCHM_EDT_HIS_ID` varchar(64) DEFAULT NULL COMMENT '方案版本历史id',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `CREATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `UPDATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人名称',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`MCHT_SCHM_ID`),
  KEY `IDX_SH_MCHT_SCHEME_SCHM_EDT_ID` (`SCHM_EDT_ID`),
  KEY `IDX_SH_MERCHANT_SCHEME_MCHT_ID` (`MCHT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户方案';

-- ----------------------------
-- Records of sh_merchant_scheme
-- ----------------------------
INSERT INTO `sh_merchant_scheme` VALUES ('0e94f62519b84d138566d05510db5f4a', '2018-04-04 16:27:04', '25fc068a3cde4c6d9afbe2ede3093f68', '1', '1', '0', '1', 'cf9ab6961c1948b49b7a37404d6008c9', '1', null, null, '1', '2018-04-04 16:25:57', '1', '2018-04-13 10:27:34', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('11ef3fb52d414e24ac7086035b076f76', '2018-04-08 00:00:00', null, null, '0', '0', '08c0a69a74254da4a317f0eee6a58164', null, '1', null, null, '1', '2018-04-08 13:19:37', '1', '2018-04-08 13:19:37', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('192e78f06ff94bdf98986d06172d3193', '2020-08-27 00:00:00', null, '1', '1', '1', '96a639f2acaa420088a9f831d4fb7fb1', '968c983ff8b246b48528cb9cf5931bd8', '233b1e33148444a49af58f52146c17c4', null, null, '1', '2018-08-20 17:45:14', '1', '2018-08-20 17:45:14', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('22ce72da43cc43c9bf931ef31d5e4d87', '2018-04-28 00:00:00', 'd961d12588c94bc3b2683e6bd3ed881e', null, '0', '0', '982c5410003c4ee0bdce19356caf0b00', 'b21bd15dd36f4690af80179f3cf02f3d', '1', null, null, '1', '2018-04-04 17:57:08', '1', '2018-04-08 11:55:50', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('35eb97c61e4a451b8db3692103b2b2b8', '2018-04-27 00:00:00', null, null, '0', '0', '1', null, '1', null, null, '1', '2018-04-08 13:24:14', '1', '2018-04-08 13:24:14', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('438e01b77fe5441abb13d2a33e82d16d', '2019-09-30 00:00:00', null, null, '1', '1', '96a639f2acaa420088a9f831d4fb7fb1', null, '1', null, null, '1', '2018-08-20 17:44:18', '1', '2018-08-20 17:44:18', '1');
INSERT INTO `sh_merchant_scheme` VALUES ('5dfe28a577c643cd82cf469b18b38038', '2018-04-04 00:00:00', null, null, '0', '0', '08c0a69a74254da4a317f0eee6a58164', null, '1', null, null, '1', '2018-04-08 13:22:55', '1', '2018-04-08 13:22:55', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('6b2ac652d878468c926e5ef6bbf2656d', '2018-04-13 00:00:00', null, null, '1', '1', '1', null, '1', null, null, '1', '2018-04-13 09:11:21', '1', '2018-04-13 09:11:21', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('a5f10fb5f0bf4c66a89a3909e0eec3d0', '2018-04-10 00:00:00', null, null, '0', '0', '08c0a69a74254da4a317f0eee6a58164', null, '1', null, null, '1', '2018-04-08 12:00:05', '1', '2018-04-08 12:00:05', '0');
INSERT INTO `sh_merchant_scheme` VALUES ('d1ec33e526bf4db5a542fad2862e2d26', '2018-04-08 11:57:03', 'd5362427712c4eb6ac4dfc723e75c7c8', '1', '0', '0', '08c0a69a74254da4a317f0eee6a58164', '8f47591a92514aac80d0754772bb62b0', '1', null, null, '1', '2018-04-08 11:36:17', '1', '2018-04-08 11:56:30', '0');

-- ----------------------------
-- Table structure for `sh_merchant_scheme_add_service`
-- ----------------------------
DROP TABLE IF EXISTS `sh_merchant_scheme_add_service`;
CREATE TABLE `sh_merchant_scheme_add_service` (
  `MCHT_SCHM_ID` varchar(64) NOT NULL COMMENT '商户方案',
  `AS_ID` varchar(64) NOT NULL COMMENT '增值服务id',
  `AS_CODE` varchar(64) DEFAULT NULL COMMENT '增值编码',
  PRIMARY KEY (`MCHT_SCHM_ID`,`AS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户方案增值服务';

-- ----------------------------
-- Records of sh_merchant_scheme_add_service
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_merchant_scheme_package`
-- ----------------------------
DROP TABLE IF EXISTS `sh_merchant_scheme_package`;
CREATE TABLE `sh_merchant_scheme_package` (
  `MSP_ID` varchar(64) NOT NULL COMMENT 'id',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案id',
  `PKG_ID` varchar(64) DEFAULT NULL COMMENT '功能包id',
  `EDT_PKG_HIS_ID` varchar(64) DEFAULT NULL COMMENT '版本功能包历史id',
  PRIMARY KEY (`MSP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户方案功能包';

-- ----------------------------
-- Records of sh_merchant_scheme_package
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_order`
-- ----------------------------
DROP TABLE IF EXISTS `sh_order`;
CREATE TABLE `sh_order` (
  `ORD_ID` varchar(64) NOT NULL COMMENT '订单id',
  `ORD_NUM` varchar(64) NOT NULL COMMENT '订单号',
  `SCHM_EDT_HIS_ID` varchar(64) NOT NULL COMMENT '方案版本历史id',
  `EDT_PRC_ID` varchar(64) DEFAULT NULL COMMENT '方案版本价格id',
  `SCHM_EDT_PAY_TYPE` char(1) DEFAULT NULL COMMENT '1月付、2年付',
  `SCHM_EDT_PRICE` decimal(9,0) DEFAULT NULL COMMENT '方案价格',
  `SCHM_EDT_INCREASE_PRICE` decimal(9,0) DEFAULT NULL COMMENT '增值包价格',
  `ORD_BUY_NUM` decimal(3,0) NOT NULL COMMENT '购买数量',
  `SERVICE_START_DATE` datetime DEFAULT NULL COMMENT '开始时间',
  `SERVICE_END_DATE` datetime DEFAULT NULL COMMENT '结束时间',
  `ORD_TOTAL_AMOUNT` decimal(9,0) DEFAULT NULL COMMENT '总金额',
  `ORD_PAY_STATUS` char(1) DEFAULT NULL COMMENT '交费状态0未付费、1已付费、欠费',
  `ORD_DISCOUNT_AMOUNT` decimal(9,0) DEFAULT NULL COMMENT '优惠金额',
  `ORD_REAL_AMOUNT` decimal(9,0) DEFAULT NULL COMMENT '实际金额',
  `ACT_ID` varchar(64) DEFAULT NULL COMMENT '活动id',
  `ORD_STATUS` char(1) DEFAULT NULL COMMENT '0正常1作废2系统作废',
  `ORD_TYPE` char(1) DEFAULT NULL COMMENT '1购买、2升级',
  `ORD_OLD_ID` varchar(64) DEFAULT NULL COMMENT '原订单id',
  `CLIENT_MANAGER_ID` varchar(64) DEFAULT NULL COMMENT '客户经理id',
  `CLIENT_MANAGER_NAME` varchar(20) DEFAULT NULL COMMENT '客户经理名称',
  `MCHT_SCHM_ID` varchar(64) NOT NULL COMMENT '商家方案id',
  `MCHT_ID` varchar(64) NOT NULL COMMENT '商家id',
  `ORD_PAY_TYPE` char(1) DEFAULT NULL COMMENT '1线上交、2线下交',
  `ORD_PAY_DATE` datetime DEFAULT NULL COMMENT '交费时间',
  `ORD_PAY_USERNAME` varchar(64) DEFAULT NULL COMMENT '交费人名称',
  `ORD_SALE_TYPE` char(1) DEFAULT NULL COMMENT '1线上、2线下',
  `ORD_CANCEL_DATE` datetime DEFAULT NULL COMMENT '作废时间',
  `ORD_CANCEL_USERNAME` varchar(20) DEFAULT NULL COMMENT '作废人名称',
  `ORD_CANCEL_CAUSE` varchar(200) DEFAULT NULL COMMENT '作废人原因',
  `CREATE_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `REMARKS` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ORD_ID`),
  KEY `IDX_SH_ORDER_SCHM_EDT_ID` (`SCHM_EDT_HIS_ID`),
  KEY `IDX_SH_ORDER_ACT_ID` (`ACT_ID`),
  KEY `IDX_SH_ORDER_CLIENT_MANAGER_ID` (`CLIENT_MANAGER_ID`),
  KEY `IDX_SH_ORDER_MCHT_SCHM_ID` (`MCHT_SCHM_ID`),
  KEY `IDX_SH_ORDER_MCHT_ID` (`MCHT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户订单';

-- ----------------------------
-- Records of sh_order
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_order_addservice_rel`
-- ----------------------------
DROP TABLE IF EXISTS `sh_order_addservice_rel`;
CREATE TABLE `sh_order_addservice_rel` (
  `AS_ID` varchar(64) NOT NULL COMMENT '增值服务id',
  `ORD_ID` varchar(64) NOT NULL COMMENT '订单id',
  `AS_PRICE` decimal(9,0) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`AS_ID`,`ORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单增值服务关联表';

-- ----------------------------
-- Records of sh_order_addservice_rel
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_order_package`
-- ----------------------------
DROP TABLE IF EXISTS `sh_order_package`;
CREATE TABLE `sh_order_package` (
  `ORD_PKG_ID` varchar(64) NOT NULL COMMENT '订单功能包Id',
  `ORD_ID` varchar(64) NOT NULL COMMENT '商户订单id',
  `EDT_PKG_HIS_ID` varchar(64) NOT NULL COMMENT '版本功能包历史id',
  `PKG_NAME` varchar(64) DEFAULT NULL COMMENT '功能包名称',
  PRIMARY KEY (`ORD_PKG_ID`),
  KEY `IDX_SH_ORDER_PACKAGE_PKID` (`EDT_PKG_HIS_ID`),
  KEY `IDX_SH_ORDER_PACKAGE_ORDID` (`ORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单功能包';

-- ----------------------------
-- Records of sh_order_package
-- ----------------------------
INSERT INTO `sh_order_package` VALUES ('0e4e6e467c30414089bcd0eac5658352', '44b1678dca234b5084fe9e718e01d629', 'd277afe8b37f484cbd1603de227584fa', '企业通用2');
INSERT INTO `sh_order_package` VALUES ('1d59f19ec00f4d79984391b292d135d3', '0a0fa752be68420eb4c1e613e2ec6608', '36d92639dd5b42909681a1d08f6e7cf7', 'dyr包2');
INSERT INTO `sh_order_package` VALUES ('2202f2db1fad4622aabcb1e162f702f2', '528b1ac5f5fe4e678cea182859f57e12', '55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '核销包2');
INSERT INTO `sh_order_package` VALUES ('35e270c1784a4e80bae2aad54469b7c1', 'd5362427712c4eb6ac4dfc723e75c7c8', '17e91a9f521249f28efba289f37c374d', '核销包1');
INSERT INTO `sh_order_package` VALUES ('87bb2c052ec54feaa23aa2beb7d29b3e', '44bc5865c1ca4a91a29d5f3c351f7f3e', '36d92639dd5b42909681a1d08f6e7cf7', 'dyr包2');
INSERT INTO `sh_order_package` VALUES ('8fe90cce47a74b7a827c33a38c1ce5a2', 'd961d12588c94bc3b2683e6bd3ed881e', '36d92639dd5b42909681a1d08f6e7cf7', 'dyr包2');
INSERT INTO `sh_order_package` VALUES ('bfd4ef6be90e41d1a32fa3020752b097', '1270824af7c64dfa917b213e4f9ab12e', '17e91a9f521249f28efba289f37c374d', '核销包1');
INSERT INTO `sh_order_package` VALUES ('d4ce9b737aeb40fda0d00ed78250ef75', '25fc068a3cde4c6d9afbe2ede3093f68', '55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '核销包2');
INSERT INTO `sh_order_package` VALUES ('db8890b57c4c4dd9ba8b3e2756d8053e', '5c20c53e7d4649dab76aa63b62f54b59', '55ac95e8cdd24a0bb46c2d0eb4d7a6ff', '核销包2');
INSERT INTO `sh_order_package` VALUES ('f95cd4522cac43fb98e854c7b17b8881', '127d8e8df68545a5a398b54bba05db9f', '17e91a9f521249f28efba289f37c374d', '核销包1');

-- ----------------------------
-- Table structure for `sh_store`
-- ----------------------------
DROP TABLE IF EXISTS `sh_store`;
CREATE TABLE `sh_store` (
  `STORE_ID` varchar(64) NOT NULL COMMENT '门店id',
  `STORE_NAME` varchar(128) DEFAULT NULL COMMENT '门店名称',
  `STORE_CODE` varchar(64) DEFAULT NULL COMMENT '门店编码',
  `STORE_ADRESS` varchar(256) DEFAULT NULL COMMENT '地址',
  `STORE_PHOTO` varchar(30) DEFAULT NULL COMMENT '图片',
  `STORE_IMGS` varchar(300) DEFAULT NULL COMMENT '图片展示',
  `STORE_LINKMAN` varchar(20) DEFAULT NULL COMMENT '负责人',
  `STORE_PHONE` varchar(20) DEFAULT NULL COMMENT '电话',
  `STORE_INFO` varchar(500) DEFAULT NULL COMMENT '门店介绍',
  `Y_LINE` varchar(10) DEFAULT NULL COMMENT '经度',
  `X_LINE` varchar(10) DEFAULT NULL COMMENT '纬度',
  `MCHT_SCHM_ID` varchar(64) DEFAULT NULL COMMENT '商户方案ID',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_BY` varchar(64) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`STORE_ID`),
  UNIQUE KEY `U_SH_STORE_CODE` (`STORE_CODE`),
  KEY `IDX_SH_STORE_MCHT_SCHM_ID` (`MCHT_SCHM_ID`),
  KEY `IDX_SH_STORE_MCHT_ID` (`MCHT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户门店';

-- ----------------------------
-- Records of sh_store
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_store_staff_ref`
-- ----------------------------
DROP TABLE IF EXISTS `sh_store_staff_ref`;
CREATE TABLE `sh_store_staff_ref` (
  `CUST_ID` varchar(64) NOT NULL COMMENT '员工id',
  `STORE_ID` varchar(64) NOT NULL COMMENT '门店id',
  PRIMARY KEY (`STORE_ID`,`CUST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工门店关联表';

-- ----------------------------
-- Records of sh_store_staff_ref
-- ----------------------------

-- ----------------------------
-- Table structure for `sh_version_update`
-- ----------------------------
DROP TABLE IF EXISTS `sh_version_update`;
CREATE TABLE `sh_version_update` (
  `VER_UP_ID` varchar(64) NOT NULL COMMENT 'ID',
  `MCHT_NAME` varchar(256) DEFAULT NULL COMMENT '商户名称',
  `VER_UP_TYPE` char(1) DEFAULT NULL COMMENT '升级类型：1小程序、2版本',
  `VER_UP_DESC` varchar(100) DEFAULT NULL COMMENT '升级描述',
  `VER_UP_CONTENT` varchar(800) DEFAULT NULL COMMENT '升级内容',
  `MCHT_ID` varchar(64) DEFAULT NULL COMMENT '商户id',
  `SCHM_ID` varchar(64) DEFAULT NULL COMMENT '方案id',
  `SCHM_EDT_ID` varchar(64) DEFAULT NULL COMMENT '方案版本id',
  `APLT_ID` varchar(64) DEFAULT NULL COMMENT '小程序id',
  `APLT_VER_CODE` decimal(9,0) DEFAULT NULL COMMENT '小程序版本code',
  `APLT_VER_NAME` varchar(64) DEFAULT NULL COMMENT '版本名称',
  PRIMARY KEY (`VER_UP_ID`),
  KEY `IDX_SH_VERSION_UPDATE_MCHT_ID` (`MCHT_ID`),
  KEY `IDX_SH_VERSION_UPDATE_SCHM_ID` (`SCHM_ID`),
  KEY `IDX_SH_VERSION_UPDATE_SCHM_EDT` (`SCHM_EDT_ID`),
  KEY `IDX_SH_VERSION_UPDATE_APLT_ID` (`APLT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户版本升级';

-- ----------------------------
-- Records of sh_version_update
-- ----------------------------

-- ----------------------------
-- Table structure for `sms_tmpl`
-- ----------------------------
DROP TABLE IF EXISTS `sms_tmpl`;
CREATE TABLE `sms_tmpl` (
  `ST_ID` varchar(20) NOT NULL COMMENT 'ID',
  `ST_TYPE` varchar(20) DEFAULT NULL COMMENT '模板类型',
  `ST_NO` varchar(20) DEFAULT NULL COMMENT '模板编号',
  `ST_CONT` varchar(200) DEFAULT NULL COMMENT '模板内容',
  PRIMARY KEY (`ST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信模板';

-- ----------------------------
-- Records of sms_tmpl
-- ----------------------------
INSERT INTO `sms_tmpl` VALUES ('1', '2', '38100', null);
INSERT INTO `sms_tmpl` VALUES ('2', '1', '11123', null);

-- ----------------------------
-- Table structure for `time_expires`
-- ----------------------------
DROP TABLE IF EXISTS `time_expires`;
CREATE TABLE `time_expires` (
  `TE_ID` varchar(64) NOT NULL COMMENT 'ID',
  `TE_STATUS` char(1) DEFAULT NULL COMMENT '0未处理、1处理、2处理失败',
  `TE_EXPIRE_DATE` datetime DEFAULT NULL COMMENT '过期时间',
  `TE_SERVICE_TYPE` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `TE_SERVICE_PARAMS` varchar(200) DEFAULT NULL COMMENT '逗号分割，根据具体业务类型、参数处理相关逻辑',
  `TE_OBJ_ID` varchar(64) DEFAULT NULL COMMENT '对象id',
  `TE_CUST_ID` varchar(64) DEFAULT NULL COMMENT '客户id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`TE_ID`),
  KEY `IDX_TIME_EXPIRES_EXPIRDATE` (`TE_EXPIRE_DATE`),
  KEY `IDX_TIME_EXPIRES_OBJ_ID` (`TE_OBJ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='时间到期处理';

-- ----------------------------
-- Records of time_expires
-- ----------------------------
INSERT INTO `time_expires` VALUES ('4fb13d8c2a8941a196174e0f974d25cc', '0', '2018-04-11 18:29:10', 'SH_APPLET_SETTING_CODE_UPLOAD', '0', '8f3d7b19c0dc43479f5af955579c0dcf', '1', '2018-04-11 18:29:10', '2018-04-11 18:29:10', null);
INSERT INTO `time_expires` VALUES ('e9dc5e4aefd8481cb61adf821b7c9511', '2', '2018-04-11 17:47:01', 'APP_REVERT_STATUS', '0', '8f3d7b19c0dc43479f5af955579c0dcf', '1', '2018-04-11 17:47:01', '2018-04-11 17:47:01', null);

-- ----------------------------
-- Table structure for `time_expires_bk`
-- ----------------------------
DROP TABLE IF EXISTS `time_expires_bk`;
CREATE TABLE `time_expires_bk` (
  `TE_ID` varchar(64) NOT NULL COMMENT 'ID',
  `TE_STATUS` char(1) DEFAULT NULL COMMENT '0未处理、1处理、2处理失败',
  `TE_EXPIRE_DATE` datetime DEFAULT NULL COMMENT '过期时间',
  `TE_SERVICE_TYPE` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `TE_SERVICE_PARAMS` varchar(200) DEFAULT NULL COMMENT '逗号分割，根据具体业务类型、参数处理相关逻辑',
  `TE_OBJ_ID` varchar(64) DEFAULT NULL COMMENT '对象id',
  `TE_CUST_ID` varchar(64) DEFAULT NULL COMMENT '客户id',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `REMARKS` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`TE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of time_expires_bk
-- ----------------------------
INSERT INTO `time_expires_bk` VALUES ('0e544927bc384f4fa234a5b0cc8d5062', '2', '2018-03-21 18:21:33', 'SH_APPLET_SETTING_CODE_PUB', '0', '1', '1', '2018-03-21 18:21:33', '2018-03-21 18:21:33', null);
INSERT INTO `time_expires_bk` VALUES ('5a9e6cf52a34465896cdbd9e8ae46b62', '1', '2018-03-22 10:42:15', 'SH_APPLET_SETTING_CODE_AUDIT_CHECK', '0', '2', '1', '2018-03-22 10:42:15', '2018-03-22 10:42:15', null);
INSERT INTO `time_expires_bk` VALUES ('746b0505b0204d9f92a00e9fc9f7c979', '1', '2018-03-22 10:25:30', 'SH_APPLET_SETTING_CODE_UPLOAD', '0,a2a57e22b7b04c9785e73dd4fbe26312', '2', '1', '2018-03-22 10:25:30', '2018-03-22 10:25:30', null);
INSERT INTO `time_expires_bk` VALUES ('ad479805624c4550beec380d7a8d456b', '1', '2018-04-11 15:40:24', 'SH_APPLET_SETTING_CODE_UPLOAD', '0,a2a57e22b7b04c9785e73dd4fbe26312', '8f3d7b19c0dc43479f5af955579c0dcf', '1', '2018-04-11 15:40:24', '2018-04-11 15:40:24', null);
INSERT INTO `time_expires_bk` VALUES ('f2596899f2914d85957ec9725c4d7ee7', '2', '2018-04-11 15:38:00', 'APP_REVERT_STATUS', '0', '8f3d7b19c0dc43479f5af955579c0dcf', '1', '2018-04-11 15:38:00', '2018-04-11 15:38:00', null);

-- ----------------------------
-- Table structure for `ur_device`
-- ----------------------------
DROP TABLE IF EXISTS `ur_device`;
CREATE TABLE `ur_device` (
  `DEV_ID` varchar(64) NOT NULL COMMENT 'ID',
  `UUID` varchar(64) NOT NULL COMMENT 'UUID',
  `CUST_ID` varchar(64) DEFAULT NULL COMMENT '客户id',
  `DEV_STATUS` char(1) DEFAULT NULL COMMENT '1登录、2退出登录、3在其它设备登录',
  `BIND_DATE` datetime DEFAULT NULL COMMENT '绑定时间',
  `CLIENT_TYPE` varchar(10) DEFAULT NULL COMMENT 'IP: IPHONE PD: IPAD AD: ANDROID AP: ANDROID PAD',
  `CLIENT_VER_NO` varchar(20) DEFAULT NULL COMMENT '客户端版本',
  `CLIENT_INFO` varchar(500) DEFAULT NULL COMMENT '客户端详情',
  `CLIENT_OS` varchar(100) DEFAULT NULL COMMENT 'I:IOS A:ANDROID',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `DEL_FLAG` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`DEV_ID`),
  KEY `IDX_US_DEVICE_CUSTID` (`CUST_ID`),
  KEY `IDX_US_DEVICE_UUID` (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户设备';

-- ----------------------------
-- Records of ur_device
-- ----------------------------
INSERT INTO `ur_device` VALUES ('082afba3282342babcd79becc666a472', '111', '111', '3', '2018-07-31 17:35:54', '', null, '', 'A', null, '2018-05-10 16:58:25', '2018-05-10 17:36:23', '0');
INSERT INTO `ur_device` VALUES ('1045ca5236df4296afbc0b2c7b56718f', '7202516393', '111', '3', '2018-05-10 16:58:25', '', null, '', 'A', null, '2018-05-10 15:19:47', '2018-05-10 15:28:24', '0');
INSERT INTO `ur_device` VALUES ('1fc4901d930940d1aae5e2cee2e4d13f', '8846968855', '111', '3', '2018-05-10 15:19:47', '', null, '', 'A', null, '2018-05-10 13:30:24', '2018-05-10 13:30:24', '0');
INSERT INTO `ur_device` VALUES ('9e107c7ce2f2482f9cd010c753fb1313', '930655731', '111', '1', '2018-07-31 17:36:07', '', null, '', 'A', null, '2018-07-31 17:35:54', '2018-08-01 17:16:04', '0');
INSERT INTO `ur_device` VALUES ('bab3272359fe4997b908824c0373f1ad', '95676048881', '111', '3', '2018-07-31 17:35:54', '', null, '', 'A', null, '2018-05-11 10:42:03', '2018-05-11 15:04:22', '0');
