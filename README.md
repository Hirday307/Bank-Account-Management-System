# Bank Account Management System

This project is a simple Java-based Bank Account Management System that allows users to create accounts, deposit and withdraw money, transfer funds, and view transaction histories.

## Features

- **Account Creation**: Create a new bank account with a unique account number.
- **Deposit Money**: Add funds to an account.
- **Withdraw Money**: Withdraw funds from an account (subject to sufficient balance).
- **Transfer Money**: Transfer funds between accounts.
- **Passbook**: View the transaction history for an account.

## File Overview

- **`bank_acc.java`**: The main Java file implementing the banking system logic and user interface.

## How to Run

1. Ensure you have Java installed on your system (JDK version 8 or later).
2. Compile the program using the command:
   ```bash
   javac bank_acc.java
   ```
3. Run the program using the command:
   ```bash
   java bank_acc
   ```

## Usage

1. Follow the menu options displayed on the console to interact with the system.
2. Choose from the following options:
   - Create Account
   - Deposit Money
   - Withdraw Money
   - Transfer Money
   - View Passbook
   - Exit

### Example Interaction

```
Bank System Menu:
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Transfer Money
5. View Passbook
6. Exit
Choose an option: 1
Enter account number: 123456
Account created successfully.
```

## Code Structure

### `Transaction` Class
Handles transaction details such as type (Deposit/Withdraw) and amount.

### `BankAccount` Class
Manages individual account details, balance, transactions, and methods for deposit, withdrawal, transfer, and passbook display.

### `bank_acc` Class
The main driver class with a menu-driven interface for interacting with the banking system.

## Limitations

- The program currently supports a maximum of 10 accounts.
- A fixed array size of 100 is used for storing transactions.
- No persistent data storage; all data is lost upon program termination.

## Contribution

Feel free to fork this repository and submit pull requests for enhancements or bug fixes.

## License

This project is licensed under the MIT License.
