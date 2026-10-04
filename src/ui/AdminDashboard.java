package ui;

import dao.CompanyDAO;
import dao.ApplicationDAO;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private CompanyDAO companyDAO = new CompanyDAO();
    private ApplicationDAO applicationDAO = new ApplicationDAO();

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel(
                "Admin Dashboard",
                SwingConstants.CENTER
        );

        JButton addCompanyButton =
                new JButton("Add Company");

        JButton viewCompaniesButton =
                new JButton("View Companies");

        JButton viewApplicationsButton =
                new JButton("View Applications");

        JButton logoutButton =
                new JButton("Logout");

        panel.add(title);
        panel.add(addCompanyButton);
        panel.add(viewCompaniesButton);
        panel.add(viewApplicationsButton);
        panel.add(logoutButton);

        add(panel);

        // Add Company
        addCompanyButton.addActionListener(e -> addCompany());

        // View Companies
        viewCompaniesButton.addActionListener(e -> {

            companyDAO.displayCompanies();

            JOptionPane.showMessageDialog(
                    this,
                    "Companies are displayed in the terminal."
            );
        });

        // View Applications
        viewApplicationsButton.addActionListener(e -> {

            applicationDAO.displayApplications();

            JOptionPane.showMessageDialog(
                    this,
                    "Applications are displayed in the terminal."
            );
        });

        // Logout
        logoutButton.addActionListener(e -> {

            dispose();

            JOptionPane.showMessageDialog(
                    null,
                    "Admin logged out successfully!"
            );
        });
    }


    // Add company method
    private void addCompany() {

        String name = JOptionPane.showInputDialog(
                this,
                "Enter Company Name:"
        );

        String jobRole = JOptionPane.showInputDialog(
                this,
                "Enter Job Role:"
        );

        String packageText = JOptionPane.showInputDialog(
                this,
                "Enter Package (LPA):"
        );

        String cgpaText = JOptionPane.showInputDialog(
                this,
                "Enter Minimum CGPA:"
        );

        try {

            double packageAmount =
                    Double.parseDouble(packageText);

            double eligibilityCgpa =
                    Double.parseDouble(cgpaText);

            model.Company company =
                    new model.Company(
                            0,
                            name,
                            jobRole,
                            packageAmount,
                            eligibilityCgpa
                    );

            companyDAO.addCompany(company);

            JOptionPane.showMessageDialog(
                    this,
                    "Company added successfully!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid details!"
            );
        }
    }


    // Main method for testing
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AdminDashboard dashboard =
                    new AdminDashboard();

            dashboard.setVisible(true);
        });
    }
}