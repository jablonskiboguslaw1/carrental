package com.bogus.carrental.service;

import com.bogus.carrental.database.DepartmentRepository;
import com.bogus.carrental.model.Department;
import com.bogus.carrental.model.DepartmentDto;
import com.bogus.carrental.model.dtos.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department findById(Long id) {
       return departmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<DepartmentDto> getDepartmentDtos() {
        return departmentRepository.findAll().stream().map(DepartmentMapper::mapToDepartmentDto).collect(Collectors.toList());
    }

    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = departmentRepository.save(DepartmentMapper.mapDtoToDepartment(departmentDto));
        return DepartmentMapper.mapToDepartmentDto(department);
    }


}
