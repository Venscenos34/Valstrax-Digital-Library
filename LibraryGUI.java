import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.io.*;

public class LibraryGUI extends JFrame {
    private static ArrayList<Book> daftarBuku = new ArrayList<>();
    private final String FILE_NAME = "data_perpustakaan.txt";

    public LibraryGUI() {
        loadDataFromFile(); // Baca data lama saat buka
        
        setUndecorated(true);
        setSize(600, 650);
        setLocationRelativeTo(null);
        setBackground(new Color(0,0,0,0));

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(41, 128, 185), 0, getHeight(), new Color(44, 62, 80));
                g2d.setPaint(gp);
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            }
        };
        mainPanel.setLayout(null);

        // Logo & Judul (seperti desain sebelumnya)
        JLabel title = new JLabel("VALSTRAX DIGITAL LIBRARY", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 150, 600, 40);
        mainPanel.add(title);

        // --- MENU TOMBOL ---
        String[] menuItems = {"Tambah Buku Baru", "Lihat Semua Koleksi", "Simpan Data Perpustakaan", "Logout / Keluar"};
        int startY = 220;

        for (int i = 0; i < menuItems.length; i++) {
     JButton btn = new JButton(menuItems[i]);
        btn.setBounds(150, startY + (i * 85), 300, 55);
    
     // Background tombol tetap putih bersih
        btn.setBackground(Color.WHITE);
    
        // WARNA TEKS: Diubah menjadi Biru Navy Tua (Sangat Kontras)
        btn.setForeground(new Color(44, 62, 80)); 
    
     // Font dipertebal agar lebih jelas
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
    
     // Garis pinggir tombol (Border) disamakan dengan warna teks
        btn.setBorder(BorderFactory.createLineBorder(new Color(44, 62, 80), 2));
    
     btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        final String menu = menuItems[i];
        btn.addActionListener(e -> {
        if(menu.contains("Tambah")) tambahBuku();
        else if(menu.contains("Lihat")) lihatKoleksi();
        else if(menu.contains("Simpan")) saveData();
        else if(menu.contains("Logout")) { dispose(); new LoginScreen(); }
    });
    mainPanel.add(btn);
}

        add(mainPanel);
        setVisible(true);
    }

    private void tambahBuku() {
        String j = JOptionPane.showInputDialog(this, "Judul Buku:");
        String p = JOptionPane.showInputDialog(this, "Pengarang:");
        if (j != null && p != null && !j.isEmpty()) {
            daftarBuku.add(new Book(j, p));
            JOptionPane.showMessageDialog(this, "Buku berhasil ditambah ke list!");
        }
    }

    private void lihatKoleksi() {
        String[] col = {"Judul", "Pengarang"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        for (Book b : daftarBuku) model.addRow(new Object[]{b.getJudul(), b.getPengarang()});
        
        JTable table = new JTable(model);
        JOptionPane.showMessageDialog(this, new JScrollPane(table), "Koleksi Buku", JOptionPane.PLAIN_MESSAGE);
    }

    private void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book b : daftarBuku) pw.println(b.toString());
            JOptionPane.showMessageDialog(this, "Data tersimpan di data_perpustakaan.txt");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error simpan data!");
        }
    }

    private void loadDataFromFile() {
        daftarBuku.clear();
        File f = new File(FILE_NAME);
        if(!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if(p.length == 2) daftarBuku.add(new Book(p[0], p[1]));
            }
        } catch (Exception e) {}
    }
}