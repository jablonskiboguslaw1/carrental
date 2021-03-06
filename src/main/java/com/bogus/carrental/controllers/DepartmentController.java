package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.DepartmentDto;
import com.bogus.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("")
    public List<DepartmentDto> getDepartments() {
        return departmentService.getDepartmentDtos();
    }

    @PostMapping("")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }


}
