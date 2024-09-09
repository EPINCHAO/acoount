package com.tata.account_microservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;                  // Date of Transaction
    private String transactionType;          // Type of Transaction
    private double amount;                   // Amount of Transaction
    private double balanceAfterTransaction;

    @ManyToOne
    private Account account;

}
