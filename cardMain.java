import Add_card.*;
import Core.UserData;

import java.util.HashMap;
import java.util.Scanner;

public class cardMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please enter your information to add a bank account.");

        UserData userData = new UserData();
        userData.setUsername("nada_amin");
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

        scanner.close();
    }
}
