package com.bogus.carrental.model.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String mark;
    private String model;
    private String bodyType;
    private Long mileage;
    private String color;
    private String productionYear;
    private Double payForDay;
}
