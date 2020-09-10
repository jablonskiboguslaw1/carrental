package com.bogus.carrental.controllers;

import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.dtos.CarRentalDto;
import com.bogus.carrental.service.CarRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class CarRentalController {

    private final CarRentalService carRentalService;


    @GetMapping("/service")
    public List<CarRentalDto> getAllRental(){

       return carRentalService.findAll();
    }

    @GetMapping("details")
    public CarRentalDto getRentalById(@RequestParam Long id){

        return carRentalService.findFindById(id);
    }


    @PostMapping("")
    @ResponseBody
    public CarRentalDto makeRental(@RequestBody CarRental carRental, @RequestParam Long reservationId){


        return  carRentalService.makeRental(carRental, reservationId);

    }
    @DeleteMapping("")
    public boolean deleteRentalById(@RequestParam Long reservationId){
        return carRentalService.deleteRentalByReservationId(reservationId);
    }


}
