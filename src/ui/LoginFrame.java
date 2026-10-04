package ui;

import service.AuthService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private AuthService authService;

    public LoginFrame() {

        authService = new AuthService();

        setTitle("Student Placement Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel =
                new JLabel("Login", SwingConstants.CENTER);

        JLabel emailLabel =
                new JLabel("Email:");

        JLabel passwordLabel =
                new JLabel("Password:");

        emailField = new JTextField();

        passwordField = new JPasswordField();

        JButton loginButton =
                new JButton("Login");

        JButton registerButton =
                new JButton("Register");

        panel.add(titleLabel);
        panel.add(new JLabel(""));

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(registerButton);

        add(panel);

        // Login button
        loginButton.addActionListener(e -> login());

        // Register button
        registerButton.addActionListener(e -> {

            dispose();

            new RegisterFrame().setVisible(true);
        });
    }


    // Login method
    private void login() {

        String email = emailField.getText();

        String password =
                new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter email and password!"
            );

            return;
        }

        boolean success =
                authService.login(email, password);

        if (success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!"
            );

            dispose();

            new StudentDashboard().setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid email or password!"
            );
        }
    }


    // Main method for testing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            LoginFrame loginFrame =
                    new LoginFrame();

            loginFrame.setVisible(true);
        });
    }
}