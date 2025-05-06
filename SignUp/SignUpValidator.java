package SignUp;
import Core.UserData;

// abstract class which contains the base class for the different validations
// each validation method extends the abstract class and provides its implementation
public abstract class SignUpValidator {
    public abstract boolean validate(UserData user);
}
