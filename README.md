# 📚 Valstrax Digital Library (Java Swing)

Selamat datang di proyek **Valstrax Digital Library**. Aplikasi ini adalah sistem manajemen perpustakaan sederhana yang dibangun menggunakan Java Swing. Data buku akan tersimpan secara otomatis dalam file teks sehingga tidak akan hilang saat aplikasi ditutup.

---

## 🛠️ Panduan Persiapan (Bagi Pemula)

Jika Anda belum pernah menjalankan program Java sebelumnya, ikuti langkah-langkah di bawah ini:

### 1. Instalasi Java (JDK)
Aplikasi ini membutuhkan Java Development Kit (JDK) untuk berjalan.
* **Unduh JDK**: Pergi ke [Halaman Unduh Oracle](https://www.oracle.com/java/technologies/downloads/) atau gunakan OpenJDK.
* **Instalasi**: Jalankan installer dan ikuti petunjuknya.
* **Verifikasi**: Buka Terminal/Command Prompt, ketik `java -version`. Jika muncul versi Java, maka instalasi berhasil.

### 2. Persiapan Kode
* Unduh proyek ini (Klik tombol **Code** > **Download ZIP**).
* Ekstrak folder tersebut di komputer Anda.

---

## 🚀 Cara Menjalankan Aplikasi

Anda bisa menggunakan dua cara:

### Cara A: Menggunakan VS Code (Direkomendasikan)
1. Buka folder proyek di **VS Code**.
2. Instal ekstensi **"Extension Pack for Java"** dari Microsoft.
3. Cari file `SplashScreen.java` atau `MainApp.java` di sidebar kiri.
4. Klik tombol **Run** (Ikon segitiga di pojok kanan atas).

### Cara B: Menggunakan Command Prompt (Tanpa IDE)
1. Buka folder proyek di Command Prompt.
2. Kompilasi semua file dengan perintah:
   ```bash
   javac *.java
Jalankan aplikasi:

Bash

java SplashScreen
🔑 Informasi Login
Untuk masuk ke sistem, gunakan akun berikut:

Username: admin

Password: 123

✨ Fitur Aplikasi
Tambah Buku: Menambahkan judul dan pengarang baru.

Lihat Koleksi: Menampilkan database buku dalam tabel.

Simpan Otomatis: Menulis data ke file data_perpustakaan.txt.

Login System: Keamanan akses sebelum masuk ke database.

📁 Struktur Folder
*.java: File kode sumber program.

logo.png: Logo aplikasi (pastikan file ini tetap di folder utama).

data_perpustakaan.txt: Tempat penyimpanan database buku.
