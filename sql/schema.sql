-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : mysql
-- Généré le : mer. 20 avr. 2022 à 15:15
-- Version du serveur : 8.0.28
-- Version de PHP : 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `wow_companion_db`
--
CREATE DATABASE IF NOT EXISTS `wow_companion_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `wow_companion_db`;

-- --------------------------------------------------------

--
-- Structure de la table `CHARACTERS`
--

CREATE TABLE `CHARACTERS` (
  `ID` int NOT NULL,
  `AVERAGE_ITEM_LEVEL` int DEFAULT NULL,
  `EQUIPPED_ITEM_LEVEL` int DEFAULT NULL,
  `IS_ACTIVE` bit(1) DEFAULT NULL,
  `IS_FAVORITE` bit(1) DEFAULT NULL,
  `LAST_LOGIN_TIMESTAMP` bigint DEFAULT NULL,
  `LEVEL` int DEFAULT NULL,
  `MEDIA_AVATAR_URL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MEDIA_INSET_URL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MEDIA_MAIN_URL` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `RENOWN_LEVEL` int DEFAULT NULL,
  `COVENANT_ID` int DEFAULT NULL,
  `GUILD_ID` int DEFAULT NULL,
  `GUILD_RANK_ID` int DEFAULT NULL,
  `MAIN_PLAYABLE_SPECIALIZATION_ID` int DEFAULT NULL,
  `PLAYABLE_CLASS_ID` int DEFAULT NULL,
  `PLAYABLE_RACE_ID` int DEFAULT NULL,
  `REALM_ID` int DEFAULT NULL,
  `USER_ACCOUNT_ID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `COVENANT`
--

