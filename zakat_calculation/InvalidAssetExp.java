package zakat_calculation;

/**
 * Custom unchecked exception thrown when an invalid asset is encountered
 * during zakat calculation.
 */
public class InvalidAssetExp extends RuntimeException {

    /**
     * Constructs a new {@code InvalidAssetExp} with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InvalidAssetExp(String message) {
        super(message);
    }
}
