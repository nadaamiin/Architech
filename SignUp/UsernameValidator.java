package SignUp;

import Core.UserData;
import Core.DatabaseConnector;

/**
 * Validates the username field during the sign-up process.
 *
 * <p>This validator ensures that the username:</p>
 * <ul>
 *     <li>Is not null</li>
 *     <li>Has a maximum length of 50 characters</li>
 *     <li>Is unique (not already present in the user database)</li>
 * </ul>
 */
public class UsernameValidator extends SignUpValidator {

    /** Connector to the user database for checking existing usernames. */
    private DatabaseConnector dbConnector;

    /**
     * Constructs a {@code UsernameValidator} and initializes the database connector.
     */
    public UsernameValidator() {
        this.dbConnector = new DatabaseConnector("users.txt");
    }

    /**
     * Validates the username of the given user.
     *
     * @param user the user data to validate
     * @return true if the username is non-null, within length limits, and unique; false otherwise
     */
    @Override
    public boolean validate(UserData user) {
        String username = user.getUsername();
        return username != null &&
                username.length() <= 50 &&
                !dbConnector.searchForUser(username);
    }
}
