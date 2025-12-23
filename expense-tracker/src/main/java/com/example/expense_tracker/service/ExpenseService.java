package com.example.expense_tracker.service;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.dto.ExpenseTrackerDTO;
import com.example.expense_tracker.expenseinterface.ExpenseRepositoryJPA;
import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Expense;


@Service
public class ExpenseService {

    private final ExpenseRepositoryJPA expenseRepository;

    public ExpenseService(ExpenseRepositoryJPA repo) {
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
        
        Sort sort = Sort.by(
            "dataDesc".equals(sortBy)
            ? Sort.Direction.DESC
            : Sort.Direction.ASC,

            "createdAt"
        );

        PageRequest pageable = PageRequest.of(page, size, sort);
        return expenseRepository.findAll(pageable).getContent();
    }


    public double getTotal() {
        return expenseRepository.findAll().stream()
                                .mapToDouble(Expense :: getAmount)
                                .sum();
    }

    public List<Expense> viewExpenseByCategory(Category category) {
        return expenseRepository.findByCategory(category);
        
    }

    public void deleteExpenses(Long id) {
        expenseRepository.deleteById(id);
    }
    
}
