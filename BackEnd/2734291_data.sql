-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: fdb21.awardspace.net
-- Generation Time: Sep 30, 2020 at 05:45 AM
-- Server version: 5.7.20-log
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2734291_data`
--
CREATE DATABASE IF NOT EXISTS `2734291_data` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `2734291_data`;

-- --------------------------------------------------------

--
-- Table structure for table `app`
--

DROP TABLE IF EXISTS `app`;
CREATE TABLE IF NOT EXISTS `app` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `sender` varchar(30) NOT NULL,
  `receiver` varchar(30) NOT NULL,
  `data` varchar(500) NOT NULL,
  PRIMARY KEY (`id`,`sender`,`receiver`,`data`)
) ENGINE=MEMORY AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `app`
--

TRUNCATE TABLE `app`;
--
-- Dumping data for table `app`
--

INSERT DELAYED IGNORE INTO `app` (`id`, `sender`, `receiver`, `data`) VALUES
(15, 'somu', 'prskid', 'hi~'),
(14, 'somu', 'prskid', 'list'),
(13, 'prskid', 'somu', 'list');

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

DROP TABLE IF EXISTS `auth`;
CREATE TABLE IF NOT EXISTS `auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` varchar(30) NOT NULL,
  `first` varchar(30) NOT NULL,
  `last` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  PRIMARY KEY (`id`) USING HASH,
  UNIQUE KEY `user` (`user`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `auth`
--

TRUNCATE TABLE `auth`;
--
-- Dumping data for table `auth`
--

INSERT DELAYED IGNORE INTO `auth` (`id`, `user`, `first`, `last`, `email`, `pass`) VALUES
(33, '1111', 'nhensg', 'Vmdv dg', 'Dvv. db. ', '1111');

-- --------------------------------------------------------

--
-- Table structure for table `commenttable`
--

DROP TABLE IF EXISTS `commenttable`;
CREATE TABLE IF NOT EXISTS `commenttable` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `author` varchar(30) NOT NULL,
  `title` varchar(30) NOT NULL,
  `commenter` varchar(30) NOT NULL,
  `comment` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `commenttable`
--

TRUNCATE TABLE `commenttable`;
--
-- Dumping data for table `commenttable`
--

INSERT DELAYED IGNORE INTO `commenttable` (`id`, `author`, `title`, `commenter`, `comment`) VALUES
(23, 'prskid', 'What is atom?', 'prskid', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `posttable`
--

DROP TABLE IF EXISTS `posttable`;
CREATE TABLE IF NOT EXISTS `posttable` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `author` varchar(30) NOT NULL,
  `title` varchar(30) NOT NULL,
  `post` varchar(500) NOT NULL,
  `ptime` time NOT NULL,
  `pdate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `posttable`
--

TRUNCATE TABLE `posttable`;
--
-- Dumping data for table `posttable`
--

INSERT DELAYED IGNORE INTO `posttable` (`id`, `author`, `title`, `post`, `ptime`, `pdate`) VALUES
(19, 'prskid', 'What is atom?', 'Needed a definition of atom', '16:23:02', '2019-02-13');

-- --------------------------------------------------------

--
-- Table structure for table `touch_auth`
--

DROP TABLE IF EXISTS `touch_auth`;
CREATE TABLE IF NOT EXISTS `touch_auth` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  UNIQUE KEY `uid` (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `touch_auth`
--

TRUNCATE TABLE `touch_auth`;
--
-- Dumping data for table `touch_auth`
--

INSERT DELAYED IGNORE INTO `touch_auth` (`uid`, `userid`, `password`) VALUES
(28, 'prskid', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `touch_data`
--

DROP TABLE IF EXISTS `touch_data`;
CREATE TABLE IF NOT EXISTS `touch_data` (
  `uid` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `phone` varchar(50) NOT NULL,
  `batch` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  UNIQUE KEY `uid` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `touch_data`
--

TRUNCATE TABLE `touch_data`;
--
-- Dumping data for table `touch_data`
--

INSERT DELAYED IGNORE INTO `touch_data` (`uid`, `name`, `phone`, `batch`, `company`, `email`) VALUES
(28, 'Prithwiraj', '6204570243', '2018', 'HOG', 'prskid1000@gmail.com');
--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth`
--
ALTER TABLE `auth` ADD FULLTEXT KEY `first` (`first`);
ALTER TABLE `auth` ADD FULLTEXT KEY `last` (`last`);
ALTER TABLE `auth` ADD FULLTEXT KEY `pass` (`pass`);

--
-- Indexes for table `commenttable`
--
ALTER TABLE `commenttable` ADD FULLTEXT KEY `author` (`author`);
ALTER TABLE `commenttable` ADD FULLTEXT KEY `title` (`title`);
ALTER TABLE `commenttable` ADD FULLTEXT KEY `commenter` (`commenter`);
ALTER TABLE `commenttable` ADD FULLTEXT KEY `comment` (`comment`);

--
-- Indexes for table `posttable`
--
ALTER TABLE `posttable` ADD FULLTEXT KEY `author` (`author`);
ALTER TABLE `posttable` ADD FULLTEXT KEY `title` (`title`);
ALTER TABLE `posttable` ADD FULLTEXT KEY `post` (`post`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
