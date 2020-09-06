package com.bogus.carrental.database;

import com.bogus.carrental.model.CarReturn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReturnRepository extends JpaRepository<CarReturn, Long> {
}
