package com.rest_hrm.presentation.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("test")
public class TestClass {

    @POST
    public String getAll(){
        return "everyThing is Well don't worry";
    }
}
