
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
Banking/
│
├── out/
│   └── artifacts/
│       └── Banking_jar/
│           └── Banking.jar
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

- **out/artifacts/Banking_jar/Banking.jar**: A jar file which can be downloaded and executed to directly run the JavaFX Application.
- **src/account/Main.java**: The main Java file containing the application home page.
- **Bank.txt**: The file used to store account details in the format `accountNumber:password:amount`.

## Usage

### Creating a New Account

1. Launch the application.
2. Navigate to the "Create Account" section.
3. Enter a 12-digit account number and a 6-letter password and confirm password.
4. Click "Create".

### Displaying Account Details

1. Navigate to the "Show Details" section.
2. Enter your account number and password.
3. Click "Display" to view the account details.

### Depositing/Withdrawing Amount

1. Navigate to the "Deposit / Withdraw" section.
2. Enter your account number, password.
3. Select the transaction type and enter the amount to deposit/withdraw.
4. Click "Submit".


## Data Storage Format

The account details are stored in the `Bank.txt` file in the following format:
```
123456789012:abcdef:00100000
234567890123:ghijkl:01250050
```
- `123456789012`: 12-digit account number
- `abcdef`: 6-letter password
- `00100000`: Account balance (<= 9,00,00,000)

