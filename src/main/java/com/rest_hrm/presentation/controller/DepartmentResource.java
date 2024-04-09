package com.rest_hrm.presentation.controller;

import com.rest_hrm.business.dto.DepartmentDto;
import com.rest_hrm.business.dto.EmployeeDto;
import com.rest_hrm.business.dto.requests_dtos.DepartmentRequest;
import com.rest_hrm.business.service.DepartmentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("department")
public class DepartmentResource {
    DepartmentService departmentService;

    public DepartmentResource() {
        departmentService = new DepartmentService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDepartments() {
        return Response.ok(departmentService.getAllDepartments()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentById(@PathParam("id") int id) {
        DepartmentDto department = departmentService.getDepartmentById(id);
        if (department != null) {
            return Response.ok(department).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid department Id").build();
        }
    }

    @GET
    @Path("/n")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentsByName(@QueryParam("name") String name) {
        return Response.ok(departmentService.getDepartmentsStartsWithName(name)).build();
    }

    @GET
    @Path("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentManager(@QueryParam("id") int id){
        if (id == 0)
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid department Id").build();

        EmployeeDto employeeDto = departmentService.getDepartmentManager(id);
        if (employeeDto!= null)
            return Response.ok(employeeDto).build();

        return Response.status(Response.Status.BAD_REQUEST).entity("Invalid department Id").build();
    }

    @GET
    @Path("managerName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentByManagerName(@PathParam("name") String name) {
        List<DepartmentDto> departments = departmentService.getDepartmentsByManagerName(name);
        return Response.ok(departments).build();
    }

    @GET
    @Path("managerId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentByManagerId(@PathParam("id") int id) {
        DepartmentDto department = departmentService.getDepartmentByManagerID(id);
        if (department != null) {
            return Response.ok(department).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid manager Id").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDepartment(DepartmentRequest departmentRequest){
        if (departmentRequest == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no body").build();
        }
        String result = departmentService.createDepartment(departmentRequest);
        if (result.isEmpty())
            return Response.ok().build();
        else
            return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    }

    @PUT
    @Path("name")
    public Response updateDepartmentName(@QueryParam("depId") int id, @QueryParam("name") String depName) {
        DepartmentDto department = departmentService.updateDepartmentName(id, depName);
        if (department != null)
            return Response.ok(department).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).entity("invalid department Id").build();

    }

    @PUT
    @Path("manager")
    public Response updateDepartmentManager(@QueryParam("depId") int depId, @QueryParam("mgrId") int mgrId) {
        DepartmentDto departmentDto = departmentService.updateDepartmentManager(depId, mgrId);
        if (departmentDto != null)
            return Response.ok().build();
        else
            return Response.status(Response.Status.BAD_REQUEST).entity("invalid department Id").build();

    }

    @DELETE
    public Response deleteAllEmployees() {
        departmentService.deleteAllDepartments();
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartmentById(@PathParam("id") int id) {
        departmentService.deleteDepartmentById(id);
        return Response.ok().build();
    }

}
