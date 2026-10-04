package model;

public class Company {

    private int id;
    private String name;
    private String jobRole;
    private double packageAmount;
    private double eligibilityCgpa;

    // Constructor
    public Company(int id, String name, String jobRole,
                   double packageAmount, double eligibilityCgpa) {

        this.id = id;
        this.name = name;
        this.jobRole = jobRole;
        this.packageAmount = packageAmount;
        this.eligibilityCgpa = eligibilityCgpa;
    }

    // Display company details
    public void displayCompany() {

        System.out.println("Company ID: " + id);
        System.out.println("Company Name: " + name);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Package: " + packageAmount + " LPA");
        System.out.println("Minimum CGPA: " + eligibilityCgpa);
    }
}