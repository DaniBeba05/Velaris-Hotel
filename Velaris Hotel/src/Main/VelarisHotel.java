/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import Enums.TipoStaff;
import clases.Staff;
import clases.Reserva;
import Enums.GeneroCliente;
import Enums.EstadoReserva;
import clases.Cliente;
 import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author usuario
 */



public class VelarisHotel{
   
   public static void main(String[] args) {
       
  
    Cliente cliente1 = new Cliente("Carlos", "123ABC", 612345678, GeneroCliente.MASCULINO, LocalDate.of(1985, 5, 15));
    Cliente cliente2 = new Cliente("Maria", "456DEF", 612345679, GeneroCliente.FEMENINO, LocalDate.of(1990, 8, 22));
    
  
    LocalDate fechaEntrada1 = LocalDate.now().plusDays(4); 
    LocalDate fechaSalida1 = fechaEntrada1.plusDays(3);
    double costoTotal1 = 300.00; 
    
    Reserva reserva1 = new Reserva(fechaEntrada1, fechaSalida1, cliente1, EstadoReserva.PENDIENTE, true, costoTotal1);
    
    System.out.println(reserva1.mostrarDetalles());
    reserva1.pagarReserva(); 
    reserva1.confirmarReserva();
    System.out.println(reserva1.mostrarDetalles());
    
    System.out.println("\nEl cliente " + cliente1.getNombre() + " decide cancelar la reserva...");
    reserva1.cancelarReserva();
    System.out.println(reserva1.mostrarDetalles());
    
    LocalDate fechaEntrada2 = LocalDate.now().plusDays(2);
    LocalDate fechaSalida2 = fechaEntrada2.plusDays(2); 
    double costoTotal2 = 200.00; 
    
    Reserva reserva2 = new Reserva(fechaEntrada2, fechaSalida2, cliente2, EstadoReserva.PENDIENTE, true, costoTotal2);
    
    System.out.println("\nDetalles de la segunda reserva:");
    System.out.println(reserva2.mostrarDetalles());
    
    reserva2.pagarReserva();
    reserva2.confirmarReserva();
    System.out.println(reserva2.mostrarDetalles());
    
    System.out.println("\nEl cliente " + cliente2.getNombre() + " decide cancelar la reserva...");
    reserva2.cancelarReserva();
    System.out.println(reserva2.mostrarDetalles());
    
    // ----------------------------------------
    //          Creación de un Staff
    // ----------------------------------------
    
    Staff staff1 = new Staff("Juan Perez", 101, TipoStaff.RECEPCIONISTA, 3);
    
   
    System.out.println("\nDetalles del Staff:");
    System.out.println(staff1.obtenerResumen());
    
   
    if (staff1.addReserva(reserva1)) {
        System.out.println("\nReserva aniadida al Staff " + staff1.getnombre());
    } else {
        System.out.println("\nNo se pudo aniadir la reserva al Staff " + staff1.getnombre() + " porque ha alcanzado el limite.");
    }
    
   
    if (staff1.addReserva(reserva2)) {
        System.out.println("\nSegunda reserva aniadida al Staff " + staff1.getnombre());
    } else {
        System.out.println("\nNo se pudo añadir la segunda reserva al Staff " + staff1.getnombre() + " porque ha alcanzado el limite.");
    }
    
    
    System.out.println("\nReservas actuales del Staff:");
    for (Reserva reserva : staff1.getReservas()) {
        System.out.println(reserva.mostrarDetalles());
    }
    
    
    if (staff1.maxReservasAlcanzado()) {
        System.out.println("\nEl Staff " + staff1.getnombre() + " ha alcanzado el numero maximo de reservas permitidas.");
    } else {
        System.out.println("\nEl Staff " + staff1.getnombre() + " aun puede gestionar más reservas.");
    }
}

}





  

    

