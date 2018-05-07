/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.20-log : Database - distribution
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`distribution` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `distribution`;

/*Table structure for table `dis_member_info` */

DROP TABLE IF EXISTS `dis_member_info`;

CREATE TABLE `dis_member_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dis_platform_id` varchar(100) DEFAULT NULL,
  `dis_user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `dis_model_id` varchar(100) DEFAULT NULL COMMENT '上级id',
  `dis_full_index` varchar(4000) DEFAULT NULL COMMENT '全路径',
  `dis_user_name` varchar(100) DEFAULT NULL,
  `dis_level` int(11) DEFAULT NULL COMMENT '级别',
  `dis_user_type` varchar(10) DEFAULT NULL COMMENT '身份类型',
  `dis_note` varchar(100) DEFAULT NULL COMMENT '备注',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '删除状态',
  `dis_plat_super` varchar(100) DEFAULT NULL COMMENT '上级代理商id',
  `dis_plat_full_index` varchar(4000) DEFAULT NULL COMMENT '代理商全路径',
  `dis_plat_level` int(11) DEFAULT NULL COMMENT '代理商等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dis_member_info` */

insert  into `dis_member_info`(`id`,`dis_platform_id`,`dis_user_id`,`dis_model_id`,`dis_full_index`,`dis_user_name`,`dis_level`,`dis_user_type`,`dis_note`,`add_time`,`update_time`,`is_delete`,`dis_plat_super`,`dis_plat_full_index`,`dis_plat_level`) values (9,'dist','qinshihuang','','qinshihuang','秦始皇',0,'1','','2018-05-02 20:41:49','2018-05-02 20:41:49','N','dist','admin.dist',1),(10,'dist','qinershi','qinshihuang','qinshihuang.qinershi','秦二世',1,'1','','2018-05-02 20:42:48','2018-05-02 20:42:48','N','dist','admin.dist',1),(11,'dist','liubang','qinershi','qinshihuang.qinershi.liubang','刘邦',2,'1','','2018-05-02 20:43:58','2018-05-02 20:43:58','N','dist','admin.dist',1),(12,'dist','xiangyu','qinershi','qinshihuang.qinershi.xiangyu','项羽',2,'1','','2018-05-02 20:44:27','2018-05-02 20:44:27','N','dist','admin.dist',1),(13,'dist','hanwudi','liubang','qinshihuang.qinershi.liubang.hanwudi','汉武帝',3,'1','','2018-05-02 20:45:18','2018-05-02 20:45:18','N','dist','admin.dist',1),(14,'dist','liuxiug','hanwudi','qinshihuang.qinershi.liubang.hanwudi.liuxiug','刘秀',4,'1','','2018-05-02 20:45:59','2018-05-02 20:45:59','N','dist','admin.dist',1),(15,'dist','liubei','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.liubei','刘备',5,'1','','2018-05-02 20:46:36','2018-05-02 20:46:36','N','dist','admin.dist',1),(16,'dist','caocao','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao','曹操',5,'1','','2018-05-02 20:46:52','2018-05-02 20:46:52','N','dist','admin.dist',1),(17,'dist','sunquan','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.sunquan','孙权',5,'1','','2018-05-02 20:47:05','2018-05-02 20:47:05','N','dist','admin.dist',1),(18,'dist','weichao','caocao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao','魏朝',6,'1','','2018-05-02 20:47:45','2018-05-02 20:47:45','N','dist','admin.dist',1),(19,'dist','suichao','weichao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao','隋朝',7,'1','','2018-05-02 20:48:06','2018-05-02 20:48:06','N','dist','admin.dist',1),(20,'dist','tangchao','suichao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao','唐朝',8,'1','','2018-05-02 20:48:25','2018-05-02 20:48:25','N','dist','admin.dist',1),(21,'dist','songchao','tangchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao','宋朝',9,'1','','2018-05-02 20:48:46','2018-05-02 20:48:46','N','dist','admin.dist',1),(22,'dist','yuanchao','songchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao','元朝',10,'1','','2018-05-02 20:49:07','2018-05-02 20:49:07','N','dist','admin.dist',1),(23,'dist','mingchao','yuanchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao','明朝',11,'0','','2018-05-02 20:53:26','2018-05-02 20:53:26','N','dist','admin.dist',1),(24,'dist','qingchao','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao','清朝',12,'3','','2018-05-02 20:53:46','2018-05-02 20:53:46','N','dist','admin.dist',1),(29,'dist','minguo','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.minguo','民国',13,'0','sss','2018-05-08 00:28:05','2018-05-08 00:28:05','N','yiji','admin.dist.yiji',2);

/*Table structure for table `dis_profi_param` */

DROP TABLE IF EXISTS `dis_profi_param`;

