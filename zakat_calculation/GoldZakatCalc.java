package zakat_calculation;
import Assets.Asset;

/**
 * Strategy class for calculating zakat on gold assets.
 * Applies a fixed zakat rate of 2.5% (0.025) to the total value of the gold,
 * calculated as price per unit multiplied by quantity.
 */
public class GoldZakatCalc implements ZakatCalcStrategy {

    /**
     * Calculates the zakat for a given gold asset.
     * The zakat is 2.5% of the total value (price × quantity).
     *
     * @param asset the gold asset for which zakat is to be calculated
     * @return the zakat amount, which is 2.5% of the total asset value
     */
    @Override
    public double calculate(Asset asset) {
        return asset.getPrice() * asset.getQuantity() * 0.025;
    }
}

