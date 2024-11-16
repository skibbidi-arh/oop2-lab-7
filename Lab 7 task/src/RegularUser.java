import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;



public class RegularUser extends User  {

    public RegularUser(String Username, String email, String password, String type) throws IOException {

        this.Username = Username;
        this.email = email;
        this.password = password;
        this.type = type;
        CreateAccount c =new CreateAccount(Username,  email,  password,type);


    }



    @Override
    String getType() {
        return this.type;
    }

    @Override
    String getEmail() {
        return email;
    }

    @Override
    void setPassword() {
        System.out.println("ok");
    }





}
