package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.CarRentalDto;
import com.bogus.carrental.service.CarRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class CarRentalController {

    private final CarRentalService carRentalService;


    @GetMapping("")
    public List<CarRentalDto> getAllRental() {

        return carRentalService.findAll();
    }


    @GetMapping("/empl/{id}")
    public List<CarRentalDto> getAllRentalByEmployee(@PathVariable Long id) {

        return carRentalService.findAllByEmployee(id);
    }


    @GetMapping("/{id}")
    public CarRentalDto getRentalById(@PathVariable Long id) {

        return carRentalService.findFindById(id);
    }


    @PostMapping("/{reservationId}")
    @ResponseBody
    public CarRentalDto makeRental(@RequestBody CarRentalDto carRentalDto, @PathVariable Long reservationId) {


        return carRentalService.makeRental(carRentalDto, reservationId);

    }

    @DeleteMapping("/{reservationId}")
    public boolean deleteRentalById(@PathVariable Long reservationId) {
        return carRentalService.deleteRentalByReservationId(reservationId);
    }


}
