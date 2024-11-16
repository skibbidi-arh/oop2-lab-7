public class PowerUser extends User {

    public PowerUser(String Username, String email, String password, String type) {

        this.Username = Username;
        this.email = email;
        this.password = password;
        this.type = type;

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

