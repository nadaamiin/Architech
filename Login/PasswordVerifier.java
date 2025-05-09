package Login;
import Core.UserData;
import Core.DatabaseConnector;
import java.util.List;

/**
 * Concrete decorator class that extends the login operation to verify the password.
 * After the username is verified by the preceding decorator, this class checks if
 * the provided password matches the one stored in the database.
 */
public class PasswordVerifier extends LoginVerifier {
    /**
     * The {@link DatabaseConnector} used to retrieve stored user data from the database file.
     */
    private DatabaseConnector dbconnector;

    /**
     * Constructs a {@code PasswordVerifier} to wrap the login verification chain.
     * This constructor initializes the {@link DatabaseConnector} with the provided file path
     * and passes the login verification chain to the parent constructor.
     *
     * @param wrappee the next step in the verification chain (e.g., username verification)
     * @param filePath the path to the file where user data is stored
     */
    public PasswordVerifier(LoginService wrappee, String filePath) {
        super(wrappee);
        this.dbconnector = new DatabaseConnector(filePath);
    }

    /**
     * Verifies the username and password against the stored users in the database.
     * It checks if the username exists and if the provided password matches the stored one.
     *
     * @param username the username provided by the user
     * @param password the password provided by the user
     * @return {@code true} if both username and password are correct, {@code false} otherwise
     */
    @Override
    public boolean login(String username, String password) {
        // Retrieve the list of stored users from the database
        List<UserData> users = dbconnector.getStoredUsers();

        // Loop through the list of users and check if the provided username and password match any stored entry
        for (UserData user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Successfully authenticated
            }
        }

        return false; // Authentication failed
    }
}
