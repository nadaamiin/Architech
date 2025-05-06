import SignUp.SignUpService;
import SignUp.SignUpOperation;
import Login.LoginOperation;
import Login.LoginService;

public class Main {
    public static void main(String[] args) {

        // signing a user
        SignUpService service = new SignUpOperation();
        service.signup("Niall Horan", "Niall32", "NiallHoran@gmail.com", "Horan1direction");

        // login
        LoginOperation login = new LoginOperation("users.txt");
        // successful log in
        login.login("alice123", "secure1Pass");
        // username and password don't match
        login.login("alice123", "securepass");
        // non-existing user
        login.login("bob321", "pass123");

        Portfolio portfolio = new Portfolio();

        Asset asset1 = new Asset(1, AssetTypes.Stock, "Tesla", 10, new java.util.Date(), 700.0);
        Asset asset2 = new Asset(2, AssetTypes.Crypto, "Bitcoin", 2, new java.util.Date(), 30000.0);

        portfolio.addAsset(asset1);
        portfolio.addAsset(asset2);

        System.out.println("Assets in Portfolio:");
        for (Asset asset : portfolio.getAllAssets()) {
            System.out.println(asset);
        }

        System.out.println("\nEditing Asset 1");
        asset1.setPrice(750.0);
        portfolio.editAsset(asset1.getAssetID(), asset1);

        System.out.println("\nUpdated Assets:");
        for (Asset asset : portfolio.getAllAssets()) {
            System.out.println(asset);
        }

        System.out.println("\nRemoving Asset 2");
        portfolio.removeAsset(2);

        System.out.println("\nFinal Assets:");
        for (Asset asset : portfolio.getAllAssets()) {
            System.out.println(asset);
        }


    }
}