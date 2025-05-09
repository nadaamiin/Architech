package Add_card;

/**
 * Represents a user in the system with an associated bank account.
 * This class allows adding, removing, and retrieving the user's bank account.
 */
public class User {
    /**
     * The unique ID of the user.
     */
    private String userId;

    /**
     * The bank account associated with this user.
     */
    private BankAccount bankAccount;

    /**
     * Adds a bank account to the user if one does not already exist.
     *
     * @param account the {@link BankAccount} to add
     */
    public void addAccount(BankAccount account) {
        if (this.bankAccount == null) {
            this.bankAccount = account;
        }
    }

    /**
     * Returns the bank account associated with the user.
     *
     * @return the user's {@link BankAccount}, or {@code null} if no account exists
     */
    public BankAccount getAccount() {
        return bankAccount;
    }

    /**
     * Removes the user's bank account if one exists.
     *
     * @return {@code true} if the account was removed, {@code false} if no account existed
     */
    public boolean removeAccount() {
        if (this.bankAccount != null) {
            this.bankAccount = null;
            return true;
        }
        return false;
    }

    /**
     * Sets the user's unique ID.
     *
     * @param userId the unique ID to assign to the user
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns the user's unique ID.
     *
     * @return the user's unique ID
     */
    public String getUserId() {
        return userId;
    }
}
