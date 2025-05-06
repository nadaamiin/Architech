package Assets;

import Core.UserData;
public class Portfolio {
    //Create list of Assets
    private java.util.List<Asset> assets = new java.util.ArrayList<>();

    private UserData user;

    /*
    public Portfolio(UserData owner) {
        this.user = owner;
    }*/

    public UserData getOwner() {
        return user;
    }


    public void addAsset(Asset asset) {
        if (validateAsset(asset)) {
            assets.add(asset);
        }
    }

    public void editAsset(int assetID, Asset updatedAsset) {
        if (!validateAsset(updatedAsset)) return;

        for (int i = 0; i < assets.size(); i++) {
            if (assets.get(i).getAssetID() == assetID) {
                assets.set(i, updatedAsset);
                return;
            }
        }
    }

    public void removeAsset(int assetID) {
        assets.removeIf(asset -> asset.getAssetID() == assetID);
    }

    public Asset getAsset(int assetID) {
        for (Asset asset : assets) {
            if (asset.getAssetID() == assetID) {
                return asset;
            }
        }
        return null;
    }

    public java.util.List<Asset> getAllAssets() {
        return assets;
    }

    private boolean validateAsset(Asset asset) {
        return asset.getName() != null && !asset.getName().isEmpty() && asset.getQuantity() > 0 && asset.getPrice() >= 0;
    }

    public java.util.List<AssetTypes> getAvailableAssetTypes() {
        return java.util.Arrays.asList(AssetTypes.values());
    }

}

