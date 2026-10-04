package service;

import dao.StudentDAO;
import model.Student;

public class AuthService {

    private StudentDAO studentDAO = new StudentDAO();

    // Student Registration
    public void registerStudent(Student student) {

        studentDAO.addStudent(student);

        System.out.println("Registration completed!");
    }

    // Student Login
    public boolean login(String email, String password) {

        // For now, we will check login using StudentDAO
        return studentDAO.loginStudent(email, password);
    }
}