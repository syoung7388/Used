-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.4-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- used 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `used` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `used`;

-- 테이블 used.auction 구조 내보내기
CREATE TABLE IF NOT EXISTS `auction` (
  `a_num` int(11) NOT NULL,
  `a_price` varchar(50) DEFAULT NULL,
  `a_participant` varchar(50) DEFAULT NULL,
  `a_time` datetime NOT NULL,
  `p_number` int(11) NOT NULL,
  PRIMARY KEY (`a_num`,`p_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.auction:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;

-- 테이블 used.auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `auth` (
  `u_username` varchar(50) NOT NULL,
  `u_auth` varchar(50) NOT NULL,
  PRIMARY KEY (`u_auth`,`u_username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.auth:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` (`u_username`, `u_auth`) VALUES
	('33@33', 'ROLE_USER'),
	('y@y', 'ROLE_USER');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;

-- 테이블 used.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `board` (
  `b_num` int(11) NOT NULL AUTO_INCREMENT,
  `b_writer` varchar(50) NOT NULL,
  `b_title` varchar(50) NOT NULL,
  `b_content` longtext NOT NULL,
  `b_like` int(10) DEFAULT NULL,
  PRIMARY KEY (`b_num`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.board:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` (`b_num`, `b_writer`, `b_title`, `b_content`, `b_like`) VALUES
	(1, 'anonymousUser', '전주행', '전주행', NULL),
	(2, 'anonymousUser', '전주행', '전주행', NULL),
	(3, 'anonymousUser', '작업대', '작업대', NULL),
	(4, 'anonymousUser', '1', '1', NULL);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;

-- 테이블 used.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `p_num` int(11) NOT NULL AUTO_INCREMENT,
  `p_kind` varchar(50) NOT NULL,
  `p_industry` varchar(50) NOT NULL,
  `p_brand` varchar(50) NOT NULL,
  `p_year` varchar(50) NOT NULL,
  `p_picture` mediumtext DEFAULT '',
  `p_startprice` int(11) NOT NULL,
  `p_endprice` int(11) DEFAULT NULL,
  `b_number` int(11) NOT NULL,
  PRIMARY KEY (`p_num`,`b_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.product:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
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
  `u_password` varchar(500) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_phone` varchar(50) NOT NULL,
  `u_num` int(11) NOT NULL AUTO_INCREMENT,
  `u_isAccountNonLocked` tinyint(4) DEFAULT NULL,
  `u_isAccountNonExpired` tinyint(4) DEFAULT NULL,
  `u_isCredentialsNonExpired` tinyint(4) DEFAULT NULL,
  `u_isEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`u_num`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.user:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`u_password`, `u_name`, `u_username`, `u_address`, `u_phone`, `u_num`, `u_isAccountNonLocked`, `u_isAccountNonExpired`, `u_isCredentialsNonExpired`, `u_isEnabled`) VALUES
	('$2a$10$r6q5gnGARo6ocgu3Cs02KuzQRlG7KiWhSPbG/icWWi/wre0jAuHSG', '3', '33@33', '대구 북구 3공단로 5 (노원동3가)', '3', 10, 1, 1, 1, 1),
	('$2a$10$/V4ipj5XM3aJPgvFmiB7quMcSZrUsyNAGwk6tOu/r5XCQZeissFyO', 'yt', 'y@y', '서울 강북구 덕릉로10길 23 (수유동, H.Y하우스)', 'y@y', 14, 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
