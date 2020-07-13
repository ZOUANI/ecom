-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2020 at 02:35 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `generated`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `label`) VALUES
(7, 'Phone'),
(8, 'Printer');

-- --------------------------------------------------------

--
-- Table structure for table `category_product`
--

CREATE TABLE `category_product` (
  `id` bigint(20) NOT NULL,
  `category` bigint(20) DEFAULT NULL,
  `product` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `name`, `post_code`) VALUES
(9, 'Agadir', '80000'),
(10, 'Marrakech', '40000'),
(11, 'Casablanca', '22000'),
(19, 'Temara', NULL),
(24, 'Tanger', NULL),
(29, 'Rabat', NULL),
(33, 'Nador', NULL),
(37, 'guelmim', NULL),
(41, 'Tetouane', NULL),
(53, 'Geulmim', NULL),
(57, 'Taroudant', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `city` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `address`, `email`, `first_name`, `last_name`, `phone_number`, `city`) VALUES
(20, NULL, NULL, 'chafiq', 'lakrad', '212617856765', 19),
(25, NULL, NULL, 'Nabil', 'mouslimi', '212614091472', 24),
(30, NULL, NULL, 'Abderrahim', 'ouardighi', '212662772875', 29),
(34, NULL, NULL, 'Noureddine', 'baz', '212677987769', 33),
(38, NULL, NULL, 'lahoucine', 'labras', '212604994642', 37),
(42, NULL, NULL, 'youssef', 'kamil', '212677199355', 41),
(45, NULL, NULL, 'MOHAMED', 'TAYAR', '212640769187', 41),
(50, NULL, NULL, 'KAMAL', 'IDRISI', '212661394201', 19),
(54, NULL, NULL, 'MOHAMED', 'OUAMALO', '212667748420', 53),
(58, NULL, NULL, 'omar', 'elmerabet', '212677808914', 57);

-- --------------------------------------------------------

--
-- Table structure for table `command`
--

CREATE TABLE `command` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `order_date` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `regulation_date` date DEFAULT NULL,
  `remarque` varchar(255) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `city` bigint(20) DEFAULT NULL,
  `client` bigint(20) DEFAULT NULL,
  `delivery` bigint(20) DEFAULT NULL,
  `order_status` bigint(20) DEFAULT NULL,
  `validator` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `command`
--

INSERT INTO `command` (`id`, `address`, `day`, `month`, `order_date`, `reference`, `regulation_date`, `remarque`, `total`, `year`, `city`, `client`, `delivery`, `order_status`, `validator`) VALUES
(22, 'hay oued edahab rue souk larbiaa imm. aziza12 appr devant imm. chemssit 9', 6, 7, '2020-07-05', 'CX1577', '2020-07-06', '', '399.00', 2020, 19, 20, 6, 21, 4),
(26, 'Branes 2 residence sidi moussa appartement8 etage 1', 7, 7, '2020-07-06', 'LT2570', '2020-07-06', '', '299.00', 2020, 24, 25, 12, 21, 4),
(31, '12.RueLarbi Ben Abdallah  Rabat(10H30MIN)', 8, 7, '2020-07-07', 'LT2786', '2020-07-07', '', '299.00', 2020, 29, 30, 6, 13, 4),
(35, 'Nador TAOUINA', 9, 7, '2020-07-08', 'LT2831', '2020-07-08', '18/6: MA3AYAT LIH TA7AD', '299.00', 2020, 33, 34, 12, 15, 4),
(39, 'guelmim RES SAHRA', 10, 7, '2020-07-09', 'LT2851', '2020-07-10', '', '299.00', 2020, 37, 38, 6, 21, 4),
(43, 'bv med 5', 9, 7, '2020-07-08', 'LT2499', '2020-07-08', '', '249.00', 2020, 41, 42, 12, 13, 4),
(46, 'MHANACH 2 BV SEBTA', 10, 7, '2020-07-09', 'CX1507', '2020-07-10', '', '399.00', 2020, 41, 45, 6, 13, 4),
(51, 'BV OMAR BNO KHATAB', 8, 7, '2020-07-07', 'CX1512', '2020-07-09', '', '399.00', 2020, 19, 50, 49, 16, 4),
(55, 'HAY SINA3I', 9, 7, '2020-07-08', 'LT2516', '2020-06-11', '', '249.00', 2020, 53, 54, 12, 14, 4),
(59, 'oulad issa taroudant', 11, 7, '2020-07-10', 'CX1523', '2020-07-11', '', '399.00', 2020, 57, 58, 6, 14, 4);

-- --------------------------------------------------------

--
-- Table structure for table `delivery_cost`
--

