package zakat_calculation;
import Assets.AssetTypes;

/**
 * A factory class for creating instances of {@link ZakatCalcStrategy}
 * based on the provided {@link AssetTypes}.
 */
public class ZakatCalculatorFactory {

    /**
     * Returns a Zakat calculator strategy based on the asset type.
     *
     * @param type The type of asset for which zakat needs to be calculated.
     * @return An instance of {@link ZakatCalcStrategy} appropriate for the asset type.
     * @throws InvalidAssetExp if the asset type is unsupported.
     */
    public static ZakatCalcStrategy getCalculator(AssetTypes type) {
        return switch (type) {
            case CRYPTO -> new CryptoZakatCalc();
            case GOLD -> new GoldZakatCalc();
            case STOCK -> new StockZakatCalc();
            case REAL_ESTATE -> new EstateZakatCalc();
            default -> throw new InvalidAssetExp("Unsupported asset type: " + type);
        };
    }
}

