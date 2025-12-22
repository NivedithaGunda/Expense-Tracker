package com.example.expense_tracker.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.expense_tracker.dto.ExpenseTrackerDTO;
import com.example.expense_tracker.expenseinterface.ExpenseRepositoryInterface;
import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;


@Service
public class ExpenseService {

    private ExpenseRepositoryInterface expenseRepository;

    public ExpenseService(ExpenseRepository repo) {
        this.expenseRepository = repo;
    }

    public void addExpense(ExpenseTrackerDTO dto) {
        
        Category category;

        try {
            category = Category.valueOf(dto.getCategory().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category : " + dto.getCategory());
        }
        Expense expense = new Expense(dto.getAmount(), category, dto.getNote());
        expenseRepository.save(expense);
    }

    // sorting and pagination 
    public List<Expense> viewExpense(int page, int size, String sortBy) {
        
        List<Expense> expenses = expenseRepository.findAll();

         if ("dataDesc".equalsIgnoreCase(sortBy)) {
            expenses =  expenses.stream()
                        .sorted((a,b) -> b.getCreateddt().compareTo(a.getCreateddt()))
                        .toList();
        }

        if ("dataAsc".equalsIgnoreCase(sortBy)) {
            expenses =  expenses.stream()
                    .sorted((a,b) -> a.getCreateddt().compareTo(b.getCreateddt()))
                    .toList();
        }

        int start = page * size;
        int end = Math.min(start + size, expenses.size());

        if (start >= expenses.size()) {
            return List.of();
        }

        return expenses.subList(start, end);
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
