
package datos;

import dominio.ClsVendedor;
import java.sql.*;
import java.util.*;



/**
 *
 * @author ramos
 */
public class ClsVendedorJDBC {//comandos SQL
    private static final String SQL_SELECT="select* from bdproyect.tb_vendedores";
    private static final String SQL_UPDATE="update bdproyect.tb_vendedores set nombre=?,enero=?,febrero=?,marzo=?,total=?,promedio=? where codigo=?";
    private static final String SQL_INSERT="insert into bdproyect.tb_vendedores (nombre,enero,febrero,marzo,total,promedio) values(?,?,?)";
    private static final String SQL_DELETE="delete from bdproyect.tb_vendedores where codigo=?";

    

    
    public  List<ClsVendedor>seleccion(){
        
     Connection  conn=null;
     PreparedStatement stmt=null;
     ResultSet rs=null;
     ClsVendedor vendedor=null;
     List<ClsVendedor> vendedores = new ArrayList<ClsVendedor>();
    
     
     
     
        try {
            conn= Clsconexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            
            while(rs.next()){
          int   id=rs.getInt("id");
                String nombre=rs.getString("nombre");
                Double enero=rs.getDouble("enero");
                Double febrero= rs.getDouble("febrero");
                Double marzo= rs.getDouble("marzo");
                Double total=rs.getDouble("total");
                Double promedio= rs.getDouble("promedio");
                vendedor=new ClsVendedor();
                vendedor.setId(id);
                vendedor.setNombre(nombre);
                vendedor.setEnero(enero);
                vendedor.setFebrero(febrero);
                vendedor.setMarzo(marzo);
                vendedor.setTotalMeses(total);
                vendedor.setPromedio(promedio);
                    vendedores.add(vendedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
                Clsconexion.closeR(rs);
                Clsconexion.closeP(stmt);
                Clsconexion.closeC(conn);
                
        return vendedores;                   
   

        
        }
    
    
        }
    
    
    
    //INSERTAR UN NUEVO VENDEDOR EN LA BD;
    public int InsertarVendedor(ClsVendedor vendedor){
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, vendedor.getNombre());
            statement.setDouble(2, vendedor.getEnero());
            statement.setDouble(3, vendedor.getFebrero());
            statement.setDouble(4, vendedor.getMarzo());
            statement.setDouble(5, vendedor.getTotalMeses());
            statement.setDouble(6, vendedor.getPromedio());
            rows=statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Clsconexion.closeC(conexion);
            Clsconexion.closeP(statement);
        }
        return rows;
    }
    
   //METODO PARA SELECCIONAR MAYORXMES EN LA BD;
    public int VentasMayores(String Mes){
        String Nombre="";
        Double Cantidad=0.0;
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement("select nombre,"+Mes +" from tb_vendedores where "+ Mes+"=(select max("+Mes+") from tb_vendedores);");
            resultSet=statement.executeQuery();
            System.out.println("********** Mayores Ventas  "+Mes+"**********");
            while(resultSet.next()){
                Nombre=resultSet.getString("nombre");
                Cantidad=resultSet.getDouble(Mes);
                
                System.out.println("El Nombre es: "+Nombre+" y la cantidad es =Q"+Cantidad);
            }    
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Clsconexion.closeC(conexion);
            Clsconexion.closeR(resultSet);
            Clsconexion.closeP(statement);
        }
        return rows;
    }
    //METODO PARA SELECCIONAR MENORXMES EN LA BD;   
    public int VentasMenores(String Mes){
        String Nombre="";
        Double Cantidad=0.0;
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement("select nombre,"+Mes +" from tb_vendedores where "+ Mes+"=(select min("+Mes+") from tb_vendedores);");
            resultSet=statement.executeQuery();
            System.out.println("********** Menores Ventas  "+Mes+"**********");
            while(resultSet.next()){
                Nombre=resultSet.getString("nombre");
                Cantidad=resultSet.getDouble(Mes);   
                System.out.println("El Nombre es: "+Nombre+" y la cantidad es =Q"+Cantidad);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Clsconexion.closeC(conexion);
            Clsconexion.closeR(resultSet);
            Clsconexion.closeP(statement);
        }
        return rows;
    }
    //METODO PARA SELECCIONAR VENTA MAYOR EN LA BD;
    public int VentaTotalMayor(String Total){
        String Nombre="";
        Double Cantidad=0.0;
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement("select nombre,"+Total +" from tb_vendedores where "+ Total+"=(select max("+Total+") from tb_vendedores);");
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                Nombre=resultSet.getString("nombre");
                Cantidad=resultSet.getDouble(Total);   
            }
            
            System.out.println("La persona que mas vende es: "+Nombre+" con la cantidad de:Q"+Cantidad);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Clsconexion.closeC(conexion);
            Clsconexion.closeR(resultSet);
            Clsconexion.closeP(statement);
        }
        return rows;
    }  
   
   //METODO PARA ELMINAR UN VENDEDOR EN LA BD;
    public int EliminarVendedor(int codigo){
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement(SQL_DELETE+codigo);
            rows=statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
           Clsconexion.closeC(conexion);
            Clsconexion.closeP(statement);
        }
        return rows;
        
    }
    //METODO MODIFICAR NOMBRE EN EL BD;
    public int ModificarNombreVendedor(String Columna,String Parametro,String codigo){
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement("update tb_vendedores set "+Columna+"="+Parametro+" where codigo="+codigo+";");
            rows=statement.executeUpdate();
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Clsconexion.closeC(conexion);
            Clsconexion.closeP(statement);
        }
        return rows;
        
    }
    //cambia ventas en la base;
    public int ModificarCantidadVendedor(String Columna,String codigo, Double CantNueva, Double Total, Double Promedio){
        int rows=0;
        Connection conexion=null;
        PreparedStatement statement=null;           
        try {
            conexion=Clsconexion.getConnection();
            statement=conexion.prepareStatement("update tb_vendedores set "+Columna+"="+CantNueva+" ,total="+Total+" ,promedio="+Promedio+" where codigo="+codigo);
            rows=statement.executeUpdate();
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Clsconexion.closeC(conexion);
            Clsconexion.closeP(statement);
        }
        return rows;
        
    } 
    
}