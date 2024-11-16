package clases;

import Enums.GeneroCliente;
import java.util.Objects;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    //--------------------------------
    //          Atributos:
    //--------------------------------

    private String nombre;
    private String ID;
    private int numeroContacto;
    private GeneroCliente genero;
    private LocalDate fechaNacimiento;
    private List<Reserva> reservas;
    private List<ServicioAdicional> servicioAdicional;
    private List<LugaresDelHotel> lugaresDelHotel;

    //--------------------------------
    //          Constructores:
    //--------------------------------

    public Cliente(String nombre, String ID, int numeroContacto, GeneroCliente genero, LocalDate fechaNacimiento, List<Reserva> reservas, List<ServicioAdicional> servicioAdicional, List<LugaresDelHotel> lugaresDelHotel) {
        this.nombre = nombre;
        this.ID = ID;
        this.numeroContacto = numeroContacto;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.reservas = (reservas != null) ? new ArrayList<>(reservas) : new ArrayList<>();
        this.servicioAdicional = (servicioAdicional != null) ? new ArrayList<>(servicioAdicional) : new ArrayList<>();
        this.lugaresDelHotel = (lugaresDelHotel != null) ? new ArrayList<>(lugaresDelHotel) : new ArrayList<>();
    }

    public Cliente() {
        this("Jesus", "234515L", 658571829, GeneroCliente.MASCULINO, LocalDate.of(1990, 1, 1), null, null, null);
    }

    public Cliente(Cliente otroCliente) {
        this(otroCliente.nombre, otroCliente.ID, otroCliente.numeroContacto, otroCliente.genero, otroCliente.fechaNacimiento, otroCliente.reservas, otroCliente.servicioAdicional, otroCliente.lugaresDelHotel);
    }

    //--------------------------------
    //          Setters:
    //--------------------------------

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public void setGenero(GeneroCliente genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setServicioAdicional(List<ServicioAdicional> servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }

    public void setLugaresDelHotel(List<LugaresDelHotel> lugaresDelHotel) {
        this.lugaresDelHotel = lugaresDelHotel;
    }

    
    

    //--------------------------------
    //          Getters:
    //--------------------------------

    public String getNombre() {
        return nombre;
    }

    public String getID() {
        return ID;
    }

    public int getNumeroContacto() {
        return numeroContacto;
    }

    public GeneroCliente getGenero() {
        return genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    
    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas);
    }

    public List<ServicioAdicional> getServicioAdicional() {
        return new ArrayList<>(servicioAdicional);
    }

    public List<LugaresDelHotel> getLugaresDelHotel() {
        return new ArrayList<>(lugaresDelHotel);
    }


    //--------------------------------
    //          Otros métodos:
    //--------------------------------

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", ID=" + ID + ", numeroContacto=" + numeroContacto + ", genero=" + genero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(nombre);
        hash = 13 * hash + Objects.hashCode(ID);
        hash = 13 * hash + numeroContacto;
        hash = 13 * hash + Objects.hashCode(genero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (numeroContacto != other.numeroContacto) {
            return false;
        }
        if (!Objects.equals(nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(ID, other.ID)) {
            return false;
        }
        return genero == other.genero;
    }

    public boolean validarNumeroContacto() {
        return String.valueOf(numeroContacto).length() == 9;
    }

    public void actualizarCliente(String nombre, String ID, int numeroContacto, GeneroCliente genero) {
        this.nombre = nombre;
        this.ID = ID;
        this.numeroContacto = numeroContacto;
        this.genero = genero;
    }

    public void formatearID() {
        this.ID = ID.toUpperCase();
    }

    public boolean esMayorDeEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    public Cliente clonar() {
        return new Cliente(this);
    }

    public boolean esGenero(GeneroCliente genero) {
        return this.genero == genero;
    }

    public boolean cambiarGenero(GeneroCliente nuevoGenero) {
        if (nuevoGenero != null && nuevoGenero != this.genero) {
            this.genero = nuevoGenero;
            return true;
        }
        return false;
    }

    public boolean validarID() {
        return ID.matches("[A-Za-z0-9]{6,12}");
    }

    public int obtenerEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public boolean esNumeroMovil() {
        String numero = String.valueOf(numeroContacto);
        return numero.startsWith("6") || numero.startsWith("7");
    }

    public int compararEdad(Cliente otroCliente) {
        return Integer.compare(this.obtenerEdad(), otroCliente.obtenerEdad());
    }

    public String obtenerInformacionDetallada() {
        return String.format("Nombre: %s\nID: %s\nNumero de Contacto: %d\nGenero: %s\nFecha de Nacimiento: %s\nEdad: %d años",
                             nombre, ID, numeroContacto, genero, fechaNacimiento, obtenerEdad());
    }

    public boolean cambiarFechaNacimiento(LocalDate nuevaFecha) {
        if (nuevaFecha != null && nuevaFecha.isBefore(LocalDate.now())) {
            this.fechaNacimiento = nuevaFecha;
            return true;
        }
        return false;
    }

    public String categoriaEdad() {
        int edad = obtenerEdad();
        if (edad < 12) {
            return "niño";
        } else if (edad < 18) {
            return "Adolescente";
        } else {
            return "Adulto";
        }
    }
}

