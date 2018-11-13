/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.20-log : Database - authority
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`authority` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `authority`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Data for the table `dept` */

insert  into `dept`(`id`,`num`,`pid`,`pids`,`simplename`,`fullname`,`tips`,`version`) values (24,1,0,'[0],','总公司','总公司','',NULL),(25,2,24,'[0],[24],','开发部','开发部','',NULL),(26,3,24,'[0],[24],','运营部','运营部','',NULL),(27,4,24,'[0],[24],','战略部','战略部','',NULL);

/*Table structure for table `dict` */

DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Data for the table `dict` */

insert  into `dict`(`id`,`num`,`pid`,`name`,`tips`) values (16,0,0,'状态',NULL),(17,1,16,'启用',NULL),(18,2,16,'禁用',NULL),(29,0,0,'性别',NULL),(30,1,29,'男',NULL),(31,2,29,'女',NULL),(35,0,0,'账号状态',NULL),(36,1,35,'启用',NULL),(37,2,35,'冻结',NULL),(38,3,35,'已删除',NULL);

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=266 DEFAULT CHARSET=utf8 COMMENT='登录记录';

/*Data for the table `login_log` */

insert  into `login_log`(`id`,`logname`,`userid`,`createtime`,`succeed`,`message`,`ip`) values (130,'退出日志',1,'2018-04-06 00:35:15','成功',NULL,'0:0:0:0:0:0:0:1'),(131,'登录日志',1,'2018-04-06 00:35:22','成功',NULL,'0:0:0:0:0:0:0:1'),(132,'登录日志',1,'2018-04-06 00:36:44','成功',NULL,'0:0:0:0:0:0:0:1'),(133,'退出日志',1,'2018-04-07 15:24:27','成功',NULL,'0:0:0:0:0:0:0:1'),(134,'登录日志',1,'2018-04-07 15:34:48','成功',NULL,'127.0.0.1'),(135,'退出日志',1,'2018-04-07 15:35:52','成功',NULL,'0:0:0:0:0:0:0:1'),(136,'登录日志',1,'2018-04-07 15:35:57','成功',NULL,'0:0:0:0:0:0:0:1'),(137,'退出日志',1,'2018-04-08 14:26:16','成功',NULL,'0:0:0:0:0:0:0:1'),(138,'登录日志',46,'2018-04-08 14:26:24','成功',NULL,'0:0:0:0:0:0:0:1'),(139,'退出日志',46,'2018-04-08 14:27:44','成功',NULL,'0:0:0:0:0:0:0:1'),(140,'登录日志',1,'2018-04-08 14:27:49','成功',NULL,'0:0:0:0:0:0:0:1'),(141,'退出日志',1,'2018-04-08 14:51:24','成功',NULL,'0:0:0:0:0:0:0:1'),(142,'登录日志',46,'2018-04-08 14:51:37','成功',NULL,'0:0:0:0:0:0:0:1'),(143,'退出日志',1,'2018-04-08 21:06:05','成功',NULL,'0:0:0:0:0:0:0:1'),(144,'登录日志',46,'2018-04-08 21:06:12','成功',NULL,'0:0:0:0:0:0:0:1'),(145,'退出日志',46,'2018-04-08 21:06:46','成功',NULL,'0:0:0:0:0:0:0:1'),(146,'登录日志',1,'2018-04-08 21:06:53','成功',NULL,'0:0:0:0:0:0:0:1'),(147,'退出日志',1,'2018-04-08 21:17:17','成功',NULL,'0:0:0:0:0:0:0:1'),(148,'登录日志',1,'2018-04-08 21:18:20','成功',NULL,'0:0:0:0:0:0:0:1'),(149,'退出日志',46,'2018-04-14 14:14:53','成功',NULL,'0:0:0:0:0:0:0:1'),(150,'登录日志',46,'2018-04-14 14:15:31','成功',NULL,'0:0:0:0:0:0:0:1'),(151,'退出日志',46,'2018-04-14 14:16:05','成功',NULL,'0:0:0:0:0:0:0:1'),(152,'登录日志',1,'2018-04-14 14:16:15','成功',NULL,'0:0:0:0:0:0:0:1'),(153,'退出日志',1,'2018-04-14 17:20:49','成功',NULL,'0:0:0:0:0:0:0:1'),(154,'登录日志',46,'2018-04-14 17:20:55','成功',NULL,'0:0:0:0:0:0:0:1'),(155,'退出日志',46,'2018-04-14 17:21:06','成功',NULL,'0:0:0:0:0:0:0:1'),(156,'登录日志',1,'2018-04-14 17:21:12','成功',NULL,'0:0:0:0:0:0:0:1'),(157,'退出日志',1,'2018-04-14 17:21:42','成功',NULL,'0:0:0:0:0:0:0:1'),(158,'登录日志',46,'2018-04-14 17:21:49','成功',NULL,'0:0:0:0:0:0:0:1'),(159,'退出日志',46,'2018-04-14 17:39:00','成功',NULL,'0:0:0:0:0:0:0:1'),(160,'登录日志',1,'2018-04-14 17:39:14','成功',NULL,'0:0:0:0:0:0:0:1'),(161,'退出日志',1,'2018-04-14 17:42:04','成功',NULL,'0:0:0:0:0:0:0:1'),(162,'登录日志',46,'2018-04-14 17:42:11','成功',NULL,'0:0:0:0:0:0:0:1'),(163,'退出日志',46,'2018-04-14 17:42:18','成功',NULL,'0:0:0:0:0:0:0:1'),(164,'登录日志',1,'2018-04-14 17:42:23','成功',NULL,'0:0:0:0:0:0:0:1'),(165,'退出日志',1,'2018-04-14 17:44:32','成功',NULL,'0:0:0:0:0:0:0:1'),(166,'登录日志',46,'2018-04-14 17:44:37','成功',NULL,'0:0:0:0:0:0:0:1'),(167,'退出日志',46,'2018-04-14 17:44:46','成功',NULL,'0:0:0:0:0:0:0:1'),(168,'登录日志',1,'2018-04-14 17:44:55','成功',NULL,'0:0:0:0:0:0:0:1'),(169,'登录日志',1,'2018-04-24 20:16:12','成功',NULL,'0:0:0:0:0:0:0:1'),(170,'退出日志',1,'2018-04-24 22:13:43','成功',NULL,'0:0:0:0:0:0:0:1'),(171,'登录日志',1,'2018-04-24 22:13:52','成功',NULL,'0:0:0:0:0:0:0:1'),(172,'退出日志',1,'2018-04-25 14:49:25','成功',NULL,'0:0:0:0:0:0:0:1'),(173,'登录日志',1,'2018-04-25 14:49:32','成功',NULL,'0:0:0:0:0:0:0:1'),(174,'退出日志',1,'2018-04-25 17:33:07','成功',NULL,'0:0:0:0:0:0:0:1'),(175,'登录日志',1,'2018-04-25 17:33:12','成功',NULL,'0:0:0:0:0:0:0:1'),(176,'退出日志',1,'2018-04-25 17:34:24','成功',NULL,'0:0:0:0:0:0:0:1'),(177,'登录日志',1,'2018-04-25 17:34:30','成功',NULL,'0:0:0:0:0:0:0:1'),(178,'退出日志',1,'2018-04-25 20:10:42','成功',NULL,'0:0:0:0:0:0:0:1'),(179,'登录日志',1,'2018-04-25 20:10:49','成功',NULL,'0:0:0:0:0:0:0:1'),(180,'退出日志',1,'2018-04-25 22:56:48','成功',NULL,'0:0:0:0:0:0:0:1'),(181,'登录失败日志',NULL,'2018-04-25 22:56:54','成功','账号:dist,账号密码错误','0:0:0:0:0:0:0:1'),(182,'登录失败日志',NULL,'2018-04-25 22:57:01','成功','账号:dist,账号密码错误','0:0:0:0:0:0:0:1'),(183,'登录日志',46,'2018-04-25 22:57:15','成功',NULL,'0:0:0:0:0:0:0:1'),(184,'退出日志',46,'2018-04-28 15:01:10','成功',NULL,'0:0:0:0:0:0:0:1'),(185,'登录日志',1,'2018-04-28 15:01:24','成功',NULL,'0:0:0:0:0:0:0:1'),(186,'退出日志',1,'2018-05-03 20:37:33','成功',NULL,'0:0:0:0:0:0:0:1'),(187,'登录日志',46,'2018-05-03 20:37:43','成功',NULL,'0:0:0:0:0:0:0:1'),(188,'退出日志',46,'2018-05-03 20:38:00','成功',NULL,'0:0:0:0:0:0:0:1'),(189,'登录日志',1,'2018-05-03 20:38:07','成功',NULL,'0:0:0:0:0:0:0:1'),(190,'退出日志',1,'2018-05-04 23:03:58','成功',NULL,'0:0:0:0:0:0:0:1'),(191,'登录日志',46,'2018-05-04 23:04:15','成功',NULL,'0:0:0:0:0:0:0:1'),(192,'退出日志',46,'2018-05-04 23:15:08','成功',NULL,'0:0:0:0:0:0:0:1'),(193,'登录失败日志',NULL,'2018-05-04 23:15:17','成功','账号:admin,账号密码错误','0:0:0:0:0:0:0:1'),(194,'登录日志',1,'2018-05-04 23:15:26','成功',NULL,'0:0:0:0:0:0:0:1'),(195,'退出日志',1,'2018-05-04 23:59:48','成功',NULL,'0:0:0:0:0:0:0:1'),(196,'登录日志',46,'2018-05-05 00:00:10','成功',NULL,'0:0:0:0:0:0:0:1'),(197,'退出日志',46,'2018-05-05 00:09:10','成功',NULL,'0:0:0:0:0:0:0:1'),(198,'登录日志',47,'2018-05-05 00:09:16','成功',NULL,'0:0:0:0:0:0:0:1'),(199,'登录日志',1,'2018-05-05 00:15:45','成功',NULL,'0:0:0:0:0:0:0:1'),(200,'退出日志',1,'2018-05-05 00:38:02','成功',NULL,'0:0:0:0:0:0:0:1'),(201,'登录日志',46,'2018-05-05 00:38:11','成功',NULL,'0:0:0:0:0:0:0:1'),(202,'退出日志',46,'2018-05-05 00:47:47','成功',NULL,'0:0:0:0:0:0:0:1'),(203,'登录日志',1,'2018-05-05 00:47:55','成功',NULL,'0:0:0:0:0:0:0:1'),(204,'退出日志',1,'2018-05-08 00:26:46','成功',NULL,'0:0:0:0:0:0:0:1'),(205,'登录日志',46,'2018-05-08 00:26:52','成功',NULL,'0:0:0:0:0:0:0:1'),(206,'退出日志',46,'2018-05-08 00:27:30','成功',NULL,'0:0:0:0:0:0:0:1'),(207,'登录日志',1,'2018-05-08 00:27:36','成功',NULL,'0:0:0:0:0:0:0:1'),(208,'登录日志',1,'2018-05-15 17:56:09','成功',NULL,'0:0:0:0:0:0:0:1'),(209,'登录失败日志',NULL,'2018-05-27 13:32:59','成功','账号:admin,账号密码错误','0:0:0:0:0:0:0:1'),(210,'登录日志',1,'2018-05-27 13:33:05','成功',NULL,'0:0:0:0:0:0:0:1'),(211,'登录日志',1,'2018-06-07 23:46:54','成功',NULL,'0:0:0:0:0:0:0:1'),(212,'退出日志',1,'2018-06-09 09:09:56','成功',NULL,'0:0:0:0:0:0:0:1'),(213,'登录失败日志',NULL,'2018-06-09 09:10:03','成功','账号:dist,账号密码错误','0:0:0:0:0:0:0:1'),(214,'登录日志',46,'2018-06-09 09:10:09','成功',NULL,'0:0:0:0:0:0:0:1'),(215,'退出日志',46,'2018-06-09 09:10:22','成功',NULL,'0:0:0:0:0:0:0:1'),(216,'登录日志',49,'2018-06-09 09:10:32','成功',NULL,'0:0:0:0:0:0:0:1'),(217,'退出日志',49,'2018-06-09 09:10:36','成功',NULL,'0:0:0:0:0:0:0:1'),(218,'登录日志',1,'2018-06-09 09:10:52','成功',NULL,'0:0:0:0:0:0:0:1'),(219,'退出日志',1,'2018-06-09 09:11:50','成功',NULL,'0:0:0:0:0:0:0:1'),(220,'登录日志',46,'2018-06-09 09:11:57','成功',NULL,'0:0:0:0:0:0:0:1'),(221,'退出日志',46,'2018-06-09 09:12:07','成功',NULL,'0:0:0:0:0:0:0:1'),(222,'登录日志',1,'2018-06-09 09:12:18','成功',NULL,'0:0:0:0:0:0:0:1'),(223,'退出日志',1,'2018-06-09 09:15:19','成功',NULL,'0:0:0:0:0:0:0:1'),(224,'登录日志',49,'2018-06-09 09:15:29','成功',NULL,'0:0:0:0:0:0:0:1'),(225,'退出日志',49,'2018-06-09 09:25:14','成功',NULL,'0:0:0:0:0:0:0:1'),(226,'登录日志',1,'2018-06-09 09:25:20','成功',NULL,'0:0:0:0:0:0:0:1'),(227,'退出日志',1,'2018-06-09 18:35:12','成功',NULL,'0:0:0:0:0:0:0:1'),(228,'登录日志',46,'2018-06-09 18:35:17','成功',NULL,'0:0:0:0:0:0:0:1'),(229,'退出日志',46,'2018-06-09 18:40:23','成功',NULL,'0:0:0:0:0:0:0:1'),(230,'登录日志',1,'2018-06-09 18:41:32','成功',NULL,'0:0:0:0:0:0:0:1'),(231,'登录日志',1,'2018-06-11 21:18:58','成功',NULL,'0:0:0:0:0:0:0:1'),(232,'登录日志',1,'2018-06-16 20:05:31','成功',NULL,'0:0:0:0:0:0:0:1'),(233,'登录失败日志',NULL,'2018-06-26 17:24:41','成功','账号:admin,账号密码错误','0:0:0:0:0:0:0:1'),(234,'登录日志',1,'2018-06-26 17:24:46','成功',NULL,'0:0:0:0:0:0:0:1'),(235,'登录日志',1,'2018-07-08 23:26:45','成功',NULL,'0:0:0:0:0:0:0:1'),(236,'登录日志',1,'2018-07-17 17:46:10','成功',NULL,'0:0:0:0:0:0:0:1'),(237,'退出日志',1,'2018-07-18 23:05:25','成功',NULL,'0:0:0:0:0:0:0:1'),(238,'登录日志',46,'2018-07-18 23:05:32','成功',NULL,'0:0:0:0:0:0:0:1'),(239,'退出日志',46,'2018-07-18 23:05:48','成功',NULL,'0:0:0:0:0:0:0:1'),(240,'登录日志',49,'2018-07-18 23:05:54','成功',NULL,'0:0:0:0:0:0:0:1'),(241,'退出日志',49,'2018-07-18 23:06:00','成功',NULL,'0:0:0:0:0:0:0:1'),(242,'登录失败日志',NULL,'2018-07-18 23:06:12','成功','账号:admin,账号密码错误','0:0:0:0:0:0:0:1'),(243,'登录日志',1,'2018-07-18 23:06:45','成功',NULL,'0:0:0:0:0:0:0:1'),(244,'登录日志',1,'2018-07-30 12:20:36','成功',NULL,'0:0:0:0:0:0:0:1'),(245,'登录日志',1,'2018-07-30 12:35:49','成功',NULL,'127.0.0.1'),(246,'登录日志',1,'2018-09-03 20:30:49','成功',NULL,'0:0:0:0:0:0:0:1'),(247,'登录日志',1,'2018-09-25 17:32:56','成功',NULL,'0:0:0:0:0:0:0:1'),(248,'登录日志',1,'2018-10-03 18:51:58','成功',NULL,'0:0:0:0:0:0:0:1'),(249,'登录失败日志',NULL,'2018-10-12 23:53:48','成功','账号:admin,账号密码错误','0:0:0:0:0:0:0:1'),(250,'登录日志',1,'2018-10-12 23:53:54','成功',NULL,'0:0:0:0:0:0:0:1'),(251,'登录日志',1,'2018-10-20 15:32:27','成功',NULL,'0:0:0:0:0:0:0:1'),(252,'退出日志',1,'2018-10-20 15:33:48','成功',NULL,'0:0:0:0:0:0:0:1'),(253,'登录日志',46,'2018-10-20 15:33:55','成功',NULL,'0:0:0:0:0:0:0:1'),(254,'退出日志',46,'2018-10-20 15:34:39','成功',NULL,'0:0:0:0:0:0:0:1'),(255,'登录日志',1,'2018-10-20 15:34:48','成功',NULL,'0:0:0:0:0:0:0:1'),(256,'退出日志',1,'2018-10-20 15:35:40','成功',NULL,'0:0:0:0:0:0:0:1'),(257,'登录日志',46,'2018-10-20 15:35:47','成功',NULL,'0:0:0:0:0:0:0:1'),(258,'退出日志',46,'2018-10-20 15:36:01','成功',NULL,'0:0:0:0:0:0:0:1'),(259,'登录日志',1,'2018-10-20 15:36:07','成功',NULL,'0:0:0:0:0:0:0:1'),(260,'退出日志',1,'2018-10-20 15:36:22','成功',NULL,'0:0:0:0:0:0:0:1'),(261,'登录日志',46,'2018-10-20 15:36:28','成功',NULL,'0:0:0:0:0:0:0:1'),(262,'退出日志',46,'2018-10-20 15:40:27','成功',NULL,'0:0:0:0:0:0:0:1'),(263,'登录日志',1,'2018-10-20 15:40:33','成功',NULL,'0:0:0:0:0:0:0:1'),(264,'退出日志',1,'2018-10-20 16:40:27','成功',NULL,'0:0:0:0:0:0:0:1'),(265,'登录日志',46,'2018-10-20 16:40:33','成功',NULL,'0:0:0:0:0:0:0:1');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `menu` */

