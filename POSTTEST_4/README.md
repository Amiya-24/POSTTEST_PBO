# Sistem Manajemen Penyewaan Alat Berat & Kalkulasi Biaya Operator

Sebuah program sederhana berbasis teks (CLI) yang dibuat dengan Java. Program ini berfungsi untuk mencatat transaksi penyewaan alat berat sekaligus menghitung otomatis total biaya yang harus dibayar (termasuk gaji operatornya).

## 📑 Daftar Isi
- [Perkembangan Modul (Struktur Repositori)](#perkembangan-modul-struktur-repositori)
- [Apa Saja yang Bisa Dilakukan Program Ini? (Fitur Utama)](#apa-saja-yang-bisa-dilakukan-program-ini-fitur-utama)
- [Gimana Cara Kerjanya? (Alur Program)](#gimana-cara-kerjanya-alur-program)
- [Data Bawaan (Bisa Langsung Dipakai)](#data-bawaan-bisa-langsung-dipakai)
- [Struktur Kode (Penjelasan Singkat Class)](#struktur-kode-penjelasan-singkat-class)
- [Cara Menjalankan Program di Komputer Kamu](#cara-menjalankan-program-di-komputer-kamu)
- [Pengembangan Selanjutnya](#pengembangan-selanjutnya)

---

## Perkembangan Modul (Struktur Repositori)
Repositori ini berisi beberapa tahap perkembangan (Posttest) dari implementasi Object-Oriented Programming (OOP):

- **`POSTTEST_1` (Dasar OOP & CRUD):** Implementasi sistem dasar menggunakan class `AlatBerat`, `Operator`, `Penyewaan`, dan `SistemUtama`. Data disimpan sementara pada memori menggunakan `ArrayList`.
- **`POSTTEST_2` (Enkapsulasi & Access Modifiers):** Peningkatan struktur kode dari Posttest 1 dengan menerapkan prinsip **Enkapsulasi** secara ketat. Menambahkan setter/getter secara lengkap, membatasi *access modifier* dengan `private` dan `protected`, serta memindahkan logika pencetakan data ke dalam *method* masing-masing class (seperti `cetakInfoAlat()`, `cetakInfoOperator()`, dan `cetakStruk()`).
- **`POSTTEST_3` (Inheritance & Error Handling):** - **Hierarchical Inheritance:** Memecah `AlatBerat` menjadi Superclass, dan membuat 3 Subclass (`Excavator`, `Bulldozer`, `Crane`) dengan spesifikasi khususnya masing-masing.
- **`POSTTEST_4` (IPolimorfisme & Overriding):**  - **Polimorfisme & Overriding:** Menggunakan tipe data Superclass untuk menyimpan objek Subclass di `ArrayList` dan menerapkan *Dynamic Method Dispatch* pada method `cetakInfoAlat()`.

---

## Apa Saja yang Bisa Dilakukan Program Ini? (Fitur Utama)
Program ini mempunyai fitur CRUD dasar (Create, Read, Update, Delete) yang dikemas dalam bentuk menu interaktif:
1. **Lihat Transaksi:** Menampilkan semua data sewaan yang sudah dicatat, lengkap dengan rincian alat berat, operator, lama sewa, dan total harganya.
2. **Buat Transaksi Baru:** Menambah catatan sewa baru. Kamu tinggal pilih alat berat dan operator dari daftar yang ada, lalu masukkan berapa hari mau disewa.
3. **Ubah Lama Sewa:** Salah masukin hari? Tenang, kamu bisa ubah durasi sewanya pakai ID Transaksi. Total harga otomatis bakal dihitung ulang!
4. **Hapus Transaksi:** Menghapus catatan sewaan kalau pesanannya batal atau sudah selesai.

---

## Gimana Cara Kerjanya? (Alur Program)
1. **Buka Program:** Saat program pertama kali dijalankan, kamu akan melihat menu pilihan (1-5).

![Menu Utama](assets/[1]%20Tampilan%20Menu%20Awal.png)

2. **Mulai Menyewa:** Pilih menu nomor 2 untuk membuat pesanan. Masukkan ID bebas (misal: T01), pilih alat dan operatornya dengan mengetikkan nomor, lalu isi berapa hari mau disewa.

![Buat Transaksi](assets/[2]%20Membuat%20Transaksi%20Baru.png)

3. **Sistem Menghitung:** Program akan langsung menjumlahkan total harga pakai rumus: `(Harga Sewa Alat + Harga Operator) x Lama Sewa`.
4. **Cek Data:** Pilih menu nomor 1 untuk melihat apakah data dan harganya sudah masuk dengan benar.

![Lihat Transaksi](assets/[3]%20Melihat%20Transaksi.png)

5. **Selesai:** Kalau sudah selesai, pilih menu nomor 5 untuk keluar dari program.

![Program Selesai](assets/[4]%20Keluar%20dari%20Program.png)

*Catatan: Karena ini program sederhana, datanya hanya disimpan sementara pada memori komputer menggunakan `ArrayList`. Sehingga jika program ditutup, datanya akan hilang.*

---

## Data Bawaan (Bisa Langsung Dipakai)
Biar mudah saat menguji program, terdapat beberapa data bawaan di dalamnya:
* **Alat Berat:**
  1. Excavator (A01) - Rp 1.500.000 / hari
  2. Bulldozer (A02) - Rp 2.000.000 / hari
  3. Mobile Crane Kato (A03) - Rp 3.500.000 / hari *(Kapasitas Angkat: 25.0 Ton)*
* **Operator:**
  1. Budi (Senior) - Rp 500.000 / hari
  2. Andi (Junior) - Rp 300.000 / hari

---

## Struktur Kode (Penjelasan Singkat Class)
Sistem ini menggunakan struktur OOP dengan klasifikasi sebagai berikut:
- **`AlatBerat` (Superclass):** Menyimpan atribut dasar alat seperti ID, Nama Alat, dan Harga Sewa per Hari.
  - **`Excavator` (Subclass):** Mewarisi `AlatBerat` dengan tambahan atribut `kapasitasBucket`.
  - **`Bulldozer` (Subclass):** Mewarisi `AlatBerat` dengan tambahan atribut `tipeBlade`.
  - **`Crane` (Subclass):** Mewarisi `AlatBerat` dengan tambahan atribut `kapasitasAngkat`.
- **`Operator`:** Menyimpan data operator (ID, Nama, Biaya).
- **`Penyewaan`:** Kelas perantara (Transaksi) yang menggabungkan objek `AlatBerat` (secara Polimorfisme) dan `Operator`. Mengurus kalkulasi total biaya dan pencetakan struk.
- **`SistemUtama`:** Class utama yang menjalankan CLI interaktif, mengelola *Array List*, dan menu CRUD.

---

## Cara Menjalankan Program di Komputer Kamu
1. Pastikan di komputermu sudah ter-install Java Development Kit (JDK).
2. Buka terminal atau *Command Prompt* (CMD).
3. Arahkan ke direktori (*cd*) ke dalam folder tempat file `SistemUtama.java` ini disimpan.
4. Compile program dengan menjalankan perintah berikut:
   ```bash
   javac SistemUtama.java
   ```
5. Kemudian jalankan program yang telah dicompile dengan perintah:
   ```bash
   java SistemUtama
   ```

---

## Pengembangan Selanjutnya
Karena program ini masih dalam versi dasar, ada banyak ruang untuk dikembangkan ke depannya. Beberapa fitur yang bisa ditambahkan antara lain:
1. **Fitur Login & Register:** Untuk membatasi akses pengguna selain Admin.
2. **Fitur CRUD Admin:** Menambahkan CRUD Admin untuk mengelola data `Alat Berat`, `Operator`, `Transaksi`, dan `Akun`.
3. **Detail CRUD Client:** Menambahkan detail pada bagian `UPDATE`.
4. **Validasi Input:** Menambahkan `ERROR HANDLING` pada program.