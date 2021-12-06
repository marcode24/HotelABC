package modelos;
import java.time.LocalDate;

public class ReservacionCS {
    private int idReservacion;
    private String nombre;
    private String apellido;
    private int adultos;
    private int ninios;
    private LocalDate llegada;
    private LocalDate salida;
    private int noches;
    private Double total;
    private String estado;
    private int idHabitacion;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    } 
    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }
    public void setNinios(int ninios) {
        this.ninios = ninios;
    }
    public void setLlegada(LocalDate llegada) {
        this.llegada = llegada;
    }
    public void setSalida(LocalDate salida){
        this.salida = salida;
    }
    public void setNoches(int noches) {
        this.noches = noches;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setIdHabitacion(int idHabitacion){
        this.idHabitacion = idHabitacion;
    }
    
    
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    } 
    public int getAdultos() {
        return this.adultos;
    }
    public int getNinios() {
        return this.ninios;
    }
    public LocalDate getLlegada() {
        return this.llegada;
    }
    public LocalDate getSalida(){
        return this.salida;
    }
    public int getNoches() {
        return this.noches;
    }
    public Double getTotal() {
        return this.total;
    }
    public String getEstado() {
        return this.estado;
    }
    public int getIdHabitacion() {
        return this.idHabitacion;
    }
}
