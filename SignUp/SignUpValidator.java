package SignUp;

import Core.UserData;

/**
 * Abstract base class for validating different fields of a user during sign-up.
 *
 * <p>Each subclass should implement a specific validation strategy
 * (e.g., username, password, email, or name validation).</p>
 */
public abstract class SignUpValidator {

    /**
     * Validates a specific attribute of the given {@link UserData} object.
     *
     * @param user the user data to validate
     * @return true if the validation passes; false otherwise
     */
    public abstract boolean validate(UserData user);
}
