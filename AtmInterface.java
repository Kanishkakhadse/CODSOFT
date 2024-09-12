import java.util.Scanner;

// Step 1: Create BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor
     BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
     void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
     boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

    // Method to check the account balance
     double checkBalance() {
        return balance;
    }
}

// Step 2: Create ATM class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner = new Scanner(System.in);

    // Constructor to link with BankAccount
    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    // Method for withdrawing money
    void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    // Method for depositing money
     void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    // Method for checking balance
    void checkBalance() {
        System.out.println("Your current balance is: $" + bankAccount.checkBalance());
    }

    // ATM interface method
     void startATM() {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return; // Exit the method
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

// Step 3: Main class to run the ATM
 class ATMInterface {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(1000.00);

        // Create an ATM object linked to the bank account
        ATM atm = new ATM(account);

        // Start the ATM interface
        atm.startATM();
    }
}