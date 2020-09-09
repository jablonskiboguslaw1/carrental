package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.dtos.CarDto;
import com.bogus.carrental.model.dtos.CarUpdateDto;
import com.bogus.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin
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
    public CarDto addCar(@RequestBody CarDto carDto) {

        return carService.addCar(carDto);

    }


    @PatchMapping("")
    @ResponseBody
    public Car updateCar(@RequestBody CarUpdateDto carUpdateDto, @RequestParam(name = "id") Long id) {

        return carService.updateCar(id, carUpdateDto);

    }

    @PatchMapping("/department")
    @ResponseBody
    public Car setCarDepartment(@RequestParam(name="car")Long car, @RequestParam(name = "id") Long id) {

        return carService.setCarDepartment(id,car);

    }


    @DeleteMapping("")
    public void deleteCar(@RequestParam(name = "id") Long id) {

        carService.deleteCarById(id);

    }


    @GetMapping("/details/service")
    public Car showCarById(@RequestParam(name = "id") Long id) {

        return carService.showCarById(id);

    }
    @GetMapping("/department")
    public List<CarDto> showAllCarsByDepartment(@RequestParam Long departmentId) {

        return carService.showAllCarsDtosByDepartment(departmentId);

    }
    @GetMapping("/dates")
    public List<Car> showAllCarsAvailable(
            @RequestParam(name = "start") String start,
            @RequestParam(name = "end") String end) {

        return carService.showAllCarsAvailable(
                LocalDate.parse(start), LocalDate.parse(end));

    }
}
