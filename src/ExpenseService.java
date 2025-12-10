import java.util.List;

public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository repo) {
        this.expenseRepository = repo;
    }

    public void addExpense(double amount, Category category, String note) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }

        Expense expense = new Expense(amount, category, note);
        expenseRepository.save(expense);
        System.out.println("Expense added successfully!");
    }

    public List<Expense> viewExpense() {
        
        return expenseRepository.findAll();

    }

    public double getTotal() {
        return expenseRepository.findAll().stream()
                                .mapToDouble(Expense :: getAmount)
                                .sum();
    }

    public List<Expense> viewExpenseByCategory(Category category) {
        return expenseRepository.findByCategory(category);
        
    }
    
}
