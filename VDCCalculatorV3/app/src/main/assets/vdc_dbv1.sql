-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vdc_db
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assures`
--

DROP TABLE IF EXISTS assures;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assures` (
  `id` int NOT NULL,
  `Bonus` int NOT NULL,
  `Nationalite` varchar(45) NOT NULL,
  `Age` int NOT NULL,
  `Premiums_Year` int NOT NULL,
  `N_Accidents` varchar(45) NOT NULL,
  `N_Licence` varchar(45) NOT NULL,
  `Pay_Premiums_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `N_Permis_UNIQUE` (`N_Licence`),
  KEY `fk_Assures_Pay_Premiums1_idx` (`Pay_Premiums_id`),
  CONSTRAINT `fk_Assures_Pay_Premiums1` FOREIGN KEY (`Pay_Premiums_id`) REFERENCES `pay_premiums` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assures`
--

LOCK TABLES `assures` WRITE;
/*!40000 ALTER TABLE `assures` DISABLE KEYS */;
/*!40000 ALTER TABLE `assures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorepairshops`
--

DROP TABLE IF EXISTS `autorepairshops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorepairshops` (
  `id` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Addresse` varchar(45) NOT NULL,
  `N_Phone` int NOT NULL,
  `N_Affiliated` int NOT NULL,
  `Owner` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Nom_UNIQUE` (`Name`),
  UNIQUE KEY `Adresse_UNIQUE` (`Addresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorepairshops`
--

LOCK TABLES `autorepairshops` WRITE;
/*!40000 ALTER TABLE `autorepairshops` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorepairshops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id` int NOT NULL,
  `Brand` varchar(45) NOT NULL,
  `Model` varchar(45) NOT NULL,
  `Seats` varchar(45) NOT NULL,
  `Fuel` varchar(45) NOT NULL,
  `Power` int NOT NULL,
  `Weight` int NOT NULL,
  `year` date NOT NULL,
  `purchaseprice` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Chassis_UNIQUE` (`Seats`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fellings`
--

DROP TABLE IF EXISTS `fellings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fellings` (
  `id` int NOT NULL,
  `Price` int NOT NULL,
  `Station` varchar(45) NOT NULL,
  `Date` date DEFAULT NULL,
  `Address` varchar(45) NOT NULL,
  `Cars_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Date_UNIQUE` (`Date`),
  KEY `fk_Fellings_Cars1_idx` (`Cars_id`),
  CONSTRAINT `fk_Fellings_Cars1` FOREIGN KEY (`Cars_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fellings`
--

LOCK TABLES `fellings` WRITE;
/*!40000 ALTER TABLE `fellings` DISABLE KEYS */;
/*!40000 ALTER TABLE `fellings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_contract`
--

DROP TABLE IF EXISTS `insurance_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance_contract` (
  `id` int NOT NULL,
  `N_Contract` varchar(45) NOT NULL,
  `SurName` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  `Advisor` varchar(45) NOT NULL,
  `Cars_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Insurance_contract_Cars1_idx` (`Cars_id`),
  CONSTRAINT `fk_Insurance_contract_Cars1` FOREIGN KEY (`Cars_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_contract`
--

LOCK TABLES `insurance_contract` WRITE;
/*!40000 ALTER TABLE `insurance_contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `insurance_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_premiums`
--

DROP TABLE IF EXISTS `pay_premiums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay_premiums` (
  `id` int NOT NULL,
  `N_Bill` int NOT NULL,
  `Date` date NOT NULL,
  `Price` int NOT NULL,
  `Insurance_contract_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `N_Facture_UNIQUE` (`N_Bill`),
  KEY `fk_Pay_Premiums_Insurance_contract1_idx` (`Insurance_contract_id`),
  CONSTRAINT `fk_Pay_Premiums_Insurance_contract1` FOREIGN KEY (`Insurance_contract_id`) REFERENCES `insurance_contract` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_premiums`
--

LOCK TABLES `pay_premiums` WRITE;
/*!40000 ALTER TABLE `pay_premiums` DISABLE KEYS */;
/*!40000 ALTER TABLE `pay_premiums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san`
--

DROP TABLE IF EXISTS `san`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Numero_UNIQUE` (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san`
--

LOCK TABLES `san` WRITE;
/*!40000 ALTER TABLE `san` DISABLE KEYS */;
/*!40000 ALTER TABLE `san` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxes`
--

DROP TABLE IF EXISTS `taxes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxes` (
  `id` int NOT NULL,
  `Price` varchar(45) NOT NULL,
  `ToTaxe_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Numero_UNIQUE` (`Price`),
  KEY `fk_Taxes_ToTaxe1_idx` (`ToTaxe_id`),
  CONSTRAINT `fk_Taxes_ToTaxe1` FOREIGN KEY (`ToTaxe_id`) REFERENCES `totaxe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxes`
--

LOCK TABLES `taxes` WRITE;
/*!40000 ALTER TABLE `taxes` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torepair`
--

DROP TABLE IF EXISTS `torepair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `torepair` (
  `id` int NOT NULL,
  `N_bill` int NOT NULL,
  `Date` date NOT NULL,
  `Price` int NOT NULL,
  `AutoRepairShops_id` int DEFAULT NULL,
  `Cars_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `N_Facture_UNIQUE` (`N_bill`),
  KEY `fk_ToRepair_AutoRepairShops1_idx` (`AutoRepairShops_id`),
  KEY `fk_ToRepair_Cars1_idx` (`Cars_id`),
  CONSTRAINT `fk_ToRepair_AutoRepairShops1` FOREIGN KEY (`AutoRepairShops_id`) REFERENCES `autorepairshops` (`id`),
  CONSTRAINT `fk_ToRepair_Cars1` FOREIGN KEY (`Cars_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torepair`
--

LOCK TABLES `torepair` WRITE;
/*!40000 ALTER TABLE `torepair` DISABLE KEYS */;
/*!40000 ALTER TABLE `torepair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `totaxe`
--

DROP TABLE IF EXISTS `totaxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `totaxe` (
  `id` int NOT NULL,
  `N_Facture` int NOT NULL,
  `Date` date NOT NULL,
  `Prix` int NOT NULL,
  `Cars_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `N_Facture_UNIQUE` (`N_Facture`),
  KEY `fk_ToTaxe_Cars1_idx` (`Cars_id`),
  CONSTRAINT `fk_ToTaxe_Cars1` FOREIGN KEY (`Cars_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `totaxe`
--

LOCK TABLES `totaxe` WRITE;
/*!40000 ALTER TABLE `totaxe` DISABLE KEYS */;
/*!40000 ALTER TABLE `totaxe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-21 14:46:37
