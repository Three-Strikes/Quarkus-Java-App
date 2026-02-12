package com.controllers;

import com.services.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigInteger;

@Path("/labseq")
public class LabSeqController {

    @Inject
    LabSeqService serv;

    @Path("{n}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public BigInteger CalculateLabSeqSequence(int n) {
        try{
            return serv.calculateLabSeq(n);
        }catch (IllegalArgumentException e){
            throw new WebApplicationException(
                    Response.status(400)
                    .entity(e.getMessage())
                    .type("text/plain")
                    .build());
        }
    }
}
