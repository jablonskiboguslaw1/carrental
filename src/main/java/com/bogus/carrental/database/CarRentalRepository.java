package com.bogus.carrental.database;

import com.bogus.carrental.model.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentalRepository extends JpaRepository<CarRental, Long> {
}
