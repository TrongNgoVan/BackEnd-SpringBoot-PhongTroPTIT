-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: moteldb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `x_coordinate` double NOT NULL,
  `y_coordinate` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Quận Ba Đình',21.0368,105.8359),(2,'Quận Bắc Từ Liêm',21.0677,105.7544),(3,'Quận Cầu Giấy',21.0285,105.791),(4,'Quận Đống Đa',21.0145,105.827),(5,'Quận Hà Đông',20.971,105.7745),(6,'Quận Hai Bà Trưng',21.007,105.8575),(7,'Quận Hoàn Kiếm',21.0285,105.8542),(8,'Quận Hoàng Mai',20.9742,105.8633),(9,'Quận Long Biên',21.0461,105.8913),(10,'Quận Nam Từ Liêm',21.0298,105.7704),(11,'Quận Tây Hồ',21.075,105.82),(12,'Quận Thanh Xuân',20.9931,105.8139),(13,'Huyện Ba Vì',21.24,105.36),(14,'Huyện Chương Mỹ',20.9038,105.5943),(15,'Huyện Đan Phượng',21.1194,105.5953),(16,'Huyện Đông Anh',21.1466,105.8369),(17,'Huyện Gia Lâm',21.0186,105.9766),(18,'Huyện Hoài Đức',20.9773,105.6631),(19,'Huyện Mê Linh',21.2155,105.6996),(20,'Huyện Mỹ Đức',20.7377,105.7333),(21,'Huyện Phú Xuyên',20.7424,105.9153),(22,'Huyện Thanh Oai',20.9384,105.8139),(23,'Huyện Thanh Trì',20.9169,105.8581);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02 14:57:28
