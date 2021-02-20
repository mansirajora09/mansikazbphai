# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.30)
# Database: zbp
# Generation Time: 2020-12-30 07:56:18 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table advertiser
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advertiser`;

CREATE TABLE `advertiser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table advertiser_agency_link
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advertiser_agency_link`;

CREATE TABLE `advertiser_agency_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `advertiser_id` bigint(20) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_advertiser_agency_link_adv_idx` (`advertiser_id`),
  KEY `fk_advertiser_agency_link_agen_idx` (`agency_id`),
  CONSTRAINT `fk_advertiser_agency_link_adv` FOREIGN KEY (`advertiser_id`) REFERENCES `advertiser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_advertiser_agency_link_agen` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table agency
# ------------------------------------------------------------

DROP TABLE IF EXISTS `agency`;

CREATE TABLE `agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table available_ads
# ------------------------------------------------------------

DROP TABLE IF EXISTS `available_ads`;

CREATE TABLE `available_ads` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `banner_type` enum('HORIZONTAL','SQUARE','VERTICAL') NOT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `device` enum('MOBILE','DESKTOP') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `available_ads` WRITE;
/*!40000 ALTER TABLE `available_ads` DISABLE KEYS */;

INSERT INTO `available_ads` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `banner_type`, `width`, `height`, `device`)
VALUES
	(1,'2020-11-18 13:56:37',NULL,NULL,NULL,1,'HORIZONTAL',480,360,'MOBILE'),
	(2,'2020-11-18 13:56:50',NULL,NULL,NULL,1,'SQUARE',480,480,'MOBILE'),
	(3,'2020-11-18 14:18:40',NULL,NULL,NULL,1,'VERTICAL',360,600,'MOBILE'),
	(4,'2020-11-18 14:43:31',NULL,NULL,NULL,1,'HORIZONTAL',480,360,'DESKTOP'),
	(5,'2020-11-18 13:57:01',NULL,NULL,NULL,1,'SQUARE',480,480,'DESKTOP'),
	(6,'2020-11-18 13:57:03',NULL,NULL,NULL,1,'VERTICAL',360,800,'DESKTOP'),
	(7,'2020-11-18 14:14:36',NULL,NULL,NULL,1,'HORIZONTAL',600,360,'DESKTOP'),
	(8,'2020-11-18 13:57:08',NULL,NULL,NULL,1,'SQUARE',480,480,'DESKTOP'),
	(9,'2020-11-18 13:57:10',NULL,NULL,NULL,1,'VERTICAL',360,800,'DESKTOP'),
	(10,'2020-11-18 13:57:12',NULL,NULL,NULL,1,'SQUARE',480,480,'DESKTOP');

/*!40000 ALTER TABLE `available_ads` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table black_out_hours
# ------------------------------------------------------------

DROP TABLE IF EXISTS `black_out_hours`;

CREATE TABLE `black_out_hours` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `start_hour` time DEFAULT NULL,
  `end_hour` time DEFAULT NULL,
  `campaing_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_blk_out_hour_campaign_id_idx` (`campaing_id`),
  CONSTRAINT `fk_blk_out_hour_campaign_id` FOREIGN KEY (`campaing_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `black_out_hours` WRITE;
/*!40000 ALTER TABLE `black_out_hours` DISABLE KEYS */;

INSERT INTO `black_out_hours` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `start_hour`, `end_hour`, `campaing_id`)
VALUES
	(1,'2020-10-29 17:29:33',NULL,NULL,NULL,1,'20:00:00','21:00:00',1),
	(3,'2020-10-29 17:29:33',NULL,NULL,NULL,1,'16:00:00','18:00:00',1);

