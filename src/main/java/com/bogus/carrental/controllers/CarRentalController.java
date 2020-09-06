package com.bogus.carrental.controllers;

import com.bogus.carrental.model.CarRental;
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
    public List<CarRental> getAllRental(){

       return carRentalService.findAll();
    }

    @GetMapping("details")
    public CarRental getRentalById(@RequestParam Long id){

        return carRentalService.findFindById(id);
    }


    @PostMapping
    @ResponseBody
    public CarRental makeRental(@RequestBody CarRental carRental){
        return  carRentalService.makeRental(carRental);

    }
    @DeleteMapping
    public boolean deleteRentalById(@RequestParam Long id){
        return carRentalService.deleteRentalById(id);
    }
}
