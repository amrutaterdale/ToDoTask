-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: task
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alltask`
--

DROP TABLE IF EXISTS `alltask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alltask` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(45) DEFAULT NULL,
  `tdesc` varchar(45) DEFAULT NULL,
  `chkbox` int(11) DEFAULT '0',
  `status` varchar(10) DEFAULT 'incomplete',
  `email` varchar(45) DEFAULT NULL,
  `taskdate` date DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alltask`
--

LOCK TABLES `alltask` WRITE;
/*!40000 ALTER TABLE `alltask` DISABLE KEYS */;
INSERT INTO `alltask` VALUES (9,'t7','cooking',1,'complete','neha@gmail.com',NULL),(10,'t8','cleaning',1,'complete','neha@gmail.com',NULL),(12,'t6','travelling1',1,'complete','neha@gmail.com',NULL),(13,'t9','eating',0,'incomplete','amruta@gmail.com',NULL),(14,'t45','listening',0,'incomplete','aditya@gmail.com',NULL),(16,'t34','teaching',0,'incomplete','aditya@gmail.com',NULL),(17,'4','fg',1,'complete','piya@gmail.com',NULL),(18,'1','df',1,'complete','piya@gmail.com',NULL),(21,'t09','washing',1,'complete','piya@gmail.com',NULL),(22,'t1','singing',1,'complete','amruta@gmail.com',NULL),(23,'t2123','reading123',1,'complete','amruta@gmail.com',NULL),(25,'r1','rd1',1,'complete','pranav@gmail.com','2020-09-02'),(26,'r5','rd1',0,'incomplete','pranav@gmail.com','2020-09-02'),(27,'r1','rd1',0,'incomplete','pranav@gmail.com','2020-09-02'),(53,'t5','playing',1,'complete','rohit@gmail.com','2020-09-04'),(55,'d3','45',0,'incomplete','amruta@gmail.com','2020-09-04'),(57,'d37','451',1,'complete','amruta@gmail.com','2020-09-04'),(58,'t6','singing',0,'incomplete','piya@gmail.com','2020-09-05'),(59,'t7','running',0,'incomplete','rohit@gmail.com','2020-09-05'),(60,'t41','d4',1,'complete','tqpriyanka@gmail.com','2020-09-10'),(65,'11','2',1,'complete','amruta@gmail.com','2020-09-10');
/*!40000 ALTER TABLE `alltask` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-19 14:35:59
