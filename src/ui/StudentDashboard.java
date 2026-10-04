package ui;

import service.PlacementService;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard extends JFrame {

    private PlacementService placementService;

    public StudentDashboard() {

        placementService = new PlacementService();

        setTitle("Student Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(5, 1, 10, 10)
        );

        JLabel title =
                new JLabel(
                        "Student Dashboard",
                        SwingConstants.CENTER
                );

        JButton companiesButton =
                new JButton("View Companies");

        JButton applyButton =
                new JButton("Apply for Company");

        JButton applicationsButton =
                new JButton("My Applications");

        JButton logoutButton =
                new JButton("Logout");

        panel.add(title);
        panel.add(companiesButton);
        panel.add(applyButton);
        panel.add(applicationsButton);
        panel.add(logoutButton);

        add(panel);


        // View Companies
        companiesButton.addActionListener(e -> {

            placementService.showCompanies();

            JOptionPane.showMessageDialog(
                    this,
                    "Companies are displayed in the terminal."
            );
        });


        // Apply for Company
        applyButton.addActionListener(e -> {

            String studentIdText =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Student ID:"
                    );

            String companyIdText =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Company ID:"
                    );

            try {

                int studentId =
                        Integer.parseInt(studentIdText);

                int companyId =
                        Integer.parseInt(companyIdText);

                placementService.applyForCompany(
                        studentId,
                        companyId
                );

                JOptionPane.showMessageDialog(
                        this,
                        "Application submitted!"
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid IDs!"
                );
            }
        });


        // My Applications
        applicationsButton.addActionListener(e -> {

            placementService.showApplications();

            JOptionPane.showMessageDialog(
                    this,
                    "Applications are displayed in the terminal."
            );
        });


        // Logout
        logoutButton.addActionListener(e -> {

            dispose();

            new LoginFrame().setVisible(true);
        });
    }


    // Main method for testing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentDashboard dashboard =
                    new StudentDashboard();

            dashboard.setVisible(true);
        });
    }
}