insert  into `menu`(`id`,`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) values (105,'system','0','[0],','系统管理','fa-user','',10,1,1,NULL,1,1),(106,'mgr','system','[0],[system],','用户管理','','/mgr',1,2,1,NULL,1,0),(107,'mgr_add','mgr','[0],[system],[mgr],','添加用户',NULL,'/mgr/add',1,3,0,NULL,1,0),(108,'mgr_edit','mgr','[0],[system],[mgr],','修改用户',NULL,'/mgr/edit',2,3,0,NULL,1,0),(109,'mgr_delete','mgr','[0],[system],[mgr],','删除用户',NULL,'/mgr/delete',3,3,0,NULL,1,0),(110,'mgr_reset','mgr','[0],[system],[mgr],','重置密码',NULL,'/mgr/reset',4,3,0,NULL,1,0),(111,'mgr_freeze','mgr','[0],[system],[mgr],','冻结用户',NULL,'/mgr/freeze',5,3,0,NULL,1,0),(112,'mgr_unfreeze','mgr','[0],[system],[mgr],','解除冻结用户',NULL,'/mgr/unfreeze',6,3,0,NULL,1,0),(113,'mgr_setRole','mgr','[0],[system],[mgr],','分配角色',NULL,'/mgr/setRole',7,3,0,NULL,1,0),(114,'role','system','[0],[system],','角色管理',NULL,'/role',2,2,1,NULL,1,0),(115,'role_add','role','[0],[system],[role],','添加角色',NULL,'/role/add',1,3,0,NULL,1,0),(116,'role_edit','role','[0],[system],[role],','修改角色',NULL,'/role/edit',2,3,0,NULL,1,0),(117,'role_remove','role','[0],[system],[role],','删除角色',NULL,'/role/remove',3,3,0,NULL,1,0),(118,'role_setAuthority','role','[0],[system],[role],','配置权限',NULL,'/role/setAuthority',4,3,0,NULL,1,0),(119,'menu','system','[0],[system],','菜单管理',NULL,'/menu',4,2,1,NULL,1,0),(120,'menu_add','menu','[0],[system],[menu],','添加菜单',NULL,'/menu/add',1,3,0,NULL,1,0),(121,'menu_edit','menu','[0],[system],[menu],','修改菜单',NULL,'/menu/edit',2,3,0,NULL,1,0),(122,'menu_remove','menu','[0],[system],[menu],','删除菜单',NULL,'/menu/remove',3,3,0,NULL,1,0),(128,'log','system','[0],[system],','业务日志',NULL,'/log',6,2,1,NULL,1,0),(130,'druid','system','[0],[system],','监控管理',NULL,'/druid',7,2,1,NULL,1,NULL),(131,'dept','system','[0],[system],','部门管理',NULL,'/dept',3,2,1,NULL,1,NULL),(133,'loginLog','system','[0],[system],','登录日志',NULL,'/loginLog',6,2,1,NULL,1,NULL),(134,'log_clean','log','[0],[system],[log],','清空日志',NULL,'/log/delLog',3,3,0,NULL,1,NULL),(135,'dept_add','dept','[0],[system],[dept],','添加部门',NULL,'/dept/add',1,3,0,NULL,1,NULL),(136,'dept_update','dept','[0],[system],[dept],','修改部门',NULL,'/dept/update',1,3,0,NULL,1,NULL),(137,'dept_delete','dept','[0],[system],[dept],','删除部门',NULL,'/dept/delete',1,3,0,NULL,1,NULL),(141,'notice','system','[0],[system],','通知管理',NULL,'/notice',9,2,1,NULL,1,NULL),(142,'notice_add','notice','[0],[system],[notice],','添加通知',NULL,'/notice/add',1,3,0,NULL,1,NULL),(143,'notice_update','notice','[0],[system],[notice],','修改通知',NULL,'/notice/update',2,3,0,NULL,1,NULL),(144,'notice_delete','notice','[0],[system],[notice],','删除通知',NULL,'/notice/delete',3,3,0,NULL,1,NULL),(148,'code','system','[0],[system],','代码生成','fa-user','/code',10,2,1,NULL,1,NULL),(149,'api_mgr','duijiecankao','[0],[duijiecankao],','接口文档','','/swagger-ui.html',2,2,1,NULL,1,NULL),(150,'to_menu_edit','menu','[0],[system],[menu],','菜单编辑跳转','','/menu/menu_edit',4,3,0,NULL,1,NULL),(151,'menu_list','menu','[0],[system],[menu],','菜单列表','','/menu/list',5,3,0,NULL,1,NULL),(152,'to_dept_update','dept','[0],[system],[dept],','修改部门跳转','','/dept/dept_update',4,3,0,NULL,1,NULL),(153,'dept_list','dept','[0],[system],[dept],','部门列表','','/dept/list',5,3,0,NULL,1,NULL),(154,'dept_detail','dept','[0],[system],[dept],','部门详情','','/dept/detail',6,3,0,NULL,1,NULL),(158,'log_list','log','[0],[system],[log],','日志列表','','/log/list',2,3,0,NULL,1,NULL),(159,'log_detail','log','[0],[system],[log],','日志详情','','/log/detail',3,3,0,NULL,1,NULL),(160,'del_login_log','loginLog','[0],[system],[loginLog],','清空登录日志','','/loginLog/delLoginLog',1,3,0,NULL,1,NULL),(161,'login_log_list','loginLog','[0],[system],[loginLog],','登录日志列表','','/loginLog/list',2,3,0,NULL,1,NULL),(162,'to_role_edit','role','[0],[system],[role],','修改角色跳转','','/role/role_edit',5,3,0,NULL,1,NULL),(163,'to_role_assign','role','[0],[system],[role],','角色分配跳转','','/role/role_assign',6,3,0,NULL,1,NULL),(164,'role_list','role','[0],[system],[role],','角色列表','','/role/list',7,3,0,NULL,1,NULL),(165,'to_assign_role','mgr','[0],[system],[mgr],','分配角色跳转','','/mgr/role_assign',8,3,0,NULL,1,NULL),(166,'to_user_edit','mgr','[0],[system],[mgr],','编辑用户跳转','','/mgr/user_edit',9,3,0,NULL,1,NULL),(167,'mgr_list','mgr','[0],[system],[mgr],','用户列表','','/mgr/list',10,3,0,NULL,1,NULL),(168,'memmber_manage','huiyuanxinxi','[0],[huiyuanxinxi],','会员管理','','/disMemberInfo',2,2,1,NULL,1,NULL),(169,'profit_param','fenxiaopeizhi','[0],[fenxiaopeizhi],','分润设置','','/disProfiParam',3,2,1,NULL,1,NULL),(170,'profit_order','jiaoyizhongxin','[0],[jiaoyizhongxin],','分润信息','','/disProfitRecord',4,2,1,NULL,1,NULL),(171,'member_add','memmber_manage','[0],[memmber_manage],','模拟新增会员','','/disMemberInfo/add',1,2,0,NULL,1,NULL),(172,'profit_param_add','profit_param','[0],[profit_param],','新增分润类型','','/disProfiParam/add',1,2,0,NULL,1,NULL),(173,'profit_param_delete','profit_param','[0],[profit_param],','删除','','/disProfiParam/delete',2,2,0,NULL,1,NULL),(174,'profit_order_add','profit_order','[0],[profit_order],','模拟交易','','/disProfitRecord/add',1,2,0,NULL,1,NULL),(175,'disMemberInfo_view','memmber_manage','[0],[memmber_manage],','查看关系图','','/disMemberInfo/view',5,2,0,NULL,1,NULL),(176,'key','duijiecankao','[0],[duijiecankao],','查看秘钥','','/key',1,2,1,NULL,1,NULL),(177,'disProfiParam_menu','profit_param','[0],[profit_param],','分润查询','','/disProfiParam/menu',1,2,0,NULL,1,NULL),(178,'dic','fenxiaopeizhi','[0],[fenxiaopeizhi],','分销字典管理','','/dic',9,2,1,NULL,1,NULL),(179,'dic_add','dic','[0],[system],[dic],','分销字典增加','','/dic/add',2,3,0,NULL,1,NULL),(180,'dic_update','dic','[0],[system],[dic],','分销字典修改','','/dic/update',2,3,0,NULL,1,NULL),(181,'dic_delete','dic','[0],[dic],','分销 字典删除','','/dic/delete',3,2,0,NULL,1,NULL),(182,'disMemberAmount','huiyuanxinxi','[0],[huiyuanxinxi],','账单查询','','/disMemberAmount',4,2,1,NULL,1,NULL),(183,'disMemberAmount_menu','disMemberAmount','[0],[disMemberAmount],','账单查询','','/disMemberAmount/menu',1,2,0,NULL,1,NULL),(184,'simOper','duijiecankao','[0],[duijiecankao],','模拟操作','','/simOper',1,2,1,NULL,1,NULL),(185,'simOper_menu','simOper','[0],[simOper],','模拟菜单','','/simOper/menu',1,2,0,NULL,1,NULL),(186,'DistWithdrawParam','fenxiaopeizhi','[0],[fenxiaopeizhi],','提现费率设置','','/DistWithdrawParam',5,2,1,NULL,1,NULL),(187,'DistWithdrawParam_menu','DistWithdrawParam','[0],[DistWithdrawParam],','菜单','','/DistWithdrawParam/menu',1,2,0,NULL,1,NULL),(188,'DistWithdrawParam_add','DistWithdrawParam','[0],[DistWithdrawParam],','新增','','/DistWithdrawParam/add',3,2,0,NULL,1,NULL),(189,'DistWithdrawParam_update','DistWithdrawParam','[0],[DistWithdrawParam],','修改','','/DistWithdrawParam/update',4,2,0,NULL,1,NULL),(190,'DistWithdrawParam_delete','DistWithdrawParam','[0],[DistWithdrawParam],','删除','','/DistWithdrawParam/delete',6,2,0,NULL,1,NULL),(191,'DisWithdrawRecord','jiaoyizhongxin','[0],[jiaoyizhongxin],','提现信息','','/DisWithdrawRecord',6,2,1,NULL,1,NULL),(192,'DisWithdrawRecord_add','DisWithdrawRecord','[0],[DisWithdrawRecord],','菜单','','/DisWithdrawRecord/add',1,2,0,NULL,1,NULL),(193,'duijiecankao','0','[0],','对接参考','','/',1,1,1,NULL,1,NULL),(194,'huiyuanxinxi','0','[0],','会员信息','','/',2,1,1,NULL,1,NULL),(195,'fenxiaopeizhi','0','[0],','分销配置','','/',3,1,1,NULL,1,NULL),(196,'jiaoyizhongxin','0','[0],','交易中心','','/',4,1,1,NULL,1,NULL),(197,'statisticalCenter','0','[0],','统计中心','','/',6,1,1,NULL,1,NULL),(198,'dynamic','statisticalCenter','[0],[statisticalCenter],','交易动态','','/dynamic',1,2,1,NULL,1,NULL),(199,'dynamic_menu','dynamic','[0],[statisticalCenter],[dynamic],','动态查询','','/dynamic/menu',1,3,0,NULL,1,NULL),(200,'dynamic_myaccount','statisticalCenter','[0],[statisticalCenter],','我的账户','','/dynamic/myaccount',2,2,1,NULL,1,NULL),(201,'DisRankParam_menu','fenxiaopeizhi','[0],[fenxiaopeizhi],','段位积分设置','','/DisRankParam',4,2,1,NULL,1,NULL),(202,'disRankParam_add','DisRankParam_menu','[0],[fenxiaopeizhi],[DisRankParam_menu],','添加','','/DisRankParam/add',1,3,0,NULL,1,NULL),(203,'disRankParam_update','DisRankParam_menu','[0],[fenxiaopeizhi],[DisRankParam_menu],','段位积分修改','','/DisRankParam/update',2,3,0,NULL,1,NULL),(204,'disRankParam_delete','DisRankParam_menu','[0],[fenxiaopeizhi],[DisRankParam_menu],','段位积分删除','','/DisRankParam/delete',3,3,0,NULL,1,NULL),(205,'DisUpgradeParam','fenxiaopeizhi','[0],[fenxiaopeizhi],','会员垂直升级配置','','/DisUpgradeParam',6,2,1,NULL,1,NULL),(206,'DisUpgradeParam_add','DisUpgradeParam','[0],[fenxiaopeizhi],[DisUpgradeParam],','添加','','/DisUpgradeParam/add',1,3,0,NULL,1,NULL),(207,'DisUpgradeParam_update','DisUpgradeParam','[0],[fenxiaopeizhi],[DisUpgradeParam],','修改','','/DisUpgradeParam/update',2,3,0,NULL,1,NULL),(208,'DisUpgradeParam_delete','DisUpgradeParam','[0],[fenxiaopeizhi],[DisUpgradeParam],','删除','','/DisUpgradeParam/delete',3,3,0,NULL,1,NULL),(209,'sysJob','system','[0],[system],','任务调度','','/sysJob',6,2,1,NULL,1,NULL),(210,'DisUpgradeParam_agent','fenxiaopeizhi','[0],[fenxiaopeizhi],','代理垂直分润','','/DisUpgradeParam/agent',6,2,1,NULL,1,NULL),(211,'DisUpgradeParam_agent_add','DisUpgradeParam_agent','[0],[fenxiaopeizhi],[DisUpgradeParam_agent],','添加','','/DisUpgradeParam/agent/add',1,3,0,NULL,1,NULL),(212,'DisUpgradeParam_agent_delete','DisUpgradeParam_agent','[0],[fenxiaopeizhi],[DisUpgradeParam_agent],','删除','','/DisUpgradeParam/agent/delete',2,3,0,NULL,1,NULL);

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='通知表';

/*Data for the table `notice` */

insert  into `notice`(`id`,`title`,`type`,`content`,`createtime`,`creater`) values (6,'欢迎界面',10,'欢迎使用分销管理系统','2017-01-11 08:53:20',1),(8,'分销系统介绍',NULL,'微分销系统是在互联网环境下，面对多种复杂的分销系统，可以配置化的对系统进行快速的开发，并且应用到线上，并且不影响自己系统业务的运行。','2017-05-10 19:28:57',1);

/*Table structure for table `operation_log` */

DROP TABLE IF EXISTS `operation_log`;

CREATE TABLE `operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1021 DEFAULT CHARSET=utf8 COMMENT='操作日志';

/*Data for the table `operation_log` */

/*Table structure for table `qrtz_blob_triggers` */

DROP TABLE IF EXISTS `qrtz_blob_triggers`;

CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_blob_triggers` */

/*Table structure for table `qrtz_calendars` */

DROP TABLE IF EXISTS `qrtz_calendars`;

CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_calendars` */

/*Table structure for table `qrtz_cron_triggers` */

DROP TABLE IF EXISTS `qrtz_cron_triggers`;

CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_cron_triggers` */

/*Table structure for table `qrtz_fired_triggers` */

DROP TABLE IF EXISTS `qrtz_fired_triggers`;

CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_fired_triggers` */

/*Table structure for table `qrtz_job_details` */

DROP TABLE IF EXISTS `qrtz_job_details`;

CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_job_details` */

/*Table structure for table `qrtz_locks` */

DROP TABLE IF EXISTS `qrtz_locks`;

CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_locks` */

/*Table structure for table `qrtz_paused_trigger_grps` */

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;

CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_paused_trigger_grps` */

/*Table structure for table `qrtz_scheduler_state` */

DROP TABLE IF EXISTS `qrtz_scheduler_state`;

CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_scheduler_state` */

/*Table structure for table `qrtz_simple_triggers` */

DROP TABLE IF EXISTS `qrtz_simple_triggers`;

CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simple_triggers` */

/*Table structure for table `qrtz_simprop_triggers` */

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;

CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_simprop_triggers` */

/*Table structure for table `qrtz_triggers` */

DROP TABLE IF EXISTS `qrtz_triggers`;

CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `qrtz_triggers` */

/*Table structure for table `relation` */

DROP TABLE IF EXISTS `relation`;

CREATE TABLE `relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5529 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

/*Data for the table `relation` */

insert  into `relation`(`id`,`menuid`,`roleid`) values (4972,105,7),(4973,106,7),(4974,107,7),(4975,108,7),(4976,110,7),(4977,111,7),(4978,112,7),(4979,166,7),(4980,167,7),(4981,194,7),(4982,168,7),(4983,171,7),(4984,175,7),(4985,182,7),(4986,183,7),(4987,196,7),(4988,170,7),(4989,174,7),(4990,191,7),(4991,192,7),(4992,197,7),(4993,198,7),(4994,199,7),(5416,105,1),(5417,106,1),(5418,107,1),(5419,108,1),(5420,109,1),(5421,110,1),(5422,111,1),(5423,112,1),(5424,113,1),(5425,165,1),(5426,166,1),(5427,167,1),(5428,114,1),(5429,115,1),(5430,116,1),(5431,117,1),(5432,118,1),(5433,162,1),(5434,163,1),(5435,164,1),(5436,119,1),(5437,120,1),(5438,121,1),(5439,122,1),(5440,150,1),(5441,151,1),(5442,128,1),(5443,134,1),(5444,158,1),(5445,159,1),(5446,130,1),(5447,131,1),(5448,135,1),(5449,136,1),(5450,137,1),(5451,152,1),(5452,153,1),(5453,154,1),(5454,133,1),(5455,160,1),(5456,161,1),(5457,141,1),(5458,142,1),(5459,143,1),(5460,144,1),(5461,148,1),(5462,209,1),(5463,193,1),(5464,149,1),(5465,176,1),(5466,184,1),(5467,185,1),(5468,194,1),(5469,168,1),(5470,171,1),(5471,175,1),(5472,182,1),(5473,183,1),(5474,195,1),(5475,169,1),(5476,172,1),(5477,173,1),(5478,177,1),(5479,178,1),(5480,179,1),(5481,180,1),(5482,181,1),(5483,186,1),(5484,187,1),(5485,188,1),(5486,189,1),(5487,190,1),(5488,201,1),(5489,202,1),(5490,203,1),(5491,204,1),(5492,205,1),(5493,206,1),(5494,207,1),(5495,208,1),(5496,210,1),(5497,211,1),(5498,212,1),(5499,196,1),(5500,170,1),(5501,174,1),(5502,191,1),(5503,192,1),(5504,197,1),(5505,198,1),(5506,199,1),(5507,200,1),(5508,105,5),(5509,106,5),(5510,107,5),(5511,108,5),(5512,110,5),(5513,111,5),(5514,112,5),(5515,166,5),(5516,167,5),(5517,168,5),(5518,171,5),(5519,175,5),(5520,196,5),(5521,170,5),(5522,174,5),(5523,191,5),(5524,192,5),(5525,197,5),(5526,198,5),(5527,199,5),(5528,200,5);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `role` */

insert  into `role`(`id`,`num`,`pid`,`name`,`deptid`,`tips`,`version`) values (1,1,0,'超级管理员',24,'administrator',1),(5,2,1,'分销商权限',25,'dist',NULL),(7,3,5,'一级代理',24,'一级代理',NULL),(8,4,7,'二级代理',24,'二级代理',NULL),(9,NULL,8,'三级代理',NULL,'三级代理',NULL),(10,NULL,9,'四级代理',24,'四级代理',NULL);

/*Table structure for table `sys_job` */

DROP TABLE IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `job_name` varchar(512) NOT NULL COMMENT '任务名称',
  `job_group` varchar(512) NOT NULL COMMENT '任务组名',
  `job_cron` varchar(512) NOT NULL COMMENT '时间表达式',
  `job_class_path` varchar(1024) NOT NULL COMMENT '类路径,全类型',
  `job_data_map` varchar(1024) DEFAULT NULL COMMENT '传递map参数',
  `job_status` int(2) NOT NULL COMMENT '状态:1启用 0停用',
  `job_describe` varchar(1024) DEFAULT NULL COMMENT '任务功能描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `sys_job` */

insert  into `sys_job`(`id`,`job_name`,`job_group`,`job_cron`,`job_class_path`,`job_data_map`,`job_status`,`job_describe`) values (22,'test','test','*/1 * * * * ?','com.stylefeng.guns.modular.system.task.TestTask1',NULL,0,'a job a'),(23,'会员垂直等级升级','dist','0 0 23 L * ?','com.stylefeng.guns.modular.dist.task.MemberRankTask',NULL,1,'等级升级');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`value`) values (1,'123');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  `secret` varchar(4000) DEFAULT NULL COMMENT '分销商key',
  `superaccount` varchar(45) DEFAULT NULL COMMENT '上级key',
  `fullindex` varchar(4000) DEFAULT NULL COMMENT '全路径',
  `level` varchar(200) DEFAULT NULL COMMENT '等级',
  PRIMARY KEY (`id`,`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='管理员表';

/*Data for the table `user` */

insert  into `user`(`id`,`avatar`,`account`,`password`,`salt`,`name`,`birthday`,`sex`,`email`,`phone`,`roleid`,`deptid`,`status`,`createtime`,`version`,`secret`,`superaccount`,`fullindex`,`level`) values (1,'girl.gif','admin','ecfadcde9305f8891bcfe5a1e28c253e','8pgby','张三','2017-05-05 00:00:00',2,'sn93@qq.com','18200000000','1',27,1,'2016-01-29 08:49:53',25,'111',NULL,'admin','0'),(46,NULL,'dist','e46b7e4742c2ca7efd8ed23117e38daa','bm26x','小江','2018-04-02 00:00:00',1,'','','5',25,1,'2018-04-08 14:25:57',NULL,'ml3GDhKLbFIAGoxGm28e','admin','admin.dist','1'),(49,NULL,'yiji','975fcf11fdbb1618239b24baf0fb4bd1','0bobr','ss','2018-05-07 00:00:00',2,'','','7',24,1,'2018-05-08 00:27:25',NULL,'814puuCtGyLvf3q0qmBe','dist','admin.dist.yiji','2'),(51,NULL,'zhangsan','09e96f7f77cc13669e8ab19770ebc9e5','z6m1l','张三','2018-05-23 00:00:00',1,'','','5',24,1,'2018-05-16 00:06:52',NULL,'Ag6B9t7o1iwbweadayFf','admin','admin.zhangsan','1'),(52,NULL,'yiji_ceshi','b907a8e292595ecc5731bc984d278aab','05092','测试','2018-10-24 00:00:00',1,'1111@qq.com','','7',26,1,'2018-10-20 16:41:10',NULL,'zqJtdLrbp8pe3DFjoC2v','dist','admin.dist.yiji_ceshi','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
