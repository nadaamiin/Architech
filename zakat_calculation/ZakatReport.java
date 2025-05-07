//package zakat_calculation;
////import com.itextpdf.text.*;
////import com.itextpdf.text.pdf.PdfWriter;
//import java.io.FileOutputStream;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.List;
//
//import Assets.*;
//
//public class ZakatReport {
//    private List<Asset> assets = new ArrayList<>();
//    private Map<String, LocalDate> zakatDates = new HashMap<>();
//    private double totalZakatDue = 0.0;
//
//    public void addAsset(Asset asset) {
//        assets.add(asset);
//        zakatDates.put(asset.getName(), LocalDate.now());
//    }
//
//    public void calcTotalZakat(ZakatCalculator calculator) {
//        totalZakatDue = 0;
//        for (Asset asset : assets) {
//            calculator = new ZakatCalculator(ZakatCalculatorFactory.getCalculator(asset.getAssetType()));
//            totalZakatDue += calculator.calculate(asset);
//        }
//    }
//
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
//
//    public double getTotalZakatDue() {
//        return totalZakatDue;
//    }
//}
