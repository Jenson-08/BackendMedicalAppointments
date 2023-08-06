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
import logic.Cita;
import logic.Service;
/**
 *
 * @author jenso
 */
@Path("/citas")
public class Citas {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Cita d) {  
        try {
            Service.instance().addCita(d);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_medico}")
    public List<Cita> citasPorIdMedico(@PathParam("id_medico") String id_medico) throws Exception  { 
        return Service.instance().CitasporIddeMedico(id_medico);
    }
    
   
    
    
    
}
