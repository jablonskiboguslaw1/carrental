package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.CarRentalDto;
import com.bogus.carrental.service.CarRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class CarRentalController {


    private final CarRentalService carRentalService;


    @GetMapping("/service")
    public List<CarRentalDto> getAllRental() {

        return carRentalService.findAll();
    }

    @GetMapping("details")
    public CarRentalDto getRentalById(@RequestParam Long id) {

        return carRentalService.findFindById(id);
    }

    // public CarReturnDto makeReturn(@RequestBody CarReturnFormDto carReturn, @RequestParam Long empl, @RequestParam Long reservationId) {
    //   return carReturnService.makeReturn(carReturn,empl,reservationId);
    @PostMapping("")
    @ResponseBody
    public CarRentalDto makeRental(@RequestBody CarRentalDto carRentalDto, @RequestParam Long reservationId) {


        return carRentalService.makeRental(carRentalDto, reservationId);

    }

    @DeleteMapping("")
    public boolean deleteRentalById(@RequestParam Long reservationId) {
        return carRentalService.deleteRentalByReservationId(reservationId);
    }


}
