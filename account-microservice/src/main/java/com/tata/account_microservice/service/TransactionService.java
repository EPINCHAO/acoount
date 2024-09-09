package com.tata.account_microservice.service;

import com.tata.account_microservice.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction create(Transaction transaction);
    Optional<Transaction> read(Long id);
    Transaction update(Transaction transaction);

    List<Transaction> findAll();
}
