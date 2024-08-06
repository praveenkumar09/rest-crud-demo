package com.praveen.springguru.rest_crud_demo.daoImpl;

import com.praveen.springguru.rest_crud_demo.dao.EmployeeDAO;
import com.praveen.springguru.rest_crud_demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves all employees from the database.
     *
     * @return A list of all employees in the system.
     */
    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }
}
