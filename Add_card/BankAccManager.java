package Add_card;

public class BankAccManager {
    public BankAccount createAccount(User user, Bank bank, CardInfo cardInfo) {
        BankAccount account = new BankAccount(user, bank, cardInfo);
        user.addAccount(account);
        return account;
    }

    public boolean validateAccount(BankAccount account) {
        return account.getUser() != null &&
                account.getBank() != null &&
                account.getCardInfo().isValidCardInfo();
    }
}
