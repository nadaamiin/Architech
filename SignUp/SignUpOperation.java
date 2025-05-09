package SignUp;

import java.util.ArrayList;
import java.util.List;
import Core.UserData;
import Core.DatabaseConnector;

/**
 * Handles the sign-up process for new users by validating input fields
 * and storing user data using the {@link DatabaseConnector}.
 *
 * <p>This class uses the Strategy Pattern to apply multiple validation rules
 * defined by implementations of {@link SignUpValidator}.</p>
 */
public class SignUpOperation implements SignUpService {
    private DatabaseConnector dbConnector;
    private List<SignUpValidator> fields;

    /**
     * Constructs a new SignUpOperation instance.
     * Initializes the database connector and sets up the validators using the Strategy Pattern.
     */
    public SignUpOperation() {
        this.dbConnector = new DatabaseConnector("users.txt");
        this.fields = new ArrayList<>();

        // Add all field-specific validators (strategies)
        fields.add(new UsernameValidator());
        fields.add(new PasswordValidator());
        fields.add(new NameValidator());
        fields.add(new EmailValidator());
    }

    /**
     * Attempts to sign up a user by validating the input and saving the data if all fields pass.
     *
     * @param name     the full name of the user
     * @param username the chosen username
     * @param email    the user's email address
     * @param password the chosen password
     * @return true if the sign-up is successful; false otherwise
     */
    @Override
    public boolean signup(String name, String username, String email, String password) {
        UserData user = new UserData(name, username, email, password);

        // Validate each field using its validator
        for (SignUpValidator validator : fields) {
            if (!validator.validate(user)) {
                System.out.println("Sign up failed!!");
                return false;
            }
        }

        // All validations passed; add user to storage
        dbConnector.addUser(user);
        System.out.println("\n--> Profile Created <--\n");
        return true;
    }
}
