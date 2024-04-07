package com.rest_hrm;

import com.rest_hrm.persistence.connection.JPAManager;
import com.rest_hrm.persistence.entities.Employee;
import com.rest_hrm.persistence.repo.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = JPAManager.INSTANCE.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        EmployeeRepo employeeRepo = new EmployeeRepo(em);
        System.out.println("employeeRepo.findById(Employee.class,2) = " + employeeRepo.findById(Employee.class, 2));
    }
}
