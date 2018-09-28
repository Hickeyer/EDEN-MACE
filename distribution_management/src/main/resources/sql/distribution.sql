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
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='账户变动表，用于记录账户变动情况';

/*Data for the table `dis_amount_situation` */

insert  into `dis_amount_situation`(`id`,`dis_user_id`,`type`,`before_change_amount`,`after_change_amount`,`add_time`,`specific_before_change_amount`,`specific_after_change_amount`,`dis_pro_type`,`change_amount`,`describe`) values (11,'mingchao','0','10100.00','10200.00','2018-05-31 21:43:01','10200.00','10300.00','0','100.00',NULL),(12,'dist','0','1.00','2.00','2018-05-31 21:43:02','1.00','2.00','1','1.00',NULL),(13,'admin','0','5.00','6.00','2018-05-31 21:43:02','5.00','6.00','1','1.00',NULL),(14,'mingchao','0','0.00','100.00','2018-05-31 21:45:19','0.00','100.00','0','100.00',NULL),(15,'dist','0','0.00','1.00','2018-05-31 21:45:20','0.00','1.00','1','1.00',NULL),(16,'admin','0','0.00','1.00','2018-05-31 21:45:20','0.00','1.00','1','1.00',NULL),(17,'mingchao','1','100.00','50.00','2018-06-09 02:17:57','100.00','50.00','0','50.00',NULL),(18,'mingchao','0','50.00','10050.00','2018-06-09 14:22:34','50.00','10050.00','0','10000.00','minguo的trade账户交易，根据当前费率，获得{}元，'),(19,'dist','0','1.00','2.00','2018-06-09 14:22:35','1.00','2.00','1','1.00','minguo的level账户交易，根据当前费率，获得{}元，'),(20,'admin','0','1.00','2.00','2018-06-09 14:22:35','1.00','2.00','1','1.00','minguo的level账户交易，根据当前费率，获得{}元，'),(21,'mingchao','0','10050.00','10200.00','2018-06-09 14:26:29','10050.00','10200.00','0','150.00','minguo的trade账户交易，根据当前费率，获得150.0元，'),(22,'dist','0','2.00','3.00','2018-06-09 14:26:29','2.00','3.00','1','1.00','minguo的level账户交易，根据当前费率，获得1元，'),(23,'admin','0','2.00','3.00','2018-06-09 14:26:29','2.00','3.00','1','1.00','minguo的level账户交易，根据当前费率，获得1元，'),(24,'mingchao','0','10200.00','11200.00','2018-06-09 14:32:27','10200.00','11200.00','0','1000.00','minguo的trade账户交易，根据当前费率，mingchao获得1000.0元，'),(25,'dist','0','3.00','4.00','2018-06-09 14:32:27','3.00','4.00','1','1.00','minguo的level账户交易，根据当前费率，dist获得1元，'),(26,'admin','0','3.00','4.00','2018-06-09 14:32:27','3.00','4.00','1','1.00','minguo的level账户交易，根据当前费率，admin获得1元，'),(27,'yuanchao','0','0.00','0.00','2018-05-02 20:49:07','0.00','0.00','0','0.00','账户初始化'),(28,'yuanchao','0','0.00','122.20','2018-06-09 20:03:14','0.00','122.20','0','122.20','qingchao的trade账户交易，根据当前费率，yuanchao获得122.2元，'),(29,'mingchao','0','11200.00','12422.00','2018-06-09 20:03:14','11200.00','12422.00','0','1222.00','qingchao的trade账户交易，根据当前费率，mingchao获得1222元，'),(30,'admin','0','4.00','5.00','2018-06-09 20:03:15','4.00','5.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(31,'admin','0','5.00','6.00','2018-06-09 20:03:15','5.00','6.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(32,'yuanchao','0','122.20','244.40','2018-06-09 20:11:09','122.20','244.40','0','122.20','qingchao的trade账户交易，根据当前费率，yuanchao获得122.2元，'),(33,'mingchao','0','12422.00','13644.00','2018-06-09 20:11:09','12422.00','13644.00','0','1222.00','qingchao的trade账户交易，根据当前费率，mingchao获得1222元，'),(34,'admin','0','6.00','7.00','2018-06-09 20:11:09','6.00','7.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(35,'admin','0','7.00','8.00','2018-06-09 20:11:09','7.00','8.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(36,'yuanchao','1','244.40','144.40','2018-06-09 20:16:42','244.40','144.40','0','100.00','yuanchao的trade账户提现'),(37,'yuanchao','0','144.40','244.40','2018-06-09 20:27:54','144.40','244.40','0','100.00','xiaoli的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(38,'mingchao','0','13644.00','14644.00','2018-06-09 20:27:54','13644.00','14644.00','0','1000.00','xiaoli的trade账户交易，根据当前费率，mingchao获得1000元，'),(39,'dist','0','4.00','5.00','2018-06-09 20:27:54','4.00','5.00','1','1.00','xiaoli的level账户交易，根据当前费率，dist获得1元，'),(40,'admin','0','8.00','9.00','2018-06-09 20:27:54','8.00','9.00','1','1.00','xiaoli的level账户交易，根据当前费率，admin获得1元，'),(41,'liuxiug','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(42,'liuxiug','0','0.00','1000.00','2018-06-09 20:49:19','0.00','1000.00','0','1000.00','weichao的trade账户交易，根据当前费率，liuxiug获得1000.0元，'),(43,'caocao','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(44,'caocao','0','0.00','10000.00','2018-06-09 20:49:20','0.00','10000.00','0','10000.00','weichao的trade账户交易，根据当前费率，caocao获得10000元，'),(45,'admin','0','9.00','10.00','2018-06-09 20:49:20','9.00','10.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(46,'admin','0','10.00','11.00','2018-06-09 20:49:20','10.00','11.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(47,'liuxiug','0','1000.00','2000.00','2018-06-09 20:50:00','1000.00','2000.00','0','1000.00','weichao的trade账户交易，根据当前费率，liuxiug获得1000.0元，'),(48,'caocao','0','10000.00','20000.00','2018-06-09 20:50:00','10000.00','20000.00','0','10000.00','weichao的trade账户交易，根据当前费率，caocao获得10000元，'),(49,'admin','0','11.00','12.00','2018-06-09 20:50:00','11.00','12.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(50,'admin','0','12.00','13.00','2018-06-09 20:50:01','12.00','13.00','1','1.00','weichao的level账户交易，根据当前费率，admin获得1元，'),(51,'qinershi','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(52,'qinershi','0','0.00','188.80','2018-06-10 11:24:22','0.00','188.80','0','188.80','hanwudi的trade账户交易，根据当前费率，qinershi获得188.8元，'),(53,'liubang','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(54,'liubang','0','0.00','1888.00','2018-06-10 11:24:22','0.00','1888.00','0','1888.00','hanwudi的trade账户交易，根据当前费率，liubang获得1888元，'),(55,'admin','0','13.00','14.00','2018-06-10 11:24:22','13.00','14.00','1','1.00','hanwudi的level账户交易，根据当前费率，admin获得1元，'),(56,'admin','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(57,'admin','0','14.00','221.68','2018-06-10 11:24:22','0.00','207.68','0','207.68','hanwudi的trade账户交易，根据当前费率，admin获得207.68元，'),(58,'hanwudi','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(59,'hanwudi','0','0.00','180.00','2018-06-10 11:33:41','0.00','180.00','0','180.00','sunquan的trade账户交易，根据当前费率，hanwudi获得180.0元，'),(60,'liuxiug','0','2000.00','3800.00','2018-06-10 11:33:41','2000.00','3800.00','0','1800.00','sunquan的trade账户交易，根据当前费率，liuxiug获得1800元，'),(61,'admin','0','221.68','222.68','2018-06-10 11:33:41','14.00','15.00','1','1.00','sunquan的level账户交易，根据当前费率，admin获得1元，'),(62,'admin','0','222.68','282.68','2018-06-10 11:33:41','15.00','75.00','1','60.00','sunquan的level账户交易，根据当前费率，admin获得60元，'),(63,'yuanchao','0','244.40','344.40','2018-06-26 17:25:28','244.40','344.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(64,'mingchao','0','14644.00','14744.00','2018-06-26 17:25:28','14644.00','14744.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(65,'admin','0','282.68','283.68','2018-06-26 17:25:28','75.00','76.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(66,'admin','0','283.68','343.68','2018-06-26 17:25:28','76.00','136.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(67,'yuanchao','0','344.40','444.40','2018-06-26 17:28:01','344.40','444.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(68,'mingchao','0','14744.00','14844.00','2018-06-26 17:28:01','14744.00','14844.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(69,'admin','0','343.68','344.68','2018-06-26 17:28:01','136.00','137.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(70,'admin','0','344.68','404.68','2018-06-26 17:28:01','137.00','197.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(71,'yuanchao','0','444.40','544.40','2018-06-26 17:28:55','444.40','544.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(72,'mingchao','0','14844.00','14944.00','2018-06-26 17:28:55','14844.00','14944.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(73,'admin','0','404.68','405.68','2018-06-26 17:30:51','197.00','198.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(74,'admin','0','405.68','465.68','2018-06-26 17:30:51','198.00','258.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(75,'yuanchao','0','544.40','644.40','2018-06-26 17:31:33','544.40','644.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(76,'mingchao','0','14944.00','15044.00','2018-06-26 17:31:33','14944.00','15044.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(77,'admin','0','465.68','466.68','2018-06-26 17:32:47','258.00','259.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(78,'admin','0','466.68','526.68','2018-06-26 17:32:47','259.00','319.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(79,'yuanchao','0','644.40','744.40','2018-06-26 17:33:10','644.40','744.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(80,'mingchao','0','15044.00','15144.00','2018-06-26 17:33:10','15044.00','15144.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(81,'admin','0','526.68','527.68','2018-06-26 17:34:41','319.00','320.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(82,'admin','0','527.68','587.68','2018-06-26 17:34:41','320.00','380.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(83,'yuanchao','0','744.40','844.40','2018-06-26 17:34:49','744.40','844.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(84,'mingchao','0','15144.00','15244.00','2018-06-26 17:34:49','15144.00','15244.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(85,'admin','0','587.68','588.68','2018-06-26 17:34:59','380.00','381.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(86,'admin','0','588.68','648.68','2018-06-26 17:35:04','381.00','441.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(87,'yuanchao','0','844.40','944.40','2018-06-26 17:35:36','844.40','944.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(88,'mingchao','0','15244.00','15344.00','2018-06-26 17:35:36','15244.00','15344.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(89,'admin','0','648.68','649.68','2018-06-26 18:18:49','441.00','442.00','1','1.00','qingchao的level账户交易，根据当前费率，admin获得1元，'),(90,'admin','0','649.68','709.68','2018-06-26 18:18:49','442.00','502.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(91,'yuanchao','0','944.40','1044.40','2018-06-26 18:27:59','944.40','1044.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(92,'mingchao','0','15344.00','15444.00','2018-06-26 18:27:59','15344.00','15444.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(93,'admin','0','709.68','769.68','2018-06-26 18:28:28','502.00','562.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(94,'yuanchao','0','1044.40','1144.40','2018-06-26 18:28:31','1044.40','1144.40','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(95,'mingchao','0','15444.00','15544.00','2018-06-26 18:28:31','15444.00','15544.00','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(96,'admin','0','769.68','829.68','2018-06-26 18:29:25','562.00','622.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(133,'mingchao','0','15544.00','15644.00','2018-06-26 18:54:20','15544.00','15644.00','0','100.00','minguo的trade账户交易，根据当前费率，mingchao获得100.0元，'),(134,'dist','0','5.00','6.00','2018-06-26 18:54:20','5.00','6.00','1','1.00','minguo的level账户交易，根据当前费率，dist获得1元，'),(135,'yiji','2','0.00','0.00','2018-06-26 18:54:20','0.00','0.00','1','0.00','账户初始化'),(136,'yiji','0','0.00','20.00','2018-06-26 18:54:20','0.00','20.00','1','20.00','minguo的level账户交易，根据当前费率，yiji获得20元，'),(137,'admin','0','829.68','889.68','2018-06-26 18:54:20','622.00','682.00','1','60.00','minguo的level账户交易，根据当前费率，admin获得60元，'),(138,'mingchao','0','15644.00','15744.00','2018-06-26 18:58:06','15644.00','15744.00','0','100.00','minguo的trade账户交易，根据当前费率，mingchao获得100.0元，'),(139,'dist','0','6.00','7.00','2018-06-26 18:58:06','6.00','7.00','1','1.00','minguo的level账户交易，根据当前费率，dist获得1元，'),(140,'yiji','0','0.00','20.00','2018-06-26 18:58:06','0.00','20.00','1','20.00','minguo的level账户交易，根据当前费率，yiji获得20元，'),(141,'admin','0','889.68','949.68','2018-06-26 18:58:06','682.00','742.00','1','60.00','minguo的level账户交易，根据当前费率，admin获得60元，'),(142,'mingchao','0','15744.00','15844.00','2018-06-26 18:59:08','15744.00','15844.00','0','100.00','minguo的trade账户交易，根据当前费率，mingchao获得100.0元，'),(143,'dist','0','7.00','8.00','2018-06-26 18:59:08','7.00','8.00','1','1.00','minguo的level账户交易，根据当前费率，dist获得1元，'),(144,'yiji','0','20.00','40.00','2018-06-26 18:59:08','20.00','40.00','1','20.00','minguo的level账户交易，根据当前费率，yiji获得20元，'),(145,'admin','0','949.68','1009.68','2018-06-26 18:59:08','742.00','802.00','1','60.00','minguo的level账户交易，根据当前费率，admin获得60元，'),(146,'mingchao','0','15844.00','15944.00','2018-06-26 18:59:45','15844.00','15944.00','0','100.00','minguo的trade账户交易，根据当前费率，mingchao获得100.0元，'),(147,'dist','0','8.00','9.00','2018-06-26 18:59:46','8.00','9.00','1','1.00','minguo的level账户交易，根据当前费率，dist获得1元，'),(148,'yiji','0','40.00','60.00','2018-06-26 19:00:24','40.00','60.00','1','20.00','minguo的level账户交易，根据当前费率，yiji获得20元，'),(149,'admin','0','1009.68','1069.68','2018-06-26 19:00:28','802.00','862.00','1','60.00','minguo的level账户交易，根据当前费率，admin获得60元，'),(150,'yuanchao','0','1144.40','1156.60','2018-07-01 00:51:16','1144.40','1156.60','0','12.20','qingchao的trade账户交易，根据当前费率，yuanchao获得12.2元，'),(151,'mingchao','0','15944.00','15956.20','2018-07-01 00:51:16','15944.00','15956.20','0','12.20','qingchao的trade账户交易，根据当前费率，mingchao获得12.2元，'),(152,'dist','0','9.00','10.00','2018-07-01 00:51:16','9.00','10.00','1','1.00','qingchao的level账户交易，根据当前费率，dist获得1元，'),(153,'admin','0','1069.68','1129.68','2018-07-01 00:51:16','862.00','922.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(154,'dist','0','10.00','11.00','2018-07-01 01:32:34','10.00','11.00','1','1.00','fasongdao的level账户交易，根据当前费率，dist获得1元，'),(155,'admin','0','1129.68','1189.68','2018-07-01 01:32:34','922.00','982.00','1','60.00','fasongdao的level账户交易，根据当前费率，admin获得60元，'),(156,'dist','0','11.00','12.00','2018-07-01 01:34:02','11.00','12.00','1','1.00','fasongdao的level账户交易，根据当前费率，dist获得1元，'),(157,'admin','0','1189.68','1249.68','2018-07-01 01:34:02','982.00','1042.00','1','60.00','fasongdao的level账户交易，根据当前费率，admin获得60元，'),(158,'dist','0','12.00','13.00','2018-07-01 01:35:28','12.00','13.00','1','1.00','fasongdao的level账户交易，根据当前费率，dist获得1元，'),(159,'admin','0','1249.68','1309.68','2018-07-01 01:35:28','1042.00','1102.00','1','60.00','fasongdao的level账户交易，根据当前费率，admin获得60元，'),(160,'dist','0','13.00','14.00','2018-07-01 01:38:59','13.00','14.00','1','1.00','fasongdao的level账户交易，根据当前费率，dist获得1元，'),(161,'admin','0','1309.68','1369.68','2018-07-01 01:38:59','1102.00','1162.00','1','60.00','fasongdao的level账户交易，根据当前费率，admin获得60元，'),(162,'dist','0','14.00','15.00','2018-07-01 01:40:16','14.00','15.00','1','1.00','fasongdao的level账户交易，根据当前费率，dist获得1元，'),(163,'admin','0','1369.68','1429.68','2018-07-01 01:40:16','1162.00','1222.00','1','60.00','fasongdao的level账户交易，根据当前费率，admin获得60元，'),(164,'yuanchao','0','1156.60','1256.60','2018-07-23 00:24:14','1156.60','1256.60','0','100.00','qingchao的trade账户交易，根据当前费率，yuanchao获得100.0元，'),(165,'mingchao','0','15956.20','16056.20','2018-07-23 00:24:14','15956.20','16056.20','0','100.00','qingchao的trade账户交易，根据当前费率，mingchao获得100.0元，'),(166,'dist','0','15.00','16.00','2018-07-23 00:24:14','15.00','16.00','1','1.00','qingchao的level账户交易，根据当前费率，dist获得1元，'),(167,'admin','0','1429.68','1489.68','2018-07-23 00:24:14','1222.00','1282.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(168,'yuanchao','0','1256.60','1446.60','2018-07-23 00:25:35','1256.60','1446.60','0','190.00','qingchao的trade账户交易，根据当前费率，yuanchao获得190.0元，'),(169,'mingchao','0','16056.20','16246.20','2018-07-23 00:25:35','16056.20','16246.20','0','190.00','qingchao的trade账户交易，根据当前费率，mingchao获得190.0元，'),(170,'dist','0','16.00','17.00','2018-07-23 00:25:35','16.00','17.00','1','1.00','qingchao的level账户交易，根据当前费率，dist获得1元，'),(171,'admin','0','1489.68','1549.68','2018-07-23 00:25:35','1282.00','1342.00','1','60.00','qingchao的level账户交易，根据当前费率，admin获得60元，'),(172,'mingchao','0','16246.20','16256.20','2018-07-30 12:21:27','16246.20','16256.20','0','10.00','shunzhi的trade账户交易，根据当前费率，mingchao获得10.0元，'),(173,'qingchao','2','0.00','0.00','2018-05-16 00:06:52','0.00','0.00','0','0.00','账户初始化'),(174,'qingchao','0','0.00','10.00','2018-07-30 12:21:27','0.00','10.00','0','10.00','shunzhi的trade账户交易，根据当前费率，qingchao获得10.0元，'),(175,'dist','0','17.00','18.00','2018-07-30 12:21:28','17.00','18.00','1','1.00','shunzhi的level账户交易，根据当前费率，dist获得1元，'),(176,'admin','0','1549.68','1609.68','2018-07-30 12:21:28','1342.00','1402.00','1','60.00','shunzhi的level账户交易，根据当前费率，admin获得60元，');

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
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='账户金额表';

/*Data for the table `dis_member_amount` */

insert  into `dis_member_amount`(`id`,`dis_user_id`,`dis_user_name`,`total_amount`,`frozen_amount`,`avaible_amount`,`type`,`add_time`,`update_time`,`amount_status`,`trade_total_amount`,`trade_frozen_amount`,`trade_avaible_amount`,`level_total_amount`,`level_frozen_amount`,`level_avaible_amount`) values (31,'songchao','宋朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(32,'yuanchao','元朝','1446.60','0.00','1446.60','0','2018-05-16 00:06:52',NULL,'0','1446.60','0.00','1446.60','0.00','0.00','0.00'),(33,'mingchao','明朝','16256.20','0.00','16256.20','0','2018-05-16 00:06:52',NULL,'0','16256.20','0.00','16256.20','0.00','0.00','0.00'),(34,'qingchao','清朝','10.00','1.00','9.00','0','2018-05-16 00:06:52',NULL,'0','10.00','1.00','9.00','0.00','0.00','0.00'),(35,'qinershi','秦二世','188.80','0.00','188.80','0','2018-05-16 00:06:52',NULL,'0','188.80','0.00','188.80','0.00','0.00','0.00'),(36,'liubang','刘邦','1888.00','0.00','1888.00','0','2018-05-16 00:06:52',NULL,'0','1888.00','0.00','1888.00','0.00','0.00','0.00'),(37,'xiangyu','项羽','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(38,'hanwudi','汉武帝','180.00','0.00','180.00','0','2018-05-16 00:06:52',NULL,'0','180.00','0.00','180.00','0.00','0.00','0.00'),(39,'liuxiug','刘秀','3800.00','0.00','3800.00','0','2018-05-16 00:06:52',NULL,'0','3800.00','0.00','3800.00','0.00','0.00','0.00'),(40,'minguo','民国','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(41,'qinshihuang','秦始皇','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(42,'liubei','刘备','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(43,'caocao','曹操','20000.00','0.00','20000.00','0','2018-05-16 00:06:52',NULL,'0','20000.00','0.00','20000.00','0.00','0.00','0.00'),(44,'sunquan','孙权','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(45,'weichao','魏朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(46,'suichao','隋朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(47,'tangchao','唐朝','0.00','0.00','0.00','0','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','0.00','0.00','0.00'),(48,'admin','admin','1609.68','0.00','1609.68','1','2018-05-16 00:06:52',NULL,'0','207.68','0.00','207.68','1402.00','0.00','1402.00'),(49,'zhangsan','张三','0.00','0.00','0.00','1','2018-05-16 00:06:52','2018-05-16 00:06:52','0','0.00','0.00','0.00','0.00','0.00','0.00'),(50,'xiaoliuzi','小六子','0.00','0.00','0.00','0','2018-05-28 21:24:41','2018-05-28 21:24:41','0','0.00','0.00','0.00','0.00','0.00','0.00'),(51,'dist','dist','18.00','0.00','18.00','1','2018-05-16 00:06:52',NULL,'0','0.00','0.00','0.00','18.00','0.00','18.00'),(52,'xiaoli','小李','0.00','0.00','0.00','0','2018-06-09 20:26:44','2018-06-09 20:26:44','0','0.00','0.00','0.00','0.00','0.00','0.00'),(53,'guanggaofei','???','0.00','0.00','0.00','0','2018-06-16 16:17:02','2018-06-16 16:17:02','0','0.00','0.00','0.00','0.00','0.00','0.00'),(54,'shishishang','???','0.00','0.00','0.00','0','2018-06-16 16:17:47','2018-06-16 16:17:47','0','0.00','0.00','0.00','0.00','0.00','0.00'),(55,'fafafa','???','0.00','0.00','0.00','0','2018-06-16 16:20:08','2018-06-16 16:20:08','0','0.00','0.00','0.00','0.00','0.00','0.00'),(56,'fafafaa','????','0.00','0.00','0.00','0','2018-06-16 16:28:19','2018-06-16 16:28:19','0','0.00','0.00','0.00','0.00','0.00','0.00'),(57,'zhongwenluanma','中文乱码','0.00','0.00','0.00','0','2018-06-16 16:28:54','2018-06-16 16:28:54','0','0.00','0.00','0.00','0.00','0.00','0.00'),(58,'sasashuisuo','洒洒水所','0.00','0.00','0.00','0','2018-06-16 17:07:49','2018-06-16 17:07:49','0','0.00','0.00','0.00','0.00','0.00','0.00'),(59,'fandesa','范德萨','0.00','0.00','0.00','0','2018-06-16 17:08:31','2018-06-16 17:08:31','0','0.00','0.00','0.00','0.00','0.00','0.00'),(60,'xiaoxiao','小小','0.00','0.00','0.00','0','2018-06-16 17:15:45','2018-06-16 17:15:45','0','0.00','0.00','0.00','0.00','0.00','0.00'),(61,'ouyangyiboa','欧阳一波啊','0.00','0.00','0.00','0','2018-06-20 22:27:32','2018-06-20 22:27:32','0','0.00','0.00','0.00','0.00','0.00','0.00'),(62,'fasongdao','发送到','0.00','0.00','0.00','0','2018-06-20 22:29:07','2018-06-20 22:29:07','0','0.00','0.00','0.00','0.00','0.00','0.00'),(63,'yiji','yiji','60.00','0.00','60.00','1','2018-06-26 18:58:06','2018-06-26 18:58:06','0','0.00','0.00','0.00','60.00','0.00','60.00'),(71,'sanji','三级测试','0.00','0.00','0.00','0','2018-07-18 00:42:33','2018-07-18 00:42:33','0','0.00','0.00','0.00','0.00','0.00','0.00'),(72,'sanji2','三级测试2','0.00','0.00','0.00','0','2018-07-18 00:42:52','2018-07-18 00:42:52','0','0.00','0.00','0.00','0.00','0.00','0.00'),(73,'huangpu','sss','0.00','0.00','0.00','0','2018-07-18 23:32:28','2018-07-18 23:32:28','0','0.00','0.00','0.00','0.00','0.00','0.00'),(74,'yaoqingjf','邀请积分','0.00','0.00','0.00','0','2018-07-23 23:28:07','2018-07-23 23:28:07','0','0.00','0.00','0.00','0.00','0.00','0.00'),(75,'yaoqingjf1','邀请积分1','0.00','0.00','0.00','0','2018-07-23 23:31:43','2018-07-23 23:31:43','0','0.00','0.00','0.00','0.00','0.00','0.00'),(76,'shunzhi','顺治','0.00','0.00','0.00','0','2018-07-30 12:21:10','2018-07-30 12:21:10','0','0.00','0.00','0.00','0.00','0.00','0.00'),(77,'wde','ss','0.00','0.00','0.00','0','2018-07-30 12:24:44','2018-07-30 12:24:44','0','0.00','0.00','0.00','0.00','0.00','0.00'),(78,'wdess','ssss','0.00','0.00','0.00','0','2018-07-30 12:24:54','2018-07-30 12:24:54','0','0.00','0.00','0.00','0.00','0.00','0.00');

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
  `dis_user_rank` varchar(10) DEFAULT 'A' COMMENT '用户段位(青铜、黄金、白银等)',
  `dis_note` varchar(100) DEFAULT NULL COMMENT '备注',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '删除状态',
  `dis_plat_super` varchar(100) DEFAULT NULL COMMENT '上级代理商id',
  `dis_plat_full_index` varchar(4000) DEFAULT NULL COMMENT '代理商全路径',
  `dis_plat_level` int(11) DEFAULT NULL COMMENT '代理商等级',
  `type` varchar(10) DEFAULT '0' COMMENT '账户类型(0,会员，1：代理商)',
  `rank_integral` int(10) DEFAULT '0' COMMENT '段位积分',
  `total_rank_integral` int(10) DEFAULT NULL COMMENT '段位总积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `dis_member_info` */

insert  into `dis_member_info`(`id`,`dis_platform_id`,`dis_user_id`,`dis_model_id`,`dis_full_index`,`dis_user_name`,`dis_level`,`dis_user_type`,`dis_user_rank`,`dis_note`,`add_time`,`update_time`,`is_delete`,`dis_plat_super`,`dis_plat_full_index`,`dis_plat_level`,`type`,`rank_integral`,`total_rank_integral`) values (9,'dist','qinshihuang','','qinshihuang','秦始皇',0,'1','A','','2018-05-02 20:41:49','2018-05-02 20:41:49','N','dist','admin.dist',1,'0',0,NULL),(10,'dist','qinershi','qinshihuang','qinshihuang.qinershi','秦二世',1,'1','A','','2018-05-02 20:42:48','2018-05-02 20:42:48','N','dist','admin.dist',1,'0',0,NULL),(11,'dist','liubang','qinershi','qinshihuang.qinershi.liubang','刘邦',2,'1','A','','2018-05-02 20:43:58','2018-05-02 20:43:58','N','dist','admin.dist',1,'0',0,NULL),(12,'dist','xiangyu','qinershi','qinshihuang.qinershi.xiangyu','项羽',2,'1','A','','2018-05-02 20:44:27','2018-05-02 20:44:27','N','dist','admin.dist',1,'0',0,NULL),(13,'dist','hanwudi','liubang','qinshihuang.qinershi.liubang.hanwudi','汉武帝',3,'1','A','','2018-05-02 20:45:18','2018-05-02 20:45:18','N','dist','admin.dist',1,'0',0,NULL),(14,'dist','liuxiug','hanwudi','qinshihuang.qinershi.liubang.hanwudi.liuxiug','刘秀',4,'1','A','','2018-05-02 20:45:59','2018-05-02 20:45:59','N','dist','admin.dist',1,'0',0,NULL),(15,'dist','liubei','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.liubei','刘备',5,'1','A','','2018-05-02 20:46:36','2018-05-02 20:46:36','N','dist','admin.dist',1,'0',0,NULL),(16,'dist','caocao','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao','曹操',5,'1','A','','2018-05-02 20:46:52','2018-05-02 20:46:52','N','dist','admin.dist',1,'0',0,NULL),(17,'dist','sunquan','liuxiug','qinshihuang.qinershi.liubang.hanwudi.liuxiug.sunquan','孙权',5,'1','A','','2018-05-02 20:47:05','2018-05-02 20:47:05','N','dist','admin.dist',1,'0',0,NULL),(18,'dist','weichao','caocao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao','魏朝',6,'1','A','','2018-05-02 20:47:45','2018-05-02 20:47:45','N','dist','admin.dist',1,'0',0,NULL),(19,'dist','suichao','weichao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao','隋朝',7,'1','A','','2018-05-02 20:48:06','2018-05-02 20:48:06','N','dist','admin.dist',1,'0',0,NULL),(20,'dist','tangchao','suichao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao','唐朝',8,'1','A','','2018-05-02 20:48:25','2018-05-02 20:48:25','N','dist','admin.dist',1,'0',0,NULL),(21,'dist','songchao','tangchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao','宋朝',9,'1','A','','2018-05-02 20:48:46','2018-05-02 20:48:46','N','dist','admin.dist',1,'0',0,NULL),(22,'dist','yuanchao','songchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao','元朝',10,'1','A','','2018-05-02 20:49:07','2018-05-02 20:49:07','N','dist','admin.dist',1,'0',0,NULL),(23,'dist','mingchao','yuanchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao','明朝',11,'1','A','','2018-05-02 20:53:26','2018-05-02 20:53:26','N','dist','admin.dist',1,'0',290,NULL),(24,'dist','qingchao','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao','清朝',12,'1','A','','2018-05-02 20:53:46','2018-05-02 20:53:46','N','dist','admin.dist',1,'0',140,NULL),(29,'dist','minguo','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.minguo','民国',13,'0','A','sss','2018-05-08 00:28:05','2018-05-08 00:28:05','N','yiji','admin.dist.yiji',2,'0',0,NULL),(30,'admin','admin',NULL,'admin','系统管理员',0,'10000','A',NULL,'2018-05-08 00:28:05','2018-05-08 00:28:05','N',NULL,'admin',0,'1',0,NULL),(31,'dist','dist','admin','admin.dist','平台商',1,'10000','A',NULL,'2018-05-08 00:28:05','2018-05-08 00:28:05','N','admin','admin.dist',1,'1',0,NULL),(32,'dist','yiji','dist','admin.dist.yiji','一级代理',2,'10000','A',NULL,'2018-05-08 00:28:05','2018-05-08 00:28:05','N','dist','admin.dist.yiji',2,'1',0,NULL),(33,'zhangsan','zhangsan','admin','admin.zhangsan','张三',1,'10000','A',NULL,'2018-05-16 00:06:52','2018-05-16 00:06:52','N','admin','admin.zhangsan',1,'1',0,NULL),(34,'dist','xiaoliuzi','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.xiaoliuzi','小六子',12,'0','A','dist下的一级用户','2018-05-28 21:24:41','2018-05-28 21:24:41','N','yiji','admin.dist.yiji',2,'0',0,NULL),(35,'dist','xiaoli','mingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.xiaoli','小李',12,'0','A','','2018-06-09 20:26:44','2018-06-09 20:26:44','N','yiji','admin.dist.yiji',2,'0',0,NULL),(36,'dist','guanggaofei','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.guanggaofei','???',13,'0','A','???plug??','2018-06-16 16:17:02','2018-06-16 16:17:02','N','dist','admin.dist',1,'0',0,NULL),(37,'dist','shishishang','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.shishishang','???',13,'0','A','???plug??','2018-06-16 16:17:47','2018-06-16 16:17:47','N','dist','admin.dist',1,'0',0,NULL),(38,'dist','fafafa','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.fafafa','???',13,'0','A','???plug??','2018-06-16 16:20:08','2018-06-16 16:20:08','N','dist','admin.dist',1,'0',0,NULL),(39,'dist','fafafaa','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.fafafaa','????',13,'0','A','???plug??','2018-06-16 16:28:19','2018-06-16 16:28:19','N','dist','admin.dist',1,'0',0,NULL),(40,'dist','zhongwenluanma','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.zhongwenluanma','中文乱码',13,'0','A','来源：plug测试','2018-06-16 16:28:54','2018-06-16 16:28:54','N','dist','admin.dist',1,'0',0,NULL),(41,'dist','sasashuisuo','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.sasashuisuo','洒洒水所',13,'0','A','来源：plug测试','2018-06-16 17:07:49','2018-06-16 17:07:49','N','dist','admin.dist',1,'0',0,NULL),(42,'dist','fandesa','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.fandesa','范德萨',13,'0','A','来源：plug测试','2018-06-16 17:08:31','2018-06-16 17:08:31','N','dist','admin.dist',1,'0',0,NULL),(43,'dist','xiaoxiao','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.xiaoxiao','小小',13,'0','A','来源：plug测试','2018-06-16 17:15:45','2018-06-16 17:15:45','N','dist','admin.dist',1,'0',0,NULL),(44,'dist','ouyangyiboa','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.ouyangyiboa','欧阳一波啊',13,'0','A','来源：plug测试','2018-06-20 22:27:32','2018-06-20 22:27:32','N','dist','admin.dist',1,'0',0,NULL),(45,'dist','fasongdao','qingchao','qinshihuang.qinershi.liubang.hanwudi.liuxiug.caocao.weichao.suichao.tangchao.songchao.yuanchao.mingchao.qingchao.fasongdao','发送到',2,'2','A','来源：plug测试','2018-06-20 22:29:07','2018-06-20 22:29:07','N','dist','admin.dist',1,'0',0,NULL),(53,'dist','sanji','qingchao','mingchao.qingchao.sanji','三级测试',3,'0','A','测试','2018-07-18 00:42:32','2018-07-18 00:42:32','N','dist','admin.dist',1,'0',0,NULL),(54,'dist','sanji2','sanji','qingchao.sanji.sanji2','三级测试2',3,'0','A','测试2','2018-07-18 00:42:52','2018-07-18 00:42:52','N','dist','admin.dist',1,'0',0,NULL),(55,'dist','huangpu','qingchao','mingchao.qingchao.huangpu','sss',3,'0','A','','2018-07-18 23:32:28','2018-07-18 23:32:28','N','dist','admin.dist',1,'0',0,NULL),(56,'dist','yaoqingjf','qingchao','mingchao.qingchao.yaoqingjf','邀请积分',3,'0','A','积分测试','2018-07-23 23:28:07','2018-07-23 23:28:07','N','dist','admin.dist',1,'0',0,NULL),(57,'dist','yaoqingjf1','qingchao','mingchao.qingchao.yaoqingjf1','邀请积分1',3,'0','A','积分测试','2018-07-23 23:31:43','2018-07-23 23:31:43','N','dist','admin.dist',1,'0',0,NULL),(58,'dist','shunzhi','qingchao','mingchao.qingchao.shunzhi','顺治',3,'0','A','测试','2018-07-30 12:21:10','2018-07-30 12:21:10','N','dist','admin.dist',1,'0',10,NULL),(59,'zhangsan','wde','zhangsan','admin.zhangsan.wde','ss',2,'0','A','s','2018-07-30 12:24:44','2018-07-30 12:24:44','N','zhangsan','admin.zhangsan',1,'0',0,NULL),(60,'dist','wdess','zhangsan','admin.zhangsan.wdess','ssss',2,'0','A','s','2018-07-30 12:24:54','2018-07-30 12:24:54','N','dist','admin.dist',1,'0',0,NULL);

/*Table structure for table `dis_profit_param` */

DROP TABLE IF EXISTS `dis_profit_param`;

CREATE TABLE `dis_profit_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_platform_id` varchar(100) DEFAULT NULL COMMENT '平台id',
  `dis_pro_mode` varchar(100) NOT NULL COMMENT '分润模型，如 百分比和固定金额',
  `dis_pro_type` varchar(100) DEFAULT NULL COMMENT '分润类别，如上级发展下级分润 ，交易分润。。。。',
  `dis_pro_value` varchar(20) DEFAULT NULL COMMENT '分润值',
  `dis_pro_level` varchar(100) DEFAULT NULL COMMENT '从下往上对应的级别关系',
  `dis_user_type` varchar(10) DEFAULT NULL COMMENT '会员类型（1000：平台标示，其他为用户类型）',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '是否删除',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `dist_trade_mode` varchar(20) DEFAULT NULL COMMENT '交易方式(分润或者提现)',
  `dis_user_rank` varchar(10) DEFAULT 'A' COMMENT '用户段位（青铜等）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_profit_param` */

insert  into `dis_profit_param`(`id`,`dis_platform_id`,`dis_pro_mode`,`dis_pro_type`,`dis_pro_value`,`dis_pro_level`,`dis_user_type`,`is_delete`,`update_time`,`add_time`,`dist_trade_mode`,`dis_user_rank`) values (2,'dist','0','0','0.1','2','1','N','2018-04-05 16:30:21','2018-04-05 16:30:21','0','A'),(4,'dist','0','0','0.1','1','1','N',NULL,'2018-05-28 21:04:31','0','A'),(6,'dist','1','0','1','1','10000','N',NULL,'2018-05-28 21:53:58','0','A'),(7,'dist','0','0','0.01','1','0','N',NULL,'2018-05-30 15:46:21','0','A'),(9,'admin','1','0','60','1','10000','N',NULL,'2018-06-10 11:33:01',NULL,'A'),(10,'dist','0','0','0.2','1','2','N',NULL,'2018-06-11 22:26:09',NULL,'A'),(11,'dist','1','1','1','1','0','N',NULL,'2018-06-11 22:26:57',NULL,'A'),(12,'dist','1','0','20','2','10000','N',NULL,'2018-06-26 17:31:30',NULL,'A'),(13,'dist','0','0','0.1','4','0','N',NULL,'2018-07-19 22:05:44',NULL,'B');

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
) ENGINE=InnoDB AUTO_INCREMENT=279 DEFAULT CHARSET=utf8 COMMENT='分润记录表';

/*Data for the table `dis_profit_record` */

insert  into `dis_profit_record`(`id`,`profit_num`,`dis_platform_id`,`dis_get_user_id`,`dis_set_user_id`,`dis_amount`,`dis_pro_type`,`dis_note`,`dis_user_type`,`dis_order_id`,`is_delete`,`add_time`,`update_time`,`type`,`before_amount`,`after_amount`,`before_pro_amount`,`after_pro_amount`) values (241,'PRO61858062277','dist','mingchao','minguo','100.00','0',NULL,'1','qq','N','2018-06-26 18:58:06','2018-06-26 18:58:06','0',NULL,NULL,NULL,NULL),(242,'PRO61858069241',NULL,'dist','minguo','1.00','0',NULL,'10000','qq','N','2018-06-26 18:58:06','2018-06-26 18:58:06','1',NULL,NULL,NULL,NULL),(243,'PRO61858067399',NULL,'yiji','minguo','20.00','0',NULL,'10000','qq','N','2018-06-26 18:58:06','2018-06-26 18:58:06','1',NULL,NULL,NULL,NULL),(244,'PRO61858062867',NULL,'admin','minguo','60.00','0',NULL,'10000','qq','N','2018-06-26 18:58:06','2018-06-26 18:58:06','1',NULL,NULL,NULL,NULL),(245,'PRO61859085326','dist','mingchao','minguo','100.00','0',NULL,'1','qq','N','2018-06-26 18:59:08','2018-06-26 18:59:08','0',NULL,NULL,NULL,NULL),(246,'PRO61859086812',NULL,'dist','minguo','1.00','0',NULL,'10000','qq','N','2018-06-26 18:59:08','2018-06-26 18:59:08','1',NULL,NULL,NULL,NULL),(247,'PRO61859081714',NULL,'yiji','minguo','20.00','0',NULL,'10000','qq','N','2018-06-26 18:59:08','2018-06-26 18:59:08','1',NULL,NULL,NULL,NULL),(248,'PRO61859086698',NULL,'admin','minguo','60.00','0',NULL,'10000','qq','N','2018-06-26 18:59:08','2018-06-26 18:59:08','1',NULL,NULL,NULL,NULL),(249,'PRO61859419114','dist','mingchao','minguo','100.00','0',NULL,'1','qq','N','2018-06-26 18:59:41','2018-06-26 18:59:41','0',NULL,NULL,NULL,NULL),(250,'PRO61859457301',NULL,'dist','minguo','1.00','0',NULL,'10000','qq','N','2018-06-26 18:59:45','2018-06-26 18:59:45','1',NULL,NULL,NULL,NULL),(251,'PRO61859467729',NULL,'yiji','minguo','20.00','0',NULL,'10000','qq','N','2018-06-26 18:59:46','2018-06-26 18:59:46','1',NULL,NULL,NULL,NULL),(252,'PRO61900247207',NULL,'admin','minguo','60.00','0',NULL,'10000','qq','N','2018-06-26 19:00:24','2018-06-26 19:00:24','1',NULL,NULL,NULL,NULL),(253,'PRO10051169348','dist','yuanchao','qingchao','12.20','0',NULL,'1','sss','N','2018-07-01 00:51:16','2018-07-01 00:51:16','0',NULL,NULL,NULL,NULL),(254,'PRO10051161672','dist','mingchao','qingchao','12.20','0',NULL,'1','sss','N','2018-07-01 00:51:16','2018-07-01 00:51:16','0',NULL,NULL,NULL,NULL),(255,'PRO10051167419',NULL,'dist','qingchao','1.00','0',NULL,'10000','sss','N','2018-07-01 00:51:16','2018-07-01 00:51:16','1',NULL,NULL,NULL,NULL),(256,'PRO10051166683',NULL,'admin','qingchao','60.00','0',NULL,'10000','sss','N','2018-07-01 00:51:16','2018-07-01 00:51:16','1',NULL,NULL,NULL,NULL),(257,'PRO10132342252',NULL,'dist','fasongdao','1.00','1',NULL,'10000','','N','2018-07-01 01:32:34','2018-07-01 01:32:34','1',NULL,NULL,NULL,NULL),(258,'PRO10132348782',NULL,'admin','fasongdao','60.00','1',NULL,'10000','','N','2018-07-01 01:32:34','2018-07-01 01:32:34','1',NULL,NULL,NULL,NULL),(259,'PRO10134025658',NULL,'dist','fasongdao','1.00','1',NULL,'10000','','N','2018-07-01 01:34:02','2018-07-01 01:34:02','1',NULL,NULL,NULL,NULL),(260,'PRO10134022471',NULL,'admin','fasongdao','60.00','1',NULL,'10000','','N','2018-07-01 01:34:02','2018-07-01 01:34:02','1',NULL,NULL,NULL,NULL),(261,'PRO10135283689',NULL,'dist','fasongdao','1.00','1',NULL,'10000','','N','2018-07-01 01:35:28','2018-07-01 01:35:28','1',NULL,NULL,NULL,NULL),(262,'PRO10135283099',NULL,'admin','fasongdao','60.00','1',NULL,'10000','','N','2018-07-01 01:35:28','2018-07-01 01:35:28','1',NULL,NULL,NULL,NULL),(263,'PRO10138599798',NULL,'dist','fasongdao','1.00','1',NULL,'10000','','N','2018-07-01 01:38:59','2018-07-01 01:38:59','1',NULL,NULL,NULL,NULL),(264,'PRO10138595925',NULL,'admin','fasongdao','60.00','1',NULL,'10000','','N','2018-07-01 01:38:59','2018-07-01 01:38:59','1',NULL,NULL,NULL,NULL),(265,'PRO10140165715',NULL,'dist','fasongdao','1.00','1',NULL,'10000','','N','2018-07-01 01:40:16','2018-07-01 01:40:16','1',NULL,NULL,NULL,NULL),(266,'PRO10140164572',NULL,'admin','fasongdao','60.00','1',NULL,'10000','','N','2018-07-01 01:40:16','2018-07-01 01:40:16','1',NULL,NULL,NULL,NULL),(267,'PRO30024147064','dist','yuanchao','qingchao','100.00','0',NULL,'1','ggggggg','N','2018-07-23 00:24:14','2018-07-23 00:24:14','0',NULL,NULL,NULL,NULL),(268,'PRO30024143339','dist','mingchao','qingchao','100.00','0',NULL,'1','ggggggg','N','2018-07-23 00:24:14','2018-07-23 00:24:14','0',NULL,NULL,NULL,NULL),(269,'PRO30024140303',NULL,'dist','qingchao','1.00','0',NULL,'10000','ggggggg','N','2018-07-23 00:24:14','2018-07-23 00:24:14','1',NULL,NULL,NULL,NULL),(270,'PRO30024141116',NULL,'admin','qingchao','60.00','0',NULL,'10000','ggggggg','N','2018-07-23 00:24:14','2018-07-23 00:24:14','1',NULL,NULL,NULL,NULL),(271,'PRO30025359448','dist','yuanchao','qingchao','190.00','0',NULL,'1','ssss','N','2018-07-23 00:25:35','2018-07-23 00:25:35','0',NULL,NULL,NULL,NULL),(272,'PRO30025355692','dist','mingchao','qingchao','190.00','0',NULL,'1','ssss','N','2018-07-23 00:25:35','2018-07-23 00:25:35','0',NULL,NULL,NULL,NULL),(273,'PRO30025354627',NULL,'dist','qingchao','1.00','0',NULL,'10000','ssss','N','2018-07-23 00:25:35','2018-07-23 00:25:35','1',NULL,NULL,NULL,NULL),(274,'PRO30025352079',NULL,'admin','qingchao','60.00','0',NULL,'10000','ssss','N','2018-07-23 00:25:35','2018-07-23 00:25:35','1',NULL,NULL,NULL,NULL),(275,'PRO01221278231','dist','mingchao','shunzhi','10.00','0',NULL,'1','1sss','N','2018-07-30 12:21:27','2018-07-30 12:21:27','0',NULL,NULL,NULL,NULL),(276,'PRO01221270294','dist','qingchao','shunzhi','10.00','0',NULL,'1','1sss','N','2018-07-30 12:21:27','2018-07-30 12:21:27','0',NULL,NULL,NULL,NULL),(277,'PRO01221287652',NULL,'dist','shunzhi','1.00','0',NULL,'10000','1sss','N','2018-07-30 12:21:28','2018-07-30 12:21:28','1',NULL,NULL,NULL,NULL),(278,'PRO01221287798',NULL,'admin','shunzhi','60.00','0',NULL,'10000','1sss','N','2018-07-30 12:21:28','2018-07-30 12:21:28','1',NULL,NULL,NULL,NULL);

/*Table structure for table `dis_rank_integral_record` */

DROP TABLE IF EXISTS `dis_rank_integral_record`;

CREATE TABLE `dis_rank_integral_record` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `dis_user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `sys_integral` int(10) DEFAULT NULL COMMENT '系统积分',
  `is_use` varchar(2) DEFAULT 'N' COMMENT '是否使用（Y:使用,N未使用）',
  `is_expire` varchar(2) DEFAULT 'N' COMMENT '是否过期(Y:已过期，N未过期) 暂时不用',
  `before_integral` int(10) DEFAULT NULL COMMENT '使用前积分',
  `after_integral` int(10) DEFAULT NULL COMMENT '使用后积分',
  `expire_time` varchar(20) DEFAULT NULL COMMENT '到期时间（暂时不用）',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `dis_pro_type` varchar(10) DEFAULT NULL COMMENT '来源(交易、升级，下级升级)',
  `source_user_id` varchar(100) DEFAULT NULL COMMENT '来源用户id',
  `source_remak` varchar(200) DEFAULT NULL COMMENT '来源备注',
  `use_time` varchar(20) DEFAULT NULL COMMENT '使用时间',
  `use_remark` varchar(100) DEFAULT NULL COMMENT '使用备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='系统积分记录表';

/*Data for the table `dis_rank_integral_record` */

insert  into `dis_rank_integral_record`(`id`,`dis_user_id`,`sys_integral`,`is_use`,`is_expire`,`before_integral`,`after_integral`,`expire_time`,`add_time`,`dis_pro_type`,`source_user_id`,`source_remak`,`use_time`,`use_remark`) values (5,'qingchao',10,'N','N',110,120,'2021-04-18 23:31:43','2018-07-23 23:31:43','2','yaoqingjf1','您的邀请下级yaoqingjf1,您获得120积分',NULL,NULL),(6,'qingchao',10,'N','N',120,130,'2021-04-25 12:21:10','2018-07-30 12:21:10','2','shunzhi','您的邀请下级shunzhi,您获得130积分',NULL,NULL),(7,'qingchao',10,'N','N',130,140,'2021-04-25 12:21:28','2018-07-30 12:21:28','0','shunzhi','您的下级shunzhi交易100元,您获得140积分',NULL,NULL),(8,'shunzhi',10,'N','N',0,10,'2021-04-25 12:21:28','2018-07-30 12:21:28','0','shunzhi','您的下级shunzhi交易100元,您获得10积分',NULL,NULL);

/*Table structure for table `dis_rank_param` */

DROP TABLE IF EXISTS `dis_rank_param`;

CREATE TABLE `dis_rank_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dis_platform_id` varchar(100) DEFAULT NULL COMMENT '平台id',
  `dis_pro_mode` varchar(100) NOT NULL COMMENT '分润模型，如 百分比和固定金额',
  `dis_pro_type` varchar(100) DEFAULT NULL COMMENT '分润类别，如上级发展下级分润 ，交易分润。。。。',
  `dis_integral_value` varchar(20) DEFAULT NULL COMMENT '积分值',
  `dis_pro_level` varchar(100) DEFAULT NULL COMMENT '从下往上对应的级别关系',
  `dis_user_type` varchar(10) DEFAULT NULL COMMENT '会员类型（1000：平台标示，其他为用户类型）',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '是否删除',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `dis_user_rank` varchar(10) DEFAULT 'A' COMMENT '用户段位（青铜等）',
  `dis_rank_name` varchar(50) DEFAULT NULL COMMENT '段位积分名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_rank_param` */

insert  into `dis_rank_param`(`id`,`dis_platform_id`,`dis_pro_mode`,`dis_pro_type`,`dis_integral_value`,`dis_pro_level`,`dis_user_type`,`is_delete`,`update_time`,`add_time`,`dis_user_rank`,`dis_rank_name`) values (3,'dist','0','0','2','1','0','N',NULL,'2018-07-20 15:40:40','A','aaa'),(4,'dist','0','0','0.1','1','1','N',NULL,'2018-07-23 00:21:57','A','一级经理'),(5,'dist','0','0','0.1','0','0','N',NULL,'2018-07-23 00:23:47','A','自身_经理'),(6,'dist','1','2','10','1','1','N',NULL,'2018-07-23 23:27:10','A','邀请会员一级经理青铜');

/*Table structure for table `dis_trade_record` */

DROP TABLE IF EXISTS `dis_trade_record`;

CREATE TABLE `dis_trade_record` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dis_user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `trade_num` varchar(20) DEFAULT NULL COMMENT '第三方订单号',
  `trade_amount` decimal(12,2) DEFAULT '0.00' COMMENT '交易金额',
  `trade_time` varchar(20) DEFAULT NULL COMMENT '交易时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='交易金额记录表';

/*Data for the table `dis_trade_record` */

insert  into `dis_trade_record`(`id`,`dis_user_id`,`trade_num`,`trade_amount`,`trade_time`) values (1,'shunzhi','1sss','100.00','2018-07-30 12:21:28');

/*Table structure for table `dis_upgrade_param` */

DROP TABLE IF EXISTS `dis_upgrade_param`;

CREATE TABLE `dis_upgrade_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `upgrade_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `begin_integral` int(10) DEFAULT NULL COMMENT '开始金额',
  `end_integral` int(10) DEFAULT NULL COMMENT '结束金额',
  `dis_user_rank` varchar(10) DEFAULT NULL COMMENT '用户水平等级',
  `is_delete` varchar(2) DEFAULT 'N' COMMENT '是否删除',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `update_time` varchar(20) DEFAULT NULL COMMENT '修改时间',
  `identity_type` varchar(2) DEFAULT '0' COMMENT '0会员  1代理商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='垂直升级配置表';

/*Data for the table `dis_upgrade_param` */

insert  into `dis_upgrade_param`(`id`,`upgrade_name`,`begin_integral`,`end_integral`,`dis_user_rank`,`is_delete`,`add_time`,`update_time`,`identity_type`) values (2,'11',12,12,'A','N','2018-07-23 17:08:13',NULL,NULL);

/*Table structure for table `dis_upgrade_record` */

DROP TABLE IF EXISTS `dis_upgrade_record`;

CREATE TABLE `dis_upgrade_record` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dis_user_id` varchar(100) DEFAULT NULL COMMENT '用户id',
  `before_upgrade_level` varchar(10) DEFAULT NULL COMMENT '升级前等级',
  `after_upgrade_level` varchar(10) DEFAULT NULL COMMENT '升级后等级',
  `level_differ` varchar(2) DEFAULT NULL COMMENT '等级差额',
  `upgrade_time` varchar(20) DEFAULT NULL COMMENT '升级时间',
  `level_type` varchar(2) DEFAULT '0' COMMENT '升级类型(0:垂直升级 1：水平升级)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户升级记录表';

/*Data for the table `dis_upgrade_record` */

insert  into `dis_upgrade_record`(`id`,`dis_user_id`,`before_upgrade_level`,`after_upgrade_level`,`level_differ`,`upgrade_time`,`level_type`) values (1,NULL,NULL,NULL,NULL,NULL,'0');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='提现表';

/*Data for the table `dis_withdraw_record` */

insert  into `dis_withdraw_record`(`id`,`dis_user_id`,`withdraw_num`,`total_amount`,`fee_amount`,`real_amount`,`withdraw_time`,`handle_time`,`withdraw_status`,`dis_pro_mode`) values (2,'mingchao',NULL,'50.00','0.00','50.00','2018-05-31 21:48:19','2018-06-09 02:17:57','2','0'),(3,'mingchao',NULL,'50.00','2.00','48.00','2018-05-31 21:50:34','2018-06-09 02:18:21','3','0'),(4,'yuanchao','TX92016224444','100.00','2.00','98.00','2018-06-09 20:16:22','2018-06-09 20:16:42','2','0'),(5,'mingchao','TX10101382241','1.00','2.00','-1.00','2018-07-01 01:01:38','2018-07-01 01:02:03','3','0'),(6,'qingchao','TX01221486862','1.00','2.00','-1.00','2018-07-30 12:21:48',NULL,'1','0');

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
) ENGINE=InnoDB AUTO_INCREMENT=10031 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典类型表';

/*Data for the table `sys_dic` */

insert  into `sys_dic`(`dic_id`,`dic_no`,`dic_notes`,`dic_order`,`dic_type_no`,`dic_value`,`is_delete`,`add_time`,`update_time`,`ext_field`,`ext_field2`) values (43,'0','trade',NULL,'disProType','交易分润','N',NULL,NULL,NULL,NULL),(44,'1','level',NULL,'disProType','上下级分润','N',NULL,NULL,NULL,NULL),(49,'0','即总金额*百分之比',NULL,'disProMode','百分比','N',NULL,NULL,NULL,NULL),(50,'1','固定金额',NULL,'disProMode','固定金额','N',NULL,NULL,NULL,NULL),(101,'1',NULL,NULL,'quanxianid','5','N',NULL,NULL,NULL,NULL),(102,'2',NULL,NULL,'quanxianid','7','N',NULL,NULL,NULL,NULL),(103,'3',NULL,NULL,'quanxianid','8','N',NULL,NULL,NULL,NULL),(104,'4',NULL,NULL,'quanxianid','9','N',NULL,NULL,NULL,NULL),(105,'5',NULL,NULL,'quanxianid','10','N',NULL,NULL,NULL,NULL),(10003,'1',NULL,NULL,'withdrawStatus','申请中','N',NULL,NULL,NULL,NULL),(10004,'2',NULL,NULL,'withdrawStatus','审核成功','N',NULL,NULL,NULL,NULL),(10005,'3',NULL,NULL,'withdrawStatus','审核拒绝','N',NULL,NULL,NULL,NULL),(10006,'profit','分润',NULL,'orderPrefix','PRO','N',NULL,NULL,NULL,NULL),(10007,'withdrawl','提现',NULL,'orderPrefix','TX','N',NULL,NULL,NULL,NULL),(10008,'0',NULL,NULL,'disUserType','游客','N',NULL,NULL,NULL,NULL),(10009,'1',NULL,NULL,'disUserType','经理','N',NULL,NULL,NULL,NULL),(10010,'2',NULL,NULL,'disUserType','老板','N',NULL,NULL,NULL,NULL),(10011,'10000','此值不能改变，作为平台标识',NULL,'disUserType','平台标识','N',NULL,NULL,NULL,NULL),(10012,'3',NULL,NULL,'maxLevel','会员最大级别','N',NULL,NULL,NULL,NULL),(10013,'A',NULL,NULL,'disUserRank','青铜','N',NULL,NULL,NULL,NULL),(10014,'B',NULL,NULL,'disUserRank','黄金','N',NULL,NULL,NULL,NULL),(10015,'C',NULL,NULL,'disUserRank','铂金','N',NULL,NULL,NULL,NULL),(10016,'D',NULL,NULL,'disUserRank','钻石','N',NULL,NULL,NULL,NULL),(10019,'0','积分使用',NULL,'disProLevel','自身','N',NULL,NULL,NULL,NULL),(10020,'1',NULL,NULL,'disProLevel','一级','N',NULL,NULL,NULL,NULL),(10021,'2',NULL,NULL,'disProLevel','二级','N',NULL,NULL,NULL,NULL),(10022,'3',NULL,NULL,'disProLevel','三级','N',NULL,NULL,NULL,NULL),(10023,'4',NULL,NULL,'disProLevel','四级','N',NULL,NULL,NULL,NULL),(10024,'0','trade',NULL,'disProRankType','商品交易','N',NULL,NULL,NULL,NULL),(10025,'1','level',NULL,'disProRankType','升级','N',NULL,NULL,NULL,NULL),(10026,'2','invation',NULL,'disProRankType','邀请会员','N',NULL,NULL,NULL,NULL),(10029,'1000','单位为天，备用数据',NULL,'effectiveTime','积分有效时间','N',NULL,NULL,NULL,NULL),(10030,'Y',NULL,NULL,'isTotalIntegral','是否按照总积分计算','N',NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

/*Data for the table `sys_dic_type` */

insert  into `sys_dic_type`(`dic_type_id`,`dic_type_name`,`dic_type_no`,`dic_type_notes`,`dic_type_order`,`system_no`,`is_delete`,`add_time`,`update_time`) values (27,'分润类别','disProType',NULL,NULL,'pc','N',NULL,NULL),(29,'分润模型','disProMode',NULL,NULL,'pc','N',NULL,NULL),(42,'权限id','quanxianid',NULL,NULL,'pc','N',NULL,NULL),(44,'提现状态','withdrawStatus',NULL,NULL,'pc','N',NULL,NULL),(45,'订单前缀','orderPrefix',NULL,NULL,'pc','N',NULL,NULL),(46,'用户类型','disUserType',NULL,NULL,'pc','N',NULL,NULL),(47,'会员最大级别','maxLevel',NULL,NULL,'pc','N',NULL,NULL),(48,'段位','disUserRank',NULL,NULL,'pc','N',NULL,NULL),(51,'用户等级','disProLevel',NULL,NULL,'pc','N',NULL,NULL),(52,'交易类型','disProRankType',NULL,NULL,'pc','N',NULL,NULL),(55,'积分有效时间','effectiveTime',NULL,NULL,'pc','N',NULL,NULL),(56,'是否按照总积分计算','isTotalIntegral',NULL,NULL,'pc','N',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
