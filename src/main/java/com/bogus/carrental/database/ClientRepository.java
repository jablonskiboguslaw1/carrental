package com.bogus.carrental.database;

import com.bogus.carrental.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
    boolean existsByEmail(String email);

    @Query( "SELECT c FROM Client c WHERE c.isActive=true" )
    List<Client> findAllActive();
}
