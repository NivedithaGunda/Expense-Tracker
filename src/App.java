import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseRepository repo = new ExpenseRepository();
        ExpenseService service = new ExpenseService(repo);
        
        while (true) {
            System.out.println("""
                    ------ Expense Tracker ------
                    1. Add Expense
                    2. View All Expenses
                    3. View Total Expenses
                    4. View Expenses by Category
                    5. Delete an Expense
                    6. Exit
                    Enter your choice:
                    """);

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Enter Category (Food/Travel/Shopping/Entertainment, Rent, Other): ");
                    String catinput = sc.nextLine();
                    Category category;
                    try {
                        category = Category.valueOf(catinput.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category given. Defaulting to OTHER.");
                        category = Category.OTHER;
                    }

                    System.out.println("Enter note: ");
                    String note = sc.nextLine();

                    service.addExpense(amount, category, note);
    
                    break;
                
                case 2:
                    List<Expense> expenses = service.viewExpense();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses added");
                    } else {
                        System.out.println("--- All Expenses ---");
                        for (int i = 0; i < expenses.size(); i++) {
                            System.out.println((i + 1) + ") " + expenses.get(i));
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("Total spent= " + service.getTotal());
                    break;
                
                case 4:
                    
                    System.out.println("Enter category: ");
                    String categoryinput = sc.next();
                    Category expenseByCategory;
                    try {
                        expenseByCategory = Category.valueOf(categoryinput.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category given. Defaulting to OTHER.");
                        expenseByCategory = Category.OTHER;
                    }

                    System.out.println("--- " + expenseByCategory + " Expenses ---");
                    List<Expense> filtered = service.viewExpenseByCategory(expenseByCategory);

                    if (filtered.isEmpty()) {
                        System.out.println("No expenses found for " + expenseByCategory);
                    } else {
                        for (Expense e : filtered) {
                            System.out.println(e.getAmount() + " | " + e.getNote());
                        }
                    }
                    break;
                
                // case 5:
            
                //     System.out.println("Expense to delete: ");
                //     int idx = sc.nextInt();
                //     service.deleteExpenses(idx);
                //     break;
                
                default:
                    return;
            }
        // sc.close();
        }
    }
}
