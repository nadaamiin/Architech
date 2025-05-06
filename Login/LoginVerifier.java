package Login;

// abstract decorator class which contains the base class for the different verifications
// each verification method extends the abstract class and provides its implementation
public abstract class LoginVerifier implements LoginService {
    protected LoginService wrappee;

    public LoginVerifier(LoginService wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public abstract boolean login(String username, String password);
}
