import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CreateAccount {
Scanner sc = new Scanner(System.in);
Checkmail cm = new Checkmail();
String FileName = "user.csv";

    void inputuser() throws IOException {
        Random rand = new Random();
        int n = rand.nextInt(100);
        String username;
        String password;
        String type;
        String userId;
        String email;

        userId = Integer.toString(generateRandom6DigitNumber());
        System.out.println("Enter userID: "+userId);

        System.out.println("Enter username: ");
        username = sc.nextLine();
        System.out.println("Enter email: ");
        email = sc.nextLine();
        if(cm.isEmailExists(this.FileName, email))
        {
            System.out.println("Email already exists");


        }
        System.out.println("Enter password: ");
        password = sc.nextLine();
        System.out.println("Enter type: ");
        type = sc.nextLine();
        writeSingleRowToCSV(FileName,userId,email,username,password,type);


    }



     void writeSingleRowToCSV(String filePath,String userID, String username,String email, String password, String type) throws IOException {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

             String rowData = userID + "," + username + "," + email + "," + password + "," + type;
             writer.write(rowData);
             writer.newLine();


         } catch (IOException e) {
             throw new IOException("Error writing to CSV file: " + e.getMessage(), e);
         }


    }

    public static int generateRandom6DigitNumber() {
        Random random = new Random();
        // Generate a random number between 100,000 and 999,999 (inclusive)
        int randomNumber = 100000 + random.nextInt(900000);
        return randomNumber;
    }



}
