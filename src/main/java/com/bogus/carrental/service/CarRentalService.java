package com.bogus.carrental.service;

import com.bogus.carrental.database.CarRentalRepository;
import com.bogus.carrental.model.CarRental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;

    public List<CarRental> findAll() {

        return carRentalRepository.findAll();
    }

    public CarRental makeRental(CarRental carRental) {
        carRentalRepository.save(carRental);
        return carRental;
    }

    public CarRental  findFindById(Long id) {

       return carRentalRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }

    public boolean deleteRentalById(Long id) {

     carRentalRepository.deleteById(id);
     return true;


    }
}
