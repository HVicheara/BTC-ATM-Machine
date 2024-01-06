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
- Admin & Customer are the sub class of User, there are 2 sub class to super class User because there are 2 different kind of user where the admin can manage every account and for customer, they can only manage their own account. 

# Encapsulation
- Getter & Setter functions in every classes
- Usage of Public, Private, Protected accessor is to allow us to encapsulate our code and define clear visibility for classes and members.

# Abstraction
- User is an abstract class
- displayAllTransactions() is an abstract method in Customer and Admin class, where in the Admin class, it display the transaction from the file regardless the user and for the method in Customer class, it display a specific transaction based on the userID.

# Polymorphism
- Overriding functions: toString() can be found in Customer class. It provides a custom string representation for an object, including the default string representation from the User class and appending information about the balance of the customer in BTC and the other one is in Transaction class where it return the values in string and also to make it easier to debug or log information about transactions in your application.
- equals() this override from object class(root class), this block checks if the fullName and phoneNumber fields of the current instance (this) and the tmpUser instance are equal. If both conditions are true, it returns true, indicating that the two User objects are considered equal.
- Overloading functions: checkBalance() in Customer Class.

# Exception Handling
- IOException for reading files error in Customer class to catch the unwanted input and block the execution and also to find the right path
- NoSuchElementException for No User Found (Query Data) also in Customer class.
- NumberFormatException, can be found in customer class in getBalanceFromAccountFile method, which this execution when Double.parseDouble(parts[5]) encounters a NumberFormatException. The Double.parseDouble() method is used to convert the string value at parts[5] into a double.

# File I/O
- accounts.txt
- transactions.txt

# Static Methods
- Login class
- Register class
- Currency class
