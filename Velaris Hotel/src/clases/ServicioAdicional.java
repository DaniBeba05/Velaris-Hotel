package clases;


public class ServicioAdicional {

    //--------------------------------
    //          Atributos:
    //--------------------------------
    private String nombre;
    private double coste;

    //--------------------------------
    //          Constructores:
    //--------------------------------
    public ServicioAdicional(String nombre, double coste) {
        this.nombre = nombre;
        this.coste = coste;
    }

    public ServicioAdicional() {
        this.nombre = "Servicio Genérico";
        this.coste = 0.0; 
    }

    public ServicioAdicional(ServicioAdicional otroServicioAdicional) {
        this.nombre = otroServicioAdicional.nombre;
        this.coste = otroServicioAdicional.coste;
    }

    //--------------------------------
    //          Setters:
    //--------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    //--------------------------------
    //          Getters:
    //--------------------------------
    public String getNombre() {
        return nombre;
    }

    public double getCoste() {
        return coste;
    }

    //--------------------------------
    //          Métodos Adicionales:
    //--------------------------------
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 100.");
        }
        this.coste -= this.coste * (porcentaje / 100);
    }

    public String mostrarDetalles() {
        return "Servicio: " + nombre + ", Coste: $" + String.format("%.2f", coste);
    }

    public boolean esServicioGratuito() {
        return this.coste == 0.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServicioAdicional that = (ServicioAdicional) obj;
        return Double.compare(that.coste, coste) == 0 && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nombre, coste);
    }

    public void actualizarCoste(double nuevoCoste) {
        if (nuevoCoste < 0) {
            throw new IllegalArgumentException("El coste no puede ser negativo.");
        }
        this.coste = nuevoCoste;
    }
}


