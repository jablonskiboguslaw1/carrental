package com.bogus.carrental.service;

import com.bogus.carrental.database.CarRepository;
import com.bogus.carrental.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {


    private final CarRepository carRepository;


    public List<Car> showAllCars() {

        return carRepository.findAll();

    }


    public Car showCarById(Long id) {

        Optional<Car> carById = carRepository.findById(id);

        if (carById.isPresent())
            return carById.get();
        else
            throw new NoSuchElementException();

    }


    public Car createCar(Car car) {

        carRepository.save(car);
        return car;

    }


    public Car updateCar(Long id, Car car) {

        Optional<Car> carById = carRepository.findById(id);
        Car updatedCar = null;
        if (carById.isPresent()) {
            updatedCar = carById.get();
            if (car.getBodyType() != null)
                updatedCar.setBodyType(car.getBodyType());
            if (car.getPayForDay() != null)
                updatedCar.setPayForDay(car.getPayForDay());
            if (car.getMileage() != null)
                updatedCar.setMileage(car.getMileage());
            if (car.getColor() != null)
                updatedCar.setColor(car.getColor());
            carRepository.save(updatedCar);
        }
        return updatedCar;

    }


    public void deleteCarById(Long id) {

        carRepository.deleteById(id);

    }
}

