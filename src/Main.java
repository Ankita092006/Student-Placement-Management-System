import javax.swing.SwingUtilities;
import ui.LoginFrame;

public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("     STUDENT PLACEMENT MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("Starting application...");

        SwingUtilities.invokeLater(() -> {

            try {

                LoginFrame loginFrame =
                        new LoginFrame();

                loginFrame.setVisible(true);

                System.out.println(
                        "Application started successfully!"
                );

            } catch (Exception e) {

                System.out.println(
                        "Error starting application!"
                );

                e.printStackTrace();
            }
        });
    }
}