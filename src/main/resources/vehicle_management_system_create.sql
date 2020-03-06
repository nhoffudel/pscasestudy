-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.19 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for vehicle_management_system
DROP DATABASE IF EXISTS `vehicle_management_system`;
CREATE DATABASE IF NOT EXISTS `vehicle_management_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vehicle_management_system`;

-- Dumping structure for table vehicle_management_system.records
DROP TABLE IF EXISTS `records`;
CREATE TABLE IF NOT EXISTS `records` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `vehicleVIN` varchar(20) NOT NULL,
  `owner` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `date` int NOT NULL,
  `miles` float NOT NULL,
  `cost` float DEFAULT NULL,
  `location` text,
  `notes` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `recordfk1` (`owner`),
  KEY `recordfk2` (`vehicleVIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table vehicle_management_system.trips
DROP TABLE IF EXISTS `trips`;
CREATE TABLE IF NOT EXISTS `trips` (
  `tripID` int NOT NULL AUTO_INCREMENT,
  `vehicleName` varchar(30) NOT NULL,
  `owner` varchar(30) NOT NULL,
  `dateBegin` int NOT NULL,
  `dateEnd` int NOT NULL,
  `placeBegin` text NOT NULL,
  `placeEnd` text NOT NULL,
  `milesBegin` float NOT NULL,
  `milesEnd` float NOT NULL,
  `cost` float DEFAULT NULL,
  `fuelEcon` float DEFAULT NULL,
  `notes` text NOT NULL,
  PRIMARY KEY (`tripID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table vehicle_management_system.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(30) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `hashedPassword` text NOT NULL,
  `securityQuestion` text NOT NULL,
  `hashedSecurityAnswer` text NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table vehicle_management_system.vehicles
DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE IF NOT EXISTS `vehicles` (
  `VIN` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `make` varchar(20) NOT NULL,
  `model` varchar(30) NOT NULL DEFAULT '',
  `year` int NOT NULL,
  `color` varchar(20) NOT NULL,
  `trim` varchar(20) NOT NULL,
  `engine` varchar(20) NOT NULL,
  `notes` text NOT NULL,
  `owner` varchar(30) NOT NULL,
  PRIMARY KEY (`VIN`),
  KEY `vehiclefk1` (`owner`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
