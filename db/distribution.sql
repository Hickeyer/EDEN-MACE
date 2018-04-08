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

/*Table structure for table `card_info` */

DROP TABLE IF EXISTS `card_info`;

CREATE TABLE `card_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_num` varchar(100) DEFAULT NULL,
  `card_num` varchar(100) DEFAULT NULL,
  `card_name` varchar(100) DEFAULT NULL,
  `card_img` varchar(100) DEFAULT NULL,
  `card_info` varchar(800) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='可办信用卡信息表';

/*Data for the table `card_info` */

/*Table structure for table `card_order_info` */

DROP TABLE IF EXISTS `card_order_info`;

CREATE TABLE `card_order_info` (
  `id` int(11) DEFAULT NULL,
  `order_name` varchar(100) DEFAULT NULL,
  `order_id` varchar(100) DEFAULT NULL,
  `order_mobile` varchar(100) DEFAULT NULL,
  `order_idcardno` varchar(100) DEFAULT NULL,
  `order_email` varchar(100) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办卡订单信息表';

/*Data for the table `card_order_info` */

/*Table structure for table `dis_dictionary` */

DROP TABLE IF EXISTS `dis_dictionary`;

CREATE TABLE `dis_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_code` varchar(20) DEFAULT NULL COMMENT '字典编码',
  `dis_type` varchar(100) DEFAULT NULL COMMENT '字典隐藏字段',
  `dis_value` varchar(100) DEFAULT NULL COMMENT '字典值，为前台显示用',
  `dis_sort` int(11) DEFAULT NULL COMMENT '排序',
  `dis_sys_id` varchar(1) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(100) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Data for the table `dis_dictionary` */

insert  into `dis_dictionary`(`id`,`dis_code`,`dis_type`,`dis_value`,`dis_sort`,`dis_sys_id`,`is_delete`,`add_time`,`update_time`) values (1000,'disUserType','1','会员',NULL,NULL,'N',NULL,NULL),(1001,'disUserType','0','代理商',NULL,NULL,'N',NULL,NULL),(1002,'disProMode','0','百分比',NULL,NULL,'N',NULL,NULL),(1003,'disProMode','1','金额',NULL,NULL,'N',NULL,NULL),(1004,'disProType','0','交易分润',NULL,NULL,'N',NULL,NULL),(1005,'disProType','1','上下级分润',NULL,NULL,'N',NULL,NULL),(1006,'disProLevel','1','一级',NULL,NULL,'N',NULL,NULL),(1007,'disProLevel','2','二级',NULL,NULL,'N',NULL,NULL),(1008,'disProLevel','3','三级',NULL,NULL,'N',NULL,NULL);

/*Table structure for table `dis_member_info` */

DROP TABLE IF EXISTS `dis_member_info`;

CREATE TABLE `dis_member_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dis_platform_id` varchar(100) DEFAULT NULL,
  `dis_user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `dis_model_id` varchar(100) DEFAULT NULL COMMENT '上级id',
  `dis_full_index` varchar(100) DEFAULT NULL COMMENT '全路径',
  `dis_user_name` varchar(100) DEFAULT NULL,
  `dis_level` int(11) DEFAULT NULL COMMENT '级别',
  `dis_user_type` varchar(10) DEFAULT NULL COMMENT '身份类型(0 代理商 1会员)',
  `dis_note` varchar(100) DEFAULT NULL COMMENT '备注',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dis_member_info` */

insert  into `dis_member_info`(`id`,`dis_platform_id`,`dis_user_id`,`dis_model_id`,`dis_full_index`,`dis_user_name`,`dis_level`,`dis_user_type`,`dis_note`,`add_time`,`update_time`,`is_delete`) values (1,'admin','1111','','1111','11',0,'1','11','2018-03-01 19:16:11','2018-03-01 19:16:11','N'),(2,'admin','111111','1111','1111.111111','11',1,'1','11','2018-04-04 12:21:21','2018-04-04 12:21:21','N'),(3,'admin','12312','111111','1111.111111.12312','aaa',2,'0','aa','2018-04-05 15:56:15','2018-04-05 15:56:15','N'),(4,'admin','12abc','12312','1111.111111.12312.12abc','aabbcc',3,'0','111','2018-04-05 22:12:12','2018-04-05 22:12:12','N'),(5,'admin','12abcsss','111111','1111.111111.12abcsss','aabbccdddd',2,'0','111','2018-04-05 22:12:45','2018-04-05 22:12:45','N'),(6,'admin','asdfsadf','111111','1111.111111.asdfsadf','112321',2,'0','111','2018-04-05 22:12:53','2018-04-05 22:12:53','N'),(7,'admin','ssss','1111','1111.ssss','test',1,'1','string','2018-04-07 20:35:57','2018-04-07 20:35:57','N');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_profi_param` */

insert  into `dis_profi_param`(`id`,`dis_platform_id`,`dis_pro_mode`,`dis_pro_type`,`dis_pro_value`,`dis_pro_level`,`dis_user_type`,`is_delete`,`update_time`,`add_time`) values (1,'admin','0','1','12','1','1','N','2018-04-05 16:24:04','2018-04-05 16:24:04'),(2,'admin','0','0','0.1','2','1','N','2018-04-05 16:30:21','2018-04-05 16:30:21'),(3,'admin','0','0','0.1','2','1','N','2018-04-05 16:32:52','2018-04-05 16:32:52'),(6,'admin','0','0','12','1','1','N',NULL,NULL);

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='分润记录表';

/*Data for the table `dis_profit_record` */

insert  into `dis_profit_record`(`id`,`dis_platform_id`,`dis_get_user_id`,`dis_set_user_id`,`dis_amount`,`dis_pro_type`,`dis_note`,`dis_user_type`,`dis_order_id`,`is_delete`,`add_time`,`update_time`) values (18,'admin','1111','12312','10.00','0','1','1','123','N','2018-04-05 16:44:10','2018-04-05 16:44:10'),(19,'admin','1111','12312','10.00','0','1','1','123','N','2018-04-05 16:44:10','2018-04-05 16:44:10'),(20,'admin','111111','12312','1200.00','1','1','1','123','N','2018-04-05 16:44:42','2018-04-05 16:44:42');

/*Table structure for table `member_amount` */

DROP TABLE IF EXISTS `member_amount`;

CREATE TABLE `member_amount` (
  `id` int(11) DEFAULT NULL,
  `member_code` varchar(100) DEFAULT NULL,
  `member_type` varchar(10) DEFAULT NULL COMMENT '账户类型',
  `member_amount` decimal(12,2) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用金额表';

/*Data for the table `member_amount` */

/*Table structure for table `member_amount_histroy` */

DROP TABLE IF EXISTS `member_amount_histroy`;

CREATE TABLE `member_amount_histroy` (
  `id` int(11) DEFAULT NULL,
  `his_type` varchar(10) DEFAULT NULL COMMENT '收入类型，支出或者收入',
  `his_order` varchar(500) DEFAULT NULL,
  `his_amount` decimal(12,2) DEFAULT NULL,
  `his_note` varchar(800) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户金额变化表';

/*Data for the table `member_amount_histroy` */

/*Table structure for table `memeber_info` */

DROP TABLE IF EXISTS `memeber_info`;

CREATE TABLE `memeber_info` (
  `id` int(11) DEFAULT NULL,
  `member_code` varchar(100) DEFAULT NULL,
  `open_id` varchar(100) DEFAULT NULL,
  `member_name` varchar(100) DEFAULT NULL,
  `member_pwd` varchar(100) DEFAULT NULL,
  `member_source` varchar(100) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息表';

/*Data for the table `memeber_info` */

/*Table structure for table `mobile_message` */

DROP TABLE IF EXISTS `mobile_message`;

CREATE TABLE `mobile_message` (
  `id` int(11) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `send_time` varchar(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `add_time` varchar(100) DEFAULT NULL,
  `is_delete` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发送短信信息表';

/*Data for the table `mobile_message` */

/*Table structure for table `withdrawal_info` */

DROP TABLE IF EXISTS `withdrawal_info`;

CREATE TABLE `withdrawal_info` (
  `id` int(11) DEFAULT NULL,
  `withdraw_num` varchar(100) DEFAULT NULL,
  `withdraw_type` varchar(20) DEFAULT NULL,
  `withdraw_name` varchar(100) DEFAULT NULL,
  `withdraw_mobile` varchar(20) DEFAULT NULL,
  `withdraw_card` varchar(20) DEFAULT NULL,
  `withdraw_amount` decimal(12,2) DEFAULT NULL,
  `withdraw_poundage` decimal(12,2) DEFAULT NULL,
  `real_amount` decimal(12,2) DEFAULT NULL,
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提现信息表';

/*Data for the table `withdrawal_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
