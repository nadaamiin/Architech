package Login;

/**
 * Defines the behavior for login operations.
 * Any class implementing this interface must provide the implementation for the {@code login} method.
 * This allows for flexible login handling, including the use of different login verification strategies.
 */
public interface LoginService {

    /**
     * Attempts to authenticate a user with the provided username and password.
     * Implementations of this method will define the logic for validating the user's credentials.
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return {@code true} if the login is successful, {@code false} if the credentials are invalid
     */
    boolean login(String username, String password);
}
