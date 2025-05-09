package Assets;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Represents a user's asset that is subject to zakat calculation.
 * Stores details such as asset type, quantity, purchase date, price, and ownership.
 */
public class Asset {
    private int assetID;
    private AssetTypes assetType;
    private String name;
    private int quantity;
    private java.util.Date purchaseDate;
    private double price;
    private String username; // Link to user

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Constructs a new Asset with the specified properties.
     *
     * @param assetID      Unique identifier for the asset.
     * @param assetType    The type of the asset (e.g., GOLD, STOCK).
     * @param name         The name of the asset.
     * @param quantity     The quantity or amount of the asset.
     * @param purchaseDate The date the asset was acquired.
     * @param price        The price per unit of the asset.
     * @param username     The username of the asset's owner.
     */
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


    /**
     * Gets the name of the asset.
     *
     * @return The asset name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the asset.
     *
     * @param name The new name of the asset.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the quantity of the asset.
     *
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the asset.
     *
     * @param quantity The new quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the purchase date of the asset.
     *
     * @param date The new purchase date.
     */
    public void setDate(java.util.Date date) {
        this.purchaseDate = date;
    }

    /**
     * Gets the price per unit of the asset.
     *
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price per unit of the asset.
     *
     * @param price The new price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the unique ID of the asset.
     *
     * @return The asset ID.
     */
    public int getAssetID() {
        return assetID;
    }

    /**
     * Gets the username of the asset's owner.
     *
     * @return The owner's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the type of the asset.
     *
     * @return The asset type.
     */
    public AssetTypes getAssetType() {
        return assetType;
    }

    /**
     * Gets the date the asset was purchased.
     *
     * @return The purchase date.
     */
    public java.util.Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Returns a CSV-style string representation of the asset.
     *
     * @return A string containing asset details.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return assetID + "," + name + "," + assetType + "," + quantity + "," +
                sdf.format(purchaseDate) + "," + price + "," + username;
    }


    /**
     * Creates an Asset object from a pipe-separated string.
     *
     * @param line A string in the format "id|type|name|quantity|date|price|username".
     * @return A new {@link Asset} instance based on the parsed values.
     * @throws ParseException if the date format is invalid.
     */
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