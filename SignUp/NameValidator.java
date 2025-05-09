package SignUp;
import Core.UserData;

/**
 * Concrete validator class that validates the name during the sign-up process.
 * This class extends the {@link SignUpValidator} abstract class and provides
 * the specific validation logic for the name field.
 * The name is checked to ensure it is not empty, its length is less than or equal to 100 characters,
 * and it consists only of alphabetic characters and spaces.
 */
public class NameValidator extends SignUpValidator {
    /**
     * Validates the name field of the provided {@link UserData}.
     * The name is checked to make sure it is not null, its length is less than or equal to 100 characters,
     * and it only contains alphabetic characters and spaces.
     *
     * @param user the {@link UserData} object containing the user's details
     * @return {@code true} if the name is valid, {@code false} otherwise
     */
    @Override
    public boolean validate(UserData user) {
        String name = user.getName();
        return name != null && name.length() <= 100 && name.matches("[a-zA-Z ]+");
    }
}
