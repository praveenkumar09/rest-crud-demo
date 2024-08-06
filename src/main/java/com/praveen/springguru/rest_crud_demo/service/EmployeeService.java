package com.praveen.springguru.rest_crud_demo.service;

import com.praveen.springguru.rest_crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
}
