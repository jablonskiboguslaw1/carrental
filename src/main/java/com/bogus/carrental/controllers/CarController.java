package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.dtos.CarDto;
import com.bogus.carrental.model.dtos.CarUpdateDto;
import com.bogus.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;


    @GetMapping("/service")
    public List<Car> showAllCarsDetails() {

        return carService.showAllCarsDetails();

    }


    @GetMapping("")
    public List<CarDto> showAllCars() {

        return carService.showAllCarsDtos();

    }


    @GetMapping("/details")
    public CarDto showCarDtoById(@RequestParam(name = "id") Long id) {

        return carService.showCarDtoById(id);

    }


    @PostMapping("")
    @ResponseBody
    public Car addCar(@RequestBody Car car) {

        return carService.createCar(car);

    }


    @PatchMapping("")
    @ResponseBody
    public Car updateCar(@RequestBody CarUpdateDto carUpdateDto, @RequestParam(name = "id") Long id) {

        return carService.updateCar(id, carUpdateDto);

    }


    @DeleteMapping("")
    public void deleteCar(@RequestParam(name = "id") Long id) {

        carService.deleteCarById(id);

    }


    @GetMapping("/details/service")
    public Car showCarById(@RequestParam(name = "id") Long id) {

        return carService.showCarById(id);

    }

}
