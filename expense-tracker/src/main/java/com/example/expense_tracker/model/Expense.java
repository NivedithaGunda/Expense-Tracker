package com.example.expense_tracker.model;

import java.time.LocalDateTime;

public class Expense {

     double amount;

     Category category;

     String note;

     LocalDateTime createdAt;

    public Expense(){
        this.createdAt = LocalDateTime.now();
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
        this.createdAt = LocalDateTime.now();
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

    public LocalDateTime getCreateddt() {
        return createdAt;
    }

    public String toString() {
        return amount + " | " + category + " | " + note;
    }

}
