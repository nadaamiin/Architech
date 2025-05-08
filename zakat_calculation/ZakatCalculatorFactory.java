package zakat_calculation;
import Assets.AssetTypes;

public class ZakatCalculatorFactory {
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

