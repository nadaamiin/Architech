package Login;

import Core.UserData;
import Core.DatabaseConnector;

// concrete decorator -> extends the log in operation to verify username
// then it passes the wrappee object to the password verifier
public class UsernameVerifier extends LoginVerifier {
    private DatabaseConnector dbconnector;

    // constructor
    public UsernameVerifier(LoginService wrappee, String filePath) {
        super(wrappee);
        this.dbconnector = new DatabaseConnector(filePath);
    }

    // providing implementation for the login method
    // first search for the username, if found, will return the wrappee object to then check the password
    @Override
    public boolean login(String username, String password) {
        if (!dbconnector.searchForUser(username)) {
            System.out.println("Login failed: Username not found!!");
            return false;
        }
        return wrappee.login(username, password);
    }
}

