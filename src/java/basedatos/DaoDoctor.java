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
import logic.Doctor;
/**
 *
 * @author jenso
 */
public class DaoDoctor {
    BaseDatos db;
    public DaoDoctor() {
        db = BaseDatos.instance();
    }
    
    public void create(Doctor d) throws Exception {
        String sql = "insert into doctor (id,password,name,speciality,fee,location,estado,frecuencia,dia1,hEntrada1,hSalida1,dia2,hEntrada2,hSalida2,dia3,hEntrada3,hSalida3,dia4,hEntrada4,hSalida4,dia5,hEntrada5,hSalida5,dia6,hEntrada6,hSalida6,dia7,hEntrada7,hSalida7,rol) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, d.getId());
        stm.setString(2, d.getPassword());
        stm.setString(3, d.getName());
        stm.setString(4, d.getSpeciality());
        stm.setString(5, d.getFee());
        stm.setString(6, d.getLocation());
        stm.setString(7, d.getEstado());
        stm.setInt(8, d.getFrecuencia());
        stm.setBoolean(9, d.getDia1());
        stm.setString(10, d.gethEntrada1());
        stm.setString(11, d.gethSalida1());
        stm.setBoolean(12, d.getDia2());
        stm.setString(13, d.gethEntrada2());
        stm.setString(14, d.gethSalida2());
        stm.setBoolean(15, d.getDia3());
        stm.setString(16, d.gethEntrada3());
        stm.setString(17, d.gethSalida3());
        stm.setBoolean(18, d.getDia4());
        stm.setString(19, d.gethEntrada4());
        stm.setString(20, d.gethSalida4());
        stm.setBoolean(21, d.getDia5());
        stm.setString(22, d.gethEntrada5());
        stm.setString(23, d.gethSalida5());
        stm.setBoolean(24, d.getDia6());
        stm.setString(25, d.gethEntrada6());
        stm.setString(26, d.gethSalida6());
        stm.setBoolean(27, d.getDia7());
        stm.setString(28, d.gethEntrada7());
        stm.setString(29, d.gethSalida7());
        stm.setString(30, d.getRol());
        
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Doctor ya existe");
        }
    }

    public Doctor read(String id) throws Exception {
        String sql = "select * from doctor d where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Doctor d = from(rs, "d");
            return d;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }
    
 
    public void update(Doctor p) throws Exception {
        String sql = "update doctor set name=?, speciality=?, fee=?, location=?"
                + "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getName());
        stm.setString(2, p.getSpeciality());
        stm.setString(3, p.getFee());
        stm.setString(4, p.getLocation());
        stm.setString(5, p.getId());
     
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Doctor no existe");
        }
    }
      public void updateCondicion(Doctor p) throws Exception {
        String sql = "update doctor set estado=? "
                + "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, "activo");
        stm.setString(2, p.getId());
       
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Doctor no existe");
        }
    }
    
    
    

    public void delete(Doctor p) throws Exception {
        String sql = "delete from doctor where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Paciente no existe");
        }
    }

    public List<Doctor> findAll() {
        List<Doctor> resultado = new ArrayList<>();
        try {
            String sql = "select * from doctor p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Doctor p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    public List<Doctor> findInactive(String inactivo) {
        List<Doctor> resultado = new ArrayList<>();
        try {
            String sql = "select * from doctor p where estado=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, inactivo);
            ResultSet rs = db.executeQuery(stm);
            Doctor p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
     public List<Doctor> findActive(String activo) {
        List<Doctor> resultado = new ArrayList<>();
        try {
            String sql = "select * from doctor p where estado=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, activo);
            ResultSet rs = db.executeQuery(stm);
            Doctor p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }



    public Doctor findByID(String id)throws Exception {

        String sql = "select * from doctor p where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
       
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Doctor p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }

    }

    public Doctor from(ResultSet rs, String alias) {
        try {
             Doctor p = new Doctor();
            
            p.setId(rs.getString(alias + ".id"));
            p.setPassword(rs.getString(alias + ".password"));
            p.setName(rs.getString(alias + ".name"));
            p.setSpeciality(rs.getString(alias + ".speciality"));
            p.setFee(rs.getString(alias + ".fee"));
            p.setLocation(rs.getString(alias + ".location"));
            p.setEstado(rs.getString(alias + ".estado"));
            p.setFrecuencia(rs.getInt(alias + ".frecuencia"));
            p.setDia1(rs.getBoolean(alias+".dia1"));
            p.sethEntrada1(rs.getString(alias + ".hEntrada1"));
            p.sethSalida1(rs.getString(alias + ".hSalida1"));
            
            
            p.setDia2(rs.getBoolean(alias+".dia2"));
            p.sethEntrada2(rs.getString(alias + ".hEntrada2"));
            p.sethSalida2(rs.getString(alias + ".hSalida2"));
            
            
            p.setDia3(rs.getBoolean(alias+".dia3"));
            p.sethEntrada3(rs.getString(alias + ".hEntrada3"));
            p.sethSalida3(rs.getString(alias + ".hSalida3"));
            
            
            p.setDia4(rs.getBoolean(alias+".dia4"));
            p.sethEntrada4(rs.getString(alias + ".hEntrada4"));
            p.sethSalida4(rs.getString(alias + ".hSalida4"));
            
           
            p.setDia5(rs.getBoolean(alias+".dia5"));
            p.sethEntrada5(rs.getString(alias + ".hEntrada5"));
            p.sethSalida5(rs.getString(alias + ".hSalida5"));
            
            
            p.setDia6(rs.getBoolean(alias+".dia6"));
            p.sethEntrada6(rs.getString(alias + ".hEntrada6"));
            p.sethSalida6(rs.getString(alias + ".hSalida6"));
            
            
            p.setDia7(rs.getBoolean(alias+".dia7"));
            p.sethEntrada7(rs.getString(alias + ".hEntrada7"));
            p.sethSalida7(rs.getString(alias + ".hSalida7"));
            p.setRol(rs.getString(alias+".rol") );
            
           
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
   
}
