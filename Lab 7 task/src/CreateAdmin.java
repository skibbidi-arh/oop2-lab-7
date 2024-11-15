import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CreateAdmin {
    Scanner sc = new Scanner(System.in);
    Checkmail cm = new Checkmail();
    String FileName = "admin.csv";

    void inputAdmin() throws IOException {
        String username;
        String password;
        String userId;
        String email;

        userId = Integer.toString(generateRandom6DigitNumber());
        System.out.println("Generated Admin ID: " + userId);

        System.out.println("Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter email: ");
        email = sc.nextLine();
        if (cm.isEmailExists(this.FileName, email)) {
            System.out.println("Email already exists");
            return;
        }
        System.out.println("Enter password: ");
        password = sc.nextLine();

        writeSingleRowToCSV(FileName, userId, email, username, password);
    }

    void writeSingleRowToCSV(String filePath, String userID, String username, String email, String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String rowData = userID + "," + username + "," + email + "," + password;
            writer.append(rowData);
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Error writing to CSV file: " + e.getMessage(), e);
        }
    }

    public static int generateRandom6DigitNumber() {
        Random random = new Random();
        // Generate a random number between 100,000 and 999,999 (inclusive)
        return 100000 + random.nextInt(900000);
    }
}
