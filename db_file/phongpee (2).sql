-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 25, 2023 at 07:47 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phongpee`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetOrdersByShopId` (IN `shopId` INT)   BEGIN
    SELECT orders.order_id, user_id, note, `date`, due_time, products.shop_id, status
    FROM orders
    JOIN orders_detail ON orders.order_id = orders_detail.orders_id
    JOIN products ON orders_detail.product_id = products.product_id
    WHERE products.shop_id = shopId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetProductDetails` (IN `order_id_param` INT)   BEGIN
    SELECT
        products.product_id,
        products.name,
        products.decription,
        products.shop_id,
        orders_detail.quantity,
        products.price,
        products.type,
        products.image
    FROM
        products
    JOIN
        orders_detail ON products.product_id = orders_detail.product_id
    JOIN
        orders ON orders_detail.orders_id = orders.order_id
    WHERE
        orders.order_id = order_id_param;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int NOT NULL,
  `user_id` int NOT NULL,
  `note` varchar(200) NOT NULL,
  `date` datetime NOT NULL,
  `due_time` int NOT NULL,
  `status` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `user_id`, `note`, `date`, `due_time`, `status`) VALUES
(1, 1, '', '2023-12-23 00:00:00', 30, 1),
(2, 1, '', '2023-12-23 00:00:00', 30, 0),
(3, 2, '', '2023-12-23 00:00:00', 30, 1),
(4, 2, '', '2023-12-23 00:00:00', 30, 1),
(5, 1, '44 Nguyễn Huệ', '2023-12-23 00:00:00', 30, 1),
(6, 1, '', '2023-12-23 00:00:00', 30, 1),
(7, 1, '', '2023-12-23 00:00:00', 30, 0),
(8, 1, '', '2023-12-23 00:00:00', 30, 0),
(9, 1, '44 Nguyễn Huệ', '2023-12-23 00:00:00', 30, 0),
(10, 1, '', '2023-12-23 00:00:00', 30, 0),
(11, 1, '', '2023-12-23 00:00:00', 30, 0),
(12, 1, '44 Nguyễn Huệ', '2023-12-24 00:00:00', 30, 0),
(13, 1, '4/24 KTT Xã Tắc', '2023-12-24 00:00:00', 30, 0),
(14, 1, '55 Nguyễn Huệ', '2023-12-25 00:00:00', 30, 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders_detail`
--

