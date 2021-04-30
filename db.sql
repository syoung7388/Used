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

-- 테이블 used.address 구조 내보내기
CREATE TABLE IF NOT EXISTS `address` (
  `ad_num` int(11) NOT NULL AUTO_INCREMENT,
  `a_num` int(11) NOT NULL,
  `ad_lat` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ad_lon` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ad_addr` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ad_town` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ad_num`),
  KEY `a_num` (`a_num`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.address:~9 rows (대략적) 내보내기
DELETE FROM `address`;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`ad_num`, `a_num`, `ad_lat`, `ad_lon`, `ad_addr`, `ad_town`) VALUES
	(2, 20, '37.4849665053325', '127.034757121285', '서울 강남구 강남대로 238 (도곡동, 스카이쏠라빌딩)', '도곡동'),
	(4, 22, '37.0994693510836', '126.83994498363', '경기 화성시 장안면 3.1만세로322번길 10 (어은리)', '어은리'),
	(8, 26, '37.4919609951887', '127.057095314906', '서울 강남구 남부순환로 2907 (대치동, 대치지구대)', '대치동'),
	(9, 27, '37.6444661835855', '127.005876847211', '서울 강북구 4.19로17길 11 (수유동)', '수유동'),
	(10, 28, '37.0996527684079', '126.839982282494', '경기 화성시 장안면 3.1만세로322번길 8 (어은리)', '어은리'),
	(11, 29, '35.1477478746859', '126.940085125088', '광주 동구 2순환로 575 (지산동)', '지산동'),
	(12, 30, '37.5481280339601', '126.83602235212', '서울 강서구 강서로 251 (내발산동, 세란빌딩)', '내발산동'),
	(13, 31, '35.8497438250925', '128.572047773056', '대구 남구 대경길 6 (대명동)', '대명동'),
	(14, 32, '37.4719190358695', '127.051012027473', '서울 강남구 양재대로 333 (개포동)', '개포동');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- 테이블 used.auction 구조 내보내기
