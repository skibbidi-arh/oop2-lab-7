import java.io.IOException;

public class AdminUser extends User {

    public AdminUser(String Username, String email, String password) throws IOException {

        this.Username = Username;
        this.email = email;
        this.password = password;
        this.type = "admin";
        CreateAdmin admin = new CreateAdmin(this.Username, this.email, this.password);

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
