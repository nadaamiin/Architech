package Add_card;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents the information associated with a credit or debit card.
 * This class holds the card number, cardholder name, expiry date, and CVV,
 * and provides validation methods to check the correctness of the card details.
 */
public class CardInfo {

    /**
     * The card number (16 digits).
     */
    private String cardNumber;

    /**
     * The name of the cardholder.
     */
    private String cardHolderName;

    /**
     * The expiry date of the card (in MM/yy or MM/yyyy format).
     */
    private String expiryDate;

    /**
     * The CVV/CVC code of the card (3 or 4 digits).
     */
    private String cvv;

    /**
     * Validates the card number to ensure it is exactly 16 digits.
     *
     * @return {@code true} if the card number is valid, {@code false} otherwise
     */
    public boolean isValidCardNumber() {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    /**
     * Validates the cardholder's name to ensure it is not null or empty.
     *
     * @return {@code true} if the cardholder's name is valid, {@code false} otherwise
     */
    public boolean isValidCardHolderName() {
        return cardHolderName != null && !cardHolderName.trim().isEmpty();
    }

    /**
     * Validates the CVV to ensure it is either 3 or 4 digits.
     *
     * @return {@code true} if the CVV is valid, {@code false} otherwise
     */
    public boolean isValidCVV() {
        return cvv != null && cvv.matches("\\d{3,4}");
    }

    /**
     * Validates the expiry date to ensure it is a valid date in the future or the current month.
     * The expiry date should be in either MM/yy or MM/yyyy format.
     *
     * @return {@code true} if the expiry date is valid, {@code false} otherwise
     */
    public boolean isValidExpiryDate() {
        if (expiryDate == null) return false;
        try {
            DateTimeFormatter formatter = expiryDate.length() == 5 ?
                    DateTimeFormatter.ofPattern("MM/yy") :
                    DateTimeFormatter.ofPattern("MM/yyyy");

            YearMonth expiry = YearMonth.parse(expiryDate, formatter);
            YearMonth now = YearMonth.now();
            return expiry.isAfter(now) || expiry.equals(now);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Validates the entire card information (card number, cardholder name, expiry date, and CVV).
     *
     * @return {@code true} if all card details are valid, {@code false} otherwise
     */
    public boolean isValidCardInfo() {
        return isValidCardNumber() && isValidCardHolderName() &&
                isValidExpiryDate() && isValidCVV();
    }

    /**
     * Sets the card number.
     *
     * @param cardNumber the card number to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Sets the cardholder's name.
     *
     * @param cardHolderName the cardholder's name to set
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    /**
     * Sets the expiry date of the card.
     *
     * @param expiryDate the expiry date to set
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Sets the CVV of the card.
     *
     * @param cvv the CVV to set
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Returns the card number.
     *
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Returns the cardholder's name.
     *
     * @return the cardholder's name
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Returns the expiry date of the card.
     *
     * @return the expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Returns the CVV of the card.
     *
     * @return the CVV
     */
    public String getCvv() {
        return cvv;
    }
}
