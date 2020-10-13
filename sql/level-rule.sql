/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.20-log : Database - level-rule
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`level-rule` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `level-rule`;

/*Table structure for table `dis_profit_param` */

DROP TABLE IF EXISTS `dis_profit_param`;

CREATE TABLE `dis_profit_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_platform_id` varchar(100) DEFAULT NULL COMMENT '平台id',
  `cal_model` varchar(100) NOT NULL COMMENT '计算模型，如 百分比和固定金额',
  `account_type` varchar(100) DEFAULT NULL COMMENT '账户类型，如上级发展下级分润 ，交易分润。。。。',
  `dis_pro_value` varchar(20) DEFAULT NULL COMMENT '分润值',
  `dis_pro_level` varchar(100) DEFAULT NULL COMMENT '从下往上对应的级别关系',
  `dis_user_type` varchar(10) DEFAULT NULL COMMENT '会员类型（1000：平台标示，其他为用户类型）',
  `is_delete` varchar(1) DEFAULT 'N' COMMENT '是否删除',
  `update_time` varchar(20) DEFAULT NULL COMMENT '更新时间',
  `add_time` varchar(20) DEFAULT NULL COMMENT '添加时间',
  `dist_trade_mode` varchar(20) DEFAULT NULL COMMENT '交易方式(分润或者提现)',
  `dis_user_rank` varchar(10) DEFAULT 'A' COMMENT '用户段位（青铜等）',
  `identity_type` varchar(10) DEFAULT '0' COMMENT '身份类型(0,会员，1：代理商)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='分润参数设置';

/*Data for the table `dis_profit_param` */

