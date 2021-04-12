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

-- 테이블 used.auction 구조 내보내기
CREATE TABLE IF NOT EXISTS `auction` (
  `u_num` int(11) NOT NULL,
  `p_num` int(11) NOT NULL,
  `a_price` varchar(50) DEFAULT NULL,
  `a_time` datetime NOT NULL,
  PRIMARY KEY (`p_num`,`u_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.auction:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;

-- 테이블 used.auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `auth` (
  `u_username` varchar(50) NOT NULL,
  `u_auth` varchar(50) NOT NULL,
  PRIMARY KEY (`u_username`,`u_auth`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.auth:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` (`u_username`, `u_auth`) VALUES
	('1@1', 'ROLE_USER'),
	('22@22', 'ROLE_USER'),
	('5@5', 'ROLE_USER'),
	('7@7', 'ROLE_USER'),
	('a@a', 'ROLE_USER'),
	('kk@kk', 'ROLE_USER'),
	('y@y', 'ROLE_USER');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;

-- 테이블 used.like 구조 내보내기
CREATE TABLE IF NOT EXISTS `like` (
  `p_num` int(11) NOT NULL,
  `u_num` int(11) NOT NULL,
  PRIMARY KEY (`p_num`,`u_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.like:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
/*!40000 ALTER TABLE `like` ENABLE KEYS */;

-- 테이블 used.picture 구조 내보내기
CREATE TABLE IF NOT EXISTS `picture` (
  `p_num` int(11) NOT NULL,
  `pi_num` int(11) NOT NULL AUTO_INCREMENT,
  `p_picture` longtext CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`pi_num`,`p_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.picture:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` (`p_num`, `pi_num`, `p_picture`) VALUES
	(53, 33, '@/assets/중기 5.jpg'),
	(54, 34, '@/assets/온유오빠.jpg'),
	(55, 35, '@/assets/송강오빠.jpg'),
	(56, 36, '@/assets/캡처.PNG');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;

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
  PRIMARY KEY (`p_num`,`u_username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.product:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`p_num`, `u_username`, `p_kind`, `p_industry`, `p_content`, `p_brand`, `p_year`, `p_startprice`, `p_date`, `p_endprice`, `p_title`, `p_sale`) VALUES
	(53, 'kk@kk', '커피머신', '족발/ 보쌈', '1', '1', '1975', 1, '2020-04-21', NULL, '1', 'false'),
	(54, 'kk@kk', '그릴기', '치킨', '안녕하세요 그릴기 판매합니다', '엘지', '1976', 10000, '2020-04-21', NULL, '안녕하세요 가마꿉입니다', 'false'),
	(55, 'kk@kk', '냉장고/쇼케이스', '족발/ 보쌈', '나무도마 족발 냉장고 판매합니다', '대우', '1988', 1200000, '2021-04-12', NULL, '나무도마', 'false'),
	(56, 'kk@kk', '튀김기', '분식', '신전 튀김기 팔아요', '엘지', '2018', 12345, '2021-04-12', NULL, '신전떡볶이입니다', 'false');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 테이블 used.spring_session 구조 내보내기
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 used.spring_session:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;

-- 테이블 used.spring_session_attributes 구조 내보내기
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 테이블 데이터 used.spring_session_attributes:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;

-- 테이블 used.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `u_num` int(11) NOT NULL AUTO_INCREMENT,
  `u_password` varchar(500) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_phone` varchar(50) NOT NULL,
  `u_isAccountNonLocked` tinyint(4) DEFAULT NULL,
  `u_isAccountNonExpired` tinyint(4) DEFAULT NULL,
  `u_isCredentialsNonExpired` tinyint(4) DEFAULT NULL,
  `u_isEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`u_num`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.user:~13 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`u_num`, `u_password`, `u_name`, `u_username`, `u_address`, `u_phone`, `u_isAccountNonLocked`, `u_isAccountNonExpired`, `u_isCredentialsNonExpired`, `u_isEnabled`) VALUES
	(10, '$2a$10$r6q5gnGARo6ocgu3Cs02KuzQRlG7KiWhSPbG/icWWi/wre0jAuHSG', '3', '33@33', '대구 북구 3공단로 5 (노원동3가)', '3', 1, 1, 1, 1),
	(14, '$2a$10$/V4ipj5XM3aJPgvFmiB7quMcSZrUsyNAGwk6tOu/r5XCQZeissFyO', 'yt', 'y@y', '서울 강북구 덕릉로10길 23 (수유동, H.Y하우스)', 'y@y', 1, 1, 1, 1),
	(31, '$2a$10$NKtEw8DcbnlWxv3qXbL3tewYF6xLehkklG.HE/qrrUmVbH0eI1Ozu', '10', '10@10', '경기 화성시 10용사로 49 (병점동)', '10', 1, 1, 1, 1),
	(32, '$2a$10$eEmKevWXhD.wZAZurlHYxOjATEeRdBO0e3eNngj6GVvzNjB//F7hy', '15', '15@15', '서울 강서구 곰달래로15가길 15 (화곡동, 해오름빌)', '1515', 1, 1, 1, 1),
	(33, '$2a$10$714FWROcOZXnXeeeb2xnru2aijjg8olOojgPfUzl2tgS7dIgx4Q.m', '16', '16@16', '서울 광진구 영화사로16가길 4 (구의동, 둥지하이츠)', '1616', 1, 1, 1, 1),
	(34, '$2a$10$hKeMvk22l9oQid29JnVjD.73V4zKSODXty9GzzJIlSKcc9a31dXAm', '1', '1@1', '충북 청주시 상당구 1순환로 1202-2 (방서동)', '11', 1, 1, 1, 1),
	(35, '$2a$10$mIwRXzO0hBvqQO2B9MJypuXTW7PYbQ7Aihw1LXkgzTyLNcC0BGmBO', '1', '1@1', '충북 청주시 상당구 1순환로 1202-2 (방서동)', '11', 1, 1, 1, 1),
	(36, '$2a$10$OpHmhNnRwmzgUf0dewz1i.t1BwtpGzRZHwaIYqNU9AqHIPWqWsWMy', '2', '22@22', '광주 광산구 2순환로 2482 (신가동)', '2', 1, 1, 1, 1),
	(37, '$2a$10$VoxetuHEZnnJ5iJrQGZYtu0gL8XdRD0M5EHYTkKT.SySYbyd8WziO', 'yy', 'y@y', '서울 강북구 덕릉로10길 23 (수유동, H.Y하우스)', '010888888888', 1, 1, 1, 1),
	(38, '$2a$10$Z6gYnqwcySwtX.YgYsmbrOeVbNPcdSPJvlcL2CqzFefpU8o27cqm2', 'a', 'a@a', '서울 강서구 강서로 375 (마곡동)', '01083747388', 1, 1, 1, 1),
	(39, '$2a$10$WsRJaMq33NSRnQ9fSCB41OopVs/MYygHtiHIWJ9tiKz.KbYrmudbC', '5', '5@5', '전남 구례군 구례읍 5일시장길 3-1 (봉동리)', '01000000000', 1, 1, 1, 1),
	(40, '$2a$10$5Sixvwt9lW6tY06sIP.xieqvm/5uoHw61k0mVOgV5ux2ssXw6Kw9q', 'k', 'kk@kk', '경기 가평군 가평읍 상천고갯길 213 (상색리, H&K물산)', '1', 1, 1, 1, 1),
	(41, '$2a$10$83BDV0kYr2l.t.6SFh5AfuxjGk7H0mz5a20Olkv5jHnhbsPeBouZO', '7', '7@7', '부산 기장군 장안읍 에코산단로 8 (기룡리)', '01022222222', 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
