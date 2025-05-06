class Asset {
    private int assetID;
    private AssetTypes assetType;
    private String name;
    private int quantity;
    private java.util.Date purchaseDate;
    private double price;

    public Asset(int assetID, AssetTypes assetType, String name, int quantity, java.util.Date purchaseDate, double price) {
        this.assetID = assetID;
        this.assetType = assetType;
        this.name = name;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.price = price;
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

    public AssetTypes getAssetType() {
        return assetType;
    }

    public java.util.Date getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return "Asset ID: " + assetID + ", Name: " + name + ", Type: " + assetType + ", Quantity: " + quantity + ", Date: " + purchaseDate + ", Price: " + price;
    }
}