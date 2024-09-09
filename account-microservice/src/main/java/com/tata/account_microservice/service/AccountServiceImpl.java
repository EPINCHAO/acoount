package com.tata.account_microservice.service;

import com.tata.account_microservice.entity.Account;
import com.tata.account_microservice.repository.AccountRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepoistory accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> read(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);  // save() handles both create and update
    }

    @Override
    public void changeStatus(Long id, Boolean status) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setStatus(status);
            accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not found with ID: " + id);
        }
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
