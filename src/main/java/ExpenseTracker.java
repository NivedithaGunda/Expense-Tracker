import java.util.ArrayList;

public class ExpenseTracker {
    private ArrayList<Expense> expenses = new ArrayList<>();

    void addExpense(Expense e) {
        expenses.add(e);
        System.out.println("Expense added successfully!");
    }

    void viewExpense () {

        if (expenses.isEmpty()) {
            System.out.println("No expenses added");
            return;
        }

        System.out.println("--- All Expenses ---");

        for (int i = 0; i < expenses.size(); i++) {
            System.out.println(i + 1 + ")"  + expenses.get(i));
        }
    }

    
    double getTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        return total;
    }

    void viewExpenseByCategory(Category category) {
        System.out.println("--- " + category + " Expenses ---");
        for (Expense e : expenses) {
            if (e.getCategory() == category) {
                System.out.println(e.getAmount() +  " | " + e.note);
            }
        }
    }


    void deleteExpenses(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Deleted");
        } else {
            System.out.println("Invalid index");
        }
    }
 
}
