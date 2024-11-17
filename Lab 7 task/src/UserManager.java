import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static UserManager instance; // Singleton instance
    private Map<String, User> loggedInUsers = new HashMap<>();


    private UserManager() {

    }


    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }


    public User authenticate(String username, String password, String userType) throws IOException {
        Authentication auth;
        if (userType.equalsIgnoreCase("admin")) {
            auth = new AuthenticateAdmin();
        } else {
            auth = new AuthenticateUser();
        }

        if (auth.authenticate(username, password)) {
            return createUser(username, password, userType);
        } else {
            System.out.println("Authentication failed for " + username);
            return null;
        }
    }


    public User createUser(String username, String password, String userType) throws IOException {
        Checkmail checkMail = new Checkmail();
        String email = findEmail(username, userType);

        if (email == null) {
            System.out.println("User not found in the system.");
            return null;
        }

        switch (userType.toLowerCase()) {
            case "admin":
                return new AdminUser(username, email, password);
            case "power":
                return new PowerUser(username, email, password, "power");
            case "regular":
                return new RegularUser(username, email, password, "regular");
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }


    private String findEmail(String username, String userType) throws IOException {
        String filePath = userType.equalsIgnoreCase("admin") ? "admin.csv" : "user.csv";
        Checkmail checkMail = new Checkmail();
        return checkMail.isEmailExists(filePath, username) ? username + "@example.com" : null;
    }


    public void addUser(String username, String email, String password, String userType) throws IOException {
        switch (userType.toLowerCase()) {
            case "admin":
                new CreateAdmin(username, email, password);
                break;
            case "power":
            case "regular":
                new CreateAccount(username, email, password, userType);
                break;
            default:
                throw new IllegalArgumentException("Invalid user type for creation: " + userType);
        }
    }


    public void logout(User user) {
        if (loggedInUsers.containsKey(user.Username)) {
            loggedInUsers.remove(user.Username);
            System.out.println(user.Username + " has been logged out.");
        } else {
            System.out.println("User not found in logged-in users.");
        }
    }


    public void listLoggedInUsers() {
        if (loggedInUsers.isEmpty()) {
            System.out.println("No users are currently logged in.");
        } else {
            loggedInUsers.forEach((key, value) -> System.out.println(key + " (" + value.getType() + ")"));
        }
    }
}
