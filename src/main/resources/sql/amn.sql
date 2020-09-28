/*
 Navicat Premium Data Transfer

 Source Server         : 本地库
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : amn

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 28/09/2020 17:45:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_amn
-- ----------------------------
DROP TABLE IF EXISTS `t_amn`;
CREATE TABLE `t_amn`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_amn
-- ----------------------------
INSERT INTO `t_amn` VALUES (1, '图标123411111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111', 'http://localhost:88881/amn/img/img.png');
INSERT INTO `t_amn` VALUES (2, '景色图1', 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.8s7esoQz1ur427577055a3566bb5afda8767befb741a.png');
INSERT INTO `t_amn` VALUES (3, 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.Y1DmZcxbyNeIa33b65d3205ad20a26528de0d0f49c49.jpg', 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.Y1DmZcxbyNeIa33b65d3205ad20a26528de0d0f49c49.jpg');
INSERT INTO `t_amn` VALUES (6, 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.yYI0J5WSjxnNea33dd47b1abd4490b763b280fcdf569.png', 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.yYI0J5WSjxnNea33dd47b1abd4490b763b280fcdf569.png');
INSERT INTO `t_amn` VALUES (8, 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.Ljk2OGa1ZNtr7cd9b4e9ef71bcbca1ebcafa27417388.png', 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.Ljk2OGa1ZNtr7cd9b4e9ef71bcbca1ebcafa27417388.png');
INSERT INTO `t_amn` VALUES (9, 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.yAedEquYRwAYd7e21d7b740a4c024d427b4762ed76b2.jpg', 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.yAedEquYRwAYd7e21d7b740a4c024d427b4762ed76b2.jpg');
INSERT INTO `t_amn` VALUES (11, 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.gOGLUE41HNIl4ee8b9a3d2b73b625fd3f7f087562221.png', 'http://tmp/wx2e227a019a3bf9c9.o6zAJs8YkhBXHQaiPXZtI0buWzsY.gOGLUE41HNIl4ee8b9a3d2b73b625fd3f7f087562221.png');

-- ----------------------------
-- Table structure for t_cla
-- ----------------------------
DROP TABLE IF EXISTS `t_cla`;
CREATE TABLE `t_cla`  (
  `cid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cno` tinyint(3) UNSIGNED ZEROFILL NOT NULL COMMENT '班号',
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班名',
  `caddr` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cla
-- ----------------------------

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu`  (
  `sid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sno` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '学号',
  `sch` decimal(5, 1) UNSIGNED NOT NULL COMMENT '语文',
  `sma` decimal(5, 1) UNSIGNED NOT NULL COMMENT '数学',
  `sen` decimal(5, 1) UNSIGNED NOT NULL COMMENT '英语',
  `sclass` tinyint(3) UNSIGNED ZEROFILL NOT NULL COMMENT '班级',
  `steacher` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '老师',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stu
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys
-- ----------------------------
DROP TABLE IF EXISTS `t_sys`;
CREATE TABLE `t_sys`  (
  `sid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sno` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '系统编号',
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统名称',
  `sversion` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统版本',
  `sremark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '系统备注',
  PRIMARY KEY (`sid`) USING BTREE,
  UNIQUE INDEX `t_sys_001`(`sno`) USING BTREE COMMENT '系统编号唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys
-- ----------------------------
INSERT INTO `t_sys` VALUES (1, 0000000001, 'Windows7操作系统', 'Windows7', '已经不支持更新了11111');
INSERT INTO `t_sys` VALUES (2, 0000000002, 'Windows8操作系统', 'Windows8', '已经不在使用了');
INSERT INTO `t_sys` VALUES (3, 0000000003, 'Windows10操作系统', 'Windows10', '现在正在使用');
INSERT INTO `t_sys` VALUES (4, 0000000004, 'CentOS8操作系统', 'Linux', '正在升级中');

-- ----------------------------
-- Table structure for t_tea
-- ----------------------------
DROP TABLE IF EXISTS `t_tea`;
CREATE TABLE `t_tea`  (
  `tid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `tno` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '工号',
  `tle` tinyint(3) UNSIGNED NOT NULL COMMENT '等级',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tea
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uno` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '编号',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `ino` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `uage` tinyint(3) NULL DEFAULT NULL COMMENT '年龄',
  `usex` tinyint(3) NULL DEFAULT NULL COMMENT '性别',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机',
  `addr` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 0000000001, '张飒', '421126199202124125', '1992-02-12', 28, 0, '13956232145', '湖南省长沙市', '新增用户');
INSERT INTO `t_user` VALUES (2, 0000000002, '张飒1', '421126199202124125', '2020-09-27', 28, 0, '13956232145', '湖南省长沙市', '新增用户');

SET FOREIGN_KEY_CHECKS = 1;
