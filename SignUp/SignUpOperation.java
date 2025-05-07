package SignUp;

import java.util.ArrayList;
import java.util.List;
import Core.UserData;
import Core.DatabaseConnector;

// it validates the input data using sign up validator abstract class

public class SignUpOperation implements SignUpService {
    // uses database connector to get the stored data
    private DatabaseConnector dbConnector;
    // storing the validators into a list to check each one individually
    private List<SignUpValidator> fields;

    // constructor
    public SignUpOperation() {

        this.dbConnector = new DatabaseConnector("users.txt");
        this.fields = new ArrayList<>();

        // Strategy pattern is used
        fields.add(new UsernameValidator(dbConnector));
        fields.add(new PasswordValidator());
        fields.add(new NameValidator());
        fields.add(new EmailValidator());
    }

    // implementing the signup method from the interface sign up service
    @Override
    public boolean signup(String name, String username, String email, String password) {
        // object of user data
        UserData user = new UserData(name, username, email, password);

        // for each field, will check validation for it
        for (SignUpValidator validator : fields) {
            // if one of the fields didn't pass the validation check, will output invalid
            if (!validator.validate(user)) {
                System.out.println("Sign up failed!!");
                return false;
            }
        }

        // else, validation successful and will add it to the file
        dbConnector.addUser(user);
        System.out.println("Profile Created.");
        return true;
    }
}
