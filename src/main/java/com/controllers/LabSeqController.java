package com.controllers;

import com.services.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class LabSeqController {

    @Inject
    LabSeqService serv;

    public LabSeqController(LabSeqService serviceInstance){
        serv = serviceInstance;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
