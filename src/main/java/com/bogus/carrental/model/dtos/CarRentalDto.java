package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CarRentalDto {

    private Long id;
    private Long employeeId;
    private LocalDate dateOfRental;
    private String comments;
}
