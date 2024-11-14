import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Checkmail {


    public  boolean isEmailExists(String filePath, String email) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;


            reader.readLine();


            while ((line = reader.readLine()) != null) {

                String[] columns = line.split(",");


                if (columns.length > 1 && columns[2].trim().equalsIgnoreCase(email)) {
                    return true;
                }
            }

            return false;
        } catch (IOException e) {
            throw new IOException("Error reading the CSV file: " + e.getMessage(), e);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }


}
