-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 17, 2023 at 03:41 AM
-- Server version: 5.7.40
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tambak`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_cust` varchar(10) DEFAULT NULL,
  `nama_pt` varchar(100) DEFAULT NULL,
  `npwp` varchar(100) DEFAULT NULL,
  `sppkp` varchar(100) DEFAULT NULL,
  `tgl_bergabung` date DEFAULT NULL,
  `tgl_habis_kontrak` date DEFAULT NULL,
  `no_hp` varchar(100) DEFAULT NULL,
  `no_telp` varchar(100) DEFAULT NULL,
  `alamat` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `kode_cust`, `nama_pt`, `npwp`, `sppkp`, `tgl_bergabung`, `tgl_habis_kontrak`, `no_hp`, `no_telp`, `alamat`) VALUES
(2, 'CST02', 'CV. Udang Sejati', '08.178.554.2-123.321', 'PEM- 368 /WPJ.09/KP.0403/2004.', '2023-01-05', '2023-04-05', '08998768665', '0986863837299', 'Jl. DImana saja aku tidak tahu');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

DROP TABLE IF EXISTS `karyawan`;
CREATE TABLE IF NOT EXISTS `karyawan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(250) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `jenkel` enum('l','p') DEFAULT NULL,
  `no_hp` varchar(50) DEFAULT NULL,
  `alamat` text,
  `jabatan` varchar(50) DEFAULT NULL,
  `status_aktif` enum('1','0') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `tgl_lahir`, `jenkel`, `no_hp`, `alamat`, `jabatan`, `status_aktif`) VALUES
(1, 'Herzi', '2019-03-24', 'l', '0813', 'jl. banjarmasin kalimantan selatan', 'MANAGER', '0'),
(2, 'Deva Anjayani Mamud', '2003-06-09', 'l', '09098987987', 'Cermay Banjir', 'PENGAWAS', '1');

-- --------------------------------------------------------

--
-- Table structure for table `lahan`
--

DROP TABLE IF EXISTS `lahan`;
CREATE TABLE IF NOT EXISTS `lahan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lokasi` varchar(100) DEFAULT NULL,
  `koordinat` varchar(100) DEFAULT NULL,
  `luas` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lahan`
--

INSERT INTO `lahan` (`id`, `lokasi`, `koordinat`, `luas`) VALUES
(2, 'Leran ', '7°06\'34.0\"S 112°33\'50.2\"E ', '2 Hektar');

-- --------------------------------------------------------

--
-- Table structure for table `pendapatan`
--

DROP TABLE IF EXISTS `pendapatan`;
CREATE TABLE IF NOT EXISTS `pendapatan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tambak_id` int(11) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `jumlah_panen` int(11) DEFAULT NULL,
  `harga_kg` int(11) DEFAULT NULL,
  `total_pendapatan` int(11) DEFAULT NULL,
  `ket` text,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `kebun_id` (`tambak_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pendapatan`
--

INSERT INTO `pendapatan` (`id`, `tambak_id`, `customer_id`, `jumlah_panen`, `harga_kg`, `total_pendapatan`, `ket`, `created_at`, `updated_at`) VALUES
(2, 2, 2, 3000, 20000, 60000000, 'Deal sudah dilakukan', '2023-01-17 00:24:11', '2023-01-17 00:24:11');

-- --------------------------------------------------------

--
-- Table structure for table `pengeluaran`
--

DROP TABLE IF EXISTS `pengeluaran`;
CREATE TABLE IF NOT EXISTS `pengeluaran` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tambak_id` int(11) DEFAULT NULL,
  `biaya_ikan` int(11) DEFAULT NULL,
  `biaya_panen` int(11) DEFAULT NULL,
  `biaya_lain` int(11) DEFAULT NULL,
  `total_pengeluaran` int(11) DEFAULT NULL,
  `ket` text,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `kebun_id` (`tambak_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengeluaran`
--

INSERT INTO `pengeluaran` (`id`, `tambak_id`, `biaya_ikan`, `biaya_panen`, `biaya_lain`, `total_pengeluaran`, `ket`, `created_at`, `updated_at`) VALUES
(1, 2, 20000000, 5000000, 4000000, 29000000, 'Done ', '2023-01-17 02:38:24', '2023-01-17 02:38:24');

-- --------------------------------------------------------

--
-- Table structure for table `tambak`
--

DROP TABLE IF EXISTS `tambak`;
CREATE TABLE IF NOT EXISTS `tambak` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(250) DEFAULT NULL,
  `lahan_id` int(11) DEFAULT NULL,
  `varietas` varchar(250) DEFAULT NULL,
  `total_bibit` int(11) DEFAULT NULL,
  `tgl_sebar` date DEFAULT NULL,
  `tgl_perkiraan_panen` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lahan_id` (`lahan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tambak`
--

INSERT INTO `tambak` (`id`, `nama`, `lahan_id`, `varietas`, `total_bibit`, `tgl_sebar`, `tgl_perkiraan_panen`) VALUES
(2, 'Udang Fanami', 2, 'UDANG FANAMEE PREMIUM', 10, '2023-01-17', '2023-04-05');

-- --------------------------------------------------------

--
-- Table structure for table `tambak_detail`
--

DROP TABLE IF EXISTS `tambak_detail`;
CREATE TABLE IF NOT EXISTS `tambak_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tambak_id` int(11) DEFAULT NULL,
  `progress_tambak` enum('proses_tanam','perawatan','siap_panen','panen_gagal','penanaman_kembali','proses_panen','selesai_panen') DEFAULT NULL,
  `tgl_update` datetime DEFAULT NULL,
  `ket` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tambak_detail`
--

INSERT INTO `tambak_detail` (`id`, `tambak_id`, `progress_tambak`, `tgl_update`, `ket`) VALUES
(4, 2, 'proses_tanam', '2023-01-17 00:00:00', 'Sebar bibit sudahh dilakukan (Herzi)'),
(5, 2, 'perawatan', '2023-01-17 00:00:00', 'Perwatan minggu pertama (herzi)');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nama_depan` varchar(50) NOT NULL,
  `nama_belakang` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `alamat` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama_depan`, `nama_belakang`, `username`, `password`, `tanggal_lahir`, `alamat`) VALUES
(1, 'Naufal', 'Syahbana', 'nopal', '12345', '2003-06-07', 'Gunung tingggi menjulang ke angkasa'),
(2, 'Alexander', 'Suwoto', 'alex', 'alex123', '2029-12-12', 'Mars');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pendapatan`
--
ALTER TABLE `pendapatan`
  ADD CONSTRAINT `pendapatan_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pendapatan_ibfk_2` FOREIGN KEY (`tambak_id`) REFERENCES `tambak` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`tambak_id`) REFERENCES `tambak` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `tambak`
--
ALTER TABLE `tambak`
  ADD CONSTRAINT `tambak_ibfk_1` FOREIGN KEY (`lahan_id`) REFERENCES `lahan` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
