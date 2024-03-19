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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `faculty_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj2xhv1clx0m0axk2y53wm4hgl` (`faculty_id`),
  CONSTRAINT `FKj2xhv1clx0m0axk2y53wm4hgl` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'BM Toan','Toan',1),(2,'BM Vat ly','Vat ly',1),(3,'BM Ngoai ngu','Ngoai ngu',1),(4,'BM Ly luan chinh tri','Ly luan',1),(5,'BM GDTC-QP','GDTC-QP',1),(6,'BM Mang vien thong','Mang vien thong',2),(7,'BM Tin hieu va HT','Tin hieu va HT',2),(8,'BM Thong tin vo tuyen','Thong tin vo tuyen',2),(9,'BM Khoa hoc may tinh','Khoa hoc may tinh',3),(10,'BM An toan thong tin','An toan thong tin',3),(11,'BM He thong thong tin','He thong thong tin',3),(12,'BM CN phan mem','CN phan mem',3),(13,'BM Xu ly tin hieu va truyen thong','Xu ly tin hieu va truyen thong',4),(14,'BM Dien tu may tinh','Dien tu may tinh',4),(15,'BM Kinh te','Kinh te',5),(16,'BM Quan tri','Quan tri',5),(17,'BM Tai chinh','Tai chinh',6),(18,'BM Ke toan va kiem toan','Ke toan va kiem toan',6),(19,'BM Thiet ke DPT','Thiet ke DPT',7),(20,'BM Truyen thong DPT','Truyen thong DPT',7),(21,'BM Cong nghe DPT','Cong nghe DPT',7);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
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
