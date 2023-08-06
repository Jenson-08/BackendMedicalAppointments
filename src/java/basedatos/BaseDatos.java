/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatos;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author jenso
 */
public class BaseDatos {
     private static BaseDatos theInstance;
    public static BaseDatos instance(){
        if (theInstance==null){ 
            theInstance=new BaseDatos();
        }
        return theInstance;
    }
    
        Connection cnx=null;
        
    public BaseDatos(){
        
        
        
        cnx=this.getConnection();            
    }
     public Connection getConnection(){
          
        try {
            
            String driver = "com.mysql.cj.jdbc.Driver";
            String server = "localhost";
            String port = "3306";
            String user = "root";
            String password = "root";
            String database = "proyecto2progra4";
            
            String URL_conexion="jdbc:mysql://"+ server+":"+port+"/"+
                    database+"?user="+user+"&password="+password+"&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";            
            Class.forName(driver);
            System.out.println("conexion exitosa");
            return DriverManager.getConnection(URL_conexion);
            
            
        }catch(Exception e){
              System.err.println(e.getMessage());
            System.exit(-1);
        }
        return  null;
     }
        
    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }
    public int executeUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public ResultSet executeQuery(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }    
}
