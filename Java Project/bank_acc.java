import java.io.*;

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": " + amount;
    }
}

class BankAccount {
    String accountNumber;
    double balance;
    Transaction[] transactions;
    int transactionCount;

    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new Transaction[100];
        this.transactionCount = 0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdraw", amount);
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    void transfer(BankAccount toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred: " + amount + " to account " + toAccount.accountNumber);
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }

    void addTransaction(String type, double amount) {
        if (transactionCount < transactions.length) {
            transactions[transactionCount++] = new Transaction(type, amount);
        }
    }

    void printPassbook() {
        System.out.println("Passbook for account " + accountNumber);
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }
}

public class bank_acc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BankAccount[] accounts = new BankAccount[10];
        int accountCount = 0;

        while (true) {
            System.out.println("\nBank System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Passbook");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1 -> {
                    if (accountCount < accounts.length) {
                        System.out.print("Enter account number: ");
                        String accountNumber = reader.readLine();
                        accounts[accountCount++] = new BankAccount(accountNumber);
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Account limit reached.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = reader.readLine();
                    BankAccount depositAccount = findAccount(accounts, depositAccountNumber, accountCount);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(reader.readLine());
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = reader.readLine();
                    BankAccount withdrawAccount = findAccount(accounts, withdrawAccountNumber, accountCount);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(reader.readLine());
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter your account number: ");
                    String fromAccountNumber = reader.readLine();
                    BankAccount fromAccount = findAccount(accounts, fromAccountNumber, accountCount);
                    if (fromAccount != null) {
                        System.out.print("Enter recipient account number: ");
                        String toAccountNumber = reader.readLine();
                        BankAccount toAccount = findAccount(accounts, toAccountNumber, accountCount);
                        if (toAccount != null) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = Double.parseDouble(reader.readLine());
                            fromAccount.transfer(toAccount, transferAmount);
                        } else {
                            System.out.println("Recipient account not found.");
                        }
                    } else {
                        System.out.println("Your account not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter account number: ");
                    String passbookAccountNumber = reader.readLine();
                    BankAccount passbookAccount = findAccount(accounts, passbookAccountNumber, accountCount);
                    if (passbookAccount != null) {
                        passbookAccount.printPassbook();
                    } else {
                        System.out.println("Account not found.");
                    }
                }
                case 6 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static BankAccount findAccount(BankAccount[] accounts, String accountNumber, int accountCount) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountNumber.equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}
