package SignUp;
import Core.UserData;

// validating the input name
// it extends the abstract class sign up validator
public class NameValidator extends SignUpValidator {
    // validating the name to make sure it is not empty, length <= 100 characters and is structured text
    @Override
    public boolean validate(UserData user) {
        String name = user.getName();
        return name != null && name.length() <= 100 && name.matches("[a-zA-Z ]+");
    }
}
