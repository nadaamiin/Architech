package Add_card;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CardInfo {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public boolean isValidCardNumber() {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    public boolean isValidCardHolderName() {
        return cardHolderName != null && !cardHolderName.trim().isEmpty();
    }

    public boolean isValidCVV() {
        return cvv != null && cvv.matches("\\d{3,4}");
    }

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

    public boolean isValidCardInfo() {
        return isValidCardNumber() && isValidCardHolderName() &&
                isValidExpiryDate() && isValidCVV();
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public String getCvv() {
        return cvv;
    }
}
