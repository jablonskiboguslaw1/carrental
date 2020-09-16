package com.bogus.carrental.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client extends User{


    private String email;
    private String city;
    private String street;
    private String postCode;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
}
