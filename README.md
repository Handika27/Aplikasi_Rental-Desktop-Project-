\# Aplikasi Rental Kendaraan (Desktop Swing)



Aplikasi berbasis desktop Java Swing dan MySQL yang dirancang untuk mempermudah pengelolaan transaksi penyewaan kendaraan, pendataan armada, serta pencatatan riwayat sewa.



\---



\## Fitur Utama



\- \*\*Multi-Role Access\*\*: Login terpisah untuk Admin dan Kasir.

\- \*\*Manajemen Kendaraan\*\*: Tambah, edit, hapus, dan cari status armada rental.

\- \*\*Manajemen Pelanggan \& Petugas\*\*: Pengelolaan data master pengguna aplikasi.

\- \*\*Transaksi Sewa \& Kembali\*\*: Pencatatan peminjaman dan kalkulasi pengembalian kendaraan.

\- \*\*Riwayat Transaksi\*\*: Rekapitulasi data transaksi rental secara real-time.



\---



\## Tech Stack \& Prasyarat



\- \*\*Bahasa Pemrograman:\*\* Java (JDK 8+)

\- \*\*Framework GUI:\*\* Java Swing

\- \*\*Database:\*\* MySQL

\- \*\*Tool / IDE:\*\* NetBeans IDE, XAMPP (Apache \& MySQL)



\---



\## Cara Menjalankan Projek



1\. \*\*Persiapan Database:\*\*

&#x20;  - Nyalakan \*\*Apache\*\* dan \*\*MySQL\*\* di XAMPP Control Panel.

&#x20;  - Buka `http://localhost/phpmyadmin` di browser.

&#x20;  - Buat database baru dengan nama `dbrental2`.

&#x20;  - Import file \*\*`dbrental2.sql`\*\* yang ada di dalam repositori ini.



2\. \*\*Membuka Projek di NetBeans:\*\*

&#x20;  - Clone repositori ini atau download sebagai \*\*ZIP\*\*.

&#x20;  - Buka NetBeans IDE $\\rightarrow$ \*\*File\*\* $\\rightarrow$ \*\*Open Project\*\*.

&#x20;  - Cari dan pilih folder projek `Aplikasi\_Rental`.



3\. \*\*Menjalankan Aplikasi:\*\*

&#x20;  - Pastikan pengaturan koneksi database di file `src/myConnection/DB0.java` sudah sesuai.

&#x20;  - Cari file `FrLogin.java` di dalam package `src/Desain/`.

&#x20;  - Klik kanan pada `FrLogin.java` $\\rightarrow$ \*\*Run File\*\* (atau tekan `Shift + F6`).

