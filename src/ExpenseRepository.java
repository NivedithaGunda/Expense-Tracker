import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository{
    
    private List<Expense> expenses = new ArrayList<>();
    
    public void save(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> findAll() {
        return expenses;
    }

    public List<Expense> findByCategory(Category category) {
        return expenses.stream()
                        .filter(e -> e.getCategory() == category)
                        .toList();
    }

}