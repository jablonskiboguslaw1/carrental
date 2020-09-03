package com.bogus.carrental.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarUpdateDto {

    private Long mileage;
    private String color;
    private Double payForDay;

}
