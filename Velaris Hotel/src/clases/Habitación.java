package clases;

import Enums.TipoHabitacion;
import Enums.EstadoHabitacion;
import Enums.EstadoDeElementosDeHabitacion;
import Enums.ElementosHabitacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private ArrayList<Cliente> clientes;

    //--------------------------------
    //          Constructores:
    //--------------------------------
    public Habitación(int numeroHabitacion, TipoHabitacion tipoHabitacion, EstadoHabitacion estadoHabitacion, double precioPorNoche, boolean estaLimpia, ArrayList<Cliente> clientes) {
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.precioPorNoche = precioPorNoche;
        this.estaLimpia = estaLimpia;
        this.elementosHabitacion = new HashMap<>();
        this.clientes = (clientes != null) ? new ArrayList<>(clientes) : new ArrayList<>();
    }

    public Habitación() {
        this(5, TipoHabitacion.DOBLE, EstadoHabitacion.DISPONIBLE, 100.50, true, null);
        this.elementosHabitacion = new HashMap<>();
    }

    public Habitación(Habitación otraHabitacion) {
        this.numeroHabitacion = otraHabitacion.numeroHabitacion;
        this.tipoHabitacion = otraHabitacion.tipoHabitacion;
        this.estadoHabitacion = otraHabitacion.estadoHabitacion;
        this.precioPorNoche = otraHabitacion.precioPorNoche;
        this.estaLimpia = otraHabitacion.estaLimpia;
        this.elementosHabitacion = new HashMap<>(otraHabitacion.elementosHabitacion);
        this.clientes = new ArrayList<>(otraHabitacion.clientes); 
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

    public void setElementosHabitacion(Map<ElementosHabitacion, EstadoDeElementosDeHabitacion> elementosHabitacion) {
        this.elementosHabitacion = elementosHabitacion;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    //--------------------------------
    //          Getters:
    //--------------------------------
    public int getNumeroHabitacion() {
        return this.numeroHabitacion;
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

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public Map<ElementosHabitacion, EstadoDeElementosDeHabitacion> getElementosHabitacion() {
        return elementosHabitacion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
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
        return this.elementosHabitacion.getOrDefault(elemento, EstadoDeElementosDeHabitacion.AVERIADO);
    }
}
