package com.praveen.springguru.rest_crud_demo.rest;

import com.praveen.springguru.rest_crud_demo.entity.Employee;
import com.praveen.springguru.rest_crud_demo.error.exception.NotFoundException;
import com.praveen.springguru.rest_crud_demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        if(allEmployees == null || allEmployees.isEmpty()) {
            throw new NotFoundException("No employees found");
        }
        return allEmployees;
    }
}
