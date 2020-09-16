package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.ReservationDto;
import com.bogus.carrental.model.dtos.ReservationFormDto;
import com.bogus.carrental.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")


public class ReservationController {


    private final ReservationService reservationService;


    @GetMapping("")
    public List<ReservationDto> showAllReservation() {

        return reservationService.findAllReservations();

    }


    @GetMapping("/details")
    public ReservationDto getReservationDetails(@RequestParam(name = "id") Long id) {

        return reservationService.showReservationById(id);

    }


    @PostMapping("")
    @ResponseBody
    public ReservationDto createReservation(@RequestBody ReservationFormDto reservationFormDto) {

        return reservationService.createReservation(reservationFormDto);

    }


    @PatchMapping("")
    @ResponseBody
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto,
                                            @RequestParam(name = "id") Long id) {

        return reservationService.updateReservation(id, reservationDto);

    }


    @DeleteMapping("")
    public void deleteReservation(@RequestParam(name = "id") Long id) {

        reservationService.deleteReservationById(id);

    }

}