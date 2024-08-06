package com.praveen.springguru.rest_crud_demo.dao;

import com.praveen.springguru.rest_crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
}
