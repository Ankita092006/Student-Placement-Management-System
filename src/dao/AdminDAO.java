package dao;

import database.DBConnection;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    // Add Admin
    public void addAdmin(Admin admin) {

        String sql = "INSERT INTO admins (name, email, password) " +
                     "VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());

            ps.executeUpdate();

            System.out.println("Admin added successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error adding admin!");
            e.printStackTrace();
        }
    }


    // Admin Login
    public boolean loginAdmin(String email, String password) {

        String sql = "SELECT * FROM admins " +
                     "WHERE email = ? AND password = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Admin login successful!");

                rs.close();
                ps.close();
                con.close();

                return true;
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Admin login error!");
            e.printStackTrace();
        }

        return false;
    }


    // Display all Admins
    public void displayAdmins() {

        String sql = "SELECT * FROM admins";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------");

                System.out.println("Admin ID: "
                        + rs.getInt("id"));

                System.out.println("Admin Name: "
                        + rs.getString("name"));

                System.out.println("Admin Email: "
                        + rs.getString("email"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error displaying admins!");
            e.printStackTrace();
        }
    }
}