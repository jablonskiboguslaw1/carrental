package com.bogus.carrental.controllers;

import com.bogus.carrental.model.DepartmentDto;
import com.bogus.carrental.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("")
    public List<DepartmentDto> getDepartments(){
        return departmentService.getDepartmentDtos();
    }

   @PostMapping("")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.addDepartment(departmentDto);
   }





}
