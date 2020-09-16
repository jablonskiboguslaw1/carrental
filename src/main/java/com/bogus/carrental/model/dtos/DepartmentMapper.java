package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Department;

public class DepartmentMapper {
    private DepartmentMapper() {
    }

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .city(department.getCity())
                .name(department.getName())
                .build();
    }

    public static Department mapDtoToDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setCity(departmentDto.getCity());
        department.setName(departmentDto.getName());
        return department;
    }
}
