-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2019 at 10:03 AM
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
  `id_admin` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama`, `username`, `password`, `status`) VALUES
(1, 'Swamedika', 'dragneel', '3108', 'super'),
(6, 'ggwp', 'ggwp', '123', 'non-aktif'),
(7, 'ez', 'ez', '12345', 'admin'),
(8, 'adasd', 'asdasd', 'asdsad', 'non-aktif');

-- --------------------------------------------------------

--
-- Table structure for table `antrian`
--

CREATE TABLE `antrian` (
  `id_antrian` int(11) NOT NULL,
  `nomor_urut` int(5) NOT NULL,
  `pas_index` varchar(20) NOT NULL,
  `pas_nama` varchar(30) NOT NULL,
  `pas_alamat` text NOT NULL,
  `tanggal_antrian` date NOT NULL,
  `nama_poli` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `antrian`
--

INSERT INTO `antrian` (`id_antrian`, `nomor_urut`, `pas_index`, `pas_nama`, `pas_alamat`, `tanggal_antrian`, `nama_poli`, `status`) VALUES
(65, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-05-31', 'Poli Gigi', 'antri'),
(66, 2, 'IN110661102', 'Lita Putri Ayu Lestari', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-05-31', 'Poli Mata', 'antri'),
(67, 3, 'IN110661103', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5', '2019-05-31', 'Poli Umum', 'antri'),
(68, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-05-30', 'Poli Gigi', 'antri'),
(69, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-01', 'Poli Gigi', 'selesai'),
(70, 2, 'IN110661104', 'IN1106611', 'IN1106611', '2019-06-01', 'Poli Mata', 'selesai'),
(71, 3, 'IN110661102', 'Lita Putri Ayu Lestari', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-01', 'Poli Mata', 'selesai'),
(72, 4, 'IN110661103', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-01', 'Poli Mata', 'selesai'),
(73, 5, 'IN110661105', 'IN1106611', 'IN1106611', '2019-06-01', 'Poli Umum', 'selesai'),
(74, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-02', 'Poli Gigi', 'selesai'),
(75, 2, 'IN110661104', 'IN1106611', 'IN1106611', '2019-06-02', 'Poli Mata', 'selesai'),
(76, 3, 'IN110661105', 'IN1106611', 'IN1106611', '2019-06-02', 'Poli Mata', 'selesai'),
(77, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-03', 'Poli Mata', 'selesai'),
(78, 2, 'IN110661102', 'Lita Putri Ayu Lestari', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-03', 'Poli Mata', 'selesai'),
(79, 3, 'IN110661103', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-03', 'Poli Mata', 'selesai'),
(80, 4, 'IN110661105', 'IN1106611', 'IN1106611', '2019-06-03', 'Poli Gigi', 'antri'),
(83, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-04', 'Poli Mata', 'antri'),
(84, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-13', 'Poli Gigi', 'antri'),
(85, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-20', 'Poli Gigi', 'antri'),
(86, 2, 'IN110661104', 'IN1106611', 'IN1106611', '2019-06-20', 'Poli Mata', 'antri'),
(87, 3, 'IN110661102', 'Lita Putri Ayu Lestari', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-20', 'Poli Gigi', 'antri'),
(89, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-21', 'Poli Umum', 'selesai'),
(90, 2, 'IN110661102', 'Lita Putri Ayu Lestari', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-21', 'Poli Gigi', 'selesai'),
(91, 3, '123', 'a', 'b', '2019-06-21', 'Poli Gigi', 'antri'),
(92, 1, 'IN110661101', 'Ady Bagus Sugih Susanto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-26', 'Poli Gigi', 'antri'),
(93, 2, 'IN110661102', 'Lita Putri Ayu Lestari', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '2019-06-26', 'Poli Umum', 'antri'),
(94, 3, 'IN110661107', 'yulianto', 'rogojamppi', '2019-06-26', 'gigi', 'antri'),
(95, 3, 'IN110661104', 'yulianto', 'rogojamppi', '2019-06-26', 'gigi', 'antri');

-- --------------------------------------------------------

--
-- Table structure for table `backup`
--

CREATE TABLE `backup` (
  `back_index` varchar(20) NOT NULL,
  `back_nik` varchar(20) NOT NULL,
  `back_nama` varchar(30) NOT NULL,
  `back_kk` varchar(30) NOT NULL,
  `back_alamat` text NOT NULL,
  `back_telepon` varchar(15) NOT NULL,
  `back_lahir` date NOT NULL,
  `back_agama` varchar(10) NOT NULL,
  `back_pendidikan` varchar(20) NOT NULL,
  `back_kelamin` varchar(11) NOT NULL,
  `back_darah` varchar(3) NOT NULL,
  `back_pekerjaan` varchar(10) NOT NULL,
  `back_username` varchar(100) NOT NULL,
  `back_delete` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `backup`
--

INSERT INTO `backup` (`back_index`, `back_nik`, `back_nama`, `back_kk`, `back_alamat`, `back_telepon`, `back_lahir`, `back_agama`, `back_pendidikan`, `back_kelamin`, `back_darah`, `back_pekerjaan`, `back_username`, `back_delete`) VALUES
('IN110661105', '78689700', 'IN1106611', 'IN1106611', 'IN1106611', '8890', '2019-05-15', 'Katolik', 'SD / MI', 'Laki - Laki', 'O+', 'Polri', 'dragneel', '2019-06-30');

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
  `pas_lahir` date NOT NULL,
  `pas_agama` varchar(10) NOT NULL,
  `pas_pendidikan` varchar(20) NOT NULL,
  `pas_kelamin` varchar(11) NOT NULL,
  `pas_darah` varchar(3) NOT NULL,
  `pas_pekerjaan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`pas_index`, `pas_nik`, `pas_nama`, `pas_kk`, `pas_alamat`, `pas_telepon`, `pas_lahir`, `pas_agama`, `pas_pendidikan`, `pas_kelamin`, `pas_darah`, `pas_pekerjaan`) VALUES
('IN110661101', '3510130312970001', 'Ady Bagus Sugih Susanto', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '082232567731', '1997-12-03', 'Islam', 'Sarjana', 'Laki - Laki', 'O+', 'TNI'),
('IN110661102', '3510136306000002', 'Lita Putri Ayu Lestari', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '082232567731', '2000-06-23', 'Hindu', 'SMA / SMK / MAN', 'Perempuan', 'O+', 'Polri'),
('IN110661103', '3510130607690002', 'Yulianto', 'Yulianto', 'Dsn Rogojampi Utara RT 3 RW 5 Banyuwangi', '082232567731', '1969-07-06', 'Islam', 'Sarjana', 'Laki - Laki', 'O+', 'TNI');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `antrian`
--
ALTER TABLE `antrian`
  ADD PRIMARY KEY (`id_antrian`),
  ADD KEY `id_poli` (`nama_poli`);

--
-- Indexes for table `backup`
--
ALTER TABLE `backup`
  ADD PRIMARY KEY (`back_index`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`pas_index`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `antrian`
--
ALTER TABLE `antrian`
  MODIFY `id_antrian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
