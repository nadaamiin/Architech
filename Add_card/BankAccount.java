package Add_card;

import java.time.LocalDateTime;

public class BankAccount {
    private final User user;
    private final Bank bank;
    private final CardInfo cardInfo;
    private final LocalDateTime linkedAt;

    public BankAccount(User user, Bank bank, CardInfo cardInfo) {
        this.user = user;
        this.bank = bank;
        this.cardInfo = cardInfo;
        this.linkedAt = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public LocalDateTime getLinkedAt() {
        return linkedAt;
    }
}
