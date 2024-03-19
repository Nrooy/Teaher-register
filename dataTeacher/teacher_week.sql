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
-- Table structure for table `week`
--

DROP TABLE IF EXISTS `week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `week` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `week`
--

LOCK TABLES `week` WRITE;
/*!40000 ALTER TABLE `week` DISABLE KEYS */;
INSERT INTO `week` VALUES (1,'Tuan 1','Cung hoc nao'),(2,'Tuan 2','Cung hoc nao'),(3,'Tuan 3','Cung hoc nao'),(4,'Tuan 4','Cung hoc nao'),(5,'Tuan 5','Cung hoc nao'),(6,'Tuan 6','Cung hoc nao'),(7,'Tuan 7','Cung hoc nao'),(8,'Tuan 8','Cung hoc nao'),(9,'Tuan 9','Cung hoc nao'),(10,'Tuan 10','Cung hoc nao'),(11,'Tuan 11','Cung hoc nao'),(12,'Tuan 12','Cung hoc nao'),(13,'Tuan 13','Cung hoc nao'),(14,'Tuan 14','Cung hoc nao'),(15,'Tuan 15','Cung hoc nao'),(16,'Tuan 16','Cung hoc nao'),(17,'Tuan 17','Cung hoc nao'),(18,'Tuan 18','Cung hoc nao'),(19,'Tuan 19','Cung hoc nao'),(20,'Tuan 20','Cung hoc nao'),(21,'Tuan 21','Cung hoc nao'),(22,'Tuan 22','Cung hoc nao'),(23,'Tuan 23','Cung hoc nao'),(24,'Tuan 24','Cung hoc nao'),(25,'Tuan 25','Cung hoc nao'),(26,'Tuan 26','Cung hoc nao'),(27,'Tuan 27','Cung hoc nao'),(28,'Tuan 28','Cung hoc nao'),(29,'Tuan 29','Cung hoc nao'),(30,'Tuan 30','Cung hoc nao'),(31,'Tuan 31','Cung hoc nao'),(32,'Tuan 32','Cung hoc nao'),(33,'Tuan 33','Cung hoc nao'),(34,'Tuan 34','Cung hoc nao'),(35,'Tuan 35','Cung hoc nao'),(36,'Tuan 36','Cung hoc nao'),(37,'Tuan 37','Cung hoc nao'),(38,'Tuan 38','Cung hoc nao'),(39,'Tuan 39','Cung hoc nao'),(40,'Tuan 40','Cung hoc nao'),(41,'Tuan 41','Cung hoc nao'),(42,'Tuan 42','Cung hoc nao'),(43,'Tuan 43','Cung hoc nao'),(44,'Tuan 44','Cung hoc nao'),(45,'Tuan 45','Cung hoc nao'),(46,'Tuan 46','Cung hoc nao'),(47,'Tuan 47','Cung hoc nao'),(48,'Tuan 48','Cung hoc nao'),(49,'Tuan 49','Cung hoc nao'),(50,'Tuan 50','Cung hoc nao'),(51,'Tuan 51','Cung hoc nao'),(52,'Tuan 52','Cung hoc nao');
/*!40000 ALTER TABLE `week` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-19 10:37:14
