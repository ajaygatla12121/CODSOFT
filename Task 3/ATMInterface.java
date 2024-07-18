package task3;

import java.util.Scanner;

public class ATMInterface {
	
    private BankAccount account;
    private Scanner scanner;

    public ATMInterface(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
    	
        int option;
        
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 4);
    }

    private void checkBalance() {
    	
        System.out.println("Your current balance: ₹" + account.getBalance());
    }

    private void deposit() {
    	
        System.out.print("Enter deposit amount: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Your current balance: ₹" + account.getBalance());
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw() {
    	
        System.out.print("Enter withdrawal amount: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println("Your current balance: ₹" + account.getBalance());
            }
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
    	
        BankAccount userAccount = new BankAccount(0); // Initial balance of ₹1000
        ATMInterface atm = new ATMInterface(userAccount);
        atm.displayMenu();
    }
}

class BankAccount {
	
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
    	
        balance = balance+amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
    	
        if (balance >= amount) {
            balance = balance-amount;
            System.out.println("Withdrawn: ₹" + amount);
            return true;
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return false;
        }
    }
}
