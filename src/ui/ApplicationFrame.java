package ui;

import dao.ApplicationDAO;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {

    private JTextField studentIdField;
    private JTextField companyIdField;

    private ApplicationDAO applicationDAO;

    public ApplicationFrame() {

        applicationDAO = new ApplicationDAO();

        setTitle("Job Application");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel =
                new JLabel("Apply for Job", SwingConstants.CENTER);

        JLabel studentIdLabel =
                new JLabel("Student ID:");

        JLabel companyIdLabel =
                new JLabel("Company ID:");

        studentIdField = new JTextField();
        companyIdField = new JTextField();

        JButton applyButton =
                new JButton("Apply");

        JButton viewButton =
                new JButton("View Applications");

        JButton closeButton =
                new JButton("Close");

        panel.add(titleLabel);
        panel.add(new JLabel(""));

        panel.add(studentIdLabel);
        panel.add(studentIdField);

        panel.add(companyIdLabel);
        panel.add(companyIdField);

        panel.add(applyButton);
        panel.add(viewButton);

        panel.add(closeButton);
        panel.add(new JLabel(""));

        add(panel);

        // Apply button
        applyButton.addActionListener(e -> applyForJob());

        // View applications button
        viewButton.addActionListener(e -> viewApplications());

        // Close button
        closeButton.addActionListener(e -> dispose());
    }


    // Apply for company
    private void applyForJob() {

        String studentIdText =
                studentIdField.getText();

        String companyIdText =
                companyIdField.getText();

        if (studentIdText.isEmpty() ||
            companyIdText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter Student ID and Company ID!"
            );

            return;
        }

        try {

            int studentId =
                    Integer.parseInt(studentIdText);

            int companyId =
                    Integer.parseInt(companyIdText);

            applicationDAO.applyForCompany(
                    studentId,
                    companyId
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Application submitted successfully!"
            );

            studentIdField.setText("");
            companyIdField.setText("");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric IDs!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error submitting application!"
            );
        }
    }


    // View applications
    private void viewApplications() {

        applicationDAO.displayApplications();

        JOptionPane.showMessageDialog(
                this,
                "Application details are displayed in the terminal."
        );
    }


    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ApplicationFrame frame =
                    new ApplicationFrame();

            frame.setVisible(true);
        });
    }
}
