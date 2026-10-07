package ui;

import database.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyFrame extends JFrame {

    private JTable companyTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public CompanyFrame() {

        setTitle("Available Companies");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Top panel
        JPanel topPanel = new JPanel(new FlowLayout());

        JLabel searchLabel = new JLabel("Search:");

        searchField = new JTextField(20);

        JButton searchButton =
                new JButton("Search");

        JButton refreshButton =
                new JButton("Refresh");

        JButton closeButton =
                new JButton("Close");

        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(refreshButton);

        // Table
        String[] columns = {
                "ID",
                "Company",
                "Job Role",
                "Package (LPA)",
                "Minimum CGPA"
        };

        tableModel = new DefaultTableModel(columns, 0);

        companyTable = new JTable(tableModel);

        JScrollPane scrollPane =
                new JScrollPane(companyTable);

        // Bottom panel
        JPanel bottomPanel = new JPanel();

        bottomPanel.add(closeButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Load all companies
        loadCompanies("");

        // Search button
        searchButton.addActionListener(e -> {

            String keyword =
                    searchField.getText();

            loadCompanies(keyword);
        });

        // Refresh button
        refreshButton.addActionListener(e -> {

            searchField.setText("");

            loadCompanies("");
        });

        // Close button
        closeButton.addActionListener(e -> dispose());
    }


    // Load companies from MySQL
    private void loadCompanies(String keyword) {

        tableModel.setRowCount(0);

        String sql =
                "SELECT * FROM companies " +
                "WHERE name LIKE ? " +
                "OR job_role LIKE ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            String searchKeyword =
                    "%" + keyword + "%";

            ps.setString(1, searchKeyword);
            ps.setString(2, searchKeyword);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Object[] row = {

                    rs.getInt("id"),

                    rs.getString("name"),

                    rs.getString("job_role"),

                    rs.getDouble("package_amount"),

                    rs.getDouble("eligibility_cgpa")
                };

                tableModel.addRow(row);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading companies!"
            );

            e.printStackTrace();
        }
    }


    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CompanyFrame frame =
                    new CompanyFrame();

            frame.setVisible(true);
        });
    }
}
