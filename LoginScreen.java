import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LoginScreen extends JFrame {
    public LoginScreen() {
        setUndecorated(true);
        setSize(400, 550);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(41, 128, 185), 0, getHeight(), new Color(142, 68, 173));
                g2d.setPaint(gp);
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
            }
        };
        mainPanel.setLayout(null);

        // Logo
        try {
            ImageIcon icon = new ImageIcon("logo.png");
            Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JLabel logo = new JLabel(new ImageIcon(img));
            logo.setBounds(160, 30, 80, 80);
            mainPanel.add(logo);
        } catch(Exception e) {}

        JLabel title = new JLabel("LOGIN SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(241, 196, 15)); // Kuning Emas
        title.setBounds(0, 120, 400, 40);
        mainPanel.add(title);

        JTextField userField = new JTextField();
        userField.setBounds(50, 200, 300, 40);
        userField.setBackground(new Color(0, 0, 0, 80));
        userField.setForeground(Color.WHITE);
        userField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
        mainPanel.add(userField);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(50, 280, 300, 40);
        passField.setBackground(new Color(0, 0, 0, 80));
        passField.setForeground(Color.WHITE);
        passField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.WHITE));
        mainPanel.add(passField);

        JButton loginBtn = new JButton("ACCESS SYSTEM");
        loginBtn.setBounds(50, 380, 300, 50);
        loginBtn.setBackground(new Color(236, 240, 241));
        loginBtn.setForeground(new Color(44, 62, 80)); // Teks Gelap
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginBtn.addActionListener(e -> {
            if(userField.getText().equals("admin") && new String(passField.getPassword()).equals("123")) {
                dispose();
                new LibraryGUI();
            } else {
                JOptionPane.showMessageDialog(null, "User/Pass Salah!");
            }
        });
        mainPanel.add(loginBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(150, 450, 100, 30);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setBorderPainted(false);
        exitBtn.addActionListener(e -> System.exit(0));
        mainPanel.add(exitBtn);

        add(mainPanel);
        setVisible(true);
    }
}