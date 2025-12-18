package com.example.expense_tracker.expenseinterface;

import java.util.List;

import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Expense;

public interface ExpenseRepositoryInterface {

     void save(Expense expense);
     List<Expense> findAll();
     List<Expense> findByCategory(Category category);
     void delete(int index);
}