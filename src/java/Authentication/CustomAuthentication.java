/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Authentication;
import logic.Usuario;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Doctor;
/**
 *
 * @author jenso
 */
@ApplicationScoped
public class CustomAuthentication implements HttpAuthenticationMechanism {

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request,HttpServletResponse response,HttpMessageContext httpMsgContext) 
       {
           Doctor user=(Doctor) request.getSession().getAttribute("doctor");
           if(user!=null)
              return httpMsgContext.notifyContainerAboutLogin(
                new Principal() { @Override public String getName() { return user.getName();}},
                new HashSet<>(Arrays.asList(new String[]{user.getRol()})));
           else
              return httpMsgContext.notifyContainerAboutLogin(
                new Principal() { @Override public String getName() { return "none";}},
                new HashSet<>());               
    }
}


