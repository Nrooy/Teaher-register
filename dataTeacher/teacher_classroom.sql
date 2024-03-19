-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: teacher
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKio8crqqepwi9ox33ui6enoi5x` (`building_id`),
  CONSTRAINT `FKio8crqqepwi9ox33ui6enoi5x` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'201-A1','Hoang gia',30,1),(2,'202-A1','Hoang gia',30,1),(3,'301-A1','Hoang gia',30,1),(4,'302-A1','Hoang gia',30,1),(5,'101-A2','Thuong dan',60,1),(6,'102-A2','Thuong dan',60,1),(7,'201-A2','Thuong dan',60,1),(8,'202-A2','Thuong dan',60,1),(9,'203-A2','Thuong dan',60,1),(10,'204-A2','Thuong dan',60,1),(11,'301-A2','Thuong dan',60,1),(12,'302-A2','Thuong dan',60,1),(13,'303-A2','Thuong dan',60,1),(14,'304-A2','Thuong dan',60,1),(15,'201-A3','Thuong dan thuc hanh',90,1),(16,'202-A3','Thuong dan thuc hanh',90,1),(17,'301-A3','Thuong dan thuc hanh',90,1),(18,'303-A3','Thuong dan thuc hanh',90,1),(19,'305-A3','Thuong dan thuc hanh',90,1),(20,'307-A3','Thuong dan thuc hanh',90,1),(21,'309-A3','Thuong dan thuc hanh',90,1),(22,'311-A3','Thuong dan thuc hanh',90,1),(23,'401-A3','Thuong dan thuc hanh',90,1),(24,'402-A3','Thuong dan thuc hanh',90,1),(25,'403-A3','Thuong dan thuc hanh',90,1),(26,'501-A3','Thuong dan thuc hanh',90,1),(27,'503-A3','Thuong dan thuc hanh',90,1),(28,'505-A3','Thuong dan thuc hanh',90,1),(29,'507-A3','Thuong dan thuc hanh',90,1),(30,'509-A3','Thuong dan thuc hanh',90,1);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-19 10:37:13
