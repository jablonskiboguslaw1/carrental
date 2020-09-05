package com.bogus.carrental.service;

import com.bogus.carrental.database.CarRepository;
import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.dtos.CarDto;
import com.bogus.carrental.model.dtos.CarMapper;
import com.bogus.carrental.model.dtos.CarUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {


    private final CarRepository carRepository;


    public List<Car> showAllCarsDetails() {

        return carRepository.findAll();

    }


    public List<CarDto> showAllCarsDtos() {

        return CarMapper.mapToCarDtos(carRepository.findAll());

    }


    public Car showCarById(Long id) {

        Optional<Car> carById = carRepository.findById(id);

        if (carById.isPresent())
            return carById.get();
        else
            throw new NoSuchElementException();

    }


    public CarDto createCar(CarDto carDto) {
        Car car = CarMapper.mapDtoToCar(carDto);
        carRepository.save(car);
        return CarMapper.mapToCarDto(car);

    }


    public void deleteCarById(Long id) {

        carRepository.deleteById(id);

    }

    public CarDto showCarDtoById(Long id) {
        Optional<Car> carById = carRepository.findById(id);

        if (carById.isPresent())
            return CarMapper.mapToCarDto(carById.get());
        else
            throw new NoSuchElementException();
    }


    public Car updateCar(Long id, CarUpdateDto carUpdateDto) {

        Optional<Car> carById = carRepository.findById(id);

        Car updatedCar = carById.orElseThrow(NoSuchElementException::new);

            if (carUpdateDto.getPayForDay() != null)
                updatedCar.setPayForDay(carUpdateDto.getPayForDay());
            if (carUpdateDto.getMileage() != null)
                updatedCar.setMileage(carUpdateDto.getMileage());
            if (carUpdateDto.getColor() != null)
                updatedCar.setColor(carUpdateDto.getColor());
            carRepository.save(updatedCar);

        return updatedCar;

    }

}

