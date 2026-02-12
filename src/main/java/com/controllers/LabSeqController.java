package com.controllers;

import com.services.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.math.BigInteger;

@Path("/labseq")
public class LabSeqController {

    @Inject
    LabSeqService serv;

    @Path("{n:\\d+}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public BigInteger calculate(int n) {
        try{
            return serv.calculateLabSeq(n);
        }catch (IllegalArgumentException e){
            throw new WebApplicationException(e.getMessage(), 400);
        }catch (ProcessingException e){
            throw new WebApplicationException(e.getMessage(), 500);
        }

    }
}
