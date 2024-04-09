package com.rest_hrm.presentation.controller;

import com.rest_hrm.business.dto.HolidayDto;
import com.rest_hrm.business.dto.requests_dtos.HolidayRequest;
import com.rest_hrm.business.service.HolidayService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("holiday")
public class HolidayResource {
    HolidayService holidayService;

    public HolidayResource(){
        holidayService = new HolidayService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHolidays(){
        return Response.ok(holidayService.getAllHolidays()).build();
    }

    @GET
    @Path("/{id}")
    public Response getHolidayById(@PathParam("id") int id){
        HolidayDto holidayDto = holidayService.getHolidayById(id);
        if (holidayDto != null)
            return Response.ok(holidayDto).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).entity("invalid holiday id").build();
    }

    @GET
    @Path("emp/{id}")
    public Response getHolidayForEmployee(@PathParam("id") int id){
        List<HolidayDto> holidayDos = holidayService.getHolidaysForEmployee(id);
        return Response.ok(holidayDos).build();
    }

    @GET
    @Path("date/{date}")
    public Response getHolidayForEmployee(@PathParam("date") String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        List<HolidayDto> holidayDos = holidayService.getHolidaysByDate(date);
        return Response.ok(holidayDos).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createHoliday(HolidayRequest holidayRequest){
        if (holidayRequest == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no body").build();
        }
        HolidayDto holidayDto = holidayService.createHoliday(holidayRequest);
        if (holidayDto != null)
            return Response.ok(holidayDto).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("invalid holiday data").build();
    }
}
