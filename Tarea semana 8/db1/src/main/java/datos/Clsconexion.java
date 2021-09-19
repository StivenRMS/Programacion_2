/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;




/**
 *
 * @author ramos
 */
public class Clsconexion {
    
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/bdproyect?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER="root";
    private static final String JDBC_PWD="loso";
    
    //crear metodo conexion
    public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PWD);
        
    }
    
    //cerrar conexion
    public static void closeR(ResultSet rs){
        
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
    public static void closeP(PreparedStatement stmt){
        
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
    
    public static void closeC(Connection cn){
        
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }

}
