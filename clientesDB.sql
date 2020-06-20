-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 20, 2020 at 02:15 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `es.seas.u3.ejercicio.feedback.db`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientesDB`
--

CREATE TABLE `clientesDB` (
  `NumeroCliente` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL,
  `apellido1` varchar(20) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL,
  `apellido2` varchar(20) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ascii COMMENT='Tabla donde guardamos los clientes creados';

--
-- Dumping data for table `clientesDB`
--

INSERT INTO `clientesDB` (`NumeroCliente`, `nombre`, `apellido1`, `apellido2`) VALUES
(1, 'Fabio', 'Scarcella', 'Gomez'),
(2, 'Andrea', 'Sánchez', 'Guitierrez'),
(3, 'Carmen', 'Rubio', 'Rubio'),
(4, 'Esteban', 'Díaz', 'Perez'),
(5, 'Pol', 'Hinojosa', 'Carrillo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientesDB`
--
ALTER TABLE `clientesDB`
  ADD PRIMARY KEY (`NumeroCliente`) USING BTREE,
  ADD KEY `intNumeroCliente` (`NumeroCliente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientesDB`
--
ALTER TABLE `clientesDB`
  MODIFY `NumeroCliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
