package SignUp;

/**
 * Defines the contract for sign-up operations.
 *
 * <p>Any class that implements this interface must provide logic for registering a new user,
 * including handling of user input and validation.</p>
 */
public interface SignUpService {

    /**
     * Attempts to sign up a user with the provided details.
     *
     * @param name     the full name of the user
     * @param username the desired username
     * @param email    the user's email address
     * @param password the user's password
     * @return true if sign-up is successful; false otherwise
     */
    boolean signup(String name, String username, String email, String password);
}
