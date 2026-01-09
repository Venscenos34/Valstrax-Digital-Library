import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("A01", "Budi", "Pagi");
        boolean running = true;

        System.out.println("Sistem diakses oleh: ");
        admin.showRole();

        while (running) {
            System.out.println("\n--- MENU PERPUSTAKAAN ---");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Simpan & Keluar");
            System.out.print("Pilih: ");

            try {
                String input = scanner.nextLine();
                if (!InputValidator.isNumeric(input)) throw new Exception("Input harus angka!");
                
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.print("Judul: "); String t = scanner.nextLine();
                        System.out.print("Penulis: "); String a = scanner.nextLine();
                        service.addBook(new Book(t, a));
                        break;
                    case 2:
                        service.showAllBooks();
                        break;
                    case 3:
                        System.out.print("Judul buku yang dipinjam: ");
                        service.borrowBook(scanner.nextLine());
                        break;
                    case 4:
                        FileHandler.saveBooks(service.getBooks());
                        running = false;
                        break;
                    default:
                        System.out.println("Pilihan salah.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}