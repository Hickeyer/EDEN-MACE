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

/*Table structure for table `dis_amount_situation` */

DROP TABLE IF EXISTS `dis_amount_situation`;

CREATE TABLE `dis_amount_situation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `type` varchar(10) DEFAULT NULL COMMENT '(0:收入,1:支出)',
  `before_change_amount` decimal(10,2) DEFAULT '0.00' COMMENT '总账户变动之前余额',
  `after_change_amount` decimal(10,2) DEFAULT '0.00' COMMENT '总账户变动之后余额',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `specific_before_change_amount` decimal(10,2) DEFAULT '0.00' COMMENT '具体账户变动之前金额',
  `specific_after_change_amount` decimal(10,2) DEFAULT '0.00' COMMENT '具体账户变动之后金额',
  `dis_pro_type` varchar(10) DEFAULT NULL COMMENT '具体账户类型',
  `change_amount` decimal(10,2) DEFAULT NULL COMMENT '账户变动金额',
  `describe` varchar(200) DEFAULT NULL COMMENT '具体变动描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='账户变动表，用于记录账户变动情况';

/*Data for the table `dis_amount_situation` */

insert  into `dis_amount_situation`(`id`,`dis_user_id`,`type`,`before_change_amount`,`after_change_amount`,`add_time`,`specific_before_change_amount`,`specific_after_change_amount`,`dis_pro_type`,`change_amount`,`describe`) values (11,'mingchao','0','10100.00','10200.00','2018-05-31 21:43:01','10200.00','10300.00','0','100.00',NULL),(12,'dist','0','1.00','2.00','2018-05-31 21:43:02','1.00','2.00','1','1.00',NULL),(13,'admin','0','5.00','6.00','2018-05-31 21:43:02','5.00','6.00','1','1.00',NULL),(14,'mingchao','0','0.00','100.00','2018-05-31 21:45:19','0.00','100.00','0','100.00',NULL),(15,'dist','0','0.00','1.00','2018-05-31 21:45:20','0.00','1.00','1','1.00',NULL),(16,'admin','0','0.00','1.00','2018-05-31 21:45:20','0.00','1.00','1','1.00',NULL),(17,'mingchao','1','100.00','50.00','2018-06-09 02:17:57','100.00','50.00','0','50.00',NULL),(18,'mingchao','0','50.00','10050.00','2018-06-09 14:22:34','50.00','10050.00','0','10000.00','minguo的trade账户交易，根据当前费率，获得{}元，'),(19,'dist','0','1.00','2.00','2018-06-09 14:22:35','1.00','2.00','1','1.00','minguo的level账户交易，根据当前费率，获得{}元，'),(20,'admin','0','1.00','2.00','2018-06-09 14:22:35','1.00','2.00','1','1.00','minguo的level账户交易，根据当前费率，获得{}元，'),(21,'mingchao','0','10050.00','10200.00','2018-06-09 14:26:29','10050.00','10200.00','0','150.00','minguo的trade账户交易，根据当前费率，获得150.0元，'),(22,'dist','0','2.00','3.00','2018-06-09 14:26:29','2.00','3.00','1','1.00','minguo的level账户交易，根据当前费率，获得1元，'),(23,'admin','0','2.00','3.00','2018-06-09 14:26:29','2.00','3.00','1','1.00','minguo的level账户交易，根据当前费率，获得1元，'),(24,'mingchao','0','10200.00','11200.00','2018-06-09 14:32:27','10200.00','11200.00','0','1000.00','minguo的trade账户交易，根据当前费率，mingchao获得1000.0元，'),(25,'dist','0','3.00','4.00','2018-06-09 14:32:27','3.00','4.00','1','1.00','minguo的level账户交易，根据当前费率，dist获得1元，'),(26,'admin','0','3.00','4.00','2018-06-09 14:32:27','3.00','4.00','1','1.00','minguo的level账户交易，根据当前费率，admin获得1元，'),(27,'yuanchao','0','0.00','0.00','2018-05-02 20:49:07','0.00','0.00','0','0.00','账户初始化'),(28,'yuanchao','0','0.00','122.20','2018-06-09 20:03:14','0.00','122.20','0','122.20','qingchao的trade账户交易，根据当前费率，yuanchao获得122.2元，'),(29,'mingchao','0','11200.00','12422.00','2018-06-09 20:03:14','11200.00','12422.00','0','1222.00','qingchao的trade账户交易，根据当前费率，mingchao获得1222元，'),(30,'admin','0','4.00','5.00','2018-06-09 20:03:15','4.00','5.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(31,'admin','0','5.00','6.00','2018-06-09 20:03:15','5.00','6.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(32,'yuanchao','0','122.20','244.40','2018-06-09 20:11:09','122.20','244.40','0','122.20','qingchao的trade账户交易，根据当前费率，yuanchao获得122.2元，'),(33,'mingchao','0','12422.00','13644.00','2018-06-09 20:11:09','12422.00','13644.00','0','1222.00','qingchao的trade账户交易，根据当前费率，mingchao获得1222元，'),(34,'admin','0','6.00','7.00','2018-06-09 20:11:09','6.00','7.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(35,'admin','0','7.00','8.00','2018-06-09 20:11:09','7.00','8.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(36,'yuanchao','1','244.40','144.40','2018-06-09 20:16:42','244.40','144.40','0','100.00','yuanchao的trade账户提现'),(37,'yuanchao','0','144.40','244.40','2018-06-09 20:27:54','144.40','244.40','0','100.00','xiaoli的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(38,'mingchao','0','13644.00','14644.00','2018-06-09 20:27:54','13644.00','14644.00','0','1000.00','xiaoli的trade账户交易，根据当前费率，mingchao获得1000元，'),(39,'dist','0','4.00','5.00','2018-06-09 20:27:54','4.00','5.00','1','1.00','xiaoli的level账户交易，根据当前费率，dist获得1元，'),(40,'admin','0','8.00','9.00','2018-06-09 20:27:54','8.00','9.00','1','1.00','xiaoli的level账户交易，根据当前费率，admin获得1元，'),(41,'liuxiug','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(42,'liuxiug','0','0.00','1000.00','2018-06-09 20:49:19','0.00','1000.00','0','1000.00','weichao的trade账户交易，根据当前费率，liuxiug获得1000.0元，'),(43,'caocao','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(44,'caocao','0','0.00','10000.00','2018-06-09 20:49:20','0.00','10000.00','0','10000.00','weichao的trade账户交易，根据当前费率，caocao获得10000元，'),(45,'admin','0','9.00','10.00','2018-06-09 20:49:20','9.00','10.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(46,'admin','0','10.00','11.00','2018-06-09 20:49:20','10.00','11.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(47,'liuxiug','0','1000.00','2000.00','2018-06-09 20:50:00','1000.00','2000.00','0','1000.00','weichao的trade账户交易，根据当前费率，liuxiug获得1000.0元，'),(48,'caocao','0','10000.00','20000.00','2018-06-09 20:50:00','10000.00','20000.00','0','10000.00','weichao的trade账户交易，根据当前费率，caocao获得10000元，'),(49,'admin','0','11.00','12.00','2018-06-09 20:50:00','11.00','12.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(50,'admin','0','12.00','13.00','2018-06-09 20:50:01','12.00','13.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，');

/*Table structure for table `dis_member_amount` */

DROP TABLE IF EXISTS `dis_member_amount`;

CREATE TABLE `dis_member_amount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_user_id` varchar(50) DEFAULT NULL COMMENT '用户标示id',
  `dis_user_name` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `total_amount` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `frozen_amount` decimal(12,2) DEFAULT NULL COMMENT '冻结金额',
  `avaible_amount` decimal(12,2) DEFAULT NULL COMMENT '可用金额',
  `type` varchar(20) DEFAULT '0' COMMENT '类型（0会员 1 代理商）',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `amount_status` varchar(10) DEFAULT NULL COMMENT '状态（0正常 1冻结）',
  `trade_total_amount` decimal(12,2) DEFAULT NULL COMMENT '扩展字段，交易账户总金额',
  `trade_frozen_amount` decimal(12,2) DEFAULT NULL COMMENT '扩展字段，交易账户冻结金额',
  `trade_avaible_amount` decimal(12,2) DEFAULT NULL COMMENT '扩展字段，交易账户可用金额',
  `level_total_amount` decimal(12,2) DEFAULT NULL COMMENT '扩展字段，等级账户总金额',
  `level_frozen_amount` decimal(12,2) DEFAULT NULL COMMENT '扩展字段，等级账户冻结金额',
  `level_avaible_amount` decimal(12,2) DEFAULT NULL COMMENT '扩展字段，等级账户可用金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `dis_member_amount` */

insert  into `dis_member_amount`(`id`,`dis_user_id`,`dis_user_name`,`total_amount`,`frozen_amount`,`avaible_amount`,`type`,`add_time`,`update_time`,`amount_status`,`trade_total_amount`,`trade_frozen_amount`,`trade_avaible_amount`,`level_total_amount`,`level_frozen_amount`,`level_avaible_amount`) values (31,'songchao','宋朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(32,'yuanchao','元朝','244.40','0.00','244.40','0','2018-05-16 00:06:52',NULL,'0','244.40','0.00','244.40','0.00','0.00','0.00'),(33,'mingchao','明朝','14644.00','0.00','14644.00','0','2018-05-16 00:06:52',NULL,'0','14644.00','0.00','14644.00','0.00','0.00','0.00'),(34,'qingchao','清朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(35,'qinershi','秦二世','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(36,'liubang','刘邦','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(37,'xiangyu','项羽','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(38,'hanwudi','汉武帝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(39,'liuxiug','刘秀','2000.00','0.00','2000.00','0','2018-05-16 00:06:52',NULL,'0','2000.00','0.00','2000.00','0.00','0.00','0.00'),(40,'minguo','民国','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(41,'qinshihuang','秦始皇','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(42,'liubei','刘备','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(43,'caocao','曹操','20000.00','0.00','20000.00','0','2018-05-16 00:06:52',NULL,'0','20000.00','0.00','20000.00','0.00','0.00','0.00'),(44,'sunquan','孙权','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(45,'weichao','魏朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(46,'suichao','隋朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(47,'tangchao','唐朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(48,'admin','admin','13.00','0.00','13.00','1','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','13.00','0.00','13.00'),(49,'zhangsan','张三','0.00','0.00','0.00','1','2018-05-16 00:06:52','2018-05-16 00:06:52','0','0.00','0.00','0.00','0.00','0.00','0.00'),(50,'xiaoliuzi','小六子','0.00','0.00','0.00','0','2018-05-28 21:24:41','2018-05-28 21:24:41','0','0.00','0.00','0.00','0.00','0.00','0.00'),(51,'dist','dist','5.00','0.00','5.00','1','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','5.00','0.00','5.00'),(52,'xiaoli','小李','0.00','0.00','0.00','0','2018-06-09 20:26:44','2018-06-09 20:26:44','0','0.00','0.00','0.00','0.00','0.00','0.00');

/*Table structure for table `dis_member_info` */

DROP TABLE IF EXISTS `dis_member_info`;

CREATE TABLE `dis_member_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dis_platform_id` varchar(100) DEFAULT NULL COMMENT '平台',
  `dis_user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `dis_model_id` varchar(100) DEFAULT NULL COMMENT '上级id',
  `dis_full_index` varchar(4000) DEFAULT NULL COMMENT '全路径',
  `dis_user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `dis_level` int(11) DEFAULT NULL COMMENT '级别',
  `dis_user_type` varchar(10) DEFAULT NULL COMMENT '身份类型',
  `dis_note` varchar(100) DEFAULT NULL COMMENT '备注',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '删除状态',
  `dis_plat_super` varchar(100) DEFAULT NULL COMMENT '上级代理商id',
  `dis_plat_full_index` varchar(4000) DEFAULT NULL COMMENT '代理商全路径',
  `dis_plat_level` int(11) DEFAULT NULL COMMENT '代理商等级',
  `type` varchar(10) DEFAULT '0' COMMENT '账户类型(0,会员，1：代理商)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dis_member_info` */

