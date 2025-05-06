package zakat_calculation;
import Assets.Asset;

public class EstateZakatCalc implements ZakatCalcStrategy {
    @Override
    public double calculate(Asset asset) {
        return asset.getPrice() * 0.025;
    }
}