/*!40000 ALTER TABLE `black_out_hours` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table campaign
# ------------------------------------------------------------

DROP TABLE IF EXISTS `campaign`;

CREATE TABLE `campaign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(245) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `daily_start_time` time DEFAULT NULL,
  `daily_end_time` time DEFAULT NULL,
  `status` enum('SCHEDULED','RUNNING','STOPPED') NOT NULL DEFAULT 'SCHEDULED',
  `type` enum('IVR','WAP') DEFAULT NULL,
  `media_type` enum('BANNER','VIDEO','AUDIO') DEFAULT NULL,
  `flow_type` enum('SCP','JSON') DEFAULT NULL,
  `time_zone` varchar(100) DEFAULT NULL,
  `is_capping` tinyint(1) DEFAULT '0',
  `is_targeting` tinyint(1) DEFAULT '0',
  `flow` text,
  `operator_id` bigint(20) DEFAULT NULL,
  `mxgraph_id` int(20) DEFAULT NULL,
  `time_zone_name` varchar(100) DEFAULT NULL,
  `scp_flow_name` varchar(100) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `max_click` int(11) DEFAULT NULL,
  `current_click` int(11) DEFAULT NULL,
  `max_impression` int(11) DEFAULT NULL,
  `current_impression` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `campaign` WRITE;
/*!40000 ALTER TABLE `campaign` DISABLE KEYS */;

