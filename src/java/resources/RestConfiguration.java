/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
/**
 *
 * @author jenso
 */
@ApplicationPath("api")
@DeclareRoles({ "doctor" })
public class RestConfiguration extends Application{
@Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(MultiPartFeature.class);
        classes.add(Doctores.class);
        classes.add(Personas.class);
        classes.add(Login.class);  
        classes.add(PacientesPorMedico.class);
        classes.add(Citas.class);
        classes.add(CitaPorMedico.class);
        classes.add(CitasAtendidas.class);
        classes.add(Admins.class);
        classes.add(EstadoDoctor.class);
        classes.add(DoctoresInactivos.class);
        classes.add(CitasPorPaciente.class);
        classes.add(Antecedentes.class);
        classes.add(PdfsCita.class);
        classes.add(AntecedentesPorMedico.class);
        return classes;
    }   
}
