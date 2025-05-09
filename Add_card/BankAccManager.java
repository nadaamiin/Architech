package Add_card;

/**
 * Manages the creation and validation of bank accounts for users.
 * This class provides methods to create new accounts and validate existing ones.
 */
public class BankAccManager {

    /**
     * Creates a new bank account for a user with the specified bank and card information.
     *
     * @param user the user who will own the new bank account
     * @param bank the bank associated with the new account
     * @param cardInfo the card information for the account
     * @return the newly created {@link BankAccount}
     */
    public BankAccount createAccount(User user, Bank bank, CardInfo cardInfo) {
        BankAccount account = new BankAccount(user, bank, cardInfo);
        user.addAccount(account);
        return account;
    }

    /**
     * Validates a bank account to ensure it has a valid user, bank, and card information.
     * A valid account must have a non-null user, a non-null bank, and valid card information.
     *
     * @param account the {@link BankAccount} to validate
     * @return {@code true} if the account is valid, {@code false} otherwise
     */
    public boolean validateAccount(BankAccount account) {
        return account.getUser() != null &&
                account.getBank() != null &&
                account.getCardInfo().isValidCardInfo();
    }
}
