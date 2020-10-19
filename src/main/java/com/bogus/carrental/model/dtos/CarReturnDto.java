package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CarReturnDto {


    private Long id;
    private Long employeeId;
    private LocalDate dateOfReturn;
    private String comments;
    private BigDecimal additionalPayments;

}

