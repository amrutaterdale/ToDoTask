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
-- Table structure for table `registereduser`
--

DROP TABLE IF EXISTS `registereduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registereduser` (
  `firstName` varchar(25) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `pwd` varchar(35) DEFAULT NULL,
  `confirmPwd` varchar(35) DEFAULT NULL,
  `regDate` date DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `randomno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registereduser`
--

LOCK TABLES `registereduser` WRITE;
/*!40000 ALTER TABLE `registereduser` DISABLE KEYS */;
INSERT INTO `registereduser` VALUES ('Neha','Terdale','female','neha@gmail.com','2020-08-05','123','123','2020-08-07',1,13,NULL),('Amruta','patil','female','amruta@gmail.com','2020-08-14','89','89','2020-08-27',1,14,NULL),('Aditya','Mahajan','male','aditya@gmail.com','2020-08-13','12','12','2020-08-13',0,15,NULL),('Piya','jadhav','female','piya@gmail.com','2020-08-14','78','78','2020-08-20',1,16,NULL),('pranav','brahme','male','pranav@gmail.com','2020-09-16','123','123','2020-09-24',1,17,NULL),('gh','op','female','g@gmail.com','2020-09-24','02','02','2020-09-01',0,18,NULL),('achal','patil','female','achal@gmail.com','2020-09-24','56','56','2020-08-31',1,19,NULL),('Rohit','Sharma','male','rohit@gmail.com','2020-09-11','rohit','rohit','2020-09-03',1,24,NULL),('virat','kohli','male','virat@gmail.com','2020-09-16','5','5','2020-09-03',1,25,NULL),('priyanka','pabalkar','female','tqpriyanka@gmail.com','2020-09-17','14','14','2020-09-10',1,51,1451);
/*!40000 ALTER TABLE `registereduser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-19 14:36:01
