package com.bogus.carrental.database;

import com.bogus.carrental.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
    boolean existsByEmail(String email);
}
