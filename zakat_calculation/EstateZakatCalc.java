package zakat_calculation;
import Assets.Asset;

/**
 * Strategy class for calculating zakat on estate assets.
 * Applies a fixed zakat rate of 2.5% (0.025) to the asset's price.
 */
public class EstateZakatCalc implements ZakatCalcStrategy {

    /**
     * Calculates the zakat for a given estate asset.
     *
     * @param asset the asset for which zakat is to be calculated
     * @return the zakat amount, which is 2.5% of the asset's price
     */
    @Override
    public double calculate(Asset asset) {
        return asset.getPrice() * 0.025;
    }
}

