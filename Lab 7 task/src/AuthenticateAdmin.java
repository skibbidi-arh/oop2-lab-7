import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AuthenticateAdmin implements  Authentication{


    @Override
    public boolean authenticate(String username, String password) {
        String line;
        String filePath="admin.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[2].equals(username) && values[3].equals(password)) {
                    return true;
                }

            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return false;


    }




}
