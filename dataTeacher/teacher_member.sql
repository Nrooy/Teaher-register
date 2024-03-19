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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'anhpn','anhpn','Pham Ngoc Anh','1990-01-01','Ha Noi','anhpn@gmail.com','0912316141'),(2,'thanhltm','thanhltm','Le Thi Minh Thanh','1990-01-01','Ha Noi','thanhltm@gmail.com','0904801508'),(3,'giaonq','giaonq','Nguyen Quynh Giao','1990-01-01','Ha Noi','giaonq@gmail.com','0934100636'),(4,'ninhdm','ninhdm','Dao Manh Ninh','1990-01-01','Ha Noi','ninhdm@gmail.com','0914788000'),(5,'thinhnd','thinhnd','Nguyen Duc Thinh','1990-01-01','Ha Noi','thinhnd@gmail.com','0913556590'),(6,'bannt','bannt','Nguyen Tien Ban','1990-01-01','Ha Noi','bannt@gmail.com','0904110109'),(7,'trinhnc','trinhnc','Nguyen Chien Trinh','1990-01-01','Ha Noi','trinhnc@gmail.com','0915400946'),(8,'minhht','minhht','Hoang Trong Minh','1990-01-01','Ha Noi','minhht@gmail.com','0913259259'),(9,'nhannd','nhannd','Nguyen Duc Nhan','1990-01-01','Ha Noi','nhannd@gmail.com','0439170811'),(10,'chaulh','chaulh','Pham Ngoc Anh','1990-01-01','Ha Noi','chaulh@gmail.com','0911465080'),(11,'ngocdt','ngocdt','Dang The Ngoc','1990-01-01','Ha Noi','ngocdt@gmail.com','0918686517'),(12,'minhnn','minhnn','Nguyen Ngoc Minh','1990-01-01','Ha Noi','minhnn@gmail.com','0912824193'),(13,'thiennd','thiennd','Ngo Duc Thien','1990-01-01','Ha Noi','thiennd@gmail.com','0912316141'),(14,'hieunt','hieunt','Nguyen Trung Hieu','1990-01-01','Ha Noi','hieunt@gmail.com','0916566268'),(15,'phuongnd','phuongnd','Nguyen Duy Phuong','1990-01-01','Ha Noi','phuongnd@gmail.com','0913575442'),(16,'bachnx','bachnx','Ngo Xuan Bach','1990-01-01','Ha Noi','bachnx@gmail.com','0898980268'),(17,'dauhx','dauhx','Hoang Xuan Dau','1990-01-01','Ha Noi','dauhx@gmail.com','0904534390'),(18,'cuongpv','cuongpv','Pham Van Cuong','1990-01-01','Ha Noi','cuongpv@gmail.com','0904018876'),(19,'hungnm','hungnm','Nguyen Manh Hung','1990-01-01','Ha Noi','hungnm@gmail.com','0987812082'),(20,'phongvt','phongvt','Vu Trong Phong','1990-01-01','Ha Noi','phongvt@gmail.com','0912099811'),(21,'thaptt','thaptt','Tran Thi Thap','1990-01-01','Ha Noi','thaptt@gmail.com','0912212929'),(22,'ducdtv','ducdtv','Dang Thi Viet Duc','1990-01-01','Ha Noi','ducdtv@gmail.com','0914932612'),(23,'haunv','haunv','Nguyen Van Hau','1990-01-01','Ha Noi','haunv@gmail.com','0933132286'),(24,'tienvh','tienvh','Vu Huu Tien','1990-01-01','Ha Noi','tienvh@gmail.com','0914932612'),(25,'trungtq','trungtq','Tran Quoc Trung','1990-01-01','Ha Noi','trungtq@gmail.com','0901788999'),(26,'hanglt','hanglt','Le Thi Hang','1990-01-01','Ha Noi','hanglt@gmail.com','0904826618');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-19 10:37:15
