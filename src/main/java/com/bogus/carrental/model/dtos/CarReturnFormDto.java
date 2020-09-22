package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CarReturnFormDto {


    private Long id;
    private LocalDate dateOfReturn;
    private String comments;
    private double additionalPayments;
}
