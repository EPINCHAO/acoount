package com.tata.account_microservice.controller;

import com.tata.account_microservice.entity.Transaction;
import com.tata.account_microservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.create(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.read(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        if (!transactionService.read(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        transaction.setId(id); // Ensure the ID is set for update
        Transaction updatedTransaction = transactionService.update(transaction);
        return ResponseEntity.ok(updatedTransaction);
    }


    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.findAll();
        return ResponseEntity.ok(transactions);
    }
}
