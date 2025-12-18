package com.example.expense_tracker.model;


public class Expense {

     double amount;

     Category category;

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
