package SignUp;
import Core.UserData;

// email validator
// it extends the abstract class sign up validator
public class EmailValidator extends SignUpValidator {
    // validating the email to make sure not empty, <= 100 characters and in the correct email format
    @Override
    public boolean validate(UserData user) {
        String email = user.getEmail();
        return email != null &&
                email.length() <= 100 &&
                email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
    }
}
