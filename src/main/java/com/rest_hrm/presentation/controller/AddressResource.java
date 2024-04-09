package com.rest_hrm.presentation.controller;

import com.rest_hrm.business.dto.AddressDto;
import com.rest_hrm.business.service.AddressService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

@Path("address")
public class AddressResource {
    AddressService addressService;

    public AddressResource(){
        addressService = new AddressService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAddresses(){
        return Response.ok(addressService.getAllAddresses()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAddressById(@PathParam("id") int id){
        AddressDto addressDto = addressService.getAddressByID(id);
        if (addressDto != null)
            return Response.ok(addressDto).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("invalid address id").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAddress(AddressDto addressDto){
        if (addressDto == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no body").build();
        }
        AddressDto createdDto = addressService.createAddress(addressDto);
        return Response.ok(createdDto).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAddressById(@PathParam("id") int id) {
        String result = addressService.deleteAddressById(id);
        if (Objects.equals(result, ""))
            return Response.ok().build();
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(result).build();

    }
}
