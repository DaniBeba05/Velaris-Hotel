package velaris.hotel;

import java.util.Objects;
import java.time.LocalDate;
import java.time.Period;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Cliente {
    
    //--------------------------------
    //          Atributos:
    //--------------------------------
    
    private String nombre;
    private String ID; 
    private int numeroContacto; 
    private Genero genero;
    private LocalDate fechaNacimiento;
    
    //--------------------------------
    //          Constructores:
    //--------------------------------

    public Cliente(String nombre, String ID, int numeroContacto, Genero genero, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.ID = ID;
        this.numeroContacto = numeroContacto;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento; 
    }
    
    public Cliente (){
        nombre = "Jesus"; 
        ID = "234515L";
        numeroContacto = 658571829; 
        genero = Genero.MASCULINO;
        fechaNacimiento = LocalDate.of(1990,1,1); 
    }
    
    public Cliente (Cliente otroCliente){
        this.nombre = otroCliente.nombre;
        this.ID = otroCliente.ID;
        this.numeroContacto = otroCliente.numeroContacto;
        this.genero = otroCliente.genero; 
        this.fechaNacimiento = otroCliente.fechaNacimiento;
    }
    
    //--------------------------------
    //          Setters:
    //--------------------------------
    
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    
    public void setID(String ID){
        this.ID = ID; 
    }
    
    public void setNumeroContacto(int numeroContacto){
        this.numeroContacto = numeroContacto; 
    }
    
    public void setGenero(Genero genero){
        this.genero = genero; 
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento; 
    }
    
    //--------------------------------
    //          Getters:
    //--------------------------------
    
    public String getNombre(){
        return nombre; 
    }
    
    public String getID(){
        return ID; 
    }
    
    public int getNumeroContacto(){
        return numeroContacto; 
    }
    
    public Genero getGenero(){
        return genero; 
    }
    
    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    //--------------------------------
    //          Otros métodos:
    //--------------------------------
    
    public enum Genero {
        MASCULINO, FEMENINO, OTRO;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", ID=" + ID + ", numeroContacto=" + numeroContacto + ", genero=" + genero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.ID);
        hash = 13 * hash + this.numeroContacto;
        hash = 13 * hash + Objects.hashCode(this.genero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.numeroContacto != other.numeroContacto) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return this.genero == other.genero;
    }
    
    public boolean validarNumeroContacto() {
        String numero = String.valueOf(numeroContacto);
        return numero.length() == 9;
    }
    
    public void actualizarCliente(String nombre, String ID, int numeroContacto, Genero genero) {
        this.nombre = nombre;
        this.ID = ID;
        this.numeroContacto = numeroContacto;
        this.genero = genero;
    }

    public void formatearID() {
        this.ID = this.ID.toUpperCase();
    }
    
    public boolean esMayorDeEdad() {
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);
        return edad.getYears() >= 18;
    }
    
    public Cliente clonar() {
        return new Cliente(this);
    }

    public boolean esGenero(Genero genero) {
        return this.genero == genero;
    }

    public boolean cambiarGenero(Genero nuevoGenero) {
        if (nuevoGenero != null && nuevoGenero != this.genero) {
            this.genero = nuevoGenero;
            return true;
        }
        return false;
    }
    
    public boolean validarID() {
        return this.ID.matches("[A-Za-z0-9]{6,12}");
    }
    
    public int obtenerEdad() {
        LocalDate hoy = LocalDate.now();
        return Period.between(fechaNacimiento, hoy).getYears();
    }
    
    public boolean esNumeroMovil() {
        String numero = String.valueOf(numeroContacto);
        return numero.startsWith("6") || numero.startsWith("7");
    }
    
    public int compararEdad(Cliente otroCliente) {
        return Integer.compare(this.obtenerEdad(), otroCliente.obtenerEdad());
    }

    public String obtenerInformacionDetallada() {
        return String.format("Nombre: %s\nID: %s\nNumero de Contacto: %d\nGenero: %s\nFecha de Nacimiento: %s\nEdad: %d years", 
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
            return "ninio";
        } else if (edad < 18) {
            return "Adolescente";
        } else {
            return "Adulto";
        }
    }
}





    
    

}
