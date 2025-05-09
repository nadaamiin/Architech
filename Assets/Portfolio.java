package Assets;
import java.io.*;
import java.util.*;
import java.lang.IllegalArgumentException;
import Core.UserData;

/**
 * Represents a user's portfolio of assets and provides functionality
 * to add, edit, remove, and retrieve assets from persistent storage.
 */
public class Portfolio {

    private static final String ASSETS_FILE = "assets.txt";
    private java.util.List<Asset> assets = new java.util.ArrayList<>();

    private UserData user;

    /**
     * Returns the owner (user) of the portfolio.
     *
     * @return the {@link UserData} object representing the owner.
     */
    public UserData getOwner() {
        return user;
    }


    /**
     * Adds an asset to the portfolio after validating it and saves it to the file.
     *
     * @param asset the asset to be added.
     */
    public void addAsset(Asset asset) {
        if (validateAsset(asset)) {
            List<Asset> assets = loadAssetsFromFile();
            assets.add(asset);
            saveAssetsToFile(assets);
        }
    }

    /**
     * Edits an existing asset identified by its ID.
     *
     * @param assetID      the ID of the asset to edit.
     * @param updatedAsset the new asset details to replace the old one.
     */
    public void editAsset(int assetID, Asset updatedAsset) {
        if (!validateAsset(updatedAsset)) return;

        List<Asset> assets = loadAssetsFromFile();
        for (int i = 0; i < assets.size(); i++) {
            if (assets.get(i).getAssetID() == assetID &&
                    assets.get(i).getUsername().equals(updatedAsset.getUsername())) {
                assets.set(i, updatedAsset);
                saveAssetsToFile(assets);
                return;
            }
        }
    }

    /**
     * Removes an asset from the portfolio based on its ID and username.
     *
     * @param assetID  the ID of the asset to be removed.
     * @param username the username of the asset's owner.
     */
    public void removeAsset(int assetID, String username) {
        List<Asset> assets = loadAssetsFromFile();
        assets.removeIf(asset -> asset.getAssetID() == assetID && asset.getUsername().equals(username));
        saveAssetsToFile(assets);
    }

    /**
     * Retrieves a specific asset by ID and username.
     *
     * @param assetID  the ID of the asset.
     * @param username the username of the asset owner.
     * @return the matching {@link Asset} or null if not found.
     */
    public Asset getAsset(int assetID, String username) {
        for (Asset asset : loadAssetsFromFile()) {
            if (asset.getAssetID() == assetID && asset.getUsername().equals(username)) {
                return asset;
            }
        }
        return null;
    }

    /**
     * Returns a list of all assets stored in the portfolio.
     *
     * @return a list of all {@link Asset} instances.
     */
    public List<Asset> getAllAssets() {
        return loadAssetsFromFile();
    }

    /**
     * Returns a list of assets belonging to a specific user.
     *
     * @param username the username to filter assets by.
     * @return a list of {@link Asset} objects for that user.
     */
    public List<Asset> getUserAssets(String username) {
        List<Asset> userAssets = new ArrayList<>();
        for (Asset asset : loadAssetsFromFile()) {
            if (asset.getUsername().equals(username)) {
                userAssets.add(asset);
            }
        }
        return userAssets;
    }

    /**
     * Validates the given asset to ensure it has valid data.
     *
     * @param asset the asset to validate.
     * @return true if the asset is valid, false otherwise.
     */
    private boolean validateAsset(Asset asset) {
        return asset.getName() != null && !asset.getName().isEmpty() &&
                asset.getQuantity() > 0 && asset.getPrice() >= 0;
    }

    /**
     * Returns a list of all available asset types.
     *
     * @return a list of {@link AssetTypes} enums.
     */
    public List<AssetTypes> getAvailableAssetTypes() {
        return Arrays.asList(AssetTypes.values());
    }

    /**
     * Saves the given list of assets to a file for persistence.
     *
     * @param assets the list of assets to save.
     */
    private void saveAssetsToFile(List<Asset> assets) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ASSETS_FILE))) {
            for (Asset asset : assets) {
                writer.write(asset.getAssetID() + "," +
                        asset.getAssetType() + "," +
                        asset.getName() + "," +
                        asset.getQuantity() + "," +
                        asset.getPurchaseDate().getTime() + "," +  // store date as timestamp
                        asset.getPrice() + "," +
                        asset.getUsername());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving assets: " + e.getMessage());
        }
    }


    /**
     * Loads all assets from the persistent file.
     *
     * @return a list of loaded {@link Asset} objects.
     */
    private List<Asset> loadAssetsFromFile() {
        List<Asset> assets = new ArrayList<>();
        File file = new File(ASSETS_FILE);
        if (!file.exists()) return assets;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 7) continue;

                int id = Integer.parseInt(parts[0]);
                AssetTypes type = AssetTypes.valueOf(parts[1]);
                String name = parts[2];
                int quantity = Integer.parseInt(parts[3]);
                Date date = new Date(Long.parseLong(parts[4]));
                double price = Double.parseDouble(parts[5]);
                String username = parts[6];

                assets.add(new Asset(id, type, name, quantity, date, price, username));
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error loading assets: " + e.getMessage());
        }

        return assets;
    }
}

