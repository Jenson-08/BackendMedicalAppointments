/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatos;

import logic.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jenso
 */
public class DaoCitas {
    BaseDatos db;

    public DaoCitas() {
        db = BaseDatos.instance();
    }

    public void create(Cita p) throws Exception {
        String sql = "insert into cita (fecha,titulocita,nomPaciente,horacita,id_medico)"
                + "values(?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getFecha());
        stm.setString(2, p.getTitulocita());
        stm.setString(3, p.getNomPaciente());
        stm.setString(4, p.getHoracita());
        stm.setString(5, p.getId_medico());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona ya existe");
        }
    }

    public Cita read(String id) throws Exception {
        String sql = "select * from cita p where titulocita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Cita p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }

    public void update(Cita p) throws Exception {
        String sql = "update cita set horacita=?"
                + "where titulocita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getHoracita());
        stm.setString(2, p.getTitulocita());
        
    
     
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
    public void delete(Cita p) throws Exception {
        String sql = "delete from cita where titulocita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getTitulocita());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
     public List<Cita> findAll() {
        List<Cita> resultado = new ArrayList<>();
        try {
            String sql = "select * from cita p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Cita p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    public List<Cita> findCitasporIdMedico(String id) {
        List<Cita> resultado = new ArrayList<>();
        try {
            String sql = "select * from cita p where id_medico=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            Cita p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Cita from(ResultSet rs, String alias) {
        try {
            Cita p = new Cita();
            p.setFecha(rs.getString(alias+".fecha"));
            p.setTitulocita(rs.getString(alias + ".titulocita"));
            p.setNomPaciente(rs.getString(alias + ".nomPaciente"));
            p.setHoracita(rs.getString(alias + ".horacita"));
            p.setId_medico(rs.getString(alias + ".id_medico"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
}