CREATE TABLE `orders_detail` (
  `orders_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders_detail`
--

INSERT INTO `orders_detail` (`orders_id`, `product_id`, `quantity`) VALUES
(3, 2, 1),
(4, 2, 1),
(4, 1, 2),
(5, 2, 8),
(6, 2, 2),
(7, 2, 1),
(8, 2, 2),
(9, 2, 1),
(10, 2, 1),
(11, 2, 1),
(12, 2, 2),
(13, 2, 3),
(14, 37, 3);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `decription` varchar(100) NOT NULL,
  `shop_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` double NOT NULL,
  `type` int NOT NULL,
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `name`, `decription`, `shop_id`, `quantity`, `price`, `type`, `image`) VALUES
(1, 'Bánh mì nướng bơ tỏi', 'Cái gì cũng có cái giá của nó, tiền đi đôi với chất lượng', 4, 500, 30000, 1, 'pizza-kat_banh-my-nuong-bo-toi.jpeg'),
(2, 'Bắp chiên bơ', 'Cái gì cũng có cái giá của nó, tiền đi đôi với chất lượng', 1, 500, 30000, 1, 'alphago_bap-chien-bo.jpeg'),
(3, 'Đùi gà 1 cái', 'Gà max ngon', 1, 50, 35000, 0, 'alphago_ga-ran-1-dui.jpeg'),
(4, 'Gà rán 2 miếng', '2 miếng gà tươi giòn', 1, 5, 20000, 0, 'alphago_ga-ran-2-mieng.jpeg'),
(5, 'Gà sốt cay phô mai', 'sốt dẻo cực ngon', 1, 12, 25000, 0, 'alphago_ga-sot-cay-pho-mai.jpeg'),
(6, 'Gà sốt phô mai', 'Phô mai kéo sợi không ngon không lấy tiền', 1, 3, 10000, 0, 'alphago_ga-sot-pho-mai.jpeg'),
(7, 'Gà sốt tok', 'sốt tok cực dẻo cực dai cực ngon', 1, 30, 40000, 0, 'alphago_ga-sot-tok.jpeg'),
(8, 'Kimbap chiên', 'Kimbap ngon cực', 1, 50, 30000, 0, 'alphago_kimbap-chien.jpeg'),
(9, 'Mì xào gà', 'Mì ngon cùng với gà hòa quyện vào đầu lưỡi', 1, 30, 43000, 0, 'alphago_mi-xao-ga.jpg'),
(10, 'Mì xào xúc xích', 'Ngon chả kém mì xào gà', 1, 5, 30000, 0, 'alphago_mi-xao-xuc-xich.jpg'),
(11, 'Nem chua rán', 'Độc quyền công thức độc quyền mùi vị, độc quyền cả tái tim của bạn', 1, 30, 43000, 0, 'alphago_nem-chua-ran.jpeg'),
(12, 'Pepsi', 'Là pepsi nhưng không phải pepsi', 1, 50, 10000, 1, 'alphago_pepsi.jpeg'),
(13, 'Bánh bèo khay', 'Bánh cực ngon', 6, 5, 30000, 0, 'banh-chi_banh-beo-khay.jpg'),
(14, 'Bánh ram ít', 'Bánh ram ít nhưng cũng không nhiều', 6, 50, 30000, 0, 'banh-chi_banh-it-ram.jpg'),
(15, 'Bánh lọc', 'Bánh lọc đặc sản không nơi nào có', 6, 1000, 40000, 0, 'banh-chi_banh-loc.jpg'),
(16, 'Bánh nậm', 'Nếu dở thì qua chỗ khác mua', 6, 40, 40000, 0, 'banh-chi_banh-nam.jpg'),
(17, 'Bánh bao chiên', 'Lúc trước tôi ăn bánh bao luộc thấy chán quá thử chiên ai ngờ ngon hết sẩy', 8, 30, 15000, 0, 'banh-ran-chi-hue_banh-bao-chien.jpg'),
(18, 'Bánh batiso', 'Cái này ngon lắm á', 8, 50, 10000, 0, 'banh-ran-chi-hue_banh-batiso.jpg'),
(19, 'Bánh tiêu', 'ăn cho đỡ tiêu', 8, 50, 5000, 0, 'banh-ran-chi-hue_banh-tieu.jpg'),
(20, 'Chè thái bà Liên', 'Mua chè là phải tới chỗ tôi, vừa ngon vừa vẻ', 10, 50, 20000, 1, 'che-thai-ba-lien-da-nang-my-linh_che-thai.jpg'),
(21, 'Cơm gà', 'Cơm với gà', 15, 30, 30000, 0, 'com-ga-xoi-mo_comga.jpeg'),
(22, 'Cơm sườn', 'Cơm với sườn', 15, 50, 30000, 0, 'com-ga-xoi-mo_com-suon.jpg'),
(27, 'Cơm xúc xích bò', 'Cơm với xúc xích bò. Ngon lắm đặt đi', 15, 5, 30000, 0, 'com-ga-xoi-mo_xuc-xich-bo.jpeg'),
(28, 'Bún đậu cơ bản A', 'Một người ăn là quá no, nên ăn 2 người', 9, 50, 40000, 0, 'cuon-bun-dau-mam-tom_bun-dau-co-ban-A.jpeg'),
(29, 'Bún đậu cơ bản B', 'Ăn thôi chưa đủ, phải trải nghiệm, trải nghiệm mới thấy được vị ngon', 9, 50, 30000, 0, 'cuon-bun-dau-mam-tom_bun-dau-co-ban-B.jpeg'),
(30, 'Cơm rang bò cay', 'Ngon', 24, 30, 30000, 0, 'doo-tokbokki_com-rang-bo-cay.jpeg'),
(31, 'Lẩu miến ba chỉ', 'Miến dai, dòn, ngon', 24, 50, 30000, 0, 'doo-tokbokki_lau-mien-ba-chi.jpeg'),
(32, 'tokbokki', 'Đặc sản của quán', 24, 30, 25000, 0, 'doo-tokbokki_tokbokki.jpeg'),
(33, 'Combo gà quay', 'Combo gà quay', 16, 50, 30000, 0, 'ga-ran-kfc_combo-ga-quay.jpeg'),
(34, 'Combo hân hoan', 'Hân hoan cùng gia đình', 16, 30, 30000, 0, 'ga-ran-kfc_combo-han-hoan.jpeg'),
(35, 'Combo tưng bừng', 'Combo tưng bừng', 16, 50, 30000, 0, 'ga-ran-kfc_combo-tung-bung.jpeg'),
(36, 'Combo vui vẻ', 'Combo vui vẻ', 16, 50, 30000, 0, 'ga-ran-kfc_combo-vui-ve.jpeg'),
(37, 'Bạc xỉu', 'Cái gì cũng có cái giá của nó, tiền đi đôi với chất lượng', 2, 50, 30000, 1, 'highlands_bac-xiu.jpeg'),
(38, 'Combo trà chiều', 'Rất ngon, hợp khẩu vị của bạn', 2, 50, 30000, 1, 'highlands_combo-tra-chieu.jpg'),
(39, 'Phin đen đá', 'Nhâm nhi buổi chiều còn gì tuyệt vời hơn', 2, 40, 29000, 1, 'highlands_phin-den-da.jpeg'),
(40, 'Phin sữa đá', 'Ngọt như hương vị của tình yêu', 2, 50, 32000, 1, 'highlands_phin-sua-da.jpeg'),
(41, 'Trà sen vàng', 'Trà sen chứ có phải trà xanh đâu mà không ngon được', 2, 50, 40000, 1, 'highlands_tra-sen-vang.jpeg'),
(42, 'Trà thạch đào', 'Trà + thạch đào = Trà thạch đào', 2, 50, 30000, 1, 'highlands_tra-thach-dao.jpeg'),
(43, 'Trà xanh đậu đỏ', 'Trà xanh, đậu đỏ ', 2, 40, 30000, 1, 'highlands_tra-xanh-dau-do.jpeg'),
(44, 'Hồng trà sữa', 'Ngon, ngọt, đủ vị', 17, 30, 30000, 1, 'hotto_hong-tra-sua.jpeg'),
(45, 'Ô long sữa trân châu', 'Hot drink của quán tui, thường xuyên có deal giảm giá', 17, 50, 30000, 1, 'hotto_o-long-sua-tran-chau.jpeg'),
(46, 'Takoyaki', 'Cái này hay giảm giá ăn cũng vui miệng lắm các đồng hữu à', 17, 1000, 20000, 0, 'hotto_takoyaki.jpeg'),
(47, 'Yakult dưa lưới', 'Yakult ngọt, dưa lưới thơm, cực phẩm đồ uống', 17, 40, 20000, 1, 'hotto_Yakult-dua-luoi.jpeg'),
(48, 'Yakult sữa dâu', 'Ngon ngọt như cách chàng trai thổi chữ tình vào trong tai bạn', 17, 50, 30000, 1, 'hotto_yakult-sua-dau.jpeg'),
(49, 'Yakult thanh đào', 'Yakult thanh đào', 17, 50, 27000, 1, 'hotto_yakult-thanh-dao.jpeg'),
(50, 'Bánh mì bơ tỏi', 'Bánh mì bơ tỏi', 18, 30, 30000, 0, 'lo-banh-phan-chu-trinh_banh-mi-bo-toi.jpeg'),
(51, 'Cua phô mai', 'Cua phô mai', 18, 40, 30000, 12000, 'lo-banh-phan-chu-trinh_cua-pho-mai.jpeg'),
(52, 'Paparoti', 'Paparoti', 18, 50, 15000, 0, 'lo-banh-phan-chu-trinh_paparoti.jpeg'),
(53, 'Xúc xích phô mai', 'Xúc xích + phô mai = xúc xích phô mai', 18, 50, 20000, 0, 'lo-banh-phan-chu-trinh_xuc-xich-pho-mai.jpeg'),
(54, 'Chân gà rút xương', 'Ăn vặt rất ngon', 19, 100, 65000, 0, 'ngoc-che-buoi_chan-ga-rut-xuong.jpeg'),
(55, 'Chè bưởi', 'Tên món như tên quán, hiểu rồi đấy!', 19, 50, 20000, 1, 'ngoc-che-buoi_che-buoi.jpeg'),
(56, 'Khô gà lá chanh', 'Khô gà lá chanh', 19, 50, 30000, 0, 'ngoc-che-buoi_kho-ga-la-chanh.jpeg'),
(57, 'Sầu riêng dầm', 'Sầu riêng dầm', 19, 40, 20000, 1, 'ngoc-che-buoi_sau-rieng-dam.jpg'),
(58, 'Bánh mỳ nướng bơ tỏi', 'Bánh mỳ nướng bơ tỏi', 4, 50, 30000, 0, 'pizza-kat_banh-my-nuong-bo-toi.jpeg'),
(59, 'Đùi gà rán giòn', 'Giòn dai ngon', 4, 40, 250000, 0, 'pizza-kat_dui-ga-ran-gion.jpeg'),
(60, 'Khoai tây chiên', 'Ít dầu mỡ', 4, 50, 15000, 0, 'pizza-kat_khoai-tay-chien.jpeg'),
(61, 'Cơm gà dương châu', 'Cơm gà dương châu', 20, 50, 30000, 0, 'quan-bui-a-son-com-ga_duong-chau.jpg'),
(62, 'Cơm gà xối mỡ', 'Cơm gà xối mỡ', 20, 30, 30000, 0, 'quan-bui-a-son-com-ga_ga-xoi-mo.jpg'),
(63, 'Bún hến', 'Đặc sản khi tới Huế', 21, 40, 10000, 0, 'quan-hoa-dong_bun-hen.jpg'),
(64, 'Cơm hến khô', 'Cơm hến khô', 21, 50, 15000, 0, 'quan-hoa-dong_com-hen-kho.jpg'),
(65, ' Mì hến', ' Mì hến', 21, 50, 10000, 0, 'quan-hoa-dong_mi-hen.jpg'),
(66, 'Sữa chua thạch cà phê', 'Sữa chua thạch cà phê', 22, 30, 15000, 1, 'sua-chua-tran-chau-co-ly_sua-chua-thach-cf.jpeg'),
(67, 'Sữa chua uống', 'Sữa chua uống', 22, 50, 20000, 1, 'sua-chua-tran-chau-co-ly_sua-chua-uong.jpeg'),
(68, 'Sữa chua việt quất', 'Sữa chua việt quất', 22, 100, 15000, 1, 'sua-chua-tran-chau-co-ly_sua-chua-viet-quat.jpeg'),
(69, 'Sữa chua xoài', 'Sữa chua xoài', 22, 40, 15000, 1, 'sua-chua-tran-chau-co-ly_sua-chua-xoai.jpeg'),
(70, 'Bánh tráng trứng combo', '1 Bánh tráng 1 pepsi', 23, 50, 40000, 0, 'suong-sa-dua_banh-trang-trung-combo.jpeg'),
(71, 'Trà mãng cầu', 'Trà mãng cầu', 23, 50, 15000, 1, 'suong-sa-dua_tra-mang-cau.jpeg'),
(72, 'Trìa sốt thái', 'Trìa sốt thái', 23, 50, 30000, 0, 'suong-sa-dua_tria-sot-thai.jpg'),
(73, 'Bánh lọc chiên', 'Bánh lọc chiên', 5, 50, 15000, 0, 'xoainonbenhu_banh-loc-chien.jpg'),
(74, 'Bánh tráng bò', 'Bánh tráng bò', 5, 50, 30000, 0, 'xoainonbenhu_banh-trang-bo.jpg'),
(75, 'Gà ủ muối nửa con', 'Nửa con gà ủ muối', 5, 50, 60000, 0, 'xoainonbenhu_ga-u-muoi-nua-con.jpeg'),
(76, 'Phô mai que 3 cây', 'Phô mai que 3 cây', 5, 50000, 10000, 0, 'xoainonbenhu_pho-mai-que-3-cay.jpeg'),
(77, 'Trứng gà nướng 5 quả', 'Trứng gà nướng 5 quả', 5, 50, 30000, 0, 'xoainonbenhu_trung-ga-nuong-5-qua.jpeg'),
(78, 'Xoài non chấm ruốc', 'Xoài non chấm ruốc', 5, 1000, 30000, 0, 'xoainonbenhu_xoai-non-cham-ruoc.jpg'),
(79, 'Xoài non mix bò khô', 'Xoài non mix bò khô', 5, 50, 30000, 0, 'xoainonbenhu_xoai-non-mix-bo-kho.jpeg'),
(84, 'Gà nướng nguyên con', 'Gà nướng', 1, 50, 123000, 0, 'default.png');

