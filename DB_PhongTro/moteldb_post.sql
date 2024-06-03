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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `approved` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci,
  `create_at` datetime DEFAULT NULL,
  `del` bit(1) NOT NULL,
  `last_update` datetime DEFAULT NULL,
  `not_approved` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`) USING BTREE,
  CONSTRAINT `FK72mt33dhhs48hf9gcqrq4fxte` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,_binary '','<p>Full đồ: Tủ quần áo,Điều Hoà, Nóng Lạnh, Bàn Bếp, hút mùi, tủ lạnh, ban công,... thang máy, ko Chung chủ, giờ giấc tự do\nLiên hệ : 0968825548.</p>','2023-09-15 03:00:00',_binary '\0','2019-09-15 03:00:00',_binary '\0','phòng trọ giá rẻ ',1),(2,_binary '','<p>nguyên sàn tầng 7, chia thành 2 phòng.\nLiên hệ : 0388.275.936</p>','2023-09-15 03:00:00',_binary '\0','2019-05-15 03:00:00',_binary '\0','KHU CĂN HỘ MINI ,PHÒNG ĐẸP SẠCH SẼ ,ĐẦY ĐỦ NỘI THẤT',1),(3,_binary '','<p>Cho Thuê Phòng : Khép kín đầy đủ đồ\n( Gần : Hồ Văn quán, Yên Phúc , Chợ Xanh , Chiến Thắng , Nguyễn Khuyến , KĐT Văn Quán... )\n- Nội thất : Điều hòa, nl , bàn ghế, tủ lạnh, máy giặt, tủ quần áo, bồn rửa kệ bếp,\n- Phòng thoáng có cửa sổ, hút mùi .\n- Không chung chủ.\nBạn nào cần thuê phòng lh/zalo:\n0368226986.</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Ở ghép tổng 2 phòng riêng đầy đủ',1),(4,_binary '','<p>Cho thuê CCMN \nCó giường, tủ , nóng lạnh , điều hòa \nCổng vân tay , h giấc thoải mái , k chung chủ , vệ sinh khép kín , nhà có bảo vệ đảm bảo an ninh 24/24\n- Gần các Trường mầm non, tiểu học, ĐH lớn: ĐH Kiến Trúc, Bưu Chính, Y Dược Học Cổ Truyền, Đh CNGTVT, Sư Phạm Nghệ Thuật Tw\n- Gần các bệnh viện lớn: K Tân Triều, 103 \nLh : 0388.275.936 Em Dũng.</p>','2023-09-25 03:00:00',_binary '\0','2019-09-25 03:00:00',_binary '\0','phòng trọ giá rẻ ',1),(5,_binary '','<p>Nhà mới khai trương, có thể vào ở luôn \nBếp nấu ăn riêng biệt, gác xép + giường ( ở được 4-5 người)</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Tìm 1 nữ  ở ghép',1),(6,_binary '','<p>Thiết kế căn studio vệ sinh khép kín, FULL điều hoà, nóng lạnh, giường to hoặc giường tầng ở dc 3-4 người, tủ quần áo, tủ bếp, bàn ghế ngồi ăn hoặc ngồi học, cửa thoáng mát, camera an ninh các tầng, máy giặt, máy sấy,.....</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng cho thuê ở ghép ',1),(7,_binary '','<p>vệ sinh kép kín\nNội thất : điều hoà , nóng lạnh , giường tủ….\nPhòng rộng 20-25m2\nLiên hệ :0335565416.</p>','2023-09-26 03:00:00',_binary '\0','2023-09-26 03:00:00',_binary '\0','Phòng trọ  đầy đủ tiện nghi',2),(8,_binary '','<p>phòng đầy đủ nội thất , gần: đh Kiến Trúc, Bưu Chính Viễn Thông, Học Viện An Ninh, xung quanh gần chợ, tạp hóa ... thuận tiện đi lại. Hotline: 0919253274.</p>','2023-09-20 03:10:00',_binary '\0','2023-09-20 03:10:00',_binary '\0','Homestay cao cấp 26m2',2),(9,_binary '','<p>Nhà mới khai trương, có thể vào ở luôn \nBếp nấu ăn riêng biệt, gác xép + giường ( ở được 4-5 người)</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng trọ cao cấp ',2),(10,_binary '','<p>Nhà mới khai trương, có thể vào ở luôn \nBếp nấu ăn riêng biệt, gác xép + giường ( ở được 4-5 người).</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng mới  đầy đủ tiện nghi',2),(11,_binary '','<p>Nhà mới khai trương, có thể vào ở luôn \nBếp nấu ăn riêng biệt, gác xép + giường ( ở được 4-5 người)</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng trọ cho thuê',2),(12,_binary '','<p>phòng đầy đủ nội thất , gần: đh Kiến Trúc, Bưu Chính Viễn Thông, Học Viện An Ninh, xung quanh gần chợ, tạp hóa ... thuận tiện đi lại. Hotline: 0919253274</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng cho thuê, giờ giấc tự do, đầy đủ nội thất',2),(13,_binary '','<p>phòng đầy đủ nội thất , gần: đh Kiến Trúc, Bưu Chính Viễn Thông, Học Viện An Ninh, xung quanh gần chợ, tạp hóa ... thuận tiện đi lại. Hotline: 0919253274</p>','2023-09-15 01:00:00',_binary '\0','2023-09-15 01:00:00',_binary '\0','Tìm người ở ghép nhà nguyên căn .',3),(14,_binary '','<p>Thiết kế căn studio vệ sinh khép kín, FULL điều hoà, nóng lạnh, giường to hoặc giường tầng ở dc 3-4 người, tủ quần áo, tủ bếp, bàn ghế ngồi ăn hoặc ngồi học, cửa thoáng mát, camera an ninh các tầng, máy giặt, máy sấy,.....</p>','2023-09-15 01:00:00',_binary '\0','2023-09-15 01:00:00',_binary '\0','Phòng cho thuê, giờ giấc tự do, đầy đủ nội thất',3),(15,_binary '','<p>Còn 1 phòng duy nhất, thêm thông tin các bạn vui lòng inbox vì mình ko nhắn được trước hoặc gọi điện/ nhắn tin qua zalo theo sô 0845906366</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng trọ ',3),(16,_binary '','<p>Cho thuê phòng trọ  vệ sinh kép kín\nNội thất : điều hoà , nóng lạnh , giường tủ….\nPhòng rộng 20-25m2\nLiên hệ :0335565416</p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng trọ cao cấp',3),(17,_binary '','<p>Phòng trọ cao cấp, chuẩn đẹp, có gác lững, bếp nấu ăn, an ninh, thoáng mát</p>','2023-09-16 03:00:00',_binary '\0','2023-09-16 03:00:00',_binary '\0','CHO SINH VIÊN THUÊ',3),(18,_binary '','<p>phòng đầy đủ nội thất, gần: đh Kiến Trúc, Bưu Chính Viễn Thông, Học Viện An Ninh, xung quanh gần chợ, tạp hóa ... thuận tiện đi lại\nHotline: 0919253274</p>','2023-09-17 03:00:00',_binary '\0','2023-09-17 03:00:00',_binary '\0','CẦN NAM Ở GHÉP PHÒNG SẠCH SẼ THOÁNG MÁT ĐẦY ĐỦ TIỆN NGHI',3),(19,_binary '','<p>Chính chủ cho thuê phòng khép kín .Cách chợ đầu mối 500m.Full nội thất.\nLiên hệ: 0988315215</p>','2023-09-18 03:00:00',_binary '\0','2023-09-18 03:00:00',_binary '\0','CHO SINH VIÊN THUÊ',4),(20,_binary '','<p>Phòng ở luôn. Ban công cửa sổ, tách bếp riêng. Không chung chủ, </p>','2023-09-15 03:00:00',_binary '\0','2023-09-15 03:00:00',_binary '\0','Phòng cho thuê mới xây cao cấp ',4),(21,_binary '','<p>Phòng setup lung linh - sạch sẽ - khách mới chuyển công tác nên nóng hổi vừa thổi vừa chốt ngay kẻo hết</p>','2023-09-20 03:00:00',_binary '\0','2023-09-20 03:00:00',_binary '\0','Phòng trọ cho nữ ',4),(22,_binary '','<p>Chính chủ cho thuê phòng ccmn khép kín mới.Full Nóng lạnh, điều hoà, tủ, giường, thang máy, wifi, máy giặt…hệ thống PCCC đảm bảo!</p>','2023-09-26 03:00:00',_binary '\0','2023-09-26 03:00:00',_binary '\0','PHÒNG CHO THUÊ - YÊN TĨNH - THOÁNG MÁT',4),(23,_binary '','<p>Nhà được thiết kế 5 tầng và toàn bộ các trang thiết bị đều được sắm mới.\n Tầng 1 được thiết kế để xe rộng rãi \nTầng 2,3,4,5 được thiết kế từ 4-6 người, có ban công để phơi đồ \nTrang thiết bị bao gồm có: Điều Hoà, Nóng Lạnh, Máy Giặt, Bếp Ăn, Quạt, Chăn Ga Gối Đệm</p>','2023-09-17 03:00:00',_binary '\0','2023-09-17 03:00:00',_binary '\0','Cho thuê nhà nguyên căn ',4),(24,_binary '','<p>Phòng có: Giường, Tủ, Đh, NL, Máy Giặt,bàn học, tủ lạnh\nNhà thang máy\n-Giờ giấc tự do, cửa vân tay\n-Gần chợ, bến xe bus, cửa hàng tiện dụng.</p>','2023-09-25 03:00:00',_binary '\0','2023-09-25 03:00:00',_binary '\0','PHÒNG CHO THUÊ - YÊN TĨNH - THOÁNG MÁT',4),(25,_binary '\0','<p>Cho thuê nhà CCMN mới 100%  . Nhà mới xây nội thất đầy đủ giường, tủ, gác xép, sofa, đệm, chăn, điều hòa, nóng lạnh vvv, cho ở 2-3 người</p>','2023-09-18 15:30:00',_binary '\0','2023-09-18 15:30:00',_binary '','Cho thuê phòng trọ ',2);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02 14:57:27
