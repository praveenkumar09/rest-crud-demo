package com.praveen.springguru.rest_crud_demo.serviceImpl;

import com.praveen.springguru.rest_crud_demo.dao.EmployeeDAO;
import com.praveen.springguru.rest_crud_demo.entity.Employee;
import com.praveen.springguru.rest_crud_demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
