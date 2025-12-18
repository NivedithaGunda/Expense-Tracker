package com.example.expense_tracker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Expense {

     @Positive(message = "Amount must be greater than 0")
     double amount;

     @NotNull(message = "Category is required")
     Category category;

     @NotBlank
     String note;

    public Expense(){

    }

    public Expense(double amount){
        this(amount, Category.OTHER , "");
    }

    public Expense(double amount, Category category) {
        this(amount, category, "");
    }

    public Expense(double amount, Category category, String note) {
        this.amount = amount;
        this.category = category;
        this.note = note;
    }

    public Category getCategory(){
        return category;
    }

    public double getAmount(){
        return amount;
    }

    public String getNote(){
        return note;
    }

    public String toString() {
        return amount + " | " + category + " | " + note;
    }

}
