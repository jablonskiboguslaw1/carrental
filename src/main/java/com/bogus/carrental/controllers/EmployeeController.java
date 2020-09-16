package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Employee;
import com.bogus.carrental.model.dtos.EmployeeDto;
import com.bogus.carrental.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {


    private final EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.findAll();

    }

    @GetMapping("/details")
    public Employee getEmployeeById(@RequestParam Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/department")
    List<EmployeeDto> getEmployeesByDepartmentId(@RequestParam Long id) {
        return employeeService.findAllByDepartmentId(id);
    }

    @PostMapping
    @ResponseBody
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PatchMapping
    public EmployeeDto chooseManager(@RequestParam Long id) {
        return employeeService.chooseManager(id);
    }

    @DeleteMapping
    public boolean deleteEmployeeById(@RequestParam Long id) {
        return employeeService.deleteById(id);
    }

}
