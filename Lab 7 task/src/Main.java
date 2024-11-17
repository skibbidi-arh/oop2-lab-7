import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserManager userManager = UserManager.getInstance(); // Access the singleton instance


        userManager.addUser("admin1", "admin1@example.com", "adminpass", "admin");


        User admin = userManager.authenticate("admin1", "adminpass", "admin");
        if (admin != null) {
            System.out.println("Welcome, Admin!");
        }


        userManager.addUser("user1", "user1@example.com", "userpass", "regular");


        User regularUser = userManager.authenticate("user1", "userpass", "regular");
        if (regularUser != null) {
            System.out.println("Welcome, Regular User!");
        }


        userManager.listLoggedInUsers();


        userManager.logout(regularUser);

        
        userManager.listLoggedInUsers();
    }
}
