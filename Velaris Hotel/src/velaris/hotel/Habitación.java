package velaris.hotel;


import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Habitación {  

    //--------------------------------
    //          Atributos:
    //--------------------------------
    private int numeroHabitacion; 
    private String tipoHabitacion; 
    private boolean estaDisponible;
    private double precioPorNoche; 
    private boolean estaLimpia;
     
    

    //--------------------------------
    //          Constructores:
    //--------------------------------

    public Habitación(int numeroHabitacion, String tipoHabitacion, boolean estaDisponible, double precioPorNoche, boolean estaLimpia) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.estaDisponible = estaDisponible;
        this.precioPorNoche = precioPorNoche;
        this.estaLimpia = estaLimpia;
         
    }

    public Habitación() { 
        
        numeroHabitacion = 5; 
        tipoHabitacion = "doble";
        estaDisponible = true;
        precioPorNoche = 100.50; 
        estaLimpia = true; 
         
        
    }

        public Habitación(Habitación otraHabitacion) {
        this.numeroHabitacion = otraHabitacion.numeroHabitacion;
        this.tipoHabitacion = otraHabitacion.tipoHabitacion;
        this.estaDisponible = otraHabitacion.estaDisponible;
        this.precioPorNoche = otraHabitacion.precioPorNoche; 
    }
        
      
        
        
        
        
 
    //--------------------------------
    //          Setters:
    //--------------------------------
 
    public void setNumeroHabitacion(int numeroHabitacion){
        this.numeroHabitacion = numeroHabitacion;
    }
 
    public void setTipoHabitacion(String tipoHabitacion){
        this.tipoHabitacion = tipoHabitacion; 
    }
 
    public void setEstaDisponible(boolean estaDisponible){
        this.estaDisponible = estaDisponible; 
    }
     
    public void setPrecioPorNoche(double precioPorNoche){
        this.precioPorNoche = precioPorNoche; 
    }
    
    public void setEstaLimpia(boolean estaLimpia){
        this.estaLimpia = estaLimpia; 
    }

    //--------------------------------
    //          Getters:
    //--------------------------------
     
    public int getNumeroHabitacion(){
        return this.numeroHabitacion; 
    }
     
    public String getTipoHabitacion(){
        return this.tipoHabitacion; 
    }
     
    public boolean isDisponible(){
        return this.estaDisponible; 
    }
    
    public double getPrecioPorNoche(){
        return this.precioPorNoche;
    }
    
    public boolean getEstaLimpia(){
        return estaLimpia; 
    }
    
    //--------------------------------
    //          Otros metodos:
    //--------------------------------
    
    public void cambiarEstado(boolean disponible) {
        this.estaDisponible = disponible;
    }
    
    public boolean reservar() {
        if (this.estaDisponible) {
            this.estaDisponible = false;
            return true;
        } 
        return false; 
    }
    
    public void liberar() {
        this.estaDisponible = true;
    }
    
    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            this.precioPorNoche -= this.precioPorNoche * (porcentaje / 100);
        } else {
            System.out.println("El porcentaje de descuento debe estar entre 0 y 100.");
        }
    }
    
    public void actualizarLimpieza(boolean limpia) {
        this.estaLimpia = limpia;
    }
    
    public boolean esTipo(String tipo) {
        return this.tipoHabitacion.equalsIgnoreCase(tipo);
    }
    
    public double calcularCostoConImpuesto(int noches, double impuestoPorcentaje) {
        double costoBase = this.precioPorNoche * noches;
        return costoBase + (costoBase * (impuestoPorcentaje / 100));
    }
    
    public void resetear() {
        this.estaDisponible = true;
        this.estaLimpia = true; 
    }
    
    public String obtenerDescripcion() {
        String disponibilidad = estaDisponible ? "disponible" : "no disponible";
        String limpieza = estaLimpia ? "limpia" : "sucia";
        return "Habitación " + numeroHabitacion + " (" + tipoHabitacion + ") - Precio por noche: $" + precioPorNoche +
               " - Estado: " + disponibilidad + " - Limpieza: " + limpieza;
    }
    
    public void aplicarCargoAdicional(double cargo) {
        if (cargo > 0) {
            this.precioPorNoche += cargo;
        } else {
            System.out.println("El cargo adicional debe ser mayor que cero.");
        }
    }
 
  
 
    public void establecerPrecioTemporada(String temporada) {
        switch (temporada.toLowerCase()) {
            case "alta":
                this.precioPorNoche *= 1.4; 
                break;
            case "media":
                this.precioPorNoche *= 1.2; 
                break;
            case "baja":
                break;
            default:
                System.out.println("Temporada no válida.");
        }
    }

    public boolean compararPrecio(Habitación otraHabitacion) {
        return this.precioPorNoche < otraHabitacion.getPrecioPorNoche();
    }

    @Override
    public String toString() {
        return "Habitacion{" +
               "numeroHabitacion=" + numeroHabitacion +
               ", tipoHabitacion='" + tipoHabitacion + '\'' +
               ", estaDisponible=" + estaDisponible +
               ", precioPorNoche=" + precioPorNoche +
               ", estaLimpia=" + estaLimpia +
               '}';
    }
}
