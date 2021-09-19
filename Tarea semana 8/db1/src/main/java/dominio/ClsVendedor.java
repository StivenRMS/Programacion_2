
package dominio;

/**
 *
 * @author ramos
 */
public class ClsVendedor {
    
    private int id;
    private String nombre;
    private double enero;
    private double febrero;
    private double marzo;
    private double promedio;
    private double totalMeses;
    
    
    
    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double Promedio) {
        this.promedio = Promedio;
    }

    @Override
    public String toString() {
        return "ClsVendedor{" + "id=" + id + ", nombre=" + nombre + ", enero=" + enero + ", febrero=" + febrero + ", marzo=" + marzo + ", Promedio=" + promedio + ", totalMeses=" + totalMeses + '}';
    }
    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnero() {
        return enero;
    }

    public void setEnero(double enero) {
        this.enero = enero;
    }

    public double getFebrero() {
        return febrero;
    }

    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    public double getMarzo() {
        return marzo;
    }

    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }

    public double getTotalMeses() {
        return totalMeses;
    }

    public void setTotalMeses(double totalMeses) {
        this.totalMeses = totalMeses;
    }
    
}
