package com.bogus.carrental.controllers;

import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.CarReturn;
import com.bogus.carrental.service.CarReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/return")
public class CarReturnController {

    private final CarReturnService carReturnService;


    @GetMapping("")

    public List<CarReturn> getAllReturns() {
        return carReturnService.findAll();
    }

    @PostMapping("")
    public CarReturn makeReturn(@RequestBody CarReturn carReturn,@RequestParam Long reservationId) {
        return carReturnService.makeReturn(carReturn,reservationId);
    }
    @GetMapping("details")
    public CarReturn getReturnById(@RequestParam Long id){

        return carReturnService.findFindById(id);
    }

    @DeleteMapping("")
    public boolean deleteReturnById(@RequestParam Long id){
        return carReturnService.deleteReturnById(id);
    }

}


