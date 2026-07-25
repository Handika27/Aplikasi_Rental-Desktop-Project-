-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Jul 2026 pada 21.56
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbrental2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kendaraan`
--

CREATE TABLE `tb_kendaraan` (
  `nopol` varchar(12) NOT NULL,
  `merk_kendaraan` varchar(30) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `harga_sewa` int(11) DEFAULT NULL,
  `status` varchar(15) DEFAULT 'Tersedia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_kendaraan`
--

INSERT INTO `tb_kendaraan` (`nopol`, `merk_kendaraan`, `jenis`, `harga_sewa`, `status`) VALUES
('R 11111 QW', 'Jetour T1', 'Mobil', 700000, 'Tersedia'),
('R 2213 RRR', 'Nissan Evalia', 'Mobil', 370000, 'Tersedia'),
('R 2222 AA', 'Avanza', 'Mobil', 370000, 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pelanggan`
--

CREATE TABLE `tb_pelanggan` (
  `nik` varchar(16) NOT NULL,
  `nama_pelanggan` varchar(50) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_pelanggan`
--

INSERT INTO `tb_pelanggan` (`nik`, `nama_pelanggan`, `no_telp`, `alamat`) VALUES
('123456', 'aaaa', '123456', 'mksjbns'),
('33022123456788', 'joko pwt', '08123456778', 'sokaraja'),
('du3hu93', 'xnjxmkfr', 'mjxi30xjwh', 'xqhweuxhueh'),
('o90234093094', 'jkfjsfnnd', '209390', 'snbdnxjjkmn'),
('xbe2u89ux', 'xkndbfxhewuf', '261537', 'xjwbujx');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pengguna`
--

CREATE TABLE `tb_pengguna` (
  `id_pengguna` varchar(10) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `role` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_pengguna`
--

INSERT INTO `tb_pengguna` (`id_pengguna`, `nama`, `username`, `password`, `role`) VALUES
('K01', 'Joko', 'kasir1', '123', 'Kasir'),
('U001', 'Admin Utama', 'admin', '123', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_sewa`
--

CREATE TABLE `tb_sewa` (
  `id_sewa` varchar(15) NOT NULL,
  `nik` varchar(16) DEFAULT NULL,
  `nopol` varchar(12) DEFAULT NULL,
  `tgl_sewa` date DEFAULT NULL,
  `durasi` int(11) DEFAULT NULL,
  `total_harga` int(11) DEFAULT NULL,
  `status_sewa` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_sewa`
--

INSERT INTO `tb_sewa` (`id_sewa`, `nik`, `nopol`, `tgl_sewa`, `durasi`, `total_harga`, `status_sewa`) VALUES
('SWR3372', '33022123456788', 'R 11111 QW', '2026-07-23', 4, 2800000, 'Selesai');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_kendaraan`
--
ALTER TABLE `tb_kendaraan`
  ADD PRIMARY KEY (`nopol`);

--
-- Indeks untuk tabel `tb_pelanggan`
--
ALTER TABLE `tb_pelanggan`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `tb_pengguna`
--
ALTER TABLE `tb_pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indeks untuk tabel `tb_sewa`
--
ALTER TABLE `tb_sewa`
  ADD PRIMARY KEY (`id_sewa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
