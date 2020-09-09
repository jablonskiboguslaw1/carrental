package com.bogus.carrental.controllers;

import com.bogus.carrental.model.Employee;
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
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();

    }

    @GetMapping("/details")
    public Employee getEmployeeById(@RequestParam Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/department")
    List<Employee> getEmployeesByDepartmentId(@RequestParam Long id) {
        return employeeService.findAllByDepartmentId(id);
    }

    @PostMapping
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PatchMapping
    public Employee chooseManager(@RequestParam Long id) {
        return employeeService.chooseManager(id);
    }

    @DeleteMapping

    public boolean deleteEmployeeById(@RequestParam Long id) {
        return employeeService.deleteById(id);
    }

}
