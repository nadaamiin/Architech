package zakat_calculation;
import java.time.LocalDate;
import java.util.*;
import Assets.*;

public class ZakatReport {
    private List<Asset> assets = new ArrayList<>();
    private Map<String, LocalDate> zakatDates = new HashMap<>();
    private double totalZakatDue = 0.0;

    public void addAsset(Asset asset) {
        assets.add(asset);
        zakatDates.put(asset.getName(), LocalDate.now());
    }

    public void calcTotalZakat(ZakatCalculator calculator) {
        totalZakatDue = 0;
        for (Asset asset : assets) {
            calculator = new ZakatCalculator(ZakatCalculatorFactory.getCalculator(asset.getAssetType()));
            totalZakatDue += calculator.calculate(asset);
        }
    }

    public void generatePdf(String filename) {
        System.out.println("Generating PDF: " + filename);
        // Stub - integrate with iText or similar library if needed
    }

    public double getTotalZakatDue() {
        return totalZakatDue;
    }
}
