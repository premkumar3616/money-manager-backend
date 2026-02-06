package com.example.moneymanager.service;

import com.example.moneymanager.model.Transaction;
import com.example.moneymanager.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction addTransaction(Transaction transaction) {
        transaction.setCreatedAt(LocalDateTime.now());
        if (transaction.getDate() == null) {
            transaction.setDate(LocalDateTime.now());
        }
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public List<Transaction> getTransactionsBetween(LocalDateTime start, LocalDateTime end) {
        return repository.findByDateBetween(start, end);
    }

    public Transaction updateTransaction(String id, Transaction transaction) {
        Optional<Transaction> existing = repository.findById(id);
        if (existing.isPresent()) {
            Transaction t = existing.get();
            // Check 12 hours restriction
            if (t.getCreatedAt() != null && t.getCreatedAt().plusHours(12).isBefore(LocalDateTime.now())) {
                throw new RuntimeException("Cannot edit transaction after 12 hours");
            }
            t.setDescription(transaction.getDescription());
            t.setAmount(transaction.getAmount());
            t.setCategory(transaction.getCategory());
            t.setDivision(transaction.getDivision());
            t.setDate(transaction.getDate());
            t.setType(transaction.getType());
            return repository.save(t);
        }
        return null; // Or throw exception
    }

    public void deleteTransaction(String id) {
        repository.deleteById(id);
    }
}
