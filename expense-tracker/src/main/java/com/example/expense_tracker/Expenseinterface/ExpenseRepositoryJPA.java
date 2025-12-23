package com.example.expense_tracker.expenseinterface;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Expense;

public interface ExpenseRepositoryJPA extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(Category category);

}