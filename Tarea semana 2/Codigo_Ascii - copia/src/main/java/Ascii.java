
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ascii {

    public static void main(String[] args) {

        String mensaje;
        String mensajeEncriptado;
        String MensajeDesencriptado;
        char array[];
        mensaje = JOptionPane.showInputDialog("Ingrese su codigo para Encriptar");
        array = mensaje.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (array[i] - (char) 6);
        }
        mensajeEncriptado = String.valueOf(array);
        
        System.out.println("Tu mensaje encriptado es: "+mensajeEncriptado);
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (array[i] + (char) 6);
        }
        MensajeDesencriptado=String.copyValueOf(array);
        System.out.println("Tu mensaje desencriptado es: " + MensajeDesencriptado);
    }
}
