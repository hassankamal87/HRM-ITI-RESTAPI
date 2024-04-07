package com.rest_hrm.persistence.repo;

import com.rest_hrm.persistence.entities.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeRepo extends CrudRepo<Employee, Integer>{
    public EmployeeRepo(EntityManager entityManager) {
        super(entityManager);
    }
}
