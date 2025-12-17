package com.example.expense_tracker.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expense_tracker.Expenseinterface.ExpenseRepositoryInterface;
import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;


@Service
public class ExpenseService {

    private ExpenseRepositoryInterface expenseRepository;

    public ExpenseService(ExpenseRepository repo) {
        this.expenseRepository = repo;
    }

    public void addExpense(double amount, Category category, String note) {
        
        Expense expense = new Expense(amount, category, note);
        expenseRepository.save(expense);
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

    public boolean deleteExpenses(int userIndex) {
        List<Expense> expenses = expenseRepository.findAll();

        int index = userIndex - 1;

        if (index < 0 || index >= expenses.size()) {
            return false;
        }
        
        expenseRepository.delete(index);
        return true;
    }
    
}
