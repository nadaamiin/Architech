import SignUp.SignUpService;
import SignUp.SignUpOperation;
import Login.LoginOperation;
import Login.LoginService;
import Add_card.User;
import Add_card.Bank;
import Add_card.BankAccount;
import Add_card.CardInfo;
import Add_card.BankAccManager;
import java.util.HashMap;
import java.util.Map;

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


        // Create a bank
        Bank bank = new Bank();
        bank.setName("Cairo Bank");
        bank.setBankId("CB001");
        bank.setValidBanks(new HashMap<>());

        // Create a user
        User user = new User();
        user.setName("Nada Amin");
        user.setUserId("NA123");

        // Create card info
        CardInfo card = new CardInfo();
        card.setCardNumber("1234567812345678");
        card.setCardHolderName("Nada Amin");
        card.setExpiryDate("12/27");
        card.setCvv("123");

        // Create bank account
        BankAccManager manager = new BankAccManager();
        BankAccount account = manager.createAccount(user, bank, card);

        // Validate account
        boolean isValid = manager.validateAccount(account);
        System.out.println("Account is valid: " + isValid);

        // Print account info
        System.out.println("User: " + account.getUser().getName());
        System.out.println("Bank: " + account.getBank().getName());
        System.out.println("Linked at: " + account.getLinkedAt());

        // Try removing the account
        boolean removed = user.removeAccount();
        System.out.println("Account removed: " + removed);
    }
}