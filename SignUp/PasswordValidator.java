package SignUp;
import Core.UserData;


// password validator
// it extends the abstract class sign up validator
public class PasswordValidator extends SignUpValidator {
    // check to make sure password is <100 characters
    //include an uppercase letter, numbers and/or special characters
    @Override
    public boolean validate(UserData user) {
        String password = user.getPassword();

        return password != null &&
                !password.isEmpty() &&
                password.length() <= 100 &&
                password.matches(".*[A-Z].*") &&
                (password.matches(".*[0-9].*") || password.matches(".*[!@#$%^&*()_+=\\-].*"));
    }
}
