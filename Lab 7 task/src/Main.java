import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        //account.inputuser();
        //User u =new RegularUser("arham","sfgfdgfdwe","tokecdi","regular");
       // AdminUser ad = new AdminUser("admin","agaas","admin");
        AuthenticateAdmin admin = new AuthenticateAdmin();
       boolean b= admin.authenticate("admin", "admin");
        System.out.println(b);

    }
}