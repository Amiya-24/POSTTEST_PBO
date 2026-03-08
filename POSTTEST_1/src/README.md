# Sistem Penyewaan Alat Berat & Kalkulasi Operator

Aplikasi Command Line Interface (CLI) sederhana berbasis Java untuk mengelola transaksi penyewaan alat berat beserta perhitungan biaya operator. Proyek ini merupakan implementasi dari tugas POSTTEST 1 Pemrograman Berorientasi Objek (PBO).

## Identitas
- **Nama:** Muhammad Faiz Lazuardi
- **NIM:** 2409106031

## Deskripsi Program
Program ini memungkinkan pengguna untuk melakukan pencatatan transaksi penyewaan alat berat. Sistem akan secara otomatis mengkalkulasi total biaya penyewaan berdasarkan harga sewa alat berat per hari, biaya operator per hari, dan durasi lama sewa yang diinputkan oleh pengguna. Semua data disimpan sementara di dalam memori menggunakan koleksi `ArrayList`.

## Fitur Utama (CRUD)
Sistem ini dilengkapi dengan menu interaktif yang memiliki fitur-fitur berikut:
1. **Tampilkan Data Transaksi Penyewaan (Read):** Menampilkan seluruh data transaksi yang telah dibuat, lengkap dengan rincian alat berat, operator, lama sewa, dan total biaya.
2. **Buat Transaksi Penyewaan Baru (Create):** Menginputkan ID transaksi baru, memilih alat berat dan operator dari daftar yang tersedia, serta menentukan lama sewa.
3. **Ubah Lama Sewa Transaksi (Update):** Mengubah durasi lama sewa berdasarkan ID Transaksi. Total biaya akan dikalkulasi ulang secara otomatis.
4. **Hapus Transaksi Penyewaan (Delete):** Menghapus data transaksi penyewaan dari sistem berdasarkan ID Transaksi.

## Struktur Kelas
Program ini menggunakan prinsip Object-Oriented Programming (OOP) yang dibagi menjadi empat kelas utama:
- `AlatBerat`: Menyimpan atribut untuk alat berat seperti ID, Nama Alat, dan Harga Sewa per Hari.
- `Operator`: Menyimpan atribut untuk operator seperti ID, Nama Operator, dan Biaya per Hari.
- `Penyewaan`: Kelas yang menggabungkan objek `AlatBerat` dan `Operator` ke dalam satu transaksi. Kelas ini juga memiliki metode `hitungTotalBiaya()` untuk mengkalkulasi total tagihan.
- `SistemUtama`: Kelas utama yang menampung daftar `ArrayList`, metode `main`, serta logika CLI interaktif.

## Cara Menjalankan Program
1. Pastikan Java Development Kit (JDK) telah terinstal di perangkat Anda.
2. Buka terminal atau command prompt, lalu arahkan ke direktori tempat file `SistemUtama.java` berada.
3. Lakukan kompilasi program dengan menjalankan perintah:
   ```bash
   javac SistemUtama.java