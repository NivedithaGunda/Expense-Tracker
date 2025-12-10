import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

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

                    tracker.addExpense(new Expense(amount, category, note));
    
                    break;
                
                case 2:
                    tracker.viewExpense();
                    break;
                
                case 3:
                    System.out.println("Total spent= " + tracker.getTotal());
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

                    tracker.viewExpenseByCategory(expenseByCategory);
                    break;
                
                case 5:
            
                    System.out.println("Expense to delete: ");
                    int idx = sc.nextInt();
                    tracker.deleteExpenses(idx);
                    break;
                
                default:
                    return;
            }
        sc.close();
        }
    }
}
