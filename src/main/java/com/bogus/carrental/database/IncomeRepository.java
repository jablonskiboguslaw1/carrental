package com.bogus.carrental.database;

import com.bogus.carrental.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Double> {
}
