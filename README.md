# Aplikasi Rental Kendaraan (Desktop Swing)

Aplikasi berbasis desktop Java Swing dan MySQL yang dirancang untuk mempermudah pengelolaan transaksi penyewaan kendaraan, pendataan armada, serta pencatatan riwayat sewa.

---

## Fitur Utama

- Multi-Role Access: Login terpisah untuk Admin dan Kasir.
- Manajemen Kendaraan: Tambah, edit, hapus, dan cari status armada rental.
- Manajemen Pelanggan & Petugas: Pengelolaan data master pengguna aplikasi.
- Transaksi Sewa & Kembali: Pencatatan peminjaman dan kalkulasi pengembalian kendaraan.
- Riwayat Transaksi: Rekapitulasi data transaksi rental secara real-time.

---

## Tech Stack & Prasyarat

- Bahasa Pemrograman: Java (JDK 8+)
- Framework GUI: Java Swing
- Database: MySQL
- Tool / IDE: NetBeans IDE, XAMPP (Apache & MySQL)

---

## Cara Menjalankan Projek

1. Persiapan Database:
   - Nyalakan Apache dan MySQL di XAMPP Control Panel.
   - Buka http://localhost/phpmyadmin di browser.
   - Buat database baru dengan nama dbrental2.
   - Import file Dbrental2.sql yang ada di repositori ini.

2. Membuka Projek di NetBeans:
   - Clone repositori ini atau download sebagai ZIP.
   - Buka NetBeans IDE -> File -> Open Project.
   - Cari dan pilih folder projek Aplikasi_Rental.

3. Menjalankan Aplikasi:
   - Pastikan pengaturan koneksi database di file src/myConnection/DB0.java sudah sesuai.
   - Cari file FrLogin.java di dalam package src/Desain/.
   - Klik kanan pada FrLogin.java -> Run File (atau tekan Shift + F6).