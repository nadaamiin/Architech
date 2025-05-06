package Login;

// interface
// it defines the behaviour of login
// so the Login operation class will have to provide implementation for this class
public interface LoginService {
    boolean login(String username, String password);
}
