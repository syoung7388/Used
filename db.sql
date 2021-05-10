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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.address:~22 rows (대략적) 내보내기
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
	(14, 32, '37.4719190358695', '127.051012027473', '서울 강남구 양재대로 333 (개포동)', '개포동'),
	(15, 33, '36.6375346629654', '127.459726819858', '충북 청주시 서원구 1순환로 627 (사창동, 에덴건축)', '사창동'),
	(16, 34, '37.5182112402056', '127.023150432187', '서울 강남구 가로수길 5 (신사동)', '신사동'),
	(17, 35, '37.54034051708', '126.79667948628', '서울 강서구 대장로 39 (오쇠동)', '오쇠동'),
	(18, 36, '37.4719190358695', '127.051012027473', '서울 강남구 양재대로 333 (개포동)', '개포동'),
	(19, 37, '37.4846145098939', '126.903495668471', '서울 관악구 신사로 3 (신림동, 조원동공중화장실)', '신림동'),
	(20, 38, '37.4816207832791', '127.044692469535', '서울 강남구 양재천로 167 (도곡동)', '도곡동'),
	(21, 39, '37.4781726909959', '127.044983798146', '서울 강남구 개포로 202 (개포동, 석인빌딩)', '개포동'),
	(22, 40, '37.5512951423626', '127.124423444799', '서울 강동구 상암로 6 (암사동)', '암사동'),
	(23, 41, '37.4719190358695', '127.051012027473', '서울 강남구 양재대로 333 (개포동)', '개포동'),
	(24, 42, '37.5512951423626', '127.124423444799', '서울 강동구 상암로 6 (암사동)', '암사동'),
	(25, 43, '37.6463886066409', '127.007567488458', '서울 강북구 4.19로12길 5 (수유동)', '수유동'),
	(26, 44, '36.6563619120438', '127.472781924359', '충북 청주시 흥덕구 1순환로 384 (신봉동)', '신봉동'),
	(27, 45, '36.6375346629654', '127.459726819858', '충북 청주시 서원구 1순환로 627 (사창동, 에덴건축)', '사창동'),
	(28, 46, '37.4719190358695', '127.051012027473', '서울 강남구 양재대로 333 (개포동)', '개포동'),
	(29, 47, '37.5481280339601', '126.83602235212', '서울 강서구 강서로 251 (내발산동, 세란빌딩)', '내발산동'),
	(30, 48, '37.5547171125957', '126.816835087425', '서울 강서구 방화대로6가길 6 (공항동)', '공항동');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- 테이블 used.amount 구조 내보내기
