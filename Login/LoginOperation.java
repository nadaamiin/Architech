package Login;

// construct the decorator chain
// it implements the login service interface
public class LoginOperation implements LoginService {
    private LoginService loginCheck;

    // constructor
    public LoginOperation(String filePath) {
        // verify the username then password -> using decorator pattern where the objects are wrapped
        this.loginCheck = new UsernameVerifier(
                new PasswordVerifier(null, filePath),
                filePath);
    }

    @Override
    public boolean login(String username, String password) {
        return loginCheck.login(username, password);
    }
}

