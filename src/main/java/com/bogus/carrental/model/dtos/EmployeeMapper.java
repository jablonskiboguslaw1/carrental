package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Department;
import com.bogus.carrental.model.Employee;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EmployeeMapper {
    private EmployeeMapper() {
    }


    public static EmployeeDto mapToDto(Employee employee) {

        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .position(employee.getPosition())
                .email(employee.getEmail())
                .department(employee.getDepartment().getName()).build();

    }


    public static Employee mapDtoToEmployee(EmployeeDto employeeDto, Department department) {
        return Employee.builder()
                .position(employeeDto.getPosition())
                .department(department)
                .email(employeeDto.getEmail())
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .password(new BCryptPasswordEncoder().encode(employeeDto.getPassword())).build();


    }
}
