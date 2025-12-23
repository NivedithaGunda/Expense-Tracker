package com.example.expense_tracker.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String note;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

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

    public long getId() {
        return id;
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
