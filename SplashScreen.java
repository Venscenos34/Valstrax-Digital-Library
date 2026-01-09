import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SplashScreen extends JWindow {
    private JProgressBar progressBar;
    private JLabel statusLabel;

    public SplashScreen() {
        // 1. Panel Utama dengan Gradient Biru-Ungu
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Warna Gradient Modern
                GradientPaint gp = new GradientPaint(0, 0, new Color(41, 128, 185), 0, getHeight(), new Color(142, 68, 173));
                g2d.setPaint(gp);
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            }
        };
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);

        // 2. Judul Aplikasi
        JLabel title = new JLabel("VALSTRAX DIGITAL LIBRARY");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(50, 50, 400, 40);
        mainPanel.add(title);

        // 3. Subtitle
        JLabel subtitle = new JLabel("The Place Where Books Come Alive");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(new Color(236, 240, 241));
        subtitle.setBounds(50, 85, 300, 20);
        mainPanel.add(subtitle);

        // 4. Status Loading (Teks yang berubah-ubah)
        statusLabel = new JLabel("Starting system...");
        statusLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setBounds(50, 180, 300, 20);
        mainPanel.add(statusLabel);

        // 5. Progress Bar Modern (Tipis & Transparan)
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(50, 210, 400, 6);
        progressBar.setBackground(new Color(255, 255, 255, 50));
        progressBar.setForeground(new Color(46, 204, 113));
        progressBar.setBorderPainted(false);
        mainPanel.add(progressBar);

        // 6. Konfigurasi Jendela (Membulat/Rounded)
        setContentPane(mainPanel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0)); // Transparan agar sudut membulat terlihat
        setVisible(true);

        runLoading();
    }

    private void runLoading() {
        // Menggunakan Timer agar UI tidak freeze dan bar jalan sampai 100
        Timer timer = new Timer(35, e -> {
            int value = progressBar.getValue();
            if (value < 100) {
                value++;
                progressBar.setValue(value);

                // Ubah status teks berdasarkan persen
                if (value == 20) statusLabel.setText("Inisialisasi modul...");
                if (value == 50) statusLabel.setText("Menghubungkan database...");
                if (value == 80) statusLabel.setText("Sinkronisasi file...");
            } else {
                ((Timer)e.getSource()).stop();
                dispose(); // Tutup splash
                new LoginScreen(); // Buka Login
            }
        });
        timer.start();
    }

   public static void main(String[] args) {
        // Look and Feel Windows
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(() -> new SplashScreen());
    }
}