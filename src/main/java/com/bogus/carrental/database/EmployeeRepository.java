package com.bogus.carrental.database;

import com.bogus.carrental.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("Select e from Employee e where e.department.Id=?1")
    List<Employee> findByDepartmentAndActiveIsTrue(Long id);

    Employee findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("Select e from Employee e where e.isActive=true")
    List<Employee> findAllByActiveIsTrue();

}