CREATE TABLE IF NOT EXISTS `amount` (
  `am_num` int(11) NOT NULL AUTO_INCREMENT,
  `am_tax_free` varchar(45) NOT NULL,
  `am_vat` varchar(45) NOT NULL,
  `am_point` varchar(45) NOT NULL,
  `am_discount` varchar(45) NOT NULL,
  `am_total` varchar(45) NOT NULL,
  `pa_num` int(11) NOT NULL,
  PRIMARY KEY (`am_num`),
  KEY `pa_num` (`pa_num`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.amount:~5 rows (대략적) 내보내기
DELETE FROM `amount`;
/*!40000 ALTER TABLE `amount` DISABLE KEYS */;
INSERT INTO `amount` (`am_num`, `am_tax_free`, `am_vat`, `am_point`, `am_discount`, `am_total`, `pa_num`) VALUES
	(8, '0', '90909', '0', '0', '1000000', 10),
	(11, '0', '90909', '0', '0', '1000000', 13),
	(12, '0', '90909', '0', '0', '1000000', 14),
	(13, '0', '90909', '0', '0', '1000000', 15),
	(14, '0', '90909', '0', '0', '1000000', 16);
/*!40000 ALTER TABLE `amount` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.auction:~23 rows (대략적) 내보내기
DELETE FROM `auction`;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` (`a_num`, `a_username`, `a_startdate`, `a_enddate`, `a_startprice`, `a_sale`, `a_hits`, `a_title`, `a_content`) VALUES
	(20, 'kk@kk', '2021-04-29', '2021-04-30', 13000, 2, 3, '안녕하세용갈', 'ㅇ'),
	(22, 'kk@kk', '2021-04-29', '2021-04-30', 62222, 2, 61, '하잉', 'null'),
	(26, 'kk@kk', '2021-04-29', '2021-04-30', 200000, 2, 2, '안녕하세요 족발 @@', '안녕하세요 족발 @@'),
	(27, 'kk@kk', '2021-04-29', '2021-04-30', 1230000, 2, 1, '쪽발', '쪽발'),
	(28, 'kk@kk', '2021-04-29', '2021-05-10', 130000, 0, 47, '떡뽁이 먹고싶당', '떡뽁이 먹고싶당'),
	(29, 'c@c', '2021-04-30', '2021-05-10', 120000, 0, 22, '꼬기 먹고싶당', '꼬기 먹고싶당'),
	(30, 'c@c', '2021-04-30', '2021-05-10', 1300000, 0, 14, '네네치킨', '네네치킨'),
	(31, 'c@c', '2021-04-30', '2021-05-10', 1500000, 0, 10, '핸즈커피', '핸즈커피'),
	(32, 'c@c', '2021-04-30', '2021-05-10', 11, 0, 9, '11', '11'),
	(33, 'c@c', '2021-05-05', '2021-05-13', 1111, 0, 4, 'a', 'a'),
	(34, 'c@c', '2021-05-05', '2021-05-15', 1300000, 0, 2, '안녕하세요 보스커피입니다', '안녕하세요 보스커피입니다'),
	(35, 'c@c', '2021-05-05', '2021-05-15', 1340000, 0, 0, '로제 떡볶이', '로제 떡볶이'),
	(36, 'c@c', '2021-05-05', '2021-05-13', 1300000, 0, 0, '배고파 너의 고파', '배고파 너의 고파'),
	(37, 'c@c', '2021-05-05', '2021-05-15', 1400000, 0, 2, '하잉', '하윙'),
	(38, 'c@c', '2021-05-05', '2021-05-15', 123243, 0, 2, '안농안농', '안농'),
	(39, 'c@c', '2021-05-06', '2021-05-15', 130000, 0, 0, '하잉하잉', 'ㅇㅇㅇ'),
	(40, 'c@c', '2021-05-06', '2021-05-14', 1400000, 0, 1, '아잉', '아잉'),
	(41, 'c@c', '2021-05-06', '2021-05-16', 14000, 0, 5, '피짜', '피짜'),
	(42, 'c@c', '2021-05-06', '2021-05-15', 50000, 0, 1, '그대', '그대'),
	(43, 'c@c', '2021-05-06', '2021-05-16', 4444, 0, 1, '44', '44'),
	(44, 'c@c', '2021-05-06', '2021-05-10', 1111, 0, 4, '111', '111'),
	(45, 'c@c', '2021-05-06', '2021-05-16', 140000, 0, 0, '130000', '14'),
	(46, 'c@c', '2021-05-06', '2021-05-15', 113300, 0, 2, '하잉하잉', '항잉'),
	(47, 'c@c', '2021-05-06', '2021-05-15', 150000, 0, 7, 'ㅈㅈ', 'ㅈㅈ'),
	(48, 'c@c', '2021-05-06', '2021-05-16', 6666, 0, 6, '66', '666');
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;

-- 테이블 used.auc_and_pro 구조 내보내기
CREATE TABLE IF NOT EXISTS `auc_and_pro` (
  `a_num` int(11) NOT NULL,
  `p_num` int(11) NOT NULL,
  PRIMARY KEY (`a_num`,`p_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.auc_and_pro:~23 rows (대략적) 내보내기
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
	(32, 110),
	(33, 111),
	(34, 112),
	(35, 113),
	(36, 114),
	(37, 115),
	(38, 116),
	(39, 117),
	(40, 118),
	(41, 119),
	(42, 120),
	(43, 121),
	(44, 122),
	(45, 123),
	(46, 124),
	(47, 125),
	(48, 126);
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

-- 테이블 used.card 구조 내보내기
CREATE TABLE IF NOT EXISTS `card` (
  `c_num` int(11) NOT NULL AUTO_INCREMENT,
  `c_bin` bigint(30) NOT NULL,
  `c_type` varchar(45) NOT NULL,
  `c_install_month` varchar(45) NOT NULL,
  `c_approved_id` bigint(30) NOT NULL,
  `c_mid` varchar(45) NOT NULL,
  `c_interest_free_install` varchar(45) NOT NULL,
  `pa_num` int(11) NOT NULL,
  PRIMARY KEY (`c_num`),
  KEY `pa_num` (`pa_num`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.card:~5 rows (대략적) 내보내기
DELETE FROM `card`;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` (`c_num`, `c_bin`, `c_type`, `c_install_month`, `c_approved_id`, `c_mid`, `c_interest_free_install`, `pa_num`) VALUES
	(6, 123456, '신용', '00', 11111111, 'mid', 'N', 10),
	(9, 123456, '신용', '00', 11111111, 'mid', 'N', 13),
	(10, 123456, '신용', '00', 11111111, 'mid', 'N', 14),
	(11, 123456, '신용', '00', 11111111, 'mid', 'N', 15),
	(12, 123456, '신용', '00', 11111111, 'mid', 'N', 16);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;

-- 테이블 used.chat 구조 내보내기
CREATE TABLE IF NOT EXISTS `chat` (
  `ch_num` int(11) NOT NULL AUTO_INCREMENT,
  `ch_seller` varchar(50) NOT NULL,
  `ch_buyer` varchar(50) NOT NULL,
  `a_num` int(11) NOT NULL,
  PRIMARY KEY (`ch_num`) USING BTREE,
  KEY `a_num` (`a_num`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.chat:~0 rows (대략적) 내보내기
DELETE FROM `chat`;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` (`ch_num`, `ch_seller`, `ch_buyer`, `a_num`) VALUES
	(17, 'kk@kk', 'c@c', 20),
	(18, 'kk@kk', 'c@c', 22),
	(19, 'kk@kk', 'c@c', 26);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;

-- 테이블 used.like 구조 내보내기
CREATE TABLE IF NOT EXISTS `like` (
  `a_num` int(11) NOT NULL,
  `l_username` varchar(50) NOT NULL,
  `l_num` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`l_num`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.like:~7 rows (대략적) 내보내기
DELETE FROM `like`;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
INSERT INTO `like` (`a_num`, `l_username`, `l_num`) VALUES
	(22, 'c@c', 1),
	(26, 'c@c', 2),
	(27, 'c@c', 3),
	(31, '1@1', 5),
	(29, '1@1', 6),
	(22, '1@1', 7),
	(28, 'c@c', 11),
	(29, 'kk@kk', 12);
/*!40000 ALTER TABLE `like` ENABLE KEYS */;

-- 테이블 used.message 구조 내보내기
CREATE TABLE IF NOT EXISTS `message` (
  `m_num` int(11) NOT NULL AUTO_INCREMENT,
  `ch_num` int(11) NOT NULL,
  `m_username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `m_content` varchar(50) CHARACTER SET utf8 NOT NULL,
  `m_time` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`m_num`),
  KEY `ca_num` (`ch_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.message:~0 rows (대략적) 내보내기
DELETE FROM `message`;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;

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
  KEY `a_num` (`a_num`),
  KEY `o_username` (`o_username`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.offer:~6 rows (대략적) 내보내기
DELETE FROM `offer`;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` (`o_num`, `a_num`, `o_username`, `o_price`, `o_time`, `o_select`, `o_skip`, `o_pay`) VALUES
	(61, 20, 'c@c', 1000000, '2021-04-29 15:22:30', 0, 0, 0),
	(63, 26, 'c@c', 1000000, '2021-04-29 15:52:02', 1, 0, 0),
	(64, 27, 'c@c', 1000000, '2021-04-29 15:58:12', 1, 0, 0),
	(71, 22, 'c@c', 1000000, '2021-04-30 10:26:29', 1, 0, 0),
	(73, 26, 'c@c', 900000, '2021-04-30 10:26:52', 0, 0, 0),
	(74, 20, 'f@f', 900000, '2021-04-30 11:02:51', 1, 0, 0),
	(81, 28, 'c@c', 17000000, '2021-05-03 12:33:28', 0, 0, 0),
	(82, 31, 'kk@kk', 100000000, '2021-05-05 10:48:21', 0, 0, 0);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;

-- 테이블 used.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `pa_num` int(11) NOT NULL AUTO_INCREMENT,
  `pa_username` varchar(45) NOT NULL,
  `pa_method` varchar(45) NOT NULL,
  `pa_kind` varchar(45) NOT NULL,
  `pa_quantity` varchar(45) NOT NULL,
  `pa_time` varchar(45) NOT NULL,
  `a_num` int(11) NOT NULL,
  `p_num` int(11) NOT NULL,
  `pa_cop` varchar(45) NOT NULL,
  PRIMARY KEY (`pa_num`),
  KEY `a_num` (`a_num`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.payment:~5 rows (대략적) 내보내기
DELETE FROM `payment`;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`pa_num`, `pa_username`, `pa_method`, `pa_kind`, `pa_quantity`, `pa_time`, `a_num`, `p_num`, `pa_cop`) VALUES
	(10, 'c@c', 'MONEY', '벽선단', '1', '2021-05-04T19:10:26', 22, 100, 'KAKAOPAY'),
	(13, 'c@c', 'CARD', '커피머신', '1', '2021-05-05T10:31:29', 27, 105, 'KAKAOPAY'),
	(14, 'c@c', 'CARD', '커피머신', '1', '2021-05-05T10:41:36', 26, 104, 'KAKAOPAY'),
	(15, 'c@c', 'CARD', '냉동 절육기', '1', '2021-05-05T10:44:47', 20, 98, 'KAKAOPAY');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 테이블 used.picture 구조 내보내기
CREATE TABLE IF NOT EXISTS `picture` (
  `p_num` int(11) NOT NULL,
  `pi_num` int(11) NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`pi_num`,`p_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=latin1;

-- 테이블 데이터 used.picture:~34 rows (대략적) 내보내기
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
	(110, 163, 'article.jpg'),
	(110, 164, 'e382665f1e25e51bde7ac49e62d2ea1b.jpg'),
	(111, 165, 'aacvv.jpg'),
	(111, 166, 'KakaoTalk_20201221_170406053.jpg'),
	(112, 167, 'aacvv.jpg'),
	(112, 168, '25763021630.jpg'),
	(113, 169, 'aacvv.jpg'),
	(113, 170, '25763021630.jpg'),
	(114, 171, 'aacvv.jpg'),
	(114, 172, '25763021630.jpg'),
	(115, 173, 'aacvv.jpg'),
	(115, 174, 'article.jpg'),
	(116, 175, 'aacvv.jpg'),
	(116, 176, '25763021630.jpg'),
	(117, 177, '660_shop1_359170.jpg'),
	(117, 178, 'abcd.jpg'),
	(118, 179, 'aacvv.jpg'),
	(118, 180, '25763021630.jpg'),
	(119, 181, 'aacvv.jpg'),
	(119, 182, '25763021630.jpg'),
	(120, 183, 'e382665f1e25e51bde7ac49e62d2ea1b.jpg'),
	(120, 184, '654_shop1_309263.jpg'),
	(121, 185, '25776225976.jpg'),
	(122, 186, '25776225976.jpg'),
	(123, 187, 'aacvv.jpg'),
	(124, 188, '660_shop1_359170.jpg'),
	(125, 189, '660_shop1_359170.jpg'),
	(126, 190, 'aacvv.jpg');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;

-- 테이블 used.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `p_num` int(11) NOT NULL AUTO_INCREMENT,
  `p_brand` varchar(50) NOT NULL,
  `p_kind` varchar(50) NOT NULL,
  `p_industry` varchar(50) NOT NULL,
  `p_year` varchar(50) NOT NULL,
  PRIMARY KEY (`p_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.product:~22 rows (대략적) 내보내기
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
	(110, '11', '그릴기', '호프/술집', '1996'),
	(111, 'a', '냉동 절육기', '카페/베이커리', '1987'),
	(112, '보스', '그릴기', '카페/베이커리', '1989'),
	(113, '로제', '그릴기', '한식', '1989'),
	(114, '배고', '그릴기', '카페/베이커리', '1989'),
	(115, '하ㅏ잉', '작업대', '호프/술집', '1989'),
	(116, 'ㅇㄴ', '커피머신', '배달전문점', '1987'),
	(117, 'ㅇㅇ', '냉동 절육기', '호프/술집', '1994'),
	(118, '아잉', '그릴기', '배달전문점', '1981'),
	(119, '피짜', '커피머신', '피자/샐러드', '1988'),
	(120, '그대', '제빙기', '배달전문점', '1989'),
	(121, '44', '커피머신', '호프/술집', '1995'),
	(122, '111', '커피머신', '배달전문점', '1988'),
	(123, '14', '커피머신', '배달전문점', '1989'),
	(124, 'ㅇㅇ', '냉동 절육기', '분식', '1970'),
	(125, 'ㅈㅈ', '그릴기', '카페/베이커리', '1995'),
	(126, '66', '그릴기', '카페/베이커리', '1987');
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.user:~16 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`u_num`, `u_password`, `u_name`, `u_username`, `u_address`, `u_phone`, `u_isAccountNonLocked`, `u_isAccountNonExpired`, `u_isCredentialsNonExpired`, `u_isEnabled`) VALUES
	(10, '$2a$10$r6q5gnGARo6ocgu3Cs02KuzQRlG7KiWhSPbG/icWWi/wre0jAuHSG', '3', '33@33', '대구 북구 3공단로 5 (노원동3가)', '3', 1, 1, 1, 1),
	(14, '$2a$10$/V4ipj5XM3aJPgvFmiB7quMcSZrUsyNAGwk6tOu/r5XCQZeissFyO', 'yt', 'y@y', '서울 강북구 덕릉로10길 23 (수유동, H.Y하우스)', 'y@y', 1, 1, 1, 1),
	(31, '$2a$10$NKtEw8DcbnlWxv3qXbL3tewYF6xLehkklG.HE/qrrUmVbH0eI1Ozu', '10', '10@10', '경기 화성시 10용사로 49 (병점동)', '10', 1, 1, 1, 1),
	(32, '$2a$10$eEmKevWXhD.wZAZurlHYxOjATEeRdBO0e3eNngj6GVvzNjB//F7hy', '15', '15@15', '서울 강서구 곰달래로15가길 15 (화곡동, 해오름빌)', '1515', 1, 1, 1, 1),
	(33, '$2a$10$714FWROcOZXnXeeeb2xnru2aijjg8olOojgPfUzl2tgS7dIgx4Q.m', '16', '16@16', '서울 광진구 영화사로16가길 4 (구의동, 둥지하이츠)', '1616', 1, 1, 1, 1),
	(36, '$2a$10$OpHmhNnRwmzgUf0dewz1i.t1BwtpGzRZHwaIYqNU9AqHIPWqWsWMy', '2', '22@22', '광주 광산구 2순환로 2482 (신가동)', '2', 1, 1, 1, 1),
	(37, '$2a$10$VoxetuHEZnnJ5iJrQGZYtu0gL8XdRD0M5EHYTkKT.SySYbyd8WziO', 'yy', 'y@y', '서울 강북구 덕릉로10길 23 (수유동, H.Y하우스)', '010888888888', 1, 1, 1, 1),
	(38, '$2a$10$Z6gYnqwcySwtX.YgYsmbrOeVbNPcdSPJvlcL2CqzFefpU8o27cqm2', 'a', 'a@a', '서울 강서구 강서로 375 (마곡동)', '01083747388', 1, 1, 1, 1),
	(39, '$2a$10$WsRJaMq33NSRnQ9fSCB41OopVs/MYygHtiHIWJ9tiKz.KbYrmudbC', '5', '5@5', '전남 구례군 구례읍 5일시장길 3-1 (봉동리)', '01000000000', 1, 1, 1, 1),
	(40, '$2a$10$5Sixvwt9lW6tY06sIP.xieqvm/5uoHw61k0mVOgV5ux2ssXw6Kw9q', 'k', 'kk@kk', '경기 가평군 가평읍 상천고갯길 213 (상색리, H&K물산)', '1', 1, 1, 1, 1),
	(41, '$2a$10$83BDV0kYr2l.t.6SFh5AfuxjGk7H0mz5a20Olkv5jHnhbsPeBouZO', '7', '7@7', '부산 기장군 장안읍 에코산단로 8 (기룡리)', '01022222222', 1, 1, 1, 1),
	(42, '$2a$10$qDdJQC9Dd.k5cbnaRqLPwOxGHhPbi.Bgq4bNbpOyZn5IFnEFgfXl2', '10', '10@10', '경기 화성시 10용사로 49 (병점동)', '01088888888', 1, 1, 1, 1),
	(43, '$2a$10$SrHFjMeelAKY1VENABSz7O9vf9HjLfl54mH.2185.gRuPHluXsQXG', 'g', 'g@g', '서울 강남구 헌릉로 569 (세곡동)', '1111111111', 1, 1, 1, 1),
	(44, '$2a$10$KsF9bzpypIlMFKVpxAxz1.ee1j1ozFes.w6NGg7xSsyJAFu8EAG8G', 'f', 'f@f', '인천 서구 로봇랜드로 33 (원창동)', '01083747388', 1, 1, 1, 1),
	(45, '$2a$10$Kl634SUZJqbvmwI0BjcanOOOvsw4VfRH3dSOZ1qG7HqN7f4V/WAH2', 'c', 'c@c', '서울 강남구 도산대로 402-2 (청담동)', '123444', 1, 1, 1, 1),
	(46, '$2a$10$3pL1MP4FqZpyW.CL6QNJAO2hoN4zXyeQ9u/6LqvZEUS79s6/f2uJu', '1', '1@1', '충북 청주시 청원구 1순환로 42 (율량동, 화장실)', '01083747388', 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
