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
import logic.Antecedente;

/**
 *
 * @author jenso
 */
public class DaoAntecedente {

     BaseDatos db;

    public DaoAntecedente() {
        db = BaseDatos.instance();
    }

    public void create(Antecedente p) throws Exception {
        String sql = "insert into antecedente (idPaciente,alergia,enfermedad,cirugia,vacuna,tiposangre,idMedico)"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getIdPaciente());
        stm.setString(2, p.getAlergia());
        stm.setString(3, p.getEnfermedad());
        stm.setString(4, p.getCirugia());
        stm.setString(5, p.getVacuna());
        stm.setString(6, p.getTiposangre());
        stm.setString(7, p.getIdMedico());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona ya existe");
        }
    }

    public Antecedente read(String id) throws Exception {
        String sql = "select * from antecedente p where idPaciente=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Antecedente p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }

    public void update(Antecedente p) throws Exception {
        String sql = "update antecedente set alergia=?, enfermedad=?,cirugia=?,vacuna=?"
                + "where idPaciente=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getAlergia());
        stm.setString(2, p.getEnfermedad());
        stm.setString(3, p.getCirugia());
        stm.setString(4, p.getVacuna());
        stm.setString(5, p.getIdPaciente());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
    public void delete(Antecedente p) throws Exception {
        String sql = "delete from antecedente where idPaciente=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getIdPaciente());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona no existe");
        }
    }
     public List<Antecedente> findAll() {
        List<Antecedente> resultado = new ArrayList<>();
        try {
            String sql = "select * from antecedente p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Antecedente p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    
    public List<Antecedente> findAntecedenteporIdPaciente(String id) {
        List<Antecedente> resultado = new ArrayList<>();
        try {
            String sql = "select * from antecedente p where idPaciente=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            Antecedente p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
     public List<Antecedente> findAntecedenteporIdMedico(String id) {
        List<Antecedente> resultado = new ArrayList<>();
        try {
            String sql = "select * from antecedente p where idMedico=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = db.executeQuery(stm);
            Antecedente p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    
    
    
    public Antecedente from(ResultSet rs, String alias) {
        try {
            Antecedente p = new Antecedente();

            p.setIdPaciente(rs.getString(alias + ".idPaciente"));
            p.setAlergia(rs.getString(alias + ".alergia"));
            p.setEnfermedad(rs.getString(alias + ".enfermedad"));
            p.setCirugia(rs.getString(alias + ".cirugia"));
            p.setVacuna(rs.getString(alias + ".vacuna"));
            p.setTiposangre(rs.getString(alias + ".tiposangre"));
            p.setIdMedico(rs.getString(alias + ".idMedico"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }

}

