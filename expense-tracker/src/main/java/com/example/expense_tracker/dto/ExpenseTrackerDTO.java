package com.example.expense_tracker.dto;

import com.example.expense_tracker.model.Category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ExpenseTrackerDTO {

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @NotNull(message = "Category is required")
    private String category;

    private String note;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}