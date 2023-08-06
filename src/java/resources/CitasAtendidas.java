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
import logic.Service;
import logic.CitaAtendida;
/**
 *
 * @author jenso
 */
@Path("/citaatendida")
public class CitasAtendidas {
     @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(CitaAtendida p) {  
        try {
            Service.instance().addCitaAtendida(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id_medico}")
    public List<CitaAtendida> citasPorIdMedico(@PathParam("id_medico") String id_medico) throws Exception  { 
        return Service.instance().CitasAtendidasporIddeMedico(id_medico);
    }
    
    
    
    
    
    
}



