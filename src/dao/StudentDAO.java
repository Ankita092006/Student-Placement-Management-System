package dao;

import database.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Add student to database
    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(name, email, password, department, cgpa) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getDepartment());
            ps.setDouble(5, student.getCgpa());

            ps.executeUpdate();

            System.out.println("Student added successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error adding student!");
            e.printStackTrace();
        }
    }

    // Display all students
    public void displayStudents() {

        String sql = "SELECT * FROM students";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Department: "
                                   + rs.getString("department"));
                System.out.println("CGPA: "
                                   + rs.getDouble("cgpa"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error displaying students!");
            e.printStackTrace();
        }
    }
}
