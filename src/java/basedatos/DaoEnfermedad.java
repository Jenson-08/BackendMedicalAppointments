/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Enfermedad;
/**
 *
 * @author jenso
 */
public class DaoEnfermedad {
    BaseDatos db;

    public DaoEnfermedad() {
        db = BaseDatos.instance();
    }

    public void create(Enfermedad p) throws Exception {
        String sql = "insert into enfermedad (id_persona,nombre)"
                + "values(?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        
        stm.setString(1, p.getId_persona());
        stm.setString(2, p.getNombre());

        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Ya existe");
        }
    }

    public Enfermedad read(String id) throws Exception {
        String sql = "select * from enfermedad p where id_persona=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Enfermedad p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }

    public void update(Enfermedad p) throws Exception {
        String sql = "update enfermedad set id_persona=?, nombre=?"
                + "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getId_persona());
        stm.setString(2, p.getNombre());
      
    
     
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
    public void delete(Enfermedad p) throws Exception {
        String sql = "delete from enfermedad where id_persona=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getId_persona());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
     public List<Enfermedad> findAll() {
        List<Enfermedad> resultado = new ArrayList<>();
        try {
            String sql = "select * from enfermedad p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Enfermedad p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
     public List<Enfermedad> findAllbyId(String id) {
        List<Enfermedad> resultado = new ArrayList<>();
        try {
            String sql = "select * from enfermedad p where id_persona=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            Enfermedad p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    
    
    
    
    
    
    
    
    
    public Enfermedad from(ResultSet rs, String alias) {
        try {
            Enfermedad p = new Enfermedad();

            p.setId_persona(rs.getString(alias + ".id_persona"));
            p.setNombre(rs.getString(alias + ".nombre"));
            

            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
}
