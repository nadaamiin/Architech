package SignUp;

// interface
// it defines the behaviour of sign up
// so the signUpOperation class will have to provide implementation for this class
public interface SignUpService {
    void signup(String name, String username, String email, String password);
}
