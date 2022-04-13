-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: wow_companion_db
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `COVENANT`
--

DROP TABLE IF EXISTS `COVENANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `COVENANT` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `MEDIA_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COVENANT`
--

LOCK TABLES `COVENANT` WRITE;
/*!40000 ALTER TABLE `COVENANT` DISABLE KEYS */;
/*!40000 ALTER TABLE `COVENANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FACTIONS`
--

DROP TABLE IF EXISTS `FACTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FACTIONS` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FACTIONS`
--

LOCK TABLES `FACTIONS` WRITE;
/*!40000 ALTER TABLE `FACTIONS` DISABLE KEYS */;
/*!40000 ALTER TABLE `FACTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYABLE_CLASSES`
--

DROP TABLE IF EXISTS `PLAYABLE_CLASSES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLAYABLE_CLASSES` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `MEDIA_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYABLE_CLASSES`
--

LOCK TABLES `PLAYABLE_CLASSES` WRITE;
/*!40000 ALTER TABLE `PLAYABLE_CLASSES` DISABLE KEYS */;
/*!40000 ALTER TABLE `PLAYABLE_CLASSES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYABLE_RACES`
--

DROP TABLE IF EXISTS `PLAYABLE_RACES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLAYABLE_RACES` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `FACTION_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FACTION_ID` (`FACTION_ID`),
  CONSTRAINT `FK_FACTION_ID` FOREIGN KEY (`FACTION_ID`) REFERENCES `FACTIONS` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYABLE_RACES`
--

LOCK TABLES `PLAYABLE_RACES` WRITE;
/*!40000 ALTER TABLE `PLAYABLE_RACES` DISABLE KEYS */;
/*!40000 ALTER TABLE `PLAYABLE_RACES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAYABLE_SPECIALIZATIONS`
--

DROP TABLE IF EXISTS `PLAYABLE_SPECIALIZATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLAYABLE_SPECIALIZATIONS` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `MEDIA_URL` varchar(255) DEFAULT NULL,
  `PLAYABLE_CLASS_ID` int DEFAULT NULL,
  `SPECIALIZATION_ROLE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PLAYABLE_CLASS_ID` (`PLAYABLE_CLASS_ID`),
  KEY `FK_SPECIALIZATION_ROLE_ID` (`SPECIALIZATION_ROLE_ID`),
  CONSTRAINT `FK_PLAYABLE_CLASS_ID` FOREIGN KEY (`PLAYABLE_CLASS_ID`) REFERENCES `PLAYABLE_CLASSES` (`ID`),
  CONSTRAINT `FK_SPECIALIZATION_ROLE_ID` FOREIGN KEY (`SPECIALIZATION_ROLE_ID`) REFERENCES `SPECIALIZATION_ROLES` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAYABLE_SPECIALIZATIONS`
--

LOCK TABLES `PLAYABLE_SPECIALIZATIONS` WRITE;
/*!40000 ALTER TABLE `PLAYABLE_SPECIALIZATIONS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PLAYABLE_SPECIALIZATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REALMS`
--

DROP TABLE IF EXISTS `REALMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REALMS` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `LOCALE` varchar(255) NOT NULL,
  `SLUG` varchar(255) NOT NULL,
  `TIMEZONE` varchar(255) NOT NULL,
  `REALM_CATEGORY_ID` int DEFAULT NULL,
  `REALM_TYPE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_SLUG` (`SLUG`),
  KEY `FK_REALM_CATEGORY_ID` (`REALM_CATEGORY_ID`),
  KEY `FK_REALM_TYPE_ID` (`REALM_TYPE_ID`),
  CONSTRAINT `FK_REALM_CATEGORY_ID` FOREIGN KEY (`REALM_CATEGORY_ID`) REFERENCES `REALM_CATEGORY` (`ID`),
  CONSTRAINT `FK_REALM_TYPE_ID` FOREIGN KEY (`REALM_TYPE_ID`) REFERENCES `REALM_TYPE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REALMS`
--

LOCK TABLES `REALMS` WRITE;
/*!40000 ALTER TABLE `REALMS` DISABLE KEYS */;
/*!40000 ALTER TABLE `REALMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REALM_CATEGORY`
--

DROP TABLE IF EXISTS `REALM_CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REALM_CATEGORY` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `SLUG` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_SLUG` (`SLUG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REALM_CATEGORY`
--

LOCK TABLES `REALM_CATEGORY` WRITE;
/*!40000 ALTER TABLE `REALM_CATEGORY` DISABLE KEYS */;
/*!40000 ALTER TABLE `REALM_CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REALM_TYPE`
--

DROP TABLE IF EXISTS `REALM_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REALM_TYPE` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REALM_TYPE`
--

LOCK TABLES `REALM_TYPE` WRITE;
/*!40000 ALTER TABLE `REALM_TYPE` DISABLE KEYS */;
/*!40000 ALTER TABLE `REALM_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SPECIALIZATION_ROLES`
--

DROP TABLE IF EXISTS `SPECIALIZATION_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SPECIALIZATION_ROLES` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) DEFAULT NULL,
  `EN_GB` varchar(255) DEFAULT NULL,
  `EN_US` varchar(255) DEFAULT NULL,
  `ES_ES` varchar(255) DEFAULT NULL,
  `ES_MX` varchar(255) DEFAULT NULL,
  `FR_FR` varchar(255) DEFAULT NULL,
  `IT_IT` varchar(255) DEFAULT NULL,
  `KO_KR` varchar(255) DEFAULT NULL,
  `PT_BR` varchar(255) DEFAULT NULL,
  `RU_RU` varchar(255) DEFAULT NULL,
  `ZH_CN` varchar(255) DEFAULT NULL,
  `ZH_TW` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPECIALIZATION_ROLES`
--

LOCK TABLES `SPECIALIZATION_ROLES` WRITE;
/*!40000 ALTER TABLE `SPECIALIZATION_ROLES` DISABLE KEYS */;
/*!40000 ALTER TABLE `SPECIALIZATION_ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-12 13:16:54
