package com.tata.account_microservice.controller;

import com.tata.account_microservice.entity.Account;
import com.tata.account_microservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.create(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> account = accountService.read(id);
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        if (!accountService.read(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        account.setId(id); // Ensure the ID is set for update
        Account updatedAccount = accountService.update(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> changeAccountStatus(@PathVariable Long id, @RequestParam Boolean status) {
        try {
            accountService.changeStatus(id, status);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.findAll();
        return ResponseEntity.ok(accounts);
    }
}
