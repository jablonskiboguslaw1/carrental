package com.bogus.carrental.controllers;

import com.bogus.carrental.model.dtos.EmployeeDto;
import com.bogus.carrental.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {


    private final EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/department/{id}")
    List<EmployeeDto> getEmployeesByDepartmentId(@PathVariable Long id) {
        return employeeService.findAllByDepartmentId(id);
    }

    @PostMapping
    @ResponseBody
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping("{id}")
    @ResponseBody
    public EmployeeDto changeRights(@PathVariable Long id) {
        return employeeService.changeRights(id);
    }

    @DeleteMapping("{id}")
    public void deactivateEmployeeById(@PathVariable Long id) {
        employeeService.deactivateEmployeeAccountById(id);


    }

}
