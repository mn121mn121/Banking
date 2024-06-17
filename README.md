
# Account Management System

## Overview

This repository is a Java-based Account Management System developed using JavaFX for the user interface and file handling for data persistence. It allows users to create new accounts, display account details, and perform deposit and withdrawal operations. Account details are stored in a file named `Bank.txt` in the following format: `12-digit account number:6-letter password:amount`.

## Features

- **Create New Account**: Allows users to create a new account with a unique 12-digit account number and a 6-letter password.
- **Display Account Details**: Users can view the details of their accounts including the current balance.
- **Deposit Amount**: Users can deposit a specified amount into their account.
- **Withdraw Amount**: Users can withdraw a specified amount from their account, provided they have sufficient balance.

## Project Structure

```
account-management-system/
│
├── src/
│   └── account/
│       └── Main.java
│
├── Bank.txt
│
├── README.md
└── ...
```

- **src/account/Main.java**: The main Java file containing the application logic and user interface implementation using JavaFX.
- **Bank.txt**: The file used to store account details in the format `accountNumber:password:amount`.

## Setup and Installation

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/account-management-system.git
   cd account-management-system
   ```

2. **Open the project in your preferred Java IDE**.

3. **Ensure JavaFX is set up**:
   - Add the JavaFX library to your project's build path.
   - You can download JavaFX from [here](https://gluonhq.com/products/javafx/).

4. **Run the Application**:
   - Locate the `Main.java` file in the `src/account/` directory.
   - Run the `Main.java` file as a Java Application.

## Usage

### Creating a New Account

1. Launch the application.
2. Navigate to the "Create Account" section.
3. Enter a 12-digit account number and a 6-letter password.
4. Click "Create".

### Displaying Account Details

1. Navigate to the "Display Account" section.
2. Enter your account number and password.
3. Click "Display" to view the account details.

### Depositing Amount

1. Navigate to the "Deposit" section.
2. Enter your account number, password, and the amount to deposit.
3. Click "Deposit".

### Withdrawing Amount

1. Navigate to the "Withdraw" section.
2. Enter your account number, password, and the amount to withdraw.
3. Click "Withdraw".

## Data Storage Format

The account details are stored in the `Bank.txt` file in the following format:
```
123456789012:abcdef:00100000
234567890123:ghijkl:01250050
```
- `123456789012`: 12-digit account number
- `abcdef`: 6-letter password
- `00100000`: Account balance

