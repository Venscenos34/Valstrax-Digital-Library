Library Management System (Java OOP)
Nama Aplikasi

Library Management System (Sistem Manajemen Perpustakaan Berbasis Java OOP)

Deskripsi Singkat

Library Management System adalah aplikasi berbasis Java yang digunakan untuk mengelola sistem perpustakaan secara sederhana. Aplikasi ini memungkinkan admin untuk mengelola data buku dan member untuk meminjam serta mengembalikan buku. Sistem ini dibangun menggunakan konsep Object-Oriented Programming (OOP) dan dilengkapi dengan Graphical User Interface (GUI).

Cara Menjalankan Aplikasi

1. Pastikan Java JDK sudah terinstall di komputer 

2. Ekstrak folder project 

3. Buka project menggunakan IDE Java (NetBeans / IntelliJ / Eclipse) 

4. Jalankan file Main.java atau class utama aplikasi 

5. Aplikasi akan menampilkan Splash Screen lalu masuk ke Login Screen 

6. Login sebagai Admin

Daftar Class dan Fungsinya

SplashScreen: Menampilkan tampilan loading awal aplikasi sebelum masuk ke halaman login.

LoginScreen: Menangani proses login user dan validasi username serta password. 

Person: Class induk yang menyimpan atribut umum seperti nama dan ID. 

Admin: Turunan dari Person yang memiliki hak akses untuk mengelola data buku. 

Member: Turunan dari Person yang berperan sebagai peminjam buku. 

Item: Class dasar untuk item perpustakaan yang menyimpan ID dan judul. 

Book: Turunan dari Item yang menyimpan informasi buku seperti penulis dan status ketersediaan. 

Loanable (Interface): Mendefinisikan method peminjaman dan pengembalian buku. 

LibraryService: Mengatur logika utama sistem seperti peminjaman dan pengembalian buku. 

FileHandler: Menangani proses penyimpanan dan pembacaan data dari file. 

InputValidator: Memvalidasi input agar sesuai dan tidak kosong. 

LibraryGUI: GUI utama yang menghubungkan user dengan fitur sistem. 

DaftarBukuScreen: Menampilkan daftar buku dan status ketersediaannya. 

FormTambahBuku: Form yang digunakan admin untuk menambahkan buku baru.

Konsep OOP yang Digunakan

Encapsulation: Data dibungkus dalam class dan diakses melalui method untuk menjaga keamanan data. 

Inheritance: Class Admin dan Member mewarisi Person, sedangkan Book mewarisi Item. 

Polymorphism: Class turunan dapat memiliki perilaku berbeda pada method yang sama. 

Interface: Loanable digunakan untuk mendefinisikan perilaku peminjaman agar konsisten.

Abstraction: Pemisahan antara logika sistem dan tampilan GUI untuk menyederhanakan penggunaan aplikasi.

Kesimpulan

Aplikasi Library Management System menerapkan konsep OOP secara lengkap sehingga sistem menjadi modular, terstruktur, mudah dikembangkan, dan mudah dipelihara.
