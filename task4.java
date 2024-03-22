import java.util.Scanner;

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Remaining balance: $" + account.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to check the balance of the account
    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }
}

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Getter method to retrieve the account balance
    public double getBalance() {
        return balance;
    }

    // Setter method to set the account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount account = new BankAccount(1000);

        // Create an ATM instance with the bank account
        ATM atm = new ATM(account);

        // Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        System.out.println("Welcome to the ATM. Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.print("Enter your choice: ");

        // Read user input
        int choice = scanner.nextInt();

        // Perform action based on user choice
        switch (choice) {
            case 1:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                atm.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                atm.deposit(depositAmount);
                break;
            case 3:
                atm.checkBalance();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        // Close the scanner
        scanner.close();
    }
}
