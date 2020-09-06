package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.ReservationDto;
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
    public ReservationDto createReservation(@RequestBody Reservation reservation) {

        return reservationService.createReservation(reservation);

    }


    @PatchMapping("")
    @ResponseBody
    public ReservationDto updateReservation(@RequestBody Reservation reservation,
                                            @RequestParam(name = "id") Long id) {

        return reservationService.updateReservation(id, reservation);

    }


    @DeleteMapping("")
    public void deleteReservation(@RequestParam(name = "id") Long id) {

        reservationService.deleteReservationById(id);

    }

}