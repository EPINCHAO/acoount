package com.tata.account_microservice.repository;

import com.tata.account_microservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepoistory extends JpaRepository<Account, Long> {
}
