package model;

public class Admin {

    private int id;
    private String name;
    private String email;
    private String password;

    // Constructor
    public Admin(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    // Display admin details
    public void displayAdmin() {

        System.out.println("Admin ID: " + id);
        System.out.println("Admin Name: " + name);
        System.out.println("Admin Email: " + email);
    }
}
