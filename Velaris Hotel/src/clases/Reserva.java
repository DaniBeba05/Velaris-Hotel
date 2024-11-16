package clases;
import Enums.EstadoReserva;
import clases.Cliente;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import Enums.TipoPension;

/**
 *
 * @author usuario
 */


public class Reserva {
    
        //--------------------------------
        //          Atributos:
        //--------------------------------
    
        private LocalDate fechaDeEntrada; 
        private LocalDate fechaDeSalida; 
        private Cliente cliente; 
        private EstadoReserva estadoReserva;
        private boolean pagarAhora;
        private boolean pagado;
        private double costoTotal; 
        private TipoPension tipoPension; 

        //--------------------------------
        //          Constructores:
        //--------------------------------

        public Reserva(LocalDate fechaDeEntrada, LocalDate fechaDeSalida, Cliente cliente, EstadoReserva estadoReserva, boolean pagarAhora, double costoTotal, TipoPension tipoPension) {
            if (fechaDeSalida.isBefore(fechaDeEntrada)) {
                throw new IllegalArgumentException("La fecha de salida no puede ser anterior a la fecha de entrada.");
            }
            this.fechaDeEntrada = fechaDeEntrada;
            this.fechaDeSalida = fechaDeSalida;
            this.cliente = new Cliente(cliente); 
            this.estadoReserva = estadoReserva; 
            this.pagarAhora = pagarAhora;
            this.pagado = pagarAhora; 
            this.costoTotal = costoTotal; 
            this.tipoPension = tipoPension;
        }

        public Reserva (){

             this.fechaDeEntrada = LocalDate.of(2024, 10, 25); 
            this.fechaDeSalida = LocalDate.of(2024, 10, 27);
            this.cliente = new Cliente(); 
            this.estadoReserva = estadoReserva.CONFIRMADA; 
            this.pagarAhora = false; 
            this.pagado = false;
            this.costoTotal = 300; 
            this.tipoPension = TipoPension.SOLO_DESAYUNO; 
        }

        public Reserva(Reserva otraReserva){

             this.fechaDeEntrada = otraReserva.fechaDeEntrada;
            this.fechaDeSalida = otraReserva.fechaDeSalida;
            this.cliente = otraReserva.cliente;
            this.estadoReserva = otraReserva.estadoReserva; 
            this.pagarAhora = otraReserva.pagarAhora;
            this.pagado = otraReserva.pagado; 
            this.costoTotal = otraReserva.costoTotal;
            this.tipoPension = otraReserva.tipoPension; 
        }

 




        //--------------------------------
        //          Setters:
        //--------------------------------

        public void setFechaDeEntrada(LocalDate fechaDeEntrada) {
            if (this.fechaDeSalida != null && fechaDeEntrada.isAfter(this.fechaDeSalida)) {
                throw new IllegalArgumentException("La fecha de entrada no puede ser posterior a la fecha de salida.");
            }
            this.fechaDeEntrada = fechaDeEntrada;
        }

        public void setFechaDeSalida(LocalDate fechaDeSalida) {
            if (fechaDeSalida.isBefore(this.fechaDeEntrada)) {
                throw new IllegalArgumentException("La fecha de salida no puede ser anterior a la fecha de entrada.");
            }
            this.fechaDeSalida = fechaDeSalida; 
        }

        public void setCliente(Cliente cliente) {
            this.cliente = new Cliente(cliente); 
        }

        public void setEstadoReserva(EstadoReserva estadoReserva) {
            this.estadoReserva = estadoReserva; 
        }

        public void setPagarAhora(boolean pagarAhora) {
            this.pagarAhora = pagarAhora; 
        }

        public void setPagado(boolean pagado) {
            this.pagado = pagado; 
        }

        public void setCostoTotal(double costoTotal) {
            this.costoTotal = costoTotal;
        }
        
        public void setTipoPension (TipoPension tipoPension){
            
            this.tipoPension = tipoPension; 
        }

        //--------------------------------
        //          Getters:
        //--------------------------------

        public LocalDate getFechaDeEntrada() {
            return fechaDeEntrada;
        }

        public LocalDate getFechaDeSalida() {
            return fechaDeSalida; 
        }

        public Cliente getCliente() {
            return new Cliente(cliente); 
        }

        public EstadoReserva getEstadoReserva() {
            return estadoReserva; 
        }

        public boolean getPagarAhora() {
            return pagarAhora; 
        }

        public boolean getPagado() {
            return pagado; 
        }

        public double getCostoTotal() {
            return costoTotal;
        }
        
        public TipoPension getTipoPension() {
            
            return tipoPension;
        }

        //--------------------------------
        //          Otros métodos:
        //--------------------------------

        public String mostrarDetalles() {
             return "Reserva para " + cliente.getNombre() + 
               " del " + fechaDeEntrada + " al " + fechaDeSalida + 
               ". Estado: " + estadoReserva + 
               ". Costo total: " + costoTotal + 
               ". Tipo de Pension: " + tipoPension +
               ". Pagada: " + (pagado ? "Sí" : "No");
        }

        public void confirmarReserva() {
            if (estadoReserva != EstadoReserva.PENDIENTE) {
                throw new IllegalStateException("La reserva no esta en estado pendiente.");
            }
            estadoReserva = EstadoReserva.CONFIRMADA;
        }

        public void cancelarReserva() {
            long diasAntesDeEntrada = LocalDate.now().until(fechaDeEntrada, ChronoUnit.DAYS);
            if (diasAntesDeEntrada >= 3) {
                estadoReserva = EstadoReserva.CANCELADA;
                pagado = false; 
                costoTotal = 0; 
                System.out.println("Reserva cancelada sin costo. Se ha reembolsado el dinero.");
            } else {
                System.out.println("Cancelacion tardia. Aplicando penalizacion...");
                aplicarPenalizacion();
            }
        }

        private void aplicarPenalizacion() { 
            double penalizacion = costoTotal * 0.20;
            System.out.println("Cancelacion tardia. Penalizacion aplicada: 20% del total. Importe: " + penalizacion);
            costoTotal -= penalizacion; 
            System.out.println("Se ha devuelto el 80% del monto pagado. Monto restante: " + costoTotal);
        }

        public void pagarReserva() {
            if (!pagado) {
                pagado = true;
                System.out.println("Reserva pagada exitosamente.");
            } else {
                System.out.println("La reserva ya ha sido pagada.");
            }
        }
    }









 
    
    
    
    

