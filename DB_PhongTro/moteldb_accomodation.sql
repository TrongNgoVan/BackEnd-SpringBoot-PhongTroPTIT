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
-- Table structure for table `accomodation`
--

DROP TABLE IF EXISTS `accomodation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accomodation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `acreage` double NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `air_conditioner` bit(1) NOT NULL,
  `cabletv` bit(1) NOT NULL,
  `electric_price` double DEFAULT NULL,
  `heater` bit(1) NOT NULL,
  `internet` bit(1) NOT NULL,
  `motel` bit(1) NOT NULL,
  `parking` bit(1) NOT NULL,
  `price` double NOT NULL,
  `status` bit(1) NOT NULL,
  `toilet` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `tv` bit(1) NOT NULL,
  `water_price` double DEFAULT NULL,
  `x_coordinate` double NOT NULL,
  `y_coordinate` double NOT NULL,
  `district_id` bigint DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKq53a7bgkai6ybq8cc86v4tduq` (`district_id`) USING BTREE,
  KEY `FKb7bq3ifinxseoia87hja6slat` (`post_id`) USING BTREE,
  CONSTRAINT `FKb7bq3ifinxseoia87hja6slat` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKq53a7bgkai6ybq8cc86v4tduq` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accomodation`
--

LOCK TABLES `accomodation` WRITE;
/*!40000 ALTER TABLE `accomodation` DISABLE KEYS */;
INSERT INTO `accomodation` VALUES (1,20,'130 Nguyễn Văn Trỗi , Mộ Lao , Hà Đông, Hà Nội',_binary '',_binary '',0,_binary '\0',_binary '',_binary '',_binary '\0',5000000,_binary '','KHEP_KIN',_binary '',0,20.981418,105.785575,15,1),(2,20,'44 Phố Đại An/3 Phố Ao Sen, Tổ dân phố 3, Mộ Lao, Hà Đông, Hà Nội',_binary '\0',_binary '',0,_binary '\0',_binary '',_binary '',_binary '',1400000,_binary '','KHEP_KIN',_binary '',0,20.982032,105.788599,15,2),(3,35,'22 Đ. Yên Xá, Tân Triều, Thanh Trì, Hà Nội, Việt Nam',_binary '\0',_binary '',0,_binary '\0',_binary '',_binary '\0',_binary '',1500000,_binary '','KHEP_KIN',_binary '',0,20.967354,105.795828,15,3),(4,58,'14-2 Ngõ 23 Nguyễn Khuyến, P. Văn Quán, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '\0',_binary '',13000000,_binary '','KHEP_KIN',_binary '',0,20.979337,105.790016,15,4),(5,20,'111 Nguyễn Khuyến, P. Văn Quán, Hà Đông, Hà Nội 100000, Việt Nam',_binary '\0',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '',1200000,_binary '','KHEP_KIN',_binary '\0',0,20.977336,105.788175,15,5),(6,40,'Ng. 133 Nguyễn Văn Trỗi, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',3500,_binary '\0',_binary '\0',_binary '',_binary '\0',900000,_binary '','CHUNG',_binary '\0',0,20.980336,105.783859,15,6),(7,25,'87 Ng. 58 Đ. Thanh Bình, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '',_binary '\0',4000000,_binary '','KHEP_KIN',_binary '',0,20.979841,105.783091,1,7),(8,26,'72 P. Đại An, P. Văn Quán, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '',_binary '\0',4000000,_binary '','KHEP_KIN',_binary '',0,20.978719,105.79162,1,8),(9,30,'102  Chiến Thắng, Tân Triều, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '',_binary '\0',6000000,_binary '','KHEP_KIN',_binary '',0,20.980392,105.795182,1,9),(10,16,'63  P. Phùng Khoang, Trung Văn, Từ Liêm, Hà Nội, Việt Nam',_binary '',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '\0',6000000,_binary '','KHEP_KIN',_binary '',0,20.986704,105.793386,1,10),(11,30,'58 P. Dương Lâm, P. Văn Quán, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '\0',4800000,_binary '','KHEP_KIN',_binary '',0,20.975461,105.787691,1,11),(12,26,'Ng. 87 Đ. Yên Xá, Tân Triều, Thanh Trì, Hà Nội, Việt Nam',_binary '',_binary '',4000,_binary '\0',_binary '',_binary '',_binary '\0',4700000,_binary '','KHEP_KIN',_binary '',0,20.96954,105.79574,1,12),(13,30,'Ng. 181 Đ. Trần Phú, P. Văn Quán, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '\0',0,_binary '\0',_binary '',_binary '\0',_binary '',1500000,_binary '','KHEP_KIN',_binary '\0',0,20.976373,105.786318,13,13),(14,150,'2 P. Dương Lâm, P. Văn Quán, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '',_binary '',_binary '\0',_binary '',15000000,_binary '','KHEP_KIN',_binary '',0,20.977247,105.786302,13,14),(15,50,'Ng. 95 Đ. Chiến Thắng, P. Văn Quán, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '',_binary '',4500000,_binary '','CHUA_XAC_DINH',_binary '\0',0,20.9817,105.7943,13,15),(16,25,'4 Ngõ 5 Ao Sen, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',3000,_binary '\0',_binary '',_binary '',_binary '',2700000,_binary '','KHEP_KIN',_binary '\0',0,20.982132,105.787911,13,16),(17,20,'3  Ngõ 2 Ao Sen, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',0,_binary '\0',_binary '\0',_binary '',_binary '\0',600000,_binary '','CHUA_XAC_DINH',_binary '\0',0,20.981606,105.788451,13,17),(18,39,'92 N. 6, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '',4000,_binary '\0',_binary '',_binary '',_binary '',525000,_binary '','KHEP_KIN',_binary '\0',6000,20.982367,105.786987,13,18),(19,25,'Ngõ 58 Phố Ao Sen, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '',2500000,_binary '','KHEP_KIN',_binary '\0',0,20.982632,105.787824,13,19),(20,15,'16 , 16A3, Làng Việt kiều Châu Âu, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '',2900000,_binary '','KHEP_KIN',_binary '\0',0,20.983821,105.786615,13,20),(21,15,'7 Ngõ 8 Ao Sen, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',4000,_binary '\0',_binary '',_binary '',_binary '',1900000,_binary '','KHEP_KIN',_binary '\0',5000,20.982585,105.7874,13,21),(22,22,'1 P. Ao Sen, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '',3000000,_binary '','KHEP_KIN',_binary '\0',0,20.982679,105.787554,13,22),(23,107,'112  P. Nguyễn Văn Trỗi, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '\0',_binary '',10000000,_binary '','KHEP_KIN',_binary '\0',0,20.980791,105.785962,13,23),(24,46,'19  Ng. 109 P. Nguyễn Văn Trỗi, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '',_binary '',0,_binary '\0',_binary '',_binary '\0',_binary '',7500000,_binary '','KHEP_KIN',_binary '',0,20.982455,105.784135,13,24),(25,12,'Ngõ 27 Nguyễn Văn Lộc, P. Mộ Lao, Hà Đông, Hà Nội, Việt Nam',_binary '\0',_binary '\0',0,_binary '\0',_binary '',_binary '',_binary '',2800000,_binary '','KHEP_KIN',_binary '\0',0,20.984736,105.78359,1,25);
/*!40000 ALTER TABLE `accomodation` ENABLE KEYS */;
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
