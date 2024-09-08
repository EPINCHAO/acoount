package com.tata.client_microservice.repository;

import com.tata.client_microservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByIdentification(String identification);
}
