package Login;

import Core.UserData;
import Core.DatabaseConnector;

/**
 * Concrete decorator class that extends the login operation to verify the username.
 * This class checks if the provided username exists in the stored database.
 * After the username is verified, the next step in the verification chain (e.g., password verification)
 * is delegated to the wrappee object.
 */
public class UsernameVerifier extends LoginVerifier {
    /**
     * The {@link DatabaseConnector} used to search for users in the stored database.
     */
    private DatabaseConnector dbconnector;

    /**
     * Constructs a {@code UsernameVerifier} to wrap the login verification chain.
     * This constructor initializes the {@link DatabaseConnector} with the provided file path
     * and passes the login verification chain to the parent constructor.
     *
     * @param wrappee the next step in the verification chain (e.g., password verification)
     * @param filePath the path to the file where user data is stored
     */
    public UsernameVerifier(LoginService wrappee, String filePath) {
        super(wrappee);
        this.dbconnector = new DatabaseConnector(filePath);
    }

    /**
     * Verifies if the username exists in the stored user data.
     * If the username exists, it delegates the verification process to the next step (password verification).
     *
     * @param username the username provided by the user
     * @param password the password provided by the user
     * @return {@code true} if the username exists and the password is valid, {@code false} otherwise
     */
    @Override
    public boolean login(String username, String password) {
        // First, verify if the username exists in the stored data
        return dbconnector.searchForUser(username) && wrappee.login(username, password);
    }
}
