﻿-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema CELINE
--
DROP DATABASE IF EXISTS CELINE ;
CREATE DATABASE CELINE;
USE CELINE;

--
-- Definition of table `COURSES`
--

DROP TABLE IF EXISTS `COURSES`;
CREATE TABLE  `COURSES` (
  `ID_COURSE` int(10) unsigned NOT NULL auto_increment,
  `DS_COURSE` varchar(100) NOT NULL,
  `DS_ID` varchar(100) NOT NULL,
  `DS_TITLE` varchar(100) NOT NULL,
  `DS_DERIVED` tinyint(1) unsigned NOT NULL,
  `DS_REMOVED` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY  (`ID_COURSE`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
--
-- Dumping data for table `COURSES`
--

/*!40000 ALTER TABLE `COURSES` DISABLE KEYS */;
/*!40000 ALTER TABLE `COURSES` ENABLE KEYS */;


--
-- Definition of table `COURSESUSERS`
--

DROP TABLE IF EXISTS `COURSESUSERS`;
CREATE TABLE `COURSESUSERS` (
  `ID_USER` int(10) unsigned NOT NULL,
  `ID_COURSE` int(10) unsigned NOT NULL,
  `ID_SUSPENDEDACTIVITY` varchar(4000) DEFAULT NULL,
  `DS_SUSPENDEDDATA` mediumtext,
  PRIMARY KEY (`ID_USER`,`ID_COURSE`),
  KEY `FK_COURSESUSERS_1` (`ID_COURSE`),
  CONSTRAINT `FK_COURSESUSERS_1` FOREIGN KEY (`ID_COURSE`) REFERENCES `courses` (`ID_COURSE`),
  CONSTRAINT `FK_COURSESUSERS_2` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `COURSESUSERS`
--

/*!40000 ALTER TABLE `COURSESUSERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `COURSESUSERS` ENABLE KEYS */;


--
-- Definition of table `TMACTIVITIES`
--

DROP TABLE IF EXISTS `TMACTIVITIES`;
CREATE TABLE  `TMACTIVITIES` (
  `ID_USER` int(10) unsigned NOT NULL,
  `ID_COURSE` int(10) unsigned NOT NULL,
  `ID_ACTIVITY` varchar(4000) NOT NULL,
  `BOOL_PROGRESSSTATUS` tinyint(1) NOT NULL,
  `VL_ABSOLUTEDURATION` double NOT NULL,
  `VL_EXPERIENCEDDURATION` double NOT NULL,
  `VL_ATTEMPTCOUNT` int(10) unsigned NOT NULL,
  `BOOL_SUSPENDED` tinyint(1) NOT NULL,
  `ID_PARENTACTIVITY` varchar(4000) default NULL,
  `IDX_CHILDREN` int(10) unsigned default NULL,
  `BOOL_ATTEMPTCOMPLETIONSTATUS` tinyint(1) NOT NULL,
  `BOOL_ATTEMPTPROGRESSSTATUS` tinyint(1) NOT NULL,
  `VL_SCORERAW` double default '0',
  `VL_SCORESCALED` double default NULL,
  `VL_SCOREMIN` double default NULL,
  `VL_SCOREMAX` double default NULL,
  CONSTRAINT `FK_TMACTIVITIES_1` FOREIGN KEY (`ID_USER`, `ID_COURSE`) REFERENCES `COURSESUSERS` (`ID_USER`, `ID_COURSE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Dumping data for table `TMACTIVITIES`
--

/*!40000 ALTER TABLE `TMACTIVITIES` DISABLE KEYS */;
/*!40000 ALTER TABLE `TMACTIVITIES` ENABLE KEYS */;


--
-- Definition of table `TMINTERACTIONS`
--

DROP TABLE IF EXISTS `TMINTERACTIONS`;
CREATE TABLE  `TMINTERACTIONS` (
  `ID_USER` int(10) unsigned NOT NULL default '0',
  `ID_COURSE` int(10) unsigned NOT NULL default '0',
  `ID_ACTIVITY` varchar(4000) NOT NULL default '',
  `ID_INTERACTION` varchar(4000) NOT NULL default '',
  `DS_TYPE` char(20) default NULL,
  `DS_TIMESTAMP` char(30) default NULL,
  `NR_WEIGHTING` double default NULL,
  `DS_LEARNERRESPONSE` mediumtext default NULL,
  `DS_RESULT` char(20) default NULL,
  `DS_LATENCY` char(30) default NULL,
  `DS_DESCRIPTION` varchar(300) default NULL,
  `NR_INDEX` int(10) unsigned NOT NULL,
  KEY `FK_TMINTERACTIONS_1` (`ID_USER`,`ID_COURSE`),
  CONSTRAINT `FK_TMINTERACTIONS_1` FOREIGN KEY (`ID_USER`, `ID_COURSE`) REFERENCES `COURSESUSERS` (`ID_USER`, `ID_COURSE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Dumping data for table `TMINTERACTIONS`
--

/*!40000 ALTER TABLE `TMINTERACTIONS` DISABLE KEYS */;
/*!40000 ALTER TABLE `TMINTERACTIONS` ENABLE KEYS */;


--
-- Definition of table `TMOBJECTIVES`
--
DROP TABLE IF EXISTS `TMOBJECTIVES`;
CREATE TABLE  `TMOBJECTIVES` (
  `ID_USER` int(10) unsigned NOT NULL,
  `ID_COURSE` int(10) unsigned NOT NULL,
  `ID_ACTIVITY` varchar(4000) NOT NULL default '',
  `ID_OBJECTIVE` varchar(4000) NOT NULL default '',
  `BOOL_PROGRESSSTATUS` tinyint(1) NOT NULL,
  `BOOL_SATISFIEDSTATUS` tinyint(1) NOT NULL,
  `BOOL_MEASURESTATUS` tinyint(1) NOT NULL,
  `VL_NORMALIZEDMEASURE` double NOT NULL,
  CONSTRAINT `FK_TMOBJECTIVES_1` FOREIGN KEY (`ID_USER`, `ID_COURSE`) REFERENCES `COURSESUSERS` (`ID_USER`, `ID_COURSE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;--
-- Dumping data for table `TMOBJECTIVES`
--

/*!40000 ALTER TABLE `TMOBJECTIVES` DISABLE KEYS */;
/*!40000 ALTER TABLE `TMOBJECTIVES` ENABLE KEYS */;


--
-- Definition of table `USERS`
--
DROP TABLE IF EXISTS `USERS`;
CREATE TABLE  `USERS` (
  `ID_USER` int(10) unsigned NOT NULL auto_increment,
  `DS_NICK` char(15) NOT NULL,
  `DS_PASSW` char(10) NOT NULL,
  `TP_USER` char(1) NOT NULL,
  PRIMARY KEY  (`ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USERS`
--

/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;

DROP TABLE IF EXISTS `REQUESTACTIVITIES`;
CREATE TABLE  `REQUESTACTIVITIES` (
  `ID_USER` int(10) unsigned NOT NULL,
  `ID_COURSE` int(10) unsigned NOT NULL,
  `ID_ACTIVITY` varchar(4000) NOT NULL,
  `VL_ATTEMPT` int(10) unsigned NOT NULL,
  `VL_EXPERIENCEDDURATION` double NOT NULL,
  `DT_LASTTIMEACCESSED` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `USERS` (`ID_USER`,`DS_PASSW`,`DS_NICK`,`TP_USER`) VALUES
  (1, 'adm', 'admin', 'A'),
  (2, '123', 'adilson', 'U');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;