package com.bogus.carrental.service;

import com.bogus.carrental.database.DepartmentRepository;
import com.bogus.carrental.database.EmployeeRepository;
import com.bogus.carrental.model.Employee;
import com.bogus.carrental.model.Position;
import com.bogus.carrental.model.dtos.EmployeeDto;
import com.bogus.carrental.model.dtos.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::mapToDto).collect(Collectors.toList());

    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<EmployeeDto> findAllByDepartmentId(Long id) {
        return employeeRepository.findByDepartment(id).stream().map(EmployeeMapper::mapToDto).collect(Collectors.toList());
    }


    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapDtoToEmployee(employeeDto, departmentRepository.findByName(employeeDto.getDepartment()));
        employeeRepository.save(employee);
        return EmployeeMapper.mapToDto(employee);
    }

    @Transactional
    public EmployeeDto chooseManager(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);

        employee.setPosition(Position.MANAGER);

        return EmployeeMapper.mapToDto(employee);
    }

    public boolean deleteById(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
