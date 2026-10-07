package ui;

import dao.AdminDAO;

import javax.swing.*;
import java.awt.*;

public class AdminLoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    private AdminDAO adminDAO;

    public AdminLoginFrame() {

        adminDAO = new AdminDAO();

        setTitle("Admin Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel =
                new JLabel("Admin Login", SwingConstants.CENTER);

        JLabel emailLabel =
                new JLabel("Email:");

        JLabel passwordLabel =
                new JLabel("Password:");

        emailField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton =
                new JButton("Login");

        JButton backButton =
                new JButton("Back");

        panel.add(titleLabel);
        panel.add(new JLabel(""));

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(backButton);

        add(panel);

        // Login button
        loginButton.addActionListener(e -> loginAdmin());

        // Back button
        backButton.addActionListener(e -> {

            dispose();

            new LoginFrame().setVisible(true);
        });
    }


    // Admin Login Method
    private void loginAdmin() {

        String email = emailField.getText();

        String password =
                new String(passwordField.getPassword());


        // Check empty fields
        if (email.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter email and password!"
            );

            return;
        }


        // Check login
        boolean success =
                adminDAO.loginAdmin(email, password);


        if (success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Admin login successful!"
            );

            dispose();

            new AdminDashboard().setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid admin email or password!"
            );
        }
    }


    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AdminLoginFrame frame =
                    new AdminLoginFrame();

            frame.setVisible(true);
        });
    }
}
