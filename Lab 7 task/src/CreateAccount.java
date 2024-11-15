import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CreateAccount {
    public CreateAccount(String Username, String email, String password, String type) throws IOException {
        inputuser(Username,  email,  password,type);
    }

Scanner sc = new Scanner(System.in);
Checkmail cm = new Checkmail();
String FileName = "user.csv";

    void inputuser(String Username, String email, String password, String type) throws IOException {
        Random rand = new Random();
        int n = rand.nextInt(100);


        String userId;


        userId = Integer.toString(generateRandom6DigitNumber());
        System.out.println(" userID: "+userId);


        if(cm.isEmailExists(this.FileName, email))
        {
            System.out.println("Email already exists");


        }

        writeSingleRowToCSV(FileName,userId,email,Username,password,type);


    }



     void writeSingleRowToCSV(String filePath,String userID, String username,String email, String password, String type) throws IOException {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {

             String rowData = userID + "," + username + "," + email + "," + password + "," + type;
             writer.append(rowData);
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
