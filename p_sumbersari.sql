-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2019 at 08:39 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `p_sumbersari`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(64) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
('868c607a4a1460ff77da8f4fd7507d7dc7c5933de4b3e2f35f53c1b163ab2d21', 'dragneel', '3108');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `pas_index` varchar(20) NOT NULL,
  `pas_nik` varchar(20) NOT NULL,
  `pas_nama` varchar(30) NOT NULL,
  `pas_kk` varchar(30) NOT NULL,
  `pas_alamat` text NOT NULL,
  `pas_telepon` varchar(15) NOT NULL,
  `pas_lahir` varchar(12) NOT NULL,
  `pas_agama` varchar(10) NOT NULL,
  `pas_pendidikan` varchar(20) NOT NULL,
  `pas_kelamin` varchar(11) NOT NULL,
  `pas_darah` varchar(2) NOT NULL,
  `pas_pekerjaan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`pas_index`, `pas_nik`, `pas_nama`, `pas_kk`, `pas_alamat`, `pas_telepon`, `pas_lahir`, `pas_agama`, `pas_pendidikan`, `pas_kelamin`, `pas_darah`, `pas_pekerjaan`) VALUES
('IN110661101', '3510130312970001', 'Ady Bagus Sugih Susanto', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '082232567731', '12/03/1997', 'Islam', 'Sarjana', 'Laki - Laki', 'O', 'Polri'),
('IN110661102', '3510136306000002', 'Lita Putri Ayu Lestari', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '082232567731', '06/23/2000', 'Islam', 'Sarjana', 'Perempuan', 'S', 'TNI'),
('IN110661103', '3510130607690002', 'Yulianto', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5', '082232567731', '07/06/1969', 'Islam', 'Sarjana', 'Laki - Laki', 'O', 'TNI');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`pas_index`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
