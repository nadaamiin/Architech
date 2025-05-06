package zakat_calculation;

import Assets.Asset;

public interface ZakatCalcStrategy {
    double calculate(Asset asset);
}
