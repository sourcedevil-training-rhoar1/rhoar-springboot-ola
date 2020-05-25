package com.redhat.developers.msa.ola;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class OlaHealthResource {

	@Autowired
	HealthEndpoint healthEndpoint;
	
    @GET
    @Path("/health")
    @Produces(MediaType.APPLICATION_JSON)
    public Health getHealth() {
        return healthEndpoint.health();
    }
}
