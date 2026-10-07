package service;

import dao.StudentDAO;
import model.Student;

public class StudentService {

    private StudentDAO studentDAO;

    // Constructor
    public StudentService() {
        studentDAO = new StudentDAO();
    }

    // Register student
    public void registerStudent(Student student) {
        studentDAO.addStudent(student);
    }

    // Student login
    public boolean loginStudent(String email, String password) {
        return studentDAO.loginStudent(email, password);
    }

    // Display all students
    public void showStudents() {
        System.out.println("===== Student List =====");
        studentDAO.displayStudents();
    }
}
