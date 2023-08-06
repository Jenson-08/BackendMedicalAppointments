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
import logic.CitaAtendida;
/**
 *
 * @author jenso
 */
public class DaoCitaAtendida {
     BaseDatos db;

    public DaoCitaAtendida() {
        db = BaseDatos.instance();
    }

    public void create(CitaAtendida p) throws Exception {
        String sql = "insert into citaatendida (titulo,nomPaciente,idMedico,signos,diagnosticos,prescripciones)"
                + "values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getTitulo());
        stm.setString(2, p.getNomPaciente());
        stm.setString(3, p.getIdMedico());
        stm.setString(4, p.getSignos());
        stm.setString(5, p.getDiagnosticos());
        stm.setString(6, p.getPrescripciones());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona ya existe");
        }
    }

    public CitaAtendida read(String id) throws Exception {
        String sql = "select * from citaatendida p where titulo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            CitaAtendida p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }

    public void update(CitaAtendida p) throws Exception {
        String sql = "update citaatendida set signos=?, diagnosticos=?,prescripciones=?"
                + "where titulo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getSignos());
        stm.setString(2, p.getDiagnosticos());
        stm.setString(3, p.getPrescripciones());
        stm.setString(4, p.getTitulo());
     
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
    public void delete(CitaAtendida p) throws Exception {
        String sql = "delete from citaatendida where titulo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getTitulo());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
     public List<CitaAtendida> findAll() {
        List<CitaAtendida> resultado = new ArrayList<>();
        try {
            String sql = "select * from citaatendida p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            CitaAtendida p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    public List<CitaAtendida> findCitasAtendidasporIdMedico(String id) {
        List<CitaAtendida> resultado = new ArrayList<>();
        try {
            String sql = "select * from citaatendida p where idMedico=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            CitaAtendida p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public List<CitaAtendida> findCitasAtendidasporNombrePaciente(String id) {
        List<CitaAtendida> resultado = new ArrayList<>();
        try {
            String sql = "select * from citaatendida p where nomPaciente=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            CitaAtendida p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
     public CitaAtendida citaAtendidaPorTitulo(String id) throws Exception {
        String sql = "select * from citaatendida p where titulo=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            CitaAtendida p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }
    
    
    
    public CitaAtendida from(ResultSet rs, String alias) {
        try {
            CitaAtendida p = new CitaAtendida();

            p.setTitulo(rs.getString(alias + ".titulo"));
            p.setNomPaciente(rs.getString(alias + ".nomPaciente"));
            p.setIdMedico(rs.getString(alias + ".idMedico"));
            p.setSignos(rs.getString(alias + ".signos"));
            p.setDiagnosticos(rs.getString(alias + ".diagnosticos"));
            p.setPrescripciones(rs.getString(alias + ".prescripciones"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }

}
