-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: slearn
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `min` double NOT NULL,
  `max` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `choice`
--

DROP TABLE IF EXISTS `choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `choice_text` varchar(1000) NOT NULL,
  `category` int(11) DEFAULT NULL,
  `question` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `question_fk_idx` (`question`),
  KEY `category_fk_idx` (`category`),
  CONSTRAINT `FK44vwej9g109rxo3lxpaqorn86` FOREIGN KEY (`question`) REFERENCES `question` (`id`),
  CONSTRAINT `FKhbnjng65tnvphen5ffp6crv0n` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `category_fk` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `question_fk` FOREIGN KEY (`question`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `knowledge_item`
--

DROP TABLE IF EXISTS `knowledge_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `lesson` int(11) NOT NULL,
  `total_theoretical_qs` int(11) DEFAULT '0',
  `total_reasoning_qs` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lesson_fk_idx` (`lesson`),
  CONSTRAINT `FKr64vui6lq2x9jwd1tp0v6lvmr` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `lesson_fk` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lesson_connection`
--

DROP TABLE IF EXISTS `lesson_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson_connection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `connection_value` double NOT NULL,
  `lesson1` int(11) DEFAULT NULL,
  `lesson2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lsn1_fk_idx` (`lesson1`),
  KEY `lsn2_fk_idx` (`lesson2`),
  CONSTRAINT `FKatlrhgb5qxkr67lsjdo84x60g` FOREIGN KEY (`lesson1`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FKoo4g36f0n6eljfklfia9lltd7` FOREIGN KEY (`lesson2`) REFERENCES `lesson` (`id`),
  CONSTRAINT `lsn1_fk` FOREIGN KEY (`lesson1`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lsn2_fk` FOREIGN KEY (`lesson2`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(400) NOT NULL,
  `lesson` int(11) DEFAULT NULL,
  `knowledge_item` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lesson_fk_idx` (`lesson`),
  KEY `ki_q_fk_idx` (`knowledge_item`),
  CONSTRAINT `FKdp8j55qr7gnhmc06e85v5rtyt` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FKln9bgcejjfk2y29n2xn9stoqh` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`),
  CONSTRAINT `ki_q_fk` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lesson_q_fk` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question_activity`
--

DROP TABLE IF EXISTS `question_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `question` int(11) NOT NULL,
  `knowledge_item` int(11) DEFAULT NULL,
  `lesson` int(11) DEFAULT NULL,
  `difficulty` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_fk_aqct_idx` (`user`),
  KEY `question_fk_aqct_idx` (`question`),
  KEY `lesson_fk_aqct_idx` (`lesson`),
  KEY `FKtffgw3i73ngrt2mllx5b0y3d4` (`knowledge_item`),
  CONSTRAINT `FKcxc7xmc117bnw4yxl0v26r2vf` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKg5c74ldjtuuj7oqsumktla3jr` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`),
  CONSTRAINT `FKss9tkt9i9jyqitg47mmekp9hd` FOREIGN KEY (`question`) REFERENCES `question` (`id`),
  CONSTRAINT `FKtffgw3i73ngrt2mllx5b0y3d4` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`),
  CONSTRAINT `lesson_fk_aqct` FOREIGN KEY (`lesson`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `question_fk_aqct` FOREIGN KEY (`question`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fk_aqct` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=726 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(300) NOT NULL,
  `xp` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `theory_score` double DEFAULT NULL,
  `reasoning_score` double DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_knowledge`
--

DROP TABLE IF EXISTS `user_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `knowledge_item` int(11) NOT NULL,
  `score` double DEFAULT NULL,
  `theoretical_qs_answered` int(11) DEFAULT NULL,
  `reasoning_qs_answered` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_k_fk_idx` (`user`),
  KEY `ki_fk_idx` (`knowledge_item`),
  CONSTRAINT `FK5skbtoi530l0c5lolxk63sfj2` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`),
  CONSTRAINT `FKi35vujnpcrpjdtvrma1wl9b7f` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `ki_fk` FOREIGN KEY (`knowledge_item`) REFERENCES `knowledge_item` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_k_fk` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-27 19:16:27
