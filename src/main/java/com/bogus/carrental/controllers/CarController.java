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


    @CrossOrigin
    @GetMapping("")
    public List<CarDto> showAllCars() {

        return carService.showAllCarsDtos();

    }


    @GetMapping("/{id}")
    public CarDto showCarDtoById( @PathVariable  Long id) {

        return carService.showCarDtoById(id);

    }


    @PostMapping("")
    @ResponseBody
    public CarDto addCar(@RequestBody CarDto carDto) {

        return carService.addCar(carDto);

    }


    @PatchMapping("/{id}")
    @ResponseBody
    public CarDto  updateCar(@RequestBody CarUpdateDto carUpdateDto, @PathVariable  Long id) {

        return carService.updateCar(id, carUpdateDto);

    }

    @PatchMapping("/department")
    @ResponseBody
    public CarDto setCarDepartment(@RequestParam(name = "car") Long car, @RequestParam(name = "id") Long id) {

        return carService.setCarDepartment(id, car);

    }


    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable  Long id) {

        carService.deleteCarById(id);

    }


    @GetMapping("/department")
    public List<CarDto> showAllCarsByDepartment(@RequestParam Long departmentId) {

        return carService.showAllCarsDtosByDepartment(departmentId);

    }

    @GetMapping("/dates")
    public List<CarDto> showAllCarsAvailable(
            @RequestParam(name = "start") String start,
            @RequestParam(name = "end") String end) {

        return carService.showAllCarsAvailable(
                LocalDate.parse(start), LocalDate.parse(end));

    }
}
