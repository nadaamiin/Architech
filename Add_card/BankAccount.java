package Add_card;

import java.time.LocalDateTime;

/**
 * Represents a bank account associated with a user.
 * This class holds the user's bank information, card details, and the date the account was linked.
 */
public class BankAccount {

    /**
     * The user associated with this bank account.
     */
    private final User user;

    /**
     * The bank where the account is held.
     */
    private final Bank bank;

    /**
     * The card information associated with the bank account.
     */
    private final CardInfo cardInfo;

    /**
     * The date and time when the bank account was linked.
     */
    private final LocalDateTime linkedAt;

    /**
     * Constructs a new bank account with the provided user, bank, and card information.
     * The account is automatically linked at the current date and time.
     *
     * @param user the user who owns the bank account
     * @param bank the bank where the account is held
     * @param cardInfo the card information associated with the account
     */
    public BankAccount(User user, Bank bank, CardInfo cardInfo) {
        this.user = user;
        this.bank = bank;
        this.cardInfo = cardInfo;
        this.linkedAt = LocalDateTime.now();
    }

    /**
     * Returns the user associated with this bank account.
     *
     * @return the user of the account
     */
    public User getUser() {
        return user;
    }

    /**
     * Returns the bank where the account is held.
     *
     * @return the bank of the account
     */
    public Bank getBank() {
        return bank;
    }


    /**
     * Returns the card information associated with the bank account.
     *
     * @return the card information of the account
     */
    public CardInfo getCardInfo() {
        return cardInfo;
    }

    /**
     * Returns the date and time when the bank account was linked.
     *
     * @return the date and time of linking
     */
    public LocalDateTime getLinkedAt() {
        return linkedAt;
    }
}
