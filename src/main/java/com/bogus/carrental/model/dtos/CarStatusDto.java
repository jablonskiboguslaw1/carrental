package com.bogus.carrental.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class CarStatusDto {


    private Long car;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private String status;
}
