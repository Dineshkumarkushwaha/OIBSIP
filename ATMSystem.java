import java.util.Scanner;
import java.util.Random;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static String userId = "Dinesh1234";
    private static String userPin = "1234";

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM System!");

        
        System.out.print("User ID: ");
        String inputId = scanner.nextLine();

        System.out.print("User PIN: ");
        String inputPin = scanner.nextLine();

        if (authenticateUser(inputId, inputPin)) {
            System.out.println("Authentication successful!");
            showMenu();
        } else {
            System.out.println("Authentication failed. Exiting the program.");
        }
    }

    private static boolean authenticateUser(String id, String pin) {
        return id.equals(userId) && pin.equals(userPin);
    }

    private static void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Functionalities:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    showTransactionsHistory();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void showTransactionsHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < 20; i++) {
            int amount = random.nextInt(41501) + 3500; // Random amount between 3500 and 45000
            System.out.println("Transaction " + (i + 1) + ": " + "₹" + amount);
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        if (pin.equals(userPin)) {
            System.out.println("Withdrawal successful: ₹" + amount);
        } else {
            System.out.println("PIN incorrect. Please try again.");
        }
    }

    private static void depositMoney() {
        System.out.print("Enter the account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter the amount to deposit: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Successfully deposited: ₹" + amount);
    }

    private static void transferMoney() {
        System.out.print("Enter the bank you want to transfer to: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter the account number to transfer to: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter the amount to transfer: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println(
                "Transfer successful to " + bankName + " account number: " + accountNumber + " amount: ₹" + amount);
    }
}
