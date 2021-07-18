
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HolaMundo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double dinero, total;
        var moneda = "";

        System.out.println("Bienvenido a Convertidor de modenas... ");
        System.out.println("Ingrese la cantidad de dinero (Q): ");
         dinero =sc.nextDouble();

         System.out.println("Ingrese el tipo de moneda:"
                 + "D = Dolar "+','
                 + "E =Euro "+','
                 + "Y=Yen");
         moneda =sc.next();
         
         System.out.println("EL RESULTADO ES: ");
         
        
        switch (moneda) {

            case "D":
                total = dinero * 7.25;
                System.out.println(total);
                break;
                
            case "E":
                total = dinero * 9.25;
                System.out.println(total);
                break;
                
            case "Y":
                total = dinero * 0.070;
                System.out.println(total);
                break;
                
            default:
                System.out.println("Esa opcion no existe chaval...");
                break;

        }

        

    }
