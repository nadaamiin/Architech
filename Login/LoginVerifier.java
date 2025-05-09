package Login;

/**
 * Abstract decorator class for login verification.
 * This class provides the base functionality for different types of login verifications,
 * such as username verification, password verification, etc. Each specific verification
 * class will extend this class and implement the verification logic.
 * The decorator pattern is used to wrap and chain multiple verification steps.
 */
public abstract class LoginVerifier implements LoginService {
    /**
     * The {@link LoginService} object that this verifier wraps.
     * This allows the chain of verifiers to delegate the login check to the next step.
     */
    protected LoginService wrappee;

    /**
     * Constructs a {@code LoginVerifier} that wraps another {@link LoginService} object.
     * This allows the verification chain to be built dynamically by chaining different verifiers.
     *
     * @param wrappee the next {@code LoginService} in the verification chain
     */
    public LoginVerifier(LoginService wrappee) {
        this.wrappee = wrappee;
    }

    /**
     * This method must be implemented by concrete verifiers to perform their specific verification.
     * The method delegates the login process to the next verification step in the chain.
     *
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return {@code true} if the login is successful according to this verifier, {@code false} otherwise
     */
    @Override
    public abstract boolean login(String username, String password);
}
