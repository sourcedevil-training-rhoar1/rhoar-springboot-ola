/**
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.developers.msa.ola;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Path("/api")
@Component
public class OlaResource {


    @Value("${com.redhat.developers.msa.ola.loc:true}")
    private boolean loc;


    @Context
    private HttpServletRequest servletRequest;
    
    @GET
    @Path("/ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String ola() {
    	if (loc) {
            String hostname = servletRequest.getServerName();
            return String.format("Olá de %s", hostname);
    	}else {
    		return "ola";
    	}
    	
    }
  
}
