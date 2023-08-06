/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;
import java.util.List;
import javax.annotation.security.RolesAllowed;
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
import logic.Persona;
import logic.Service;
/**
 *
 * @author jenso
 */
@Path("/personas")
public class Personas {
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    @RolesAllowed({"doctor"})
    public void create(Persona p) {  
        try {
            Service.instance().addPersona(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_medico}")
    public List<Persona> personasPorIdMedico(@PathParam("id_medico") String id_medico) throws Exception  { 
        return Service.instance().PersonasporIdMedico(id_medico);
    }
    */
    
    @GET
    
    @Produces({MediaType.APPLICATION_JSON})
    
    public List<Persona> personasPorIdMedico() throws Exception  { 
       
        return Service.instance().PersonasAll();
       
    }

    @GET
    @Path("{cedula}")
    @Produces({MediaType.APPLICATION_JSON})
    
    public Persona read(@PathParam("cedula") String cedula) {
        try {
            return Service.instance().getPersonaPorId(cedula);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @PUT
    @Path("{cedula}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"doctor"})
    public void update(@PathParam("cedula") String cedula, Persona p) {  
        try {
            Service.instance().updatePersona(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @DELETE
   
    public void delete(Persona p) {
        try {
            Service.instance().deletePersona(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
