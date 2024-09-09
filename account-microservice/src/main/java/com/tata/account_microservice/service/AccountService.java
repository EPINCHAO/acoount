package com.tata.account_microservice.service;

import com.tata.account_microservice.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account create(Account account);
    Optional<Account> read(Long id);
    Account update(Account account);
    void changeStatus(Long id, Boolean status);
    List<Account> findAll();
}
