/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;
 
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.glassfish.jersey.media.multipart.FormDataParam;



import logic.Service;
import logic.CitaAtendida;
/**
 *
 * @author jenso
 */
@Path("/pdfcita")
public class PdfsCita {
    
    @GET 
    @Path("{titulo}/pdf")
    @Produces("application/pdf")
       
    public Response getPdf(@PathParam("titulo") String titulo) throws IOException {
        CitaAtendida per=null;
        try { per = Service.instance().CitaAtendidaporTitulo(titulo);} catch (Exception ex) {}
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfDocument pdf = new PdfDocument(new PdfWriter(out));
        Document doc = new Document(pdf, PageSize.A4.rotate());
        
        Paragraph p;
        
        p = new Paragraph("DATOS DE CITA");
        p.setTextAlignment(TextAlignment.CENTER);
        p.setBold();
        p.setBackgroundColor(Color.PINK);
        doc.add(p);

        p = new Paragraph("TITULO: "+ per.getTitulo());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);

        p = new Paragraph("NOMBRE PACIENTE: "+per.getNomPaciente());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);
        
        p = new Paragraph("ID MEDICO: "+per.getIdMedico());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);
        
        p = new Paragraph("SIGNOS: "+per.getSignos());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);
        
        p = new Paragraph("DIAGNOSTICOS: "+per.getDiagnosticos());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);
           
        p = new Paragraph("PRESCRIPCIONES: "+per.getPrescripciones());
        p.setTextAlignment(TextAlignment.LEFT);
        p.setBold();
        doc.add(p);
        
        

        p = new Paragraph("FIN");
        p.setTextAlignment(TextAlignment.CENTER);
        p.setBold();
        p.setBackgroundColor(Color.PINK);
        doc.add(p);

        doc.close(); 
        
        return Response.ok(out.toByteArray()).build();
    }           
    
    
    
    
    
    
    
    
}
