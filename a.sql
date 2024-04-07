-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pbl3
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Cart_user1_idx` (`user_id`),
  CONSTRAINT `fk_Cart_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (101,1),(102,2),(103,3),(104,7);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_detail`
--

DROP TABLE IF EXISTS `cart_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_detail` (
  `Cart_id` int NOT NULL,
  `product_id` int NOT NULL,
  `c_quantity` int NOT NULL,
  `totalmoney` double NOT NULL,
  `cart_detail_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cart_detail_id`),
  KEY `fk_cart_detail_Cart1_idx` (`Cart_id`),
  KEY `fk_cart_detail_product1_idx` (`product_id`),
  CONSTRAINT `fk_cart_detail_Cart1` FOREIGN KEY (`Cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `fk_cart_detail_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_detail`
--

LOCK TABLES `cart_detail` WRITE;
/*!40000 ALTER TABLE `cart_detail` DISABLE KEYS */;
INSERT INTO `cart_detail` VALUES (101,1,1,100,1),(103,1,10,1000,6),(102,3,9,1080,7),(104,2,6,1680,8),(104,7,3,810,9),(104,8,1,200,10),(104,5,1,250,11);
/*!40000 ALTER TABLE `cart_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(45) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'nike'),(2,'adidas'),(3,'puma'),(4,'lacoste');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderId` int NOT NULL,
  `date` date NOT NULL,
  `totalmoney` double NOT NULL,
  `desc` varchar(200) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_order_user1_idx` (`user_id`),
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2024-03-14',500,'	Order for user1',1),(2,'2024-03-15',600,'	Order for user2',2),(3,'2024-03-16',700,'	Order for user3',3);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `orderdetail_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `order_id` int NOT NULL,
  PRIMARY KEY (`orderdetail_id`),
  KEY `fk_order_detail_product1_idx` (`product_id`),
  KEY `fk_order_detail_order1_idx` (`order_id`),
  CONSTRAINT `fk_order_detail_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`orderId`),
  CONSTRAINT `fk_order_detail_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,1,2,100,1),(2,3,2,120,1);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay`
--

DROP TABLE IF EXISTS `pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay` (
  `idPay` int NOT NULL,
  `Cart_id` int NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`idPay`),
  KEY `fk_Pay_Cart1_idx` (`Cart_id`),
  CONSTRAINT `fk_Pay_Cart1` FOREIGN KEY (`Cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay`
--

LOCK TABLES `pay` WRITE;
/*!40000 ALTER TABLE `pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(150) NOT NULL,
  `pdesc` varchar(300) NOT NULL,
  `pimage` varchar(250) NOT NULL,
  `psize` int DEFAULT NULL,
  `pquantity` varchar(45) NOT NULL,
  `pprice` double NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`pid`),
  KEY `fk_product_category1_idx` (`category_id`),
  CONSTRAINT `fk_product_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Giày Nike Flex Experience 12','Giày Nike Flex Experience 12 mẫu giày thể thao mới ra mắt của Nike với thiết kế tối giản nhưng đẹp mắt và công năng sử dụng đa dạng. Bạn có thể dùng để đi bộ, chạy bộ, đi chơi đi làm đều rất tốt.','https://cdn.snkrdunk.com/uploads/media/20200510020035-1.jpeg?size=l',38,'10',250,1),(2,'Giày Nike Air Max SCB7','Giày Nike Air Max SC mang nét huyền thoại của Nike, với bộ đệm Air Max trứ danh đây là mẫu giày có thể kết hợp với bất cứ trang phục nào mà bạn vẫn hoàn toàn tự tin trong mọi hoàn cảnh.','https://cdn.snkrdunk.com/uploads/media/20200329095638-0.jpeg?size=l',39,'10',280,1),(3,'GIÀY NIKE JORDAN NU RETRO NAM','Giày Nike Jordan Nu Retro 1 Low là một trong những dòng giày sneaker nổi tiếng nhất của thương hiệu Jordan, một mẫu giày mà mỗi khi xuất hiện luôn tạo ra cơn sốt trên toàn cầu, một mẫu giày huyện thoại của biết bao nhiêu thế hệ.','https://myshoes.vn/image/cache/catalog/2023/nike/nk012/giay-jordan-nu-retro-1-low-nam-trang-vang-01-800x800.jpg',40,'10',310,1),(4,'Giày Nike x Off-White Air Force 1 ‘Black’ DO6290-001','Nike Air Force 1 bằng cách làm mới thiết kế cổ điển với phong cách tiên tiến đặc trưng của Abloh. Đôi giày này có phần trên lưới nhẹ màu đen, với hoa văn gỗ mô phỏng và dải cổ chân được làm bằng vải ripstop và logo Swoosh trong suốt làm từ TPU. ','https://myshoes.vn/image/cache/catalog/2023/nike/nike01/giay-nike-zoom-fly-5-nu-trang-den-01-800x800.jpg',41,'10',200,1),(5,'Giày Nike Air Force 1 Shadow ‘Black Red’ ','Phần upper với chất liệu thoáng khí và đàn hồi tốt, đế giữa êm ái cùng với đế ngoài cực kỳ bền chắc mang đến cho Nike Metcon 9 sự hoàn thiện và an toàn đối đa cho mọi động tác luyện tập dù là phức tạp nhất. ','https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/09783923-aed4-4179-b646-b218a37cbb47/air-max-97-womens-shoes-Fr6rM4.png',42,'10',250,1),(6,'GIÀY ADIDAS RUN 80S NAM - XÁM TRẮNG','Giày adidas Run 80S là mẫu giày sneaker có thiết kế cổ điển của thập niên 80 nhưng rất đẹp và không bao giờ lỗi mốt. adidas Run 80S có thể sử dụng trong mọi hoạt động hàng ngày.','https://bizweb.dktcdn.net/thumb/1024x1024/100/347/092/products/run-falcon-2-0-shoes-pink-fz1327-01.jpg',43,'10',210,2),(7,'GIÀY ADIDAS GALAXY 6 NAM - ĐEN','Giày adidas Galaxy 6  có thiết kế thể thao đẹp mắt, đây là mẫu giày có thể sử dụng trong mọi hoạt động hàng ngày. adidas Galaxy 6 có nhiều cải tiến so với adidas Galaxy 5 giúp đôi giày ngày càng hoàn hảo.','https://myshoes.vn/image/cache/catalog/2023/adidas/adi2/giay-adidas-galaxy-6-nam-den-01-800x800.jpg',44,'10',270,2),(8,'GIÀY ADIDAS ADIZERO RC 4 NAM - ĐEN XÁM','Giày adidas Adizero RC 4 là mẫu giày chạy bộ nhẹ, có thiết kế đẹp, thời trang. Đặc điểm cực kỳ nổi bật là hơn 50% sản phẩm được làm bằng vật liệu tái chế thân thiện và bảo vệ môi trường.','https://myshoes.vn/image/cache/catalog/2022/adidas/121/giay-adidas-adizero-rc-4-nam-den-xam-01-800x800.jpg',45,'10',200,2),(9,'GIÀY ADIDAS TRACEFINDER TRAIL NAM - XANH CAMO','Giày adidas Tracefinder Trail mẫu giày dã ngoại cao cấp của adidas, với công nghệ và vật liệu tốt nhất adidas Tracefinder giúp bạn chinh phục những quãng đường gồ ghề phức tạp nhất.','https://myshoes.vn/image/cache/catalog/2023/adidas/adi3/giay-adidas-tracefinder-trail-nam-xanh-camo-01-800x800.jpg',44,'10',210,2),(10,'GIÀY PUMA V6 LOW NAM - TRẮNG XANH','Giày Puma V6 Low là mẫu giày có thiết kế tuyệt đẹp cổ điển mà rất tinh tế. Chất liệu da cao cấp và đế cao su bền bỉ chắc chắn sẽ làm hài lòng những khách hàng khó tính nhất. Bạn sẽ luôn yên tâm rằng nó không bao giờ bị lỗi mốt.','https://myshoes.vn/image/cache/catalog/2024/puma/pm1/giay-puma-v6-low-nam-trang-xanh-01-800x800.jpg',44,'10',190,3),(11,'GIÀY PUMA PWRFRAME TR 2 NAM - NAVY ĐỎ','Giày Puma PWRFrame TR 2 mẫu giày training có thiết kế rất đẹp cùng với những công nghệ cao cấp của Puma. Đây chính là mẫu giày đa năng tuyệt vời cho luyện tập thể thao, tập gym và các hoạt động hàng ngày.','https://myshoes.vn/image/cache/catalog/2023/puma/pu01/giay-puma-pwrframe-tr-2-nam-navy-do-01-800x800.jpg',42,'10',200,3),(12,'GIÀY PUMA X RAY TRAINERS NAM - TRẮNG','Giày Puma X Ray Trainers là một trong mẫu giày thể thao có có thiết kế đơn giản mà rất tinh tế. Một mẫu giày mà bạn có thế sử dụng trong mọi hoạt động hàng ngày.','https://myshoes.vn/image/catalog/2022/puma/121/giay-puma-x-ray-trainers-nam-trang-01.jpg',41,'10',210,3),(13,'GIÀY LACOSTE PARTNER PISTE NAM - ĐEN','Giày Lacoste Partner Piste là mẫu giày Lacoste mới có thiết kế đươn giản mà đẳng cấp đặc trưng của thương hiệu đến từ Pháp. Được làm từ chất liệu da cao cấp Giày Lacoste Partner Piste là lựa chọn tuyệt vời cho các quý ông.','https://myshoes.vn/image/cache/catalog/2024/lacoste/lc01/40SMA0025_231_01-800x800.jpg',40,'10',190,4),(14,'GIÀY LACOSTE ANGULAR TEXTILE NAM - TRẮNG NÂU','Giày Lacoste Angular Textile có thiết kế đẳng cấp đặc trưng của Lacoste, với sự kết hợp hoàn hảo các chất liệu da thật,','https://myshoes.vn/image/catalog/2023/lacoste/086/giay-lacoste-angular-textile-nam-trang-nau-01.jpg',44,'10',300,4),(15,'GIÀY LACOSTE RUN SPIN COMFORT 222 NAM - TRẮNG','Giày Lacoste Run Spin Comfort 222 là mẫu giày thể thao đa dụng của Lacoste, với thiết kế thời trang và rất nhiều công nghệ tiên tiến từ hãng thời trang cao cấp của Pháp giúp cho đôi giày êm ái đồng thời có sự cân bằng tốt.','https://myshoes.vn/image/cache/catalog/2023/lacoste/086/giay-Lacoste-Run-Spin-Comfort-222-nam-trang-01-800x800.jpg',44,'10',280,4),(16,'GIÀY NIKE AIR ZOOM STRUCTURE 25 NAM - TRẮNG XANH','Giày Nike Air Zoom Structure 25 là mẫu giày thể thao mới nhất của Nike trong năm nay với thiết kế cực đẹp','https://myshoes.vn/image/cache/catalog/2024/nike/nk01/giay-nike-air-zoom-structure-25-nam-trang-xanh-01-800x800.jpg',42,'10',300,1),(17,'GIÀY NIKE AIR ZOOM PEGASUS 40 PREMIUM NAM - XANH LAM','Giày Nike Air Zoom Pegasus 40 Premium là siêu phẩm giày thể thao được mong chờ nhất hiện nay.','https://myshoes.vn/image/cache/catalog/2024/nike/nk01/giay-nike-air-zoom-pegasus-40-premium-nam-xanh-lam-01-800x800.jpg',41,'10',310,1),(18,'GIÀY NIKE MC TRAINER 2 NAM - TRẮNG ĐỎ','Giày Nike MC Trainer 2 một mẫu giày luyện tập tuyệt với dành cho tất cả mọi người','https://myshoes.vn/image/cache/catalog/2024/nike/nk01/giay-nike-mc-trainer-2-nam-trang-do-01-800x800.jpg',42,'10',330,1),(19,'GIÀY NIKE AIR MAX EXCEE NAM - XÁM VÀNG','Giày Nike Air Max Excee mẫu giày thời trang năng động, trẻ trung Air Max Excee đã cập bến','https://myshoes.vn/image/catalog/2023/nike/nike01/giay-nike-air-max-excee-nam-xam-vang-01.jpg',44,'10',350,1),(20,'GIÀY ADIDAS RUN 80S NAM - XÁM ĐỎ','Giày adidas Run 80S là mẫu giày sneaker có thiết kế cổ điển của thập niên 80 nhưng rất đẹp và không bao giờ lỗi mốt. ','https://myshoes.vn/image/cache/catalog/2024/adidas/ad2/giay-adidas-run-80-nam-xam-do-01-800x800.jpg',42,'10',320,2),(21,'GIÀY ADIDAS ULTRABOOST LIGHT NAM - ĐEN TRẮNG','Giày adidas Ultraboost Light siêu phẩm giày thể thao mới nhất đến từ nhà adidas, với vật liệu và công nghệ tốt nhất được áp dụng tối đa cho sản này adidas Ultraboost Lighthttps://myshoes.vn/image/cache/catalog/2023/adidas/adi3/giay-adidas-ultraboost-light-nam-den-trang-01-800x800.jpg','https://myshoes.vn/image/cache/catalog/2023/adidas/adi3/giay-adidas-ultraboost-light-nam-den-trang-01-800x800.jpg',42,'10',330,2),(22,'GIÀY ADIDAS ULTRABOOST LIGHT NỮ - HỒNG','Giày adidas Ultraboost Light siêu phẩm giày thể thao mới nhất đến từ nhà adidas, với vật liệu và công nghệ tốt','https://myshoes.vn/image/cache/catalog/2023/adidas/adi3/giay-adidas-ultraboost-light-nu-hong-01-800x800.jpg',43,'10',290,2),(23,'GIÀY PUMA SLIPSTREAM ARCHIVE REMASTERED NAM - TRẮNG XANH','Giày Puma Slipstream Archive Remastered mẫu giày sneaker rất nổi tiếng của Puma, thiết kế cổ điển ','https://myshoes.vn/image/catalog/2023/puma/pu01/giay-puma-slipstream-archive-remastered-nam-trang-xanh-la-04.jpg',41,'10',350,3),(24,'GIÀY PUMA CAVEN MERCEDES NAM - ĐEN XANH','Giày Puma Caven mẫu giày cổ điển được phát triển từ những năm 1980 của Puma.','https://myshoes.vn/image/catalog/2023/puma/giay-puma-caven-mercedes-nam-den-xanh-01.jpg',40,'10',380,3),(25,'GIÀY LACOSTE L001 223 NAM - TRẮNG XANH LÁ','Giày Lacoste L001 223 là một trong những mẫu giày HOT nhất của Lacoste hiện nay. Lacoste L001 223 có thiết kế cổ điển truyền thống của Lacoste ','https://myshoes.vn/image/cache/catalog/2023/lacoste/ls01/giay-lacoste-l001-223-trang-xanh-la-01-800x800.jpg',42,'10',350,4),(26,'GIÀY LACOSTE L001 223 NAM - TRẮNG XANH','Giày Lacoste L001 223 là một trong những mẫu giày HOT nhất của Lacoste hiện nay','https://myshoes.vn/image/cache/catalog/2023/lacoste/ls01/giay-lacoste-l001-223-trang-xanh-01-800x800.jpg',44,'10',380,4),(27,'GIÀY LACOSTE STORM 96 LO NAM - NÂU','Giày Lacoste Storm 96 LO có thiết kế cổ điển lấy cảm hứng từ thập niên 90 với tính thẩm mỹ táo bạo','https://myshoes.vn/image/cache/catalog/2023/lacoste/146/giay-lacoste-storm-96-lo-nam-nau-01-800x800.jpg',42,'10',400,4),(28,'GIÀY NIKE AIR MAX EXCEE NỮ - TRẮNG XANH','Giày Nike Air Max Excee mẫu giày thời trang năng động, trẻ trung Air Max Excee','https://myshoes.vn/image/catalog/2024/nike/nk01/giay-nike-air-max-excee-nu-trang-xanh-01.jpg',42,'10',390,1),(29,'GIÀY NIKE AIR JORDAN 1 LOW NAM - XANH ĐEN','Giày Nike Air Jordan 1 Low là một trong những dòng giày sneaker nổi tiếng nhất của thương hiệu Jordan','https://myshoes.vn/image/catalog/2023/nike/nike02/giay-air-jordan-1-low-nam-xanh-den-01.jpg',42,'10',290,1),(30,'GIÀY LACOSTE CHAYMON 721 NAM - ĐEN ĐEN','Giày Lacoste Chaymon 721 được thiết kế với phong cách cổ điển sang trọng đặc trưng của thương hiệu Lacoste.','https://myshoes.vn/image/catalog/2022/lacoste/25.6/giay-lacoste-chaymon-721-nam-den-den-01.jpg',41,'10',310,4),(31,'GIÀY LACOSTE COURT-DRIVE TRAINERS NAM - TRẮNG','Giày Lacoste Court-Drive Trainers là mẫu giày thể thao thời trang đa dụng của Lacoste. ','https://myshoes.vn/image/cache/catalog/lacoste/23.12/Giay-Lacoste-Court-Drive-Trainers-01-800x800.jpg',42,'10',330,4),(32,'GIÀY PUMA CAVEN NAM - TRẮNG ĐỎ','Giày Puma Caven mẫu giày cổ điển được phát triển từ những năm 1980 của Puma. Chất liệu da cao cấp và đế cao su bền ','https://myshoes.vn/image/catalog/2022/puma/2.3.1/giay-puma-caven-nam-trang-do-01.jpg',41,'10',320,3),(33,'GIÀY LACOSTE PARTNER PISTE NAM - ĐEN','Giày Lacoste Partner Piste là mẫu giày Lacoste mới có thiết kế đươn giản mà đẳng cấp đặc trưng của thương hiệu đến từ Pháp.','https://myshoes.vn/image/catalog/2024/lacoste/lc01/40SMA0025_231_01.jpg',42,'10',330,4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(200) NOT NULL,
  `uPhone` varchar(45) NOT NULL,
  `role` int NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'anhkhoa','123','ewqewq','321312',0),(2,'congbao','456','Thua thien hue','987654321',0),(3,'vietnhan','789','Thua thien hue','555555555',0),(4,'duchoang','666','da nang','888',1),(7,'a','b','eqwewq','145165',0),(8,'haha','123456','','02445959',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-07 10:38:55
