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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `sectionclass_id` int DEFAULT NULL,
  `period_id` int DEFAULT NULL,
  `day_id` int DEFAULT NULL,
  `week_id` int DEFAULT NULL,
  `classroom_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKspegywv3sqtea4v57fo8yd4gs` (`classroom_id`),
  KEY `FK3il680t7dfitccromhi95dpbp` (`day_id`),
  KEY `FKfce80ugg9yvmelgx40fho0y3j` (`period_id`),
  KEY `FKhotnt5mgtq7645hcvohv5boao` (`sectionclass_id`),
  KEY `FKof1t073hsxioayk2covxfe8um` (`teacher_id`),
  KEY `FKama1o8fh9e8oo2ooiiulcf9ca` (`week_id`),
  CONSTRAINT `FK3il680t7dfitccromhi95dpbp` FOREIGN KEY (`day_id`) REFERENCES `day` (`id`),
  CONSTRAINT `FKama1o8fh9e8oo2ooiiulcf9ca` FOREIGN KEY (`week_id`) REFERENCES `week` (`id`),
  CONSTRAINT `FKfce80ugg9yvmelgx40fho0y3j` FOREIGN KEY (`period_id`) REFERENCES `period` (`id`),
  CONSTRAINT `FKhotnt5mgtq7645hcvohv5boao` FOREIGN KEY (`sectionclass_id`) REFERENCES `sectionclass` (`id`),
  CONSTRAINT `FKof1t073hsxioayk2covxfe8um` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `FKspegywv3sqtea4v57fo8yd4gs` FOREIGN KEY (`classroom_id`) REFERENCES `classroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,33,14),(2,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,34,14),(3,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,35,14),(4,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,36,14),(5,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,37,14),(6,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,38,14),(7,'Kip 3 thu bay','Bat dau vao luc 12h thu bay',NULL,1,3,6,39,14),(8,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,23,14),(9,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,24,14),(10,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,25,14),(11,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,28,14),(12,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,29,14),(13,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,30,14),(14,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,31,14),(15,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,32,14),(16,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,33,14),(17,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,34,14),(18,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,35,14),(19,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,36,14),(20,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,37,14),(21,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,39,14),(22,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,40,14),(23,'Kip 1 thu ba','Bat dau vao luc 7h thu ba',NULL,2,1,2,41,14),(24,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,23,15),(25,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,24,15),(26,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,25,15),(27,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,28,15),(28,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,29,15),(29,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,30,15),(30,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,31,15),(31,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,32,15),(32,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,33,15),(33,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,34,15),(34,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,35,15),(35,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,36,15),(36,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,37,15),(37,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,39,15),(38,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,40,15),(39,'Kip 1 thu tu','Bat dau vao luc 7h thu tu',NULL,3,1,3,41,15),(40,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,23,25),(41,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,24,25),(42,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,25,25),(43,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,28,25),(44,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,29,25),(45,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,30,25),(46,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,31,25),(47,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,32,25),(48,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,33,25),(49,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,34,25),(50,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,35,25),(51,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,36,25),(52,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,37,25),(53,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,39,25),(54,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,40,25),(55,'Kip 1 thu hai','Bat dau vao luc 7h thu hai',NULL,4,1,1,41,25),(56,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,23,22),(57,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,24,22),(58,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,25,22),(59,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,28,22),(60,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,29,22),(61,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,30,22),(62,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,31,22),(63,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,32,22),(64,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,33,22),(65,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,34,22),(66,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,35,22),(67,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,36,22),(68,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,37,22),(69,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,39,22),(70,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,40,22),(71,'Kip 3 thu tu','Bat dau vao luc 12h thu tu',NULL,6,3,3,41,22),(72,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,23,14),(73,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,24,14),(74,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,28,14),(75,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,29,14),(76,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,30,14),(77,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,31,14),(78,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,32,14),(79,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,33,14),(80,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,34,14),(81,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,35,14),(82,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,36,14),(83,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,37,14),(84,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,38,14),(85,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,39,14),(86,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,40,14),(87,'Kip 1 thu sau','Bat dau vao luc 7h thu sau',NULL,8,1,5,41,14),(88,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,23,14),(89,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,24,14),(90,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,25,14),(91,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,28,14),(92,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,29,14),(93,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,30,14),(94,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,31,14),(95,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,32,14),(96,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,33,14),(97,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,34,14),(98,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,35,14),(99,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,36,14),(100,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,37,14),(101,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,39,14),(102,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,40,14),(103,'Kip 2 thu ba','Bat dau vao luc 9h thu ba',NULL,9,2,2,41,14);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
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
