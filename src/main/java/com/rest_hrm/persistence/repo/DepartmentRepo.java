package com.rest_hrm.persistence.repo;

import com.rest_hrm.persistence.entities.Department;
import jakarta.persistence.EntityManager;

public class DepartmentRepo extends CrudRepo<Department, Integer> {
    public DepartmentRepo(EntityManager entityManager) {
        super(entityManager);
    }
}
