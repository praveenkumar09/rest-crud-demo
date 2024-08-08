package com.praveen.springguru.rest_crud_demo.repository;


import com.praveen.springguru.rest_crud_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
