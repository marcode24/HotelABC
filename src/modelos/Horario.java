package modelos;
import java.time.LocalDate;

public class Horario {
    private int idHorario;
    private LocalDate llegada;
    private LocalDate salida;
    private int noches;
    private String estado;
    private Double total;
    private int idHabitacion;
    
    
    public void setLlegada(LocalDate llegada) {
        this.llegada = llegada;
    }
    public void setSalida(LocalDate salida){
        this.salida = salida;
    }
    public void setNoches(int noches) {
        this.noches = noches;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setIdHabitacion(int idHabitacion){
        this.idHabitacion = idHabitacion;
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
    public String getEstado() {
        return this.estado;
    }
    public Double getTotal() {
        return this.total;
    }
    public int getIdHabitacion() {
        return this.idHabitacion;
    }
}
