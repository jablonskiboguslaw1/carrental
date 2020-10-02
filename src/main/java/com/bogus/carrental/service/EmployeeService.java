package com.bogus.carrental.service;

import com.bogus.carrental.database.DepartmentRepository;
import com.bogus.carrental.database.EmployeeRepository;
import com.bogus.carrental.model.Client;
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
        return employeeRepository.findAllByActiveIsTrue().stream().map(EmployeeMapper::mapToDto).collect(Collectors.toList());

    }

    public EmployeeDto findById(Long id) {
        return EmployeeMapper.mapToDto(employeeRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<EmployeeDto> findAllByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentAndActiveIsTrue(id).stream().map(EmployeeMapper::mapToDto).collect(Collectors.toList());
    }


    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapDtoToEmployee(employeeDto, departmentRepository.findByName(employeeDto.getDepartment()));
        employee.setActive(true);
        employeeRepository.save(employee);
        return EmployeeMapper.mapToDto(employee);
    }

    @Transactional
    public EmployeeDto changeRights(Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (employee.getPosition().equals(Position.MANAGER)) {
            employee.setPosition(Position.EMPLOYEE);
        }else
        if (employee.getPosition().equals(Position.EMPLOYEE)) {
            employee.setPosition(Position.MANAGER);
        }

        return EmployeeMapper.mapToDto(employee);
    }

   @Transactional
        public void deactivateEmployeeAccountById(Long id) {

            Employee employee = employeeRepository.findById(id).orElseThrow(NoSuchElementException::new);
            employee.setActive(!employee.isActive());
        }
    }

