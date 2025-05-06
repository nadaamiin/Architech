package Login;
import Core.UserData;
import Core.DatabaseConnector;
import java.util.List;

// concrete decorator -> extends the log in operation to verify password
// after the username is verified, the wrappee object is passed to check if the username and password match
public class PasswordVerifier extends LoginVerifier {
    private DatabaseConnector dbconnector;

    // constructor
    public PasswordVerifier(LoginService wrappee, String filePath) {
        super(wrappee);
        this.dbconnector = new DatabaseConnector(filePath);
    }

    // provides implementation for the login operation
    @Override
    public boolean login(String username, String password) {
        // storing the users that are stored in the database file
        List<UserData> users = dbconnector.getStoredUsers();
        for (UserData user : users) {
            // looping over the list, and checking if the input username and password match
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // logged in successfully
                System.out.println("Logged in successfully!! Welcome Back " + user.getName());
                return true;
            }
        }

        // username and password don't match
        System.out.println("Login failed: invalid username or password!!");
        return false;
    }
}

