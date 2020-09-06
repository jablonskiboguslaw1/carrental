package com.bogus.carrental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CarReturn {


    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Employee employee;
    @CreationTimestamp
    private LocalDate dateOfReturn;
    private String comments;
    private double additionalPayments;

}

