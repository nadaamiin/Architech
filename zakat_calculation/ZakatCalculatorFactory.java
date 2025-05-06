package zakat_calculation;
import Assets.AssetTypes;

public class ZakatCalculatorFactory {
    public static ZakatCalcStrategy getCalculator(AssetTypes type) {
        return switch (type) {
            case Crypto -> new CryptoZakatCalc();
            case Gold -> new GoldZakatCalc();
            case Stock -> new StockZakatCalc();
            case Real_Estate -> new EstateZakatCalc();
            default -> throw new InvalidAssetExp("Unsupported asset type: " + type);
        };
    }
}

