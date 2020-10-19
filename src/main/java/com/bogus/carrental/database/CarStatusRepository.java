package com.bogus.carrental.database;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.CarStatus;
import com.bogus.carrental.model.dtos.CarStatusDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarStatusRepository extends JpaRepository<CarStatus, Long> {

}
