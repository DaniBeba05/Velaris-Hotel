/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package velaris.hotel;
import java.time.LocalDate;
/**
 *
 * @author usuario
 */
public class VelarisHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         
        Habitación habitacion1 = new Habitación(101, "Suite", true, 200.00, true);

      
        System.out.println("Detalles de la habitacion 1:");
        System.out.println(habitacion1.obtenerDescripcion());

       
        System.out.println("\nIntentando reservar habitacion 1...");
        if (habitacion1.reservar()) {
            System.out.println("Habitacion reservada con exito.");
        } else {
            System.out.println("La habitacion no esta disponible para reserva.");
        }
        
        System.out.println(habitacion1.obtenerDescripcion());

       
        System.out.println("\nLiberando habitacion 1...");
        habitacion1.liberar();
        System.out.println(habitacion1.obtenerDescripcion());

       
        System.out.println("\nAplicando un descuento del 10% a la habitacion 1...");
        habitacion1.aplicarDescuento(10);
        System.out.println(habitacion1.obtenerDescripcion());

       
        Habitación habitacion2 = new Habitación(habitacion1);
        System.out.println("\nDetalles de la habitacion 2 (copia de la 1):");
        System.out.println(habitacion2.obtenerDescripcion());

        
        habitacion2.setNumeroHabitacion(102);
        habitacion2.setTipoHabitacion("Individual");
        habitacion2.aplicarCargoAdicional(50);
        System.out.println("\nDetalles de la habitacion 1 (original) despues de modificar la copia:");
        System.out.println(habitacion1.obtenerDescripcion());
        System.out.println("\nDetalles de la habitacion 2 (modificada):");
        System.out.println(habitacion2.obtenerDescripcion());

       
        System.out.println("\nEstableciendo precio de temporada alta en habitacion 2...");
        habitacion2.establecerPrecioTemporada("alta");
        System.out.println(habitacion2.obtenerDescripcion());

        
        System.out.println("\nComparando precios entre habitacion 1 y habitacion 2...");
        if (habitacion1.compararPrecio(habitacion2)) {
            System.out.println("La habitacion 1 es mas barata que la habitacion 2.");
        } else {
            System.out.println("La habitacion 1 no es mas barata que la habitacion 2.");
        }

        
        double costoConImpuesto = habitacion1.calcularCostoConImpuesto(3, 10);
        System.out.println("\nEl costo total para 3 noches en habitacion 1 con 10% de impuesto es: " + costoConImpuesto);

       
        System.out.println("\nReseteando la habitacion 1...");
        habitacion1.resetear();
        System.out.println(habitacion1.obtenerDescripcion());
    
        Cliente cliente1 = new Cliente("Carlos", "123ABC", 612345678, Cliente.Genero.MASCULINO, LocalDate.of(1985, 5, 15));
        System.out.println("Cliente 1:");
        System.out.println(cliente1.obtenerInformacionDetallada());
        System.out.println();

       
        Cliente cliente2 = new Cliente();
        System.out.println("Cliente 2 (constructor por defecto):");
        System.out.println(cliente2.obtenerInformacionDetallada());
        System.out.println();

        
        Cliente cliente3 = new Cliente(cliente1);
        System.out.println("Cliente 3 (constructor de copia de Cliente 1):");
        System.out.println(cliente3.obtenerInformacionDetallada());
        System.out.println();

        
        System.out.println("Validar numero de contacto de Cliente 1: " + cliente1.validarNumeroContacto());
        System.out.println("Cliente 1 es mayor de edad: " + cliente1.esMayorDeEdad());
        System.out.println("Cliente 1 es un numero movil: " + cliente1.esNumeroMovil());
        System.out.println("Cliente 1 tiene ID valido: " + cliente1.validarID());
        System.out.println();

      
        cliente2.actualizarCliente("Ana", "456DEF", 634567890, Cliente.Genero.FEMENINO);
        cliente2.cambiarFechaNacimiento(LocalDate.of(2005, 8, 20));
        System.out.println("Cliente 2 despues de actualizar:");
        System.out.println(cliente2.obtenerInformacionDetallada());
        System.out.println();

       
        Cliente cliente4 = cliente2.clonar();
        System.out.println("Cliente 4 (clon de Cliente 2):");
        System.out.println(cliente4.obtenerInformacionDetallada());
        System.out.println();

        
        int comparacion = cliente1.compararEdad(cliente2);
        if (comparacion > 0) {
            System.out.println("Cliente 1 es mayor que Cliente 2.");
        } else if (comparacion < 0) {
            System.out.println("Cliente 1 es menor que Cliente 2.");
        } else {
            System.out.println("Cliente 1 y Cliente 2 tienen la misma edad.");
        }
        System.out.println();

        
        boolean cambioGenero = cliente1.cambiarGenero(Cliente.Genero.OTRO);
        System.out.println("Cliente 1 despues de cambiar genero a OTRO:");
        System.out.println("Cambio de genero: " + (cambioGenero ? "exitoso" : "fallido"));
        System.out.println(cliente1.obtenerInformacionDetallada());
        System.out.println();

       
        System.out.println("Categoria de edad de Cliente 2: " + cliente2.categoriaEdad());
        System.out.println("Categoria de edad de Cliente 1: " + cliente1.categoriaEdad());
    }
}
    

