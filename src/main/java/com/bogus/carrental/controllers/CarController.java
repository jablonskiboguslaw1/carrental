package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Car;
import com.bogus.carrental.model.dtos.CarDto;
import com.bogus.carrental.model.dtos.CarStatusDto;
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
    public CarDto showCarDtoById(@PathVariable Long id) {

        return carService.showCarDtoById(id);

    }


    @PostMapping("")
    @ResponseBody
    public CarDto addCar(@RequestBody CarDto carDto) {

        return carService.addCar(carDto);

    }


    @PutMapping("{id}")
    @ResponseBody
    public CarDto updateCar(@RequestBody CarUpdateDto carUpdateDto, @PathVariable Long id) {

        return carService.updateCar(id, carUpdateDto);

    }

    @PutMapping("/department/car/{id}")
    @ResponseBody
    public CarDto setCarDepartment(@RequestParam(name = "car") Long car, @PathVariable Long id) {

        return carService.setCarDepartment(id, car);

    }


    @PutMapping("/status")
    @ResponseBody
    public CarStatusDto blockCar(@RequestBody CarStatusDto status) {

      return  carService.blockCarById(status);

    }


    @GetMapping("/department/{departmentId}")
    public List<CarDto> showAllCarsByDepartment(@PathVariable Long departmentId) {

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