insert  into `dis_member_info`(`id`,`dis_platform_id`,`dis_user_id`,`dis_model_id`,`dis_full_index`,`dis_user_name`,`dis_level`,`dis_user_type`,`dis_note`,`add_time`,`update_time`,`is_delete`,`dis_plat_super`,`dis_plat_full_index`,`dis_plat_level`,`type`) values (9,'dist','qinshihuang','','qinshihuang','秦始皇',0,'1','','2018-05-02 20:41:49','2018-05-02 20:41:49','N','dist','admin.dist',1,'0'),(10,'dist','qinershi','qinshihuang','qinshihuang.qinershi','秦二世',1,'1','','2018-05-02 20:42:48','2018-05-02 20:42:48','N','dist','admin.dist',1,'0'),(11,'dist','liubang','qinershi','qinshihuang.qinershi.liubang','刘邦',2,'1','','2018-05-02 20:43:58','2018-05-02 20:43:58','N','dist','admin.dist',1,'0'),(12,'dist','xiangyu','qinershi','qinshihuang.qinershi.xiangyu','项羽',2,'1','','2018-05-02 20:44:27','2018-05-02 20:44:27','N','dist','admin.dist',1,'0'),(13,'dist','hanwudi','liubang','qinshihuang.qinershi.liubang.hanwudi','汉武帝',3,'1','','2018-05-02 20:45:18','2018-05-02 20:45:18','N','dist','admin.dist',1,'0'),(14,'dist','liuxiug','hanwudi','qinshihuang.qinershi.liubang.hanwudi.liuxiug','刘秀',4,'1','','2018-05-02 20:45:59','2018-05-02 20:45:59','N','dist','admin.dist',1,'0'),(15,'dist','liubei','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.liubei','刘备',5,'1','','2018-05-02 20:46:36','2018-05-02 20:46:36','N','dist','admin.dist',1,'0'),(16,'dist','caocao','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao','曹操',5,'1','','2018-05-02 20:46:52','2018-05-02 20:46:52','N','dist','admin.dist',1,'0'),(17,'dist','sunquan','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.sunquan','孙权',5,'1','','2018-05-02 20:47:05','2018-05-02 20:47:05','N','dist','admin.dist',1,'0'),(18,'dist','weichao','caocao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao','魏朝',6,'1','','2018-05-02 20:47:45','2018-05-02 20:47:45','N','dist','admin.dist',1,'0'),(19,'dist','suichao','weichao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao','隋朝',7,'1','','2018-05-02 20:48:06','2018-05-02 20:48:06','N','dist','admin.dist',1,'0'),(20,'dist','tangchao','suichao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao','唐朝',8,'1','','2018-05-02 20:48:25','2018-05-02 20:48:25','N','dist','admin.dist',1,'0'),(21,'dist','songchao','tangchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao','宋朝',9,'1','','2018-05-02 20:48:46','2018-05-02 20:48:46','N','dist','admin.dist',1,'0'),(22,'dist','yuanchao','songchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao','元朝',10,'1','','2018-05-02 20:49:07','2018-05-02 20:49:07','N','dist','admin.dist',1,'0'),(23,'dist','mingchao','yuanchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao','明朝',11,'1','','2018-05-02 20:53:26','2018-05-02 20:53:26','N','dist','admin.dist',1,'0'),(24,'dist','qingchao','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao','清朝',12,'3','','2018-05-02 20:53:46','2018-05-02 20:53:46','N','dist','admin.dist',1,'0'),(29,'dist','minguo','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.minguo','民国',13,'0','sss','2018-05-08 00:28:05','2018-05-08 00:28:05','N','yiji','admin.dist.yiji',2,'0'),(30,'admin','admin',NULL,'admin','系统管理员',0,'10000',NULL,'2018-05-08 00:28:05','2018-05-08 00:28:05','N',NULL,'admin',0,'1'),(31,'dist','dist','admin','admin.dist','平台商',1,'10000',NULL,'2018-05-08 00:28:05','2018-05-08 00:28:05','N','admin','admin.dist',1,'1'),(32,'dist','yiji','dist','admin.dist.yiji','一级代理',2,'10000',NULL,'2018-05-08 00:28:05','2018-05-08 00:28:05','N','dist','admin.dist.yiji',2,'1'),(33,'zhangsan','zhangsan','admin','admin.zhangsan','张三',1,'10000',NULL,'2018-05-16 00:06:52','2018-05-16 00:06:52','N','admin','admin.zhangsan',1,'1'),(34,'dist','xiaoliuzi','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.xiaoliuzi','小六子',12,'0','dist下的一级用户','2018-05-28 21:24:41','2018-05-28 21:24:41','N','yiji','admin.dist.yiji',2,'0'),(35,'dist','xiaoli','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.xiaoli','小李',12,'0','','2018-06-09 20:26:44','2018-06-09 20:26:44','N','yiji','admin.dist.yiji',2,'0');

