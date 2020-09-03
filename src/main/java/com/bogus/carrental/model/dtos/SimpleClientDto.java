package com.bogus.carrental.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class SimpleClientDto {

        private Long id;
        private String surname;
        private String email;
        private String city;
        private String street;
        private String postCode;
}
