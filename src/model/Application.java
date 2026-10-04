package model;

public class Application {

    private int id;
    private int studentId;
    private int companyId;
    private String status;

    // Constructor
    public Application(int id, int studentId,
                       int companyId, String status) {

        this.id = id;
        this.studentId = studentId;
        this.companyId = companyId;
        this.status = status;
    }

    // Display application details
    public void displayApplication() {

        System.out.println("Application ID: " + id);
        System.out.println("Student ID: " + studentId);
        System.out.println("Company ID: " + companyId);
        System.out.println("Status: " + status);
    }
}
