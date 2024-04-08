package com.rest_hrm.persistence.repo;

import com.rest_hrm.persistence.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeRepo extends CrudRepo<Employee, Integer>{
    public EmployeeRepo(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Employee> findByName(String name){
        String jpql = "SELECT p FROM Employee p WHERE p.empName LIKE :name";
        TypedQuery<Employee> findQuery = entityManager.createQuery(jpql, Employee.class);
        findQuery.setParameter("name", name + "%");
        return findQuery.getResultList();
    }

    public void deleteAll() {
        String jpql = "DELETE FROM Employee";
        entityManager.createQuery(jpql).executeUpdate();
    }
}
