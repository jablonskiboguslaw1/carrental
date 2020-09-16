package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Department;
import com.bogus.carrental.model.Employee;

public class EmployeeMapper {
    private EmployeeMapper() {
    }


    public static EmployeeDto mapToDto(Employee employee) {

        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .position(employee.getPosition())
                .department(employee.getDepartment().getName()).build();

    }

    public static Employee mapDtoToEmployee(EmployeeDto employeeDto, Department department) {
        return Employee.builder()
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .position(employeeDto.getPosition())
                .department(department)
                .build();
    }

}
