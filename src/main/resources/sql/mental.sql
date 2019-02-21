/*
 Navicat Premium Data Transfer

 Source Server         : mysql-localhost
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : mental

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 21/02/2019 10:09:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parentId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '0', '我的组织', '01', '我的组织');
INSERT INTO `t_department` VALUES ('2', '1', '部门1', '0101', '');
INSERT INTO `t_department` VALUES ('3', '1', '部门2', '0102', '');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parentId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rank` double NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '系统管理', NULL, 'fa fa-cog', 1, 'Y');
INSERT INTO `t_menu` VALUES ('11', '1', '部门管理', '/admin/department/index', '', 1, 'Y');
INSERT INTO `t_menu` VALUES ('12', '1', '角色管理', '/admin/role/index', '', 2, 'Y');
INSERT INTO `t_menu` VALUES ('13', '1', '菜单管理', '/admin/menu/index', '', 3, 'Y');
INSERT INTO `t_menu` VALUES ('14', '1', '用户管理', '/admin/user/index', NULL, 4, 'Y');
INSERT INTO `t_menu` VALUES ('2', '0', '业务1', NULL, 'fa fa-cog', 2, 'Y');
INSERT INTO `t_menu` VALUES ('21', '2', '业务1-1', '/admin/user/index', NULL, 1, 'Y');
INSERT INTO `t_menu` VALUES ('22', '2', '业务1-2', '', '', 2, 'Y');
INSERT INTO `t_menu` VALUES ('221', '22', '业务1-2-1', '/admin/user/index', NULL, 1, 'Y');
INSERT INTO `t_menu` VALUES ('222', '22', '业务1-2-2', '', NULL, 2, 'Y');
INSERT INTO `t_menu` VALUES ('3', '0', '业务2', NULL, 'fa fa-cog', 3, 'Y');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '01');
INSERT INTO `t_role` VALUES ('2', '测试员', '02');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1519912368801000', '2', '2');
INSERT INTO `t_role_menu` VALUES ('1519912368810001', '2', '21');
INSERT INTO `t_role_menu` VALUES ('1519912368812002', '2', '22');
INSERT INTO `t_role_menu` VALUES ('1519912368822003', '2', '221');
INSERT INTO `t_role_menu` VALUES ('1519912368826004', '2', '222');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `departmentId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` datetime NULL DEFAULT NULL,
  `updateTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1', 'admin', '027468B6223DB1A457989B45A3D20D543A92B2BB27442309', '管理员', '13600000000', '1970-01-01', '1', 'Y', '2018-02-25 14:52:32', '2018-02-25 14:52:35');
INSERT INTO `t_user` VALUES ('2', '2', '1', 'admin2', '027468B6223DB1A457989B45A3D20D543A92B2BB27442309', '测试员', '13600000000', '1970-01-01', '1', 'Y', '2018-02-25 14:52:32', '2018-02-25 14:52:35');

SET FOREIGN_KEY_CHECKS = 1;
