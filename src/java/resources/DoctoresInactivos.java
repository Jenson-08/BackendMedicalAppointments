/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import javax.ws.rs.Path;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import logic.Doctor;
import logic.Service;
/**
 *
 * @author jenso
 */
@Path("/doctoresinactivos")
public class DoctoresInactivos {
    @GET
    @Path("{inactivo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> read(@PathParam("inactivo") String inactivo) throws Exception { 
        return Service.instance().findInactive(inactivo);
    }     
}
