import SignUp.SignUpService;
import SignUp.SignUpOperation;
import Login.LoginOperation;
import Login.LoginService;

public class Main {
    public static void main(String[] args) {

        // signing a user
        SignUpService service = new SignUpOperation();
        service.signup("Niall Horan", "Niall32", "NiallHoran@gmail.com", "Horan1direction");

        // login
        LoginOperation login = new LoginOperation("users.txt");
        // successful log in
        login.login("alice123", "secure1Pass");
        // username and password don't match
        login.login("alice123", "securepass");
        // non-existing user
        login.login("bob321", "pass123");

    }
}