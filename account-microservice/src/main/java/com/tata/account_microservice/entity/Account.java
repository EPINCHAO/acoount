package com.tata.account_microservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private String accountType;
    private double initialBalance;
    private Boolean status;

//    @ManyToOne
//    @JoinColumn(name = "person_identification", nullable = false) // Foreign key
//    private Person person;
}
