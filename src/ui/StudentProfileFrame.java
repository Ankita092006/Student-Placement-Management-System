package ui;

import database.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentProfileFrame extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField departmentField;
    private JTextField cgpaField;

    private int studentId;

    public StudentProfileFrame(int studentId) {

        this.studentId = studentId;

        setTitle("Student Profile");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel titleLabel =
                new JLabel("Student Profile",
                        SwingConstants.CENTER);

        JLabel idLabel =
                new JLabel("Student ID:");

        JLabel nameLabel =
                new JLabel("Name:");

        JLabel emailLabel =
                new JLabel("Email:");

        JLabel departmentLabel =
                new JLabel("Department:");

        JLabel cgpaLabel =
                new JLabel("CGPA:");

        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        departmentField = new JTextField();
        cgpaField = new JTextField();

        idField.setEditable(false);
        emailField.setEditable(false);

        JButton updateButton =
                new JButton("Update Profile");

        JButton closeButton =
                new JButton("Close");

        panel.add(titleLabel);
        panel.add(new JLabel(""));

        panel.add(idLabel);
        panel.add(idField);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(departmentLabel);
        panel.add(departmentField);

        panel.add(cgpaLabel);
        panel.add(cgpaField);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(updateButton);
        buttonPanel.add(closeButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load student data
        loadStudentProfile();

        // Update button
        updateButton.addActionListener(e ->
                updateProfile());

        // Close button
        closeButton.addActionListener(e ->
                dispose());
    }


    // Load student profile
    private void loadStudentProfile() {

        String sql =
                "SELECT * FROM students WHERE id = ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                idField.setText(
                        String.valueOf(
                                rs.getInt("id")));

                nameField.setText(
                        rs.getString("name"));

                emailField.setText(
                        rs.getString("email"));

                departmentField.setText(
                        rs.getString("department"));

                cgpaField.setText(
                        String.valueOf(
                                rs.getDouble("cgpa")));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading profile!"
            );

            e.printStackTrace();
        }
    }


    // Update student profile
    private void updateProfile() {

        String name =
                nameField.getText();

        String department =
                departmentField.getText();

        String cgpaText =
                cgpaField.getText();

        if (name.isEmpty() ||
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

            String sql =
                    "UPDATE students " +
                    "SET name = ?, department = ?, cgpa = ? " +
                    "WHERE id = ?";

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, department);
            ps.setDouble(3, cgpa);
            ps.setInt(4, studentId);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Profile updated successfully!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Profile update failed!"
                );
            }

            ps.close();
            con.close();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid CGPA!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error updating profile!"
            );

            e.printStackTrace();
        }
    }


    // Main method for testing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Example student ID
            StudentProfileFrame frame =
                    new StudentProfileFrame(1);

            frame.setVisible(true);
        });
    }
}