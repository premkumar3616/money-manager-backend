package com.example.moneymanager.controller;

import com.example.moneymanager.model.Transaction;
import com.example.moneymanager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/filter")
    public List<Transaction> getTransactionsByDate(
            @RequestParam("start") String start,
            @RequestParam("end") String end) {
        // Expect ISO format
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return service.getTransactionsBetween(LocalDateTime.parse(start, formatter),
                LocalDateTime.parse(end, formatter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable String id, @RequestBody Transaction transaction) {
        try {
            return ResponseEntity.ok(service.updateTransaction(id, transaction));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable String id) {
        service.deleteTransaction(id);
    }
}
