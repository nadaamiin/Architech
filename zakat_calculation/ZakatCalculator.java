package zakat_calculation;
import Assets.Asset;

public class ZakatCalculator {
    private ZakatCalcStrategy strategy;

    public ZakatCalculator(ZakatCalcStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(Asset asset) {
        return strategy.calculate(asset);
    }
}
