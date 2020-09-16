package com.bogus.carrental.database;

import com.bogus.carrental.model.Client;
import com.bogus.carrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


public interface UserRepository<T extends User> extends JpaRepository<T, Long> {

    Optional<T> findByName(String name);

}
