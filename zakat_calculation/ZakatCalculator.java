package zakat_calculation;
import Assets.Asset;

/**
 * Context class that uses a {@link ZakatCalcStrategy} to calculate zakat for a given asset.
 * This class allows different zakat calculation strategies to be used interchangeably.
 */
public class ZakatCalculator {

    /**
     * The zakat calculation strategy to be used.
     */
    private ZakatCalcStrategy strategy;

    /**
     * Constructs a {@code ZakatCalculator} with the specified strategy.
     *
     * @param strategy the zakat calculation strategy to be used
     */
    public ZakatCalculator(ZakatCalcStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the zakat for the given asset using the current strategy.
     *
     * @param asset the asset for which zakat is to be calculated
     * @return the zakat amount
     */
    public double calculate(Asset asset) {
        return strategy.calculate(asset);
    }
}