-- --------------------------------------------------------

--
-- Table structure for table `shops`
--

CREATE TABLE `shops` (
  `shop_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(100) NOT NULL DEFAULT 'default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `shops`
--

INSERT INTO `shops` (`shop_id`, `name`, `address`, `image`) VALUES
(1, 'Alphago', '138 Nguyễn Huệ, Hue, Vietnam', 'alphago.jpg'),
(2, 'Highlands Coffee - Thạch Hãn', '59 Thạch Hãn, P. Thuận Hoà , Tp. Huế', 'highlands.jpeg'),
(4, 'Pizza Kat', '43 Kiệt 42 Nguyễn Công Trứ', 'pizza-kat.jpg'),
(5, 'Trùm Xoài Non BÉ NHƯ', '60 Đặng Thái Thân', 'xoainonbenhu.jpg'),
(6, 'Bánh Chi - Bánh Bèo & Nậm & Lọc - Hoàng Diệu', 'Kiệt 64 nhà số 2 Hoàng Diệu, P. Tây Lộc, Tp. Huế, Huế', 'banh-chi-banh-beo-nam-loc-hoang-dieu.jpg'),
(7, 'Bún Riêu Hạt Tiêu', '5 Hồ Tùng Mậu, P. Xuân Phú, Tp. Huế, Huế', 'bun-rieu-hat-tieu.jpg'),
(8, 'Bánh Rán Chị Huệ', '6/87 Nguyễn Huệ, P. Phú Nhuận', 'banh-ran-chi-hue.jpg'),
(9, 'Cuốn - Bún Đậu Mắm Tôm', '247 Nguyễn Trãi, P. Tây Lộc, Tp. Huế, Huế', 'cuon-bun-dau-mam-tom.jpg'),
(10, 'Mỹ Linh - Chè Thái Bà Liên Đà Nẵng - Bà Triệu', '16 Bà Triệu, P. Phú Hội, Tp. Huế, Huế', 'che-thai-ba-lien-da-nang-my-linh.jpg'),
(15, 'Cơm Gà Xối Mỡ - Nguyễn Huệ', '71 Nguyễn Huệ, P. Vĩnh Ninh, Tp. Huế, Huế', 'com-ga-xoi-mo-nguyen-hue.jpg'),
(16, 'Gà Rán KFC - Big C Huế', 'Tầng 4, Tầng 4, Big C, 181 Bà Triệu, P. Phú Hội', 'ga-ran-kfc-big-c-hue.jpg'),
(17, 'Takoyaki Hotto - Hai Bà Trưng', '34 Hai Bà Trưng, P. Vĩnh Ninh, Tp. Huế, Huế', 'hotto.jpeg'),
(18, 'Lò Bánh - Phan Chu Trinh', '118 Phan Chu Trinh, P. Phước Vĩnh, Tp. Huế, Huế', 'lo-banh-phan-chu-trinh.jpg'),
(19, 'Ngọc Chè Bưởi - Nguyễn Huệ', '7A Nguyễn Huệ, P. Vĩnh Ninh, Tp. Huế, Huế', 'ngoc-che-buoi-nguyen-hue.jpg'),
(20, 'Cơm Gà Bùi A Sơn - Đặng Thái Thân', '100 - 102 Đặng Thái Thân, P. Thuận Thành, Tp. Huế, Huế', 'quan-bui-a-son-com-ga.jpg'),
(21, 'Cơm Hến Hoa Đông', '64 Kiệt 7 Ưng Bình, P. Vỹ Dạ, Tp. Huế, Huế', 'quan-hoa-dong.jpg'),
(22, 'Sữa Chua Trân Châu Cô Ly', '23 Tam Thai, P. Trường An, Tp. Huế, Huế', 'sua-chua-tran-chau-co-ly.jpg'),
(23, 'Sương Sa Dừa - Lâm Hoằng', '57 Lâm Hoằng (21/2 Kiệt 37 Hàn Mặc Tử cũ), P. Vỹ Dạ, Tp. Huế, Huế', 'suong-sa-dua.jpg'),
(24, 'Doo Tokbokki - Ngô Gia Tự', '4 Kiệt 21 Ngô Gia Tự, P. Vĩnh Ninh, Tp. Huế, Huế', 'doo-tokbokki.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `authentication` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `phone`, `password`, `authentication`) VALUES
(1, 'Phong', 'jackphong@5141gmail.com', '0123456789', '202cb962ac59075b964b07152d234b70', 0),
(2, 'Ngô Tiến Phong', 'ntphong5142@gmail.com', '0945575956', '202cb962ac59075b964b07152d234b70', 0),
(3, 'Quán Alphago', 'alphago@gmail.com', '1234567890', '202cb962ac59075b964b07152d234b70', 1),
(4, 'Highlands Coffee - Thạch Hãn', 'highlands@gmail.com', '1111111111', '202cb962ac59075b964b07152d234b70', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `orders_detail`
--
ALTER TABLE `orders_detail`
  ADD KEY `product_id` (`product_id`),
  ADD KEY `orders_id` (`orders_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `shop_id` (`shop_id`);

--
-- Indexes for table `shops`
--
ALTER TABLE `shops`
  ADD PRIMARY KEY (`shop_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`,`phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `shops`
--
ALTER TABLE `shops`
  MODIFY `shop_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `orders_detail`
--
ALTER TABLE `orders_detail`
  ADD CONSTRAINT `orders_detail_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `orders_detail_ibfk_2` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`order_id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`shop_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
