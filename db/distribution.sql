/*
SQLyog Ultimate v11.11 (64 bit)
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
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8 COMMENT='字典表';

/*Data for the table `dis_dictionary` */

insert  into `dis_dictionary`(`id`,`dis_code`,`dis_type`,`dis_value`,`dis_sort`,`dis_sys_id`,`is_delete`,`add_time`,`update_time`) values (1000,'disUserType','1','会员',NULL,NULL,'N',NULL,NULL),(1001,'disUserType','0','代理商',NULL,NULL,'N',NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dis_member_info` */

insert  into `dis_member_info`(`id`,`dis_platform_id`,`dis_user_id`,`dis_model_id`,`dis_full_index`,`dis_user_name`,`dis_level`,`dis_user_type`,`dis_note`,`add_time`,`update_time`,`is_delete`) values (1,'8009','1111','','1111','11',0,'1','11','2018-03-01 19:16:11','2018-03-01 19:16:11','N');

/*Table structure for table `dis_profi_param` */

DROP TABLE IF EXISTS `dis_profi_param`;

CREATE TABLE `dis_profi_param` (
  `id` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_profi_param` */

/*Table structure for table `dis_profit_record` */

DROP TABLE IF EXISTS `dis_profit_record`;

CREATE TABLE `dis_profit_record` (
  `id` int(11) NOT NULL,
  `dis_platform_id` varchar(100) DEFAULT NULL,
  `dis_get_user_id` varchar(100) DEFAULT NULL,
  `dis_set_user_id` varchar(100) DEFAULT NULL,
  `dis_amount` decimal(12,2) DEFAULT NULL,
  `dis_pro_type` varchar(100) DEFAULT NULL COMMENT '交易类型',
  `dis_note` varchar(400) DEFAULT NULL COMMENT '备注',
  `dis_order_id` varchar(20) DEFAULT NULL COMMENT '对应第三方订单编号',
  `is_delete` varchar(1) DEFAULT NULL,
  `add_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分润记录表';

/*Data for the table `dis_profit_record` */

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
