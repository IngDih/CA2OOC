CREATE DATABASE  IF NOT EXISTS `ca2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ca2`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ca2
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `result_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `setOfEquations` varchar(255) NOT NULL,
  `valueOfX` varchar(255) DEFAULT '-',
  `valueOfY` varchar(255) DEFAULT '-',
  `valueOfZ` varchar(255) DEFAULT '-',
  PRIMARY KEY (`result_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (97,32,'3x+1y+7z+9=0;3x+5y+3z+2=0;4x+7y+7z+4=0','-2.05','1.18','-0.58'),(98,32,'2x+1y+7z-4=0;3x+9y+3z+2=0;4x+5y+7z+3=0','-5.27','0.88','1.95'),(100,33,'4x+9y+9z+6=0;7x+4y+9z+6=0;8x+6y+9z+7=0','-0.45','-0.27','-0.19'),(101,33,'9x+9y+9z+6=0;7x+4y+9z+8=0;8x+6y+9z+3=0','21.00','-8.00','-13.67'),(102,34,'7x+8y+4z+1=0;9x+3y+6z+1=0;4x+8y+2z+4=0','19.67','-3.33','-28.00'),(103,35,'5x-8y+2=0;7x-2y+4=0','-0.61','-0.13','-'),(104,35,'2x-8y+3=0;4x-2y+7=0','-1.79','-0.07','-'),(105,37,'2x+5y+9=0;5x+3y+2=0','0.89','-2.16','-'),(106,37,'2x+5y+3=0;2x+3y+2=0','-0.25','-0.50','-'),(107,37,'7x+2y+3=0;2x+4y+5=0','-0.08','-1.21','-'),(108,41,'3x-7y+8z+9=0;4x-7y+8z+6=0;3x-7y+2z+3=0','3.00','1.43','-1.00'),(109,41,'3x-2y+2z+3=0;4x-7y+8z+3=0;3x-7y+2z+3=0','-1.13','0.00','0.19'),(110,41,'3x-3y+2z+3=0;4x-7y+6z+3=0;2x-7y+2z+4=0','-1.00','0.50','0.75'),(111,41,'3x-3y+2z+3=0;4x-7y+7z+2=0;2x-7y+2z+4=0','-1.03','0.51','0.81'),(112,42,'4x+5y+8=0;4x+2y+4=0','-0.33','-1.33','-'),(113,42,'7x+2y+8=0;1x+4y+4=0','-0.92','-0.77','-'),(114,42,'7x+3y+4=0;1x+4y+4=0','-0.16','-0.96','-'),(115,42,'8x+3y+4=0;7x+2y+3=0','-0.20','-0.80','-'),(116,42,'8x+3y+6=0;7x+8y+3=0','-0.91','0.42','-'),(117,43,'8x+4y+9=0;2x+2y+5=0','0.25','-2.75','-');
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `isAdmin` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `id_UNIQUE` (`user_id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'CCT','Dublin','admin','admin',1),(32,'ingcas','pass1234','Ingrid','Menezes',0),(33,'cbaker','test','Christine','Baker',0),(34,'pmoore','test','Peter','Moore',0),(35,'lsmith','test','Logan','Smith',0),(36,'smurphy','test','Shaun','Murphy',0),(37,'imcastro','pass1234','Ingrid','Castro',0),(38,'robszlufik','test','Robert','Szlufik',0),(39,'noconnor','test','Niamh','O\'coinnor',0),(40,'aboyle','test','Amy','Boyle',0),(41,'lsilva','test','Linda','Silva',0),(42,'cjohn','test','John','Cena',0),(43,'ymckenzie','test','Yan','Mckenzie',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-18 10:23:44
