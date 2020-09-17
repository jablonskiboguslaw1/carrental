package com.bogus.carrental.database;

import com.bogus.carrental.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository<T extends UserEntity> extends JpaRepository<T, Long> {

    Optional<T> findByName(String name);

}
