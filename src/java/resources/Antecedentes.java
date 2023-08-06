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
import logic.Antecedente;
/**
 *
 * @author jenso
 */
@Path("/antecedente")
public class Antecedentes {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) 
    public void create(Antecedente p) {  
        try {
            Service.instance().addAntecedente(p);
        } catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Antecedente> antecedentesAll() throws Exception  { 
        return Service.instance().AntecedentesAll();
    }
}
