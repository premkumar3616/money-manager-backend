package com.example.moneymanager.repository;

import com.example.moneymanager.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
