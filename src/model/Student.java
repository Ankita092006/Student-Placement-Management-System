package model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String department;
    private double cgpa;

    public Student(int id, String name, String email,
                   String department, double cgpa) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;
    }

    public void displayStudent() {

        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
    }
}