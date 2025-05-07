import Add_card.*;
import Core.UserData;
import SignUp.SignUpService;
import SignUp.SignUpOperation;
import Login.LoginOperation;
import Login.LoginService;
import Assets.Asset;
import Assets.Portfolio;
import Assets.AssetTypes;
import zakat_calculation.ZakatReport;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n------------------ Welcome to ARCHITECH ------------------");
        int choice = 0;
        String name, username = " ", email, password;
        boolean Userverified = false;
        Scanner scanner = new Scanner(System.in);
        while(!Userverified){
            System.out.println("\n# Are you..\n1) A new user? -> Sign up\n2) Have an account? -> Log in\n3) Exit");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) { // signing a user
                    System.out.print("Please enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Please enter your username: ");
                    username = scanner.nextLine();
                    System.out.print("Please enter your email: ");
                    email = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    password = scanner.nextLine();
                    SignUpService service = new SignUpOperation();
                    if (service.signup(name, username, email, password)) {
                        Userverified = true;
                    }
                } else if (choice == 2) { // logging in
                    System.out.print("Please enter your username: ");
                    username = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    password = scanner.nextLine();

                    LoginOperation login = new LoginOperation("users.txt");
                    if (login.login(username, password)) {
                        Userverified = true;
                    }

                } else if (choice == 3) {
                    System.out.println("Thank you for using the app!!");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
                scanner.nextLine();
            }
        }
        if(choice == 1){
            System.out.println("Please enter your information to add a bank account.");

            UserData userData = new UserData();
            userData.setUsername(username);
            User user = new User();
            user.setUserId(userData.getUsername());

            Bank.setSuppBanks();

            Bank selectedBank;
            while (true) {
                Bank.getBanks();
                System.out.print("Enter the name of your bank: ");
                String inputBankName = scanner.nextLine();
                selectedBank = Bank.getBankByName(inputBankName);

                if (selectedBank != null) {
                    break;
                } else {
                    System.out.println("Unsupported bank. Please choose from the list above.");
                }
            }
            CardInfo card = new CardInfo();
            System.out.println("\nEnter Card Details:");

            while (true) {
                System.out.print("Card number (16 digits): ");
                card.setCardNumber(scanner.nextLine());
                if (card.isValidCardNumber()) break;
                System.out.println("Invalid card number. Try again.!");
            }

            while (true) {
                System.out.print("Card holder name: ");
                card.setCardHolderName(scanner.nextLine());
                if (card.isValidCardHolderName()) break;
                System.out.println("Card holder name cannot be empty.");
            }

            while (true) {
                System.out.print("Expiry date (MM/yy or MM/yyyy): ");
                card.setExpiryDate(scanner.nextLine());
                if (card.isValidExpiryDate()) break;
                System.out.println("Invalid or expired date. Try again!");
            }

            while (true) {
                System.out.print("CVV (3 digits): ");
                card.setCvv(scanner.nextLine());
                if (card.isValidCVV()) break;
                System.out.println("Invalid CVV. Try again.");
            }

            BankAccManager manager = new BankAccManager();
            BankAccount account = manager.createAccount(user, selectedBank, card);

            if (manager.validateAccount(account)) {
                System.out.println("\nBank account linked successfully!");
                System.out.println("Linked at: " + account.getLinkedAt());

                // Save to file
                CardDBConnector db = new CardDBConnector("accountsDB.txt");
                db.saveCardData(selectedBank, card, user);
            } else {
                System.out.println("\nFailed to link bank account due to invalid data.");
            }
        }

        System.out.println("What would you like to do");



//        Portfolio portfolio = new Portfolio();
//
//        Asset asset1 = new Asset(1, AssetTypes.Stock, "Tesla", 10, new java.util.Date(), 700.0);
//        Asset asset2 = new Asset(2, AssetTypes.Crypto, "Bitcoin", 2, new java.util.Date(), 30000.0);
//
//        portfolio.addAsset(asset1);
//        portfolio.addAsset(asset2);
//
//        System.out.println("Assets in Portfolio:");
//        for (Asset asset : portfolio.getAllAssets()) {
//            System.out.println(asset);
//        }
//
//        System.out.println("\nEditing Asset 1");
//        asset1.setPrice(750.0);
//        portfolio.editAsset(asset1.getAssetID(), asset1);
//
//        System.out.println("\nUpdated Assets:");
//        for (Asset asset : portfolio.getAllAssets()) {
//            System.out.println(asset);
//        }
//
//        System.out.println("\nRemoving Asset 2");
//        portfolio.removeAsset(2);
//
//        System.out.println("\nFinal Assets:");
//        for (Asset asset : portfolio.getAllAssets()) {
//            System.out.println(asset);
//        }
//
//
//        System.out.println("-----------------------------------------");
//        // Create a bank
//        Bank bank = new Bank();
//        bank.setName("Cairo Bank");
//        bank.setBankId("CB001");
//        bank.setValidBanks(new HashMap<>());
//
//        // Create a user
//        User user = new User();
//        user.setName("Nada Amin");
//        user.setUserId("NA123");
//
//        // Create card info
//        CardInfo card = new CardInfo();
//        card.setCardNumber("1234567812345678");
//        card.setCardHolderName("Nada Amin");
//        card.setExpiryDate("12/27");
//        card.setCvv("123");
//
//        // Create bank account
//        BankAccManager manager = new BankAccManager();
//        BankAccount account = manager.createAccount(user, bank, card);
//
//        // Validate account
//        boolean isValid = manager.validateAccount(account);
//        System.out.println("Account is valid: " + isValid);
//
//        // Print account info
//        System.out.println("User: " + account.getUser().getName());
//        System.out.println("Bank: " + account.getBank().getName());
//        System.out.println("Linked at: " + account.getLinkedAt());
//
//        // Try removing the account
//        boolean removed = user.removeAccount();
//        System.out.println("Account removed: " + removed);
//        System.out.println("-----------------------------------------");
//
//        try {
//            // Create sample assets
//            Asset goldAsset = new Asset(1, AssetTypes.Gold, "Gold Bar", 10, parseDate("2023-01-01"), 500.0);
//            Asset cryptoAsset = new Asset(2, AssetTypes.Crypto, "Bitcoin", 2, parseDate("2022-06-15"), 25000.0);
//            Asset stockAsset = new Asset(3, AssetTypes.Stock, "Tesla Shares", 5, parseDate("2021-12-10"), 800.0);
//            Asset estateAsset = new Asset(4, AssetTypes.Real_Estate, "Rental Property", 1, parseDate("2020-08-01"), 300000.0);
//
//            // Initialize Zakat Report
//            ZakatReport report = new ZakatReport();
//
//            // Add assets to the report
//            report.addAsset(goldAsset);
//            report.addAsset(cryptoAsset);
//            report.addAsset(stockAsset);
//            report.addAsset(estateAsset);
//
//            // Calculate total zakat
//            report.calcTotalZakat(null); // null is okay because factory handles strategy per asset
//
//            // Print total zakat
//            System.out.println("Total Zakat Due: $" + report.getTotalZakatDue());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static Date parseDate(String date) throws ParseException {
//        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
//    }
    }
}