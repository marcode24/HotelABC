package modelos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Habitacion {
    private int idHabitacion;
    private String nombre;
    private int capacidad;
    private Double precio;
    private String cama;
    private int cantidadCamas;
    private int tamanioHabitacion;
    private String descripcion;
    private int numeroHabitacion;
    private int disponible;
    private File foto;
    private byte[] imagen;
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setCama(String cama) {
        this.cama = cama;
    }
    
    public void setCantidadCamas(int camas) {
        this.cantidadCamas = camas;
    }
    
    public void setTamanioHabitacion(int tamanio) {
        this.tamanioHabitacion = tamanio;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public void setNumeroHabitacion(int numero) {
        this.numeroHabitacion = numero;
    }
    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
    public void setFoto(File foto) {
        this.foto = foto;
    }
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public Double getPrecio() {
        return this.precio;
    }
    
    public String getCama() {
        return this.cama;
    }
    
    public int getCantidadCamas() {
        return this.cantidadCamas;
    }
    
    public int getTamanioHabitacion() {
        return this.tamanioHabitacion;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public int getIdHabitacion(){
        return this.idHabitacion;
    }
    
    public int getNumeroHabitacion() {
        return this.numeroHabitacion;
    }
    
    public int getDisponible() {
        return this.disponible;
    }
    
    public File getFoto() {
        return this.foto;
    }
    
    public BufferedImage getImagen() {
        ByteArrayInputStream bais = new ByteArrayInputStream(imagen);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
