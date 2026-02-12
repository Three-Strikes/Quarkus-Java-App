package com.controllers;

import com.services.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.math.BigInteger;

@Path("/labseq")
public class LabSeqController {

    @Inject
    LabSeqService serv;

    @Path("{n}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get the result of the labseq sequence for an n number.", description = "Returns the result of the sequence L(n) = L(n-4) + L(n-3).")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Returns the result of the labseq sequence."
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "The inserted parameter was not able to be processed."
            )
    })
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
