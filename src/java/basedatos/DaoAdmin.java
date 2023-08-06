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
import logic.Admin;

/**
 *
 * @author jenso
 */
public class DaoAdmin {
    BaseDatos db;

    public DaoAdmin() {
        db = BaseDatos.instance();
    }

    public void create(Admin p) throws Exception {
        String sql = "insert into admin (id,password)"
                + "values(?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getId());
        stm.setString(2, p.getPassword());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona ya existe");
        }
    }

    public Admin read(String id) throws Exception {
        String sql = "select * from admin p where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Admin p = from(rs, "p");
            return p;
        } else {
            throw new Exception("Doctor no Existe");
        }
    }

    
     public List<Admin> findAll() {
        List<Admin> resultado = new ArrayList<>();
        try {
            String sql = "select * from admin p";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Admin p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    
    public Admin from(ResultSet rs, String alias) {
        try {
            Admin p = new Admin();
            p.setId(rs.getString(alias+".id"));
            p.setPassword(rs.getString(alias + ".password"));
        
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
}
