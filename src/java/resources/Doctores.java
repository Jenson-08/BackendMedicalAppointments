/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;
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

@Path("/doctores")
public class Doctores {
     
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Doctor d) {  
        try {
            Service.instance().addDoctor(d);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> read() throws Exception { 
        return Service.instance().DoctorsAll();
    }     
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Doctor read(@PathParam("id") String cedula) {
        try {
            return Service.instance().getDoctor(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update( Doctor p) {  
        try {
            Service.instance().updateDoctor(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
   
    
    
    
    
    
    
    @DELETE
    public void delete(Doctor p) {
        try {
            Service.instance().deleteDoctor(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
}
