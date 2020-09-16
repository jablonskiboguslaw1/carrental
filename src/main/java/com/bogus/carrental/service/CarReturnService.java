package com.bogus.carrental.service;

import com.bogus.carrental.database.CarReturnRepository;
import com.bogus.carrental.database.EmployeeRepository;
import com.bogus.carrental.database.ReservationRepository;
import com.bogus.carrental.model.Income;
import com.bogus.carrental.model.Reservation;
import com.bogus.carrental.model.dtos.CarReturnDto;
import com.bogus.carrental.model.dtos.CarReturnFormDto;
import com.bogus.carrental.model.dtos.CarReturnMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarReturnService {

    private final CarReturnRepository carReturnRepository;
    private final ReservationService reservationService;
    private final EmployeeRepository employeeRepository;
    private final ReservationRepository reservationRepository;
    private final IncomeService incomeService;

    public List<CarReturnDto> findAll() {

        return carReturnRepository.findAll().stream().map(CarReturnMapper::mapToDto).collect(Collectors.toList());

    }

    @Transactional
    public CarReturnDto makeReturn(CarReturnFormDto carReturn, Long employeeId, Long reservationId) {
        Reservation reservationById = reservationService.findById(reservationId);
        reservationById.setCarReturn(CarReturnMapper.mapDtoToCarReturn(carReturn, employeeRepository.findById(employeeId).orElseThrow(NoSuchElementException::new)));
        incomeService.addIncomeEntry(new Income(reservationById.getCarReturn().getAdditionalPayments(), "RETURN"));
        return CarReturnMapper.mapToDto(reservationById.getCarReturn());


    }

    public CarReturnDto findById(Long id) {
        return CarReturnMapper.mapToDto(carReturnRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }


    @Transactional
    public boolean deleteReturnByReservationId(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
        //.setCarReturn(null);


        // if (reservation.getReservationEnd().isBefore(LocalDate.now().plusDays(1))) {
        incomeService.addIncomeEntry(new Income(0 - (reservation.getCarReturn().getAdditionalPayments()), "RETURN_CANCELING"));
        //  } else
        //      incomeService.addIncomeEntry(new Income(0-(reservation.getCarReturn().getAdditionalPayments()),"RETURN_CANCELING"));

        carReturnRepository.deleteById(reservation.getCarReturn().getId());
        return true;

    }
}
