package com.rest_hrm;

import com.rest_hrm.business.dto.EmployeeDto;
import com.rest_hrm.business.service.EmployeeService;
import com.rest_hrm.persistence.connection.JPAManager;
import com.rest_hrm.persistence.entities.Employee;
import com.rest_hrm.persistence.repo.EmployeeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();
        EmployeeDto employeeDto = employeeService.updateEmployeeSalary(3, BigDecimal.valueOf(50000));
        System.out.println(employeeDto);

    }
}
