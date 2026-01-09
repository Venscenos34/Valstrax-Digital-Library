import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "data_perpustakaan.txt";

    public static void saveToFile(List<Book> books) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Header Laporan
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            writer.println("==================================================");
            writer.println("       LAPORAN DATA KOLEKSI PERPUSTAKAAN        ");
            writer.println("       Waktu Simpan: " + dtf.format(LocalDateTime.now()));
            writer.println("==================================================");
            writer.println(String.format("%-5s | %-20s | %-15s", "No", "Judul Buku", "Penulis"));
            writer.println("--------------------------------------------------");

            int no = 1;
            for (Book b : books) {
                // Menggunakan String.format agar kolom sejajar rapi
                writer.println(String.format("%-5d | %-20s | %-15s", 
                    no++, 
                    b.getTitle(), 
                    b.getAuthor()));
            }
            writer.println("==================================================");
            writer.println("Total Buku: " + books.size());
            
        } catch (IOException e) {
            System.err.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    // Method Load agar data bisa muncul lagi saat program di-run
    public static List<Book> loadFromFile() {
        List<Book> books = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return books;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // Hanya ambil baris yang berisi data (memiliki karakter '|')
                if (line.contains("|") && !line.contains("Judul Buku")) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 3) {
                        String title = parts[1].trim();
                        String author = parts[2].trim();
                        books.add(new Book(title, author));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File tidak ditemukan.");
        }
        return books;
    }
}