package Add_card;
import Core.UserData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CardDBConnector {
    private final String cardFilePath;

    public CardDBConnector(String cardFilePath) {
        this.cardFilePath = cardFilePath;
    }

    public void saveCardData(Bank bank, CardInfo card, User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cardFilePath, true))) {
            writer.write(user.getUserId() + "," +
                    bank.getName() + "," +
                    bank.getBankId() + "," +
                    card.getCardNumber() + "," +
                    card.getCardHolderName() + "," +
                    card.getExpiryDate() + "," +
                    card.getCvv());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
