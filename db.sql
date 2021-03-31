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

-- 테이블 used.auth 구조 내보내기
CREATE TABLE IF NOT EXISTS `auth` (
  `u_email` varchar(50) NOT NULL,
  `u_auth` varchar(50) NOT NULL,
  PRIMARY KEY (`u_auth`,`u_email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.auth:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `auth` DISABLE KEYS */;
INSERT INTO `auth` (`u_email`, `u_auth`) VALUES
	('B', 'ROLE_USER'),
	('dy', 'ROLE_USER'),
	('김수영님', 'ROLE_USER'),
	('쿠잉', 'ROLE_USER');
/*!40000 ALTER TABLE `auth` ENABLE KEYS */;

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
  `u_username` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_phone` varchar(50) NOT NULL,
  `u_num` int(11) NOT NULL AUTO_INCREMENT,
  `u_isAccountNonLocked` tinyint(4) DEFAULT NULL,
  `u_isAccountNonExpired` tinyint(4) DEFAULT NULL,
  `u_isCredentialsNonExpired` tinyint(4) DEFAULT NULL,
  `u_isEnabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`u_num`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.user:~7 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`u_password`, `u_username`, `u_email`, `u_address`, `u_phone`, `u_num`, `u_isAccountNonLocked`, `u_isAccountNonExpired`, `u_isCredentialsNonExpired`, `u_isEnabled`) VALUES
	('$2a$10$EvIIJGvK7YM8QMZkWpxlKunvK3XL9Iq6mj3fVuOasEA/WeC6AFvqu', 'B', 'bbbb@bbbb', '대구 동구 신암로16길 25 (신천동, 신천자이아파트)', '01083747388', 3, 1, 1, 1, 1),
	('$2a$10$bjX9dPCpBuoJQpMN2gdQduIb7AZZMDdwyhteowo1q/JNK8rUKgB2O', '김수영님', 'dddd0403@naver.com', '서울 관악구 승방길 6 (남현동, 우남빌딩)', '01083747388', 4, 1, 1, 1, 1),
	('$2a$10$1FedNBA78NE6NxYUwMpjKO2Xmsm1jFaUfk36I4jkqktdAjIavTlue', 'dy', 'ccc@ccc', '서울 강남구 강남대로 708 (압구정동, 한남대교레인보우카폐)', '01083747388', 5, 1, 1, 1, 1),
	('$2a$10$pN/jF9DYFDkPL59LGbne3u1PmyvNNnaBcEoumHLT7QNufjqciH97y', 'dy', 'ccc@ccc', '서울 관악구 승방길 6 (남현동, 우남빌딩)', '01083747388', 6, 1, 1, 1, 1),
	('$2a$10$tZtxdfoapJ9o7k72iKhUMesnEElzAdR/Ps/m/rEsDvD8BuQ735AyS', 'dy', 'ccc@ccc', '서울 관악구 승방길 6 (남현동, 우남빌딩)', '01083747388', 7, 1, 1, 1, 1),
	('$2a$10$.JO5pQYnPcQGZoiCxhiY4OmyraFL4LsuuqQsbVmetPuVYqy4waUa.', 'dy', 'ccc@ccc', '서울 관악구 승방길 6 (남현동, 우남빌딩)', '01083747388', 8, 1, 1, 1, 1),
	('$2a$10$0.Zu6ovKVBMgbans4HEmUuEuTULdaHaA80NOh/DUxEWrpFhORPiNG', '쿠잉', 'ddd@ddd', '제주특별자치도 제주시 가령골길 1 (일도이동)', '01083747388', 9, 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
