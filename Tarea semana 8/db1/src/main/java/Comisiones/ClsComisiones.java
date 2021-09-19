/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comisiones;

import datos.ClsVendedorJDBC;
import dominio.ClsVendedor;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsComisiones {
    Scanner t=new Scanner(System.in);
    ClsVendedor CV =new ClsVendedor();
    ClsVendedorJDBC jDBC=new ClsVendedorJDBC();
    
    
    //METODO ENCARGADO DE INGRESAR LOS VENDEDORES LA BD;
    public void IngresarVendedor(){
       System.out.println("Cuantos vendedores quiere ingresar: ");
        int cant=t.nextInt();
        
        for(int i=0; i<cant;i++){
          String nomb="";
          Double EneroC=0.0,FebreroC=0.0,MarzoC=0.0,Pro=0.0;
          System.out.println("Ingrese el Nombre:");
          CV.setNombre(t.nextLine());
          CV.setNombre(t.nextLine());
          System.out.println("Ingrese  Enero:");
          EneroC=t.nextDouble();
          CV.setEnero(EneroC);
          System.out.println("Ingrese Febrero:");
          FebreroC=t.nextDouble();
          CV.setFebrero(FebreroC);
          System.out.println("Ingrese Marzo:");
          MarzoC=t.nextDouble();
          CV.setMarzo(MarzoC);
          CV.setTotalMeses(EneroC+FebreroC+MarzoC);
          Pro=(EneroC+FebreroC+MarzoC)/3;
          CV.setPromedio(Pro);
          jDBC.InsertarVendedor(CV);
        }
         JOptionPane.showMessageDialog(null, "Se Registro correctamente!");
    }
    //imprimir;
    public void ImprimirInfo(){
        List<ClsVendedor> Imprimir=jDBC.seleccion();
        for (ClsVendedor Xs : Imprimir) {
            System.out.println("Vendedor=" +Xs);
            
        }
    }
   
    public void VMayC(){
        jDBC.VentasMayores("enero");
        jDBC.VentasMayores("febrero");
        jDBC.VentasMayores("marzo");
        
    }   
   
    
    
    public void VentaTotalMayorCo(){
        jDBC.VentaTotalMayor("total");
        
    }
    public void VMenoresC(){
        jDBC.VentasMenores("enero");
        jDBC.VentasMenores("febrero");
        jDBC.VentasMenores("marzo");
        
    }
    //Elimina vendedor
    public void EliminarVendedor(){
        List<ClsVendedor> Imprimir=jDBC.seleccion();
        for (ClsVendedor Xs : Imprimir) {
            System.out.println("id: "+Xs.getId()+"Nombre de Empleado: "+Xs.getNombre()+"Promedio de las Ventas: "+Xs.getPromedio());
            
        }
        System.out.println("Cual es Codigo del Vendedor que desea Eliminar: ");
        int code=t.nextInt();
        jDBC.EliminarVendedor(code);
        System.out.println("REGISTRO ELIMINADO ");
    }
  
    
                
        
    
    public void buscador(){
        System.out.println("Cual es la cantidad a Buscar: ");
        Double busqueda=t.nextDouble();
       
        
    }
    
    
}
