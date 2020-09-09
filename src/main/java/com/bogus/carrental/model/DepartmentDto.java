package com.bogus.carrental.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DepartmentDto {
private Long id;
    private String name;
    private String city;


}
