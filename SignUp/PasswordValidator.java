package SignUp;
import Core.UserData;

/**
 * Concrete validator class that validates the password during the sign-up process.
 * This class extends the {@link SignUpValidator} abstract class and provides
 * the specific validation logic for the password field.
 * The password is checked to ensure it is not empty, its length is less than or equal to 100 characters,
 * and it includes at least one uppercase letter and either a number or a special character.
 */
public class PasswordValidator extends SignUpValidator {
    /**
     * Validates the password field of the provided {@link UserData}.
     * The password is checked to make sure it is not null, not empty, its length is less than or equal to 100 characters,
     * and it includes at least one uppercase letter and either a number or a special character.
     *
     * @param user the {@link UserData} object containing the user's details
     * @return {@code true} if the password is valid, {@code false} otherwise
     */
    @Override
    public boolean validate(UserData user) {
        String password = user.getPassword();

        return password != null &&
                !password.isEmpty() &&
                password.length() <= 100 &&
                password.matches(".*[A-Z].*") &&  // contains at least one uppercase letter
                (password.matches(".*[0-9].*") || password.matches(".*[!@#$%^&*()_+=\\-].*"));  // contains either a number or a special character
    }
}
