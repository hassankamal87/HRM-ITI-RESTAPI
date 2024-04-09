package com.rest_hrm.presentation.controller;

import com.rest_hrm.business.dto.TimeEntryDto;
import com.rest_hrm.business.dto.requests_dtos.TimeEntryRequest;
import com.rest_hrm.business.service.TimeEntryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Path("timeEntry")
public class TimeEntryResource {
    TimeEntryService timeEntryService;

    public TimeEntryResource() {
        timeEntryService = new TimeEntryService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTimeEntries() {
        return Response.ok(timeEntryService.getAllTimeEntries()).build();
    }

    @GET
    @Path("/{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeEntriesForEmployee(@PathParam("empId") int id) {
        return Response.ok(timeEntryService.getTimeEntriesForEmployee(id)).build();
    }

    @GET
    @Path("month/{empId}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimeEntriesForEmployeesInMonth(@PathParam("empId") int id, @PathParam("date") String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        return Response.ok(timeEntryService.getTimeEntriesForEmployeesInMonth(id, date)).build();
    }

    @GET
    @Path("hours/{empId}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalHoursForEmployeeInMonth(@PathParam("empId") int id, @PathParam("date") String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);

        Long totalHoursForEmployeeInMonth = timeEntryService.getTotalHoursForEmployeeInMonth(id, date);
        if (totalHoursForEmployeeInMonth == null)
            return Response.ok(0).build();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTimeEntry(TimeEntryRequest timeEntryRequest){
        if (timeEntryRequest == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no body").build();
        }

        TimeEntryDto dto = timeEntryService.createTimeEntry(timeEntryRequest);
        if (dto != null)
            return Response.ok(dto).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("invalid Time Entry data").build();
    }
}