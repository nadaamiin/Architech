import Add_card.*;
import Core.UserData;
import SignUp.SignUpService;
import SignUp.SignUpOperation;
import Login.LoginOperation;
import SignUp.EmailValidator;
import SignUp.PasswordValidator;
import SignUp.UsernameValidator;
import SignUp.NameValidator;
import Assets.Asset;
import Assets.Portfolio;
import Assets.AssetTypes;
import zakat_calculation.ZakatCalculator;
import zakat_calculation.ZakatReport;

import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

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
                    SignUpService service = new SignUpOperation();

                    // validating name
                    while (true) {
                        System.out.print("- Please enter your name (max 100 characters): ");
                        name = scanner.nextLine();
                        UserData user = new UserData(name, "", "", "");
                        if (new NameValidator().validate(user)) break;
                        else System.out.println("  Invalid name format!!");
                    }

                    // validating username
                    while (true) {
                        System.out.print("- Please enter your username (must be unique, max 50 characters): ");
                        username = scanner.nextLine();
                        UserData user = new UserData(name, username, "", "");
                        if (new UsernameValidator().validate(user)) break;
                        else System.out.println("  Username already taken!!");
                    }

                    // validating email
                    while (true) {
                        System.out.print("- Please enter your email (must contain @mailtype.com): ");
                        email = scanner.nextLine();
                        UserData user = new UserData(name, username, email, "");
                        if (new EmailValidator().validate(user)) break;
                        else System.out.println("  Invalid email format!!");
                    }

                    // validating password
                    while (true) {
                        System.out.print("- Please enter your password (max 100 characters, must include at least 1 uppercase char, and at least 1 number or special character): ");
                        password = scanner.nextLine();
                        UserData user = new UserData(name, username, email, password);
                        if (new PasswordValidator().validate(user)) break;
                        else System.out.println("  Invalid password!!");
                    }

                    // check if all the fields are validated, then would save the users data
                    if (service.signup(name, username, email, password)) {
                        Userverified = true;
                    }

                }else if(choice == 2) { // logging in
                    while(true) {
                        System.out.print("\nPlease enter your username: ");
                        username = scanner.nextLine();
                        System.out.print("Please enter your password: ");
                        password = scanner.nextLine();

                        LoginOperation login = new LoginOperation("users.txt");
                        if (login.login(username, password)) {
                            Userverified = true;
                            break;
                        } else {
                            System.out.println("Login failed: Invalid username or password.");
                        }
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
            System.out.println("\nPlease enter your information to add a bank account.");

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


        Portfolio portfolio = new Portfolio();
        Random random = new Random();
        int assetChoice = -1;

        while (assetChoice != 6) {
            System.out.println("\n------- Asset Management Menu -------");
            System.out.println("1) Add asset");
            System.out.println("2) Remove asset");
            System.out.println("3) Edit asset");
            System.out.println("4) View my assets");
            System.out.println("5) Zakat calculation");
            System.out.println("6) Exit");

            System.out.print("Choose an option: ");
            assetChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (assetChoice) {
                case 1: // Add Asset
                    System.out.println("Available asset types:");
                    for (AssetTypes type : portfolio.getAvailableAssetTypes()) {
                        System.out.println("- " + type);
                    }

                    AssetTypes type = null;
                    while (type == null) {
                        System.out.print("Enter asset type: ");
                        String input = scanner.nextLine().trim().toUpperCase();
                        try {
                            type = AssetTypes.valueOf(input);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid asset type. Try again!");
                        }
                    }

                    System.out.print("Enter asset name: ");
                    String assetName = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    int id = random.nextInt(100000); // generate random asset ID
                    Date now = new Date();

                    Asset newAsset = new Asset(id, type, assetName, quantity, now, price, username);
                    portfolio.addAsset(newAsset);
                    System.out.println("Asset added successfully!");
                    break;

                case 2: // Remove Asset
                    System.out.print("Enter asset ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    Asset assetToDelete = portfolio.getAsset(removeId, username);
                    if (assetToDelete == null) {
                        System.out.println("Asset not found or does not belong to you.");
                        break;
                    }

                    portfolio.removeAsset(removeId, username);

                    System.out.println("Asset removed successfully!");
                    break;

                case 3: // Edit Asset
                    System.out.print("Enter asset ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();

                    Asset asset = portfolio.getAsset(editId, username);
                    if (asset == null) {
                        System.out.println("Asset not found or does not belong to you.");
                        break;
                    }

                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();

                    asset.setQuantity(newQty);
                    asset.setPrice(newPrice);
                    portfolio.editAsset(editId, asset);

                    System.out.println("Asset updated successfully!");
                    break;

                case 4: // View Assets
                    List<Asset> myAssets = portfolio.getUserAssets(username);
                    if (myAssets.isEmpty()) {
                        System.out.println("No assets found.");
                    } else {
                        System.out.println("Your assets:");
                        for (Asset a : myAssets) {
                            System.out.println(a);
                        }
                    }
                    break;


                case 5: {
                    ZakatReport zakatReport = new ZakatReport();

                    System.out.println("\n------ Zakat Calculator ------");

                    List<Asset> userAssets = portfolio.getUserAssets(username);
                    if (userAssets.isEmpty()) {
                        System.out.println("No assets to calculate zakat on.");
                        break;
                    }

                    for (Asset userAsset : userAssets) {
                        zakatReport.addAsset(userAsset);
                    }

                    ZakatCalculator calculator = new ZakatCalculator(null);
                    zakatReport.calcTotalZakat(calculator);

                    System.out.println("\nAssets:");
                    for (Asset asset2 : zakatReport.getAssets()) {
                        System.out.println("- " + asset2.getName() + " | Type: " + asset2.getAssetType() +
                                " | Qty: " + asset2.getQuantity() + " | Price: " + asset2.getPrice());
                    }

                    System.out.println("\nTotal Zakat Due: " + zakatReport.getTotalZakatDue());

                    System.out.print("\nDo you want to generate a PDF report? (Y/N): ");
                    String input = scanner.nextLine().trim().toLowerCase();

                    if (input.equals("y")) {
                        System.out.print("Enter the pdf name: ");
                        String filename = scanner.nextLine();
//                        zakatReport.generatePdf(filename); // Make sure this method exists
                    }

                    break;
                }
                case 6:
                    System.out.println("Exiting asset management...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}