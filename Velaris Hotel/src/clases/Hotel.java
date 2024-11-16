package clases;

import Enums.EstadoHabitacion;
import Enums.TipoPension;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import Enums.EstadoReserva;
import Enums.TipoStaff;
import clases.Cliente;
import clases.Habitación;
import clases.LugaresDelHotel;
import clases.Reserva;
import clases.Staff;

public class Hotel {
    //--------------------------------
    //          Atributos:
    //--------------------------------
    private String nombre;
    private String direccion;
    private ArrayList<Habitación> habitaciones;
    private ArrayList<Cliente> clientes;
    private ArrayList<Staff> staff;
    private ArrayList<LugaresDelHotel> lugaresDelHotel;

    //--------------------------------
    //          Constructores:
    //--------------------------------
    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.lugaresDelHotel = new ArrayList<>();
    }

    //--------------------------------
    //          Setters:
    //--------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHabitaciones(ArrayList<Habitación> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    public void setLugaresDelHotel(ArrayList<LugaresDelHotel> lugaresDelHotel) {
        this.lugaresDelHotel = lugaresDelHotel;
    }

    //--------------------------------
    //          Getters:
    //--------------------------------
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Habitación> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public ArrayList<LugaresDelHotel> getLugaresDelHotel() {
        return lugaresDelHotel;
    }

    //--------------------------------
    //          Métodos Adicionales:
    //--------------------------------
    public void agregarHabitacion(Habitación habitacion) {
        habitaciones.add(habitacion);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarStaff(Staff personal) {
        staff.add(personal);
    }

    public void agregarLugar(LugaresDelHotel lugar) {
        lugaresDelHotel.add(lugar);
    }

    public boolean realizarReserva(Cliente cliente, LocalDate fechaEntrada, LocalDate fechaSalida, TipoPension tipoPension) {
        for (Habitación habitacion : habitaciones) {
            if (habitacion.getEstadoHabitacion() == EstadoHabitacion.DISPONIBLE) {

                Reserva nuevaReserva = new Reserva(fechaEntrada, fechaSalida, cliente, EstadoReserva.CONFIRMADA, true,
                        calcularCosto(fechaEntrada, fechaSalida, habitacion.getPrecioPorNoche()), tipoPension);

                habitacion.setEstadoHabitacion(EstadoHabitacion.NODISPONIBLE);
                cliente.getReservas().add(nuevaReserva);

                // Asignar la reserva a un miembro del staff con espacio disponible
                for (Staff miembro : staff) {
                    if (miembro.addReserva(nuevaReserva)) {
                        System.out.println("Reserva realizada y asignada a: " + miembro.getnombre());
                        System.out.println("Reserva realizada con éxito.");
                        return true; // La reserva se realizó con éxito
                    }
                }

                System.out.println("No se pudo agregar la reserva al staff, límite alcanzado.");
                return false;
            }
        }

        System.out.println("No hay habitaciones disponibles para las fechas solicitadas.");
        return false; // No se pudo realizar la reserva
    }

    private double calcularCosto(LocalDate fechaEntrada, LocalDate fechaSalida, double precioPorNoche) {
        long noches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
        return noches * precioPorNoche;
    }

    public void cancelarReserva(Reserva reserva) {
        if (reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
            reserva.cancelarReserva();
        } else {
            System.out.println("La reserva no se puede cancelar.");
        }
    }

    public boolean verificarDisponibilidad(LocalDate fechaEntrada, LocalDate fechaSalida) {
        for (Habitación habitacion : habitaciones) {
            if (habitacion.getEstadoHabitacion() == EstadoHabitacion.DISPONIBLE) {
                return true;
            }
        }
        return false;
    }

    public void mostrarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.obtenerInformacionDetallada());
        }
    }

    public void mostrarReservas() {
        for (Staff miembro : staff) {
            System.out.println("Reservas a cargo de " + miembro.getnombre() + ":");
            for (Reserva reserva : miembro.getReservas()) {
                System.out.println(reserva.mostrarDetalles());
            }
        }
    }

    public void actualizarEstadoHabitaciones() {
        for (Habitación habitacion : habitaciones) {
            if (habitacion.getEstadoHabitacion() == EstadoHabitacion.LIMPIA) {
                habitacion.setEstaLimpia(true);
            } else {
                habitacion.setEstadoHabitacion(EstadoHabitacion.SUCIA);
            }
        }
    }

    public double calcularIngresos() {
        double total = 0;
        for (Staff miembro : staff) {
            for (Reserva reserva : miembro.getReservas()) {
                if (reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
                    total += reserva.getCostoTotal();
                }
            }
        }
        return total;
    }

    public void mostrarInformacion() {
        System.out.println("Hotel: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Habitaciones: " + habitaciones.size());
        System.out.println("Clientes: " + clientes.size());
        System.out.println("Personal: " + staff.size());
        System.out.println("Lugares: " + lugaresDelHotel.size());
    }
}
