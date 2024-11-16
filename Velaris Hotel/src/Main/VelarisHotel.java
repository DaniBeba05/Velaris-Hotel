package main; 
import Enums.ElementosHabitacion;
import Enums.EstadoDeElementosDeHabitacion;
import Enums.EstadoHabitacion;
import clases.Cliente;
import clases.Facturacion;
import clases.Habitación;
import clases.LugaresDelHotel;
import clases.Reserva;
import clases.ServicioAdicional;
import clases.Staff; 
import clases.Hotel;
import Enums.EstadoReserva;
import Enums.GeneroCliente;
import Enums.TipoHabitacion;
import Enums.TipoLugar;
import Enums.TipoPension;
import Enums.TipoStaff;
import java.time.LocalDate;
import java.time.LocalTime; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VelarisHotel {
    public static void main(String[] args) {
       Hotel hotel = new Hotel("Hotel Paradise", "Calle Falsa 123");

        // Crear habitaciones
        Habitación habitacion1 = new Habitación(101, TipoHabitacion.DOBLE, EstadoHabitacion.LIMPIA, 150.00, true, new ArrayList<>());
        Habitación habitacion2 = new Habitación(102, TipoHabitacion.TRIPLE, EstadoHabitacion.DISPONIBLE, 200.00, true, new ArrayList<>());

        // Agregar habitaciones al hotel
        hotel.agregarHabitacion(habitacion1);
        hotel.agregarHabitacion(habitacion2);

        // Crear clientes
        Cliente cliente1 = new Cliente("Laura", "123456A", 123456789, GeneroCliente.FEMENINO, LocalDate.of(1995, 5, 15), null, null, null);
        Cliente cliente2 = new Cliente("Carlos", "789012B", 987654321, GeneroCliente.MASCULINO, LocalDate.of(1988, 8, 22), null, null, null);

        // Agregar clientes al hotel
        hotel.agregarCliente(cliente1);
        hotel.agregarCliente(cliente2);

        // Crear staff
        Staff staff1 = new Staff("Juan", 1, TipoStaff.RECEPCIONISTA, 10);
        Staff staff2 = new Staff("Ana", 2, TipoStaff.COCINERO, 5);

        // Agregar staff al hotel
        hotel.agregarStaff(staff1);
        hotel.agregarStaff(staff2);

        // Crear lugares del hotel
        LugaresDelHotel piscina = new LugaresDelHotel("Piscina", "Lugar para nadar y relajarse.", 50, true, 0, TipoLugar.PISCINA, LocalTime.of(8, 0), LocalTime.of(20, 0), false);
        hotel.agregarLugar(piscina);

        // Mostrar información del hotel
        hotel.mostrarInformacion();

        // Crear una reserva
        Reserva reserva1 = new Reserva(LocalDate.now(), LocalDate.now().plusDays(2), cliente1, EstadoReserva.PENDIENTE, false, 300, TipoPension.SOLO_DESAYUNO);
        System.out.println(reserva1.mostrarDetalles());

        // Confirmar la reserva
        reserva1.confirmarReserva();
        System.out.println(reserva1.mostrarDetalles());

        // Mostrar detalles de la habitación y sus elementos
        habitacion1.agregarElemento(ElementosHabitacion.CAMA, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.BAÑO, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.AIREACONDICIONADO, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.ARMARIO, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.NEVERA, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.MESAESTUDIO, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.TELEVISION, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.SOFA, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.CAJAFUERTE, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);
        habitacion1.agregarElemento(ElementosHabitacion.COCINA, EstadoDeElementosDeHabitacion.DISPONIBLEPARAUSAR);

        System.out.println("Estado de los elementos en la habitación 101: " + habitacion1.getElementosHabitacion());
    }
}
