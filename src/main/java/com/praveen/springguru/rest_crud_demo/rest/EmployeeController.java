package com.praveen.springguru.rest_crud_demo.rest;

import com.praveen.springguru.rest_crud_demo.entity.Employee;
import com.praveen.springguru.rest_crud_demo.error.exception.NotFoundException;
import com.praveen.springguru.rest_crud_demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        if(savedEmployee == null) {
            throw new NotFoundException("Employee not found");
        }
        return savedEmployee;
    }


    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        if(employee == null) {
            throw new NotFoundException("Employee not found");
        }
        return employee;
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        if(savedEmployee == null) {
            throw new NotFoundException("Employee not found");
        }
        return savedEmployee;
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee deleted successfully";
    }
}
