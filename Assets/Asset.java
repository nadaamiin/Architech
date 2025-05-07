package Assets;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Asset {
    private int assetID;
    private AssetTypes assetType;
    private String name;
    private int quantity;
    private java.util.Date purchaseDate;
    private double price;
    private String username; // Link to user

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Asset(int assetID, AssetTypes assetType, String name, int quantity,
                 java.util.Date purchaseDate, double price, String username) {
        this.assetID = assetID;
        this.assetType = assetType;
        this.name = name;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.username = username;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(java.util.Date date) {
        this.purchaseDate = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAssetID() {
        return assetID;
    }

    public String getUsername() { return username; }


    public AssetTypes getAssetType() {
        return assetType;
    }

    public java.util.Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return assetID + "," + name + "," + assetType + "," + quantity + "," +
                sdf.format(purchaseDate) + "," + price + "," + username;
    }


    public static Asset fromString(String line) throws ParseException {
        String[] parts = line.split("\\|");
        int id = Integer.parseInt(parts[0]);
        AssetTypes type = AssetTypes.valueOf(parts[1]);
        String name = parts[2];
        int quantity = Integer.parseInt(parts[3]);
        Date date = sdf.parse(parts[4]);
        double price = Double.parseDouble(parts[5]);
        String username = parts[6];
        return new Asset(id, type, name, quantity, date, price, username);
    }
}