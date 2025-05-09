package zakat_calculation;

import Assets.Asset;

/**
 * Strategy class for calculating Zakat on cryptocurrency assets.
 * Applies a standard 2.5% rate on the total value of the crypto asset.
 */
public class CryptoZakatCalc implements ZakatCalcStrategy {

    /**
     * Calculates the Zakat owed for a cryptocurrency asset.
     * The formula used is: (price × quantity × 2.5%)
     *
     * @param asset The crypto asset for which Zakat is to be calculated
     * @return The calculated Zakat amount
     */
    @Override
    public double calculate(Asset asset) {
        return asset.getPrice() * asset.getQuantity() * 0.025;
    }
}
