## Project
Personal Expense Tracker (Console-based)
## Project description
The Personal Expense Tracker is a simple Java console application that helps users track their daily expenses.
It allows the user to:
Add new expenses (amount + category + note)
View all expenses
View total spent
View expenses by category
Exit the app

This project helps beginners practice:
OOP concepts
ArrayList / Lists
Loops & conditionals
Basic input using Scanner
Clean code & modular design

## Steps to Set Up the Project Locally
Prerequisites -  Java installed (JDK 8+), Any IDE (IntelliJ / VS Code) OR just a terminal

Setup-
Expense.java
ExpenseTracker.java
Main.java

## How to Run / Use the Project
Run the Main class.

The console will display a menu like:

------ Expense Tracker ------
1. Add Expense
2. View All Expenses
3. View Total Expenses
4. View Expenses by Category
5. Delete an Expense
6. Exit
Enter your choice:

## Example Usage

Add Expense
Enter amount: 250
Enter category (Food/Travel/Shopping/Entertainment, Rent, Other): Food
Enter note: Lunch with friend
Expense added successfully!

View All Expenses
--- All Expenses ---
1) 250 | Food | Lunch with friend
2) 100 | Travel | Auto fare

View Total Expenses
Total spent: ₹350

View Expenses by Category
Enter category: Food
--- Food Expenses ---
250 | Lunch with friend

## Refactor: Introduced Service and Repository layers
Separated Repository and Service to make a CRUD design. 