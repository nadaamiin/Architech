package Core;

// class that is used to store and return users info
public class UserData {
    private String name;
    private String username;
    private String email;
    private String password;

    public UserData(){}
    // constructor
    public UserData(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // getters that are used to retrieve the stored data when validating each field
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setUsername(String username){
        this.username = username;
    }
}
