package com.bogus.carrental.service;

import com.bogus.carrental.database.CarRepository;
import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.dtos.CarDto;
import com.bogus.carrental.model.dtos.CarMapper;
import com.bogus.carrental.model.dtos.CarUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {


    private final CarRepository carRepository;
    private final DepartmentService departmentService;

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


    public CarDto addCar(CarDto carDto) {
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

    @Transactional
    public Car setCarDepartment(Long id, Long car) {
        Car updatedCar = carRepository.findById(car).orElseThrow(NoSuchElementException::new);
        updatedCar.setDepartment(departmentService.findById(id));
        return updatedCar;
    }

    public List<CarDto> showAllCarsDtosByDepartment(Long id) {
        return carRepository.findCarsByDepartment(id).stream().map(CarMapper::mapToCarDto).collect(Collectors.toList());

    }

    public List<Car> showAllCarsAvailable(LocalDate start1, LocalDate end1) {

        return carRepository.findAllAvailableCars().stream().filter(
                car -> car.getStatuses().stream().noneMatch(
                        carStatus ->
                                ((carStatus.getStartDate().isBefore(end1)) &&
                                        (carStatus.getEndDate().isAfter(start1)))))
                .collect(Collectors.toList());

    }
}

