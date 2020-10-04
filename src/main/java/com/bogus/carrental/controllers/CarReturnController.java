package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.CarReturnDto;
import com.bogus.carrental.service.CarReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/returns")
public class CarReturnController {

    private final CarReturnService carReturnService;


    @GetMapping("")

    public List<CarReturnDto> getAllReturns() {
        return carReturnService.findAll();
    }

    @PostMapping("{reservationId}")
    public CarReturnDto makeReturn(@RequestBody CarReturnDto carReturn, @PathVariable Long reservationId) {
        return carReturnService.makeReturn(carReturn, reservationId);
    }

    @GetMapping("{id}")
    public CarReturnDto getReturnById(@PathVariable Long id) {

        return carReturnService.findById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteReturnByReservationId(@PathVariable Long id) {
        return carReturnService.deleteReturnByReservationId(id);
    }

}


