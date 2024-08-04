package com.praveen.springguru.rest_crud_demo.rest;

import com.praveen.springguru.rest_crud_demo.dao.EmployeeDAO;
import com.praveen.springguru.rest_crud_demo.entity.Employee;
import com.praveen.springguru.rest_crud_demo.error.exception.NotFoundException;
import com.praveen.springguru.rest_crud_demo.error.pojo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        if(allEmployees == null || allEmployees.isEmpty()) {
            throw new NotFoundException("No employees found");
        }
        return allEmployees;
    }
}
