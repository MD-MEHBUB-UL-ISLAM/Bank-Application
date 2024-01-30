import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String name;
    private int number;
    private String type;
    private double balance;

    public Account(String name, int number, String type, double balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into " + type + " account.");
    }

    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from " + type + " account.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}

public class BankingApplication {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Update an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Deposit an amount into your account");
            System.out.println("6. Withdraw an amount from your account");
            System.out.println("7. Search for an account");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    withdraw();
                    break;
                case 7:
                    searchAccount();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
        scanner.close();
    }

    private static void createAccount() {
        System.out.print("Enter account name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account type: ");
        String type = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        accounts.add(new Account(name, number, type, balance));
        System.out.println("Account created successfully.");
    }

    private static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

    private static void updateAccount() {
        System.out.print("Enter account number to update: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Account account : accounts) {
            if (account.getNumber() == number) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new type: ");
                String type = scanner.nextLine();
                account.setName(name);
                account.setType(type);
                System.out.println("Account updated successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumber() == number) {
                accounts.remove(i);
                System.out.println("Account deleted successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void deposit() {
        System.out.print("Enter account number to deposit into: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Account account : accounts) {
            if (account.getNumber() == number) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                account.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void withdraw() {
        System.out.print("Enter account number to withdraw from: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Account account : accounts) {
            if (account.getNumber() == number) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                account.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void searchAccount() {
        System.out.print("Enter account number to search for: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Account account : accounts) {
            if (account.getNumber() == number) {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account not found.");
    }
}