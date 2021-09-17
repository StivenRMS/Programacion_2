/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newComisiones;

import java.util.*;
import modelos.ClsInfo;
import javax.swing.JOptionPane;
/**
 *
 * @author ramos
 */
public class NuevaClsComisiones {
    
    List<ClsInfo> Lisinfo = new ArrayList<ClsInfo>();
    double SMenero,SMfebrero,SMmarzo;
    Scanner t = new Scanner(System.in);
    
    
    
    //Este meteodo registra los datos
    public ClsInfo Ingreso_Informacion(){
       ClsInfo vende = new ClsInfo();
        System.out.println("¿Cuantos vendedores ingresara?");
        int cantiVende=t.nextInt();
        
        for (int i = 0; i < cantiVende; i++) {
        String nomb="";    
        
        System.out.println("Ingrese el Nombre");
        nomb=t.next();
        vende.setNombre(nomb);
        
        System.out.println("Ingrese el Enero");
        vende.setEnero(t.nextDouble());
        
        System.out.println("Ingrese el Febrero");
        vende.setFebrero(t.nextDouble());
        
        System.out.println("Ingrese el Marzo");
        vende.setMarzo(t.nextDouble());
        Lisinfo.add(vende);
        vende = new ClsInfo();
        JOptionPane.showMessageDialog(null, "Se Registro correctamente!");
        }     
        
        
        return vende;
               
        
    }
    
    
    private void desplegarDato(){//imprime en la pantalla
        System.out.println("Vendedor"+" Enero\t"+"Febrero\t"+"Marzo\t"+" Total\t"+" Promedio\t");
        for(ClsInfo ele: Lisinfo){
            System.out.println("---------------------------------------------------------------------------");
            
            
            System.out.println(ele.getNombre()+"  Q."+ele.getEnero()+" \tQ."+ele.getFebrero()+" \tQ."+ele.getMarzo()+"  \tQ."+
                   +ele.getVentasTotal()+"  \t%"+ele.getPromedio()+"  \t");
          
        }
        
    }
    
    public void resultados(){// calcula la suma y el promedio
       SMenero=0;
       SMfebrero=0;
       SMmarzo=0;
       
       for(ClsInfo colums: Lisinfo){
           SMenero+=colums.getEnero();
           SMfebrero+=colums.getFebrero();
           SMmarzo+=colums.getMarzo();
           colums.setVentasTotal(colums.getEnero()+ colums.getFebrero()+colums.getMarzo());
           colums.setPromedio(colums.getVentasTotal()/3);
           colums=new ClsInfo();
       }
         
    }
    
    public void menorxmes(){      //Devuelve el menor de la ventas por mes
     String VendedormE="",VendedormF="",VendedormM="";
         double NummEnero=Double.MAX_VALUE,NummFebrero=Double.MAX_VALUE,NumnNarzo=Double.MAX_VALUE;
         for (ClsInfo BusM : Lisinfo) {
             if (NummEnero >BusM.getEnero()) {
                 NummEnero=BusM.getEnero();
                 VendedormE=BusM.getNombre();
             }
             if (NummFebrero >BusM.getFebrero()) {
                 NummFebrero=BusM.getFebrero();
                 VendedormF=BusM.getNombre();
             }
             if (NumnNarzo >BusM.getMarzo()) {
                 NumnNarzo=BusM.getMarzo();
                 VendedormM=BusM.getNombre();
             }
         }
         System.out.println(VendedormE+", Es el peor vendedor de Enero, solo vendio: Q"+NummEnero);
         System.out.println(VendedormF+", Es el peor vendedor de Febrero, solo vendio: Q"+NummFebrero);
         System.out.println(VendedormM+", Es el peor vendedor de Marzo, solo vendio: Q"+NumnNarzo); 
        
        
        
    }
    
    public void Mayorxmes(){      //Devuelve las mayores de la ventas por mes
     String VendedormE="",VendedormF="",VendedormM="";
         double NummEnero=Double.MIN_VALUE,NummFebrero=Double.MIN_VALUE,NumnNarzo=Double.MIN_VALUE;
         for (ClsInfo BusM : Lisinfo) {
             if (NummEnero <BusM.getEnero()) {
                 NummEnero=BusM.getEnero();
                 VendedormE=BusM.getNombre();
             }
             if (NummFebrero <BusM.getFebrero()) {
                 NummFebrero=BusM.getFebrero();
                 VendedormF=BusM.getNombre();
             }
             if (NumnNarzo <BusM.getMarzo()) {
                 NumnNarzo=BusM.getMarzo();
                 VendedormM=BusM.getNombre();
             }
         }
         System.out.println(VendedormE+", Es el MEJOR vendedor de Enero, solo vendio: Q"+NummEnero);
         System.out.println(VendedormF+", Es el MEJOR vendedor de Febrero, solo vendio: Q"+NummFebrero);
         System.out.println(VendedormM+", Es el MEJOR vendedor de Marzo, solo vendio: Q"+NumnNarzo); 
        
        
        
    }
    public void BuscarN(){
        String Nombre="",Mes="";
        Double Nbuscado=0.0;
        System.out.println("\tBUSCADOR 2.0");
        System.out.println("Ingrese la cantidad que busca: ");
        Nbuscado=t.nextDouble();
        for (ClsInfo lisB : Lisinfo) {

            if(lisB.getEnero()==Nbuscado){
                Mes="Enero";
                Nombre=lisB.getNombre();
            }

            if(lisB.getFebrero()==Nbuscado){
                Mes="Febrero";
                Nombre=lisB.getNombre();
            }

            if(lisB.getMarzo()==Nbuscado){
                Mes="Marzo";
                Nombre=lisB.getNombre();
            }

        }
        System.out.println("\t*****Resultado*****");
        System.out.println("Fue la persona: "+Nombre+ " En el mes de: "+ Mes);
        
    }

    
    public void Menu(){
        Scanner t = new Scanner (System.in);
        String opc ="";
        System.out.println("\t*****BIENVENIDO*****");
        do{
            System.out.println("\t-----MENU-----");
            System.out.println("1-Ingrese de info");
            System.out.println("2-Ver informacion");
            System.out.println("3-Ver las menores Y mayores ventas en los meses");
            System.out.println("4-Buscador de numero");
            System.out.println("5-Salir");
            opc=t.nextLine();
            switch(opc){
                case "1": Ingreso_Informacion();
                break;
                case "2": resultados();desplegarDato();
                break;
                case "3": menorxmes();Mayorxmes();
                break;
                case "4": BuscarN();
            }
        }while(!opc.equals("5"));
        
        
    }


    
}
