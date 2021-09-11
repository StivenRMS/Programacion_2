
package parte2;

import java.util.Scanner;
import javax.management.monitor.StringMonitor;

/**
 *
 * @author ramos
 */
public class ClsComisiones {
    private static int [][] Sumasfilas= new  int[4][6];
    private static final int NOMBRE =0;
    private static final int ENERO =0;
    private static final int FEBRERO =1;
    private static final int MARZO =2;
    private static final int Total =3;
    private static final int Promedio =4;
    private static String [][] encabezados= new String[0][0];
    private static String [][] comisiones = new String[4][6];
    private static int [][]cantidades=new int[4][6];
    
    
    public static void cargadeinformacion(int fila){
        
        Scanner t =new Scanner(System.in);
        System.out.println("Nombre Vendedor "+fila);
        comisiones[fila][NOMBRE]=t.nextLine();
        System.out.println("Ingrese Enero");
        cantidades[fila][ENERO]=t.nextInt();
        System.out.println("Ingrese Febrero");
        cantidades[fila][FEBRERO]=t.nextInt();
        System.out.println("Ingrese Marzo");
        cantidades[fila][MARZO]=t.nextInt();
     
 
        
       
           cantidades[3][0]= cantidades[0][ENERO] + cantidades[1][ENERO]+
            cantidades[2][ENERO];
            cantidades[3][1]= cantidades[0][FEBRERO] + cantidades[1][FEBRERO]+
            cantidades[2][FEBRERO];
             cantidades[3][2]= cantidades[0][MARZO] + cantidades[1][MARZO]+
            cantidades[2][MARZO];
              cantidades[3][3]= cantidades[0][Total] + cantidades[1][Total]+
            cantidades[2][Total];
            cantidades[3][4]=0;
        
        
        
        
        
        
    }
    
    public static void imprimirDecorado(String[][] ma){
       
       for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print(ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
   }
    
   public static void SumaColumnas(int [][]ma){
    
    for (int x = 0; x < ma[0].length; x++) {
        int suma = 0;
        for (int y = 0; y < ma.length; y++) {
            suma += ma[y][x];
        }
        System.out.printf("%d ", suma);
    }
    System.out.println();
}  
 
   
    
    public static void imprimirDCantidades(int [][] ma){
       
       for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print( ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
   }
    private static void registro(){
       for (int i = 0; i < comisiones.length-1; i++) { //Que nos pida registro menos una que llenaremos con la suma
            cargadeinformacion(i);
           
        }
        
       
    }
    
     
    
    public static void operaciones(){
            
       for (int i = 0; i <=3; i++) { //Filas
       String Nom="";
       comisiones[3][NOMBRE]="TOTAL";
       
        if (i == 4 ) {
            
           
            Nom= comisiones[3][NOMBRE];
        } else {
           
           
            Nom = comisiones[i][NOMBRE];
           
        }
      
       int sumaFilas = 0;
       var PromedioF =0;
        for (int j = 0; j <=4; j++) { //Columnas

            
            
           
            
            if (j==3){
                PromedioF=( sumaFilas/3);// Que solo saque el promedio cuando se alla acando de sumar
                
            }else{
                 sumaFilas += cantidades[i][j];
            }
            cantidades[i][Total] = sumaFilas;
            cantidades[i][Promedio]=PromedioF;
            
            

        } 
         
    }  
                      
      
    }
  
    
   public static void Mayorymenor(){
      
        int i, j, mayor, menor;
        int filaMayor, filaMenor, colMayor, colMenor;
        
        //Calcular el mayor valor de la matriz y el menor.
        //Obtener las posiciones que ocupan el mayor y el menor dentro de la matriz 
        mayor = menor = cantidades[0][0]; //se toma el primer elemento de la matriz como mayor y menor
        filaMayor = filaMenor = colMayor = colMenor = 0;

        //mediante dos bucles for anidados recorremos la matriz
        //buscamos el mayor, el menor y sus posiciones
        for (i = 0; i < cantidades.length-2; i++) {  //para cada fila de la matriz
            for (j = 0; j < cantidades[i].length-1; j++) { //para cada columna de la matriz
                if (cantidades[i][j] > mayor) {
                    mayor = cantidades[i][j];
                    filaMayor = i;
                    colMayor = j;
                } else if (cantidades[i][j] < menor) {
                    menor = cantidades[i][j];
                    filaMenor = i;
                    colMenor = j;
                }
            }           
        }

        //Mostrar por pantalla el mayor elemento de la matriz,el menor y las posiciones que ocupan           
        System.out.print("Elemento mayor: " + mayor);
        System.out.println(" Fila: "+ filaMayor + " Columna: " + colMayor);
        System.out.print("Elemento menor: " + menor);
        System.out.println(" Fila: "+ filaMenor + " Columna: " + colMenor);
    }
           
            
    public static void implntarM(){
        
        operaciones();
         //Cargamos los datos de la matriz de numeros en la matriz de String
        //vendedor 1
        comisiones[0][1]=Integer.toString(cantidades[0][0]);
        comisiones[0][2]=Integer.toString(cantidades[0][1]);
        comisiones[0][3]=Integer.toString(cantidades[0][2]);
        comisiones[0][4]=Integer.toString(cantidades[0][3]);
        comisiones[0][5]=Integer.toString(cantidades[0][4]);
        
        //vendedor 2
        comisiones[1][1]=Integer.toString(cantidades[1][0]);
        comisiones[1][2]=Integer.toString(cantidades[1][1]);
        comisiones[1][3]=Integer.toString(cantidades[1][2]);
        comisiones[1][4]=Integer.toString(cantidades[1][3]);
        comisiones[1][5]=Integer.toString(cantidades[1][4]);
        //vendedor 3
        comisiones[2][1]=Integer.toString(cantidades[2][0]);
        comisiones[2][2]=Integer.toString(cantidades[2][1]);
        comisiones[2][3]=Integer.toString(cantidades[2][2]);
        comisiones[2][4]=Integer.toString(cantidades[2][3]);
        comisiones[2][5]=Integer.toString(cantidades[2][4]);
       
        //total
        comisiones[3][1]=Integer.toString(cantidades[3][0]);
        comisiones[3][2]=Integer.toString(cantidades[3][1]);
        comisiones[3][3]=Integer.toString(cantidades[3][2]);
        comisiones[3][4]=Integer.toString(cantidades[3][3]);
        comisiones[3][5]=Integer.toString(cantidades[3][4]);  
        
    }
   
    
    public static void main(String[] args) {
        
            
        int menu=0;
        int salir=0;
        do {
            
        
        
        Scanner t =new Scanner(System.in);
        System.out.println("\t------MENU--------");
        System.out.println("Eliga una de las siguientes opciones: ");
        System.out.println("Ingresar datos___________1 ");
        System.out.println("Consultas________________2 ");
        System.out.println("Editar datos_____________3 ");
        System.out.println("Buscar cantidad__________4 ");
        System.out.println("Salir____________________5 ");
        System.out.println(" ");
        menu=t.nextInt();
        
        switch(menu){
        
            case 1: 
               
               registro(); 
               
            break;
            
            case 2:
        
         implntarM();
        imprimirDecorado(comisiones);
          
                Mayorymenor();
            break;
            
            case 3:
                break;
                
            case 4:
                break;
            case 5:
                
                break;
           
            
        
        
            
        
        }
        
        } while (menu<=4);
        
        
                
    }    
    
}


 
