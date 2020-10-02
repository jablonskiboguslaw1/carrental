package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.CarReturnDto;
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

    public List<CarReturnDto> getAllReturns() {
        return carReturnService.findAll();
    }

    @PostMapping("")
    public CarReturnDto makeReturn(@RequestBody CarReturnDto carReturn, @RequestParam Long empl, @RequestParam Long reservationId) {
        return carReturnService.makeReturn(carReturn, empl, reservationId);
    }

    @GetMapping("details")
    public CarReturnDto getReturnById(@RequestParam Long id) {

        return carReturnService.findById(id);
    }

    @DeleteMapping("")
    public boolean deleteReturnByReservationId(@RequestParam Long id) {
        return carReturnService.deleteReturnByReservationId(id);
    }

}


