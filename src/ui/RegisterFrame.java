package ui;

import model.Student;
import service.AuthService;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField departmentField;
    private JTextField cgpaField;

    private AuthService authService;

    public RegisterFrame() {

        authService = new AuthService();

        setTitle("Student Registration");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(7, 2, 10, 10)
        );

        JLabel titleLabel =
                new JLabel(
                        "Student Registration",
                        SwingConstants.CENTER
                );

        JLabel nameLabel =
                new JLabel("Name:");

        JLabel emailLabel =
                new JLabel("Email:");

        JLabel passwordLabel =
                new JLabel("Password:");

        JLabel departmentLabel =
                new JLabel("Department:");

        JLabel cgpaLabel =
                new JLabel("CGPA:");

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        departmentField = new JTextField();
        cgpaField = new JTextField();

        JButton registerButton =
                new JButton("Register");

        JButton backButton =
                new JButton("Back to Login");

        panel.add(titleLabel);
        panel.add(new JLabel(""));

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(departmentLabel);
        panel.add(departmentField);

        panel.add(cgpaLabel);
        panel.add(cgpaField);

        panel.add(registerButton);
        panel.add(backButton);

        add(panel);

        // Register button
        registerButton.addActionListener(
                e -> registerStudent()
        );

        // Back button
        backButton.addActionListener(e -> {

            dispose();

            new LoginFrame().setVisible(true);
        });
    }


    // Register student
    private void registerStudent() {

        String name =
                nameField.getText();

        String email =
                emailField.getText();

        String password =
                new String(
                        passwordField.getPassword()
                );

        String department =
                departmentField.getText();

        String cgpaText =
                cgpaField.getText();


        if (name.isEmpty() ||
            email.isEmpty() ||
            password.isEmpty() ||
            department.isEmpty() ||
            cgpaText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!"
            );

            return;
        }


        try {

            double cgpa =
                    Double.parseDouble(cgpaText);

            Student student =
                    new Student(
                            0,
                            name,
                            email,
                            password,
                            department,
                            cgpa
                    );

            authService.registerStudent(student);

            JOptionPane.showMessageDialog(
                    this,
                    "Registration successful!"
            );

            dispose();

            new LoginFrame().setVisible(true);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid CGPA!"
            );
        }
    }


    // Main method for testing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            RegisterFrame registerFrame =
                    new RegisterFrame();

            registerFrame.setVisible(true);
        });
    }
}