CREATE TABLE IF NOT EXISTS `auction` (
  `a_num` int(11) NOT NULL AUTO_INCREMENT,
  `a_username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `a_startdate` date NOT NULL DEFAULT current_timestamp(),
  `a_enddate` varchar(50) CHARACTER SET utf8 NOT NULL,
  `a_startprice` bigint(100) NOT NULL DEFAULT 0,
  `a_sale` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0:false//1: pay // 2:true',
  `a_hits` int(11) NOT NULL DEFAULT 0,
  `a_title` varchar(50) CHARACTER SET utf8 NOT NULL,
  `a_content` mediumtext CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`a_num`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.auction:~9 rows (대략적) 내보내기
DELETE FROM `auction`;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` (`a_num`, `a_username`, `a_startdate`, `a_enddate`, `a_startprice`, `a_sale`, `a_hits`, `a_title`, `a_content`) VALUES
	(20, 'kk@kk', '2021-04-29', '2021-04-30', 13000, 1, 0, '안녕하세용갈', 'ㅇ'),
	(22, 'kk@kk', '2021-04-29', '2021-04-30', 62222, 1, 2, '하잉', 'null'),
	(26, 'kk@kk', '2021-04-29', '2021-04-30', 200000, 1, 0, '안녕하세요 족발 @@', '안녕하세요 족발 @@'),
	(27, 'kk@kk', '2021-04-29', '2021-04-30', 1230000, 1, 0, '쪽발', '쪽발'),
	(28, 'kk@kk', '2021-04-29', '2021-04-30', 130000, 0, 0, '떡뽁이 먹고싶당', '떡뽁이 먹고싶당'),
	(29, 'c@c', '2021-04-30', '2021-05-10', 120000, 0, 0, '꼬기 먹고싶당', '꼬기 먹고싶당'),
	(30, 'c@c', '2021-04-30', '2021-05-10', 1300000, 0, 0, '네네치킨', '네네치킨'),
	(31, 'c@c', '2021-04-30', '2021-05-10', 1500000, 0, 0, '핸즈커피', '핸즈커피'),
	(32, 'c@c', '2021-04-30', '2021-05-10', 11, 0, 0, '11', '11');
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;

-- 테이블 used.auc_and_pro 구조 내보내기
CREATE TABLE IF NOT EXISTS `auc_and_pro` (
  `a_num` int(11) NOT NULL,
  `p_num` int(11) NOT NULL,
  PRIMARY KEY (`a_num`,`p_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.auc_and_pro:~10 rows (대략적) 내보내기
DELETE FROM `auc_and_pro`;
/*!40000 ALTER TABLE `auc_and_pro` DISABLE KEYS */;
INSERT INTO `auc_and_pro` (`a_num`, `p_num`) VALUES
	(18, 96),
	(20, 98),
	(22, 100),
	(26, 104),
	(27, 105),
	(28, 106),
	(29, 107),
	(30, 108),
	(31, 109),
	(32, 110);
/*!40000 ALTER TABLE `auc_and_pro` ENABLE KEYS */;

-- 테이블 used.auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `auth` (
  `u_username` varchar(50) NOT NULL,
  `u_auth` varchar(50) NOT NULL,
  PRIMARY KEY (`u_username`,`u_auth`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.auth:~9 rows (대략적) 내보내기
DELETE FROM `auth`;
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` (`u_username`, `u_auth`) VALUES
	('10@10', 'ROLE_USER'),
	('1@1', 'ROLE_USER'),
	('22@22', 'ROLE_USER'),
	('5@5', 'ROLE_USER'),
	('7@7', 'ROLE_USER'),
	('a@a', 'ROLE_USER'),
	('c@c', 'ROLE_USER'),
	('f@f', 'ROLE_USER'),
	('g@g', 'ROLE_USER'),
	('kk@kk', 'ROLE_USER'),
	('y@y', 'ROLE_USER');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;

-- 테이블 used.like 구조 내보내기
CREATE TABLE IF NOT EXISTS `like` (
  `a_num` int(11) NOT NULL,
  `l_username` varchar(50) NOT NULL,
  PRIMARY KEY (`a_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.like:~4 rows (대략적) 내보내기
DELETE FROM `like`;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
INSERT INTO `like` (`a_num`, `l_username`) VALUES
	(22, 'c@c'),
	(26, 'c@c'),
	(27, 'c@c'),
	(28, 'c@c');
/*!40000 ALTER TABLE `like` ENABLE KEYS */;

-- 테이블 used.offer 구조 내보내기
CREATE TABLE IF NOT EXISTS `offer` (
  `o_num` int(11) NOT NULL AUTO_INCREMENT,
  `a_num` int(11) NOT NULL,
  `o_username` varchar(50) NOT NULL,
  `o_price` bigint(50) NOT NULL,
  `o_time` datetime NOT NULL DEFAULT current_timestamp(),
  `o_select` tinyint(4) NOT NULL DEFAULT 0,
  `o_skip` tinyint(4) NOT NULL DEFAULT 0,
  `o_pay` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`o_num`) USING BTREE,
  KEY `a_num` (`a_num`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.offer:~8 rows (대략적) 내보내기
DELETE FROM `offer`;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` (`o_num`, `a_num`, `o_username`, `o_price`, `o_time`, `o_select`, `o_skip`, `o_pay`) VALUES
	(61, 20, 'c@c', 30000000000, '2021-04-29 15:22:30', 0, 0, 0),
	(63, 26, 'c@c', 1200000, '2021-04-29 15:52:02', 1, 0, 0),
	(64, 27, 'c@c', 120000, '2021-04-29 15:58:12', 1, 0, 0),
	(65, 20, 'f@f', 150000000, '2021-04-29 18:18:59', 0, 0, 0),
	(71, 22, 'c@c', 1300000, '2021-04-30 10:26:29', 1, 0, 0),
	(72, 22, 'c@c', 14000, '2021-04-30 10:26:41', 0, 0, 0),
	(73, 26, 'c@c', 150000, '2021-04-30 10:26:52', 0, 0, 0),
	(74, 20, 'f@f', 400000000000000, '2021-04-30 11:02:51', 1, 0, 0);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;

-- 테이블 used.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `pa_num` int(11) NOT NULL AUTO_INCREMENT,
  `a_num` int(11) NOT NULL,
  `o_num` int(11) NOT NULL,
  `pa_pay` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'false',
  PRIMARY KEY (`pa_num`),
  KEY `a_num` (`a_num`),
  KEY `o_num` (`o_num`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.payment:~0 rows (대략적) 내보내기
DELETE FROM `payment`;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 테이블 used.picture 구조 내보내기
CREATE TABLE IF NOT EXISTS `picture` (
  `p_num` int(11) NOT NULL,
  `pi_num` int(11) NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`pi_num`,`p_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.picture:~10 rows (대략적) 내보내기
DELETE FROM `picture`;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` (`p_num`, `pi_num`, `pi_name`) VALUES
	(100, 151, 'aacvv.jpg'),
	(98, 155, 'maxresdefault.jpg'),
	(104, 156, 'article.jpg'),
	(104, 157, '660_shop1_359170.jpg'),
	(105, 158, 'article.jpg'),
	(106, 159, 'abcd.jpg'),
	(107, 160, 'abcd.jpg'),
	(108, 161, '25776225976.jpg'),
	(109, 162, 'e382665f1e25e51bde7ac49e62d2ea1b.jpg'),
	(110, 163, 'article.jpg');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;

-- 테이블 used.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `p_num` int(11) NOT NULL AUTO_INCREMENT,
  `p_brand` varchar(50) NOT NULL,
  `p_kind` varchar(50) NOT NULL,
  `p_industry` varchar(50) NOT NULL,
  `p_year` varchar(50) NOT NULL,
  PRIMARY KEY (`p_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.product:~9 rows (대략적) 내보내기
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`p_num`, `p_brand`, `p_kind`, `p_industry`, `p_year`) VALUES
	(98, 'ㅇ', '냉동 절육기', '카페/베이커리', '1986'),
	(100, 'null', '벽선단', '족발/ 보쌈', '1987'),
	(104, '족발', '커피머신', '카페/베이커리', '1988'),
	(105, '쪽발', '커피머신', '카페/베이커리', '1988'),
	(106, '떡뽁이', '커피머신', '카페/베이커리', '1989'),
	(107, '꼬기', '냉동 절육기', '배달전문점', '1996'),
	(108, '네네치킨', '냉동 절육기', '치킨', '1987'),
	(109, '핸즈커피', '냉동 절육기', '카페/베이커리', '1988'),
	(110, '11', '그릴기', '호프/술집', '1996');
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
DELETE FROM `spring_session`;
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
DELETE FROM `spring_session_attributes`;
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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.user:~16 rows (대략적) 내보내기
DELETE FROM `user`;
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
	(41, '$2a$10$83BDV0kYr2l.t.6SFh5AfuxjGk7H0mz5a20Olkv5jHnhbsPeBouZO', '7', '7@7', '부산 기장군 장안읍 에코산단로 8 (기룡리)', '01022222222', 1, 1, 1, 1),
	(42, '$2a$10$qDdJQC9Dd.k5cbnaRqLPwOxGHhPbi.Bgq4bNbpOyZn5IFnEFgfXl2', '10', '10@10', '경기 화성시 10용사로 49 (병점동)', '01088888888', 1, 1, 1, 1),
	(43, '$2a$10$SrHFjMeelAKY1VENABSz7O9vf9HjLfl54mH.2185.gRuPHluXsQXG', 'g', 'g@g', '서울 강남구 헌릉로 569 (세곡동)', '1111111111', 1, 1, 1, 1),
	(44, '$2a$10$KsF9bzpypIlMFKVpxAxz1.ee1j1ozFes.w6NGg7xSsyJAFu8EAG8G', 'f', 'f@f', '인천 서구 로봇랜드로 33 (원창동)', '01083747388', 1, 1, 1, 1),
	(45, '$2a$10$Kl634SUZJqbvmwI0BjcanOOOvsw4VfRH3dSOZ1qG7HqN7f4V/WAH2', 'c', 'c@c', '서울 강남구 도산대로 402-2 (청담동)', '123444', 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
