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
import logic.Usuario;

/**
 *
 * @author jenso
 */
public class DaoUsuario {
    BaseDatos db;

    public DaoUsuario() {
        db = BaseDatos.instance();
    }

    public void create(Usuario u) throws Exception {
        String sql = "insert into usuario (id,clave,nombre,rol)"
                + "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getId());
        stm.setString(2, u.getClave());
        stm.setString(3, u.getNombre());
        stm.setString(4, u.getRol());
        

        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Persona ya existe");
        }
    }

    public Usuario read(String id) throws Exception {
        String sql = "select * from usuario p where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);

        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Usuario u = from(rs, "u");
            return u;
        } else {
            throw new Exception("Usuario no Existe");
        }
    }

    public void update(Usuario u) throws Exception {
        String sql = "update usuario set clave=?, nombre=?, rol=?"
                + "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getClave());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getRol());
        stm.setString(4, u.getId());
    
     
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario no existe");
        }
    }
    public void delete(Usuario u) throws Exception {
        String sql = "delete from usuario where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getId());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Usuario no existe");
        }
    }
     public List<Usuario> findAll() {
        List<Usuario> resultado = new ArrayList<>();
        try {
            String sql = "select * from usuario u";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Usuario p;
            while (rs.next()) {
                p = from(rs, "p");
                resultado.add(p);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
     
    public Usuario from(ResultSet rs, String alias) {
        try {
            Usuario u = new Usuario();

            u.setId(rs.getString(alias + ".id"));
            u.setClave(rs.getString(alias + ".clave"));
            u.setNombre(rs.getString(alias + ".nombre"));
            u.setRol(rs.getString(alias + ".rol"));

            return u;
        } catch (SQLException ex) {
            return null;
        }
    }
}
