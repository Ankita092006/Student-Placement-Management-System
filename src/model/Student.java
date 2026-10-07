package model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String password;
    private String department;
    private double cgpa;

    // Constructor
    public Student(int id, String name, String email,
                   String password, String department,
                   double cgpa) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public double getCgpa() {
        return cgpa;
    }

    // Display student details
    public void displayStudent() {

        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
    }
}
