import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Student Placement Management");
        System.out.println("          System");
        System.out.println("=================================");

        System.out.println("1. Student");
        System.out.println("2. Admin");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Student Login");
                break;

            case 2:
                System.out.println("Admin Login");
                break;

            case 3:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}