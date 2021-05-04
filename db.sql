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

-- 테이블 used.amount 구조 내보내기
CREATE TABLE IF NOT EXISTS `amount` (
  `am_num` int(11) NOT NULL,
  `am_tax_free` varchar(45) DEFAULT NULL,
  `am_vat` varchar(45) DEFAULT NULL,
  `am_point` varchar(45) DEFAULT NULL,
  `am_discount` varchar(45) DEFAULT NULL,
  `am_total` varchar(45) DEFAULT NULL,
  `pa_num` int(11) NOT NULL,
  PRIMARY KEY (`am_num`),
  KEY `pa_num` (`pa_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.amount:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `amount` DISABLE KEYS */;
/*!40000 ALTER TABLE `amount` ENABLE KEYS */;

-- 테이블 used.card 구조 내보내기
CREATE TABLE IF NOT EXISTS `card` (
  `c_num` int(11) NOT NULL,
  `c_bin` varchar(45) DEFAULT NULL,
  `c_type` varchar(45) DEFAULT NULL,
  `c_install_month` varchar(45) DEFAULT NULL,
  `c_approved_id` varchar(45) DEFAULT NULL,
  `c_mid` varchar(45) DEFAULT NULL,
  `c_code` varchar(45) DEFAULT NULL,
  `c_interest_free_install` varchar(45) DEFAULT NULL,
  `c_item_code` varchar(45) DEFAULT NULL,
  `pa_num` int(11) NOT NULL,
  PRIMARY KEY (`c_num`),
  KEY `pa_num` (`pa_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.card:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
/*!40000 ALTER TABLE `card` ENABLE KEYS */;

-- 테이블 used.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `pa_num` int(11) NOT NULL,
  `pa_username` varchar(45) DEFAULT NULL,
  `pa_method` varchar(45) DEFAULT NULL,
  `pa_amount` varchar(45) DEFAULT NULL,
  `pa_kind` varchar(45) DEFAULT NULL,
  `pa_quantity` varchar(45) DEFAULT NULL,
  `pa_time` varchar(45) DEFAULT NULL,
  `a_num` int(11) DEFAULT NULL,
  `p_num` int(11) DEFAULT NULL,
  `pa_cop` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pa_num`),
  KEY `a_num` (`a_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 used.payment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
