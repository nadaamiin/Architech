package zakat_calculation;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import Assets.*;

/**
 * Represents a report for calculating and tracking zakat owed on a user's assets.
 * This class stores assets, calculates total zakat due, and optionally generates a PDF report.
 */
public class ZakatReport {

    /** List of user assets included in the zakat calculation. */
    private List<Asset> assets = new ArrayList<>();

    /** Map storing the date on which zakat was calculated for each asset. */
    private Map<String, LocalDate> zakatDates = new HashMap<>();

    /** The total zakat due for all assets. */
    private double totalZakatDue = 0.0;

    /**
     * Adds an asset to the report and stores the current date as the zakat calculation date.
     *
     * @param asset The asset to be added.
     */
    public void addAsset(Asset asset) {
        assets.add(asset);
        zakatDates.put(asset.getName(), LocalDate.now());
    }

    /**
     * Returns the list of assets currently tracked in the report.
     *
     * @return A list of assets.
     */
    public List<Asset> getAssets() {
        return assets;
    }

    /**
     * Calculates the total zakat due for all assets using the appropriate calculator strategy
     * for each asset type.
     *
     * @param calculator A temporary calculator instance (will be replaced per asset type).
     */
    public void calcTotalZakat(ZakatCalculator calculator) {
        totalZakatDue = 0;
        for (Asset asset : assets) {
            calculator = new ZakatCalculator(ZakatCalculatorFactory.getCalculator(asset.getAssetType()));
            totalZakatDue += calculator.calculate(asset);
        }
    }

//    public void generatePdf(String filename) {
//        Document document = new Document();
//        try {
//            PdfWriter.getInstance(document, new FileOutputStream(filename));
//            document.open();
//
//            // Add title
//            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
//            Paragraph title = new Paragraph("Zakat Calculation Report", titleFont);
//            title.setAlignment(Element.ALIGN_CENTER);
//            document.add(title);
//
//            // Add date
//            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);
//            String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
//            document.add(new Paragraph("Report Date: " + formattedDate, normalFont));
//            document.add(Chunk.NEWLINE);
//
//            // Add assets section
//            Paragraph assetsHeader = new Paragraph("Assets Included in Calculation:",
//                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
//            document.add(assetsHeader);
//
//            for (Asset asset : assets) {
//                document.add(new Paragraph("- " + asset.getName() + ": " + asset.getQuantity() +
//                        " (Type: " + asset.getAssetType() + ")", normalFont));
//            }
//
//            document.add(Chunk.NEWLINE);
//
//            // Add total zakat
//            Paragraph total = new Paragraph("Total Zakat Due: " + totalZakatDue,
//                    new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD));
//            document.add(total);
//
//            document.close();
//            System.out.println("PDF report generated successfully: " + filename);
//        } catch (Exception e) {
//            System.err.println("Error generating PDF: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

    /**
     * Returns the total zakat due for all the assets in the report.
     *
     * @return The total zakat due.
     */
    public double getTotalZakatDue() {
        return totalZakatDue;
    }
}
