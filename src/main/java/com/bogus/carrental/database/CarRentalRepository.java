package com.bogus.carrental.database;

import com.bogus.carrental.model.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface CarRentalRepository extends JpaRepository<CarRental, Long> {


    @Query ("SELECT cr from CarRental cr where cr.employee.id =?1")
    List<CarRental> findAllByEmployee(Long id);
}
