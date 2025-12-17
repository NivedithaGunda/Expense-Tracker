package com.example.expense_tracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;



@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public String addExpense(@RequestBody Expense expense) {
        service.addExpense(expense.getAmount(), expense.getCategory(), expense.getNote());
        return "Expense added";
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.viewExpense();
    }

    @GetMapping("/total")
    public double getTotal() {
        return service.getTotal();
    }

    @GetMapping("/category/{category}")
    public List<Expense> byCategory(@PathVariable Category category) {
        return service.viewExpenseByCategory(category);
    }

    @DeleteMapping("/{index}") 
    public String delete(@PathVariable int index) {
        return service.deleteExpenses(index) ? "Deleted" : "Invalid index";
    }    
}