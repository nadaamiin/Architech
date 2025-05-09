package Login;

/**
 * This class implements the {@link LoginService} interface and serves as the core
 * of the login operation using the decorator pattern.
 * It wraps different verifiers (e.g., username and password verifiers) to build a chain of checks
 * for the login process.
 */
public class LoginOperation implements LoginService {
    /**
     * The next step in the decorator chain for verifying login credentials.
     * This can be a username verifier, password verifier, or any other future verification steps.
     */
    private LoginService loginCheck;

    /**
     * Constructs a {@code LoginOperation} with a specified file path for the password verification.
     * The login operation chain first verifies the username, and then the password,
     * using the decorator pattern where each verifier is wrapped around the next.
     *
     * @param filePath the file path used for password verification
     */
    public LoginOperation(String filePath) {
        // Create a chain of verifiers where the username is verified first, followed by the password.
        this.loginCheck = new UsernameVerifier(
                new PasswordVerifier(null, filePath),
                filePath);
    }

    /**
     * Attempts to login by verifying the provided username and password.
     * This method delegates the login process to the first step in the chain (username verification)
     * and continues through the chain of decorators.
     *
     * @param username the username provided by the user
     * @param password the password provided by the user
     * @return {@code true} if both username and password are valid, {@code false} otherwise
     */
    @Override
    public boolean login(String username, String password) {
        return loginCheck.login(username, password);
    }
}
