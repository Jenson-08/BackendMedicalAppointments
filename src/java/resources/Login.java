/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;
import logic.Service;
import logic.Usuario;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import logic.Doctor;
/**
 *
 * @author jenso
 */


@Path("/login")
@PermitAll
public class Login {
     @Context
    HttpServletRequest request;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Doctor login(Doctor usuario) {  
            Doctor logged=null;
            
            try {
                logged= Service.instance().getDoctor(usuario.getId());
                if(!logged.getPassword().equals(usuario.getPassword())) throw new Exception("Clave incorrecta");
                request.getSession(true).setAttribute("doctor", logged);
                return logged;
            } catch (Exception ex) {
                throw new NotFoundException();
            }  
    }
    
    @DELETE 
    public void logout() {  
        HttpSession session = request.getSession(true);
        session.removeAttribute("doctor");           
        session.invalidate();
    }
}
