package SignUp;
import Core.UserData;
import Core.DatabaseConnector;

// validating username
// it extends the abstract class sign up validator
public class UsernameValidator extends SignUpValidator {
    // object of database
    // it uses the database class to compare with the usernames already stored to check for uniqueness
    private DatabaseConnector dbConnector;

    public UsernameValidator(DatabaseConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    // check the file of stored database to see if the username is unique or no
    // and check to make sure username is unique, not empty and length <= 50
    @Override
    public boolean validate(UserData user) {
        String username = user.getUsername();
        return username != null &&
                username.length() <= 50 &&
                !dbConnector.searchForUser(username);
    }
}
