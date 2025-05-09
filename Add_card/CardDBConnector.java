package Add_card;
import Core.UserData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles saving card data to a file.
 * This class allows storing user, bank, and card information into a specified file.
 */
public class CardDBConnector {

    /**
     * The file path where card data will be saved.
     */
    private final String cardFilePath;

    /**
     * Constructs a {@code CardDBConnector} with the specified file path to save card data.
     *
     * @param cardFilePath the file path where card data will be stored
     */
    public CardDBConnector(String cardFilePath) {
        this.cardFilePath = cardFilePath;
    }

    /**
     * Saves the card data (user, bank, card information) to a file.
     * The data is written as a CSV line with user ID, bank name, bank ID, card number,
     * cardholder name, expiry date, and CVV.
     *
     * @param bank the bank associated with the card
     * @param card the card information to be saved
     * @param user the user who owns the card
     */
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
