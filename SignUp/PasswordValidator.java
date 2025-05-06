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

        // if empty
        if (password == null || password.isEmpty()) {
            System.out.println("Invalid! Password cannot be empty.");
            return false;
        }

        // if length > 100
        if (password.length() > 100) {
            System.out.println("Invalid! Password cannot be >100 characters.");
            return false;
        }

        // checking to see if it contains at least one uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Invalid! Password must contain at least one uppercase letter.");
            return false;
        }

        // checking to see if it contains a special character or a number
        if (!password.matches(".*[0-9].*") && !password.matches(".*[!@#$%^&*()_+=\\-].*")) {
            System.out.println("Invalid! Password must contain at least one number or one special character.");
            return false;
        }

        return true;
    }
}
