package Assets;
import java.io.*;
import java.util.*;
import java.lang.IllegalArgumentException;

import Core.UserData;
public class Portfolio {

    private static final String ASSETS_FILE = "assets.txt";
    //Create list of Assets
    private java.util.List<Asset> assets = new java.util.ArrayList<>();

    private UserData user;

    public UserData getOwner() {
        return user;
    }


    public void addAsset(Asset asset) {
        if (validateAsset(asset)) {
            List<Asset> assets = loadAssetsFromFile();
            assets.add(asset);
            saveAssetsToFile(assets);
        }
    }

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

    public void removeAsset(int assetID, String username) {
        List<Asset> assets = loadAssetsFromFile();
        assets.removeIf(asset -> asset.getAssetID() == assetID && asset.getUsername().equals(username));
        saveAssetsToFile(assets);
    }

    public Asset getAsset(int assetID, String username) {
        for (Asset asset : loadAssetsFromFile()) {
            if (asset.getAssetID() == assetID && asset.getUsername().equals(username)) {
                return asset;
            }
        }
        return null;
    }

    public List<Asset> getAllAssets() {
        return loadAssetsFromFile();
    }

    public List<Asset> getUserAssets(String username) {
        List<Asset> userAssets = new ArrayList<>();
        for (Asset asset : loadAssetsFromFile()) {
            if (asset.getUsername().equals(username)) {
                userAssets.add(asset);
            }
        }
        return userAssets;
    }

    private boolean validateAsset(Asset asset) {
        return asset.getName() != null && !asset.getName().isEmpty() &&
                asset.getQuantity() > 0 && asset.getPrice() >= 0;
    }

    public List<AssetTypes> getAvailableAssetTypes() {
        return Arrays.asList(AssetTypes.values());
    }

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

