package dao;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplicationDAO {

    // Apply for a company
    public void applyForCompany(int studentId, int companyId) {

        String sql = "INSERT INTO applications " +
                     "(student_id, company_id, status) " +
                     "VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, companyId);
            ps.setString(3, "Applied");

            ps.executeUpdate();

            System.out.println("Application submitted successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error submitting application!");
            e.printStackTrace();
        }
    }


    // Display all applications
    public void displayApplications() {

        String sql = "SELECT * FROM applications";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------");

                System.out.println("Application ID: "
                                   + rs.getInt("id"));

                System.out.println("Student ID: "
                                   + rs.getInt("student_id"));

                System.out.println("Company ID: "
                                   + rs.getInt("company_id"));

                System.out.println("Status: "
                                   + rs.getString("status"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error displaying applications!");
            e.printStackTrace();
        }
    }


    // Update application status
    public void updateStatus(int applicationId, String status) {

        String sql = "UPDATE applications " +
                     "SET status = ? WHERE id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, applicationId);

            ps.executeUpdate();

            System.out.println("Application status updated!");

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error updating application status!");
            e.printStackTrace();
        }
    }
}