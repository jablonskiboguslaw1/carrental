package com.bogus.carrental.database;

import com.bogus.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car,Long> {

}