/*Table structure for table `dis_profit_param` */

DROP TABLE IF EXISTS `dis_profit_param`;

CREATE TABLE `dis_profit_param` (
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
  `dist_trade_mode` varchar(20) DEFAULT NULL COMMENT '交易方式(分润或者提现)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_profit_param` */

insert  into `dis_profit_param`(`id`,`dis_platform_id`,`dis_pro_mode`,`dis_pro_type`,`dis_pro_value`,`dis_pro_level`,`dis_user_type`,`is_delete`,`update_time`,`add_time`,`dist_trade_mode`) values (2,'dist','0','0','0.1','2','1','N','2018-04-05 16:30:21','2018-04-05 16:30:21','0'),(4,'dist','0','0','1','1','1','N',NULL,'2018-05-28 21:04:31','0'),(5,'admin','1','0','1','1','10000','N',NULL,'2018-05-28 21:17:48','0'),(6,'dist','1','0','1','1','10000','N',NULL,'2018-05-28 21:53:58','0'),(7,'dist','0','0','1','1','0','N',NULL,'2018-05-30 15:46:21','0');

/*Table structure for table `dis_profit_record` */

DROP TABLE IF EXISTS `dis_profit_record`;

CREATE TABLE `dis_profit_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profit_num` varchar(50) DEFAULT NULL COMMENT '收入编号',
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
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 COMMENT='分润记录表';

/*Data for the table `dis_profit_record` */

insert  into `dis_profit_record`(`id`,`profit_num`,`dis_platform_id`,`dis_get_user_id`,`dis_set_user_id`,`dis_amount`,`dis_pro_type`,`dis_note`,`dis_user_type`,`dis_order_id`,`is_delete`,`add_time`,`update_time`,`type`,`before_amount`,`after_amount`,`before_pro_amount`,`after_pro_amount`) values (104,NULL,'dist','mingchao','minguo','100.00','0',NULL,'1','tttt','N','2018-05-31 21:45:19','2018-05-31 21:45:19','0',NULL,NULL,NULL,NULL),(105,NULL,NULL,'dist','minguo','1.00','0',NULL,'10000','tttt','N','2018-05-31 21:45:20','2018-05-31 21:45:20','1',NULL,NULL,NULL,NULL),(106,NULL,NULL,'admin','minguo','1.00','0',NULL,'10000','tttt','N','2018-05-31 21:45:20','2018-05-31 21:45:20','1',NULL,NULL,NULL,NULL),(107,NULL,'dist','mingchao','minguo','10000.00','0',NULL,'1','201806091222','N','2018-06-09 14:22:34','2018-06-09 14:22:34','0',NULL,NULL,NULL,NULL),(108,NULL,NULL,'dist','minguo','1.00','0',NULL,'10000','201806091222','N','2018-06-09 14:22:35','2018-06-09 14:22:35','1',NULL,NULL,NULL,NULL),(109,NULL,NULL,'admin','minguo','1.00','0',NULL,'10000','201806091222','N','2018-06-09 14:22:35','2018-06-09 14:22:35','1',NULL,NULL,NULL,NULL),(110,NULL,'dist','mingchao','minguo','150.00','0',NULL,'1','11111','N','2018-06-09 14:26:29','2018-06-09 14:26:29','0',NULL,NULL,NULL,NULL),(111,NULL,NULL,'dist','minguo','1.00','0',NULL,'10000','11111','N','2018-06-09 14:26:29','2018-06-09 14:26:29','1',NULL,NULL,NULL,NULL),(112,NULL,NULL,'admin','minguo','1.00','0',NULL,'10000','11111','N','2018-06-09 14:26:29','2018-06-09 14:26:29','1',NULL,NULL,NULL,NULL),(113,NULL,'dist','mingchao','minguo','1000.00','0',NULL,'1','test001','N','2018-06-09 14:32:27','2018-06-09 14:32:27','0',NULL,NULL,NULL,NULL),(114,NULL,NULL,'dist','minguo','1.00','0',NULL,'10000','test001','N','2018-06-09 14:32:27','2018-06-09 14:32:27','1',NULL,NULL,NULL,NULL),(115,NULL,NULL,'admin','minguo','1.00','0',NULL,'10000','test001','N','2018-06-09 14:32:27','2018-06-09 14:32:27','1',NULL,NULL,NULL,NULL),(116,NULL,'dist','yuanchao','qingchao','122.20','0',NULL,'1','PRO92003145922','N','2018-06-09 20:03:14','2018-06-09 20:03:14','0',NULL,NULL,NULL,NULL),(117,NULL,'dist','mingchao','qingchao','1222.00','0',NULL,'1','PRO92003145902','N','2018-06-09 20:03:14','2018-06-09 20:03:14','0',NULL,NULL,NULL,NULL),(118,NULL,NULL,'admin','qingchao','1.00','0',NULL,'10000','PRO92003152849','N','2018-06-09 20:03:15','2018-06-09 20:03:15','1',NULL,NULL,NULL,NULL),(119,NULL,NULL,'admin','qingchao','1.00','0',NULL,'10000','PRO92003156298','N','2018-06-09 20:03:15','2018-06-09 20:03:15','1',NULL,NULL,NULL,NULL),(120,'PRO92011090221','dist','yuanchao','qingchao','122.20','0',NULL,'1','sss','N','2018-06-09 20:11:09','2018-06-09 20:11:09','0',NULL,NULL,NULL,NULL),(121,'PRO92011097903','dist','mingchao','qingchao','1222.00','0',NULL,'1','sss','N','2018-06-09 20:11:09','2018-06-09 20:11:09','0',NULL,NULL,NULL,NULL),(122,'PRO92011096613',NULL,'admin','qingchao','1.00','0',NULL,'10000','sss','N','2018-06-09 20:11:09','2018-06-09 20:11:09','1',NULL,NULL,NULL,NULL),(123,'PRO92011090852',NULL,'admin','qingchao','1.00','0',NULL,'10000','sss','N','2018-06-09 20:11:09','2018-06-09 20:11:09','1',NULL,NULL,NULL,NULL),(124,'PRO92027542469','dist','yuanchao','xiaoli','100.00','0',NULL,'1','ffff','N','2018-06-09 20:27:54','2018-06-09 20:27:54','0',NULL,NULL,NULL,NULL),(125,'PRO92027542592','dist','mingchao','xiaoli','1000.00','0',NULL,'1','ffff','N','2018-06-09 20:27:54','2018-06-09 20:27:54','0',NULL,NULL,NULL,NULL),(126,'PRO92027546840',NULL,'dist','xiaoli','1.00','0',NULL,'10000','ffff','N','2018-06-09 20:27:54','2018-06-09 20:27:54','1',NULL,NULL,NULL,NULL),(127,'PRO92027541067',NULL,'admin','xiaoli','1.00','0',NULL,'10000','ffff','N','2018-06-09 20:27:54','2018-06-09 20:27:54','1',NULL,NULL,NULL,NULL),(138,'PRO92049197261','dist','liuxiug','weichao','1000.00','0',NULL,'1','12','N','2018-06-09 20:49:19','2018-06-09 20:49:19','0',NULL,NULL,NULL,NULL),(139,'PRO92049193970','dist','caocao','weichao','10000.00','0',NULL,'1','12','N','2018-06-09 20:49:19','2018-06-09 20:49:19','0',NULL,NULL,NULL,NULL),(140,'PRO92049208933',NULL,'admin','weichao','1.00','0',NULL,'10000','12','N','2018-06-09 20:49:20','2018-06-09 20:49:20','1',NULL,NULL,NULL,NULL),(141,'PRO92049200782',NULL,'admin','weichao','1.00','0',NULL,'10000','12','N','2018-06-09 20:49:20','2018-06-09 20:49:20','1',NULL,NULL,NULL,NULL),(142,'PRO92050008227','dist','liuxiug','weichao','1000.00','0',NULL,'1','12','N','2018-06-09 20:50:00','2018-06-09 20:50:00','0',NULL,NULL,NULL,NULL),(143,'PRO92050005901','dist','caocao','weichao','10000.00','0',NULL,'1','12','N','2018-06-09 20:50:00','2018-06-09 20:50:00','0',NULL,NULL,NULL,NULL),(144,'PRO92050003524',NULL,'admin','weichao','1.00','0',NULL,'10000','12','N','2018-06-09 20:50:00','2018-06-09 20:50:00','1',NULL,NULL,NULL,NULL),(145,'PRO92050011154',NULL,'admin','weichao','1.00','0',NULL,'10000','12','N','2018-06-09 20:50:01','2018-06-09 20:50:01','1',NULL,NULL,NULL,NULL);

/*Table structure for table `dis_withdraw_record` */

DROP TABLE IF EXISTS `dis_withdraw_record`;

CREATE TABLE `dis_withdraw_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `withdraw_num` varchar(50) DEFAULT NULL COMMENT '提现单号',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '提现金额',
  `fee_amount` decimal(10,2) DEFAULT NULL COMMENT '手续费',
  `real_amount` decimal(10,2) DEFAULT NULL COMMENT '实际到账金额',
  `withdraw_time` varchar(20) DEFAULT NULL COMMENT '提现时间',
  `handle_time` varchar(20) DEFAULT NULL COMMENT '处理时间',
  `withdraw_status` varchar(10) DEFAULT NULL COMMENT '处理状态',
  `dis_pro_mode` varchar(10) DEFAULT NULL COMMENT '提现账户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `dis_withdraw_record` */

insert  into `dis_withdraw_record`(`id`,`dis_user_id`,`withdraw_num`,`total_amount`,`fee_amount`,`real_amount`,`withdraw_time`,`handle_time`,`withdraw_status`,`dis_pro_mode`) values (2,'mingchao',NULL,'50.00','0.00','50.00','2018-05-31 21:48:19','2018-06-09 02:17:57','2','0'),(3,'mingchao',NULL,'50.00','2.00','48.00','2018-05-31 21:50:34','2018-06-09 02:18:21','3','0'),(4,'yuanchao','TX92016224444','100.00','2.00','98.00','2018-06-09 20:16:22','2018-06-09 20:16:42','2','0');

/*Table structure for table `dist_withdraw_param` */

DROP TABLE IF EXISTS `dist_withdraw_param`;

CREATE TABLE `dist_withdraw_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `begin_amount` decimal(10,2) DEFAULT NULL COMMENT '开始金额',
  `end_amount` decimal(10,2) DEFAULT NULL COMMENT '结束时间',
  `dis_pro_mode` varchar(10) DEFAULT NULL COMMENT '分润模型，如 百分比和固定金额',
  `dis_withdraw_value` varchar(50) DEFAULT NULL COMMENT '提现值',
  `is_delete` varchar(2) DEFAULT 'N' COMMENT '是否删除',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='提现收费配置表';

/*Data for the table `dist_withdraw_param` */

insert  into `dist_withdraw_param`(`id`,`begin_amount`,`end_amount`,`dis_pro_mode`,`dis_withdraw_value`,`is_delete`,`add_time`,`update_time`) values (4,'0.00','1000.00','1','2','N','2018-05-31 21:50:19',NULL);

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
  `ext_field` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段',
  `ext_field2` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段2',
  PRIMARY KEY (`dic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_dic` */

insert  into `sys_dic`(`dic_id`,`dic_no`,`dic_notes`,`dic_order`,`dic_type_no`,`dic_value`,`is_delete`,`add_time`,`update_time`,`ext_field`,`ext_field2`) values (43,'0','trade',NULL,'disProType','交易分润','N',NULL,NULL,NULL,NULL),(44,'1','level',NULL,'disProType','上下级分润','N',NULL,NULL,NULL,NULL),(45,'1',NULL,NULL,'disProLevel','一级','N',NULL,NULL,NULL,NULL),(46,'2',NULL,NULL,'disProLevel','二级','N',NULL,NULL,NULL,NULL),(47,'3',NULL,NULL,'disProLevel','三级','N',NULL,NULL,NULL,NULL),(48,'4',NULL,NULL,'disProLevel','四级','N',NULL,NULL,NULL,NULL),(49,'0','即总金额*百分之比',NULL,'disProMode','百分比','N',NULL,NULL,NULL,NULL),(50,'1','固定金额',NULL,'disProMode','固定金额','N',NULL,NULL,NULL,NULL),(91,'0',NULL,0,'disUserType','游客','N',NULL,NULL,NULL,NULL),(92,'1',NULL,1,'disUserType','经理','N',NULL,NULL,NULL,NULL),(93,'2',NULL,2,'disUserType','老板','N',NULL,NULL,NULL,NULL),(95,'3',NULL,3,'disUserType','aa','N',NULL,NULL,NULL,NULL),(101,'1',NULL,NULL,'quanxianid','5','N',NULL,NULL,NULL,NULL),(102,'2',NULL,NULL,'quanxianid','7','N',NULL,NULL,NULL,NULL),(103,'3',NULL,NULL,'quanxianid','8','N',NULL,NULL,NULL,NULL),(104,'4',NULL,NULL,'quanxianid','9','N',NULL,NULL,NULL,NULL),(105,'5',NULL,NULL,'quanxianid','10','N',NULL,NULL,NULL,NULL),(10000,'10000','此值不能改变，作为平台标识',10000,'disUserType','平台标识','N',NULL,NULL,NULL,NULL),(10003,'1',NULL,NULL,'withdrawStatus','申请中','N',NULL,NULL,NULL,NULL),(10004,'2',NULL,NULL,'withdrawStatus','审核成功','N',NULL,NULL,NULL,NULL),(10005,'3',NULL,NULL,'withdrawStatus','审核拒绝','N',NULL,NULL,NULL,NULL),(10006,'profit','分润',NULL,'orderPrefix','PRO','N',NULL,NULL,NULL,NULL),(10007,'withdrawl','提现',NULL,'orderPrefix','TX','N',NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_dic_type` */

insert  into `sys_dic_type`(`dic_type_id`,`dic_type_name`,`dic_type_no`,`dic_type_notes`,`dic_type_order`,`system_no`,`is_delete`,`add_time`,`update_time`) values (27,'分润类别','disProType',NULL,NULL,'pc','N',NULL,NULL),(28,'用户等级','disProLevel',NULL,NULL,'pc','N',NULL,NULL),(29,'分润模型','disProMode',NULL,NULL,'pc','N',NULL,NULL),(40,'用户类型','disUserType',NULL,NULL,'pc','N',NULL,NULL),(42,'权限id','quanxianid',NULL,NULL,'pc','N',NULL,NULL),(44,'提现状态','withdrawStatus',NULL,NULL,'pc','N',NULL,NULL),(45,'订单前缀','orderPrefix',NULL,NULL,'pc','N',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
