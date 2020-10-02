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
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String city;
    private String street;
    private String postCode;
    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;
    private boolean isActive;
}
