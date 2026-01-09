import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DaftarBukuScreen extends JDialog {
    public DaftarBukuScreen(JFrame parent) {
        super(parent, "Koleksi Semua Buku", true);
        setSize(500, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Header Tabel
        String[] columnNames = {"No", "Judul Buku", "Pengarang", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // --- CONTOH SIMULASI DATA ---
        // Nanti bagian ini bisa kamu hubungkan dengan ArrayList dari LibraryService kamu
        model.addRow(new Object[]{"1", "Laskar Pelangi", "Andrea Hirata", "Tersedia"});
        model.addRow(new Object[]{"2", "Bumi Manusia", "Pramoedya Ananta Toer", "Dipinjam"});
        model.addRow(new Object[]{"3", "Filosofi Teras", "Henry Manampiring", "Tersedia"});

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnTutup = new JButton("Tutup");
        btnTutup.addActionListener(e -> dispose());
        add(btnTutup, BorderLayout.SOUTH);
    }
}