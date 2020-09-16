package com.bogus.carrental.service;

import com.bogus.carrental.database.IncomeRepository;
import com.bogus.carrental.model.Income;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class IncomeService {

    private final IncomeRepository incomeRepository;


    public void addIncomeEntry(Income income) {
        incomeRepository.save(income);

    }
}
