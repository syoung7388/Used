-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.9-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 used.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `p_num` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(50) NOT NULL DEFAULT '',
  `p_kind` varchar(50) NOT NULL,
  `p_industry` varchar(50) NOT NULL,
  `p_content` mediumtext NOT NULL DEFAULT '',
  `p_brand` varchar(50) NOT NULL,
  `p_year` varchar(50) NOT NULL,
  `p_startprice` int(50) DEFAULT NULL,
  `p_date` date NOT NULL DEFAULT current_timestamp(),
  `p_endprice` int(50) DEFAULT NULL,
  `p_title` varchar(50) NOT NULL,
  `p_sale` varchar(5) NOT NULL,
  `p_lonlat` point NOT NULL,
  `p_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`p_num`,`u_username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.product:~10 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`p_num`, `u_username`, `p_kind`, `p_industry`, `p_content`, `p_brand`, `p_year`, `p_startprice`, `p_date`, `p_endprice`, `p_title`, `p_sale`, `p_lonlat`, `p_address`) VALUES
	(71, 'kk@kk', '그릴기', '카페/베이커리', '2', '2', '1989', 2, '2021-04-16', NULL, '2', 'false', _binary 0x00000000010100000028DC58FC7BC05F40CC03A3DCBCD24240, NULL),
	(72, 'kk@kk', '커피머신', '분식', '3', '3', '1987', 3, '2021-04-16', NULL, '3', 'false', _binary '', NULL),
	(73, 'kk@kk', '그릴기', '배달전문점', '4', '4', '1997', 4, '2021-04-16', NULL, '4', 'false', _binary '', NULL),
	(77, 'kk@kk', '커피머신', '배달전문점', '2', '2', '1988', 2, '2021-04-17', NULL, '2', 'false', _binary '', NULL),
	(78, 'kk@kk', '벽선단', '치킨', 'ㅈ', '1', '1988', 1, '2021-04-17', NULL, 'ㅈ', 'false', _binary '', NULL),
	(79, 'kk@kk', '그릴기', '배달전문점', '5', '5', '1989', 5, '2021-04-17', NULL, '5', 'false', _binary '', NULL),
	(80, 'kk@kk', '커피머신', '치킨', '7', '7', '1987', 7, '2021-04-17', NULL, '7', 'false', _binary '', NULL),
	(81, 'kk@kk', '커피머신', '치킨', '7', '7', '1989', 7, '2021-04-17', NULL, '7', 'false', _binary '', NULL),
	(82, 'kk@kk', '커피머신', '배달전문점', '123', '123', '1987', 1213, '2021-04-17', NULL, '123', 'false', _binary '', NULL),
	(83, 'kk@kk', '그릴기', '배달전문점', '2', '2', '1988', 2, '2021-04-19', NULL, '2', 'false', _binary 0x000000000101000000AABA8FE403B85F400344C022CF8E4140, '광주 남구 2순환로 1508 (송하동, 톨게이트사무소)');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
