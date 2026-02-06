package com.example.moneymanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String description;
    private BigDecimal amount;
    private TransactionType type; // INCOME, EXPENSE
    private String category;
    private Division division; // OFFICE, PERSONAL
    private LocalDateTime date;
    private LocalDateTime createdAt;

    public enum TransactionType {
        INCOME, EXPENSE
    }

    public enum Division {
        OFFICE, PERSONAL
    }
}
