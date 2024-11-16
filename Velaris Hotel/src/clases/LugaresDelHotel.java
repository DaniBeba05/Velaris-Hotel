package clases;

import Enums.TipoLugar;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class LugaresDelHotel {

    //--------------------------------
    //          Atributos:
    //--------------------------------
    private String nombre;
    private String descripcion;
    private int capacidadMaxima;
    private boolean disponible;
    private double costoAdicional;
    private TipoLugar tipoLugar;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private boolean esDePago;
    private List<ServicioAdicional> serviciosAdicionales; 
    //--------------------------------
    //          Constructores:
    //--------------------------------

 
    public LugaresDelHotel(String nombre, String descripcion, int capacidadMaxima, boolean disponible, 
                           double costoAdicional, TipoLugar tipoLugar, LocalTime horaApertura, 
                           LocalTime horaCierre, boolean esDePago) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.disponible = disponible;
        this.costoAdicional = costoAdicional;
        this.tipoLugar = tipoLugar;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.esDePago = esDePago;
        this.serviciosAdicionales = new ArrayList<>();
    }

   
    public LugaresDelHotel() {
        this.nombre = "Piscina";
        this.descripcion = "Lugar para todos los clientes donde pueden disfrutar de un agradable baño.";
        this.capacidadMaxima = 500;
        this.disponible = true;
        this.costoAdicional = 0.0;
        this.tipoLugar = TipoLugar.PISCINA;
        this.horaApertura = LocalTime.of(8, 0);
        this.horaCierre = LocalTime.of(20, 0);
        this.esDePago = false; 
        this.serviciosAdicionales = new ArrayList<>();
    }
    
     public LugaresDelHotel(LugaresDelHotel otroLugar) {
        this.nombre = otroLugar.nombre; 
        this.descripcion = otroLugar.descripcion; 
        this.capacidadMaxima = otroLugar.capacidadMaxima; 
        this.disponible= otroLugar.disponible; 
        this.costoAdicional = otroLugar.costoAdicional;
         this.tipoLugar = otroLugar.tipoLugar; 
        this.horaApertura = otroLugar.horaApertura;
        this.horaCierre = otroLugar.horaCierre;
        this.esDePago = otroLugar.esDePago;
        this.serviciosAdicionales = otroLugar.serviciosAdicionales; 
        
    }
    
     //--------------------------------
    //          Setters:
    //--------------------------------
     

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public void setTipoLugar(TipoLugar tipoLugar) {
        this.tipoLugar = tipoLugar;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }
     public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
     
       public void setEsDePago(boolean esDePago) {
        this.esDePago = esDePago;
    }
       
        //--------------------------------
    //          Getters:
    //--------------------------------

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public TipoLugar getTipoLugar() {
        return tipoLugar;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public boolean isEsDePago() {
        return esDePago;
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }
       
       
  
    //--------------------------------
    //     Métodos  Adicionales:
    //--------------------------------

   
    public void agregarServicioAdicional(String nombre, double costo) {
        serviciosAdicionales.add(new ServicioAdicional(nombre, costo));
    }

    // Método para mostrar los servicios adicionales
    public void mostrarServiciosAdicionales() {
        if (serviciosAdicionales.isEmpty()) {
            System.out.println("No hay servicios adicionales disponibles.");
        } else {
            System.out.println("Servicios Adicionales:");
            for (ServicioAdicional servicio : serviciosAdicionales) {
                System.out.println("- " + servicio.getNombre() + ": $" + servicio.getCoste());
            }
        }
    }
    
    @Override
    public String toString() {
        return "LugaresDelHotel{" +
               "nombre='" + nombre + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", capacidadMaxima=" + capacidadMaxima +
               ", disponible=" + disponible +
               ", costoAdicional=" + costoAdicional +
               ", tipoLugar=" + tipoLugar +
               ", horaApertura=" + horaApertura +
               ", horaCierre=" + horaCierre +
               ", esDePago=" + (esDePago ? "Sí" : "No") +
               '}';
    }
}
