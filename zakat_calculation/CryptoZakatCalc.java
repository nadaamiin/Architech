package zakat_calculation;

import Assets.Asset;

public class CryptoZakatCalc implements ZakatCalcStrategy {
    @Override
    public double calculate(Asset asset) {
        return asset.getPrice() * asset.getQuantity() * 0.025;
    }
}

