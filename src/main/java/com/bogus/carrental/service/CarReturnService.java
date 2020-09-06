package com.bogus.carrental.service;

import com.bogus.carrental.database.CarReturnRepository;
import com.bogus.carrental.model.CarRental;
import com.bogus.carrental.model.CarReturn;
import com.bogus.carrental.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarReturnService {

    private final CarReturnRepository carReturnRepository;
    private final ReservationService reservationService;

    public List<CarReturn> findAll() {

        return carReturnRepository.findAll();

    }

    @Transactional
    public CarReturn makeReturn(CarReturn carReturn, Long reservationId) {
        Reservation reservationById = reservationService.getReservationById(reservationId);
        reservationById.setCarReturn(carReturn);
        return carReturn;


    }

    public CarReturn findFindById(Long id) {
        return carReturnRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public boolean deleteReturnById(Long id) {
        carReturnRepository.deleteById(id);
        return true;
    }
}
