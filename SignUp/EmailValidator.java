package SignUp;
import Core.UserData;

/**
 * Concrete validator class that validates the email during the sign-up process.
 * This class extends the {@link SignUpValidator} abstract class and provides
 * the specific validation logic for the email field.
 * The email is checked to ensure it's not empty, doesn't exceed 100 characters,
 * and matches a valid email format.
 */
public class EmailValidator extends SignUpValidator {
    /**
     * Validates the email field of the provided {@link UserData}.
     * The email is checked to make sure it is not null, its length is less than or equal to 100 characters,
     * and it matches the standard email format.
     *
     * @param user the {@link UserData} object containing the user's details
     * @return {@code true} if the email is valid, {@code false} otherwise
     */
    @Override
    public boolean validate(UserData user) {
        String email = user.getEmail();
        return email != null &&
                email.length() <= 100 &&
                email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }
}
