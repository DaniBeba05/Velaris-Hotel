package clases;
import Enums.TipoStaff;
import clases.Reserva;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Staff {

    //--------------------------------
    //          Atributos:
    //--------------------------------
    
    private String nombre; 
    private int idNumber; 
    private TipoStaff tipoStaff; 
    private int maxReservas; 
    private List<Reserva> reservas; 
    
    //--------------------------------
    //          Constructores:
    //--------------------------------

   
    public Staff(String nombre, int idNumber, TipoStaff tipoStaff, int maxReservas) {
        this.nombre = nombre;
        this.idNumber = idNumber;
        this.tipoStaff = tipoStaff;
        this.maxReservas = maxReservas;
        this.reservas = new ArrayList<>(); 
    }
    
   
    public Staff() {
        this.nombre = "Jose Mari"; 
        this.idNumber = 3; 
        this.tipoStaff = TipoStaff.GERENTE;
        this.maxReservas = 5; 
        this.reservas = new ArrayList<>(); 
    }
    
   
    public Staff(Staff otroStaff) {
        this.nombre = otroStaff.nombre; 
        this.idNumber = otroStaff.idNumber; 
        this.tipoStaff = otroStaff.tipoStaff; 
        this.maxReservas = otroStaff.maxReservas; 
        this.reservas = new ArrayList<>(otroStaff.reservas);
    }
    
    //--------------------------------
    //          Setters:
    //--------------------------------
    
    public void setnombre (String nombre){
        
        this.nombre = nombre; 
    }
    
    public void setIDNumber (int idNumber){
        
        this.idNumber = idNumber; 
    }
    
    public void settipostaff (TipoStaff tipoStaff){
        
        this.tipoStaff = tipoStaff; 
    }
    
    public void setnumeromaximoreservas (int maxReservas){
        
        this.maxReservas = maxReservas; 
    }
    
     //--------------------------------
    //          Getters:
    //--------------------------------
    
    public String getnombre (){
        
        return nombre; 
    }
    
    public int getnumeroID(){
        
        return idNumber;
    }
    
    public TipoStaff gettipodeStaff(){
        
        return tipoStaff; 
    }
    
    public int getnumeromaximodereservasquellevaelempleado(){
        
        return maxReservas;
    }
    
      public List<Reserva> getReservas() {
        return new ArrayList<>(reservas); 
    }
    
     //--------------------------------
    //          Otros Metodos:
    //--------------------------------
   
      
 public boolean addReserva(Reserva nuevaReserva) {
    if (reservas.size() < maxReservas) {
        reservas.add(nuevaReserva);
        return true; 
    } else {
        return false; 
    }
}


public boolean removeReserva(Reserva reserva) {
    return reservas.remove(reserva); 
}


public boolean hasReserva(Reserva reserva) {
    return reservas.contains(reserva);
}


public boolean tieneReservas() {
    return !reservas.isEmpty();
}


public boolean maxReservasAlcanzado() {
    return reservas.size() >= maxReservas;
}



public String obtenerResumen() {
    return String.format("Nombre: %s, ID: %d, Tipo: %s, Reservas: %d/%d",
                         nombre, idNumber, tipoStaff, reservas.size(), maxReservas);
}


public int obtenerNumeroDeReservas() {
    return reservas.size();
}


@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Staff other = (Staff) obj;
    return idNumber == other.idNumber;
}


@Override
public int hashCode() {
    return Objects.hash(idNumber);
}



@Override
public String toString() {
    return "Staff{" +
           "nombre='" + nombre + '\'' +
           ", idNumber=" + idNumber +
           ", tipoStaff=" + tipoStaff +
           ", maxReservas=" + maxReservas +
           ", reservas=" + reservas +
           '}';
}

public Staff clonar() {
    return new Staff(this);
}


public void actualizarInfoBasica(String nuevoNombre, int nuevoIdNumber, TipoStaff nuevoTipo) {
    this.nombre = nuevoNombre;
    this.idNumber = nuevoIdNumber;
    this.tipoStaff = nuevoTipo;
}

}