INSERT INTO `campaign` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `name`, `start_date`, `end_date`, `daily_start_time`, `daily_end_time`, `status`, `type`, `media_type`, `flow_type`, `time_zone`, `is_capping`, `is_targeting`, `flow`, `operator_id`, `mxgraph_id`, `time_zone_name`, `scp_flow_name`, `priority`, `max_click`, `current_click`, `max_impression`, `current_impression`)
VALUES
	(1,'2020-12-14 15:01:26','120',NULL,'2020-12-30 13:24:35',1,'Hello','2020-12-10 00:00:00','2020-12-14 14:59:53','12:42:29','13:42:55','STOPPED','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST',NULL,1,0,1,NULL,0),
	(2,'2020-12-14 15:01:28','120',NULL,NULL,1,'Hi','2020-12-14 00:00:00','2020-12-16 14:54:49','14:55:06','15:55:09','RUNNING','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST','',5,0,0,NULL,NULL),
	(3,'2020-12-28 16:36:28','120',NULL,NULL,1,'IVR','2020-10-29 11:15:35','2020-11-30 11:15:40','11:15:50','20:15:57','RUNNING','IVR','AUDIO','JSON','UTC+5:30',0,0,'{\n\"actions\": [\n    {\n      \"actionId\": \"PRELOANMENU\",\n      \"actionType\": \"PLAY\",\n      \"name\": \"preloanmenu\",\n      \"path\": {\n        \"english\": \"/var/www/html/iobd/test_audio/pressonefor.wav\"\n      },\n      \"bargein\": false,\n      \"waitTime\": 0,\n      \"input\": {\n        \n      }\n    },\n    {\n      \"actionId\": \"LOANOPTION\",\n      \"actionType\": \"PLAY\",\n      \"name\": \"loanoption\",\n      \"path\": {\n        \"english\": \"/var/www/html/iobd/test_audio/loan.wav\"\n      },\n      \"bargein\": true,\n      \"waitTime\": 5,\n      \"input\": {\n        \n      }\n    },\n    {\n      \"actionId\": \"PREADSMENU\",\n      \"actionType\": \"PLAY\",\n      \"name\": \"pressadsmenu\",\n      \"path\": {\n        \"english\": \"/var/www/html/iobd/test_audio/presstwofor.wav\"\n      },\n      \"bargein\": false,\n      \"waitTime\": 0,\n      \"input\": {\n        \n      }\n    },\n    {\n      \"actionId\": \"ADSMENU\",\n      \"actionType\": \"PLAY\",\n      \"name\": \"adsoption\",\n      \"path\": {\n        \"english\": \"/var/www/html/iobd/test_audio/ads.wav\"\n      },\n      \"bargein\": true,\n      \"waitTime\": 5,\n      \"input\": {\n        \n      }\n    }\n  ]\n}',1,NULL,'IST',NULL,1,NULL,NULL,NULL,NULL),
	(4,'2020-12-02 17:27:07','120',NULL,NULL,1,'ivr2','2020-11-17 11:57:57','2020-11-17 11:57:57','11:15:50','20:15:57','RUNNING','IVR','AUDIO','SCP','UTC+5:30',0,0,NULL,1,NULL,'IST','MagicVoice',5,NULL,NULL,NULL,NULL),
	(5,'2020-12-10 13:29:31','120',NULL,NULL,1,'square','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST',NULL,10,NULL,NULL,NULL,NULL),
	(6,'2020-11-19 14:49:42','120',NULL,NULL,1,'priority1','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST',NULL,1,NULL,NULL,NULL,NULL),
	(7,'2020-11-19 14:49:43','120',NULL,NULL,1,'priority5','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST',NULL,5,NULL,NULL,NULL,NULL),
	(8,'2020-11-19 14:49:44','120',NULL,NULL,1,'priority10','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST',NULL,10,NULL,NULL,NULL,NULL),
	(9,'2020-11-19 14:49:45','120',NULL,NULL,1,'priority10','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','WAP','BANNER','JSON','UTC+5:30',0,0,NULL,1,NULL,'IST',NULL,10,NULL,NULL,NULL,NULL),
	(10,'2020-11-27 17:12:43','120',NULL,NULL,1,'IVR5','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','IVR','AUDIO','SCP','UTC+5:30',0,0,NULL,1,NULL,'IST','MagicVoice',5,NULL,NULL,NULL,NULL),
	(11,'2020-11-27 17:12:43','120',NULL,NULL,1,'IVR6','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','IVR','AUDIO','SCP','UTC+5:30',0,0,NULL,1,NULL,'IST','MagicVoice',7,NULL,NULL,NULL,NULL),
	(12,'2020-12-29 19:32:04',NULL,NULL,NULL,1,'IVR7','2020-11-17 14:51:03','2020-11-17 14:51:06','11:15:50','20:15:57','RUNNING','IVR','AUDIO','SCP','UTC+5:30',0,0,NULL,1,NULL,'IST','Islamic',10,NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `campaign` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table campaign_content
# ------------------------------------------------------------

DROP TABLE IF EXISTS `campaign_content`;

CREATE TABLE `campaign_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `redirect_url` varchar(500) DEFAULT '',
  `content_type` enum('VIDEO','BANNER','AUDIO') DEFAULT NULL,
  `capping_id` bigint(20) DEFAULT NULL,
  `current_click_count` int(11) DEFAULT NULL,
  `current_impression_count` int(11) DEFAULT NULL,
  `current_mou` int(11) DEFAULT NULL,
  `content_path` text,
  `percentage` double DEFAULT NULL,
  `campaign_id` bigint(20) NOT NULL,
  `banner_type` enum('HORIZONTAL','SQUARE','VERTICAL') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_campaing` (`campaign_id`),
  CONSTRAINT `fk_campaing` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `campaign_content` WRITE;
/*!40000 ALTER TABLE `campaign_content` DISABLE KEYS */;

INSERT INTO `campaign_content` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `height`, `width`, `redirect_url`, `content_type`, `capping_id`, `current_click_count`, `current_impression_count`, `current_mou`, `content_path`, `percentage`, `campaign_id`, `banner_type`)
VALUES
	(1,'2020-11-17 13:33:50','120',NULL,NULL,1,360,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,'/var/www/html/datacom/data/mv_tz_336x280.jpeg',NULL,1,'HORIZONTAL'),
	(2,'2020-11-17 14:50:15','120',NULL,NULL,1,800,360,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,1,'VERTICAL'),
	(3,'2020-11-17 14:48:54','150',NULL,NULL,1,360,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,2,'HORIZONTAL'),
	(4,'2020-11-18 14:27:54','150',NULL,NULL,1,360,600,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,2,'HORIZONTAL'),
	(9,'2020-11-18 14:14:18','120',NULL,NULL,1,360,600,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,5,'HORIZONTAL'),
	(10,'2020-11-18 13:33:54','120',NULL,NULL,1,800,360,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,5,'VERTICAL'),
	(11,'2020-11-17 14:58:35','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','VIDEO',NULL,NULL,NULL,NULL,NULL,NULL,5,'SQUARE'),
	(14,'2020-11-17 14:58:33','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,2,'SQUARE'),
	(15,'2020-11-17 14:58:30','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,1,'SQUARE'),
	(16,'2020-11-19 14:43:48','120',NULL,NULL,1,360,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,6,'HORIZONTAL'),
	(17,'2020-11-19 14:43:50','120',NULL,NULL,1,800,360,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,6,'VERTICAL'),
	(18,'2020-11-19 14:43:51','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,6,'SQUARE'),
	(19,'2020-11-19 14:43:52','120',NULL,NULL,1,360,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,7,'HORIZONTAL'),
	(20,'2020-11-19 14:43:53','120',NULL,NULL,1,800,360,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,7,'VERTICAL'),
	(21,'2020-11-19 14:43:54','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,7,'SQUARE'),
	(22,'2020-11-19 14:43:55','120',NULL,NULL,1,360,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,8,'HORIZONTAL'),
	(25,'2020-11-19 14:43:58','120',NULL,NULL,1,800,360,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,8,'VERTICAL'),
	(26,'2020-11-19 14:44:01','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,8,'SQUARE'),
	(27,'2020-11-19 14:44:02','120',NULL,NULL,1,360,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,9,'HORIZONTAL'),
	(28,'2020-11-19 14:44:04','120',NULL,NULL,1,800,360,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,9,'VERTICAL'),
	(29,'2020-11-19 14:44:05','120',NULL,NULL,1,480,480,'http://52.10.191.88/vodacom_tanzania','BANNER',NULL,NULL,NULL,NULL,NULL,NULL,9,'SQUARE');

/*!40000 ALTER TABLE `campaign_content` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table campaign_publisher_link
# ------------------------------------------------------------

DROP TABLE IF EXISTS `campaign_publisher_link`;

CREATE TABLE `campaign_publisher_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `campaign_id` bigint(20) DEFAULT NULL,
  `publisher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_campaign_publisher_link_camp_idx` (`campaign_id`),
  KEY `fk_campaign_publisher_link_pub_idx` (`publisher_id`),
  CONSTRAINT `fk_campaign_publisher_link_camp` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_campaign_publisher_link_pub` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `campaign_publisher_link` WRITE;
/*!40000 ALTER TABLE `campaign_publisher_link` DISABLE KEYS */;

INSERT INTO `campaign_publisher_link` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `campaign_id`, `publisher_id`)
VALUES
	(1,'2020-11-18 10:30:58',NULL,NULL,NULL,1,1,1),
	(2,'2020-11-18 10:31:08',NULL,NULL,NULL,1,2,1),
	(3,'2020-11-18 10:31:22',NULL,NULL,NULL,1,5,2),
	(4,'2020-11-19 14:45:01',NULL,NULL,NULL,1,6,1),
	(5,'2020-11-19 14:45:02',NULL,NULL,NULL,1,7,1),
	(6,'2020-11-19 14:45:03',NULL,NULL,NULL,1,8,1),
	(7,'2020-11-19 14:45:04',NULL,NULL,NULL,1,9,1),
	(8,'2020-11-24 13:37:16',NULL,NULL,NULL,1,3,1),
	(9,'2020-11-24 13:37:17',NULL,NULL,NULL,1,4,1),
	(10,'2020-11-25 17:41:00',NULL,NULL,NULL,0,10,2),
	(11,'2020-11-25 17:41:04',NULL,NULL,NULL,0,11,1),
	(12,'2020-11-25 17:41:15',NULL,NULL,NULL,0,12,1);

/*!40000 ALTER TABLE `campaign_publisher_link` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table campaign_scp_flow
# ------------------------------------------------------------

DROP TABLE IF EXISTS `campaign_scp_flow`;

CREATE TABLE `campaign_scp_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `flow_name` varchar(100) NOT NULL,
  `campaign_id` bigint(20) NOT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_campaign_id_scp_link_idx` (`campaign_id`),
  CONSTRAINT `fk_campaign_id_scp_link` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `campaign_scp_flow` WRITE;
/*!40000 ALTER TABLE `campaign_scp_flow` DISABLE KEYS */;

INSERT INTO `campaign_scp_flow` (`id`, `crdt`, `created_by`, `last_modified_on`, `last_modified_by`, `is_active`, `flow_name`, `campaign_id`, `priority`)
VALUES
	(1,'2020-11-24 13:49:02',0,NULL,NULL,1,'islamic',3,10),
	(2,'2020-11-24 13:49:11',0,NULL,NULL,1,'magic voice',4,10),
	(3,'2020-11-24 13:49:04',0,NULL,NULL,1,'magic voice',3,5);

/*!40000 ALTER TABLE `campaign_scp_flow` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table campaign_shortcode
# ------------------------------------------------------------

DROP TABLE IF EXISTS `campaign_shortcode`;

CREATE TABLE `campaign_shortcode` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `short_code` varchar(45) NOT NULL,
  `campaign_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_campaing_short_code_idx` (`campaign_id`),
  CONSTRAINT `fk_campaing_short_code` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `campaign_shortcode` WRITE;
/*!40000 ALTER TABLE `campaign_shortcode` DISABLE KEYS */;

INSERT INTO `campaign_shortcode` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `short_code`, `campaign_id`)
VALUES
	(1,'2020-11-27 17:15:52',NULL,NULL,NULL,1,'63268',3),
	(2,'2020-11-27 17:15:52',NULL,NULL,NULL,1,'63268',4),
	(10,'2020-11-27 17:15:52',NULL,NULL,NULL,1,'63268',10),
	(11,'2020-11-27 17:15:52',NULL,NULL,NULL,1,'63268',11),
	(12,'2020-11-27 17:15:52',NULL,NULL,NULL,1,'63268',12);

/*!40000 ALTER TABLE `campaign_shortcode` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table capping
# ------------------------------------------------------------

DROP TABLE IF EXISTS `capping`;

CREATE TABLE `capping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `max_click` bigint(20) DEFAULT NULL,
  `current_click` bigint(20) DEFAULT NULL,
  `max_impression` bigint(20) DEFAULT NULL,
  `current_impression` bigint(20) DEFAULT NULL,
  `campaign_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_capping_campaign_idx` (`campaign_id`),
  CONSTRAINT `fk_capping_campaign` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table loan
# ------------------------------------------------------------

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `pack_id` bigint(20) DEFAULT NULL,
  `credit_date` datetime DEFAULT NULL,
  `msisdn` bigint(20) DEFAULT NULL,
  `repayment_date` varchar(45) DEFAULT NULL,
  `lendor_callback_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_loan_pack_idx` (`pack_id`),
  CONSTRAINT `fk_loan_pack` FOREIGN KEY (`pack_id`) REFERENCES `pack` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `menu_id` varchar(11) NOT NULL,
  `menu_name` varchar(45) NOT NULL,
  `menu_displayname` varchar(45) NOT NULL,
  `display` tinyint(1) NOT NULL,
  `submenu_id` varchar(45) NOT NULL,
  `role_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_menu_1_idx` (`role_id`),
  CONSTRAINT `fk_menu_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table operators
# ------------------------------------------------------------

DROP TABLE IF EXISTS `operators`;

CREATE TABLE `operators` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `logo_image_url` varchar(500) DEFAULT NULL,
  `banner_url` varchar(500) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `operators` WRITE;
/*!40000 ALTER TABLE `operators` DISABLE KEYS */;

INSERT INTO `operators` (`id`, `crdt`, `created_by`, `last_modified_on`, `last_modified_by`, `is_active`, `name`, `description`, `logo_image_url`, `banner_url`, `country`)
VALUES
	(1,'2020-06-08 03:56:53',0,NULL,NULL,1,'BNG',NULL,NULL,NULL,'india'),
	(2,'2020-08-24 17:57:52',1,'2020-06-08 03:56:53',NULL,1,'MTN',NULL,NULL,NULL,'Yemen'),
	(3,'2020-06-08 03:56:53',1,NULL,NULL,1,'Tigo',NULL,NULL,NULL,'Tanzania'),
	(4,'2020-06-08 03:56:53',1,'2020-06-08 03:56:53',NULL,1,'MTN',NULL,NULL,NULL,'Syria');

/*!40000 ALTER TABLE `operators` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table pack
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pack`;

CREATE TABLE `pack` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  `type` enum('TALKTIME','DATA') DEFAULT NULL,
  `validity_days` int(11) DEFAULT NULL,
  `detail` varchar(45) DEFAULT NULL,
  `priority` varchar(45) DEFAULT NULL,
  `unit` enum('MINUTE','MB','CURRENCY') NOT NULL,
  `value` int(11) DEFAULT NULL,
  `price` int(12) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `payable_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`unit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table publisher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(45) NOT NULL DEFAULT '',
  `pub_id` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;

INSERT INTO `publisher` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `is_active`, `name`, `pub_id`)
VALUES
	(1,'2020-11-18 12:27:06','120',NULL,NULL,1,'BNG','qwerty12345'),
	(2,'2020-11-18 12:27:14',NULL,NULL,NULL,1,'Airtel','qwerty123456');

/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `name` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `display_name` varchar(145) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table service_preference
# ------------------------------------------------------------

DROP TABLE IF EXISTS `service_preference`;

CREATE TABLE `service_preference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `preference` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `service_preference` WRITE;
/*!40000 ALTER TABLE `service_preference` DISABLE KEYS */;

INSERT INTO `service_preference` (`id`, `crdt`, `created_by`, `last_modified_by`, `last_modified_on`, `name`, `preference`, `is_active`)
VALUES
	(1,'2020-12-09 15:52:01',NULL,NULL,NULL,'Loan',1,1),
	(2,'2020-12-09 15:54:34',NULL,NULL,NULL,'Ads',2,1),
	(3,'2020-12-09 15:52:02',NULL,NULL,NULL,'Other',3,1);

/*!40000 ALTER TABLE `service_preference` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sub_submenu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sub_submenu`;

CREATE TABLE `sub_submenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `submenu_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `displayname` varchar(145) DEFAULT NULL,
  `display` tinyint(1) DEFAULT NULL,
  `iseditable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sub_submenu_1_idx` (`submenu_id`),
  CONSTRAINT `fk_sub_submenu_1` FOREIGN KEY (`submenu_id`) REFERENCES `submenu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table submenu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `submenu`;

CREATE TABLE `submenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `submenu_id` int(11) DEFAULT NULL,
  `submenu_name` varchar(45) DEFAULT NULL,
  `submenu_displayname` varchar(145) DEFAULT NULL,
  `display` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_submenu` (`submenu_id`),
  CONSTRAINT `FK_submenu` FOREIGN KEY (`submenu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table targeting
# ------------------------------------------------------------

DROP TABLE IF EXISTS `targeting`;

CREATE TABLE `targeting` (
  `id` bigint(20) NOT NULL,
  `crdt` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(45) DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `browser` text,
  `browser_action` enum('ALLOW','BLOCK') DEFAULT 'ALLOW',
  `device` text,
  `device_action` enum('ALLOW','BLOCK') DEFAULT 'ALLOW',
  `campaign_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_targeting_camp_idx` (`campaign_id`),
  CONSTRAINT `fk_targeting_camp` FOREIGN KEY (`campaign_id`) REFERENCES `campaign` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(150) NOT NULL,
  `company_email` varchar(150) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `permission` varchar(45) DEFAULT NULL,
  `superuserid` varchar(150) DEFAULT NULL,
  `superuser_name` varchar(45) DEFAULT NULL,
  `company_name` varchar(150) DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT NULL,
  `issubuser` tinyint(1) DEFAULT NULL,
  `superuser_operation` tinyint(1) DEFAULT NULL,
  `joined_date` datetime DEFAULT NULL,
  `msisdn_length` int(11) DEFAULT NULL,
  `country_code` varchar(10) DEFAULT NULL,
  `append_countrycode` tinyint(1) DEFAULT NULL,
  `retry` tinyint(1) DEFAULT NULL,
  `mscip` varchar(45) DEFAULT NULL,
  `voicechannel` varchar(45) DEFAULT NULL,
  `tps` int(100) DEFAULT NULL,
  `cli` varchar(45) DEFAULT NULL,
  `blacklist` tinyint(1) DEFAULT NULL,
  `operator` bigint(20) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `verify_mail` tinyint(1) DEFAULT NULL,
  `userdata` varchar(200) DEFAULT NULL,
  `current_pin` varchar(45) DEFAULT NULL,
  `enterprise` tinyint(1) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `uid` text,
  `currency` varchar(45) DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  `last_modified_on` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by` varchar(45) DEFAULT NULL,
  `service_permission` varchar(45) DEFAULT '1_2_3_4_5',
  `user_type` int(11) DEFAULT NULL,
  `publisher_id` bigint(20) DEFAULT NULL,
  `advertiser_id` bigint(20) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_iobd_users_1_idx` (`operator`),
  KEY `fk_iobduser_usertype_idx` (`user_type`),
  KEY `fk_user_publisher_idx` (`publisher_id`),
  KEY `fk_user_agency_idx` (`agency_id`),
  KEY `fk_user_advertiser_idx` (`advertiser_id`),
  CONSTRAINT `fk_iobd_users_1` FOREIGN KEY (`operator`) REFERENCES `operators` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_iobduser_usertype` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_advertiser` FOREIGN KEY (`advertiser_id`) REFERENCES `advertiser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `name`, `email`, `company_email`, `password`, `permission`, `superuserid`, `superuser_name`, `company_name`, `isactive`, `issubuser`, `superuser_operation`, `joined_date`, `msisdn_length`, `country_code`, `append_countrycode`, `retry`, `mscip`, `voicechannel`, `tps`, `cli`, `blacklist`, `operator`, `country`, `role`, `verify_mail`, `userdata`, `current_pin`, `enterprise`, `mobile`, `uid`, `currency`, `vendor_id`, `last_modified_on`, `last_modified_by`, `service_permission`, `user_type`, `publisher_id`, `advertiser_id`, `agency_id`)
VALUES
	(114,'nm','test@gmail.com','mansi@blackngreen.com','FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=',NULL,'mansi','check kabira','bng',1,1,1,'2020-06-23 00:39:22',9,'+09',1,1,'217.0.0.1','ew',90,'90',0,1,'nhi pta',1,0,'69d6a581-7cb2-40b3-98be-39802b29e801',NULL,0,NULL,'69d6a581-7cb2-40b3-98be-39802b29e801','russian',0,'2020-06-23 00:39:22',NULL,'1_2_3_4_5',NULL,NULL,NULL,NULL),
	(116,'Mansi Rajora','mansirajora09@gmail.com','mansi@blackngreen.com','FeKw08M4keuw8e9gnsQZQgwg4yDOlMZfvIwzEkSOsiU=','','114',NULL,'bng',0,1,0,'2020-07-20 12:43:06',10,'',0,0,'','',0,'',0,1,'India',1,0,'http://www.reachezy.com/portal/#!/demoid/ef088ab6-de5d-4715-9ac8-b4546af07f98',NULL,0,NULL,'ef088ab6-de5d-4715-9ac8-b4546af07f98','INR',0,'2020-07-20 12:43:06',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table zbp_configuration
# ------------------------------------------------------------

DROP TABLE IF EXISTS `zbp_configuration`;

CREATE TABLE `zbp_configuration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crdt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` bigint(20) NOT NULL,
  `last_modified_on` timestamp NULL DEFAULT NULL,
  `last_modified_by` bigint(20) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `max_call_allowed_ads` int(11) DEFAULT NULL,
  `max_call_allowed_loan` int(11) DEFAULT NULL,
  `max_call_allowed_zbp` int(11) DEFAULT NULL,
  `high_priority_ads_freq` int(11) DEFAULT NULL,
  `mid_priority_ads_freq` int(11) DEFAULT NULL,
  `low_priority_ads_freq` int(11) DEFAULT NULL,
  `high_priority_loan_freq` int(11) DEFAULT NULL,
  `mid_priority_loan_freq` int(11) DEFAULT NULL,
  `low_priority_loan_freq` int(11) DEFAULT NULL,
  `high_priority_zbp_freq` int(11) DEFAULT NULL,
  `mid_priority_zbp_freq` int(11) DEFAULT NULL,
  `low_priority_zbp_freq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `zbp_configuration` WRITE;
/*!40000 ALTER TABLE `zbp_configuration` DISABLE KEYS */;

INSERT INTO `zbp_configuration` (`id`, `crdt`, `created_by`, `last_modified_on`, `last_modified_by`, `is_active`, `max_call_allowed_ads`, `max_call_allowed_loan`, `max_call_allowed_zbp`, `high_priority_ads_freq`, `mid_priority_ads_freq`, `low_priority_ads_freq`, `high_priority_loan_freq`, `mid_priority_loan_freq`, `low_priority_loan_freq`, `high_priority_zbp_freq`, `mid_priority_zbp_freq`, `low_priority_zbp_freq`)
VALUES
	(1,'2020-12-02 17:37:26',0,NULL,NULL,0,5,5,7,2,2,2,2,2,2,2,2,2);

/*!40000 ALTER TABLE `zbp_configuration` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