CREATE TABLE `delivery_cost` (
  `id` bigint(20) NOT NULL,
  `shipping_cost` decimal(19,2) DEFAULT NULL,
  `city` bigint(20) DEFAULT NULL,
  `delivery` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `delivery_type`
--

CREATE TABLE `delivery_type` (
  `id` bigint(20) NOT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(61),
(61),
(61),
(61),
(61),
(61),
(61),
(61),
(61),
(61),
(61),
(61),
(61);

-- --------------------------------------------------------

--
-- Table structure for table `order_line`
--

CREATE TABLE `order_line` (
  `id` bigint(20) NOT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `qte` decimal(19,2) DEFAULT NULL,
  `command` bigint(20) DEFAULT NULL,
  `product` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_line`
--

INSERT INTO `order_line` (`id`, `price`, `qte`, `command`, `product`) VALUES
(23, '399.00', '1.00', 22, 17),
(28, '299.00', '1.00', 26, 27),
(32, '299.00', '1.00', 31, 27),
(36, '299.00', '1.00', 35, 18),
(40, '299.00', '1.00', 39, 17),
(44, '249.00', '1.00', 43, 27),
(48, '399.00', '1.00', 46, 47),
(52, '399.00', '1.00', 51, 47),
(56, '249.00', '1.00', 55, 27),
(60, '399.00', '1.00', 59, 18);

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_status`
--

INSERT INTO `order_status` (`id`, `label`) VALUES
(13, 'confirmed'),
(14, 'closed'),
(15, 'returned'),
(16, 'processed'),
(21, 'Refused');

-- --------------------------------------------------------

--
-- Table structure for table `package_status`
--

CREATE TABLE `package_status` (
  `id` bigint(20) NOT NULL,
  `label` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `qte_stock` int(11) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `weight` decimal(19,2) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `color`, `label`, `price`, `qte_stock`, `reference`, `size`, `weight`) VALUES
(17, 'Black', 'LG Q6', '1000.00', 500, 'LGXXCF76', '56', '0.50'),
(18, 'Gold', 'Samsung Galaxy s10', '1400.00', 850, 'SAMHGCF87', '47', '0.40'),
(27, NULL, 'Pare-Brise Pare-Soleil', NULL, NULL, NULL, NULL, NULL),
(47, NULL, 'FRESHPACK-PRO', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `authority`) VALUES
(1, 'Admin'),
(3, 'Validator'),
(5, 'Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `authority` bigint(20) DEFAULT NULL,
  `city` bigint(20) DEFAULT NULL,
  `delivery_type` bigint(20) DEFAULT NULL,
  `super_admin` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `code`, `created`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone_number`, `authority`, `city`, `delivery_type`, `super_admin`) VALUES
(2, 'admin1', NULL, 'admin@gmail.com', b'1', 'adminFirst', 'adminLast', '$2a$10$54McHJIlxPGxOR.UYEW7iekDb/0eW0xrcK6oLhn8.Lo0mElkwf8hi', NULL, 1, NULL, NULL, NULL),
(4, 'validator1', NULL, 'validator@gmail.com', b'1', 'Younes', 'ABRA', '$2a$10$zVjSow8Ypikn5V5yG4YWtOwUMlBvYU3JbS.pa8fYL5ezFhBHawhFe', NULL, 3, NULL, NULL, NULL),
(6, 'Amana', NULL, 'delivery@gmail.com', b'1', 'Amana', 'Amana', '$2a$10$O9fj1nblleh9yyotW.J68eJOmqPJMA0jZJuW9J3VefpPygPkrJFd.', NULL, 5, 10, NULL, NULL),
(12, 'DHL', NULL, 'delivery2@gmail.com', b'1', 'DHL', 'DHL', '$2a$10$O9fj1nblleh9yyotW.J68eJOmqPJMA0jZJuW9J3VefpPygPkrJFd.', NULL, 5, 9, NULL, NULL),
(49, 'FastBox', '2020-07-12', NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category_product`
--
ALTER TABLE `category_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3vidvmo4dm428sja3d6ucjlr6` (`category`),
  ADD KEY `FK2kprsishy69iw1bw262itfi06` (`product`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3muajrdo22hvnvirpb7x3ap9b` (`city`);

--
-- Indexes for table `command`
--
ALTER TABLE `command`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK66q035m1kido7n7i7hnbm5w1j` (`city`),
  ADD KEY `FKn5hrlyqk9jn6b2gws2criryxt` (`client`),
  ADD KEY `FKhi7maaoxn52098rn4il8bcslc` (`delivery`),
  ADD KEY `FKsdr1o28qaohbaox4785k2psbo` (`order_status`),
  ADD KEY `FKc0ws5o11m87k58gu457lgtq5o` (`validator`);

--
-- Indexes for table `delivery_cost`
--
ALTER TABLE `delivery_cost`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmq66obj80e9xqb9bnm20qanpj` (`city`),
  ADD KEY `FK3e67j1opr4f7b3p5xwj9jf1hk` (`delivery`);

--
-- Indexes for table `delivery_type`
--
ALTER TABLE `delivery_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_line`
--
ALTER TABLE `order_line`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7j35h1jer9ukjnaei8fh000gn` (`command`),
  ADD KEY `FK863a744knr50mljrji0krsko` (`product`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `package_status`
--
ALTER TABLE `package_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9sygk50fpevfts5boo80e1xas` (`authority`),
  ADD KEY `FKeal5g2o4amn2om6d2t00o9nqb` (`city`),
  ADD KEY `FK2ebgghw7yhg7ougf2ouywq69a` (`delivery_type`),
  ADD KEY `FKjjmn9ifcp4sxxya3s18bf5ffy` (`super_admin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
