package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("")
    public List<Car> showAllCars() {

        return carService.showAllCars();

    }


    @GetMapping("/details")
    public Car showCarById(@RequestParam(name = "id") Long id) {

        return carService.showCarById(id);

    }

    @PostMapping("")
    @ResponseBody
    public Car addCar(@RequestBody Car car) {

        return carService.createCar(car);

    }

    @PatchMapping("")
    @ResponseBody
    public Car updateCar(@RequestBody Car car, @RequestParam(name = "id") Long id) {

        return carService.updateCar(id, car);

    }

    @DeleteMapping("")
    public void deleteCar(@RequestParam(name = "id") Long id) {

        carService.deleteCarById(id);

    }

}
