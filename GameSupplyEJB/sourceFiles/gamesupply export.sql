-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 29/05/2013 às 20h40min
-- Versão do Servidor: 5.5.16
-- Versão do PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `gamesupplydb`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id_address` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `address_complement` varchar(255) DEFAULT NULL,
  `address_description` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `id_customer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_address`),
  KEY `FK_address_id_customer` (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id_product_item` int(11) NOT NULL,
  `id_costumer` int(11) NOT NULL,
  PRIMARY KEY (`id_product_item`,`id_costumer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `access_level` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_login` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `platform`
--

DROP TABLE IF EXISTS `platform`;
CREATE TABLE IF NOT EXISTS `platform` (
  `id_platform` int(11) NOT NULL AUTO_INCREMENT,
  `platform` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_platform`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `product`
--

INSERT INTO `product` (`id_product`, `description`, `genre`, `name`, `platform`, `price`, `type`) VALUES
(2, 'oi oi oi', 'Ação', '45', '3DS', 988.77, 'Acessório'),
(3, '34878', 'Ação', '343', '3DS', 3.98, 'Acessório'),
(4, '090977', 'Ação', '666', '3DS', 300990, 'Acessório'),
(5, '11111', 'Ação', 'Tomb Raids', '3DS', 1212, 'Acessório'),
(6, '13131331', 'Ação', '3113', '3DS', 3113, 'Jogo'),
(7, '97900', 'Ação', '7897', '3DS', 9779, 'Acessório'),
(8, '5544', 'Ação', '45', '3DS', 454, 'Acessório'),
(9, 'LoL', 'Ação', 'Tomb Raids', '3DS', 199, 'Acessório'),
(10, '2121212', 'Aventura', 'Jogo Maluco', 'GameCube', 99, 'Jogo'),
(11, 'André Mosca Dornelas', 'Luta', 'O Mosca', 'Wii', 0, 'Console'),
(12, 'j2j2j', 'Ação', 'Joguuen', '3DS', 1.22, 'Acessório'),
(13, 'Bals ajski djksdj kjedfijkj djdjipsdipjd  jj\nodvojdfjosj\no´sdjosdjo\nsdok\nsdkkokook\ndddfdf', 'Luta', 'Zézinho Adventures', 'Playstation 3', 9.99, 'Jogo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sale`
--

DROP TABLE IF EXISTS `sale`;
CREATE TABLE IF NOT EXISTS `sale` (
  `id_sale` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `sale_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `branch` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sale`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Extraindo dados da tabela `sale`
--

INSERT INTO `sale` (`id_sale`, `name`, `platform`, `type`, `price`, `sale_date`, `branch`, `quantity`) VALUES
(1, '112', '221', '232', '23', NULL, '12', 21),
(2, '3', '23', '3', '32', '2013-05-24 17:55:39', '32', 32),
(3, '7897', '3DS', 'Acessório', '9779.0', NULL, 'Filial A', 1),
(4, '7897', '3DS', 'Acessório', '9779.0', NULL, 'Filial A', 3),
(5, 'Zézinho Adventures', 'Playstation 3', 'Jogo', '9.99', NULL, 'Filial C', 1),
(6, '1212', '1212', '1212', '121', '2013-05-28 16:40:02', '12', 12),
(7, 'BIBI', 'PLAT', NULL, NULL, NULL, NULL, NULL),
(8, 'BIBI', 'PLAT', NULL, NULL, '2013-05-28 16:43:56', NULL, NULL),
(9, '45', '3DS', 'Acessório', '454.0', NULL, 'Filial A', 9),
(10, 'O Mosca', 'Wii', 'Console', '0.0', NULL, 'Filial A', 66),
(11, 'O Mosca', 'Wii', 'Console', '0.0', '2013-05-28 17:00:49', 'Filial A', 2),
(12, 'O Mosca', 'Wii', 'Console', '0.0', '2013-05-28 17:03:43', 'Filial A', 3),
(13, '3113', '3DS', 'Jogo', '3113.0873', '2013-05-28 17:04:17', 'Filial A', 873),
(14, '3113', '3DS', 'Jogo', '3113.0873', '2013-05-28 17:15:48', 'Filial A', 1),
(15, 'O Mosca', 'Wii', 'Console', '0.0', '2013-05-28 17:18:54', 'Filial A', 1),
(16, '45', '3DS', 'Acessório', '454.0', '2013-05-28 17:22:27', 'Filial A', 1),
(17, '45', '3DS', 'Acessório', '454.0', '2013-05-28 17:22:43', 'Filial A', 1),
(18, '3113', '3DS', 'Jogo', '3113.0873', '2013-05-28 17:33:12', 'Filial A', 1),
(19, '1111', '3DS', NULL, '11111.0', '2013-05-28 17:34:16', 'Filial A', 1),
(20, '3113', '3DS', 'Jogo', '3113.0873', '2013-05-28 17:35:07', 'Filial A', 1),
(21, '45', '3DS', 'Acessório', '454.0', '2013-05-28 17:37:52', 'Filial A', 1),
(22, '1111', '3DS', NULL, '11111.0', '2013-05-28 17:38:39', 'Filial A', 1),
(23, '1111', '3DS', NULL, '11111.0', '2013-05-28 17:38:46', 'Filial A', 1),
(24, '45', '3DS', 'Acessório', '454.0', '2013-05-28 17:39:17', 'Filial A', 1),
(25, '1111', '3DS', NULL, '11111.0', '2013-05-28 17:43:22', 'Filial A', 1),
(26, '3113', '3DS', 'Jogo', '3113.0873', '2013-05-28 18:01:43', 'Filial A', 1),
(27, 'O Mosca', 'Wii', 'Console', '0.0', '2013-05-29 13:40:34', 'Filial A', 2),
(28, '7897', '3DS', 'Acessório', '9779.0', '2013-05-29 18:30:02', 'Filial A', 18);

-- --------------------------------------------------------

--
-- Estrutura da tabela `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `branch1` int(11) DEFAULT '0',
  `branch2` int(11) DEFAULT '0',
  `branch3` int(11) DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `stock`
--

INSERT INTO `stock` (`id_product`, `branch1`, `branch2`, `branch3`, `description`, `genre`, `name`, `platform`, `price`, `type`) VALUES
(1, 87, 2, 15, '53', 'Ação', '45', '3DS', 54, NULL),
(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 894, 0, 0, '11111', 'Ação', '1111', '3DS', 11111, NULL),
(6, 7996, 0, 22, '13131331', 'Ação', '3113', '3DS', 3113.0873, 'Jogo'),
(7, 52, 0, 7, '9797', 'Ação', '7897', '3DS', 9779, 'Acessório'),
(8, 0, 7, 0, '5544', 'Ação', '45', '3DS', 454, 'Acessório'),
(9, 0, 0, 0, 'LoL', 'Ação', 'Tomb Raids', '3DS', 199, 'Acessório'),
(10, 0, 0, 0, '2121212', 'Aventura', 'Jogo Maluco', 'GameCube', 99, 'Jogo'),
(11, 0, 0, 0, 'André Mosca Dornelas', 'Luta', 'O Mosca', 'Wii', 0, 'Console'),
(12, 76, 0, 0, '5544', 'Ação', '45', '3DS', 454, 'Acessório'),
(13, 0, 0, 0, 'André Mosca Dornelas', 'Luta', 'O Mosca', 'Wii', 0, 'Console'),
(14, 227, 0, 0, 'André Mosca Dornelas', 'Luta', 'O Mosca', 'Wii', 0, 'Console'),
(15, 0, 0, 0, 'j2j2j', 'Ação', 'Joguuen', '3DS', 1.22, 'Acessório'),
(16, 0, 0, 9, 'Bals ajski djksdj kjedfijkj djdjipsdipjd  jj\nodvojdfjosj\no´sdjosdjo\nsdok\nsdkkokook\ndddfdf', 'Luta', 'Zézinho Adventures', 'Playstation 3', 9.99, 'Jogo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE IF NOT EXISTS `wishlist` (
  `id_customer` int(11) NOT NULL,
  `id_product_item` int(11) NOT NULL,
  PRIMARY KEY (`id_customer`,`id_product_item`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `FK_address_id_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
