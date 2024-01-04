# Bitcoin ATM Machine - OOC Project


## Overview
Bitcoin ATM Machine (BTM) is a machine that allows users to buy and sell bitcoin through a bitcoin Automated Teller Machine.
The objective of this project is as follow: 
  + Create an intuitive GUI that facilitates easy navigation and interaction for users during both buying and selling transactions.
  + Provide a seamless experience for users, regardless of their level of familiarity with cryptocurrencies.

# System Main Functions

1. Login
2. Register Account
3. Deposit
4. Withdraw
5. Display User Wallet

# Classes List:
1. User Class: Admin & Customer (Sub Class)
2. Currency Class: Store currencies & exchange rate
3. Transaction class: Write Transaction to transactions.txt
4. IdGenerator class: Generate ID
5. Login Class: Login User based on accounts.txt
6. Register Class: Register new Users on accounts.txt
7. TransactionReader: Read data from txt file
8. Auth Class: Auth flow for BTM
9. AnonClass: Anonymous Inner Class

# Inheritance
- User is the super class 
- Admin & Customer are the sub class of User

# Encapsulation
- Getter & Setter functions in every classes
- Usage of Public, Private, Protected accessor

# Abstraction
- User is an abstract class
- displayAllTransactions() is an abstract method

# Polymorphism
- Overriding functions: toString(), equals()
- Overloading functions: checkBalance() in Customer Class.

# Exception Handling
- IOException for reading files error
- NoSuchElementException for No User Found (Query Data)
- NumberFormatException

# File I/O
- accounts.txt
- transactions.txt

# Static Methods
- Login class
- Register class
- Currency class