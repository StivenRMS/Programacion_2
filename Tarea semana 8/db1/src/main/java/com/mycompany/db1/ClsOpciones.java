/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db1;

import Comisiones.ClsComisiones;
import java.util.Scanner;

/**
 *
 * @author ramos
 */
public class ClsOpciones {
     Scanner t=new Scanner(System.in);
    ClsComisiones Comision=new ClsComisiones();
    
    
    public void  menu(){
        
        String opcion="";
        int opcion2=0;
        
        do{
             System.out.println("\n*****MENU PRINCIPAL*****\n"
                     + "1 - Ingresar Vendedor\n"
                     + "2 - Ver Ventas Mayores y Menores por cada mes\n"
                     + "3 - Consulta la Venta Mayor\n"
                     + "4 - Elimina Informacion\n"
                     + "5 - Busca Informacion\n"
                     + "6 - Consultar Toda Informacion\n"
                     + "7 - Salir ");
             opcion=t.nextLine();
             
             
             switch(opcion){
                 case "1":  
                      Comision.IngresarVendedor();
                     break;
                 case "2": 
                     System.out.println("\nventas menores por mes:");
                     Comision.VMayC();
                     System.out.println("\nventas menores por mes:");
                     Comision.VMenoresC();
                     break;
                 case "3":
                     System.out.println("\nTotal mayor:");
                     Comision.VentaTotalMayorCo();
                     break;
                 
                    
                 case "4": 
                     Comision.EliminarVendedor();
                     break;
                 case "5": 
                     Comision.buscador();
                     break;
                 case "6":  
                     Comision.ImprimirInfo();
                     break;
                
             }
            
        }while(!opcion.equals("7"));
        
        
        
    }
    
    
    
    
    
}
