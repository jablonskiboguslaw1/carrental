package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ReservationFormDto {



    private Long car;
    private Long client;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
}
