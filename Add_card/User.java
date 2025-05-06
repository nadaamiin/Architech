package Add_card;

public class User {
    private String name;
    private String userId;
    private BankAccount bankAccount;

    public void addAccount(BankAccount account) {
        if (this.bankAccount == null) {
            this.bankAccount = account;
        }
    }

    public BankAccount getAccount() {
        return bankAccount;
    }

    public boolean removeAccount() {
        if (this.bankAccount != null) {
            this.bankAccount = null;
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}

