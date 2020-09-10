package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Builder
public class CarReturnDto {


    private Long id;
    private EmployeeDto employee;
    private LocalDate dateOfReturn;
    private String comments;
    private double additionalPayments;

}

