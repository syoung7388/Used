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
  `p_address` varchar(50) NOT NULL,
  PRIMARY KEY (`p_num`,`u_username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.product:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`p_num`, `u_username`, `p_kind`, `p_industry`, `p_content`, `p_brand`, `p_year`, `p_startprice`, `p_date`, `p_endprice`, `p_title`, `p_sale`, `p_address`) VALUES
	(57, 'kk@kk', '제빙기', '호프/술집', '얼맥당 제빙기 팔아요', '대우', '1997', 1000000, '2021-04-12', NULL, '얼맥당 제빙기 팔아요', 'false', '광주 남구 2순환로 1508 (송하동, 톨게이트사무소송하동, 톨게이트사무소)'),
	(58, 'kk@kk', '커피머신', '치킨', '땅땅치킨', '대우', '2018', 121212, '2021-04-12', NULL, '땅땅치킨', 'false', '광주 남구 2순환로 1508 (송하동, 톨게이트사무소송하동, 톨게이트사무소)'),
	(59, 'kk@kk', '튀김기', '분식', '신전입니다', '대우', '2007', 100000, '2021-04-12', NULL, '신전떡볶이', 'false', '광주 남구 2순환로 1508 (송하동, 톨게이트사무소송하동, 톨게이트사무소)'),
	(60, 'kk@kk', '커피머신', '면요리', '2', '2', '1977', 1111, '2021-04-14', NULL, '2', 'false', '서울 강남구 남부순환로 2907 (대치동, 대치지구대)');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
