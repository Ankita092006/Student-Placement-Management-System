package dao;

import database.DBConnection;
import model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyDAO {

    // Add company
    public void addCompany(Company company) {

        String sql = "INSERT INTO companies " +
                     "(name, job_role, package_amount, eligibility_cgpa) " +
                     "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, company.getName());
            ps.setString(2, company.getJobRole());
            ps.setDouble(3, company.getPackageAmount());
            ps.setDouble(4, company.getEligibilityCgpa());

            ps.executeUpdate();

            System.out.println("Company added successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error adding company!");
            e.printStackTrace();
        }
    }


    // Display all companies
    public void displayCompanies() {

        String sql = "SELECT * FROM companies";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------");

                System.out.println(
                        "Company ID: " +
                        rs.getInt("id")
                );

                System.out.println(
                        "Company Name: " +
                        rs.getString("name")
                );

                System.out.println(
                        "Job Role: " +
                        rs.getString("job_role")
                );

                System.out.println(
                        "Package: " +
                        rs.getDouble("package_amount") +
                        " LPA"
                );

                System.out.println(
                        "Minimum CGPA: " +
                        rs.getDouble("eligibility_cgpa")
                );
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println(
                    "Error displaying companies!"
            );

            e.printStackTrace();
        }
    }
}