insert  into `dis_profit_param`(`id`,`dis_platform_id`,`cal_model`,`account_type`,`dis_pro_value`,`dis_pro_level`,`dis_user_type`,`is_delete`,`update_time`,`add_time`,`dist_trade_mode`,`dis_user_rank`,`identity_type`) values (1,'dist_yiji','1','0','3','1','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(2,'dist_yiji','1','0','2','2','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(3,'dist_yiji','1','0','1','3','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(4,'dist_yiji','1','0','2','2','1','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(5,'dist_yiji','1','0','2','2','1','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','B','0'),(6,'dist_yiji','1','1','3','1','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(7,'dist_yiji','1','1','2','2','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(8,'dist_yiji','1','1','1','3','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(9,'dist_yiji','1','2','3','1','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(10,'dist_yiji','1','2','2','2','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(11,'dist_yiji','1','2','1','3','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(12,'dist_yiji','1','0','3','1','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(13,'dist_yiji','1','0','2','2','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(14,'dist_yiji','1','0','1','3','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(15,'dist_yiji','1','0','2','2','1','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(16,'dist_yiji','1','0','2','2','1','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','B','0'),(17,'dist_yiji','1','1','3','1','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(18,'dist_yiji','1','1','2','2','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(19,'dist_yiji','1','1','1','3','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(20,'dist_yiji','1','2','3','1','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(21,'dist_yiji','1','2','2','2','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0'),(22,'dist_yiji','1','2','1','3','0','N','2020-07-24 11:45:07','2020-07-24 11:45:07','0','A','0');

/*Table structure for table `xml_content` */

DROP TABLE IF EXISTS `xml_content`;

CREATE TABLE `xml_content` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT 'xml',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `xml_content` */

insert  into `xml_content`(`id`,`name`,`type`,`content`) values (1,'账户参数管理','profit_param','<mxGraphModel dx=\"2692\" dy=\"1788\" grid=\"1\" gridSize=\"10\" guides=\"1\" tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\" pageScale=\"1\" pageWidth=\"827\" pageHeight=\"1169\">\n  <root>\n    <mxCell id=\"0\" />\n    <mxCell id=\"1\" parent=\"0\" />\n    <mxCell id=\"2\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.5;entryY=0;entryDx=0;entryDy=0;strokeColor=#66B2FF;exitX=0;exitY=0.5;exitDx=0;exitDy=0;shadow=0;\" edge=\"1\" source=\"27\" target=\"6\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\">\n        <mxPoint x=\"230\" y=\"170\" as=\"sourcePoint\" />\n      </mxGeometry>\n    </mxCell>\n    <mxCell id=\"3\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;shadow=0;\" edge=\"1\" source=\"6\" target=\"12\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"4\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;shadow=0;\" edge=\"1\" source=\"6\" target=\"18\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"5\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;shadow=0;\" edge=\"1\" source=\"6\" target=\"20\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"dist测试分销平台\" plantFormId=\"dist_yiji\" id=\"6\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-200\" y=\"230\" width=\"120\" height=\"60\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"7\" value=\"\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;exitX=0.5;exitY=1;exitDx=0;exitDy=0;entryX=0.5;entryY=0;entryDx=0;entryDy=0;shadow=0;\" edge=\"1\" source=\"24\" target=\"27\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\">\n        <mxPoint x=\"310\" y=\"-80\" as=\"sourcePoint\" />\n        <mxPoint x=\"290\" y=\"140\" as=\"targetPoint\" />\n      </mxGeometry>\n    </mxCell>\n    <mxCell id=\"8\" value=\"开始菜单是必须的，只能 有一个开始菜单\" style=\"text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"640\" y=\"10\" width=\"230\" height=\"20\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"9\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;shadow=0;\" edge=\"1\" source=\"12\" target=\"22\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"10\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;shadow=0;\" edge=\"1\" source=\"12\" target=\"23\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"11\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.432;entryY=0.019;entryDx=0;entryDy=0;entryPerimeter=0;strokeColor=#66B2FF;\" edge=\"1\" source=\"12\" target=\"38\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"&lt;font face=&quot;open sans, helvetica neue, helvetica, arial, sans-serif&quot;&gt;&lt;span style=&quot;font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;交易分润账户(青铜_游客)&lt;/span&gt;&lt;/font&gt;\" accountType=\"0\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"3\" id=\"12\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-560\" y=\"400\" width=\"170\" height=\"50\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"13\" value=\"&lt;b&gt;&lt;font style=&quot;font-size: 18px&quot;&gt;计算模型:&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;0:百分比,1:固定金额--&amp;gt;&lt;/span&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;calModel&lt;/span&gt;&lt;/font&gt;&lt;/b&gt;\" style=\"text;html=1;strokeColor=#66B2FF;fillColor=none;align=center;verticalAlign=middle;whiteSpace=wrap;rounded=0;shadow=0;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"827\" y=\"200\" width=\"493\" height=\"80\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"14\" value=\"&lt;font style=&quot;font-size: 18px&quot;&gt;&lt;b&gt;交易账户类型:&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;0:交易分润账户,1:升级分润账户,2:邀请分润账户&amp;nbsp; --&amp;gt;&lt;/span&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;accountType&lt;/span&gt;&lt;/b&gt;&lt;/font&gt;\" style=\"text;html=1;strokeColor=#66B2FF;fillColor=none;align=center;verticalAlign=middle;whiteSpace=wrap;rounded=0;shadow=0;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"880\" y=\"300\" width=\"660\" height=\"30\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"15\" value=\"&lt;b&gt;&lt;font style=&quot;font-size: 18px&quot;&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;disUserRank:&lt;/span&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;段位，&lt;/span&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;A:青铜,B:黄金,C:铂金,D:钻石&lt;/span&gt;&lt;/font&gt;&lt;/b&gt;\" style=\"text;html=1;strokeColor=#66B2FF;fillColor=none;align=center;verticalAlign=middle;whiteSpace=wrap;rounded=0;shadow=0;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"880\" y=\"160\" width=\"450\" height=\"30\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"16\" value=\"&lt;b&gt;&lt;font style=&quot;font-size: 18px&quot;&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;disUserType：用户类型&amp;nbsp; &amp;nbsp;&lt;/span&gt;&lt;span style=&quot;color: rgb(103 , 106 , 108) ; font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; background-color: rgb(245 , 245 , 245)&quot;&gt;0:游客,1:经理,2:老板&lt;/span&gt;&lt;/font&gt;&lt;/b&gt;\" style=\"text;html=1;strokeColor=#66B2FF;fillColor=none;align=center;verticalAlign=middle;whiteSpace=wrap;rounded=0;shadow=0;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"770\" y=\"120\" width=\"650\" height=\"10\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"17\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;\" edge=\"1\" source=\"18\" target=\"33\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"&lt;font face=&quot;open sans, helvetica neue, helvetica, arial, sans-serif&quot;&gt;&lt;span style=&quot;font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;升级分润账户（青铜_游客）&lt;/span&gt;&lt;/font&gt;\" accountType=\"1\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"3\" id=\"18\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-210\" y=\"400\" width=\"180\" height=\"70\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"19\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.5;entryY=0;entryDx=0;entryDy=0;strokeColor=#66B2FF;\" edge=\"1\" source=\"20\" target=\"36\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"&lt;font face=&quot;open sans, helvetica neue, helvetica, arial, sans-serif&quot;&gt;&lt;span style=&quot;font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;邀请分润账户&lt;/span&gt;&lt;/font&gt;&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;（青铜_游客）&lt;/span&gt;\" accountType=\"2\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"3\" id=\"20\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"60\" y=\"410\" width=\"170\" height=\"60\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"21\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;\" edge=\"1\" source=\"22\" target=\"30\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;交易分润账户(青铜_游客)&lt;/span&gt;\" accountType=\"0\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"2\" id=\"22\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-650\" y=\"545\" width=\"150\" height=\"55\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <object label=\"&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;交易分润账户(青铜_经理)&lt;/span&gt;\" accountType=\"0\" calModel=\"1\" disUserRank=\"A\" disUserType=\"1\" paramValue=\"2\" id=\"23\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-450\" y=\"545\" width=\"170\" height=\"55\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"24\" value=\"start\" style=\"start;ellipse;whiteSpace=wrap;html=1;aspect=fixed;shadow=0;strokeColor=#66B2FF;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"270\" y=\"-170\" width=\"80\" height=\"80\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"25\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;entryX=0.5;entryY=0;entryDx=0;entryDy=0;strokeColor=#66B2FF;\" edge=\"1\" source=\"27\" target=\"29\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"26\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;\" edge=\"1\" source=\"27\" target=\"31\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"27\" value=\"admin总平台\" style=\"rounded=0;whiteSpace=wrap;html=1;shadow=0;strokeColor=#66B2FF;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"250\" y=\"145\" width=\"120\" height=\"60\" as=\"geometry\" />\n    </mxCell>\n    <mxCell id=\"28\" value=\"&lt;h1&gt;&lt;font style=&quot;font-size: 36px&quot;&gt;本页面目前为会员分销配置可视化界面&lt;/font&gt;&lt;/h1&gt;\" style=\"text;html=1;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;whiteSpace=wrap;rounded=0;shadow=0;\" vertex=\"1\" parent=\"1\">\n      <mxGeometry x=\"-170\" y=\"-330\" width=\"890\" height=\"10\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"江苏省分销平台\" plantFormId=\"jiangsu\" id=\"29\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"250\" y=\"280\" width=\"120\" height=\"60\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <object label=\"&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;交易分润账户(青铜_游客)&lt;/span&gt;\" accountType=\"0\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"1\" id=\"30\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-665\" y=\"690\" width=\"180\" height=\"50\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <object label=\"安徽省分销平台\" plantFormId=\"anhui\" id=\"31\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"410\" y=\"285\" width=\"120\" height=\"60\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"32\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;\" edge=\"1\" source=\"33\" target=\"34\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;升级分润账户（青铜_游客）&lt;/span&gt;\" accountType=\"1\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"2\" id=\"33\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-220\" y=\"545\" width=\"200\" height=\"55\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <object label=\"&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;升级分润账户（青铜_游客）&lt;/span&gt;\" accountType=\"1\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"1\" id=\"34\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-227.5\" y=\"700\" width=\"215\" height=\"60\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <mxCell id=\"35\" style=\"edgeStyle=orthogonalEdgeStyle;rounded=0;orthogonalLoop=1;jettySize=auto;html=1;strokeColor=#66B2FF;\" edge=\"1\" source=\"36\" target=\"37\" parent=\"1\">\n      <mxGeometry relative=\"1\" as=\"geometry\" />\n    </mxCell>\n    <object label=\"&lt;font face=&quot;open sans, helvetica neue, helvetica, arial, sans-serif&quot;&gt;&lt;span style=&quot;font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;邀请分润账户&lt;/span&gt;&lt;/font&gt;&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;（青铜_游客）&lt;/span&gt;\" accountType=\"2\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"2\" id=\"36\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"60\" y=\"545\" width=\"170\" height=\"55\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <object label=\"&lt;font face=&quot;open sans, helvetica neue, helvetica, arial, sans-serif&quot;&gt;&lt;span style=&quot;font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;邀请分润账户&lt;/span&gt;&lt;/font&gt;&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;（青铜_游客）&lt;/span&gt;\" accountType=\"2\" calModel=\"1\" disUserRank=\"A\" disUserType=\"0\" paramValue=\"1\" id=\"37\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"50\" y=\"700\" width=\"190\" height=\"60\" as=\"geometry\" />\n      </mxCell>\n    </object>\n    <object label=\"&lt;span style=&quot;font-family: &amp;#34;open sans&amp;#34; , &amp;#34;helvetica neue&amp;#34; , &amp;#34;helvetica&amp;#34; , &amp;#34;arial&amp;#34; , sans-serif ; font-size: 13px ; background-color: rgb(255 , 255 , 255)&quot;&gt;交易分润账户(黄金_经理)&lt;/span&gt;\" accountType=\"0\" calModel=\"1\" disUserRank=\"B\" disUserType=\"1\" paramValue=\"2\" id=\"38\">\n      <mxCell style=\"rounded=0;whiteSpace=wrap;html=1;strokeColor=#66B2FF;shadow=0;\" vertex=\"1\" parent=\"1\">\n        <mxGeometry x=\"-860\" y=\"545\" width=\"170\" height=\"55\" as=\"geometry\" />\n      </mxCell>\n    </object>\n  </root>\n</mxGraphModel>');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;