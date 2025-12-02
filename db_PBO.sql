-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Nov 2025 pada 16.46
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
-- Database: `db_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `id_produk` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id`, `id_transaksi`, `id_produk`, `qty`, `subtotal`) VALUES
(1, 1, 1, 10, 50000),
(2, 2, 2, 5, 50000),
(3, 3, 1, 5, 25000),
(4, 3, 2, 53, 530000),
(5, 4, 1, 1, 5000),
(6, 5, 1, 5, 25000),
(7, 5, 2, 2, 20000),
(8, 6, 1, 5, 25000),
(9, 7, 1, 2, 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `diskon`
--

CREATE TABLE `diskon` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `persen1` double DEFAULT 0,
  `persen2` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `diskon`
--

INSERT INTO `diskon` (`id`, `tanggal`, `persen1`, `persen2`) VALUES
(2, '2025-12-25', 20, 10),
(3, '2025-01-01', 15, 5),
(4, '2025-11-11', 50, 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_hp` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `no_hp`) VALUES
(1, 'Akbla', '29879'),
(2, 'Dino', '13127970'),
(3, 'awdadadsd', '321112313'),
(4, 'YANTO', '083238493'),
(5, 'akjwdgakd', '13231312113'),
(6, 'adfadawd', '12312313'),
(7, 'YANTO', '1213131');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id`, `nama`, `harga`) VALUES
(1, 'es Teh', 5000),
(2, 'Mie Jebew', 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `tanggal` datetime NOT NULL,
  `total` double NOT NULL,
  `diskon` double DEFAULT 0,
  `total_real` double NOT NULL,
  `id_pelanggan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `tanggal`, `total`, `diskon`, `total_real`, `id_pelanggan`) VALUES
(1, '2025-11-11 04:07:09', 50000, 0, 50000, 1),
(2, '2025-11-11 04:07:33', 50000, 0, 50000, 2),
(3, '2025-11-11 04:10:11', 555000, 0, 555000, 3),
(4, '2025-11-11 10:16:24', 5000, 0, 5000, 4),
(5, '2025-11-11 11:48:00', 45000, 13500, 31500, 5),
(6, '2025-11-11 11:50:28', 25000, 15000, 10000, 6),
(7, '2025-11-11 16:32:25', 10000, 6000, 4000, 7);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_produk` (`id_produk`);

--
-- Indeks untuk tabel `diskon`
--
ALTER TABLE `diskon`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `diskon`
--
ALTER TABLE `diskon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `produk`
--
ALTER TABLE `produk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id`),
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
