-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2025 at 06:33 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` char(4) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `stok` smallint(6) NOT NULL,
  `harga` double NOT NULL,
  `persen_laba` double NOT NULL DEFAULT 5,
  `diskon` double NOT NULL DEFAULT 0,
  `id_jenis_brg` tinyint(4) NOT NULL,
  `id_pemasok` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `stok`, `harga`, `persen_laba`, `diskon`, `id_jenis_brg`, `id_pemasok`) VALUES
('B003', 'Sprite', 125, 1650, 7, 8, 102, 'S003'),
('B005', 'Fanta', 80, 1450, 6, 7, 102, 'S003'),
('B006', 'Sapu', 50, 2250, 10, 0, 104, 'S006'),
('B007', 'Kain Pel', 60, 2800, 4, 0, 104, 'S007'),
('B008', 'Coca Cola', 56, 1450, 3, 8, 102, 'S008'),
('B009', 'Seven Up', 65, 1850, 4, 8, 102, 'S008'),
('B011', 'Telepon Panasonic', 75, 230000, 8, 0, 103, 'S004'),
('B012', 'Televisi Sharp', 30, 1400000, 7, 0, 103, 'S005');

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `kode_transaksi` char(4) NOT NULL,
  `id_barang` char(4) NOT NULL,
  `jumlah` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`kode_transaksi`, `id_barang`, `jumlah`) VALUES
('J001', 'B003', 3),
('J003', 'B005', 2),
('J004', 'B007', 4),
('J004', 'B008', 2),
('J005', 'B011', 1),
('J006', 'B006', 3),
('J007', 'B008', 2),
('J008', 'B008', 5),
('J009', 'B006', 4),
('J012', 'B009', 2),
('J013', 'B008', 4);

-- --------------------------------------------------------

--
-- Table structure for table `jenis_barang`
--

CREATE TABLE `jenis_barang` (
  `id_jenis_brg` tinyint(4) NOT NULL,
  `nama_jenis_brg` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jenis_barang`
--

INSERT INTO `jenis_barang` (`id_jenis_brg`, `nama_jenis_brg`) VALUES
(100, 'Snack'),
(101, 'Minuman'),
(102, 'Elektronik'),
(103, 'Alat Pembersih'),
(104, 'Snack'),
(105, 'Minuman'),
(106, 'Elektronik'),
(107, 'Alat Pembersih'),
(108, 'Snack'),
(109, 'Minuman'),
(110, 'Elektronik'),
(111, 'Alat Pembersih'),
(113, 'api');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jenis_kelamin` char(1) NOT NULL DEFAULT 'L',
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(15) DEFAULT NULL,
  `tgl_lahir` date NOT NULL,
  `gaji` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama`, `jenis_kelamin`, `alamat`, `telepon`, `tgl_lahir`, `gaji`) VALUES
