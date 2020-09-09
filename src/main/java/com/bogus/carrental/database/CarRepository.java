package com.bogus.carrental.database;

import com.bogus.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {


    @Query("Select c from Car c where c.department.Id=?1")
    List<Car> findCarsByDepartment(Long id);


    @Query("Select distinct c from Car c left join c.reservations left join c.statuses")
    List<Car> findAllAvailableCars();
}
