import javax.swing.*;
import java.awt.*;

public class FormTambahBuku extends JDialog {
    public FormTambahBuku(JFrame parent) {
        super(parent, "Tambah Buku Baru", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("  Judul Buku:"));
        JTextField txtJudul = new JTextField();
        add(txtJudul);

        add(new JLabel("  Pengarang:"));
        JTextField txtAuthor = new JTextField();
        add(txtAuthor);

        JButton btnSimpan = new JButton("Simpan");
        JButton btnBatal = new JButton("Batal");

        btnSimpan.addActionListener(e -> {
            String judul = txtJudul.getText();
            if (!judul.isEmpty()) {
                // Di sini nanti hubungkan ke logic Simpan kamu
                JOptionPane.showMessageDialog(this, "Buku '" + judul + "' berhasil ditambahkan!");
                dispose();
            }
        });

        btnBatal.addActionListener(e -> dispose());

        add(btnSimpan);
        add(btnBatal);
    }
}