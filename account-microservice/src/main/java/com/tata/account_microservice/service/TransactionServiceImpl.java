package com.tata.account_microservice.service;

import com.tata.account_microservice.entity.Transaction;
import com.tata.account_microservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> read(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