CREATE TABLE `dis_profi_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_platform_id` varchar(100) DEFAULT NULL COMMENT '平台id',
  `dis_pro_mode` varchar(100) NOT NULL COMMENT '分润模型，如 百分比和固定金额',
  `dis_pro_type` varchar(100) DEFAULT NULL COMMENT '分润类别，如上级发展下级分润 ，交易分润。。。。',
  `dis_pro_value` varchar(20) DEFAULT NULL COMMENT '分润值',
  `dis_pro_level` varchar(100) DEFAULT NULL COMMENT '从下往上对应的级别关系',
  `dis_user_type` varchar(100) DEFAULT NULL COMMENT '会员类型（0:代理商 1：会员）',
  `is_delete` varchar(1) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_profi_param` */

insert  into `dis_profi_param`(`id`,`dis_platform_id`,`dis_pro_mode`,`dis_pro_type`,`dis_pro_value`,`dis_pro_level`,`dis_user_type`,`is_delete`,`update_time`,`add_time`) values (2,'admin','0','0','0.1','2','1','N','2018-04-05 16:30:21','2018-04-05 16:30:21'),(3,'admin','0','0','0.1','2','1','N','2018-04-05 16:32:52','2018-04-05 16:32:52');

/*Table structure for table `dis_profit_record` */

DROP TABLE IF EXISTS `dis_profit_record`;

CREATE TABLE `dis_profit_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_platform_id` varchar(100) DEFAULT NULL,
  `dis_get_user_id` varchar(100) DEFAULT NULL,
  `dis_set_user_id` varchar(100) DEFAULT NULL,
  `dis_amount` decimal(12,2) DEFAULT NULL,
  `dis_pro_type` varchar(100) DEFAULT NULL COMMENT '交易类型',
  `dis_note` varchar(400) DEFAULT NULL COMMENT '备注',
  `dis_user_type` varchar(400) DEFAULT NULL,
  `dis_order_id` varchar(20) DEFAULT NULL COMMENT '对应第三方订单编号',
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT '0' COMMENT '分类（0：用户分润 1:平台分润）',
  `before_amount` decimal(12,2) DEFAULT NULL COMMENT '交易前金额',
  `after_amount` decimal(12,2) DEFAULT NULL COMMENT '交易后金额',
  `before_pro_amount` decimal(12,2) DEFAULT NULL COMMENT '交易类型交易前金额',
  `after_pro_amount` decimal(12,2) DEFAULT NULL COMMENT '交易类型交易后金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='分润记录表';

/*Data for the table `dis_profit_record` */

insert  into `dis_profit_record`(`id`,`dis_platform_id`,`dis_get_user_id`,`dis_set_user_id`,`dis_amount`,`dis_pro_type`,`dis_note`,`dis_user_type`,`dis_order_id`,`is_delete`,`add_time`,`update_time`,`type`,`before_amount`,`after_amount`,`before_pro_amount`,`after_pro_amount`) values (18,'admin','1111','12312','10.00','0','1','1','123','N','2018-04-05 16:44:10','2018-04-05 16:44:10','0',NULL,NULL,NULL,NULL),(19,'admin','1111','12312','10.00','0','1','1','123','N','2018-04-05 16:44:10','2018-04-05 16:44:10','0',NULL,NULL,NULL,NULL),(20,'admin','111111','12312','1200.00','1','1','1','123','N','2018-04-05 16:44:42','2018-04-05 16:44:42','0',NULL,NULL,NULL,NULL);

/*Table structure for table `sys_dic` */

DROP TABLE IF EXISTS `sys_dic`;

CREATE TABLE `sys_dic` (
  `dic_id` int(11) NOT NULL AUTO_INCREMENT,
  `dic_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dic_notes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dic_order` int(11) DEFAULT NULL,
  `dic_type_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dic_value` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_delete` varchar(20) COLLATE utf8_bin DEFAULT 'N',
  `add_time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `update_time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_dic` */

insert  into `sys_dic`(`dic_id`,`dic_no`,`dic_notes`,`dic_order`,`dic_type_no`,`dic_value`,`is_delete`,`add_time`,`update_time`) values (43,'0','trade',NULL,'disProType','交易分润','N',NULL,NULL),(44,'1','level',NULL,'disProType','上下级分润','N',NULL,NULL),(45,'1',NULL,NULL,'disProLevel','一级','N',NULL,NULL),(46,'2',NULL,NULL,'disProLevel','二级','N',NULL,NULL),(47,'3',NULL,NULL,'disProLevel','三级','N',NULL,NULL),(48,'4',NULL,NULL,'disProLevel','四级','N',NULL,NULL),(49,'0','即总金额*百分之比',NULL,'disProMode','百分比','N',NULL,NULL),(50,'1','固定金额',NULL,'disProMode','固定金额','N',NULL,NULL),(91,'0',NULL,0,'disUserType','游客','N',NULL,NULL),(92,'1',NULL,1,'disUserType','经理','N',NULL,NULL),(93,'2',NULL,2,'disUserType','老板','N',NULL,NULL),(95,'3',NULL,3,'disUserType','aa','N',NULL,NULL),(101,'1',NULL,NULL,'quanxianid','5','N',NULL,NULL),(102,'2',NULL,NULL,'quanxianid','7','N',NULL,NULL),(103,'3',NULL,NULL,'quanxianid','8','N',NULL,NULL),(104,'4',NULL,NULL,'quanxianid','9','N',NULL,NULL),(105,'5',NULL,NULL,'quanxianid','10','N',NULL,NULL),(10000,'10000','此值不能改变，作为平台标识',10000,'disUserType','平台标识','N',NULL,NULL);

/*Table structure for table `sys_dic_type` */

DROP TABLE IF EXISTS `sys_dic_type`;

CREATE TABLE `sys_dic_type` (
  `dic_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `dic_type_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dic_type_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dic_type_notes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dic_type_order` int(11) DEFAULT NULL,
  `system_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_delete` varchar(20) COLLATE utf8_bin DEFAULT 'N',
  `add_time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `update_time` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dic_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_dic_type` */

insert  into `sys_dic_type`(`dic_type_id`,`dic_type_name`,`dic_type_no`,`dic_type_notes`,`dic_type_order`,`system_no`,`is_delete`,`add_time`,`update_time`) values (27,'分润类别','disProType',NULL,NULL,'pc','N',NULL,NULL),(28,'用户等级','disProLevel',NULL,NULL,'pc','N',NULL,NULL),(29,'分润模型','disProMode',NULL,NULL,'pc','N',NULL,NULL),(40,'用户类型','disUserType',NULL,NULL,'pc','N',NULL,NULL),(42,'权限id','quanxianid',NULL,NULL,'pc','N',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
