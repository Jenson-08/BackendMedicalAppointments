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
import logic.Persona;

/**
 *
 * @author jenso
 */
public class DaoPersona {

    BaseDatos db;

    public DaoPersona() {
        db = BaseDatos.instance();
    }

    public void create(Persona p) throws Exception {
        String sql = "insert into persona (cedula,nombre,sexo,id_medico)"
                + "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getCedula());
        stm.setString(2, p.getNombre());
        stm.setString(3, p.getSexo());
        stm.setString(4, p.getId_medico());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona ya existe");
        }
    }

    public Persona read(String id) throws Exception {
        String sql = "select * from persona p where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Persona p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }

    public void update(Persona p) throws Exception {
        String sql = "update persona set nombre=?, sexo=?"
                + "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getNombre());
        stm.setString(2, p.getSexo());
        stm.setString(3, p.getCedula());
    
     
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
    public void delete(Persona p) throws Exception {
        String sql = "delete from persona where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
     public List<Persona> findAll() {
        List<Persona> resultado = new ArrayList<>();
        try {
            String sql = "select * from persona p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Persona p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    public List<Persona> findPersonasporIdMedico(String id) {
        List<Persona> resultado = new ArrayList<>();
        try {
            String sql = "select * from persona p where id_medico=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            Persona p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Persona from(ResultSet rs, String alias) {
        try {
            Persona p = new Persona();

            p.setCedula(rs.getString(alias + ".cedula"));
            p.setNombre(rs.getString(alias + ".nombre"));
            p.setSexo(rs.getString(alias + ".sexo"));
            p.setId_medico(rs.getString(alias + ".id_medico"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }

}
