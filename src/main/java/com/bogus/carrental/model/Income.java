package com.bogus.carrental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue
    private Long id;
    private Double income;
    private String operation;
    @Formula("select sum(i.income) from Income i")
    private Double globalIncome;

    public Income(Double income, String operation) {
        this.income = income;
        this.operation = operation;
    }
}
