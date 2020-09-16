package com.bogus.carrental.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

