# Bitcoin ATM Machine - OOC Project


## Overview
Bitcoin ATM Machine (BTM) is a machine that allows users to buy and sell bitcoin through a bitcoin Automated Teller Machine.
The objective of this project is as follow: 
  + Create an intuitive GUI that facilitates easy navigation and interaction for users during both buying and selling transactions.
  + Provide a seamless experience for users, regardless of their level of familiarity with cryptocurrencies.

# System Main Functions
1. Authentication
   + [Login](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Login.java) 
   + [Register Account](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Register.java)
2. User: [Customer](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Customer.java)
   + Deposit
   + Withdraw
   + Display User Wallet
   + Display Transaction
3. User: [Admin](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Admin.java)
   + Display all transaction

# Classes List:
1. [User](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/User.java) Class: [Admin](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Admin.java) & [Customer](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Customer.java) (Sub Class)
2. [Currency](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Currency.java) Class: Store currencies & exchange rate
3. [Transaction](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Transaction.java) class: Write Transaction to transactions.txt
4. [IdGenerator](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/IdGenerator.java) class: Generate ID
5. [Login](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Login.java) Class: Login User based on accounts.txt
6. [Register](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Register.java) Class: Register new Users on accounts.txt
7. [TransactionReader](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/TransactionReader.java): Read data from txt file
8. [Auth](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Auth.java) Class: Auth flow for BTM
9. [AnonClass](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/AnonClass.java): Anonymous Inner Class

# Inheritance
Inheritance is a fundamental object-oriented programming (OOP) concept that allows a class (subclass or derived class) to inherit the properties and behaviors of another class (superclass or base class).
- [User](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/User.java) is the super class 
- [Admin](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Admin.java) & [Customer](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Customer.java) are the sub class of User, we use inheritance for better code structure and also for the difference between the 2 kind of User. The difference between the 2 sub-class is that Admin can display every transaction of the user while for customer, they can only display the transaction based on a specific userID.

# Encapsulation
Encapsulation is an OOP principle that involves bundling the data (attributes) and methods (functions) that operate on the data into a single unit, known as a class. 
- Getter & Setter functions in every classes
- Usage of Public, Private, Protected accessor is to allow us to encapsulate our code and define clear visibility for classes and members.
- We use Public in User class getUserID() and for every ther accessore, so that Customer class and Adim class can use it as well.

# Abstraction
Abstraction is the process of hiding the complex implementation details and exposing only the essential features of an object.
- [User](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/User.java) is an abstract class
- displayAllTransactions() is an abstract method in Customer and Admin class, where in the Admin class, it display the transaction from the file regardless the user and for the method in Customer class, it display a specific transaction based on the userID.

# Polymorphism
Polymorphism allows objects of different types to be treated as objects of a common type.
- Overriding functions: toString() can be found in Customer class. It provides a custom string representation for an object, including the default string representation from the User class and appending information about the balance of the customer in BTC and the other one is in Transaction class where it return the values in string and also to make it easier to debug or log information about transactions in your application.
- equals() this override from object class(root class), this block checks if the fullName and phoneNumber fields of the current instance (this) and the tmpUser instance are equal. If both conditions are true, it returns true, indicating that the two User objects are considered equal.
- Overloading functions: checkBalance() in Customer Class.

# Exception Handling
Exception handling is a mechanism for dealing with errors during program execution. 
- IOException for reading files error in Customer class to catch the unwanted input and block the execution and also to find the right path
- NoSuchElementException for No User Found (Query Data) also in Customer class.
- NumberFormatException, can be found in customer class in getBalanceFromAccountFile method, which this execution when Double.parseDouble(parts[5]) encounters a NumberFormatException. The Double.parseDouble() method is used to convert the string value at parts[5] into a double.

# File I/O
File I/O (Input/Output) involves reading from and writing to files.
- [accounts.txt](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/accounts.txt)
- [transactions.txt](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/transactions.txt)

# Static Methods
Static methods belong to a class rather than an instance of the class.
- [Login](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Login.java) class
- [Register](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Register.java) class
- [Currency](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Currency.java) class

# Interface 
An interface defines a contract for a set of methods that a class must implement.
In this code, we implemented interface in [Currency](https://github.com/HVicheara/BTC-ATM-Machine/blob/main/logic/Currency.java) class.
- CurrencyInterface
