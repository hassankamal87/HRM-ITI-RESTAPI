package com.rest_hrm.presentation.controller;

import com.rest_hrm.business.dto.JobDto;
import com.rest_hrm.business.service.JobService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("job")
public class JobResource {
    JobService jobService;

    public JobResource(){
        jobService = new JobService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs(){
        return Response.ok(jobService.getAllJobs()).build();
    }

    @GET
    @Path("/{id}")
    public Response getJobById(@PathParam("id") int id){
        JobDto jobDto = jobService.getJobById(id);
        if (jobDto != null)
            return Response.ok(jobDto).build();
        else
            return Response.status(Response.Status.BAD_REQUEST).entity("invalid job id").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createJob(JobDto jobDto){
        if (jobDto == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no body").build();
        }
        JobDto createdJobDto = jobService.createJob(jobDto);
        return Response.ok(createdJobDto).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteJobById(@PathParam("id") int id) {
        jobService.deleteJobById(id);
        return Response.ok().build();
    }

}
