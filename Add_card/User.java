package Add_card;

public class User {
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
    public void setUserId(String userId) {
        this.userId = userId;

    }
    public String getUserId() {
        return userId;
    }
}

