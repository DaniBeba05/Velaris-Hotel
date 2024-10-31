package clases;
 
import Enums.TipoHabitacion;
import Enums.EstadoHabitacion;
import Enums.EstadoDeElementosDeHabitacion;
import Enums.ElementosHabitacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
    private TipoHabitacion tipoHabitacion;
    private EstadoHabitacion estadoHabitacion;
    private double precioPorNoche; 
    private boolean estaLimpia;
    private Map<ElementosHabitacion, EstadoDeElementosDeHabitacion> elementosHabitacion;

    //--------------------------------
    //          Constructores:
    //--------------------------------

    public Habitación(int numeroHabitacion, TipoHabitacion tipoHabitacion, EstadoHabitacion estadoHabitacion, double precioPorNoche, boolean estaLimpia) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.estaLimpia = estaLimpia;
        this.elementosHabitacion = new HashMap<>(); // Inicialización del mapa.
    }

    public Habitación() { 
        numeroHabitacion = 5; 
        tipoHabitacion = TipoHabitacion.DOBLE;
        estadoHabitacion = EstadoHabitacion.DISPONIBLE;
        precioPorNoche = 100.50; 
        estaLimpia = true;
        this.elementosHabitacion = new HashMap<>(); // Inicialización del mapa.
    }

    public Habitación(Habitación otraHabitacion) {
        this.numeroHabitacion = otraHabitacion.numeroHabitacion;
        this.tipoHabitacion = otraHabitacion.tipoHabitacion;
        this.estadoHabitacion = otraHabitacion.estadoHabitacion;
        this.precioPorNoche = otraHabitacion.precioPorNoche; 
        this.estaLimpia = otraHabitacion.estaLimpia;
        this.elementosHabitacion = new HashMap<>(otraHabitacion.elementosHabitacion); 
    }

    //--------------------------------
    //          Setters:
    //--------------------------------
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion; 
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion; 
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche; 
    }

    public void setEstaLimpia(boolean estaLimpia) {
        this.estaLimpia = estaLimpia; 
    }

    //--------------------------------
    //          Getters:
    //--------------------------------
    public int getNumeroHabitacion() {
        return this.numeroHabitacion; 
    }

    public TipoHabitacion getTipoHabitacion() {
        return this.tipoHabitacion; 
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return this.estadoHabitacion; 
    }

    public double getPrecioPorNoche() {
        return this.precioPorNoche;
    }

    public boolean isEstaLimpia() {
        return estaLimpia; 
    }

    //--------------------------------
    //         Otros métodos:
    //--------------------------------

    
    public void agregarElemento(ElementosHabitacion elemento, EstadoDeElementosDeHabitacion estado) {
        this.elementosHabitacion.put(elemento, estado);
    }

    
    public void actualizarEstadoElemento(ElementosHabitacion elemento, EstadoDeElementosDeHabitacion nuevoEstado) {
        if (this.elementosHabitacion.containsKey(elemento)) {
            this.elementosHabitacion.put(elemento, nuevoEstado);
        } else {
            System.out.println("El elemento " + elemento + " no existe en la habitación.");
        }
    }

   
    public EstadoDeElementosDeHabitacion obtenerEstadoElemento(ElementosHabitacion elemento) {
        return this.elementosHabitacion.getOrDefault(elemento, null);
    }

   
    public boolean elementoDisponibleParaUsar(ElementosHabitacion elemento) {
        return this.elementosHabitacion.getOrDefault(elemento, EstadoDeElementosDeHabitacion.NODISPONIBLEPARAUSAR) == EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR;
    }

    public void cambiarEstado(EstadoHabitacion nuevoEstado) {
        this.estadoHabitacion = nuevoEstado;
    }

    public boolean reservar() {
        if (this.estadoHabitacion == EstadoHabitacion.DISPONIBLE) {
            this.estadoHabitacion = EstadoHabitacion.NODISPONIBLE;
            return true;
        }
        return false; 
    }

    public void liberar() {
        this.estadoHabitacion = EstadoHabitacion.DISPONIBLE;
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

    public boolean esTipo(TipoHabitacion tipo) {
        return this.tipoHabitacion == tipo;
    }

    public double calcularCostoConImpuesto(int noches, double impuestoPorcentaje) {
        double costoBase = this.precioPorNoche * noches;
        return costoBase + (costoBase * (impuestoPorcentaje / 100));
    }

    public void resetear() {
        this.estadoHabitacion = EstadoHabitacion.DISPONIBLE;
        this.estaLimpia = true; 
    }

    public String obtenerDescripcion() {
        String disponibilidad = (estadoHabitacion == EstadoHabitacion.DISPONIBLE) ? "disponible" : "no disponible";
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
                // Precio sin cambios.
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
               ", tipoHabitacion=" + tipoHabitacion +
               ", estadoHabitacion=" + estadoHabitacion +
               ", precioPorNoche=" + precioPorNoche +
               ", estaLimpia=" + estaLimpia +
               ", elementosHabitacion=" + elementosHabitacion +
               '}';
    }
}

