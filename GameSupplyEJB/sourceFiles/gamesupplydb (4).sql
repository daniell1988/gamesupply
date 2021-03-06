-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 06/06/2013 às 18h34min
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
  PRIMARY KEY (`id_address`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Extraindo dados da tabela `address`
--

INSERT INTO `address` (`id_address`, `address`, `address_complement`, `address_description`, `city`, `country`, `phone_number`, `state`, `zip`, `id_customer`) VALUES
(1, 'Rua TrololÃ³', 'APTO 31', 'Casa ', 'Sao Paulo', 'Brazzers', '28293938', 'SP', '39490384', 1),
(2, 'Rua XXX', NULL, 'Trabalho', 'Sao Paulop', 'sjij', '0909', '08', '989', 1),
(3, '2323', '232', '2323', '232', '2323', '2323', '2323', '232', 2),
(18, 'Rua Merda', 'ap12', 'Casa do joÃ?Â£o', '9', '90', '90', '90', '09', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `id_product_item` int(11) NOT NULL,
  `id_costumer` int(11) NOT NULL,
  PRIMARY KEY (`id_product_item`,`id_costumer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `customer`
--

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `customer`
--

INSERT INTO `customer` (`id_customer`, `access_level`, `email`, `first_name`, `last_name`, `mobile_number`, `phone_number`, `user_login`, `user_password`) VALUES
(1, NULL, 'danielo', 'Daniel', 'Gimenez', '999999999', '545445', 'dddaniel', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `id_customer` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `delivery` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `platform`
--

CREATE TABLE IF NOT EXISTS `platform` (
  `id_platform` int(11) NOT NULL AUTO_INCREMENT,
  `platform` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_platform`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `product`
--

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

CREATE TABLE IF NOT EXISTS `wishlist` (
  `id_customer` int(11) NOT NULL,
  `id_product_item` int(11) NOT NULL,
  PRIMARY KEY (`id_customer`,`id_product_item`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
