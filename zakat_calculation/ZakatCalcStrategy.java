package zakat_calculation;

import Assets.Asset;

/**
 * Strategy interface for zakat calculation.
 * Implementations of this interface provide specific calculation logic
 * for different types of assets (e.g., gold, stocks, real estate).
 */
public interface ZakatCalcStrategy {

    /**
     * Calculates the zakat owed for a given asset.
     *
     * @param asset the asset for which zakat is to be calculated
     * @return the zakat amount based on the specific asset type
     */
    double calculate(Asset asset);
}
