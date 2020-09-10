package com.bogus.carrental.model;

import com.bogus.carrental.model.dtos.EmployeeDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

