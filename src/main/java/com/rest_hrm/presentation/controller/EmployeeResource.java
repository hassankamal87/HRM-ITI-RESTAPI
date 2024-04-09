package com.rest_hrm.presentation.controller;

import com.rest_hrm.business.dto.EmployeeDto;
import com.rest_hrm.business.dto.requests_dtos.EmployeeRequest;
import com.rest_hrm.business.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Path("employee")
public class EmployeeResource {

    EmployeeService employeeService;

    public EmployeeResource() {
        employeeService = new EmployeeService();
    }

    @GET
    public Response getAllEmployees() {
        return Response.ok(employeeService.getAllEmployees()).build();
    }

    @GET
    @Path("/{id}")
    public Response getAllEmployees(@PathParam("id") int id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return Response.ok(employee).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid employee Id").build();
        }
    }

    @GET
    @Path("department/{id}")
    public Response getEmployeesByDepartmentId(@PathParam("id") int id) {
        return Response.ok(employeeService.getEmployeesWithDepartmentId(id)).build();
    }

    @GET
    @Path("/n")
    public Response getEmployeesStartsWithName(@QueryParam("name") String name) {
        return Response.ok(employeeService.getEmployeesByName(name)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployee(@Valid EmployeeRequest request) {

        if (request == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no body").build();
        }
        String result = employeeService.createEmployee(request);
        if (result.isEmpty()) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
        }
    }

    @PUT
    @Path("name")
    public Response updateEmployeeName(@QueryParam("empId") int id, @QueryParam("name") String empName) {
        return Response.ok(employeeService.updateEmployeeName(id, empName)).build();
    }

    @PUT
    @Path("email")
    public Response updateEmployeeEmail(@QueryParam("empId") int id, @QueryParam("email") String empEmail) {
        return Response.ok(employeeService.updateEmployeeEmail(id, empEmail)).build();
    }

    @PUT
    @Path("job")
    public Response updateEmployeeJob(@QueryParam("empId") int id, @QueryParam("jobId") int jobId) {
        EmployeeDto employeeDto = employeeService.updateEmployeeJob(id, jobId);
        if (employeeDto != null) {
            return Response.ok(employeeDto).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid job Id").build();
        }
    }

    @PUT
    @Path("salary")
    public Response updateEmployeeSalary(@QueryParam("empId") int id, @QueryParam("salary") BigDecimal salaryAmount) {
        return Response.ok(employeeService.updateEmployeeSalary(id, salaryAmount)).build();
    }

    @PUT
    @Path("end-date")
    public Response updateEmployeeEndDate(@QueryParam("empId") int id, @QueryParam("date") String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return Response.ok(employeeService.updateEmployeeEndDate(id, date)).build();
        } catch (DateTimeParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format. Please use yyyy-MM-dd").build();
        }
    }

    @PUT
    @Path("department")
    public Response updateEmployeeDepartment(@QueryParam("empId") int id, @QueryParam("departmentId") int departmentId) {
        if(id == 0 || departmentId == 0){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid parameter's, ex. empId=number&departmentId=number").build();
        }
        EmployeeDto employeeDto = employeeService.updateEmployeeDepartment(id, departmentId);
        if (employeeDto != null) {
            return Response.ok(employeeDto).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid department Id").build();
        }
    }

    @PUT
    @Path("address")
    public Response updateEmployeeAddress(@QueryParam("empId") int id, @QueryParam("addressId") int addressId) {
        EmployeeDto employeeDto = employeeService.updateEmployeeAddress(id, addressId);
        if (employeeDto != null) {
            return Response.ok(employeeDto).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Address Id").build();
        }
    }

    @PUT
    @Path("annual")
    public Response updateEmployeeSalary(@QueryParam("empId") int id, @QueryParam("annual") int annualNumber) {
        return Response.ok(employeeService.updateEmployeeAnnualHolidays(id, annualNumber)).build();
    }

    @DELETE
    public Response deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployeeById(@PathParam("id") int id) {
        employeeService.deleteById(id);
        return Response.ok().build();
    }
}
