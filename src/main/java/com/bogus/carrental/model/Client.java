package com.bogus.carrental.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
<<<<<<< HEAD
public class Client extends UserEntity {

=======
public class Client {
>>>>>>> parent of 957e9bd... inheritanece looks good

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
}
