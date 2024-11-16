public abstract class User {

    String UserId;
    String Username;
    String email;
    String password;
    String type;


    abstract String getType();
    abstract String getEmail();


    abstract void setPassword();




}
