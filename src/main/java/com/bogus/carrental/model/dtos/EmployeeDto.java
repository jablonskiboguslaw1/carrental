package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class EmployeeDto {

    private Long id;
    private Position position;
    private String department;
    private String name;
    private String surname;
    private String password;
    private String email;
}