CREATE TABLE `COVENANT` (
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

-- --------------------------------------------------------

--
-- Structure de la table `FACTIONS`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `GUILDS`
--

CREATE TABLE `GUILDS` (
  `ID` int NOT NULL,
  `NAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `USE_APPLICATION` bit(1) DEFAULT NULL,
  `FACTION_ID` int DEFAULT NULL,
  `REALM_ID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `GUILD_RANKS`
--

CREATE TABLE `GUILD_RANKS` (
  `ID` int NOT NULL,
  `NAME` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `GUILD_RANK` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `PLAYABLE_CLASSES`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `PLAYABLE_RACES`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `PLAYABLE_SPECIALIZATIONS`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `REALMS`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `REALM_CATEGORY`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `REALM_TYPE`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `SPECIALIZATION_ROLES`
--

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

-- --------------------------------------------------------

--
-- Structure de la table `USER_ACCOUNT`
--

CREATE TABLE `USER_ACCOUNT` (
  `BLIZZARD_ID` int NOT NULL,
  `BATTLE_TAG` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CREATION_INSTANT` datetime NOT NULL,
  `EMAIL` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IS_ADMIN` bit(1) NOT NULL,
  `LAST_LOGIN_INSTANT` datetime NOT NULL,
  `USER_NAME` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `CHARACTERS`
--
ALTER TABLE `CHARACTERS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKlfmxp2imrotqs02r312473dj7` (`COVENANT_ID`),
  ADD KEY `FK81mb8xudfwnt3pfsg8n2xict` (`GUILD_ID`),
  ADD KEY `FKhu2ubby85vp38eff50jlu3vv2` (`GUILD_RANK_ID`),
  ADD KEY `FKiy575kv3fagjncvufjkadmggc` (`MAIN_PLAYABLE_SPECIALIZATION_ID`),
  ADD KEY `FK1waptb5463xrawi5vd1qa40jc` (`PLAYABLE_CLASS_ID`),
  ADD KEY `FK24t2si16hjyr1a6rifypkmspf` (`PLAYABLE_RACE_ID`),
  ADD KEY `FKrg2q8frb9768dltvrcepq2wt1` (`REALM_ID`),
  ADD KEY `FKaj31msaiobnppeetkmcdcsomy` (`USER_ACCOUNT_ID`);

--
-- Index pour la table `COVENANT`
--
ALTER TABLE `COVENANT`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `FACTIONS`
--
ALTER TABLE `FACTIONS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_TYPE` (`TYPE`);

--
-- Index pour la table `GUILDS`
--
ALTER TABLE `GUILDS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKnsx4lvrdhk0xykm96swyhe64x` (`FACTION_ID`),
  ADD KEY `FKbc8b0f0npxdtaid7u7n8hralb` (`REALM_ID`);

--
-- Index pour la table `GUILD_RANKS`
--
ALTER TABLE `GUILD_RANKS`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `PLAYABLE_CLASSES`
--
ALTER TABLE `PLAYABLE_CLASSES`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `PLAYABLE_RACES`
--
ALTER TABLE `PLAYABLE_RACES`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_FACTION_ID` (`FACTION_ID`);

--
-- Index pour la table `PLAYABLE_SPECIALIZATIONS`
--
ALTER TABLE `PLAYABLE_SPECIALIZATIONS`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PLAYABLE_CLASS_ID` (`PLAYABLE_CLASS_ID`),
  ADD KEY `FK_SPECIALIZATION_ROLE_ID` (`SPECIALIZATION_ROLE_ID`);

--
-- Index pour la table `REALMS`
--
ALTER TABLE `REALMS`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_SLUG` (`SLUG`),
  ADD KEY `FK_REALM_CATEGORY_ID` (`REALM_CATEGORY_ID`),
  ADD KEY `FK_REALM_TYPE_ID` (`REALM_TYPE_ID`);

--
-- Index pour la table `REALM_CATEGORY`
--
ALTER TABLE `REALM_CATEGORY`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_SLUG` (`SLUG`);

--
-- Index pour la table `REALM_TYPE`
--
ALTER TABLE `REALM_TYPE`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_TYPE` (`TYPE`);

--
-- Index pour la table `SPECIALIZATION_ROLES`
--
ALTER TABLE `SPECIALIZATION_ROLES`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_TYPE` (`TYPE`);

--
-- Index pour la table `USER_ACCOUNT`
--
ALTER TABLE `USER_ACCOUNT`
  ADD PRIMARY KEY (`BLIZZARD_ID`),
  ADD UNIQUE KEY `UK_BATTLE_TAG` (`BATTLE_TAG`),
  ADD UNIQUE KEY `UK_EMAIL` (`EMAIL`),
  ADD UNIQUE KEY `UK_USER_NAME` (`USER_NAME`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `CHARACTERS`
--
ALTER TABLE `CHARACTERS`
  ADD CONSTRAINT `FK1waptb5463xrawi5vd1qa40jc` FOREIGN KEY (`PLAYABLE_CLASS_ID`) REFERENCES `PLAYABLE_CLASSES` (`ID`),
  ADD CONSTRAINT `FK24t2si16hjyr1a6rifypkmspf` FOREIGN KEY (`PLAYABLE_RACE_ID`) REFERENCES `PLAYABLE_RACES` (`ID`),
  ADD CONSTRAINT `FK81mb8xudfwnt3pfsg8n2xict` FOREIGN KEY (`GUILD_ID`) REFERENCES `GUILDS` (`ID`),
  ADD CONSTRAINT `FKaj31msaiobnppeetkmcdcsomy` FOREIGN KEY (`USER_ACCOUNT_ID`) REFERENCES `USER_ACCOUNT` (`BLIZZARD_ID`),
  ADD CONSTRAINT `FKhu2ubby85vp38eff50jlu3vv2` FOREIGN KEY (`GUILD_RANK_ID`) REFERENCES `GUILD_RANKS` (`ID`),
  ADD CONSTRAINT `FKiy575kv3fagjncvufjkadmggc` FOREIGN KEY (`MAIN_PLAYABLE_SPECIALIZATION_ID`) REFERENCES `PLAYABLE_SPECIALIZATIONS` (`ID`),
  ADD CONSTRAINT `FKlfmxp2imrotqs02r312473dj7` FOREIGN KEY (`COVENANT_ID`) REFERENCES `COVENANT` (`ID`),
  ADD CONSTRAINT `FKrg2q8frb9768dltvrcepq2wt1` FOREIGN KEY (`REALM_ID`) REFERENCES `REALMS` (`ID`);

--
-- Contraintes pour la table `GUILDS`
--
ALTER TABLE `GUILDS`
  ADD CONSTRAINT `FKbc8b0f0npxdtaid7u7n8hralb` FOREIGN KEY (`REALM_ID`) REFERENCES `REALMS` (`ID`),
  ADD CONSTRAINT `FKnsx4lvrdhk0xykm96swyhe64x` FOREIGN KEY (`FACTION_ID`) REFERENCES `FACTIONS` (`ID`);

--
-- Contraintes pour la table `PLAYABLE_RACES`
--
ALTER TABLE `PLAYABLE_RACES`
  ADD CONSTRAINT `FK_FACTION_ID` FOREIGN KEY (`FACTION_ID`) REFERENCES `FACTIONS` (`ID`);

--
-- Contraintes pour la table `PLAYABLE_SPECIALIZATIONS`
--
ALTER TABLE `PLAYABLE_SPECIALIZATIONS`
  ADD CONSTRAINT `FK_PLAYABLE_CLASS_ID` FOREIGN KEY (`PLAYABLE_CLASS_ID`) REFERENCES `PLAYABLE_CLASSES` (`ID`),
  ADD CONSTRAINT `FK_SPECIALIZATION_ROLE_ID` FOREIGN KEY (`SPECIALIZATION_ROLE_ID`) REFERENCES `SPECIALIZATION_ROLES` (`ID`);

--
-- Contraintes pour la table `REALMS`
--
ALTER TABLE `REALMS`
  ADD CONSTRAINT `FK_REALM_CATEGORY_ID` FOREIGN KEY (`REALM_CATEGORY_ID`) REFERENCES `REALM_CATEGORY` (`ID`),
  ADD CONSTRAINT `FK_REALM_TYPE_ID` FOREIGN KEY (`REALM_TYPE_ID`) REFERENCES `REALM_TYPE` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
