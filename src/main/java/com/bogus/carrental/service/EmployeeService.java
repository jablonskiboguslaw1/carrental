package com.bogus.carrental.service;

import com.bogus.carrental.database.EmployeeRepository;
import com.bogus.carrental.model.Employee;
import com.bogus.carrental.model.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public List<Employee> findAll() {
    return  employeeRepository.findAll();

    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Employee> findAllByDepartmentId(Long id) {
        return employeeRepository.findByDepartment(id);
    }


    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
@Transactional
    public Employee chooseManager(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);

        employee.setPosition(Position.MANAGER);

        return employee;
    }
    public boolean deleteById(Long id){
        employeeRepository.deleteById(id);
        return true;
    }
}
