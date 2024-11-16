package clases;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facturacion {
    
     //--------------------------------
    //          Atributos:
    //--------------------------------
    private Reserva reserva;
    private List<ServicioAdicional> serviciosAdicionales;
    private double costeTotal; 
    private LocalDate fechaFacturacion; 
    private String metodoPago; 
    
     //--------------------------------
    //          Constructores:
    //--------------------------------

    public Facturacion(Reserva reserva, List<ServicioAdicional> serviciosAdicionales, double costeTotal, LocalDate fechaFacturacion, String metodoPago) {
        this.reserva = reserva;
        this.serviciosAdicionales = (serviciosAdicionales != null) ? serviciosAdicionales : new ArrayList<>();
        this.costeTotal = costeTotal;
        this.fechaFacturacion = fechaFacturacion;
        this.metodoPago = metodoPago;
    }
    
  public Facturacion() {
    this.reserva = new Reserva(); // Asegúrate de que Reserva tenga un constructor por defecto
    this.serviciosAdicionales = new ArrayList<>(); // Inicializar como una lista vacía
    this.costeTotal = 0.0;
    this.fechaFacturacion = LocalDate.now(); // Asigna la fecha actual
    this.metodoPago = "No especificado"; // Método de pago por defecto
    calcularCostoTotal(); // Llama al método para calcular el costo total
}

    
    public Facturacion (Facturacion otraFacturacion){
        
        this.reserva = otraFacturacion.reserva; 
        this.serviciosAdicionales = otraFacturacion.serviciosAdicionales; 
        this.costeTotal = otraFacturacion.costeTotal; 
        this.fechaFacturacion = otraFacturacion.fechaFacturacion;
        this.metodoPago = otraFacturacion.metodoPago; 
    }
    
     //--------------------------------
    //          Setters:
    //--------------------------------
    
    

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public void setFechaFacturacion(LocalDate fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    
     //--------------------------------
    //          Getters:
    //--------------------------------
    
    

    public Reserva getReserva() {
        return reserva;
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public LocalDate getFechaFacturacion() {
        return fechaFacturacion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
    
     //--------------------------------
     //        Metodos Adicionales:
     //--------------------------------
    
    
    
    
      private void calcularCostoTotal() {
     
        costeTotal = reserva.getCostoTotal();

        
        for (ServicioAdicional servicio : serviciosAdicionales) {
            costeTotal += servicio.getCoste();
        }
    }

    
    public void mostrarFactura() {
    System.out.println("Depuracion: Iniciando metodo mostrarFactura");
    if (reserva == null) {
        System.out.println("Error: reserva es null");
    }
    if (serviciosAdicionales == null) {
        System.out.println("Error: serviciosAdicionales es null");
    }


        System.out.println("----- Factura -----");
        System.out.println("Fecha de Facturacion: " + fechaFacturacion);
        System.out.println("Reserva: " + reserva.mostrarDetalles());
        System.out.println("Servicios Adicionales:");
        for (ServicioAdicional servicio : serviciosAdicionales) {
            System.out.println("- " + servicio.getNombre() + ": $" + servicio.getCoste());
        }
        System.out.println("Metodo de Pago: " + metodoPago);
        System.out.println("Costo Total: $" + costeTotal);
        System.out.println("-------------------");
    }
    
}
