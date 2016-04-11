package com.nems.revctx.resources.submission;

import com.nems.revctx.services.submission.SubmissionService;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import org.glassfish.jersey.server.ContainerRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by NE281900 on 4/9/2016.
 */
@Path("service/{id}")
public class SubmissionResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getQuery(
            @Suspended final AsyncResponse response,
            @Context ContainerRequest jerseyRequest,
            @Context HttpServerRequest vertxRequest,
            @Context Vertx vertx,
            @PathParam("id")int id) {

        vertx.runOnContext(aVoid -> {
            response.resume(new Test("abc","def"));
        });
    }
}
