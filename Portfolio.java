import Core.UserData;
public class Portfolio {
    private UserData user;

    public Portfolio(UserData owner) {
        this.user = owner;
    }

    public UserData getOwner() {
        return user;
    }

    // portfolio
}
