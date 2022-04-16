SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `wow_companion_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `wow_companion_db`;

CREATE TABLE `COVENANT` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MEDIA_URL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `FACTIONS` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TYPE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `PLAYABLE_CLASSES` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MEDIA_URL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `PLAYABLE_RACES` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FACTION_ID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `PLAYABLE_SPECIALIZATIONS` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MEDIA_URL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PLAYABLE_CLASS_ID` int DEFAULT NULL,
  `SPECIALIZATION_ROLE_ID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `REALMS` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `LOCALE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SLUG` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TIMEZONE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `REALM_CATEGORY_ID` int DEFAULT NULL,
  `REALM_TYPE_ID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `REALM_CATEGORY` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `SLUG` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `REALM_TYPE` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TYPE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `SPECIALIZATION_ROLES` (
  `ID` int NOT NULL,
  `DE_DE` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_GB` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `EN_US` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_ES` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ES_MX` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `FR_FR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IT_IT` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `KO_KR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PT_BR` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RU_RU` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_CN` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ZH_TW` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TYPE` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `USER_ACCOUNT` (
  `BLIZZARD_ID` int NOT NULL,
  `BATTLE_TAG` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CREATION_INSTANT` datetime NOT NULL,
  `EMAIL` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IS_ADMIN` bit(1) NOT NULL,
  `LAST_LOGIN_INSTANT` datetime NOT NULL,
  `USER_NAME` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


ALTER TABLE `FACTIONS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_TYPE` (`TYPE`);

ALTER TABLE `PLAYABLE_CLASSES`
  ADD PRIMARY KEY (`ID`);

ALTER TABLE `PLAYABLE_RACES`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_FACTION_ID` (`FACTION_ID`);

ALTER TABLE `PLAYABLE_SPECIALIZATIONS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PLAYABLE_CLASS_ID` (`PLAYABLE_CLASS_ID`),
  ADD KEY `FK_SPECIALIZATION_ROLE_ID` (`SPECIALIZATION_ROLE_ID`);

ALTER TABLE `REALMS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_SLUG` (`SLUG`),
  ADD KEY `FK_REALM_CATEGORY_ID` (`REALM_CATEGORY_ID`),
  ADD KEY `FK_REALM_TYPE_ID` (`REALM_TYPE_ID`);

ALTER TABLE `REALM_CATEGORY`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_SLUG` (`SLUG`);

ALTER TABLE `REALM_TYPE`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_TYPE` (`TYPE`);

ALTER TABLE `SPECIALIZATION_ROLES`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_TYPE` (`TYPE`);

ALTER TABLE `USER_ACCOUNT`
  ADD PRIMARY KEY (`BLIZZARD_ID`),
  ADD UNIQUE KEY `UK_BATTLE_TAG` (`BATTLE_TAG`),
  ADD UNIQUE KEY `UK_EMAIL` (`EMAIL`),
  ADD UNIQUE KEY `UK_USER_NAME` (`USER_NAME`);


ALTER TABLE `PLAYABLE_RACES`
  ADD CONSTRAINT `FK_FACTION_ID` FOREIGN KEY (`FACTION_ID`) REFERENCES `FACTIONS` (`ID`);

ALTER TABLE `PLAYABLE_SPECIALIZATIONS`
  ADD CONSTRAINT `FK_PLAYABLE_CLASS_ID` FOREIGN KEY (`PLAYABLE_CLASS_ID`) REFERENCES `PLAYABLE_CLASSES` (`ID`),
  ADD CONSTRAINT `FK_SPECIALIZATION_ROLE_ID` FOREIGN KEY (`SPECIALIZATION_ROLE_ID`) REFERENCES `SPECIALIZATION_ROLES` (`ID`);

ALTER TABLE `REALMS`
  ADD CONSTRAINT `FK_REALM_CATEGORY_ID` FOREIGN KEY (`REALM_CATEGORY_ID`) REFERENCES `REALM_CATEGORY` (`ID`),
  ADD CONSTRAINT `FK_REALM_TYPE_ID` FOREIGN KEY (`REALM_TYPE_ID`) REFERENCES `REALM_TYPE` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