(1, 'Tuti', 'P', 'Jl. Kenanga No.8', '08155601135', '1984-02-13', 725069),
(2, 'Siti', 'P', 'Jl. Mawar No.36B', '085868426728', '1983-08-29', 900269),
(3, 'Endang', 'P', 'Jl. Anggrek No.1', '087811121097', '1982-11-02', 525000),
(4, 'Yuli', 'P', 'Jl. Melati No.19', '081327934634', '1980-06-03', 622349),
(5, 'Yola', 'P', 'Jl. Melati No. 80', '081328305938', '1983-09-11', 425600),
(6, 'Lisa', 'P', 'Jl. Kamboja No. 11', '081572244100', '1980-05-02', 731000),
(7, 'Hasan', 'L', 'Jl. Bungaku No. 7', '08123476772', '1978-10-06', 725800),
(8, 'Aini', 'P', 'Jl. Kenanga No.8', '08155601135', '1984-02-13', 725069);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` bigint(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jenis_kelamin` char(1) NOT NULL DEFAULT 'L',
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(15) DEFAULT NULL,
  `tgl_lahir` date NOT NULL,
  `jenis_pelanggan` char(1) NOT NULL DEFAULT 'S',
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `jenis_kelamin`, `alamat`, `telepon`, `tgl_lahir`, `jenis_pelanggan`, `email`) VALUES
(1, 'Budi', 'L', 'Jl. Merdeka No.1', '08123456789', '1984-07-16', 'S', 'budi@gmail.com'),
(2, 'Susanto', 'L', 'Jl. P. Sudirman No.9', '08189596566', '1983-07-11', 'G', NULL),
(3, 'Susanti', 'L', 'Jl. Hayam Wuruk No.9A', '08171122222', '1982-08-02', 'G', NULL),
(4, 'Anton', 'L', 'Jl. Kebon Jeruk No.9B', '08171122223', '1980-06-12', 'S', NULL),
(5, 'Bobby', 'L', 'Jl. Kebon Sirih No. 80', '081310202326', '1983-05-01', 'G', NULL),
(6, 'Charles', 'L', 'Jl. P. Diponegoro No. 89', '081399919232', '1980-04-12', 'G', NULL),
(7, 'Merry', 'P', 'Jl. Kaliurang KM. 6 No. 80', '08125656989', '1978-05-16', 'G', NULL),
(8, 'Meiliana', 'P', 'Jl. Sukarno Hatta No. 78B', '08164918722', '1986-04-04', 'S', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pemasok`
--

CREATE TABLE `pemasok` (
  `id_pemasok` char(4) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemasok`
--

INSERT INTO `pemasok` (`id_pemasok`, `nama`, `alamat`, `telepon`, `email`) VALUES
('S001', 'Pemasok A', 'Jl. Sudirman 123', '08123456789', 'pemasokA@gmail.com'),
('S002', 'Pemasok A Updated', 'Jl. Sudirman No.123', '081234567890', 'pemasok_updated@gmail.com'),
('S003', 'Sabar Subur', 'Jl. Galunggung No.66', '08157984898', NULL),
('S004', 'Kiat Sejahtera', 'Jl. Sutami No.545', '081931771735', 'sejahtera.kiat@yahoo.co.id'),
('S005', 'Bersemi Kembali', 'Jl. Sigura-gura No. 7A', '081328171718', NULL),
('S006', 'Isaku Niki', 'Jl. Kawi No. 27', '08126702381', 'yoiki_isakudab@gmail.com'),
('S007', 'Indo Mandiri', 'Jl. Muria No. 34B', '081914057581', 'mandirindo@gomandiri.org'),
('S008', 'Karya Indah', 'Jl. Merapi No. 35B', '081328084248', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` char(4) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `id_pelanggan` char(4) NOT NULL,
  `id_karyawan` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `tgl_transaksi`, `id_pelanggan`, `id_karyawan`) VALUES
('J001', '2025-12-27 15:30:00', 'P001', 7),
('J002', '2006-05-08 10:10:05', 'P002', 2),
('J003', '2006-05-12 10:45:12', 'P001', 1),
('J004', '2006-05-15 17:57:09', 'P003', 3),
('J005', '2006-05-16 18:01:31', 'P004', 4),
('J006', '2006-05-18 16:42:41', 'P002', 2),
('J007', '2006-05-20 11:31:13', 'P005', 5),
('J008', '2006-05-22 10:30:05', 'P006', 6),
('J009', '2006-05-24 20:19:19', 'P006', 6),
('J010', '2006-05-29 20:39:46', 'P007', 7),
('J011', '2006-06-02 19:16:01', 'P006', 6),
('J012', '2006-06-05 19:00:12', 'P008', 8),
('J013', '2006-06-10 14:38:11', 'P007', 7),
('J014', '2006-06-12 13:10:52', 'P006', 6),
('J015', '2025-12-27 15:30:00', 'P001', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `fk_id_jenis_brg` (`id_jenis_brg`),
  ADD KEY `fk_id_pemasok` (`id_pemasok`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`kode_transaksi`,`id_barang`),
  ADD KEY `fk_id_barang` (`id_barang`);

--
-- Indexes for table `jenis_barang`
--
ALTER TABLE `jenis_barang`
  ADD PRIMARY KEY (`id_jenis_brg`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pemasok`
--
ALTER TABLE `pemasok`
  ADD PRIMARY KEY (`id_pemasok`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `fk_id_karyawan` (`id_karyawan`),
  ADD KEY `fk_id_pelanggan` (`id_pelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jenis_barang`
--
ALTER TABLE `jenis_barang`
  MODIFY `id_jenis_brg` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `fk_id_jenis_brg` FOREIGN KEY (`id_jenis_brg`) REFERENCES `jenis_barang` (`id_jenis_brg`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_pemasok` FOREIGN KEY (`id_pemasok`) REFERENCES `pemasok` (`id_pemasok`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `fk_id_barang` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kode_transaksi` FOREIGN KEY (`kode_transaksi`) REFERENCES `transaksi` (`kode_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
