package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.ReservationDto;
import com.bogus.carrental.model.dtos.ReservationFormDto;
import com.bogus.carrental.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {


    private final ReservationService reservationService;


    @GetMapping("")
    public List<ReservationDto> showAllReservations() {

        return reservationService.findAllReservations();

    }

    @GetMapping("/client/{clientId}")
    public List<ReservationDto> showClientReservations(@PathVariable long clientId) {

        return reservationService.findClientsReservations(clientId);

    }


    @GetMapping("{id}")
    public ReservationDto getReservationDetails(@PathVariable Long id) {

        return reservationService.showReservationById(id);

    }


    @PostMapping("")
    @ResponseBody
    public ReservationDto createReservation(@RequestBody ReservationFormDto reservationFormDto) {

        return reservationService.createReservation(reservationFormDto);

    }


    @PutMapping("{id}")
    @ResponseBody
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto,
                                            @PathVariable Long id) {

        return reservationService.updateReservation(id, reservationDto);

    }


    @DeleteMapping("{id}")
    public void deleteReservation(@PathVariable Long id) {

        reservationService.deleteReservationById(id);

    }

}