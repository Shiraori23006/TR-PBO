CREATE table produk (
	id int AUTO_INCREMENT PRIMARY KEY,
    nama varchar(100),
    price int,
    stock int
);

CREATE table pelanggan (
	id int AUTO_INCREMENT PRIMARY KEY,
    nama varchar(100),
    no_hp varchar(100)
);

CREATE table transaksi (
	id int AUTO_INCREMENT PRIMARY KEY,
    tanggal DATETIME NOT NULL,
    total double NOT NULL,
    diskon double DEFAULT 0,
    total_real double NOT NULL,
    id_pelanggan int,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id)
);

CREATE TABLE detail_transaksi (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_transaksi INT NOT NULL,
    id_produk INT NOT NULL,
    qty INT NOT NULL,
    subtotal DOUBLE NOT NULL,
    FOREIGN KEY (id_transaksi) REFERENCES transaksi(id),
    FOREIGN KEY (id_produk) REFERENCES produk(id)
);

CREATE TABLE diskon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tanggal DATE NOT NULL,
    persen DOUBLE DEFAULT 0,
    persen2 DOUBLE DEFAULT 0
);


INSERT INTO diskon (tanggal, persen, persen2)
VALUES
('2025-11-11', 10, 5),
('2025-12-25', 20, 10),
('2025-01-01', 15, 5);

