package zakat_calculation;
import Assets.Asset;

/**
 * Strategy class for calculating zakat on stock assets.
 * Applies a zakat rate of 2.5% (0.025) to the total value of the stocks,
 * calculated as the price per unit multiplied by the quantity held.
 */
public class StockZakatCalc implements ZakatCalcStrategy {

    /**
     * Calculates the zakat for a given stock asset.
     * The zakat is 2.5% of the total value (price × quantity).
     *
     * @param asset the stock asset for which zakat is to be calculated
     * @return the zakat amount, which is 2.5% of the total asset value
     */
    @Override
    public double calculate(Asset asset) {
        return asset.getPrice() * asset.getQuantity() * 0.025;
    }
}

